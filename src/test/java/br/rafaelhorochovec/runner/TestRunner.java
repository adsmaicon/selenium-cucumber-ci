package br.rafaelhorochovec.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/br/rafaelhorochovec/feature", glue = "", tags = "@add", plugin = {
		"pretty", "html:target/report-html",
		"json:target/report.json" }, monochrome = false, dryRun = false, strict = true)

public class TestRunner {

}