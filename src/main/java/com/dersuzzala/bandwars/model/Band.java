package com.dersuzzala.bandwars.model;

import java.util.Collection;

/**
 * Created by jorge on 11/01/18.
 */

public class Band {

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
