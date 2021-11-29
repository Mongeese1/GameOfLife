import java.util.*;
public class State {
	/**
	 * Pra2003
	 * @author mongeese1
	 * i6222534
	 */
	ArrayList<ArrayList<Integer>> grid = 
			new ArrayList<ArrayList<Integer>>();//arraylist to hold grid
	int col;
	int row;
	
	//class constructor
	public State(final int col, final int row) {
		this.col = col;
		this.row = row;
		for (int i = 0; i<row;i++) {
			grid.add(new ArrayList<Integer>());//fill row with arraylists
			for (int j = 0;j<col;j++) {
				grid.get(i).add(j,0);//fill those arraylists integers for columns
			}
		}
	}
		//reset the game state to 0
		public void clear() {
			for(int i =0; i <row;i++) {
				for(int j =0;j>col;j++) {
					grid.get(i).set(j,0);//loop through arraylist and set all grid 0
				}
			}
		
	}
		//count living grid, represented by 1s on the grid
		public int numAlive() {
			int count = 0;
			for (int i = 0; i < row; i++){
	            for (int j = 0; j<col;j++){
	            	if(grid.get(i).get(j)==1) {
	            		count++;
	            	}
	            
	            }
	           }
			return count;
			}
		//add random ones to the grid
		public void addRand(final int percent) {
			double p = (double)percent/100;
			Random rand = new Random();
			double cutoff = 0;
			while(cutoff<p) {
				double live = numAlive();
				cutoff = live/(col*row);
				int randRow = rand.nextInt(row);
				int randCol = rand.nextInt(col);//generate randints in range row col
				//check if alive
				if (grid.get(randRow).get(randCol)!=1) {
					grid.get(randRow).set(randCol, 1);//if this !alive set alive
				}
				else {
					addRand(percent);//iterate method
					
				}
			}
		}
		public void addPattern(final Pattern pattern){
	        int midr = row/2;
	        int midc = col/2;

	        int midPatternRow = pattern.lines().size()/2;
	        int midPatternCol = (pattern.lines().get(0).size())/2;

	        for(int i = 0; i < pattern.lines().size();i++){
	            for(int j = 0; j < pattern.lines().get(0).size(); j++){
	                if (pattern.lines().get(i).get(j) == 0){
	                    continue;  // not a live cell
	                } else {
	                    final int a = (midr - midPatternRow + i + row) % row;
	                    final int b = (midc - midPatternCol + j + col) % col;
	                    grid.get(a).set(b,1);
	                }
	            }
	        }
	    }
		// method to resize the grid
	    void resize(final int newRows, final int newCols){
	        if(newRows == 0 || newCols == 0) {
	            System.out.println("You cannot have a grid of size 0.");
	        } else {
	            State next = new State(newRows, newCols);
	            for (int i = 0; i < Math.min(row, newRows); i++) {
	                for (int j = 0; j < Math.min(col, newCols); j++){
	                    next.grid.get(i).set(j, grid.get(i).get(j)); 
	                }
	            }
	            grid = next.grid;
	            row = newRows;
	            col = newCols;
	        }}
	    public int nbors(final int rows,final int cols) {
	    	int count = 0;
	    	if(grid.get(rows-1).get(cols-1)==1) { //count from -1 since this will count itself if it is alive
	    	count = -1;}
	    
	    	//indexing at 0 but users will index from 1 unless they are robots
	    	 for(int i =rows-2; i<3;i++) {//check from row below to row above
	    		 final int r = (rows - i) % row + (rows-i < 0 ? row : 0);
	             for(int j = 0;j < 3;j++) {
	                 final int c = (cols - j) % col + (cols-j < 0 ? col : 0);
	                 if(grid.get(r).get(c)==1) {
	                         count++;
	    				
	    			 }
	    		 }
	             
	    	 }  
	    	 return count;
		}
	    public void load(int rowSize, int colSize, String line, int rowPos){
	        if(rowSize != row | colSize != col){
	            resize(rowSize, colSize);
	            row = rowSize;
	            col = colSize;
	        } 
	        for (int i = 0; i < col; i++){
	            if(line.charAt(i) == 0){
	                grid.get(rowPos).set(i, 1);
	            } else {
	                grid.get(rowPos).set(i, 0);
	            }
	        }
	        
	    }
	    
	    public void iterate(final Rules rules) {
	        State temp = new State(row, col);
	        for (int i = 0; i < row; i++){
	        	for (int j = 0; j<col;j++){
	        		int value = rules.result(grid.get(i).get(j), nbors(i+1, j+1));
	        // Save current calculation to new grid
	        		temp.grid.get(i).set(j, value);
	        	}
	        }
		grid = temp.grid;
	}
	    @Override
	    public String toString() {
	        double alive = numAlive();
	        StringBuilder builder = new StringBuilder();
	        int total = row*col;
	        // print the rows of the grid
	        for (ArrayList<Integer> li : grid){
	            for(int i : li) {
	                if(i==0) {
	                    builder.append(".");
	                }else {
	                    builder.append("o");//represent living with o and dead .
	                }
	            }
	            builder.append("\n");
	        }

	        return builder.toString() + 
	        alive + " live cells out of " + 
	        total + " (" + (alive/total)*100 + " percent)" ;
	    }
	    public void clickCell(int row, int col){
	        if(grid.get(row).get(col) == 0){
	            grid.get(row).set(col, 1);
	        }
	        else{
	            grid.get(row).set(col, 0);
	        }

	    }

}

