package com.evil.generics;

import java.util.ArrayList;
import java.util.List;

public class GenericMethod {
    public <T> List<T> makeList(T t1, T t2){
        List<T> result=new ArrayList<>();
        result.add(t1);
        result.add(t2);
        return result;
    }

    public void usage(){
        List<String> listString=makeList("abc","dec");
        List<Integer> listInteger=makeList(1,2);
    }

}
