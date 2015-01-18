package com.paypal;

import static spark.Spark.*;

/**
 * Created by sechandrasekaran on 1/12/15.
 */
/*
Spark is a simple java web framework. For a url, sends out the response.
http://sparkjava.com/
*
 */
public class HelloWorldSparkStyle {
    public static void main(String[] args) {
            //routes /hello to Hello World page
            get("/hello", (req,res)->"Hello World");
            get("/test", (req,res)->"This is a test page");


            get("/hello/:anything", (req, res)-> {
                        return "Hello "+req.params(":anything");
                    }
            );




    }
}
