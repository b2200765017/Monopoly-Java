import java.io.FileWriter;
import java.io.IOException;

public class OutputWriter
{
    FileWriter myWriter = new FileWriter("output.txt");

    public OutputWriter() throws IOException {
    }

    public void Write(String str) throws IOException {
        myWriter.write(str + "\n");
    }
    public void show(Player player1, Player player2) throws IOException {
        //this func will give the output
        String winner;
        Write("-------------------------------------------------------------------------------------------------------------------------");
        Write(player1.getName() + "\t" + player1.getMoney() + "\thave: " + player1.properties.toString()
                .replace("[","").replace("]","").replace(", ",","));
        Write(player2.getName() + "\t" + player2.getMoney() + "\thave: " + player2.properties.toString()
                .replace("[","").replace("]","").replace(", ",","));
        Write(Banker.name + "\t" + Banker.money);
        if (player1.getMoney() > player2.getMoney()) winner = player1.getName();
        else winner = player2.getName();
        Write("Winner\t" + winner);
        Write("-------------------------------------------------------------------------------------------------------------------------");

    }
    public void close() throws IOException {
        myWriter.close();
    }
}
