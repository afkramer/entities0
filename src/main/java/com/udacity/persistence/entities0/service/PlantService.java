package com.udacity.persistence.entities0.service;

import com.udacity.persistence.entities0.model.Plant;
import com.udacity.persistence.entities0.repository.PlantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class PlantService {
    @Autowired
    PlantRepository plantRepository;

    public Plant getPlantByName(String name){
        return new Plant();
    }

    public Long savePlant(Plant plant){
        return plantRepository.save(plant).getId();
    }

    public boolean delivered(Long id){
        return plantRepository.deliveryCompleted(id);
    }

    public List<Plant> getPlantsCheaperThan(BigDecimal amount){
        return plantRepository.findByPriceLessThan(amount);
    }
}
