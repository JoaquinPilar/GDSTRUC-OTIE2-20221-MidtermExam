package com.midtermexam;

import java.util.LinkedList;
import java.util.ListIterator;

// This is the card stack class
public class CardStack
{
    private LinkedList<Card> stack;
    private int size = 0;

    public CardStack()
    {
        stack = new LinkedList<>();
    }

    public void push (Card card)
    {
        stack.push(card);
        size ++;
    }

    public boolean isEmpty()
    {
        return stack.isEmpty();
    }

    public void pop()
    {
        size--;
        stack.pop();
    }

    public Card peek()
    {
        return stack.peek();
    }

    public int getSize()
    {
        return size;
    }

    public void printStack()
    {

        // This displays the stack of cards held by the player
        ListIterator<Card> iterator = stack.listIterator();
        System.out.println("\nCards currently in hand:");

        while(iterator.hasNext())
        {
            System.out.println(iterator.next());
        }

    }
}