package com.movierental;

public class Customer {

    /*
     The urge to introduce Statement as a Parent class and Text & html Statement as child class is called :Speculative Generality.
     */

    private String name;
    private Rentals rentals = new Rentals();

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
        Rentals rentals = this.rentals;
        return new TextStatement().display(rentals, name);
    }

    public String htmlStatement() {
        Rentals rentals = this.rentals;
        return new HtmlStatement().htmlDisplay(rentals, name);
    }

}

