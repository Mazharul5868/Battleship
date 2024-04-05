
public class valid_board {
	
	static final int null_board = -1;
	static final int wrong_size = -2;
	static final int invalid_char = -3;
	static final int valid_board = 0;
	

	public static void main(String[] args) {
		
		char[][] board = {
				{'.', '.', '.', 'S', 'S', '*', '*', '.', 'S', 'S'},
				{'.', '.', '.', 'S', 'S', '.', '.', '.', 'S', 'S'},
				{'.', '.', 'S', 'S', 'S', '*', '*', '.', '.', '.'},
				{'.', '.', '.', 'S', 'S', '*', '*', '.', 'S', 'S'},
				{'.', '.', '.', 'S', 'S', '.', '.', '.', 'S', 'S'},
				{'.', '.', 'S', 'S', 'S', '*', '*', '.', '.', '.'},
				{'.', '.', '.', 'S', 'S', '*', '*', '.', 'S', 'S'},
				{'.', '.', '.', 'S', 'S', '.', '.', '.', 'S', 'S'},
				{'.', '.', 'S', 'S', 'S', '*', '*', '.', '.', '.'},
				{'.', 'S', 'S', 'S', '*', '*', '.', '.', '.', '.'}
		};
		
		switch(boardValidation(board)) {
		
			case null_board: 
				System.out.println("The board is null");
				break;
			case wrong_size: 
				System.out.println("The board is wrong size");
				break;
			case invalid_char: 
				System.out.println("Invalid square value");
				break;
			case valid_board: 
				System.out.println("The board is valid");
				break;
			default: 
				System.out.println("Unknown validation");
				
		}

	}

	static int boardValidation(char[][] board) {
		
		if(board == null) {
			return null_board;
		} 
		else if(board.length != 10 || column_length(board)) {
			return wrong_size;
		} 
		else if(!character_check(board)) {
			return invalid_char;
		}
		else return valid_board;
	}
	
	// check the individual character in the board
	static boolean character_check(char[][] board) {
		
		for(char[] row : board) {
			for(char column : row) {
			
				if(column != '.' && column != 'S' && column != '*') {
					return false;
				}
			}
		}
		
		return true;
	}
	
	// check the length of each row
	static boolean column_length(char[][] board) {
		
		for(char[] row : board) {
			if(row.length != 10) return true; 
		}
		return false;
	}

}
