package com.evil.linkedlist;

import java.util.Iterator;
import java.util.function.Consumer;

/**
 * LinkedList
 *
 * @author qinhu
 * @version 0.0.1
 * @since 2023-06-08
 */
public class LinkedList implements Iterable {
    private Node head;

    public void add(int value){
        Node node=new Node(value);
        if(head==null){
            head=node;
            return;
        }
        Node temp=head;
        while(temp.next!=null){
            temp=temp.next;
        }
        temp.next=node;
    }

    public void remove(int value){
        if(head==null){
            return;
        }
        if(head.value==value){
            head=head.next;
            return;
        }
        Node temp=head;
        while(temp.next!=null){
            if(temp.next.value==value){
                temp.next=temp.next.next;
                return;
            }
            temp=temp.next;
        }
    }


    @Override
    public Iterator iterator() {
        return new Iterator() {
            Node temp=head;
            @Override
            public boolean hasNext() {
                return temp!=null;
            }

            @Override
            public Object next() {
                Node node=temp;
                temp=temp.next;
                return node.value;
            }
        };
    }

    @Override
    public void forEach(Consumer action) {
        Iterable.super.forEach(action);
    }

    class Node{
         int value;
         Node next;
        public Node(int value) {
            this.value = value;
        }
    }

}
