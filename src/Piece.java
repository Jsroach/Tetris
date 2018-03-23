
/**
 * 
 * @author Jack Roach
 * this class is a base super class for all 7 tetris pieces, initially containing a few abstract methods for the pieces
 */
public abstract class Piece {
	private TetrisSquare[] squares = new TetrisSquare[4]; //contains each square of the piece for easy reference
	
	public Piece(TetrisBoard board){}
	
	/**
	 * Sets the 4 squares of the piece on the map, becoming terrain until cleared by forming a complete row of squares
	 */
	public abstract void freezeSquares();
	/**
	 * moves a piece one block to the left, each subclass checks for edges based on its shape
	 */
	public abstract void moveLeft(TetrisBoard board);
	/**
	 * moves a piece one block to the right, each subclass checks for edges based on its shape
	 */
	public abstract void moveRight(TetrisBoard board);
	/**
	 * moves a piece one block down
	 */
	public abstract void moveDown();
	/**
	 * rotates a piece 90 degrees clockwise, each subclass checks for edges based on its shape and moves itself if the rotation puts
	 * any part of the piece outside of the stage
	 */
	public abstract void rotateRight(TetrisBoard board);
	/**
	 * rotates a piece 90 degrees counterclockwise, each subclass checks for edges based on its shape and moves itself if the rotation puts
	 * any part of the piece outside of the stage
	 */
	public abstract void rotateLeft(TetrisBoard board);
	/**
	 * checks to see if the piece can move down 1 unit
	 * @return
	 */
	public abstract boolean possibleToMoveDown(TetrisBoard board);
	/**
	 * checks to see if the piece can move left 1 unit
	 * @return
	 */
	public abstract boolean possibleToMoveLeft(int n, TetrisBoard board);
	/**
	 * checks to see if the piece can move right 1 unit
	 * @return
	 */
	public abstract boolean possibleToMoveRight(int n, TetrisBoard board);
}
