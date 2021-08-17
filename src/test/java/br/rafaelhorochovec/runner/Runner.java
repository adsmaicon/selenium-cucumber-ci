package br.rafaelhorochovec.runner;

import io.cucumber.junit.CucumberOptions;

@CucumberOptions(
		features = "src/test/resources/br/rafaelhorochovec/feature/", 
		glue = "steps", 
		tags = "@add",
		plugin = { "pretty", "html:target/report-html","json:target/report.json" }, 
		monochrome = false, 
		dryRun = false, 
		strict = false)

public class Runner {
	
}