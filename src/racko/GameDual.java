package racko;

import java.util.List;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class GameDual
{
    public static int DELAY = 20;
    
    public static void main(String[] args)
    {
        play();
    }

    public static void play()
    {
        Player player1 = new PlayerFlatworm();
        Player player2 = new PlayerHuman();
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

        for (int p = 1; p <= 2; p++)
        {
            Rack rack = racks.get(p - 1);
            for (int k = 1; k <= 10; k++)
            {
                Card card = rack.get(k - 1);
                int v = card.value();
                form.setSlot(p, k, v);
            }
        }

        int playerNumber = 1;
        int counter = 1;

        while (true)
        {
            form.setLabels(playerNumber, counter, pile.peek().value());
            Utilities.delay(DELAY);

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
                String message = String.format("Player %d rackos!!!", playerNumber);
                Utilities.showMessageDialog(message);
                break;
            }

            playerNumber = (playerNumber % 2) + 1;
            if (playerNumber == 1)
            {
                ++counter;
            }
        }
        form.close();
    }
}
