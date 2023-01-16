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
        /*
        We have extracted a separate class for the Text Statement. We pass the Customer object to the TextStatement.

        This causes two problems for us -
        1. The totalAmount and totalFrequentRenterPoints methods now need to be public, breaking encapsulation
        2. The TextStatement and Customer class are dependent on each other. Thus their association is Bidirectional.
         This is a Circular Dependency.

        This code smell is called Inappropriate Intimacy. It makes the code difficult to change,
        because changing any one of these classes might require a change in the other.
        Moreover, it makes it difficult to modularise code. It can also cause side effects - when the Customer calls TextStatement,
        the TextStatement might end up changing Customer itself.
         */

        public String display(String name, List<Rental> rentals, double totalAmount, int totalFrequentRenterPoints) {
            String statement = "Rental Record for " + name + "\n";
            for (Rental rental : rentals) {

                statement += "\t" + rental.movie().getTitle() + "\t" +
                        Rental.amount(rental) + "\n";
            }

            statement += "Amount owed is " + totalAmount + "\n";
            statement += "You earned " + totalFrequentRenterPoints
                    + " frequent renter points";
            return statement;
        }

    }

    public String statement() {
        return new TextStatement().display(name, rentals, totalAmount(), totalFrequentRenterPoints());

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

