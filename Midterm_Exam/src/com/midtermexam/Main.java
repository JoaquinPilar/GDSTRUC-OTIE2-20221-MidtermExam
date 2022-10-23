// Midterm Exam
// Instructions: Create a program that features a deck of cards that the player can draw cards from

package com.midtermexam;

// This is the main class
public class Main 
{
    
    // Creating new stack for every command
    public static void main(String[] args) 
    {
        CardStack deckList = initializeDeck();
        CardStack handList = new CardStack();
        CardStack discardList = new CardStack();


        // This function executes every turn when a command has been used
        while(deckList.getSize() != 0)
        {
            round(deckList, handList, discardList);
            System.out.println("\nLoading Turn...");
            System.out.println("-----------------------------------------\n");
            pause(4);
            System.out.flush();
        }
    }

    // This function generates a random number from 1-5
    public static int rng()
    {
        int min = 1;
        int max = 5;
        return (int)(Math.random()*(max -min+1)+min);
    }

    // This is the DRAW CARDS command
    public static void draw(CardStack deck, CardStack hand)
    {
        int cardDraw = rng();
        for(int i = 0; i < cardDraw; i++)
        {
            hand.push(deck.peek());
            deck.pop();
        }
    }

    // This is the DISCARD CARDS command
    public static void discard (CardStack hand, CardStack bringBack)
    {

        // if statement for when you have no cards to discard
        if (hand.isEmpty())
        {
            System.out.println("You do not have any cards to discard...\n");
        }

        // else statement for choosing how many cards to discard
        else
        {
            int cardDiscard = rng();
            for (int i = 0; i < cardDiscard; i++)
            {
                bringBack.push(hand.peek());
                hand.pop();
            }
        }
    }

    // This is the GET DISCARDED CARDS command
    public static void revive (CardStack hand, CardStack bringBack)
    {

        // if statement for when the discarded pile is empty
        if (bringBack.isEmpty())
        {
            System.out.println("The Discarded Pile is currently empty...\n");
        }

        // else statement for when the discarded pile is not empty
        else
        {
            int cardsToBringBack = rng();
            for(int i = 0; i < cardsToBringBack; i++)
            {
                hand.push(bringBack.peek());
                bringBack.pop();
            }
        }
    }

    // This function contains the 3 random choices the program plays every turn
    public static void round(CardStack deck, CardStack hand, CardStack bringBack)
    {
        int action = rng();

        // Action for drawing cards
        if (action == 1)
        {
            draw(deck, hand);
        }

        // Action for discarding cards
        else if (action == 2)
        {
            discard(hand, bringBack);
        }

        // Action for bringing back discarded cards
        else if (action == 3)
        {
            revive(hand,bringBack);
        }

        // These are stats to display on the screen
        System.out.println("Deck Pile: " + deck.getSize());
        System.out.println("Discarded Pile: " + bringBack.getSize());
        System.out.println("Card/s in Hand: " + hand.getSize());
        hand.printStack();
    }

    // This is the deck of cards
    // Contains 30 cards
    public static CardStack initializeDeck()
    {
        CardStack deck = new CardStack();

        // This method pushes an element (card) into the stack
        for (int i =  0; i <= 5; i++)
        {
            deck.push(new Card("Spooderman"));
            deck.push(new Card("Amogus"));
            deck.push(new Card("IShowSpeed"));
            deck.push(new Card("Quandale Dingle"));
            deck.push(new Card("Gigachad"));
        }
        return deck;
    }

    // This is a function used for catching an interrupted exception
    public static void pause(int seconds)
    {

        // timer function
        try
        {
            Thread.sleep(seconds * 350L);
        }

        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}