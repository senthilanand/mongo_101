package com.paypal;

import com.mongodb.*;
import freemarker.template.Configuration;
import freemarker.template.Template;

import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import static spark.Spark.get;

/**
 * Created by sechandrasekaran on 1/14/15.
 */
public class HelloWorldMongoDBSparkFreeMarkerStyle {
    public static void main(String[] args) {

        Configuration configuration = new Configuration();
        configuration.setClassForTemplateLoading(HelloWorldFreeMarkerStyle.class, "/");

        try {
            Template helloTemplate = configuration.getTemplate("hello.ftl");
            StringWriter writer = new StringWriter();

            MongoClient client = new MongoClient(new ServerAddress("localhost", 27017));
            DB database = client.getDB("test");
            DBCollection collection = database.getCollection("names");
            DBObject document = collection.findOne();

//            Map<String, Object> helloMap = new HashMap<String, Object>();
//            helloMap.put("name", "Senthil");
            helloTemplate.process(document, writer);
            get("/hello1", (req, res) -> writer);
        }
        catch (Exception e) {
            System.out.println(e.toString());
        }


    }
}
