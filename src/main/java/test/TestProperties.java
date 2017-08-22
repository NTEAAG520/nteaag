package test;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class TestProperties {
    public static void main(String[] args) {
        String url = "D:\\Intellij Project\\src\\djlm\\nteaag\\dao\\jdbc.properties";
        try {
            FileInputStream fileInputStream = new FileInputStream(new File(url));
            Properties properties = new Properties();
            properties.load(fileInputStream);
            System.out.println(properties);
            System.out.println("username:"+properties.getProperty("db.username"));
            System.out.println("password:"+properties.getProperty("db.password"));
            System.out.println("dataBaseName:"+properties.getProperty("db.dataBaseName"));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
