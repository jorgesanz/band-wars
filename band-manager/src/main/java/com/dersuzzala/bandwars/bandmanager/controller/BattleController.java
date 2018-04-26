package com.dersuzzala.bandwars.bandmanager.controller;

import com.dersuzzala.bandwars.bandmanager.model.Battle;
import com.dersuzzala.bandwars.bandmanager.service.BattleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/battle")
public class BattleController {

    @Autowired
    private BattleService battleService;

    @GetMapping
    public Battle getBattle(){
        return battleService.getBattle();
    }

}
