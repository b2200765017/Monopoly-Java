import java.io.IOException;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        new PropertyJsonReader();
        new ListJsonReader();
        new CommandReader(args[0]);
    }
}
