package com.dersuzzala.bandwars.bandmanager.controller;

import com.dersuzzala.bandwars.bandmanager.model.Band;
import com.dersuzzala.bandwars.bandmanager.service.BandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * Created by jorge on 11/01/18.
 */
@RestController
@RequestMapping(value = "/band")
public class BandController {

    @Autowired
    private BandService bandService;

    @GetMapping
    public Collection<Band> getBands() {
        return bandService.findAll();
    }

    @PostMapping
    public Band addBand(@RequestBody Band band) {
        Band ohDiarrea = new Band();
        band.setName("Oh! diarrea");
        //TODO call real service
        //return bandService.create(band);
    }
}
