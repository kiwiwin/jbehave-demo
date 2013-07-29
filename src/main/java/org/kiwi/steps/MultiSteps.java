package org.kiwi.steps;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.kiwi.domain.Multi;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MultiSteps {
    private Multi multi;

    @Given("a number is <a> and <b>")
    public void setUpNumber(@Named("a") int a, @Named("b") int b) {
        multi = new Multi(a, b);
    }

    @When("multi these two numbers")
    public void multi() {
        multi.execute();
    }

    @Then("result is <result>")
    public void verifyResult(@Named("result") int result) {
        assertThat(multi.getResult(), is(equalTo(result)));
    }
}
