package com.extra.mongo;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.junit.Test;

import java.io.IOException;
import java.util.Objects;

public class MongoTest {

    @Test
    public void demo1() throws IOException {
        MongoClient mongoClient = MongoDbUtils.getMongoClient();
        MongoDatabase admin = mongoClient.getDatabase("admin");
        MongoCollection<Document> users = admin.getCollection("users");
        System.out.println(users.countDocuments());
        Document first = users.find().first();
        System.out.println(Objects.requireNonNull(first).toJson());
    }

}
