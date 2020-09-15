package racko;

import java.util.Random;
import java.util.LinkedList;
import java.lang.Math;

public class PlayerTesting123 implements Player
{
    Random random = new Random();

    public void beginGame(Rack rack)
    {
    }

    public int acceptCard(Rack rack, Card card)
    {
          int k = 0;
        return k;    }

    public int placeCard(Rack rack, Card card)
    {
        int k = 0;
        int v = card.value();
        
        for(int i = 0; i < 10; i++)
        {
            
            if((v >= (i * 6)) && (v <= ((i + 1) * 6)))
            {

                k = i + 1;
              
            }   

            if(k != 0 && (Math.abs(v - rack.get(k-1).value()) < 6))
            {
                k = 0;
            }
            
           
        }
        return k;

        
    }
}
