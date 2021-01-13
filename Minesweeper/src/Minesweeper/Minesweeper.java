//NicholasSouza

package Minesweeper;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Minesweeper {
    
    public final static int TILESIZE = 49;
    public final static int WINDOWWIDTH = TILESIZE * 20 + 20, WINDOWHEIGHT = TILESIZE * 15 + 50;
    public static Tile[][] tiles;
    public static GameBoard board;
    
    public static void main(String args[])
    {
        
        //GUI to house the game
        JFrame window = new JFrame();
        
        //Initializes proportions of the window with arbitrary size
        window.setVisible(true);
        window.setSize(WINDOWWIDTH, WINDOWHEIGHT);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setTitle("Minesweeper");
        
        //Creates a board for the game and puts it into the window
        board = new GameBoard();
        window.add(board);
        
        //Attaches a mouse listener to the window
        BoardMouseListener ml = new BoardMouseListener();
        window.addMouseListener(ml);
        
        //Initializes the game board on the back-end
        initBoard();
        
    }//End of main
    
    static void initBoard()
    {
        
        tiles = new Tile[20][15];
        
        for(int x = 0 ; x < tiles.length ; x++)
        {
            for(int y = 0 ; y < tiles[x].length ; y++)
            {
                //Defines tiles with a 10% chance of being a mine
                if(Math.random() * 100 < 15){
                    tiles[x][y] = new Tile(true);
                } else {
                    tiles[x][y] = new Tile(false);
                }//End of mine randomizer
                
            }//End of y loop
        }//End of x loop
        
        //Calculates the number of mines surrounding a tile
        //This must be done after defining the tiles to avoid null pointers
        for(int x = 0 ; x < tiles.length ; x++)
        {
            for(int y = 0 ; y < tiles[x].length ; y++)
            {
                
                    tiles[x][y].calcMines(x, y);
                
            }//End of y loop
        }//End of x loop
        
    }//End of initBoard
    
    public static void endGame()
    {
        //Prompts the user to play again and stores their decision in choice
        JOptionPane options = new JOptionPane();
        int choice = options.showConfirmDialog(board, "Game Over. Play Again?");
        
        //If the user selects yes, resets the board
        if(choice == options.YES_OPTION)
        {
            initBoard();
            board.repaint();
        }//End of yes check
        
        //Exits the program if the user does not want to play again
        if(choice == options.NO_OPTION)
        {
            System.exit(0);
        }//End of no check
        
    }//End of endGame
    
}//End of class
