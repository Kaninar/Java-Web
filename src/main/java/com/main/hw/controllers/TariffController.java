package com.main.hw.controllers;


import com.main.hw.models.Person;
import com.main.hw.models.Tariff;
import com.main.hw.services.PersonService;
import com.main.hw.services.TariffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api/tariffs")
public class TariffController
{
    private final TariffService tariffService;

    @Autowired
    public TariffController(TariffService tariffService) {
        this.tariffService = tariffService;
    }

    @GetMapping
    public List<Tariff> getPersons()
    {
        var list = tariffService.findAll();
        Collections.sort(list);
        return list;
    }
}
