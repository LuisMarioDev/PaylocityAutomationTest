package Utilities;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class AllureSetup {

    public static void setupExecutor() throws IOException {
        Map<String, Object> executor = Map.of(
                "name", "Ecommerce Testing",
                "reportUrl", "https://example.com/build/1/report",
                "buildName", "Web testing Luis Navarro",
                "buildOrder", 1,
                "reportName", "Luis Navarro",
                "type", "web",
                "url", "www.ae.com/us/en",
                "buildTime", java.time.ZonedDateTime.now().toString()
        );

        File executorFile = new File("target/allure-results/executor.json");
        ObjectMapper mapper = new ObjectMapper();
        try (FileWriter writer = new FileWriter(executorFile)) {
            mapper.writeValue(writer, executor);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void setupHistory() throws IOException {
        File sourceDir = new File("history");
        File targetDir = new File("target/allure-results/history");
        if (sourceDir.exists()) {
            FileUtils.copyDirectory(sourceDir, targetDir);
        }
    }

    public static void saveHistory() throws IOException {
        File sourceDir = new File("target/allure-results/history");
        File targetDir = new File("history");
        if (sourceDir.exists()) {
            FileUtils.copyDirectory(sourceDir, targetDir);
        }
    }

    public static void setupEnvironment() {
        try (FileWriter writer = new FileWriter("target/allure-results/environment.properties")) {
            writer.write("URL=www.ae.com/us/en\n");
            writer.write("Browser=Chrome\n");
            writer.write("Browser.Version=114.0\n");
            writer.write("OS=MAC OS\n");
            writer.write("Tester=Luis Mario Navarro\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void createCategories() {
        String categoriesContent = """
                [
                {
                "name": "Passed Tests",
                "matchedStatuses": ["passed"]
                },
                {
                "name": "Failed Tests",
                "matchedStatuses": ["failed"]
                },
                {
                "name": "Broken Tests",
                "matchedStatuses": ["broken"]
                },
                {
                "name": "Skipped Tests",
                "matchedStatuses": ["skipped"]
                },
                {
                "name": "Product Tests",
                "matchedStatuses": ["passed", "failed", "broken", "skipped"],
                "messageRegex": ".*Product.*"
                }
                ]
                """;

        try (FileWriter writer = new FileWriter("target/allure-results/categories.json")) {
            writer.write(categoriesContent);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}