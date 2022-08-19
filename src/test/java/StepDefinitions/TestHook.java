package StepDefinitions;

import cucumber.TestContext;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class TestHook {
    TestContext testContext;

    public TestHook(TestContext context) {
        testContext = context;
    }

    @Before
    public void BeforeSteps() {
		/*What all you can perform here
			Starting a webdriver
			Setting up DB connections
			Setting up test data
			Setting up browser cookies
			Navigating to certain page
			or anything before the test
		*/
    }

    @After
    public void AfterSteps() {
        testContext.getWebDriverManager().closeDriver();
    }
}
