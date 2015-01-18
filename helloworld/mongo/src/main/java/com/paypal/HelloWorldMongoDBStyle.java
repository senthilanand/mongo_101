package com.paypal;
import com.mongodb.*;

import java.net.UnknownHostException;

/**
 * Hello world!
 *
 */
public class HelloWorldMongoDBStyle
{
    public static void main( String[] args ) throws UnknownHostException
    {
        MongoClient client = new MongoClient(new ServerAddress("localhost", 27017));
        DB database = client.getDB("test");
        DBCollection collection = database.getCollection("names");
        DBObject document = collection.findOne();
        System.out.println(document.toString());
    }
}
