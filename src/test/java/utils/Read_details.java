package utils;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class Read_details {
    Properties prop;
    public  Read_details(){
        try{
            InputStream in=new FileInputStream("C:\\Users\\Mohit Gupta\\Documents\\12 Oct\\Framework_project\\src\\test\\java\\utils\\customerdetails.properties");
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
        return prop.getProperty("cust_id");
    }
    public String getAccount_no(){return prop.getProperty("account_id");}
    public String initial_ammount(){return prop.getProperty("intial_amount");}
    public String deposit_amount(){return prop.getProperty("deposit_amount");}
    public void cleanUpProp(){
        prop.clear();
    }
}
