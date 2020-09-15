package racko;

import java.util.Collections;
import java.util.List;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

class Program
{
    public static void main(String[] args)
    {
        test2();
    }

    public static void test1()
    {
        Deck deck = new Deck(true);
        Collections.shuffle(deck);
        deck.print();

        Rack rack1 = new Rack();
        Rack rack2 = new Rack();
        List<Rack> racks = new LinkedList<Rack>();
        racks.add(rack1);
        racks.add(rack2);
        deck.deal(racks);
        rack1.print();
        rack2.show();
    }

    public static void test2()
    {
        Deck deck = new Deck(true);
        Collections.shuffle(deck);
        deck.print();

        Rack rack = new Rack();
        deck.deal(rack);

        Scanner scanner = new Scanner(System.in);

        int c = 0;

        while (deck.size() > 0)
        {
            rack.show();

            if (rack.isSorted())
            {
                System.out.printf("You Win!!!\n");
                System.out.printf("It only took %d moves.\n", c);
                break;
            }

            c++;

            Card card = deck.pop();
            System.out.printf("%3d) %s Slot or Discard: ", c, card);

            String s = scanner.next();

            int k = 0;
            try
            {
                k = Integer.parseInt(s);
                if (k < 1 || k > 10)
                {
                    k = 0;
                }
            } catch (Exception ex)
            {
            }

            if (k > 0)
            {
                rack.set(k - 1, card);
            }
        }
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
