import javafx.scene.paint.Color;
/**
 * 
 * @author Jack Roach
 * subclass of Piece that creates the Line shaped tetris piece
 */
public class LinePiece extends Piece{
	TetrisSquare[] squares = new TetrisSquare[4];

	LinePiece(TetrisBoard board) {
		super(board);
		squares[0] = new TetrisSquare(board);
		squares[0].moveToTetrisLocation(TetrisBoard.X_DIM_SQUARES/2, 3); //center
		squares[0].setColor(Color.CORNFLOWERBLUE);
		squares[0].setBorderColor(Color.BLACK);
		
		squares[1] = new TetrisSquare(board);
		squares[1].moveToTetrisLocation(TetrisBoard.X_DIM_SQUARES/2, 2); //top
		squares[1].setColor(Color.CORNFLOWERBLUE);
		squares[1].setBorderColor(Color.BLACK);
		
		squares[2] = new TetrisSquare(board);
		squares[2].moveToTetrisLocation(TetrisBoard.X_DIM_SQUARES/2, 4);
		squares[2].setColor(Color.CORNFLOWERBLUE);
		squares[2].setBorderColor(Color.BLACK);
		
		squares[3] = new TetrisSquare(board);
		squares[3].moveToTetrisLocation(TetrisBoard.X_DIM_SQUARES/2, 5);
		squares[3].setColor(Color.CORNFLOWERBLUE);
		squares[3].setBorderColor(Color.BLACK);
	}
	
	public void freezeSquares() {
		for (int i = 0; i < 4; i++){
			TetrisBoard.board[squares[i].getX()][squares[i].getY()] = squares[i];
		}
	}
	
	public void moveLeft(TetrisBoard board){
		if (squares[0].getX() > 0 && squares[1].getX() > 0 && squares[2].getX() > 0 && squares[3].getX() > 0 &&
			board.isOccupied(squares[0].getX()-1, squares[0].getY()) == false &&
			board.isOccupied(squares[1].getX()-1, squares[1].getY()) == false &&
			board.isOccupied(squares[2].getX()-1, squares[2].getY()) == false &&
			board.isOccupied(squares[3].getX()-1, squares[3].getY()) == false){
			squares[0].moveToTetrisLocation(squares[0].getX()-1, squares[0].getY());
			squares[1].moveToTetrisLocation(squares[1].getX()-1, squares[1].getY());
			squares[2].moveToTetrisLocation(squares[2].getX()-1, squares[2].getY());
			squares[3].moveToTetrisLocation(squares[3].getX()-1, squares[3].getY());
		}
	}

	public void moveRight(TetrisBoard board){
		if (squares[0].getX() < TetrisBoard.X_DIM_SQUARES-1 &&
			squares[1].getX() < TetrisBoard.X_DIM_SQUARES-1 &&
			squares[2].getX() < TetrisBoard.X_DIM_SQUARES-1 &&
			squares[3].getX() < TetrisBoard.X_DIM_SQUARES-1 &&
			board.isOccupied(squares[0].getX()+1, squares[0].getY()) == false &&
			board.isOccupied(squares[1].getX()+1, squares[1].getY()) == false &&
			board.isOccupied(squares[2].getX()+1, squares[2].getY()) == false &&
			board.isOccupied(squares[3].getX()+1, squares[3].getY()) == false){
			squares[0].moveToTetrisLocation(squares[0].getX()+1, squares[0].getY());
			squares[1].moveToTetrisLocation(squares[1].getX()+1, squares[1].getY());
			squares[2].moveToTetrisLocation(squares[2].getX()+1, squares[2].getY());
			squares[3].moveToTetrisLocation(squares[3].getX()+1, squares[3].getY());
		}
	}
	public void moveUp(){
		squares[0].moveToTetrisLocation(squares[0].getX(), squares[0].getY()-1);
		squares[1].moveToTetrisLocation(squares[1].getX(), squares[1].getY()-1);
		squares[2].moveToTetrisLocation(squares[2].getX(), squares[2].getY()-1);
		squares[3].moveToTetrisLocation(squares[3].getX(), squares[3].getY()-1);
	}
	public void moveDown(){
		squares[0].moveToTetrisLocation(squares[0].getX(), squares[0].getY()+1);
		squares[1].moveToTetrisLocation(squares[1].getX(), squares[1].getY()+1);
		squares[2].moveToTetrisLocation(squares[2].getX(), squares[2].getY()+1);
		squares[3].moveToTetrisLocation(squares[3].getX(), squares[3].getY()+1);
	}
	public boolean possibleToMoveDown(TetrisBoard board){
		
		if (squares[0].getY() != TetrisBoard.Y_DIM_SQUARES-1 &&
			squares[1].getY() != TetrisBoard.Y_DIM_SQUARES-1 &&
			squares[2].getY() != TetrisBoard.Y_DIM_SQUARES-1 &&
			squares[3].getY() != TetrisBoard.Y_DIM_SQUARES-1){
			if (board.isOccupied(squares[0].getX(),squares[0].getY()+1) == false &&
				board.isOccupied(squares[1].getX(),squares[1].getY()+1) == false &&
				board.isOccupied(squares[2].getX(),squares[2].getY()+1) == false &&
				board.isOccupied(squares[3].getX(),squares[3].getY()+1) == false){
				return true;
				}
			else{
				return false;
			}
		}
		else{
			return false;
		}
	}
	public boolean possibleToMoveLeft(int n, TetrisBoard board){
		if (board.isOccupied(squares[0].getX()-n,squares[0].getY()) == false &&
			board.isOccupied(squares[1].getX()-n,squares[1].getY()) == false &&
			board.isOccupied(squares[2].getX()-n,squares[2].getY()) == false &&
			board.isOccupied(squares[3].getX()-n,squares[3].getY()) == false){
			return true;
		}
		else{
			return false;
		}
	}
	public boolean possibleToMoveRight(int n, TetrisBoard board){
		if (board.isOccupied(squares[0].getX()+n,squares[0].getY()) == false &&
			board.isOccupied(squares[1].getX()+n,squares[1].getY()) == false &&
			board.isOccupied(squares[2].getX()+n,squares[2].getY()) == false &&
			board.isOccupied(squares[3].getX()+n,squares[3].getY()) == false){
			return true;
		}
		else{
			return false;
		}
	}
	
	public void rotateRight(TetrisBoard board) {
		if (squares[0].getY() == TetrisBoard.Y_DIM_SQUARES-1 && squares[0].getX() < squares[1].getX()){
			if (board.isOccupied(squares[0].getX(), squares[0].getY()-1) == false &&
				board.isOccupied(squares[1].getX(), squares[1].getY()) == false &&
				board.isOccupied(squares[2].getX(), squares[2].getY()-2) == false &&
				board.isOccupied(squares[3].getX(), squares[3].getY()-3) == false){
				this.moveUp();
			}			
		}
		if (squares[0].getY() == TetrisBoard.Y_DIM_SQUARES-1 && squares[0].getX() > squares[1].getX()){
			if (board.isOccupied(squares[0].getX(), squares[0].getY()-1) == false &&
				board.isOccupied(squares[1].getX(), squares[1].getY()-2) == false &&
				board.isOccupied(squares[2].getX(), squares[2].getY()) == false &&
				board.isOccupied(squares[3].getX(), squares[3].getY()+1) == false &&
				
				board.isOccupied(squares[0].getX(), squares[0].getY()-2) == false &&
				board.isOccupied(squares[1].getX(), squares[1].getY()-3) == false &&
				board.isOccupied(squares[2].getX(), squares[2].getY()-1) == false &&
				board.isOccupied(squares[3].getX(), squares[3].getY()) == false){
				this.moveUp();
				this.moveUp();
			}
		}
		if (squares[0].getY() == TetrisBoard.Y_DIM_SQUARES-2 && squares[0].getX() > squares[1].getX()){
			if (board.isOccupied(squares[0].getX(), squares[0].getY()-1) == false &&
				board.isOccupied(squares[1].getX(), squares[1].getY()-2) == false &&
				board.isOccupied(squares[2].getX(), squares[2].getY()) == false &&
				board.isOccupied(squares[3].getX(), squares[3].getY()+1) == false){
				this.moveUp();
				
			}
		}
		if (squares[1].getY() < squares[0].getY() &&
			board.isOccupied(squares[0].getX()+1, squares[0].getY()) == false &&
			board.isOccupied(squares[0].getX()-1, squares[0].getY()) == false &&
			board.isOccupied(squares[0].getX()-2, squares[0].getY()) == false){ //position the shape spawns
			if (squares[0].getX() == TetrisBoard.X_DIM_SQUARES-1){
				if (this.possibleToMoveLeft(1, board) == true){
					this.moveLeft(board);
					squares[1].moveToTetrisLocation(squares[0].getX()+1,squares[0].getY());
					squares[2].moveToTetrisLocation(squares[0].getX()-1,squares[0].getY());
					squares[3].moveToTetrisLocation(squares[0].getX()-2,squares[0].getY());
				}
			}
			else if (squares[0].getX() == 0){
				if (this.possibleToMoveRight(2, board) == true){
					this.moveRight(board);
					this.moveRight(board);
					squares[1].moveToTetrisLocation(squares[0].getX()+1,squares[0].getY());
					squares[2].moveToTetrisLocation(squares[0].getX()-1,squares[0].getY());
					squares[3].moveToTetrisLocation(squares[0].getX()-2,squares[0].getY());
				}
			}
			else if (squares[0].getX() == 1){
				if (this.possibleToMoveRight(1, board) == true){
					this.moveRight(board);
					squares[1].moveToTetrisLocation(squares[0].getX()+1,squares[0].getY());
					squares[2].moveToTetrisLocation(squares[0].getX()-1,squares[0].getY());
					squares[3].moveToTetrisLocation(squares[0].getX()-2,squares[0].getY());
				}
			}
			else{
				squares[1].moveToTetrisLocation(squares[0].getX()+1,squares[0].getY());
				squares[2].moveToTetrisLocation(squares[0].getX()-1,squares[0].getY());
				squares[3].moveToTetrisLocation(squares[0].getX()-2,squares[0].getY());
			}
			
		}
		else if (squares[1].getY() > squares[0].getY() &&
			board.isOccupied(squares[0].getX()-1, squares[0].getY()) == false &&
			board.isOccupied(squares[0].getX()+1, squares[0].getY()) == false &&
			board.isOccupied(squares[0].getX()+2, squares[0].getY()) == false){//		
			if (squares[0].getX() == 0){
				if (this.possibleToMoveRight(1, board) == true){
					this.moveRight(board);
					squares[1].moveToTetrisLocation(squares[0].getX()-1,squares[0].getY());
					squares[2].moveToTetrisLocation(squares[0].getX()+1,squares[0].getY());
					squares[3].moveToTetrisLocation(squares[0].getX()+2,squares[0].getY());
				}
			}
			else if (squares[0].getX() == TetrisBoard.X_DIM_SQUARES-1){
				if (this.possibleToMoveLeft(2, board) == true){
					this.moveLeft(board);
					this.moveLeft(board);
					squares[1].moveToTetrisLocation(squares[0].getX()-1,squares[0].getY());
					squares[2].moveToTetrisLocation(squares[0].getX()+1,squares[0].getY());
					squares[3].moveToTetrisLocation(squares[0].getX()+2,squares[0].getY());
				}
			}
			else if (squares[0].getX() == TetrisBoard.X_DIM_SQUARES-2){
				if (this.possibleToMoveLeft(1, board) == true){
					this.moveLeft(board);
					squares[1].moveToTetrisLocation(squares[0].getX()-1,squares[0].getY());
					squares[2].moveToTetrisLocation(squares[0].getX()+1,squares[0].getY());
					squares[3].moveToTetrisLocation(squares[0].getX()+2,squares[0].getY());
				}
			}
			else{
				squares[1].moveToTetrisLocation(squares[0].getX()-1,squares[0].getY());
				squares[2].moveToTetrisLocation(squares[0].getX()+1,squares[0].getY());
				squares[3].moveToTetrisLocation(squares[0].getX()+2,squares[0].getY());
			}
		}		
		else if (squares[1].getX() < squares[0].getX() &&
			board.isOccupied(squares[0].getX(), squares[0].getY()-1) == false &&
			board.isOccupied(squares[0].getX(), squares[0].getY()+1) == false &&
			board.isOccupied(squares[0].getX(), squares[0].getY()+2) == false){//
			squares[1].moveToTetrisLocation(squares[0].getX(),squares[0].getY()-1);
			squares[2].moveToTetrisLocation(squares[0].getX(),squares[0].getY()+1);
			squares[3].moveToTetrisLocation(squares[0].getX(),squares[0].getY()+2);
		}
		else if (squares[1].getX() > squares[0].getX() &&
			board.isOccupied(squares[0].getX(), squares[0].getY()+1) == false &&
			board.isOccupied(squares[0].getX(), squares[0].getY()-1) == false &&
			board.isOccupied(squares[0].getX(), squares[0].getY()-2) == false){//
			squares[1].moveToTetrisLocation(squares[0].getX(),squares[0].getY()+1);
			squares[2].moveToTetrisLocation(squares[0].getX(),squares[0].getY()-1);
			squares[3].moveToTetrisLocation(squares[0].getX(),squares[0].getY()-2);
		}	
	}
	
	
	public void rotateLeft(TetrisBoard board) {
		if (squares[0].getY() == TetrisBoard.Y_DIM_SQUARES-1 && squares[0].getX() < squares[1].getX()){
			if (board.isOccupied(squares[0].getX(), squares[0].getY()) == false &&
				board.isOccupied(squares[1].getX(), squares[1].getY()-1) == false &&
				board.isOccupied(squares[2].getX(), squares[2].getY()-2) == false &&
				board.isOccupied(squares[3].getX(), squares[3].getY()-3) == false){
				this.moveUp();
			}			
		}
		if (squares[0].getY() == TetrisBoard.Y_DIM_SQUARES-1 && squares[0].getX() > squares[1].getX()){
			if (board.isOccupied(squares[0].getX(), squares[0].getY()-1) == false &&
				board.isOccupied(squares[1].getX(), squares[1].getY()-2) == false &&
				board.isOccupied(squares[2].getX(), squares[2].getY()) == false &&
				board.isOccupied(squares[3].getX(), squares[3].getY()+1) == false &&
				
				board.isOccupied(squares[0].getX(), squares[0].getY()-2) == false &&
				board.isOccupied(squares[1].getX(), squares[1].getY()-3) == false &&
				board.isOccupied(squares[2].getX(), squares[2].getY()-1) == false &&
				board.isOccupied(squares[3].getX(), squares[3].getY()) == false){
				this.moveUp();
			}
		}
		if (squares[0].getY() == TetrisBoard.Y_DIM_SQUARES-2 && squares[0].getX() < squares[1].getX()){
			if (board.isOccupied(squares[0].getX(), squares[0].getY()-1) == false &&
				board.isOccupied(squares[1].getX(), squares[1].getY()-2) == false &&
				board.isOccupied(squares[2].getX(), squares[2].getY()) == false &&
				board.isOccupied(squares[3].getX(), squares[3].getY()+1) == false){
				this.moveUp();
			}
		}
		if (squares[1].getY() < squares[0].getY() &&
				board.isOccupied(squares[0].getX()-1, squares[0].getY()) == false &&
				board.isOccupied(squares[0].getX()+1, squares[0].getY()) == false &&
				board.isOccupied(squares[0].getX()+2, squares[0].getY()) == false){ //position the shape spawns
			if (squares[0].getX() == 0){
				if (this.possibleToMoveRight(1, board) == true){
					this.moveRight(board);
					squares[1].moveToTetrisLocation(squares[0].getX()-1,squares[0].getY());
					squares[2].moveToTetrisLocation(squares[0].getX()+1,squares[0].getY());
					squares[3].moveToTetrisLocation(squares[0].getX()+2,squares[0].getY());
				}
			}
			else if (squares[0].getX() == TetrisBoard.X_DIM_SQUARES-1){
				if (this.possibleToMoveLeft(2, board) == true){
					this.moveLeft(board);
					this.moveLeft(board);
					squares[1].moveToTetrisLocation(squares[0].getX()-1,squares[0].getY());
					squares[2].moveToTetrisLocation(squares[0].getX()+1,squares[0].getY());
					squares[3].moveToTetrisLocation(squares[0].getX()+2,squares[0].getY());
				}
			}
			else if (squares[0].getX() == TetrisBoard.X_DIM_SQUARES-2){
				if (this.possibleToMoveLeft(1, board) == true){
					this.moveLeft(board);
					squares[1].moveToTetrisLocation(squares[0].getX()-1,squares[0].getY());
					squares[2].moveToTetrisLocation(squares[0].getX()+1,squares[0].getY());
					squares[3].moveToTetrisLocation(squares[0].getX()+2,squares[0].getY());
				}
			}
			else{
				squares[1].moveToTetrisLocation(squares[0].getX()-1,squares[0].getY());
				squares[2].moveToTetrisLocation(squares[0].getX()+1,squares[0].getY());
				squares[3].moveToTetrisLocation(squares[0].getX()+2,squares[0].getY());
			}
		}
		else if (squares[1].getY() > squares[0].getY() &&
			board.isOccupied(squares[0].getX()+1, squares[0].getY()) == false &&
			board.isOccupied(squares[0].getX()-1, squares[0].getY()) == false &&
			board.isOccupied(squares[0].getX()-2, squares[0].getY()) == false){
			if (squares[0].getX() == TetrisBoard.X_DIM_SQUARES-1){
				if (this.possibleToMoveLeft(1, board) == true){
					this.moveLeft(board);
					squares[1].moveToTetrisLocation(squares[0].getX()+1,squares[0].getY());
					squares[2].moveToTetrisLocation(squares[0].getX()-1,squares[0].getY());
					squares[3].moveToTetrisLocation(squares[0].getX()-2,squares[0].getY());
				}
			}
			else if (squares[0].getX() == 0){
				if (this.possibleToMoveRight(2, board) == true){
					this.moveRight(board);
					this.moveRight(board);
					squares[1].moveToTetrisLocation(squares[0].getX()+1,squares[0].getY());
					squares[2].moveToTetrisLocation(squares[0].getX()-1,squares[0].getY());
					squares[3].moveToTetrisLocation(squares[0].getX()-2,squares[0].getY());
				}
			}
			else if (squares[0].getX() == 1){
				if (this.possibleToMoveRight(1, board) == true){
					this.moveRight(board);
					squares[1].moveToTetrisLocation(squares[0].getX()+1,squares[0].getY());
					squares[2].moveToTetrisLocation(squares[0].getX()-1,squares[0].getY());
					squares[3].moveToTetrisLocation(squares[0].getX()-2,squares[0].getY());
				}
			}
			else{
				squares[1].moveToTetrisLocation(squares[0].getX()+1,squares[0].getY());
				squares[2].moveToTetrisLocation(squares[0].getX()-1,squares[0].getY());
				squares[3].moveToTetrisLocation(squares[0].getX()-2,squares[0].getY());
			}
		}
		else if (squares[1].getX() < squares[0].getX() &&
			board.isOccupied(squares[0].getX(), squares[0].getY()+1) == false &&
			board.isOccupied(squares[0].getX(), squares[0].getY()-1) == false &&
			board.isOccupied(squares[0].getX(), squares[0].getY()-2) == false){
			squares[1].moveToTetrisLocation(squares[0].getX(),squares[0].getY()+1);
			squares[2].moveToTetrisLocation(squares[0].getX(),squares[0].getY()-1);
			squares[3].moveToTetrisLocation(squares[0].getX(),squares[0].getY()-2);
		}
		else if (squares[1].getX() > squares[0].getX() &&
			board.isOccupied(squares[0].getX(), squares[0].getY()-1) == false &&
			board.isOccupied(squares[0].getX(), squares[0].getY()+1) == false &&
			board.isOccupied(squares[0].getX(), squares[0].getY()+2) == false){
			squares[1].moveToTetrisLocation(squares[0].getX(),squares[0].getY()-1);
			squares[2].moveToTetrisLocation(squares[0].getX(),squares[0].getY()+1);
			squares[3].moveToTetrisLocation(squares[0].getX(),squares[0].getY()+2);
		}
	}

	
}
