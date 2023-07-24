package testrunner;

import com.intuit.karate.junit5.Karate;

public class TestRunner {

    String project_path=System.getProperty("user.dir").toString();
    @Karate.Test
    Karate PetE2E() {
        return Karate.run(project_path+"\\src\\test\\Featurefile\\Pet_E2E_Excel.feature");
    }
}
