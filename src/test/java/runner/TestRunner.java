package runner;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.CucumberOptions.SnippetType;

@CucumberOptions(features = {"src/test/resources/feature/"}, 
			tags = "@Run",
			glue = {"step_defination", "hooks_class" },
			snippets=SnippetType.CAMELCASE,
			dryRun =   !true,
			monochrome=true,
			plugin = { "pretty",
					
					"html:target/cucumber/report.html/",
					
					"json:target/cucumber/report.json",
					"json:target/cucumber/report.xml",
					"timeline:target/cucumber" ,
					"rerun:target/failedSecnarios.txt",
					"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" })

public class TestRunner extends AbstractTestNGCucumberTests {

	@Override
	@DataProvider(parallel = false)
	public Object[][] scenarios() {
		return super.scenarios();
	}

	

}
