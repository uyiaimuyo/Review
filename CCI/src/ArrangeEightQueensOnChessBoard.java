// Write an algorithm to print all ways of arranging eight queens on 
// a chess board so that none of them share the same row, column or diagonal
//
// store queens column as value with row as index in columnForRow[] 
// we need to check for: if both queens are on same column columnForRow[i] == colForRow[j]
// check diagonal: i-j == columnForRow[i] - colForRow[j]

public class ArrangeEightQueensOnChessBoard {
	
	int[] colForRow = new int[8];

	public boolean check(int row) {
		for(int i=0; i<row; i++) {
			if (colForRow[i] == colForRow[row])
				return false;
			if (i-row == colForRow[i]-colForRow[row])
				return false;
		}
		return true;
	}


	public void arrange(int row) {
		if (row == 8) {
			for(int i=0; i<8; i++) {
				for(int j=0; j<8; j++) {
					if (colForRow[i] == j) {
						System.out.print("|Q");
					} else
					System.out.print("| ");
				}
				System.out.println("-------------");
			}
		}

		for (int i=0; i<8; i++) {
			colForRow[row] = i; 
			if(check(row)) 
				arrange(row+1);
		}
	}

}