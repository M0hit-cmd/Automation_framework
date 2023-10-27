package testCases;

import org.testng.annotations.Test;
import resources.StaticDataProvider;

public class DummyClass {
    @Test( dataProvider = "new_customer",dataProviderClass = StaticDataProvider.class)
    public void testing1(){

    }
}
