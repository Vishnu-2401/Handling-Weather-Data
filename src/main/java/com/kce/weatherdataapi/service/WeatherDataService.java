package com.kce.weatherdataapi.service;

import com.kce.weatherdataapi.entity.WeatherDataEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

public interface WeatherDataService {

    void uploadCSV(MultipartFile file) throws Exception;

    List<WeatherDataEntity> getByDate(String date);

    List<WeatherDataEntity> getByMonth(String month);

    Map<Integer, Map<String, Double>> getMonthlyStats(int year);
}