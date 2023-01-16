package com.movierental;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class CustomerTest {
    Customer customer = new Customer("Me");

    @Before
    public void setup(){
        customer.addRental(new Rental(new Movie("Movie_1", Movie.REGULAR),2));
        customer.addRental(new Rental(new Movie("Movie_2", Movie.NEW_RELEASE),4));
        customer.addRental(new Rental(new Movie("Movie_3", Movie.CHILDRENS),6));
    }
    @Test
    public void statement(){



        String actual_statement = customer.statement();

        String expected_statement = "Rental Record for Me\n" +
                "\tMovie_1\t2.0\n" +
                "\tMovie_2\t12.0\n" +
                "\tMovie_3\t6.0\n" +
                "Amount owed is 20.0\n" +
                "You earned 4 frequent renter points";

        Assert.assertEquals(expected_statement,actual_statement);
    }


    @Test
    public void htmlStatement(){

        String actual_statement = customer.htmlStatement();

        String expected_statement = "<H1>Rental Record for </H1><b>Me</b><br>\tMovie_1\t2.0\n" +
                "\tMovie_2\t12.0\n" +
                "\tMovie_3\t6.0\n" +
                "Amount owed is <b>20.0</b><br>You earned <b>4</b> frequent renter points <br>";

        Assert.assertEquals(expected_statement,actual_statement);
    }
}