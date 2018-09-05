package com.evil.mongodb;

import com.mongodb.client.*;
import org.bson.Document;

import java.util.Arrays;

/**
 * @author qinhu
 * @date 2018-09-05
 */
public class MongoClientDemo {
    public static void main(String[] args) {
        MongoClient mongoClient = MongoClients.create("mongodb://root:root@192.168.0.102:27017/?authSource=admin&&authMechanism=SCRAM-SHA-256");
        MongoDatabase database = mongoClient.getDatabase("testdb");
        MongoCollection<Document> collection = database.getCollection("member");
        Document doc = new Document("name", "MongoDB")
                .append("type", "database")
                .append("count", 1)
                .append("versions", Arrays.asList("v3.2", "v3.0", "v2.6"))
                .append("info", new Document("x", 203).append("y", 102));
        collection.insertOne(doc);
        System.out.println(collection.find().first().toJson());
        mongoClient.close();

    }
}
