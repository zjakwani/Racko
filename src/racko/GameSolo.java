package racko;

import java.util.List;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class GameSolo
{
    public static void main(String[] args)
    {
        Player player = new PlayerKeke();
        String p = player.getClass().getName();
        double t = 0;
        for (int n = 1; n <= 1000; n++)
        {
            int c = play(player);
            t += c;
            System.out.printf("Game %6d: %s %3d turns  average: %3.3f\n", n, p, c, t / n);
        }
    }

    public static int play(Player player)
    {
        Deck deck = new Deck(true);
        Deck pile = new Deck(false);
        Rack rack = new Rack();

        deck.shuffle();
        deck.deal(rack);

        player.beginGame(new Rack(rack));

        FormSolo form = new FormSolo();

        for (int k = 1; k <= 10; k++)
        {
            Card card = rack.get(k - 1);
            int v = card.value();
            form.setSlot(k, v);
        }

        int counter = 1;

        while (true)
        {
            if (deck.isEmpty())
            {
                pile.shuffle();
                deck = pile;
                pile = new Deck(false);
            }

            pile.push(deck.pop());
            form.setLabels(counter, pile.peek().value());
            delay(100);

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

                int v = card.value();
                form.setSlot(k, v);
            } else
            {
                pile.push(card);
            }

            form.setLabels(counter, pile.peek().value());

            if (rack.isSorted())
            {
                delay(800);
                break;
            }
            ++counter;
        }
        form.close();
        return counter;
    }

    public static void infoBox(String infoMessage)
    {
        JOptionPane.showMessageDialog(null, infoMessage, "Info Box", JOptionPane.INFORMATION_MESSAGE);
    }

    public static boolean delay(int milliseconds)
    {
        boolean success = true;
        try
        {
            Thread.sleep(milliseconds);
        } catch (InterruptedException ex)
        {
            Thread.currentThread().interrupt();
            success = false;
        }
        return success;
    }
}
