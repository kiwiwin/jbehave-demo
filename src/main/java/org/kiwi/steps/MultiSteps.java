package org.kiwi.steps;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MultiSteps {
    private int a;
    private int b;
    private int result;

    @Given("a number is <a> and <b>")
    public void setUpNumber(@Named("a") int a, @Named("b") int b) {
        this.a = a;
        this.b = b;
    }

    @When("multi these two numbers")
    public void multi() {
        this.result = a * b;
    }

    @Then("result is <result>")
    public void verifyResult(@Named("result") int result) {
        assertThat(this.result, is(equalTo(result)));
    }
}
