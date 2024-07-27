package br.com.serratec.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.serratec.dto.FoodRequestDto;
import br.com.serratec.dto.FoodResponseDTO;
import br.com.serratec.entity.Food;
import br.com.serratec.repository.FoodRepository;

@RestController
@RequestMapping("food")
public class FoodController {

    @Autowired
    private FoodRepository repository;
    

    @PostMapping
    public void saveFood(@RequestBody FoodRequestDto data) {
    	Food foodData = new Food(data);
    	repository.save(foodData);
    	
    }



    @GetMapping
    public List<FoodResponseDTO> getAll() {
        List<FoodResponseDTO> foodList = repository.findAll().stream()
            .map(food -> new FoodResponseDTO(food))
            .collect(Collectors.toList());
        return foodList;
    }

}
