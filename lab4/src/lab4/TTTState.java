package lab4;

public interface TTTState {

	char getValue(int row, int col) ;

	char currentPlayer();

	void clickCell(int row, int col);

}
