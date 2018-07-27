package com.dersuzzala.bandwars.bandmanager.Config;

import com.mongodb.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by jorge on 11/01/18.
 */
@Configuration
@EnableMongoRepositories(basePackages = "com.dersuzzala.bandwars.bandmanager.repository")
public class MongoConfig {

    @Value("${spring.data.mongodb.host}")
    private String mongoLocation;
    @Value("${spring.data.mongodb.database}")
    private String mongoDataBase;


    @Bean
    public MongoDbFactory mongoDbFactory() throws Exception {
        List<ServerAddress> serverAddressList = mongoServerAddresses(mongoLocation.split(","));
        MongoClient mongoClient = mongoClientMethod(serverAddressList);

        return new SimpleMongoDbFactory(mongoClient, mongoDataBase);
    }

    @Bean
    public MongoTemplate mongoTemplate() throws Exception {
        return new MongoTemplate(mongoDbFactory());
    }

    private List<ServerAddress> mongoServerAddresses(String[] locations) {

        List<ServerAddress> serverAddressList = new ArrayList<>();

        for (String location : locations) {
            String[] hostAndPort = location.split(":");
            if (hostAndPort.length == 2) {
                String host = hostAndPort[0];
                int port = Integer.parseInt(hostAndPort[1]);
                ServerAddress serverAddress = new ServerAddress(host, port);
                serverAddressList.add(serverAddress);
            }
        }
        return serverAddressList;
    }

    private MongoClient mongoClientMethod(List<ServerAddress> serverAddressList) {

        MongoClientOptions options = MongoClientOptions.builder()
                .socketTimeout(1500)
                .minHeartbeatFrequency(25)
                .heartbeatSocketTimeout(1500)
                .connectTimeout(1500)
                .socketKeepAlive(true)
                .threadsAllowedToBlockForConnectionMultiplier(5)
                .writeConcern(new WriteConcern(1))
                .build();

       return new MongoClient(serverAddressList, options);

    }
}
