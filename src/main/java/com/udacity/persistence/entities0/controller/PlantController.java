package com.udacity.persistence.entities0.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.udacity.persistence.entities0.DTO.PlantDTO;
import com.udacity.persistence.entities0.DTO.Views;
import com.udacity.persistence.entities0.model.Plant;
import com.udacity.persistence.entities0.service.PlantService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/plant")
public class PlantController {
    @Autowired
    private PlantService plantService;

    /* code for DTO and JsonView stuff
    public PlantDTO getPlantDTO(String name){
        return convertPlantToPlantDTO(plantService.getPlantByName(name));
    }

    @JsonView(Views.Public.class)
    public Plant getFilteredPlant(String name){
        return plantService.getPlantByName(name);
    }

    private PlantDTO convertPlantToPlantDTO(Plant plant){
        PlantDTO plantDTO = new PlantDTO();
        BeanUtils.copyProperties(plant, plantDTO);
        return plantDTO;
    }
     */

    @GetMapping("/delivered/{id}")
    public Boolean delivered(@PathVariable Long id){
        return plantService.delivered(id);
    }

    @GetMapping("/under-price/{price}")
    @JsonView(Views.Public.class)
    public List<Plant> plantsCheaperThan(@PathVariable BigDecimal price){
        return plantService.getPlantsCheaperThan(price);
    }
}
