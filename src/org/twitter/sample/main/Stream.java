/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.twitter.sample.main;

import org.apache.commons.logging.Log;
import org.twitter.sample.db.MongoDBHandler;
import twitter4j.FilterQuery;
import twitter4j.StallWarning;
import twitter4j.Status;
import twitter4j.StatusDeletionNotice;
import twitter4j.StatusListener;
import twitter4j.TwitterException;
import twitter4j.TwitterStream;
import twitter4j.TwitterStreamFactory;
import twitter4j.conf.ConfigurationBuilder;


/**
 *
 * @author jBrunn
 */
public class Stream {

    private static final String consumer_key = "";
    private static final String consumer_secret = "";
    private static final String access_token = "";
    private static final String access_token_secret = "";
    
    private static Log log; // Reference to the Default Logger 
    private TwitterStream twitterStream; // Connection to Twitter
    private MongoDBHandler db; // DB-Access Layer
    private String[] keywords = new String[0]; // List of Current Keywords
    
    private void open() throws TwitterException {
	
        // Setup the Streaming
        this.db = new MongoDBHandler();
        
        // Begin Crawling
        getTweetsFromTwitter();

    }
    
    
    /*
     * Main method.
     *
     * @param args
     * @throws TwitterException
     */
    public void getTweetsFromTwitter() {

        StatusListener listener = new StatusListener() {
            private boolean logQueueFull = true;

            @Override
            public void onException(Exception e) {
                log.error(e);
            }

            @Override
            public void onDeletionNotice(StatusDeletionNotice notice) {
            }

            @Override
            public void onScrubGeo(long arg0, long arg1) {
            }

            @Override
            public void onStatus(Status status) {
                db.insert(status);
            }
            
            @Override
            public void onTrackLimitationNotice(int notice) {
                log.warn("*** TRACK LIMITATION REACHED: " + notice + " ***");
            }

            @Override
            public void onStallWarning(StallWarning arg0) {
                log.warn("*** STALL WARNING: " + arg0);
            }
        };

        ConfigurationBuilder twitterConfig = new ConfigurationBuilder();
        twitterConfig.setDebugEnabled(false);
        twitterConfig.setOAuthAccessTokenSecret(access_token_secret);
        twitterConfig.setOAuthAccessToken(access_token);
        twitterConfig.setOAuthConsumerKey(consumer_key);
        twitterConfig.setOAuthConsumerSecret(consumer_secret);
        twitterConfig.setJSONStoreEnabled(true);

        TwitterStreamFactory fact = new TwitterStreamFactory(twitterConfig.build());
        this.twitterStream = fact.getInstance();
        this.twitterStream.addListener(listener);
        FilterQuery filterQuery = new FilterQuery();
        filterQuery.language(new String[]{"en"});
        this.twitterStream.filter(filterQuery);
        this.twitterStream.sample();

    }

     public static void main(String[] args) throws TwitterException {
        Stream stream = new Stream();
        stream.open();
    }
}
