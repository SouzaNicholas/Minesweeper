//NicholasSouza

package Minesweeper;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.ImageIcon;

public class Tile {
    
    public boolean isMine = false;      //Stores whether this tile has a mine or not
    public boolean isRevealed = false;  //Stores whether this tile has already been clicked
    int mines = 0;                      //Keeps track of adjacent mines
    
    public Tile(boolean isMine)
    {
        
        this.isMine = isMine;
        
    }//End of Tile(boolean)
    
    void reveal(int posX, int posY)
    {
        
        isRevealed = true;
        
        //Checks to see if the tiles has no mines nearby.
        //If so, all adjacent tiles are revealed.
        //Otherwise, the player would make all of those moves manually.
        if(mines == 0)
        {

            if(posX > 0
                    && posY > 0
                    && !Minesweeper.tiles[posX - 1][posY - 1].isRevealed)
            {
                Minesweeper.tiles[posX - 1][posY - 1].reveal(posX - 1, posY - 1);
            }//End of top-left check

            if(posY > 0
                    && !Minesweeper.tiles[posX][posY - 1].isRevealed)
            {
                Minesweeper.tiles[posX][posY - 1].reveal(posX, posY - 1);
            }//End of top-center check

            if(posX < Minesweeper.tiles.length - 1
                    && posY > 0
                    && !Minesweeper.tiles[posX + 1][posY - 1].isRevealed)
            {
                Minesweeper.tiles[posX + 1][posY - 1].reveal(posX + 1, posY - 1);
            }//End of top-right check

            if(posX > 0
                    && !Minesweeper.tiles[posX - 1][posY].isRevealed)
            {
                Minesweeper.tiles[posX - 1][posY].reveal(posX - 1, posY);
            }//End of mid-left check

            if(posX < Minesweeper.tiles.length - 1
                    && !Minesweeper.tiles[posX + 1][posY].isRevealed)
            {
                Minesweeper.tiles[posX + 1][posY].reveal(posX + 1, posY);
            }//End of mid-right check

            if(posX > 0
                    && posY < Minesweeper.tiles[posX].length - 1
                    && !Minesweeper.tiles[posX - 1][posY + 1].isRevealed)
            {
                Minesweeper.tiles[posX - 1][posY + 1].reveal(posX - 1, posY + 1);
            }//End of bottom-left check

            if(posY > 0
                    && posY < Minesweeper.tiles[posX].length - 1
                    && !Minesweeper.tiles[posX][posY + 1].isRevealed)
            {
                Minesweeper.tiles[posX][posY + 1].reveal(posX, posY + 1);
            }//End of bottom-center check

            if(posX < Minesweeper.tiles.length - 1
                    && posY < Minesweeper.tiles[posX].length - 1
                    && !Minesweeper.tiles[posX + 1][posY + 1].isRevealed)
            {
                Minesweeper.tiles[posX + 1][posY + 1].reveal(posX + 1, posY + 1);
            }//End of bottom-right check

        }//End of empty tile check
        
    }//End of reveal
    
    //Manually checks each surrounding tile
    //Built to avoid index out of bounds exceptions
    void calcMines(int posX, int posY)
    {
        
        if(posX > 0
                && posY > 0
                && Minesweeper.tiles[posX - 1][posY - 1].isMine)
        {
            mines++;
        }//End of top-left check
        
        if(posY > 0
                && Minesweeper.tiles[posX][posY - 1].isMine)
        {
            mines++;
        }//End of top-center check

        if(posX < Minesweeper.tiles.length - 1
                && posY > 0
                && Minesweeper.tiles[posX + 1][posY - 1].isMine)
        {
            mines++;
        }//End of top-right check
        
        if(posX > 0
                && Minesweeper.tiles[posX - 1][posY].isMine)
        {
            mines++;
        }//End of mid-left check
        
        if(posX < Minesweeper.tiles.length - 1
                && Minesweeper.tiles[posX + 1][posY].isMine)
        {
            mines++;
        }//End of mid-right check
        
        if(posX > 0
                && posY < Minesweeper.tiles[posX].length - 1
                && Minesweeper.tiles[posX - 1][posY + 1].isMine)
        {
            mines++;
        }//End of bottom-left check
        
        if(posY < Minesweeper.tiles[posX].length - 1
                && Minesweeper.tiles[posX][posY + 1].isMine)
        {
            mines++;
        }//End of bottom-center check
        
        if(posX < Minesweeper.tiles.length - 1
                && posY < Minesweeper.tiles[posX].length - 1
                && Minesweeper.tiles[posX + 1][posY + 1].isMine)
        {
            mines++;
        }//End of bottom-right check
        
    }//End of calcMines
    
    public void drawTile(int posX, int posY, Graphics g){
        
        ImageIcon img;
        
        if(!this.isRevealed){
            img = new ImageIcon("tile.png");
        } else if(this.isMine){
            img = new ImageIcon("mine.png");
        } else {
            img = new ImageIcon(mines + ".png");
        }//End of tile image definition
        
        g.drawImage(img.getImage(), posX, posY, null);
        
    }//End of drawTile
    
}//End of class
