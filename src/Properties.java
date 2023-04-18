public abstract class Properties extends Square
{
    public Properties(int id) {
        super(id);
    }
    public abstract void rent(Player player, int dice);
    public abstract boolean getOwner();
    public abstract void getProperties(Player player);

}
