package com.spring.restaurant.controller;


import com.spring.restaurant.entity.State;
import com.spring.restaurant.service.StateService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/")
@AllArgsConstructor
public class StateController {

    private StateService stateService;


    @GetMapping("allState")   // api/allState
    public List<State> getAllState() {
        return stateService.getAllState();
    }

    @GetMapping("getStateByCountryCode")  // api/getStateByCountryCode?code=
    public List<State> getStateByCountryCode(@RequestParam String code)
    {
        return stateService.getStateByCountryCode(code);
    }
}

