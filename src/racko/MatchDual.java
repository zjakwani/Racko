package racko;

import java.util.List;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class MatchDual
{
    public static int t1 = 0;
    public static int t2 = 0;
    public static int gc = 0;

    private static final int delay1 = 80;
    private static final int delay2 = 1000;
    private static final int delay3 = 2000;
    
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args)
    {
        Player player1 = new racko.PlayerTurtle();
        Player player2 = new racko.PlayerZain();
        playMatch(player1, player2);
    }

    public static void playMatch(Player player1, Player player2)
    {
        t1 = 0;
        t2 = 0;
        gc = 0;

        FormMatch formMatch = new FormMatch();

        formMatch.putName(1, getClassName(player1));
        formMatch.putName(2, getClassName(player2));

        for (int i = 1; i <= 13; i++)
        {
            //System.out.printf("Game: %d\n", i);
            List<Rack> racks = playGame(player1, player2);
            show(formMatch, racks);
        }
        int p = 0;
        String msg = String.format("Final Score\nPlayer 1: %d (%s)\nPlayer 2: %d (%s)\n",
                t1,
                getClassName(player1),
                t2,
                getClassName(player2));
        //Utilities.showMessageDialog(msg);
        System.out.println(msg);
        //scanner.nextLine();
        //Utilities.showMessageDialog(msg);
        
        Utilities.delay(delay3);
        formMatch.close();
    }

    public static List<Rack> playGame(Player player1, Player player2)
    {
        List<Player> players = new LinkedList<Player>();
        players.add(player1);
        players.add(player2);

        Deck deck = new Deck(true);
        Deck pile = new Deck(false);

        deck.shuffle();

        Rack rack1 = new Rack();
        Rack rack2 = new Rack();
        List<Rack> racks = new LinkedList<Rack>();

        racks.add(rack1);
        racks.add(rack2);
        deck.deal(racks);

        player1.beginGame(new Rack(rack1));
        player2.beginGame(new Rack(rack2));

        pile.push(deck.pop());

        FormDual form = new FormDual();
        form.getFrame().setLocation(2, 202);

        for (int p = 1; p <= 2; p++)
        {
            form.setName(p, getClassName(players.get(p - 1)));
            Rack rack = racks.get(p - 1);
            for (int k = 1; k <= 10; k++)
            {
                Card card = rack.get(k - 1);
                int v = card.value();
                form.setSlot(p, k, v);
            }
        }

        int playerNumber = gc % 2 + 1;
        int counter = 1;

        while (true)
        {
            form.setLabels(playerNumber, counter, pile.peek().value());
            Utilities.delay(delay1);

            Rack rack = racks.get(playerNumber - 1);
            Player player = players.get(playerNumber - 1);

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

                int p = playerNumber;
                int v = card.value();
                form.setSlot(p, k, v);
            } else
            {
                pile.push(card);
            }

            form.setLabels(playerNumber, counter, pile.peek().value());

            if (rack.isSorted())
            {
                break;
            }
            playerNumber = (playerNumber % 2) + 1;
            if (playerNumber == 1)
            {
                ++counter;
            }
        }
        Utilities.delay(delay2);
        form.close();
        return racks;
    }

    public static void show(FormMatch formMatch, List<Rack> racks)
    {
        Rack rack1 = racks.get(0);
        Rack rack2 = racks.get(1);
        int s1 = rack1.score();
        int s2 = rack2.score();
        boolean b1 = rack1.isSorted();
        boolean b2 = rack2.isSorted();
        boolean q1 = rack1.numSequence() > 0;
        boolean q2 = rack2.numSequence() > 0;
        t1 += s1;
        t2 += s2;
        gc += 1;

        int pn = b1 ? 1 : 2;

	String message = String.format("Player %d rackos!!!\nGame Player 1: %d\nGame Player 2: %d\n\nMatch Player 1: %d\nMatch Player 2: %d\n", 
         pn,
         s1,
         s2,
         t1,
         t2);
        // Utilities.showMessageDialog(message);
        //System.out.println(message);
        formMatch.putScore(1, gc, s1, b1, q1);
        formMatch.putScore(2, gc, s2, b2, q2);
        formMatch.putTotal(1, t1);
        formMatch.putTotal(2, t2);
    }
    
    public static String getClassName(Object o)
    {
        String name = o.getClass().getName();
        if (name.contains("."))
        {
            name = name.substring(name.indexOf('.') + 1);
        }
        return name;
    }
}
