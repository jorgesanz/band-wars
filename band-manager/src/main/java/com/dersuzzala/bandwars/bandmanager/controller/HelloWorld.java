package com.dersuzzala.bandwars.bandmanager.controller;

import org.joda.time.LocalTime;

/**
 * Created by jorge on 10/01/18.
 */
public class HelloWorld {
    public static void main(String[] args) {
        LocalTime currentTime = new LocalTime();
        System.out.println("The current local time is: " + currentTime);

        Greeter greeter = new Greeter();
        System.out.println(greeter.sayHello());
    }
}
