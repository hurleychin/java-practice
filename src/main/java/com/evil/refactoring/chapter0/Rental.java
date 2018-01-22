package com.evil.refactoring.chapter0;

/**
 * @author qinhu
 * @date 2017-12-14
 */
public class Rental {
    private Movie _movie;        //影片
    private int _daysRented;        //租期

    public Rental(Movie movie, int daysRented) {
        _movie = movie;
        _daysRented = daysRented;
    }

    public int getDaysRented() {
        return _daysRented;
    }

    public Movie getMovie() {
        return _movie;
    }

    public double getCharge() {    //计算一笔租片费。
        return _movie.getCharge(_daysRented);
    }
    public  int getFrequentRenterPoints() {
        return _movie.getFrequentRenterPoints(_daysRented);
    }
}
