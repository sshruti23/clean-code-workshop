package com.movierental;

import java.util.ArrayList;
import java.util.List;

public class Customer {

    /*
     The urge to introduce Statement as a Parent class and Text & html Statement as child class is called :Speculative Generality.
     */

    private String name;
    private List<Rental> rentals = new ArrayList<>();

    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental arg) {
        rentals.add(arg);
    }

    public String getName() {
        return name;
    }

    public class TextStatement {
        public String display(Customer customer) {
            String statement = "Rental Record for " + customer.getName() + "\n";
            for (Rental rental : customer.rentals) {

                statement += "\t" + rental.movie().getTitle() + "\t" +
                        Rental.amount(rental) + "\n";
            }

            statement += "Amount owed is " + customer.totalAmount() + "\n";
            statement += "You earned " + customer.totalFrequentRenterPoints()
                    + " frequent renter points";
            return statement;
        }

    }

    public String statement() {
        return new TextStatement().display(this);

    }

    private int totalFrequentRenterPoints() {
        int totalFrequentRenterPoints = 0;
        for (Rental rental : rentals) {
            totalFrequentRenterPoints += rental.frequentRenterPoints(rental);
        }
        return totalFrequentRenterPoints;
    }

    private double totalAmount() {
        double totalAmount = 0;
        for (Rental rental : rentals) {
            totalAmount += Rental.amount(rental);
        }
        return totalAmount;
    }

    public String htmlStatement() {
        String htmlStatement = "<H1>Rental Record for </H1>" + "<b>" + getName() + "</b>" + "<br>";
        for (Rental rental : rentals) {
            htmlStatement += "<b>" + rental.movie().getTitle() + "<b>" +
                    Rental.amount(rental) + "<br>";
        }

        htmlStatement += "Amount owed is " + "<b>" + totalAmount() + "</b>" + "<br>";
        htmlStatement += "You earned " + "<b>" + totalFrequentRenterPoints() + "</b>"
                + " frequent renter points <br>";
        return htmlStatement;
    }
}

