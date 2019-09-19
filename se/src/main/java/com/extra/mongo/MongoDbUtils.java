package com.extra.mongo;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

class MongoDbUtils {

    private static final String MONGO_PROTOCOL_PREFIX="mongodb://";

    private static Properties loadProperties() throws IOException {
        ClassLoader classLoader = MongoDbUtils.class.getClassLoader();
        URL url = classLoader.getResource("mongo.properties");
        Properties properties = new Properties();
        properties.load(new FileInputStream(url.getFile()));
        return properties;
    }

    private static String getURI(String host, String port){
        return MONGO_PROTOCOL_PREFIX + host + ":" + port;
    }

    static MongoClient getMongoClient() throws IOException {
        Properties properties = loadProperties();
        String host = properties.getProperty("mongodb.host");
        String port = properties.getProperty("mongodb.port");
        return MongoClients.create(getURI(host,port));
    }

}
