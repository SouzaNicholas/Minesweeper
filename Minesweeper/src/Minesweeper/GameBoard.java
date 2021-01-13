//NicholasSouza

package Minesweeper;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JComponent;

public class GameBoard extends JComponent{
    
    public void paintComponent(Graphics g)
    {
        
        g.setColor(new Color(255, 255, 255));
        g.fillRect(0, 0, Minesweeper.WINDOWWIDTH, Minesweeper.WINDOWHEIGHT);
        
        //This color is used for the tile outlines
        g.setColor(new Color(160, 160, 160));
        
        for(int x = 0 ; x < Minesweeper.tiles.length ; x++)
        {
            for(int y = 0 ; y < Minesweeper.tiles[x].length ; y++)
            {
                
                g.drawRect(x * Minesweeper.TILESIZE, y * Minesweeper.TILESIZE, Minesweeper.TILESIZE, Minesweeper.TILESIZE);
                
                if(Minesweeper.tiles[x][y] != null){
                    Minesweeper.tiles[x][y].drawTile(x * Minesweeper.TILESIZE + 1, y * Minesweeper.TILESIZE + 1, g);
                }//End of validity check
                
            }//End of y loop
        }//End of x loop
        
    }//End of paintComponent
    
}//End of class
