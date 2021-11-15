package lab4;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class MouseTester extends MousePanel {
	
	
	public static void gui(){        
		final JFrame frame = new JFrame("Mouse Tester");        
		frame.add(new MousePanel());        
		frame.setSize(600, 600);        
		frame.setLocationRelativeTo(null);        
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);        
		frame.setVisible(true);
	}

}
class MousePanel extends JPanel implements MouseListener, MouseMotionListener{
	Point mousedown,mouseup;
	public MousePanel()
	{    addMouseListener(this);   
	addMouseMotionListener(this);
	}


	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		mouseup = arg0.getLocationOnScreen();
		repaint();
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		mousedown = arg0.getLocationOnScreen();
		repaint();
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
				
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		mousedown = null;
		mouseup=null;
	}
	@Override
	public void paint(Graphics g){
		g.setColor(new Color(255, 255, 255));
		g.fillRect(0, 0, getWidth(), getHeight());
		if (mousedown != null){
			g.setColor(new Color(255,0,0));
			g.fillOval(mousedown.x-5,mousedown.y-5,9,9);
			repaint();
		}
		if(mouseup !=null) {
			g.setColor(new Color(0,0,255));
			g.fillOval(mousedown.x-5,mousedown.y-5,9,9);
			repaint();
		}
	}
	}
	


