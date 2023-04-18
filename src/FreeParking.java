public class FreeParking extends Square{
    public FreeParking(int id) {
        super(id);
    }

    @Override
    public void play(Player player, int dice) {
        player.setRoundWait(2);
        CommandReader.outputStr = player.getName() + " is in Free Parking";
        player.setParked(true);
    }
}
