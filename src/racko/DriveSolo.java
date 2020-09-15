package racko;

import java.util.List;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class DriveSolo
{
    public static void main(String[] args)
    {
        Player player = new PlayerZain();
        String p = player.getClass().getName();
        double t = 0;
        double u = 0;
        for (int n = 1; n <= 1000000; n++)
        {
            play(player);
            t += turns;
            u += points;
            if (n % 10000 == 0)
            {
                System.out.printf("Game %6d: %s %3d turns[%3.3f]  %3d points[%3.3f]\n", n, p, turns, t / n, points, u / n);
            }
        }
    }

    private static int points = 0;
    private static int turns = 0;

    public static void play(Player player)
    {
        points = 0;
        turns = 1;

        Deck deck = new Deck(true);
        Deck pile = new Deck(false);
        Rack rack = new Rack();

        deck.shuffle();
        deck.deal(rack);

        player.beginGame(new Rack(rack));

        while (true)
        {
            if (deck.isEmpty())
            {
                pile.shuffle();
                deck = pile;
                pile = new Deck(false);
            }

            pile.push(deck.pop());

            Card card = pile.peek();
            Rack temp = new Rack(rack);
            int k = player.acceptCard(temp, card);
            if (k > 0)
            {
                card = pile.pop();
            } else
            {
                if (deck.isEmpty())
                {
                    pile.shuffle();
                    deck = pile;
                    pile = new Deck(false);
                }
                card = deck.pop();
                k = player.placeCard(temp, card);
            }

            if (k >= 1 && k <= Rack.LEN)
            {
                pile.push(rack.get(k - 1));
                rack.set(k - 1, card);
            } else
            {
                pile.push(card);
            }

            if (rack.isSorted())
            {
                points = rack.score();
                break;
            }
            ++turns;
        }
    }
}
