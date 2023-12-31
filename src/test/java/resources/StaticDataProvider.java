package resources;

import net.bytebuddy.utility.RandomString;
import org.testng.annotations.DataProvider;

import java.util.HashMap;

public class StaticDataProvider {
    @DataProvider(name = "customer_data")
    public String[][] customer_data_provider() {
        return new String[][]{{"Mohit", "Male", "06101998", "Address of Mohit", "Faridabad", "Haryana", "121004", "8888688888", randomestring() + "@gmail.com", "ABC@121004"}, {"Rohit", "Male", "07022000", "Address of Rohit", "Mumbai", "Maharashtra", "100902", "9894820999", randomestring() + "@gmail.com", "ABC@121004"}, {"Radha", "Female", "01012001", "Address of Radha", "Delhi", "Delhi", "121005", "8989838582", randomestring() + "@gmail.com", "ABC@121004"}};
    }
    @DataProvider(name="default_customer_data")
    public String[][] default_customer_data(){
        return new String[][]{{"Mohit", "Male", "06101999", "Address of Mohit Singh", "Faridabad", "Haryana", "121004", "9891783765", randomestring() + "@gmail.com", "ABC@121004"}};
    }
    public String randomestring() {
        return RandomString.make(10);
    }


}
