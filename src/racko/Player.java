package racko;

public interface Player
{
    // beginGame is invoked at the start of each game
    // rack is the initial randomly dealt rack
    // you may initialize any variables here
    public void beginGame(Rack rack);

    // acceptCard is invoked at the start of each turn
    // rack is the current state of the rack
    // card is the last discard from the previous player's turn
    // you may return a slot number, or 0 to be dealt another card
    public int acceptCard(Rack rack, Card card);

    // placeCard is invoked if zero is returned by acceptCard
    // rack is the current state of the rack
    // card is the newly drawn card
    // you may return a slot number, or 0 to discard the new card
    public int placeCard(Rack rack, Card card);
}
