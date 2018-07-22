package com.evil.refactoring.chapter0;

import java.util.Enumeration;
import java.util.Vector;

/**
 * @author qinhu
 * @date 2017-12-14
 */
public class Customer {
    private String _name;                        //姓名
    private Vector _rentals = new Vector();        //租借记。

    public Customer (String name){
        _name = name;
    };

    public void addRental(Rental arg) {
        _rentals.addElement(arg);
    }

    public String getName (){
        return _name;
    };

    public String statement() {

//        double totalAmount = 0;        //总消费金。
//        int frequentRenterPoints = 0;        //常客积点
        Enumeration rentals = _rentals.elements();
        String result = "Rental Record for " + getName() + "\n";
        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();        //取得一笔租借记。
//            double thisAmount = this.getCharge(each);
/*            //determine amounts for each line
            switch (each.getMovie().getPriceCode()) {        //取得影片出租价格
                case Movie.REGULAR:                        //普通片
                    thisAmount += 2;
                    if (each.getDaysRented() > 2)
                        thisAmount += (each.getDaysRented() - 2) * 1.5;
                    break;
                case Movie.NEW_RELEASE:                //新片
                    thisAmount += each.getDaysRented() * 3;
                    break;
                case Movie.CHILDRENS:                //儿童。
                    thisAmount += 1.5;
                    if (each.getDaysRented() > 3)
                        thisAmount += (each.getDaysRented() - 3) * 1.5;
                    break;
            }*/
            // add frequent renter points        （累计常客积点。
//            frequentRenterPoints ++;
//            frequentRenterPoints += each.getFrequentRenterPoints();
            // add bonus for a two day new release rental
//            if ((each.getMovie().getPriceCode() == Movie.NEW_RELEASE) &&
//                    each.getDaysRented() > 1) frequentRenterPoints ++;
            //show figures for this rental（显示此笔租借记录）
            result += "\t" + each.getMovie().getTitle()+ "\t" +
                    String.valueOf(each.getCharge()) + "\n";
//            totalAmount += getCharge(each);
        }
        //add footer lines（结尾打印）
        result +=  "Amount owed is " + String.valueOf(getTotalCharge()) + "\n";
        result += "You earned " + String.valueOf(getTotalFrequentRenterPoints()) +
                " frequent renter points";
        return result;
    }
    public String htmlStatement() {
        Enumeration rentals = _rentals.elements();
        String result = "<H1>Rentals for <EM>" + getName() + "</EM></ H1><P>\n";
        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();
            //show figures for each rental
            result += each.getMovie().getTitle()+ ": " +
                    String.valueOf(each.getCharge()) + "<BR>\n";
        }
        //add footer lines
        result +=  "<P>You owe <EM>" + String.valueOf(getTotalCharge()) + "</EM><P>\n";
        result += "On this rental you earned <EM>" +
                String.valueOf(getTotalFrequentRenterPoints()) +
                "</EM> frequent renter points<P>";
        return result;
    }

//    private double getCharge(Rental aRental) {
//        return aRental.getCharge();
//    }
    private double getTotalCharge() {
        double result = 0;
        Enumeration rentals = _rentals.elements();
        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();
            result += each.getCharge();
        }
        return result;
    }
    private int getTotalFrequentRenterPoints(){
        int result = 0;
        Enumeration rentals = _rentals.elements();
        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();
            result += each.getFrequentRenterPoints();
        }
        return result;
    }

}
