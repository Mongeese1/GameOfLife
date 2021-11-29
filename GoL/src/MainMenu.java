import java.awt.event.ActionListener;
import java.awt.event.ItemListener;

import javax.swing.*;


public class MainMenu extends JMenuBar {

	/**
	 * Pra2003
	 * @author mongeese1
	 * inspired by canvas menus
	 */
	private static final long serialVersionUID = -2379563053865355422L;

    public MainMenu
    (final Game game, final GameView gameView, 
    		final ActionListener al, final ItemListener il) {
    	JMenuItem menuItem;
    	JMenu subMenu;
    	ButtonGroup group;
    	
    	//navigation bar
    	 
    	JMenu menu = new JMenu("Game of Life"); //Create the menu
         this.add(menu);
         menuItem = new JMenuItem("About");//create about 
         menuItem.addActionListener(al);
         menu.add(menuItem);

         menu.addSeparator();

 	    menuItem = new JMenuItem("Load");//create load
 	    menuItem.addActionListener(al);
 	    menu.add(menuItem);

 	    menuItem = new JMenuItem("Save");//create load
 	    menuItem.addActionListener(al);
 	    menu.add(menuItem);
 	   //game menu
 	    menu.addSeparator();
 	   
 	    
 	     menu = new JMenu("Game");
 	    this.add(menu);
 	
 	    menuItem = new JMenuItem("Start");//start game
 	    menuItem.addActionListener(al);
 	    menu.add(menuItem);
 	
 	    menuItem = new JMenuItem("Stop");//stop game
 	    menuItem.addActionListener(al);
 	    menu.add(menuItem);

    	    menu.addSeparator();

 	    menuItem = new JMenuItem("Iterate");//iterate game
 	    menuItem.addActionListener(al);
 	    menu.add(menuItem);

    	    menu.addSeparator();
    	    subMenu = new JMenu("Speed");//adjust tick speed
    	    group = new ButtonGroup();
    	    for (double ms = 12.5; ms <= 10000; ms *= 2) 
            {
    	    	final String str = (int)ms + "ms";
    	     	JRadioButtonMenuItem rbMenuItem = new JRadioButtonMenuItem(str);
    	    	rbMenuItem.setSelected(100 == ms);
    	    	rbMenuItem.addItemListener(il);
    	    	group.add(rbMenuItem);
    	    	subMenu.add(rbMenuItem);    
    	    }
    	    menu.add(subMenu);

    	
    	
    
    }
    
}