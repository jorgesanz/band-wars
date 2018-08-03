package com.dersuzzala.bandwars.model;

import java.util.Collection;

public class Battle {

    private String genre;

    private Collection<String> bands;

    public Collection<String> getBands() {
        return bands;
    }

    public void setBands(Collection<String> bands) {
        this.bands = bands;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
