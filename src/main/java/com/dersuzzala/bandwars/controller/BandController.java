package com.dersuzzala.bandwars.controller;

import com.dersuzzala.bandwars.model.Band;
import com.dersuzzala.bandwars.service.BandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by jorge on 11/01/18.
 */
@RestController
@RequestMapping(value = "/band")
public class BandController {

    @Autowired
    private BandService bandService;

    @GetMapping
    public String getBands() {
        return "Oh! diarrea";
       // return bandService.findAll();
    }

    @PostMapping
    public Band addBand(@RequestBody Band band) {
        Band ohDiarrea = new Band();
        band.setName("Oh! diarrea");
        return band;
        //TODO call real service
        //return bandService.create(band);
    }
}
