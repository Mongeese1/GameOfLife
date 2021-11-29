//import java.util.*;
/**
 * Pra2003
 * @author mongeese1
 * i6222534
 */
import java.io.*;
public class Game {
	   State state = null;
	    private Rules_B3_S23 RulesB3S23 = new Rules_B3_S23();
	    private final String fileName;

	    public Game(final int row, final int col) {
	    	
	        if (row <= 0 || col <= 0) {
	            System.out.println("Cannot have negative grid size!");
	        } else {
	            setState(new State(row, col));
	        }
	        this.fileName = "save.txt";
	    }
	    public void load() throws BadFileFormatException, IOException {
	        if (!fileName.contains(".txt")) { // If the file is not a .txt file
	            throw new BadFileFormatException("File type not supported");
	        } else {
	            System.out.println("Loading game...");
	            try (final BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));) {
	                final String rule = in.readLine(); // First line is the rule set
	                in.mark(10000); // Mark the position in order to return back to it later
	                String line = in.readLine();
	                final int colSize = line.length(); // Get the coulumn size
	                int rowSize = 0; // Set to this becasue there are 2 extra lines in the .txt
	                // Count the number of rows
	                while (line != null) {
	                    rowSize++;
	                    line = in.readLine();
	                }
	                in.reset(); // Go back to the marked position
	                line = in.readLine();
	                int rowPos = 0; // Position of the row in the grid
	                while (line != null) {
	                    getState().load(rowSize, colSize, line, rowPos);
	                    line = in.readLine();
	                    rowPos++;
	                }

	            } catch (final IOException e) {
	                System.out.println(e);
	            }
	        }
	    	
	    }
	    public State state() {//getter for state
	        return getState();
	    }
	    public void iterate() {
	        getState().iterate(RulesB3S23);
	    }
	    public void save() {
	        try (PrintWriter out = new PrintWriter(fileName);) {
	            out.println(RulesB3S23.name());
	            String output = getState().toString();
	            output = output.substring(0, output.lastIndexOf("\n")); // Remove last line
	            out.println(output);
	            System.out.println("Game has been saved!");
	        } catch (final Exception e) {
	            System.out.println(e);
	        }
	    }
	    @Override
	    public String toString() {
	        return getState().toString();
	    }

		/**
		 * @return the state
		 */
		public State getState() {
			return state;
		}

		/**
		 * @param state the state to set
		 */
		public void setState(State state) {
			this.state = state;
		}
}
