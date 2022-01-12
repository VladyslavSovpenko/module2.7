package ua.service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TemplateHandler {

    final Pattern pattern = Pattern
            .compile("\\{\\{(\\w+)\\}\\}", Pattern.MULTILINE);


    private static TemplateHandler instance;

    private static ClassLoader classLoader = Thread.currentThread().getContextClassLoader();

    private TemplateHandler() {
    }

    public static TemplateHandler getInstance() {
        if (instance == null) {
            instance = new TemplateHandler();
        }
        return instance;
    }

    public String handleTemplate(String templateName, Map<String, String> params) {
        String template = getTemplate(templateName);
        final Matcher matcher = pattern.matcher(template);

        while (matcher.find()) {
            String replacer = params.get(matcher.group(1));
            System.out.println("Full match: " + matcher.group(0));
            template = template.replace(matcher.group(0), replacer == null ? "":replacer);
        }
        return template;
    }


    public String getTemplate(String templateName) {
//        try {
//            InputStream inputStream = new FileInputStream("src/main/resources/" + templateName + ".html");
//            return new String(inputStream.readAllBytes());
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        return "";
    }


}
