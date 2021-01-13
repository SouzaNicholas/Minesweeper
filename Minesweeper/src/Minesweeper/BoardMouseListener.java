//NicholasSouza

package Minesweeper;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class BoardMouseListener implements MouseListener{

    public void mouseClicked(MouseEvent e) {
        
        int x = (e.getX() - 10) / Minesweeper.TILESIZE;
        int y = (e.getY() - 35) / Minesweeper.TILESIZE;
        
        //Stores whether every safe tile has been checked
        boolean gameOver = false;
        
        //Stops to see if the tile has been revealed or flagged before revealing it
        if(!Minesweeper.tiles[x][y].isRevealed){
            Minesweeper.tiles[x][y].reveal(x, y);
            
            Minesweeper.board.repaint();
        
            //Ends the game if the player selectes a mine
            if(Minesweeper.tiles[x][y].isMine){
                gameOver = true;
            }//End of gameOver check
            //Only checks to see if all mines have been found
            //if the player didn't click a mine
            else {
            
                //Assumes the game is over unless a tile is found that contradicts it
                gameOver = true;
                //Checks to see if any unrevealed tiles aren't mines
                //If there are, the game is still being played.
                for(int tileX = 0 ; tileX < Minesweeper.tiles.length ; tileX++){
                    for(int tileY = 0 ; tileY < Minesweeper.tiles[tileX].length ; tileY++){

                        if(!Minesweeper.tiles[tileX][tileY].isRevealed
                                && !Minesweeper.tiles[tileX][tileY].isMine)
                        {
                            gameOver = false;
                        }//End of unrevealed safe tile check

                    }//End of tileY loop
                }//End of tileX loop
            }//End of else check
            
        }//End of redundancy check
        
        if(gameOver)
        {
            Minesweeper.endGame();
        }//End of end game check
        
    }//End of mouseClicked

    //UNUSED ABSTRACT METHODS
    public void mousePressed(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
    //END OF UNUSED ABSTRACT METHODS
    
}//End of class
