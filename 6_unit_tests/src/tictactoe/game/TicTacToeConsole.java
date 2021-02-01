package tictactoe.game;

import tictactoe.helpers.Console;

/**
 * Simulates a game of tic-tac-toe on the Java console.
 *
 * @author Josh Archer
 * @version 1.0
 */
public class TicTacToeConsole
{
    private static TicTacToe ticTacToe;
    private static int player = TicTacToe.PLAYER_2;

    /**
     * Starts a game of tic-tac-toe.
     * @param args command-line args (not used)
     */
    public static void main(String[] args)
    {
        //create a new game
        ticTacToe = new TicTacToe();

        //welcome the user
        System.out.println("Welcome to Tic Tac Toe");

        //play the game
        gameLoop();
        endGame();
    }

    //print the board, then announce the results
    private static void endGame()
    {
        System.out.println(ticTacToe.toString());
        System.out.println();

        int winner = ticTacToe.getWinner();
        if (winner != -1)
        {
            System.out.println("Player #" + winner + " wins the game!");
        }
        else
        {
            System.out.println("The game is a draw.");
        }
    }

    //primary game loop
    private static void gameLoop()
    {
        while (ticTacToe.getWinner() == -1 && !ticTacToe.isBoardFull())
        {
            System.out.println(ticTacToe.toString());
            System.out.println();

            //change the player
            player = (player == TicTacToe.PLAYER_1) ? TicTacToe.PLAYER_2 : TicTacToe.PLAYER_1;
            getPlayerChoice(player);
        }
    }

    //gets the next choice for the user
    private static void getPlayerChoice(int player)
    {
        int row = Console.getInt("Player #" + player + ": enter a row");
        int col = Console.getInt("Player #" + player + ": enter a col");

        boolean result = ticTacToe.makeMove(player, row, col);

        if (result)
        {
            System.out.println("Move successful");
        }
        else
        {
            System.out.println("Move unsuccessful");
        }
        System.out.println();
    }
}
