// Attached: Lab8java
// =================================================================================================
// Program: Lab8
// =================================================================================================
// Programmer: Aiden Sallows, Spencer Glenn, Sebastian Montoya, Osman Gamez
// Class: CS4A - MTWTH 1:30 - 3:00 PM
// =================================================================================================
// Description:
//  This program generates a chessboard that solves the 8 queen logic problem by generating all 
//  solutions and displaying them.
// =================================================================================================
//Calender class used to track runtime of the code
import java.util.Calendar;

public class CS4A_Queens_Project {
    //Determines size of board. Board will always be a square (Ex. 1x1, 2x2, 3x3)
    static final int BOARD_SIZE = 8;
    
    //Display function that outputs a singular solution and solution number
    //Created by Osman Gamez
    public static void display(int[] chess, int counter) 
    {
        System.out.println("Displaying solution #" + counter);
         //for each index in array
        for(int i = 0; i < BOARD_SIZE; i++)
        { 
            //for each possible value array can hold
            for(int j = 0; j < BOARD_SIZE; j++) 
            {
                //checks if queen is at position j, if it is, outputs Q, else outputs blank
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
        //initial code created by Sebestian Gamez

        //grabs current time when code begins running
        long startTime = Calendar.getInstance().getTimeInMillis();
        //singular array to hold row and column that queens are placed.
        //index determines row, value determines column
        //For example: (3,6) is stored as chess[3] = 6
        int[] chess = new int [BOARD_SIZE];
        //Initializes array to contain the value -1.
        //This indicates an empty space, whereas values 0-7 represent full spaces
        for(int i = 0; i < chess.length; i++)
        {
            chess[i] = -1;
        }

        //row : int | row where queen is placed
        //column : int | column where queen is placed
        //rowDiagonal : int | iterative
        //oldQueen : int | used to track previously placed queens 
        int row, column, rowDiagonal, oldQueen;
        //counts number of solutions
        int count = 0;
        //initializes row starting at 0, runs until row is less than 0
        for(row = 0; row >= 0;)
        {
            //Moves column to the next possible space.
            column = chess[row];
            //Infinite while loop that breaks with a break statement.
            //While a valid space is not found, this loop iterates

            //Finding queen position Created by Aiden Sallows
            while (true)
            {
                //checks to see if column will go out of bounds
                //if it will, sets current space to not-filled, and moves back a row
                if(++column == BOARD_SIZE)
                {
                    chess[row--] = -1;
                }
                else
                {
                    //for each previously filled space, checks to see if any queens in previous rows will kill new queen
                    for(rowDiagonal = 1;rowDiagonal <= row;rowDiagonal++)
                    {
                        //First condition checks if column is same.
                        //Second condition checks if col diag right is death.
                        //Third checks if col diag left is death
                        if((oldQueen = chess[row-rowDiagonal]) == column || oldQueen == column+rowDiagonal || oldQueen == column-rowDiagonal)
                        {
                            break; //FAILED SPACE FOUND | moves to if(rowDiagonal <= row)
                        }
                    }
                    //conditional statements to continue solution finding created by: 
                     //if valid placement is not found.
                     //If this is false, that means for loop went through all checks,
                     // and the queen is safe to place.
                     //If true, queen is not safe to place, increments column

                     //Once queen position found Created by Spencer Glenn.
                     //if for loop was broken, continues while loop that goes to next column
                     //else continue
                    if(rowDiagonal <= row)
                    {
                        continue;
                    }
                    //If row is equal to 7, a solution is found.
                    //Increments solution count, decrements the row, and displays solution
                    if(row == BOARD_SIZE - 1) 
                    {
                        count++; //increments solution count
                        row--; //decrements row back to 6
                        display(chess, count);
                    }
                    //If solution is not complete
                    //Moves to the next row! Piece is placed at (row, column)
                    else
                    {
                        chess[row++] = column; 
                    }
                }
                //returns to primary loop that ends if row is less than 0,
                //which occurs when all solutions are found
                break; 
            }
        }
        //outputs number of solutions
        System.out.println("Solutions = " + count);
        //grabs end time of run time
        long endTime = Calendar.getInstance().getTimeInMillis();
        //outputs total elapsed milliseconds
        System.out.println("Time taken: " + (endTime - startTime) + " ms");
    }
}

/*=====================OUTPUT===========================================
Displaying solution #1
|Q| | | | | | | |
| | | | |Q| | | |
| | | | | | | |Q|
| | | | | |Q| | |
| | |Q| | | | | |
| | | | | | |Q| |
| |Q| | | | | | |
| | | | | | | | |

Displaying solution #2
|Q| | | | | | | |
| | | | | |Q| | |
| | | | | | | |Q|
| | |Q| | | | | |
| | | | | | |Q| |
| | | |Q| | | | |
| |Q| | | | | | |
| | | | | | | | |

Displaying solution #3
|Q| | | | | | | |
| | | | | | |Q| |
| | | |Q| | | | |
| | | | | |Q| | |
| | | | | | | |Q|
| |Q| | | | | | |
| | | | |Q| | | |
| | | | | | | | |


Displaying solution #4
|Q| | | | | | | |
| | | | | | |Q| |
| | | | |Q| | | |
| | | | | | | |Q|
| |Q| | | | | | |
| | | |Q| | | | |
| | | | | |Q| | |
| | | | | | | | |


Displaying solution #5
| |Q| | | | | | |
| | | |Q| | | | |
| | | | | |Q| | |
| | | | | | | |Q|
| | |Q| | | | | |
|Q| | | | | | | |
| | | | | | |Q| |
| | | | | | | | |


Displaying solution #6
| |Q| | | | | | |
| | | | |Q| | | |
| | | | | | |Q| |
|Q| | | | | | | |
| | |Q| | | | | |
| | | | | | | |Q|
| | | | | |Q| | |
| | | | | | | | |


Displaying solution #7
| |Q| | | | | | |
| | | | |Q| | | |
| | | | | | |Q| |
| | | |Q| | | | |
|Q| | | | | | | |
| | | | | | | |Q|
| | | | | |Q| | |
| | | | | | | | |


Displaying solution #8
| |Q| | | | | | |
| | | | | |Q| | |
|Q| | | | | | | |
| | | | | | |Q| |
| | | |Q| | | | |
| | | | | | | |Q|
| | |Q| | | | | |
| | | | | | | | |


Displaying solution #9
| |Q| | | | | | |
| | | | | |Q| | |
| | | | | | | |Q|
| | |Q| | | | | |
|Q| | | | | | | |
| | | |Q| | | | |
| | | | | | |Q| |
| | | | | | | | |


Displaying solution #10
| |Q| | | | | | |
| | | | | | |Q| |
| | |Q| | | | | |
| | | | | |Q| | |
| | | | | | | |Q|
| | | | |Q| | | |
|Q| | | | | | | |
| | | | | | | | |


Displaying solution #11
| |Q| | | | | | |
| | | | | | |Q| |
| | | | |Q| | | |
| | | | | | | |Q|
|Q| | | | | | | |
| | | |Q| | | | |
| | | | | |Q| | |
| | | | | | | | |


Displaying solution #12
| |Q| | | | | | |
| | | | | | | |Q|
| | | | | |Q| | |
|Q| | | | | | | |
| | |Q| | | | | |
| | | | |Q| | | |
| | | | | | |Q| |
| | | | | | | | |


Displaying solution #13
| | |Q| | | | | |
|Q| | | | | | | |
| | | | | | |Q| |
| | | | |Q| | | |
| | | | | | | |Q|
| |Q| | | | | | |
| | | |Q| | | | |
| | | | | | | | |


Displaying solution #14
| | |Q| | | | | |
| | | | |Q| | | |
| |Q| | | | | | |
| | | | | | | |Q|
|Q| | | | | | | |
| | | | | | |Q| |
| | | |Q| | | | |
| | | | | | | | |


Displaying solution #15
| | |Q| | | | | |
| | | | |Q| | | |
| |Q| | | | | | |
| | | | | | | |Q|
| | | | | |Q| | |
| | | |Q| | | | |
| | | | | | |Q| |
| | | | | | | | |


Displaying solution #16
| | |Q| | | | | |
| | | | |Q| | | |
| | | | | | |Q| |
|Q| | | | | | | |
| | | |Q| | | | |
| |Q| | | | | | |
| | | | | | | |Q|
| | | | | | | | |


Displaying solution #17
| | |Q| | | | | |
| | | | |Q| | | |
| | | | | | | |Q|
| | | |Q| | | | |
|Q| | | | | | | |
| | | | | | |Q| |
| |Q| | | | | | |
| | | | | | | | |


Displaying solution #18
| | |Q| | | | | |
| | | | | |Q| | |
| |Q| | | | | | |
| | | | |Q| | | |
| | | | | | | |Q|
|Q| | | | | | | |
| | | | | | |Q| |
| | | | | | | | |


Displaying solution #19
| | |Q| | | | | |
| | | | | |Q| | |
| |Q| | | | | | |
| | | | | | |Q| |
|Q| | | | | | | |
| | | |Q| | | | |
| | | | | | | |Q|
| | | | | | | | |


Displaying solution #20
| | |Q| | | | | |
| | | | | |Q| | |
| |Q| | | | | | |
| | | | | | |Q| |
| | | | |Q| | | |
|Q| | | | | | | |
| | | | | | | |Q|
| | | | | | | | |


Displaying solution #21
| | |Q| | | | | |
| | | | | |Q| | |
| | | |Q| | | | |
|Q| | | | | | | |
| | | | | | | |Q|
| | | | |Q| | | |
| | | | | | |Q| |
| | | | | | | | |


Displaying solution #22
| | |Q| | | | | |
| | | | | |Q| | |
| | | |Q| | | | |
| |Q| | | | | | |
| | | | | | | |Q|
| | | | |Q| | | |
| | | | | | |Q| |
| | | | | | | | |


Displaying solution #23
| | |Q| | | | | |
| | | | | |Q| | |
| | | | | | | |Q|
|Q| | | | | | | |
| | | |Q| | | | |
| | | | | | |Q| |
| | | | |Q| | | |
| | | | | | | | |


Displaying solution #24
| | |Q| | | | | |
| | | | | |Q| | |
| | | | | | | |Q|
|Q| | | | | | | |
| | | | |Q| | | |
| | | | | | |Q| |
| |Q| | | | | | |
| | | | | | | | |


Displaying solution #25
| | |Q| | | | | |
| | | | | |Q| | |
| | | | | | | |Q|
| |Q| | | | | | |
| | | |Q| | | | |
|Q| | | | | | | |
| | | | | | |Q| |
| | | | | | | | |


Displaying solution #26
| | |Q| | | | | |
| | | | | | |Q| |
| |Q| | | | | | |
| | | | | | | |Q|
| | | | |Q| | | |
|Q| | | | | | | |
| | | |Q| | | | |
| | | | | | | | |


Displaying solution #27
| | |Q| | | | | |
| | | | | | |Q| |
| |Q| | | | | | |
| | | | | | | |Q|
| | | | | |Q| | |
| | | |Q| | | | |
|Q| | | | | | | |
| | | | | | | | |


Displaying solution #28
| | |Q| | | | | |
| | | | | | | |Q|
| | | |Q| | | | |
| | | | | | |Q| |
|Q| | | | | | | |
| | | | | |Q| | |
| |Q| | | | | | |
| | | | | | | | |


Displaying solution #29
| | | |Q| | | | |
|Q| | | | | | | |
| | | | |Q| | | |
| | | | | | | |Q|
| |Q| | | | | | |
| | | | | | |Q| |
| | |Q| | | | | |
| | | | | | | | |


Displaying solution #30
| | | |Q| | | | |
|Q| | | | | | | |
| | | | |Q| | | |
| | | | | | | |Q|
| | | | | |Q| | |
| | |Q| | | | | |
| | | | | | |Q| |
| | | | | | | | |


Displaying solution #31
| | | |Q| | | | |
| |Q| | | | | | |
| | | | |Q| | | |
| | | | | | | |Q|
| | | | | |Q| | |
|Q| | | | | | | |
| | |Q| | | | | |
| | | | | | | | |


Displaying solution #32
| | | |Q| | | | |
| |Q| | | | | | |
| | | | | | |Q| |
| | |Q| | | | | |
| | | | | |Q| | |
| | | | | | | |Q|
|Q| | | | | | | |
| | | | | | | | |


Displaying solution #33
| | | |Q| | | | |
| |Q| | | | | | |
| | | | | | |Q| |
| | |Q| | | | | |
| | | | | |Q| | |
| | | | | | | |Q|
| | | | |Q| | | |
| | | | | | | | |


Displaying solution #34
| | | |Q| | | | |
| |Q| | | | | | |
| | | | | | |Q| |
| | | | |Q| | | |
|Q| | | | | | | |
| | | | | | | |Q|
| | | | | |Q| | |
| | | | | | | | |


Displaying solution #35
| | | |Q| | | | |
| |Q| | | | | | |
| | | | | | | |Q|
| | | | |Q| | | |
| | | | | | |Q| |
|Q| | | | | | | |
| | |Q| | | | | |
| | | | | | | | |


Displaying solution #36
| | | |Q| | | | |
| |Q| | | | | | |
| | | | | | | |Q|
| | | | | |Q| | |
|Q| | | | | | | |
| | |Q| | | | | |
| | | | |Q| | | |
| | | | | | | | |


Displaying solution #37
| | | |Q| | | | |
| | | | | |Q| | |
|Q| | | | | | | |
| | | | |Q| | | |
| |Q| | | | | | |
| | | | | | | |Q|
| | |Q| | | | | |
| | | | | | | | |


Displaying solution #38
| | | |Q| | | | |
| | | | | |Q| | |
| | | | | | | |Q|
| |Q| | | | | | |
| | | | | | |Q| |
|Q| | | | | | | |
| | |Q| | | | | |
| | | | | | | | |


Displaying solution #39
| | | |Q| | | | |
| | | | | |Q| | |
| | | | | | | |Q|
| | |Q| | | | | |
|Q| | | | | | | |
| | | | | | |Q| |
| | | | |Q| | | |
| | | | | | | | |


Displaying solution #40
| | | |Q| | | | |
| | | | | | |Q| |
|Q| | | | | | | |
| | | | | | | |Q|
| | | | |Q| | | |
| |Q| | | | | | |
| | | | | |Q| | |
| | | | | | | | |


Displaying solution #41
| | | |Q| | | | |
| | | | | | |Q| |
| | |Q| | | | | |
| | | | | | | |Q|
| |Q| | | | | | |
| | | | |Q| | | |
|Q| | | | | | | |
| | | | | | | | |


Displaying solution #42
| | | |Q| | | | |
| | | | | | |Q| |
| | | | |Q| | | |
| |Q| | | | | | |
| | | | | |Q| | |
|Q| | | | | | | |
| | |Q| | | | | |
| | | | | | | | |


Displaying solution #43
| | | |Q| | | | |
| | | | | | |Q| |
| | | | |Q| | | |
| | |Q| | | | | |
|Q| | | | | | | |
| | | | | |Q| | |
| | | | | | | |Q|
| | | | | | | | |


Displaying solution #44
| | | |Q| | | | |
| | | | | | | |Q|
|Q| | | | | | | |
| | |Q| | | | | |
| | | | | |Q| | |
| |Q| | | | | | |
| | | | | | |Q| |
| | | | | | | | |


Displaying solution #45
| | | |Q| | | | |
| | | | | | | |Q|
|Q| | | | | | | |
| | | | |Q| | | |
| | | | | | |Q| |
| |Q| | | | | | |
| | | | | |Q| | |
| | | | | | | | |


Displaying solution #46
| | | |Q| | | | |
| | | | | | | |Q|
| | | | |Q| | | |
| | |Q| | | | | |
|Q| | | | | | | |
| | | | | | |Q| |
| |Q| | | | | | |
| | | | | | | | |


Displaying solution #47
| | | | |Q| | | |
|Q| | | | | | | |
| | | |Q| | | | |
| | | | | |Q| | |
| | | | | | | |Q|
| |Q| | | | | | |
| | | | | | |Q| |
| | | | | | | | |


Displaying solution #48
| | | | |Q| | | |
|Q| | | | | | | |
| | | | | | | |Q|
| | | |Q| | | | |
| |Q| | | | | | |
| | | | | | |Q| |
| | |Q| | | | | |
| | | | | | | | |


Displaying solution #49
| | | | |Q| | | |
|Q| | | | | | | |
| | | | | | | |Q|
| | | | | |Q| | |
| | |Q| | | | | |
| | | | | | |Q| |
| |Q| | | | | | |
| | | | | | | | |


Displaying solution #50
| | | | |Q| | | |
| |Q| | | | | | |
| | | |Q| | | | |
| | | | | |Q| | |
| | | | | | | |Q|
| | |Q| | | | | |
|Q| | | | | | | |
| | | | | | | | |


Displaying solution #51
| | | | |Q| | | |
| |Q| | | | | | |
| | | |Q| | | | |
| | | | | | |Q| |
| | |Q| | | | | |
| | | | | | | |Q|
| | | | | |Q| | |
| | | | | | | | |


Displaying solution #52
| | | | |Q| | | |
| |Q| | | | | | |
| | | | | |Q| | |
|Q| | | | | | | |
| | | | | | |Q| |
| | | |Q| | | | |
| | | | | | | |Q|
| | | | | | | | |


Displaying solution #53
| | | | |Q| | | |
| |Q| | | | | | |
| | | | | | | |Q|
|Q| | | | | | | |
| | | |Q| | | | |
| | | | | | |Q| |
| | |Q| | | | | |
| | | | | | | | |


Displaying solution #54
| | | | |Q| | | |
| | |Q| | | | | |
|Q| | | | | | | |
| | | | | |Q| | |
| | | | | | | |Q|
| |Q| | | | | | |
| | | |Q| | | | |
| | | | | | | | |


Displaying solution #55
| | | | |Q| | | |
| | |Q| | | | | |
|Q| | | | | | | |
| | | | | | |Q| |
| |Q| | | | | | |
| | | | | | | |Q|
| | | | | |Q| | |
| | | | | | | | |


Displaying solution #56
| | | | |Q| | | |
| | |Q| | | | | |
| | | | | | | |Q|
| | | |Q| | | | |
| | | | | | |Q| |
|Q| | | | | | | |
| | | | | |Q| | |
| | | | | | | | |


Displaying solution #57
| | | | |Q| | | |
| | | | | | |Q| |
|Q| | | | | | | |
| | |Q| | | | | |
| | | | | | | |Q|
| | | | | |Q| | |
| | | |Q| | | | |
| | | | | | | | |


Displaying solution #58
| | | | |Q| | | |
| | | | | | |Q| |
|Q| | | | | | | |
| | | |Q| | | | |
| |Q| | | | | | |
| | | | | | | |Q|
| | | | | |Q| | |
| | | | | | | | |


Displaying solution #59
| | | | |Q| | | |
| | | | | | |Q| |
| |Q| | | | | | |
| | | |Q| | | | |
| | | | | | | |Q|
|Q| | | | | | | |
| | |Q| | | | | |
| | | | | | | | |


Displaying solution #60
| | | | |Q| | | |
| | | | | | |Q| |
| |Q| | | | | | |
| | | | | |Q| | |
| | |Q| | | | | |
|Q| | | | | | | |
| | | |Q| | | | |
| | | | | | | | |


Displaying solution #61
| | | | |Q| | | |
| | | | | | |Q| |
| |Q| | | | | | |
| | | | | |Q| | |
| | |Q| | | | | |
|Q| | | | | | | |
| | | | | | | |Q|
| | | | | | | | |


Displaying solution #62
| | | | |Q| | | |
| | | | | | |Q| |
| | | |Q| | | | |
|Q| | | | | | | |
| | |Q| | | | | |
| | | | | | | |Q|
| | | | | |Q| | |
| | | | | | | | |


Displaying solution #63
| | | | |Q| | | |
| | | | | | | |Q|
| | | |Q| | | | |
|Q| | | | | | | |
| | |Q| | | | | |
| | | | | |Q| | |
| |Q| | | | | | |
| | | | | | | | |


Displaying solution #64
| | | | |Q| | | |
| | | | | | | |Q|
| | | |Q| | | | |
|Q| | | | | | | |
| | | | | | |Q| |
| |Q| | | | | | |
| | | | | |Q| | |
| | | | | | | | |


Displaying solution #65
| | | | | |Q| | |
|Q| | | | | | | |
| | | | |Q| | | |
| |Q| | | | | | |
| | | | | | | |Q|
| | |Q| | | | | |
| | | | | | |Q| |
| | | | | | | | |


Displaying solution #66
| | | | | |Q| | |
| |Q| | | | | | |
| | | | | | |Q| |
|Q| | | | | | | |
| | |Q| | | | | |
| | | | |Q| | | |
| | | | | | | |Q|
| | | | | | | | |


Displaying solution #67
| | | | | |Q| | |
| |Q| | | | | | |
| | | | | | |Q| |
|Q| | | | | | | |
| | | |Q| | | | |
| | | | | | | |Q|
| | | | |Q| | | |
| | | | | | | | |


Displaying solution #68
| | | | | |Q| | |
| | |Q| | | | | |
|Q| | | | | | | |
| | | | | | |Q| |
| | | | |Q| | | |
| | | | | | | |Q|
| |Q| | | | | | |
| | | | | | | | |


Displaying solution #69
| | | | | |Q| | |
| | |Q| | | | | |
|Q| | | | | | | |
| | | | | | | |Q|
| | | |Q| | | | |
| |Q| | | | | | |
| | | | | | |Q| |
| | | | | | | | |


Displaying solution #70
| | | | | |Q| | |
| | |Q| | | | | |
|Q| | | | | | | |
| | | | | | | |Q|
| | | | |Q| | | |
| |Q| | | | | | |
| | | |Q| | | | |
| | | | | | | | |


Displaying solution #71
| | | | | |Q| | |
| | |Q| | | | | |
| | | | |Q| | | |
| | | | | | |Q| |
|Q| | | | | | | |
| | | |Q| | | | |
| |Q| | | | | | |
| | | | | | | | |


Displaying solution #72
| | | | | |Q| | |
| | |Q| | | | | |
| | | | |Q| | | |
| | | | | | | |Q|
|Q| | | | | | | |
| | | |Q| | | | |
| |Q| | | | | | |
| | | | | | | | |


Displaying solution #73
| | | | | |Q| | |
| | |Q| | | | | |
| | | | | | |Q| |
| |Q| | | | | | |
| | | |Q| | | | |
| | | | | | | |Q|
|Q| | | | | | | |
| | | | | | | | |


Displaying solution #74
| | | | | |Q| | |
| | |Q| | | | | |
| | | | | | |Q| |
| |Q| | | | | | |
| | | | | | | |Q|
| | | | |Q| | | |
|Q| | | | | | | |
| | | | | | | | |


Displaying solution #75
| | | | | |Q| | |
| | |Q| | | | | |
| | | | | | |Q| |
| | | |Q| | | | |
|Q| | | | | | | |
| | | | | | | |Q|
| |Q| | | | | | |
| | | | | | | | |


Displaying solution #76
| | | | | |Q| | |
| | | |Q| | | | |
|Q| | | | | | | |
| | | | |Q| | | |
| | | | | | | |Q|
| |Q| | | | | | |
| | | | | | |Q| |
| | | | | | | | |


Displaying solution #77
| | | | | |Q| | |
| | | |Q| | | | |
| |Q| | | | | | |
| | | | | | | |Q|
| | | | |Q| | | |
| | | | | | |Q| |
|Q| | | | | | | |
| | | | | | | | |


Displaying solution #78
| | | | | |Q| | |
| | | |Q| | | | |
| | | | | | |Q| |
|Q| | | | | | | |
| | |Q| | | | | |
| | | | |Q| | | |
| |Q| | | | | | |
| | | | | | | | |


Displaying solution #79
| | | | | |Q| | |
| | | |Q| | | | |
| | | | | | |Q| |
|Q| | | | | | | |
| | | | | | | |Q|
| |Q| | | | | | |
| | | | |Q| | | |
| | | | | | | | |


Displaying solution #80
| | | | | |Q| | |
| | | | | | | |Q|
| |Q| | | | | | |
| | | |Q| | | | |
|Q| | | | | | | |
| | | | | | |Q| |
| | | | |Q| | | |
| | | | | | | | |


Displaying solution #81
| | | | | | |Q| |
|Q| | | | | | | |
| | |Q| | | | | |
| | | | | | | |Q|
| | | | | |Q| | |
| | | |Q| | | | |
| |Q| | | | | | |
| | | | | | | | |


Displaying solution #82
| | | | | | |Q| |
| |Q| | | | | | |
| | | |Q| | | | |
|Q| | | | | | | |
| | | | | | | |Q|
| | | | |Q| | | |
| | |Q| | | | | |
| | | | | | | | |


Displaying solution #83
| | | | | | |Q| |
| |Q| | | | | | |
| | | | | |Q| | |
| | |Q| | | | | |
|Q| | | | | | | |
| | | |Q| | | | |
| | | | | | | |Q|
| | | | | | | | |


Displaying solution #84
| | | | | | |Q| |
| | |Q| | | | | |
|Q| | | | | | | |
| | | | | |Q| | |
| | | | | | | |Q|
| | | | |Q| | | |
| |Q| | | | | | |
| | | | | | | | |


Displaying solution #85
| | | | | | |Q| |
| | |Q| | | | | |
| | | | | | | |Q|
| |Q| | | | | | |
| | | | |Q| | | |
|Q| | | | | | | |
| | | | | |Q| | |
| | | | | | | | |


Displaying solution #86
| | | | | | |Q| |
| | | |Q| | | | |
| |Q| | | | | | |
| | | | |Q| | | |
| | | | | | | |Q|
|Q| | | | | | | |
| | |Q| | | | | |
| | | | | | | | |


Displaying solution #87
| | | | | | |Q| |
| | | |Q| | | | |
| |Q| | | | | | |
| | | | | | | |Q|
| | | | | |Q| | |
|Q| | | | | | | |
| | |Q| | | | | |
| | | | | | | | |


Displaying solution #88
| | | | | | |Q| |
| | | | |Q| | | |
| | |Q| | | | | |
|Q| | | | | | | |
| | | | | |Q| | |
| | | | | | | |Q|
| |Q| | | | | | |
| | | | | | | | |


Displaying solution #89
| | | | | | | |Q|
| |Q| | | | | | |
| | | |Q| | | | |
|Q| | | | | | | |
| | | | | | |Q| |
| | | | |Q| | | |
| | |Q| | | | | |
| | | | | | | | |


Displaying solution #90
| | | | | | | |Q|
| |Q| | | | | | |
| | | | |Q| | | |
| | |Q| | | | | |
|Q| | | | | | | |
| | | | | | |Q| |
| | | |Q| | | | |
| | | | | | | | |


Displaying solution #91
| | | | | | | |Q|
| | |Q| | | | | |
|Q| | | | | | | |
| | | | | |Q| | |
| |Q| | | | | | |
| | | | |Q| | | |
| | | | | | |Q| |
| | | | | | | | |


Displaying solution #92
| | | | | | | |Q|
| | | |Q| | | | |
|Q| | | | | | | |
| | |Q| | | | | |
| | | | | |Q| | |
| |Q| | | | | | |
| | | | | | |Q| |
| | | | | | | | |


Solutions = 92
Time taken: 424 ms
 */