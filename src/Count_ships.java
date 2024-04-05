
public class Count_ships {
	
	static final int ship_type_invalid = -1;
	static final int damage_type_invalid = -2;
	

	public static void main(String[] args) {
		
		char[][] board = {
				{'.', '.', '.', 'S', 'S', '*', '*', '.', 'S', 'S'},
				{'.', '.', '.', 'S', 'S', '.', '.', '.', 'S', 'S'},
				{'.', '.', 'S', 'S', 'S', '*', '*', '.', '.', '.'},
				{'.', '.', '.', '*', '*', '*', '*', '.', '*', '*'},
				{'.', '.', '.', 'S', 'S', '.', '.', '.', 'S', 'S'},
				{'.', '.', 'S', 'S', 'S', '*', '*', '.', '.', '.'},
				{'.', '.', '.', 'S', 'S', 'S', '*', '.', 'S', 'S'},
				{'.', '.', '.', 'S', 'S', 'S', '.', '.', '*', 'S'},
				{'.', '.', 'S', 'S', 'S', '*', '*', '.', '.', '.'},
				{'.', '*', '*', '*', '*', '*', '.', '.', '.', '.'}
		};

		String ship_type = "Battleship";
		String damage_type = "Sunk";
		
		int ships = count_ships(board, ship_type, damage_type);
		
		if(ships == ship_type_invalid) {
			System.out.println("The ship type is invalid.");
		}
		else if(ships == damage_type_invalid) {
			System.out.println("The damage type is invalid");
		}
		else {
			System.out.println("Total number of ships: " + ships);
		}
	}
	
	static int count_ships(char[][] board, String ship_type, String damage_type) {
		
		int shipSize = getShipSize(ship_type);									  	// to get the current ship size
		boolean damageType = damageType(damage_type);
		
		if(shipSize == ship_type_invalid) return ship_type_invalid;
		if(!damageType) return damage_type_invalid;
		
		int count = 0;
		
		for(int i=0; i<board.length; i++) {
			int j=0;
			while(j<board[i].length) {

				if(board[i][j] == 'S' || board[i][j] == '*') {

					int start = j;
					
					while(j < board[i].length && (board[i][j] == 'S' || board[i][j] == '*')) {
						j++;
					}
					
					int end = j-1;	
					int shipLength = end - start + 1;
					String currentDamageType = damage(board, i, start, end);
					
					if((shipLength == shipSize) && (damage_type.equalsIgnoreCase("all types") || damage_type.equalsIgnoreCase(currentDamageType))) {
						count++;
					}
					
				}
				else {
					j++;
				}
				
			}
		}
		
		return count;
	}
	
	// to get value of ship size
	static int getShipSize(String ship_type) {
		
		int ship_id = 0, ship_size = 0;
		String ship_class = "";
		
		if(ship_type.matches("\\d")) {
			ship_id = Integer.parseInt(ship_type);
		} 
		else {
			ship_class = ship_type;
		}

		if(ship_class.equalsIgnoreCase("carrier") || ship_id == 1) {
			ship_size = 5;
		}
		else if (ship_class.equalsIgnoreCase("battleship") || ship_id == 2) {
			ship_size = 4;
		}
		else if (ship_class.equalsIgnoreCase("cruiser") || ship_id == 3) {
			ship_size = 3;
		}
		else if (ship_class.equalsIgnoreCase("destroyer") || ship_id == 4) {
			ship_size = 2;
		}
		else {
			ship_size = ship_type_invalid;
		}
		
		return ship_size;
	}
	
	// to justify the valid damage type 
	static boolean damageType(String damage_type) {
		
		if(damage_type.equalsIgnoreCase("undamaged") || damage_type.equalsIgnoreCase("damaged") ||
		   damage_type.equalsIgnoreCase("sunk") || damage_type.equalsIgnoreCase("all types")) {
			return true;
		}
		else return false;
	}
	
	// identify the damage type
	static String damage(char[][] board, int row, int startCol, int endCol) {
		boolean hasS = false;
		boolean hasStar = false;
		
		for(int j=startCol; j <= endCol; j++) {
			if(board[row][j] == 'S') hasS = true;
			if(board[row][j] == '*') hasStar = true; 
		}
		
		if(hasS && hasStar) return "damaged";
		if(hasStar && !hasS) return "sunk";
		return "undamaged";
	}
	
}
