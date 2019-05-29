package web

import org.junit.runner.RunWith

import cucumber.api.CucumberOptions
import cucumber.api.junit.Cucumber

@RunWith(Cucumber.class)
@CucumberOptions(
        features = ['src/test/resources/features/'],
        glue = ["classpath:steps", "classpath:env"],
        plugin = ["pretty",
                  "usage:build/report/usage.json",
                  "html:build/report",
                  "json:build/report/cucumber.json"])
class CukesRunner {
}