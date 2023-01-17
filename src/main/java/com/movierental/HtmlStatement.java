package com.movierental;

public class HtmlStatement {
    public String htmlDisplay(Rentals rentals, String customerName) {
        String htmlStatement = "<H1>Rental Record for </H1>" + "<b>" + customerName + "</b>" + "<br>";
        for (Rental rental : rentals) {
            htmlStatement += "<b>" + rental.movie().getTitle() + "<b>" +
                    Rental.amount(rental) + "<br>";
        }

        htmlStatement += "Amount owed is " + "<b>" + rentals.totalAmount() + "</b>" + "<br>";
        htmlStatement += "You earned " + "<b>" + rentals.totalFrequentRenterPoints() + "</b>"
                + " frequent renter points <br>";
        return htmlStatement;
    }
}
