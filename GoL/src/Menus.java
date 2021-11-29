import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
/**
 * Pra2003
 * @author mongeese1
 * i6222534
 * inspired by canvas menus & alexander leonidas
 */

public class Menus implements ActionListener, ItemListener{
	private JFrame frame;
	private GameView gameView;
	private Game game;
	public Menus(Game game) {//menu constructor for a game
		this.game = game;
		this.gameView = new GameView(game);
	}
	void gui() //create gui
	{
		frame = new JFrame();
		frame.setTitle("Conway's Game of Life");
		frame.setContentPane(gameView);

		JMenuBar menuBar = new MainMenu(game, gameView, this, this);
		frame.setJMenuBar(menuBar);
			        
		final int menuHeight = 48;
		final int sx = 600;
		final int sy = 600;
		frame.setSize(sx, sy + menuHeight);  
		
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
