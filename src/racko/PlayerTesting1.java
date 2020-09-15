package racko;

import java.util.Random;

public class PlayerTesting1 implements Player
{
    Random random = new Random();

    public void beginGame(Rack rack)
    {
    }

    public int acceptCard(Rack rack, Card card)
    {
        int k = 0;
    

        int v = card.value();
        
        for(int i = 0; i < 10; i++)
        {
            if((v > (i * 6)) && (v <= ((i + 1) * 6)))
            {
                k = i + 1;
            }
        }
        return k;
    }

    public int placeCard(Rack rack, Card card)
    {
        int k = 0;
        int v = card.value();

        for(int i = 0; i < 10; i++)
        {
            if((v > (i * 6)) && (v <= ((i + 1) * 6)))
            {
                k = i + 1;
            }
        }
        return k;
    }
}
