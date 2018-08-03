package com.dersuzzala.bandwars.service;

import com.dersuzzala.bandwars.model.Band;
import com.dersuzzala.bandwars.model.Battle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BattleService {
    @Autowired
    private BandService bandService;

    public Battle getBattle() {

        List<Band> bands = bandService.findAll();
        Map<String, Set<String>> genres = new HashMap<>();
        for (Band band : bands) {
            //TODO lambda expression
            for (String genre : band.getGenres()) {
                if (!genres.containsKey(genre)) {
                    genres.put(genre, new HashSet<>());
                }
                genres.get(genre).add(band.getName());
            }
        }
        List<String> nonUniqueGenres = new ArrayList<>();
        for (Map.Entry<String, Set<String>> entry : genres.entrySet()) {
            if (entry.getValue().size() > 1) {
                nonUniqueGenres.add(entry.getKey());
            }
        }
        Random random = new Random();
        String genre = nonUniqueGenres.get(random.nextInt(nonUniqueGenres.size()));
        Set<String> selectedBands = genres.get(genre);
        String band1 = randomBand(selectedBands);
        selectedBands.remove(band1);
        String band2 = randomBand(selectedBands);
        Battle battle = new Battle();
        battle.setGenre(genre);
        Set<String> bandsOfbattle = new HashSet<>();
        bandsOfbattle.add(band1);
        bandsOfbattle.add(band2);
        battle.setBands(bandsOfbattle);
        return battle;
    }

    public String randomBand(Set<String> bands) {
        int item = new Random().nextInt(bands.size()); // In real life, the Random object should be rather more shared than this
        int i = 0;
        for (String band : bands) {
            if (i == item)
                return band;
            i++;
        }
        return null;
    }
}
