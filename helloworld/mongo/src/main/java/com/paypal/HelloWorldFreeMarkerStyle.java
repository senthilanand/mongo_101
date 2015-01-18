package com.paypal;

import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;
import freemarker.template.Configuration;
import freemarker.template.Template;
/**
 * Created by sechandrasekaran on 1/13/15.
 */

/*
FreeMarker is a java open source templating engine. It takes a template file, a map, and at run time fills
in the variables in the template with map key value, just like python django template engine
http://freemarker.org/docs/index.html
*/
public class HelloWorldFreeMarkerStyle {
    public static void main (String[] args) {
        Configuration configuration = new Configuration();
        configuration.setClassForTemplateLoading(HelloWorldFreeMarkerStyle.class, "/");

        try {
            Template helloTemplate = configuration.getTemplate("hello.ftl");
            StringWriter writer = new StringWriter();
            Map<String, Object> helloMap = new HashMap<String, Object>();
            helloMap.put("name", "HelloFreeMarker");
            helloTemplate.process(helloMap, writer);
            System.out.println(writer);
        }
        catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}
