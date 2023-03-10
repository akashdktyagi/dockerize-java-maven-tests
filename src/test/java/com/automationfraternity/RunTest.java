package com.automationfraternity;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@CucumberOptions(
        features = {
                "classpath:features"
        },
        glue = {
                "com.automationfraternity"
        },
        tags = "",
        plugin = {"pretty",
                "html:target/cucumber-reports/cucumber.html",
                "json:target/cucumber-reports/cucumber.json"
        }
)
@RunWith(Cucumber.class)
public class RunTest {

}

//@CucumberOptions(
//        features = {
//                "classpath:features"
//        },
//        glue = {
//                "com.automationfraternity"
//        },
//        tags = "",
//        plugin = {"pretty",
//                "html:target/cucumber-reports/cucumber.html",
//                "json:target/cucumber-reports/cucumber.json"
//        }
//)
//public class RunTest extends AbstractTestNGCucumberTests {
//    @Override
//    @DataProvider(parallel = true)
//    public Object[][] scenarios() {
//        return super.scenarios();
//    }
//}