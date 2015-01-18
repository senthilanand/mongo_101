package com.paypal;

import freemarker.template.Configuration;
import freemarker.template.Template;

import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;

import static spark.Spark.*;

/**
 * Created by sechandrasekaran on 1/14/15.
 */
public class HelloWorldSparkFreeMarkerStyle {
    public static void main(String[] args) {

        Configuration configuration = new Configuration();
        configuration.setClassForTemplateLoading(HelloWorldFreeMarkerStyle.class, "/");

        try {
            Template helloTemplate = configuration.getTemplate("hello.ftl");
            StringWriter writer = new StringWriter();
            Map<String, Object> helloMap = new HashMap<String, Object>();
            helloMap.put("name", "Senthil");
            helloTemplate.process(helloMap, writer);
            get("/hello", (req, res) -> writer);

            Map<String,Object> fruitsMap = new HashMap<String, Object>();
            fruitsMap.put("fruits", Arrays.asList("apple", "orange", "peach"));
            Template fruitTemplate = configuration.getTemplate("form.ftl");
            StringWriter writer_form = new StringWriter();
            fruitTemplate.process(fruitsMap, writer_form);
            get("/form", (req,res)->writer_form);

            post("/favorite_fruit", (req,res)->{
                    return "You have chosen: "+req.queryParams("fruit");
                    }
            );


        }
        catch (Exception e) {
            System.out.println(e.toString());
        }


    }
}
