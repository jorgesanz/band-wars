package com.dersuzzala.bandwars.bandmanager.repository;

import com.dersuzzala.bandwars.bandmanager.model.Band;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by jorge on 11/01/18.
 */
@Repository
public interface BandRepository extends CrudRepository<Band, String> {

    List<Band> findAll();
}
