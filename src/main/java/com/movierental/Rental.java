package com.movierental;

public class Rental {

    private int daysRented;
    private Movie movie;

    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    public int getDaysRented() {
        return daysRented;
    }

    public Movie movie() {
        return movie;
    }

    static double amount(Rental rental) {
        // Code Smell : Feature Envy
        // Definition: When a method is more interested in the objects of other class
        // Action : Move method to the class where it belongs
        // Not touching switch statement further because it irrelevant to the current context : YAGNI
        double thisAmount = 0;
        //determine amounts for each line
        switch (rental.movie().getPriceCode()) {
            case Movie.REGULAR:
                thisAmount += 2;
                if (rental.getDaysRented() > 2)
                    thisAmount += (rental.getDaysRented() - 2) * 1.5;
                break;
            case Movie.NEW_RELEASE:
                thisAmount += rental.getDaysRented() * 3;
                break;
            case Movie.CHILDRENS:
                thisAmount += 1.5;
                if (rental.getDaysRented() > 3)
                    thisAmount += (rental.getDaysRented() - 3) * 1.5;
                break;
        }
        return thisAmount;
    }

    static int frequentRenterPoints(Rental rental) {
        int frequentRenterPoints = 1;
        if (isBonusApplicable(rental)) frequentRenterPoints++;
        return frequentRenterPoints;
    }

    private static boolean isBonusApplicable(Rental rental) {
        return (rental.movie().getPriceCode() == Movie.NEW_RELEASE)
                &&
                rental.getDaysRented() > 1;
    }

}