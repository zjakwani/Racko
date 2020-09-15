package racko;

import java.util.List;
import java.util.LinkedList;
import java.util.Arrays;
import java.util.Collections;

class Record implements Comparable<Record>
{
    public Player player;
    public int wins;
    public int losses;
    public int points;

    public Record(Player xplayer)
    {
        player = xplayer;
    }

    public int compareTo(Record that)
    {
        float wp1 = this.percentage();
        float wp2 = that.percentage();

        if (wp1 == wp2)
        {
            if (this.losses > that.losses)
            {
                return -1;
            }
            if (that.losses > this.losses)
            {
                return 1;
            }

            if (this.points < that.points)
            {
                return -1;
            }
            if (that.points < this.points)
            {
                return 1;
            }
            return 0;
        }
        if (wp1 < wp2)
        {
            return -1;
        }
        if (wp2 < wp1)
        {
            return 1;
        }
        return 0;
    }

    public float percentage()
    {
        if (wins + losses < 1)
        {
            return .5f;
        }
        return wins / (wins + losses);
    }
}

class Match
{
    public int recno1;
    public int recno2;
    public int score1;
    public int score2;
    public int winner;

    public Match(int r1, int r2)
    {
        recno1 = r1;
        recno2 = r2;
        score1 = 0;
        score2 = 0;
        winner = 0;
    }
}

public class TournamentDual
{
    private static Record[] records;
    private static Match[] matches;

    public static void main(String[] args)
    {
        loadTournament();
        printTournament();
        playTournament();
    }

    public static void loadTournament()
    {
        records = new Record[8];
        records[0] = new Record(new PlayerFlatworm());
        records[1] = new Record(new PlayerFlatworm());
        records[2] = new Record(new PlayerFlatworm());
        records[3] = new Record(new PlayerFlatworm());
        records[4] = new Record(new PlayerSquid());
        records[5] = new Record(new PlayerSquid());
        records[6] = new Record(new PlayerSquid());
        records[7] = new Record(new PlayerSquid());
        
        //records[0] = new Record(new PlayerAlex());
        //records[1] = new Record(new PlayerClark());
        //records[2] = new Record(new PlayerHannah());
        //records[3] = new Record(new PlayerHarris());
        //records[4] = new Record(new PlayerLion());
        //records[5] = new Record(new PlayerPenguin());
        //records[6] = new Record(new PlayerAntonio());
        //records[7] = new Record(new PlayerDanial());

        matches = new Match[28];

		// matches[0] = new Match(0, 1);
        // matches[1] = new Match(2, 3);
        // matches[2] = new Match(4, 5);
        // matches[3] = new Match(6, 7);
		// matches[4] = new Match(0, 2);
        // matches[5] = new Match(1, 3);
        // matches[6] = new Match(4, 6);
        // matches[7] = new Match(5, 7);
		// matches[8] = new Match(0, 3);
        // matches[9] = new Match(1, 4);
        // matches[10] = new Match(2, 6);
        // matches[12] = new Match(5, 7);
		// matches[13] = new Match(0, 4);
        // matches[14] = new Match(1, 5);
        // matches[15] = new Match(2, 6);
        // matches[16] = new Match(3, 7);
		// matches[17] = new Match(0, 5);
        // matches[18] = new Match(1, 6);
        // matches[19] = new Match(2, 7);
        // matches[20] = new Match(3, 4);
		// matches[21] = new Match(0, 6);
        // matches[22] = new Match(1, 7);
        // matches[23] = new Match(2, 4);
        // matches[24] = new Match(3, 5);
		// matches[21] = new Match(0, 7);
        // matches[22] = new Match(1, 2);
        // matches[23] = new Match(3, 6);
        // matches[24] = new Match(4, );
        int c = 0;

        for (int i = 0; i < 8; i++)
        {
            for (int j = i + 1; j < 8; j++)
            {
                matches[c++] = new Match(i, j);
            }
        }
        Collections.shuffle(Arrays.asList(matches));

		// for (int i = 0; i < matches.length; i++)
        // {
        // matches[i] = (Match)list.get(i);
        // }
    }

    public static void printTournament()
    {
        for (int i = 0; i < matches.length; i++)
        {
            Match match = matches[i];
            System.out.printf("Match# %2d  r1: %d %-20s  r2: %d %-20s\n",
                    i,
                    match.recno1,
                    records[match.recno1].player.getClass().getName(),
                    match.recno2,
                    records[match.recno2].player.getClass().getName());
        }
    }

    public static void printStandings()
    {
        Record[] stand = new Record[8];

        for (int i = 0; i < 8; i++)
        {
            stand[i] = records[i];
        }

        Arrays.sort(stand, Collections.reverseOrder());

        System.out.println();
        System.out.println("Tournament Standings");
        System.out.printf("%-20s  %2s  %2s    [%5s]\n",
                "Player",
                "W",
                "L",
                "Pnts");

        for (int i = 0; i < 8; i++)
        {
            Record record = stand[i];

            System.out.printf("%-20s  %2d  %2d    [%5d]\n",
                    record.player.getClass().getName(),
                    record.wins,
                    record.losses,
                    record.points);

        }
        System.out.println();
    }

    public static void playTournament()
    {
        for (int i = 0; i < matches.length; i++)
        {
            Match match = matches[i];
            Record record1 = records[match.recno1];
            Record record2 = records[match.recno2];
            Player player1 = record1.player;
            Player player2 = record2.player;
            int s1 = 0;
            int s2 = 0;
            int w = 0;
            while (w == 0)
            {
                System.out.printf("Match# %2d  r1: %d %-20s  r2: %d %-20s\n",
                        i,
                        match.recno1,
                        player1.getClass().getName(),
                        match.recno2,
                        player2.getClass().getName());
                MatchDual.playMatch(player1, player2);
                s1 = MatchDual.t1;
                s2 = MatchDual.t2;
                if (s1 > s2)
                {
                    w = 1;
                }
                if (s2 > s1)
                {
                    w = 2;
                }
            }
            match.score1 = s1;
            match.score2 = s2;
            match.winner = w;
            matches[i] = match;
            record1.wins += (w == 1) ? 1 : 0;
            record1.losses += (w == 1) ? 0 : 1;
            record1.points += s1;
            record2.wins += (w == 2) ? 1 : 0;
            record2.losses += (w == 2) ? 0 : 1;
            record2.points += s2;

            printStandings();
        }
    }
}
