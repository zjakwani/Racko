package racko;

import java.util.Collections;
import java.util.List;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

public class GameConsole
{
    public static void main(String[] args)
    {
        play();
    }

    public static void play()
    {
        Player player1 = new PlayerConsole();
        Player player2 = new PlayerFlatworm();

        List<Player> players = new LinkedList<Player>();
        players.add(player1);
        players.add(player2);

        Deck deck = new Deck(true);
        Deck pile = new Deck(false);
        Collections.shuffle(deck);

        Rack rack1 = new Rack();
        Rack rack2 = new Rack();
        List<Rack> racks = new LinkedList<Rack>();

        racks.add(rack1);
        racks.add(rack2);
        deck.deal(racks);

        player1.beginGame(new Rack(rack1));
        player2.beginGame(new Rack(rack2));

        pile.push(deck.pop());

        int playerNumber = 1;
        int counter = 1;

        while (true)
        {
            Rack rack = racks.get(playerNumber - 1);
            Player player = players.get(playerNumber - 1);

            Card card = pile.peek();
            Rack temp = new Rack(rack);

            System.out.printf("\n\nPlayer: %d  Discard: %s  Turn: %d\n", playerNumber, card, counter);

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

                System.out.printf("Player: %d  Card: %s  Slot: %s\n",
                        playerNumber, card, k);
            } else
            {
                pile.push(card);
            }

            rack.show();
            System.out.printf("Player: %d  Discards: %s\n", playerNumber, pile.peek());

            if (rack.isSorted())
            {
                System.out.printf("Player %d wins (in only %d turns)!!!\n", playerNumber, counter);
                break;
            }
            playerNumber = (playerNumber % 2) + 1;
            if (playerNumber == 1)
            {
                ++counter;
            }
        }
    }

    public static boolean pause()
    {
        boolean b = false;

        Scanner scanner = new Scanner(System.in);
        System.out.printf("Continue? ");
        String s = scanner.next();
        if (s.toUpperCase().substring(0, 1).equals("Y"))
        {
            b = true;
        }
        return b;
    }
}
