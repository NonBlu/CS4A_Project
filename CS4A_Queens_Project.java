public class CS4A_Queens_Project {

    public static void display(int[] chess) //Created by Aiden Sallows
    {
        for(int i = 0; i < chess.length; i++)
        {
            if(chess[i] == 0)
            {
                System.out.print("| ");
            }
            else if(chess[i] == 1)
            {
                System.out.print("|Q");
            }

            if((i + 1) % 8 == 0)
            {
                System.out.print("|\n");
            }
        }
    }
    public static void main(String[] arg) {

        int[] chess = new int [64];
        chess[34] = 1;
        chess[16] = 1;

        display(chess);
    }
}
