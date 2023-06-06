package com.prasad;

import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.requests.GatewayIntent;

public class Main {

    public static void main(String[] args) {
        JDABuilder jdaBuilder = JDABuilder.createDefault("Sample Token");
        jdaBuilder.addEventListeners(new ScoldingBot()).enableIntents(GatewayIntent.MESSAGE_CONTENT).build();

        System.out.println("Hello world!");
    }

}