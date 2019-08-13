package com.evil.collection;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author qinhulin on 2019-06-28
 */
public class IteratorRemove {
    public static void main(String[] args) throws IOException, ParseException {

        List<String> hit=new ArrayList<>();
        hit.add("a");
        hit.add("b");
        hit.add("c");

        List<String> pList=new ArrayList<>();
        pList.add("a");
        pList.add("b");
        pList.add("c");
        pList.add("d");
        pList.add("e");
        pList.add("f");

        Iterator iterator=pList.iterator();
        while (iterator.hasNext()){
           String e= (String) iterator.next();
           if(hit.contains(e)){
              iterator.remove();
           }
        }

        System.out.println(pList);
    }
}
