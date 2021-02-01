package tictactoe.game;

/**
 * Represents a tic-tac-toe board.
 *
 * @author Josh Archer
 * @version 1.0
 */
public class TicTacToe
{
    public static final int GRID_SIZE = 3;
    public static final int PLAYER_1 = 1;
    public static final int PLAYER_2 = 2;

    private int[][] board;
    private int previousPlayer = -1;

    /**
     * Creates a new 3x3 tic-tac-toe board.
     */
    public TicTacToe()
    {
        board = new int[GRID_SIZE][GRID_SIZE];
    }

    /**
     * Makes a move for the current player.
     *
     * @param player a player number (the integer 1 or 2)
     * @param row a row index from 0-2
     * @param col a column index from 0-2
     *
     * @throws IllegalArgumentException if the wrong player is given to the method,
     * the player number should alternate
     * @throws IndexOutOfBoundsException if an invalid row or columns is provided
     *
     * @return true if the move was successful, or false if not successful
     */
    public boolean makeMove(int player, int row, int col)
    {
        //make sure we have a valid player and row/col
        if (player != PLAYER_1 && player != PLAYER_2)
        {
            throw new IllegalArgumentException(
                    "Invalid player number given");
        }
        else if (row < 0 || row >= GRID_SIZE || col < 0 || col >= GRID_SIZE)
        {
            throw new IndexOutOfBoundsException(
                    "Bad index, r:" + row + ", c: " + col);
        }

        //make sure player turns alternate
        if (previousPlayer == -1)
        {
            previousPlayer = player;
        }
        else if (previousPlayer == player)
        {
            return false;
        }
        else
        {
            previousPlayer = player;
        }

        //make the move if there is not already a piece in that location
        if (board[row][col] == 0)
        {
            board[row][col] = player;
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * Returns a copy of the array that stores the board state for the tic-tac-toe
     * board.
     *
     * @return a 3x3 array of integers
     */
    public int[][] getBoard()
    {
        int[][] result = new int[GRID_SIZE][GRID_SIZE];

        for (int i = 0; i < result.length; i++)
        {
            for (int j = 0; j < result[i].length; j++)
            {
                result[i][j] = board[i][j];
            }
        }
        return result;
    }

    /**
     * Returns the winner of the game (1 or 2) or -1 if the game has not
     * completed.
     *
     * @return the winning player, or -1 if the match has not completed.
     */
    public int getWinner()
    {
        if (playerWins(PLAYER_1))
        {
            return PLAYER_1;
        }
        else if (playerWins(PLAYER_2))
        {
            return PLAYER_2;
        }
        return -1;
    }

    //checks if a player has won
    private boolean playerWins(int player)
    {
        //check rows
        for (int i = 0; i < GRID_SIZE; i++)
        {
            if (ownsRow(player, i) || ownsCol(player, i))
            {
                return true;
            }
        }

        return ownsDiagonal(player);
    }

    //checks whether a diagonal is owned by a single player
    private boolean ownsDiagonal(int player)
    {
        return (board[0][0] == player &&
                board[1][1] == player &&
                board[2][2] == player) ||
               (board[0][2] == player &&
                board[1][1] == player &&
                board[2][0] == player);
    }

    //checks whether a row is owned by a single player
    private boolean ownsRow(int player, int row)
    {
        return board[row][0] == player &&
                board[row][1] == player &&
                board[row][2] == player;
    }

    //checks whether a column is owned by a single player
    private boolean ownsCol(int player, int col)
    {
        return board[0][col] == player &&
                board[1][col] == player &&
                board[2][col] == player;
    }

    /**
     * Reports if the tic-tac-toe board is full or not.
     * @return true if the board is full, or false otherwise
     */
    public boolean isBoardFull()
    {
        for (int[] row : board)
        {
            for (int cell : row)
            {
                if (cell == 0)
                {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder();

        for (int[] row : board)
        {
            for (int cell : row)
            {
                if (cell != 0)
                {
                    builder.append(cell);
                    builder.append(" ");
                }
                else
                {
                    builder.append("_ ");
                }
            }
            builder.append("\n");
        }

        return builder.toString();
    }
}
