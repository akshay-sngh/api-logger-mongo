package edu.cmu.akshaysi.project4task0service.model;

import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.json.JSONObject;

import java.time.Duration;
import java.time.Instant;

import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

public class CovidInfoStore {
    CodecRegistry pojoCodecRegistry;
    private static final String URI = "mongodb+srv://akshaysi:akshaysi@clusterzipcode.b3xic.mongodb.net/myFirstDatabase?retryWrites=true&w=majority";

    public CovidInfoStore() {
        pojoCodecRegistry = fromRegistries(MongoClientSettings.getDefaultCodecRegistry(),
                fromProviders(PojoCodecProvider.builder().automatic(true).build()));
    }

    public void insertCovidInfo(JSONObject result) {
        try (MongoClient mongoClient = MongoClients.create(URI)) {
            MongoDatabase database = mongoClient.getDatabase("covid_db");
            database = database.withCodecRegistry(pojoCodecRegistry);
            MongoCollection<JSONObject> collection = database.getCollection("locations_would_attend", JSONObject.class);
            collection.insertOne(result);
            System.out.println("Complete contents of the database are:");
            System.out.println(result);
            insertCovidLogs(result);
        }
    }

    public void insertCovidLogs(JSONObject result) {
        Instant responseTime = Instant.now();
        final Instant requestTime = Instant.parse(result.getString("timeStamp"));

        try (MongoClient mongoClient = MongoClients.create(URI)) {
            MongoDatabase database = mongoClient.getDatabase("covid_db");
            database = database.withCodecRegistry(pojoCodecRegistry);
            MongoCollection<JSONObject> collection = database.getCollection("logs", JSONObject.class);
            JSONObject log = new JSONObject();
            for (String key : result.keySet()) {
                if (!key.equals("response")) {
                    log.put(key, result.get(key));
                }
            }
            log.put("requestTime", requestTime);
            log.put("responseTime", responseTime);
            log.put("serviceLatencyInMS",Duration.between(requestTime, responseTime).toMillis());
            collection.insertOne(log);
            System.out.println(log);
        }
    }
}
