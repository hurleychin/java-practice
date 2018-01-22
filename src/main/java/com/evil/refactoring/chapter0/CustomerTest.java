package com.evil.refactoring.chapter0;

/**
 * @author qinhu
 * @date 2017-12-14
 */
public class CustomerTest {
    public static void main(String[] args){
        Customer customer=new Customer("qinhulin");
        Movie movie = new Movie("HelloWord", Movie.NEW_RELEASE);
        Rental helloWord = new Rental(movie, 5);
        customer.addRental(helloWord);
        System.out.println(customer.statement());
    }
}
