import java.util.*;

public class State {
	int nrows,ncols;
	ArrayList<ArrayList<Integer>> cells = new ArrayList<>();
	
	public State(int nrows, int ncols) {
//		int size = nrows*ncols;
		this.nrows = nrows;
		this.ncols = ncols;
		
		for (int i =0;i<nrows;i++) {
			cells.add(new ArrayList<Integer>());
			for (int j =0;j<ncols;j++) {
				
				cells.get(i).add(j,0);
			}		
		}
		
	}
	public void clear() {
		for(int i = 0;i<this.nrows;i++ ) {
			for (int j = 0;j<this.ncols;j++) {
				cells.get(i).set(j,0);
			}
		}
		
	}
	public int numAlive() {
	int count = 0;
	for (int i = 0; i<this.nrows;i++) {
		for(int j=0;j<this.ncols;j++) {
			if(cells.get(i).get(j)==1) {
				count++;
		}
		}
		}
	return count;
	}
    public void addRand(final int percent){
        double p = (double)percent/100;
        Random rand = new Random();
        double cut = 0;
        while(cut < p ){
            double alive = numAlive();
            cut = (alive/(this.ncols*this.nrows));
            int randRow = rand.nextInt(this.nrows);
            int randCol = rand.nextInt(this.ncols);
            //set a random element to 1 in the grid
            if(cells.get(randRow).get(randCol) != 1) {
                cells.get(randRow).set(randCol, 1);
            } else {
                addRand(percent);
            }

        }
    }	
		
	
	public void addGlider() {
		int mid = (this.ncols*this.nrows)/2;
		for(int i = 0;i<(int)this.nrows/2;i++) {
			for(int j = 0;j<(int)this.ncols/2;j++) {
				
			;
		}
	}
	}	
	public void resize(final int newRows, final int newCols){
		if (newRows>this.nrows||newCols>this.ncols) {
			for (int i =this.nrows;i<newRows;i++) {
				this.cells.add(new ArrayList<Integer>());
				for(int j = 0;j<newCols;j++) {
					this.cells.get(i).add(j,0);
//					this.cells.get(i)
					
				}
			}
			for(int i =0;i<this.nrows;i++) {
				for(int j = newCols-this.ncols;j<newCols;j++){
					this.cells.get(i).add(0);
				}
				}
			}
		else if(newRows<this.nrows||newCols<this.ncols) {
			for(int i = newCols;i<this.ncols;i++) {
//				this.cells.get(i).remove(i);
//				this.nrows=newRows;
				for(int j=0;j<this.nrows;j++) {
					this.cells.get(i).remove(j);
//			for(int i=0;i<newRows;i++) {
				
//			}
			}
		}}
		}
	
	public static void main(String[] args) {
		State x = new State(5,5);
//		x.clear();
		x.addRand(5);
		x.resize(16,16);
		System.out.println(x.numAlive());
		System.out.println(x.cells);
		

}
}