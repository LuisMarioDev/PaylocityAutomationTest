package Suites;

import java.util.Arrays;
import java.util.List;

public class SmokeSuite extends CucumberTestSuiteRunner{

    public List<String> includeFeatures(){
        //Lista de features especificas para el Smoke Suite
        return Arrays.asList(
                "src/test/resources/ecommerce_test.feature"
        );
    }

    public List<String> excludeFeatures(){
        //Lista de features especificas para excluir del Smoke Suite
        return null;
    }
}