package com.evil.linkedlist;

import java.util.function.Consumer;

/**
 * LinkedList
 *
 * @author qinhu
 * @version 0.0.1
 * @since 2023-06-08
 */
public class LinkedList {
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

    public void iterator(Consumer consumer){
        Node temp=head;
        while(temp!=null){
            consumer.accept(temp.value);
            temp=temp.next;
        }
    }

    private static class Node{
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }
    }

}
