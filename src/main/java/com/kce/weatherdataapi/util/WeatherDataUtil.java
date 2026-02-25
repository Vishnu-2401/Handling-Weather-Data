package com.kce.weatherdataapi.util;

import com.kce.weatherdataapi.entity.WeatherDataEntity;
import com.opencsv.CSVReader;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@Component
public class WeatherDataUtil {

    public List<WeatherDataEntity> parseCSV(MultipartFile file) throws Exception {

        List<WeatherDataEntity> list = new ArrayList<>();

        CSVReader reader = new CSVReader(new InputStreamReader(file.getInputStream()));
        String[] line;

        reader.readNext(); // skip header

        while ((line = reader.readNext()) != null) {

            WeatherDataEntity data = new WeatherDataEntity();

            String rawDate = line[0].substring(0, 8);

            String formattedDate =
                    rawDate.substring(0,4) + "-" +
                    rawDate.substring(4,6) + "-" +
                    rawDate.substring(6,8);

            data.setDate(formattedDate);
            data.setConds(getValue(line, 1));
            data.setDewptm(getValue(line, 2));
            data.setFog(getValue(line, 3));
            data.setHail(getValue(line, 4));
            data.setHeatindexm(getValue(line, 5));
            data.setHum(getValue(line, 6));
            data.setPrecipm(getValue(line, 7));
            data.setPressurm(getValue(line, 8));
            data.setRain(getValue(line, 9));
            data.setSnow(getValue(line, 10));
            data.setTempm(getValue(line, 11));
            data.setThunder(getValue(line, 12));
            data.setTornado(getValue(line, 13));
            data.setVism(getValue(line, 14));
            data.setWdird(getValue(line, 15));
            data.setWdire(getValue(line, 16));
            data.setWgustm(getValue(line, 17));
            data.setWindchillm(getValue(line, 18));
            data.setWspdm(getValue(line, 19));

            list.add(data);
        }

        return list;
    }

    private String getValue(String[] line, int index) {
        if (index >= line.length) return null;
        return line[index] == null || line[index].isBlank() ? null : line[index];
    }
}