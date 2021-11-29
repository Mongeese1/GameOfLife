
import java.io.*;
import javax.swing.*;
/**
 * Pra2003
 * @author mongeese1
 * code inspired by canvas, michal Kalbarcyzk 
 * & Alexander Leonidas with whom I collaborated on homework tasks
 */
import javax.swing.JFrame;
public class GoL {
    public static void main(String[] args) throws Exception, Exception {

      Game g = new Game(20,20);
      g.save();
//      System.out.println(g);
      if(new File("save.txt").exists()) {//test the save and load feature
    	  g.load();
    	  }
      else {
    	  System.out.println("file not found");
      }
     
      g.state().addPattern(new Glider());

      System.out.println(g);
      gui(g);
      }
    public static void gui(Game g) {//didnt get the time to implement the menus, so create gui here
        JFrame frame = new JFrame("Conway's Game of Life");
        frame.add(new GameView(g));
        frame.setSize(805, 810);        
        frame.setLocationRelativeTo(null);        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);        
        frame.setVisible(true);
    }
    //window resize is functional, iteration is broken, click works. maybe issue with rules?
      

}
