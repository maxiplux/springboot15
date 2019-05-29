package com.simple.crud15.onlycucumber;

import com.simple.crud15.controller.SnakeController;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Ignore;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;

@Ignore
public class SnakeControllerTest {

    @Autowired
    SnakeController snake;

    @Given("^I have hungry snake")
    public void i_have_hungry_snake() {
        assertEquals("hiss", snake.poke());
    }

    @When("^When I feed my snake$")
    public void when_i_feed_my_snake() {
        snake.feed();
    }

    @Then("^I receive snek snek$")
    public void receive_snek_snek()  {
        assertEquals("snek snek ^_^", snake.poke());
    }
}