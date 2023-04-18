public class GoJail extends Square{
    public GoJail(int id) {
        super(id);
    }
    @Override
    public void play(Player player, int dice) {
    player.setSquareNo(11);
    CommandReader.outputStr = player.getName() + " went to jail";
    player.setRoundWait(0);
    }


}
