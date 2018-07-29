package com.dersuzzala.bandwars.bandmanager.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Collection;

/**
 * Created by jorge on 11/01/18.
 */
@Document(collection = "bands")
public class Band {

    @Id
    private String id;

    private String name;
    Collection<String> genres;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<String> getGenres() {
        return genres;
    }

    public void setGenres(Collection<String> genres) {
        this.genres = genres;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
