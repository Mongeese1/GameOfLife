import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.*;
/**
 * Pra2003
 * @author mongeese1
 * i6222534
 */

public class GameView extends JPanel implements 
	MouseListener,MouseMotionListener{
	private Game game;
	private int ms = 100;//game speed
	private boolean showGrid = false;

	/**
	 * Generated serial ID
	 */
	private static final long serialVersionUID = -3803288123172388914L;
	//constructor for GameView class
	public GameView(Game game) {
		this.game = game;
		addMouseListener(this);
		addMouseMotionListener(this);
	}
	public boolean showGrid() {
		return showGrid();
	}
	public void iterate() {
		game.iterate();
		}
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		game.iterate();
		repaint();
		
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		//put this here too, mousedrag functionality not working on my machine
		//can't seem to make iteration work
//		game.iterate();repaint();
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// check size and mouse position and repaint on click
	    final int columns = game.state().grid.get(0).size(); 
        final int rows = game.state().grid.size(); 
        final int cellHeight = e.getY()/(getHeight()/rows); 
        final int cellWidth = e.getX()/(getWidth()/columns);

        game.state().clickCell(cellHeight,cellWidth);
        repaint();
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	
	}
	@Override
    public void paint(Graphics g){
        int columns = game.state().grid.get(0).size(); // Get the column size
        int rows = game.state().grid.size(); // Get the row size
        // Get the minimum value of the ratio of pixels to grid size
        int m = Math.min(((getWidth()) / columns), ((getHeight()) / rows));

        g.setColor(Color.white);
        g.fillRect(0, 0, getWidth(), getHeight());  

        for (int row = 0; row < rows; row++){
            for (int col = 0; col < columns; col++){
                // Get the x and y pos of the corresponding grid index
                final int x = col * m + (getWidth() - (m*columns)) / 2;
                final int y = row * m + (getHeight() - (m*rows)) / 2;
                int value = game.state().grid.get(row).get(col);
                if (value == 0) {
                    g.setColor(Color.black);
                    g.fillRoundRect(x - 1, y - 1, m - 1, m - 1, 100, 100); // Draw a cell
                } else if (value == 1) {
                        g.setColor(Color.red);
                        g.fillRoundRect(x, y, m, m, 100, 100);
                        g.setColor(Color.red);
                        g.fillRoundRect(x - 1, y - 1, m - 1, m - 1, 100, 100);
                }
            }
        }
    }
	//getters and setters
	public void setms(int ms) {
		this.ms = ms;
	}
	public int getms() {
		// TODO Auto-generated method stub
		return ms;
	}
	/**
	 * @return the showGrid
	 */
	public boolean ShowGrid() {
		return showGrid;
	}
	/**
	 * @param showGrid the showGrid to set
	 */
	public void setShowGrid(boolean showGrid) {
		this.showGrid = showGrid;
	}

}
