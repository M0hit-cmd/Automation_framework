package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadConfig {
    Properties prop;
    public  ReadConfig(){
       try{
           InputStream in=new FileInputStream("C:\\Users\\Mohit Gupta\\Documents\\12 Oct\\Framework_project\\Configurations\\config.properties");
           prop=new Properties();
           prop.load(in);
       }
       catch (Exception exp)
       {
           System.out.println(exp.getMessage());
       }
    }
    public String getUrl(){
        return prop.getProperty("baseUrl");
    }
    public String getUserName(){
        return prop.getProperty("userName");
    }
    public String getPassword(){
        return prop.getProperty("password");
    }
    public String getCust_id() {
        return prop.getProperty("customer_id");
    }

}
