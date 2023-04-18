import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class CommandReader {
    Player player1 = new Player("Player 1");
    Player player2 = new Player("Player 2");
    public static String outputStr;

    public CommandReader(String file) throws IOException {
        File comFile = new File(file);
        Scanner comScan = new Scanner(comFile);
        OutputWriter outputWriter = new OutputWriter();
        while (comScan.hasNext() & player1.isBankrupt() & player2.isBankrupt())
        {
            String str = comScan.nextLine();
            if (str.startsWith("s"))
            {
                //show function
                outputWriter.show(player1, player2);
            }
            else
            {
                String[] strArr = str.split(" ");
                String[] intArr = strArr[1].split(";");
                int playerNo = Integer.parseInt(intArr[0]);
                int dice = Integer.parseInt(intArr[1]);
                //play function with player no
                if (playerNo == 1)
                {
                    if (player1.waitRound()) {
                        player1.play(dice);
                        Square square = Square.objFinder(player1.getSquareNo());
                        square.play(player1, dice);
                        if (CommunityChest.getCardNo() == 4)
                        {
                            player2.loseMoney(10);
                        }
                        else if (CommunityChest.getCardNo() == 5)
                        {
                            player2.loseMoney(50);
                        }
                        if (player1.getOwnMoney() != 0)
                        {
                            player2.loseMoney(player1.getOwnMoney());
                            player1.setOwnMoney(0);
                        }
                    }
                    else
                    {
                        if (player1.isParked())
                        {
                            outputStr = player1.getName() + " in jail (count=" + player1.getRoundWait() + ")";
                        }
                        else
                        {
                            outputStr = player1.getName() + " is in free parking";
                        }
                    }
                    outputWriter.Write(player1.getName() + "\t" + dice + "\t" + player1.getSquareNo() + "\t" + player1.getMoney() + "\t" +
                            player2.getMoney() + "\t" + outputStr);
                }
                else
                {
                    if (player2.waitRound())
                    {
                        player2.play(dice);
                        Square square = Square.objFinder(player2.getSquareNo());
                        square.play(player2, dice);
                        if (CommunityChest.getCardNo() == 4)
                        {
                            player1.loseMoney(10);
                        }
                        else if (CommunityChest.getCardNo() == 5)
                        {
                            player1.loseMoney(50);
                        }
                        if (player2.getOwnMoney() != 0)
                        {
                            player1.loseMoney(player2.getOwnMoney());
                            player2.setOwnMoney(0);
                        }
                    }
                    else
                    {
                        if (player1.isParked())
                        {
                            outputStr = player1.getName() + " in jail (count=" + player1.getRoundWait() + ")";
                        }
                        else
                        {
                            outputStr = player1.getName() + " is in free parking";
                        }                    }
                    outputWriter.Write(player2.getName() + "\t" + dice + "\t" + player2.getSquareNo() + "\t" + player1.getMoney() + "\t" +
                            player2.getMoney() + "\t" + outputStr);
                }
            }
            if (player1.getMoney() == 0 || player2.getMoney() == 0)
            {
                player2.setBankrupt(true);
            }
        }
        outputWriter.show(player1, player2);
        outputWriter.close();
    }
}
