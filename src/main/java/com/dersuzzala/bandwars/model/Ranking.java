package com.dersuzzala.bandwars.model;

import java.util.List;

public class Ranking {

    private String genre;

    private List<Band> bands;

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public List<Band> getBands() {
        return bands;
    }

    public void setBands(List<Band> bands) {
        this.bands = bands;
    }
}
