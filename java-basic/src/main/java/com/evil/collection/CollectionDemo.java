package com.evil.collection;

import java.io.IOException;
import java.text.ParseException;
import java.util.*;

/**
 * @author qinhulin on 2019-06-28
 */
public class CollectionDemo {
    public static void main(String[] args) throws IOException, ParseException {

        List<String> hit=new ArrayList<>();
        hit.add("a");
        hit.add("b");
        hit.add("c");
        hit.add("z");

        List<String> pList=new ArrayList<>();
        pList.add("a");
        pList.add("b");
        pList.add("c");
        pList.add("d");
        pList.add("e");
        pList.add("f");

        Map<String,String> map=new HashMap<>();
        map.put("a","1");
        map.put("b","2");
        map.put("c","3");
        map.put("d","4");

        Collection  keys=new ArrayList(map.keySet());

        keys.removeAll(hit);
        System.out.println( keys);

//        pList.retainAll(hit);
//        pList.removeAll(hit);
//        System.out.println(pList);

    }
}
