package racko;

import java.util.Random;

public class PlayerSquid implements Player
{
    Random random = new Random();

    public void beginGame(Rack rack)
    {
    }

    public int acceptCard(Rack rack, Card card)
    {
        int k = 0;
        return k;
    }

    public int placeCard(Rack rack, Card card)
    {
        int k = 1;
        while (k < 10)
        {
            if (rack.get(k).value() > card.value())
            {
                break;
            }
            k++;
        }
        return k;
    }
}
