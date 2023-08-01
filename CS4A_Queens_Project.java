import java.util.Calendar;
public class CS4A_Queens_Project {
    static final int BOARD_SIZE = 5;
    //worst case scenario make it go through every combo
    public static void display(int[] chess, int counter) //Created by Aiden Sallows
    {
        System.out.println("Displaying solution #" + counter);
        for(int i = 0; i < BOARD_SIZE; i++)
        { //i = 0, value stored is 3
            for(int j = 0; j < BOARD_SIZE; j++)
            {
                if(j == chess[i])
                {
                    System.out.print("|Q");
                }
                else
                {
                    System.out.print("| ");
                }
            }
            System.out.print("|\n");
        }
        System.out.print("\n\n");
    }
    public static void main(String[] arg) {
        long startTime = Calendar.getInstance().getTimeInMillis();
        int[] chess = new int [BOARD_SIZE];
        for(int i = 0; i < chess.length; i++)
        {
            chess[i] = -1;
        }
        int row, column, rd, old;
        int count = 0;
        //initializes row starting at 0, runs until row is less than 0
        for(row = 0; row >= 0;)
        {
            column = chess[row];
            while (true)
            {
                if(++column == BOARD_SIZE)
                {
                    chess[row--] = -1;
                }
                else
                {
                    for(rd = 1; rd <= row; rd++)
                    {
                        //First condition checks if column is same. Second condition checks if col diag right is death. Third checks if col diag left is death
                        if((old = chess[row-rd]) == column || old == column+rd || old == column-rd)
                        {
                            break; //FAILED SPACE FOUND | Increments column. 
                        }
                    }
                    if(rd <= row) //valid placement is found. Rd is only used to represent for loop went through all checks
                    {
                        continue;
                    }
                    if(row == BOARD_SIZE - 1) //Row is equal to 7 when a solution is present
                    {
                        count++; //increments solution count
                        row--; //decrements row back to 6
                        display(chess, count);
                    }
                    else
                    {
                        chess[row++] = column; //Moves to the next row! Piece is placed at (row, column)
                    }
                }
                break; //returns to primary loop that ends if row is less than 0, which occurs when all solutions are found
            }
        }
        System.out.println("Solutions = " + count);
        long endTime = Calendar.getInstance().getTimeInMillis();
        System.out.println("Time taken: " + (endTime - startTime) + " ms");
    }
}
