package com.movierental;

public class TextStatement {
    public String display(Rentals rentals, String customerName) {
        String statement = "Rental Record for " + customerName + "\n";
        for (Rental rental : rentals) {

            statement += "\t" + rental.movie().getTitle() + "\t" +
                    Rental.amount(rental) + "\n";
        }

        statement += "Amount owed is " + rentals.totalAmount() + "\n";
        statement += "You earned " + rentals.totalFrequentRenterPoints()
                + " frequent renter points";
        return statement;
    }
}
