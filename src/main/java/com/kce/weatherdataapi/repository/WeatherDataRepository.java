package com.kce.weatherdataapi.repository;

import com.kce.weatherdataapi.entity.WeatherDataEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface WeatherDataRepository extends MongoRepository<WeatherDataEntity, String> {

    List<WeatherDataEntity> findByDate(String date);

}