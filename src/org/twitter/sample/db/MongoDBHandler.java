/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.twitter.sample.db;


import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;
import java.net.UnknownHostException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mongodb.morphia.Morphia;
import twitter4j.Status;

/**
 * This class contains all the methods related to inserting/deletion/updating
 * data into mongoDB
 *
 * @author pramodkoneru549
 *
 */
public class MongoDBHandler {

    private static final MongoClient CLIENT;
    private static final Log LOG = LogFactory.getLog(MongoDBHandler.class);
    private DBCollection documentCollection;
    public static final DB DB;
    private Morphia morphia;
    static {
        String host = "127.0.0.1";
        String dbname = "twitter_sample";
        try {
            CLIENT = new MongoClient(new ServerAddress(host));
            DB = CLIENT.getDB(dbname);
        } catch (UnknownHostException ex) {
            throw new RuntimeException(ex);
        }
    }
    /**
     * Initiate the connection
     */
    public MongoDBHandler() {
        
        documentCollection = MongoDBHandler.DB.getCollection("tweets");

        // Setup Morphia for easy Java Object -> MongoDB Object transformations
        morphia = new Morphia();
        morphia.mapPackage("org.knoesis.twitris.models");

    }

    public void insert(Status tweet) {
        try {
            DBObject mongoObject = morphia.toDBObject(tweet);
            documentCollection.insert(mongoObject);
        } catch (Exception e) {
            LOG.error("Error in inserting data in mongo db:-" + e.getMessage());
        }
    }

    public static void main(String[] args) {
        MongoDBHandler testHandler = new MongoDBHandler();
    }
}
