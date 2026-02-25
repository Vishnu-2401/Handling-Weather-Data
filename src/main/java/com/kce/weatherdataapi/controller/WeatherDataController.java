package com.kce.weatherdataapi.controller;

import com.kce.weatherdataapi.entity.WeatherDataEntity;
import com.kce.weatherdataapi.service.WeatherDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/weather")
public class WeatherDataController {

    @Autowired
    private WeatherDataService service;

    @PostMapping("/upload")
    public ResponseEntity<String> upload(@RequestParam("file") MultipartFile file) throws Exception {
        service.uploadCSV(file);
        return ResponseEntity.ok("CSV uploaded successfully");
    }

    @GetMapping("/date")
    public List<WeatherDataEntity> getByDate(@RequestParam String date) {
        return service.getByDate(date);
    }

    @GetMapping("/month")
    public List<WeatherDataEntity> getByMonth(@RequestParam String month) {
        return service.getByMonth(month);
    }

    @GetMapping("/stats/{year}")
    public Map<Integer, Map<String, Double>> getStats(@PathVariable int year) {
        return service.getMonthlyStats(year);
    }
}