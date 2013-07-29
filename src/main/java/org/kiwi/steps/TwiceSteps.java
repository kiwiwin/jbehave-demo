package org.kiwi.steps;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.model.ExamplesTable;
import org.kiwi.domain.KV;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TwiceSteps {

    private List<KV> kvs;

    @Given("the kvs: $table")
    public void setUpKVs(ExamplesTable table) {
        kvs = transformKV(table);
    }

    private List<KV> transformKV(ExamplesTable table) {
        List<KV> result = new ArrayList<>();
        for (Map<String, String> row : table.getRows()) {
            String key = row.get("key");
            Integer value = Integer.valueOf(row.get("value"));
            result.add(new KV(key, value));
        }
        return result;
    }

    @When("twice the value:")
    public void twiceTheValue() {
        for (KV kv : kvs) {
            kv.setValue(kv.getValue() * 2);
        }
    }

    @Then("value is twiced: $table")
    public void verifyResult(ExamplesTable table) {
        List<KV> expectedLVs = transformKV(table);
        assertThat(kvs, is(equalTo(expectedLVs)));
    }
}
