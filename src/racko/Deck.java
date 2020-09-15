package racko;

import java.util.List;
import java.util.LinkedList;
import java.util.Collections;

public class Deck extends LinkedList<Card>
{
    public Deck()
    {
    }

    public Deck(boolean fill)
    {
        if (fill)
        {
            fill();
        }
    }

    public void fill()
    {
        clear();
        int min = Card.MIN;
        int max = Card.MAX;
        for (int k = min; k <= max; k++)
        {
            add(new Card(k));
        }
    }

    public void shuffle()
    {
        Collections.shuffle(this);
    }

    public void deal(Rack rack)
    {
        if (Rack.LEN < size())
        {
            rack.clear();

            for (int i = 0; i < Rack.LEN; i++)
            {
                rack.add(pop());
            }
        }
    }

    public void deal(List<Rack> racks)
    {
        if (racks.size() * Rack.LEN < size())
        {
            for (Rack rack : racks)
            {
                rack.clear();
            }
            for (int i = 0; i < Rack.LEN; i++)
            {
                for (Rack rack : racks)
                {
                    rack.add(pop());
                }
            }
        }
    }

	// public void print()
    // {
    // for (Card card : this)
    // {
    // System.out.println(card);
    // }
    // }
    public void print()
    {
        for (int i = 0; i < size(); i++)
        {
            System.out.printf("%5d) %3s\n", i, get(i));
        }
    }

    public Deck complement()
    {
        Deck deck = new Deck(true);
        Deck comp = new Deck(false);
        for (Card card : deck)
        {
            if (!contains(card))
            {
                comp.add(card);
            }
        }
        return comp;
    }

    public double average()
    {
        double a = 0;
        double t = 0;
        int n = 0;
        for (Card card : this)
        {
            t += card.value();
            n += 1;
        }
        if (n > 0)
        {
            a = t / n;
        }
        return a;
    }

	// public static Deck complement(Rack rack)
    // {
    // Deck deck = new Deck(true);
    // Deck comp = new Deck(false);
    // for (Card card : deck)
    // {
    // if (!rack.contains(card))
    // {
    // comp.add(card);
    // }
    // }
    // return comp;
    // }
}
