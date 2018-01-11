package com.dersuzzala.bandwars.bandmanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by jorge on 11/01/18.
 */
@SpringBootApplication
@ComponentScan("com.dersuzzala.bandwars.bandmanager")
public class BandManagerApp {
    public static void main(String[] args) {
            SpringApplication.run(BandManagerApp.class, args);
    }
}
