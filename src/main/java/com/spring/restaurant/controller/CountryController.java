package com.spring.restaurant.controller;

import com.spring.restaurant.entity.Country;
import com.spring.restaurant.service.CountryService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/")
@AllArgsConstructor
public class CountryController {
    private CountryService countryService;


    @GetMapping("allCountry")  // api/allCountry
    public List<Country> getAllCountry()
    {
        return countryService.getAllCountry();
    }

}
