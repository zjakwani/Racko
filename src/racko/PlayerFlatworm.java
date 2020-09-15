package racko;

import java.util.Random;

public class PlayerFlatworm implements Player
{
    Random random = new Random();

    public void beginGame(Rack rack)
    {
    }

    public int acceptCard(Rack rack, Card card)
    {
        int k = 0;
        if (random.nextInt(2) == 0)
        {
            k = random.nextInt(10) + 1;
        }
        return k;
    }

    public int placeCard(Rack rack, Card card)
    {
        int k = random.nextInt(10) + 1;
        return k;
    }
}
