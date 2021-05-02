package com.medvantx.decoupling.config;

import com.mongodb.MongoClient;
import dev.morphia.Datastore;
import dev.morphia.Morphia;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@AutoConfigureAfter(MongoAutoConfiguration.class)
@EnableConfigurationProperties(MongoProperties.class)
public class DataSourceConfig {
    @Bean
    public Datastore datastore() {
        Morphia morphia = new Morphia();
        morphia.mapPackage("com.medvantx.decoupling");
        Datastore datastore = morphia.createDatastore(new MongoClient(), "medvantx_test_db");
        datastore.ensureIndexes();
        return datastore;
    }

}
