package racko;

import java.util.Random;

public class PlayerShark implements Player
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
        int k = 0;
        int v = card.value();
        
        if(v <= 30)
        {
            for(int i = 0; i <= 9; i++)
            {
                int w = rack.get(i).value();
                if(v < w)
                {
                    k = i + 1;
                    break;
                }
            }
        }
        else
        {
            for(int i = 9; i >= 0; i--)
            {
                int w = rack.get(i).value();
                if(v > w)
                {
                    k = i + 1;
                    break;
                }
            }
        }
        
        return k;
    }
}
