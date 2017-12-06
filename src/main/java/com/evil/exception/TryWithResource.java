package com.evil.exception;

public class TryWithResource implements AutoCloseable{

    public void doIt(){
        System.out.println(">>>doing it");
    }

    @Override
    public void close() throws Exception {
        System.out.println(">>>closed!");
    }

    public static void main(String[] args){
        try(TryWithResource tryWithResource=new TryWithResource()){
           tryWithResource.doIt();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //RuntimeException and its subclasses are unchecked exceptions.
        throw new RuntimeException();
        //The class Exception and any subclasses that are not also subclasses of RuntimeException are checked exceptions.
        //throw new Exception();
    }
}
