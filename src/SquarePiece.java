import javafx.scene.paint.Color;
/**
 * 
 * @author Jack Roach
 * subclass of Piece that creates the Square shaped tetris piece
 */
public class SquarePiece extends Piece{
	TetrisSquare[] squares = new TetrisSquare[4];
	
	SquarePiece(TetrisBoard board){
		super(board);
		squares[0] = new TetrisSquare(board);
		squares[0].moveToTetrisLocation(TetrisBoard.X_DIM_SQUARES/2, 3); //center
		squares[0].setColor(Color.FIREBRICK);
		squares[0].setBorderColor(Color.BLACK);
		
		squares[1] = new TetrisSquare(board);
		squares[1].moveToTetrisLocation(TetrisBoard.X_DIM_SQUARES/2, 2);
		squares[1].setColor(Color.FIREBRICK);
		squares[1].setBorderColor(Color.BLACK);
		
		squares[2] = new TetrisSquare(board);
		squares[2].moveToTetrisLocation(TetrisBoard.X_DIM_SQUARES/2 - 1, 3);
		squares[2].setColor(Color.FIREBRICK);
		squares[2].setBorderColor(Color.BLACK);
		
		squares[3] = new TetrisSquare(board);
		squares[3].moveToTetrisLocation(TetrisBoard.X_DIM_SQUARES/2 - 1, 2);
		squares[3].setColor(Color.FIREBRICK);
		squares[3].setBorderColor(Color.BLACK);
	}
	

	public void moveLeft(TetrisBoard board){
		if (squares[2].getX() > 0){
			squares[0].moveToTetrisLocation(squares[0].getX()-1, squares[0].getY());
			squares[1].moveToTetrisLocation(squares[1].getX()-1, squares[1].getY());
			squares[2].moveToTetrisLocation(squares[2].getX()-1, squares[2].getY());
			squares[3].moveToTetrisLocation(squares[3].getX()-1, squares[3].getY());
		}
	}

	public void moveRight(TetrisBoard board){
		if (squares[0].getX() < TetrisBoard.X_DIM_SQUARES-1 && squares[1].getX() < TetrisBoard.X_DIM_SQUARES-1 && squares[2].getX() < TetrisBoard.X_DIM_SQUARES-1 && squares[3].getX() < TetrisBoard.X_DIM_SQUARES-1){
			squares[0].moveToTetrisLocation(squares[0].getX()+1, squares[0].getY());
			squares[1].moveToTetrisLocation(squares[1].getX()+1, squares[1].getY());
			squares[2].moveToTetrisLocation(squares[2].getX()+1, squares[2].getY());
			squares[3].moveToTetrisLocation(squares[3].getX()+1, squares[3].getY());
		}
	}

	/**
	 * the appearance of the square shape does not change when rotated so the rotation methods do not contain any code for the SquarePiece class
	 */
	public void rotateRight(TetrisBoard board){}
	public void rotateLeft(TetrisBoard board){}


	public void freezeSquares() {
		for (int i = 0; i < 4; i++){
			TetrisBoard.board[squares[i].getX()][squares[i].getY()] = squares[i];
		}
	}

	public void moveDown() {
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
	
}
