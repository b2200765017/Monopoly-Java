public class Go extends Square{

    public Go(int id) {
        super(id);
    }
    @Override
    public void play(Player player, int dice) {
        super.play(player, dice);
        super.play(player, dice);
        CommandReader.outputStr = player.getName() + " is in GO square";
    }

}
