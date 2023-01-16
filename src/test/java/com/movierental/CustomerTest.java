package com.movierental;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class CustomerTest {
    @Test
    public void customerStatement(){

        Customer customer = new Customer("Me");
        customer.addRental(new Rental(new Movie("Movie_1", Movie.REGULAR),2));
        customer.addRental(new Rental(new Movie("Movie_2", Movie.NEW_RELEASE),4));
        customer.addRental(new Rental(new Movie("Movie_3", Movie.CHILDRENS),6));

        String actual_statement = customer.statement();

        String expected_statement = "Rental Record for Me\n" +
                "\tMovie_1\t2.0\n" +
                "\tMovie_2\t12.0\n" +
                "\tMovie_3\t6.0\n" +
                "Amount owed is 20.0\n" +
                "You earned 4 frequent renter points";

        Assert.assertEquals(expected_statement,actual_statement);
    }

}