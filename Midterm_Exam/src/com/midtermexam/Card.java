package com.midtermexam;

import java.util.Objects;

// This is the card class
public class Card
{
    private String name;

    public Card(String name)
    {
        this.name = name;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Card card = (Card) o;
        return Objects.equals(name, card.name);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(name);
    }

    @Override
    public String toString()
    {
        return "Card{" +
                "name='" + name + '\'' +
                '}';
    }
}