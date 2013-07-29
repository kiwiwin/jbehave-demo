package org.kiwi.steps;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.kiwi.domain.Add;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class AddSteps {
    private int a;
    private int b;
    private int result;

    private Add add;

    @Given("a number is '$a' and '$b'")
    public void setUpTwoNumbers(int a, int b) {
        add = new Add(a, b);
    }

    @When("add these two numbers")
    public void addTwo() {
        add.execute();
    }

    @Then("result is '$result'")
    public void verifyResult(int result) {
        assertThat(add.getResult(), is(equalTo(result)));
    }
}
