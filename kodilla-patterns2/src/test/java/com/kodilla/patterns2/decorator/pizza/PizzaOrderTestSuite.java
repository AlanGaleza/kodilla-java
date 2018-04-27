package com.kodilla.patterns2.decorator.pizza;

import org.junit.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.*;

public class PizzaOrderTestSuite {

    @Test
    public void testPizzaGetDescription() {
        //Given
        PizzaOrder theOrder = new BasicPizzaOrder();
        theOrder = new MozarellaDecorator(theOrder);
        theOrder = new SalamiDecorator(theOrder);
        theOrder = new OliveDecorator(theOrder);
        theOrder = new MushorromDecorator(theOrder);
        System.out.println(theOrder.getDescription());

        //When
        String description = theOrder.getDescription();

        //Then
        assertThat("Pizza ingredients: \nBasic: Dough + Tomato Sauce + Cheese\n+ Mozarella \n+ Salami \n+ Olives \n+ Mushrooms").isEqualTo(description);
    }

    @Test
    public void testPizzaGetCost() {
        //Given
        PizzaOrder theOrder = new BasicPizzaOrder();
        theOrder = new MozarellaDecorator(theOrder);
        theOrder = new SalamiDecorator(theOrder);
        theOrder = new OliveDecorator(theOrder);
        theOrder = new MushorromDecorator(theOrder);
        System.out.println(theOrder.getCost());

        //When
        BigDecimal cost = theOrder.getCost();

        //Then
        assertThat(new BigDecimal(35)).isEqualTo(cost);
    }
}
