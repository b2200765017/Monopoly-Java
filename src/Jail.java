public class Jail extends Square{
    public Jail(int id) {
        super(id);
    }

    @Override
    public void play(Player player, int dice) {
        player.setRoundWait(0);
        CommandReader.outputStr = player.getName() + " went to jail";
    }
}
