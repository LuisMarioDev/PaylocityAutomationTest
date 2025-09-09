package Suites;
import java.util.List;

public abstract class CucumberTestSuiteRunner {
    // Abstract methods to be implemented by subclasses
    protected abstract List <String> includeFeatures();
    
    protected abstract List <String> excludeFeatures();

    // Method to filter features based on inclusion and exclusion lists
    public List<String> featuresForRunning(List<String> includeFeatures, List<String> excludeFeatures){
        includeFeatures.removeAll(excludeFeatures);
        return includeFeatures;
    }

}
