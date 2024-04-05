
public class Hit {
	
	static final int invalidRow = -1;
	static final int invalidColumn = -2;
	static final int hit = 1;
	static final int miss = 2;
	static final int repeatedHit = 3;

	public static void main(String[] args) {
		
		char[][] board = {
				{'.', '.', 'S', 'S', 'S', '.', '.', '*', '*', '*'},
			    {'.', '.', '.', '*', '*', '*', '.', '.', '.', '.'},
			    {'.', '.', '.', '.', '*', '*', '.', '*', 'S', 'S'},
			    {'.', 'S', '*', '.', '.', '.', '.', '.', '.', '.'},
			    {'.', '.', '.', '.', '.', 'S', 'S', '*', 'S', '.'},
			    {'.', '.', '.', '*', '*', '*', '*', '.', '.', '.'},
			    {'.', '*', '*', '.', '.', '.', '*', 'S', 'S', '*'},
			    {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
			    {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
			    {'.', '.', '.', 'S', '*', '*', '.', '.', '.', '.'}
		};
		
		int result = hitOrMiss(7, 'B', board);
		System.out.println("The result is: " + result);
	}
	
	static int hitOrMiss(int row, char column, char[][] board) {
		
		final int minRow = 1, maxRow = 10;
		final int minCol = 'A' - 'A', maxCol = 'J' - 'A';		// convert character to column index
		int rowValue = row, colValue = column - 'A';
		
		// check if the row is invalid
		if(rowValue < minRow || rowValue > maxRow) return invalidRow;
		if(colValue < minCol || colValue > maxCol) return invalidColumn; 
		
		char currentSquare = board[row-1][colValue]; 				// convert rowValue to row index
	
		switch (currentSquare) {
		
			case 'S' : 
				return hit;
			case '.' : 
				return miss;
			case '*' : 
				return repeatedHit;
			default : 
				return 0;
			
		}
	}
	
}
