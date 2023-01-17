package com.movierental;

import java.util.ArrayList;

public class Rentals extends ArrayList<Rental> {

    double totalAmount() {
        double totalAmount = 0;
        for (Rental rental : this) {
            totalAmount += Rental.amount(rental);
        }
        return totalAmount;
    }

    int totalFrequentRenterPoints() {
        int totalFrequentRenterPoints = 0;
        for (Rental rental : this) {
            totalFrequentRenterPoints += Rental.frequentRenterPoints(rental);
        }
        return totalFrequentRenterPoints;
    }
}
