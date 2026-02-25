package com.kce.weatherdataapi.service.impl;

import com.kce.weatherdataapi.entity.WeatherDataEntity;
import com.kce.weatherdataapi.repository.WeatherDataRepository;
import com.kce.weatherdataapi.service.WeatherDataService;
import com.opencsv.CSVReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class WeatherDataServiceImpl implements WeatherDataService {

    @Autowired
    private WeatherDataRepository repository;

    @Override
    public void uploadCSV(MultipartFile file) throws Exception {

        List<WeatherDataEntity> list = new ArrayList<>();

        CSVReader reader = new CSVReader(new InputStreamReader(file.getInputStream()));
        String[] line;
        reader.readNext();

        while ((line = reader.readNext()) != null) {

            WeatherDataEntity data = new WeatherDataEntity();

            data.setDate(line[0]);
            data.setConds(line[1]);
            data.setDewptm(line[2]);
            data.setFog(line[3]);
            data.setHail(line[4]);
            data.setHeatindexm(line[5]);
            data.setHum(line[6]);
            data.setPrecipm(line[7]);
            data.setPressurm(line[8]);
            data.setRain(line[9]);
            data.setSnow(line[10]);
            data.setTempm(line[11]);
            data.setThunder(line[12]);
            data.setTornado(line[13]);
            data.setVism(line[14]);
            data.setWdird(line[15]);
            data.setWdire(line[16]);
            data.setWgustm(line[17]);
            data.setWindchillm(line[18]);
            data.setWspdm(line[19]);

            list.add(data);
        }

        repository.saveAll(list);
    }

    @Override
    public List<WeatherDataEntity> getByDate(String date) {
        return repository.findByDate(date);
    }

    @Override
    public List<WeatherDataEntity> getByMonth(String month) {

        return repository.findAll()
                .stream()
                .filter(d -> d.getDate().substring(5,7).equals(month))
                .collect(Collectors.toList());
    }

    @Override
    public Map<Integer, Map<String, Double>> getMonthlyStats(int year) {

        List<WeatherDataEntity> filtered = repository.findAll()
                .stream()
                .filter(d -> d.getDate().startsWith(String.valueOf(year)))
                .collect(Collectors.toList());

        Map<Integer, Map<String, Double>> result = new HashMap<>();

        for (int month = 1; month <= 12; month++) {

            String monthStr = String.format("%02d", month);

            List<Double> temps = filtered.stream()
                    .filter(d -> d.getDate().substring(5,7).equals(monthStr))
                    .map(d -> {
                        try {
                            return Double.parseDouble(d.getTempm());
                        } catch (Exception e) {
                            return null;
                        }
                    })
                    .filter(Objects::nonNull)
                    .sorted()
                    .toList();

            if (!temps.isEmpty()) {

                double min = temps.get(0);
                double max = temps.get(temps.size() - 1);

                double median;
                int size = temps.size();

                if (size % 2 == 0)
                    median = (temps.get(size/2 - 1) + temps.get(size/2)) / 2;
                else
                    median = temps.get(size/2);

                Map<String, Double> stats = new HashMap<>();
                stats.put("min", min);
                stats.put("max", max);
                stats.put("median", median);

                result.put(month, stats);
            }
        }

        return result;
    }
}