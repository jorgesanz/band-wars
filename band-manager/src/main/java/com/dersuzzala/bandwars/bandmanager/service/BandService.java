package com.dersuzzala.bandwars.bandmanager.service;

import com.dersuzzala.bandwars.bandmanager.model.Band;
import com.dersuzzala.bandwars.bandmanager.repository.BandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by jorge on 11/01/18.
 */

@Service
public class BandService {

    @Autowired
    private BandRepository bandRepository;

    public Band create(Band band) {
        return bandRepository.save(band);
    }

    public List<Band> findAll() {
        return bandRepository.findAll();
    }
}
