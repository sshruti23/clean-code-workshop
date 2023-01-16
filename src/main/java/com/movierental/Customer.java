package com.movierental;

import java.util.ArrayList;
import java.util.List;

public class Customer {
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

    public String statement() {
        String statement = "Rental Record for " + getName() + "\n";
        for (Rental rental : rentals) {

            statement += "\t" + rental.movie().getTitle() + "\t" +
                    Rental.amount(rental) + "\n";
        }

        //add footer lines result
        statement += "Amount owed is " + totalAmount() + "\n";
        statement += "You earned " + totalFrequentRenterPoints()
                + " frequent renter points";
        return statement;
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

