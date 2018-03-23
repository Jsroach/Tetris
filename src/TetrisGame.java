

/**
 * This should be implemented to include your game control.
 * @author pipWolfe & Jack Roach
 */
public class TetrisGame {
    private final Tetris tetrisApp;
    private static Piece piece;
    private static boolean lost = false; //set to true when the map reaches a certain height and stops the game
    /**
     * Initialize the game. Remove the example code and replace with code
     * that creates a random piece.
     * @param tetrisApp A reference to the application (use to set messages).
     * @param board A reference to the board on which Squares are drawn
     */
    public TetrisGame(Tetris tetrisApp, TetrisBoard board) {
        this.tetrisApp = tetrisApp;
        
        // You can use this to show the score, etc.
        tetrisApp.setMessage("Game has started!             ");
        
        this.makePiece(board); //first piece
    }
    
    /**
     * Randomly generates one of the 7 piece types to insert onto the board
     * @param board
     */
    public void makePiece(TetrisBoard board){
    	int random = 0 + (int)(Math.random() * 7);
        if (random == 0){
        	piece = new SquarePiece(board);
        }
        if (random == 1){
        	piece = new LinePiece(board);
        }
        if (random == 2){
        	piece = new TPiece(board);
        }
        if (random == 3){
        	piece = new LPiece(board);
        }
        if (random == 4){
        	piece = new ReverseLPiece(board);
        }
        if (random == 5){
        	piece = new RightZPiece(board);
        }
        if (random == 6){
        	piece = new LeftZPiece(board);
        }
    }
    
    /**
     * returns active piece to Tetris App class if needed
     * @return piece
     */
    public Piece getPiece(){
    	return piece;
    }
    
    /**
     * repeats the tetris animations
     * takes the squares from the current piece and locks them onto the board
     * ends the game if the board is filled to a certain point
     * clears a row, shifts upper rows down, and adds a point if a row is filled,
     * creates another piece
     * @param board
     */
    void newPiece(TetrisBoard board){
    	piece.freezeSquares();
    	if (TetrisBoard.board[TetrisBoard.X_DIM_SQUARES/2][3] != null){
    		tetrisApp.setMessage("Game Over!                    ");
    		lost = true;
    	}
    	for (int i = 0; i < TetrisBoard.Y_DIM_SQUARES; i++){
    		if(board.isRowFull(i) == true){
    			TetrisBoard.shiftDown(i);
    			Tetris.addPoint();
    		}
    	}
    	if (lost == false){
    		this.makePiece(board);
    	}
    }
    
    /**
     * Animate the game, by moving the current tetris piece down.
     */
    void update(TetrisBoard tetrisBoard) {
    	if (TetrisGame.piece.possibleToMoveDown(tetrisBoard) == true){
        	TetrisGame.piece.moveDown();
        }
    	else{
    		this.newPiece(tetrisBoard);
    	}
    }
    
    /**
     * Move the current tetris piece left.
     */
    void left(TetrisBoard board) {
        tetrisApp.setMessage("left key was pressed!         ");
        System.out.println("left key was pressed!");
        if (piece.possibleToMoveLeft(1, board) == true){
        	piece.moveLeft(board); //calls moveLeft method from Piece classes
        }
    }

    /**
     * Move the current tetris piece right.
     */
    void right(TetrisBoard board) {
        tetrisApp.setMessage("right key was pressed!        ");
        System.out.println("right key was pressed!");
        if (piece.possibleToMoveRight(1, board) == true){
        	piece.moveRight(board); //calls moveRight method from Piece classes
        }
    }

    /**
     * Drop the current tetris piece.
     */
    void drop(TetrisBoard tetrisBoard) {
        tetrisApp.setMessage("Drop key was pressed!         ");
        System.out.println("Drop key was pressed!");
        while (TetrisGame.piece.possibleToMoveDown(tetrisBoard) == true){
        	TetrisGame.piece.moveDown();
        }
    }

    /**
     * Rotate the current piece counter-clockwise.
     */
    void rotateLeft(TetrisBoard board) {
        tetrisApp.setMessage("Rotate left key was pressed!  ");
        System.out.println("rotate left key was pressed!");
        
        piece.rotateLeft(board); //calls rotateLeft method from Piece classes
    }
    
    /**
     * Rotate the current piece clockwise.
     */
    void rotateRight(TetrisBoard board) {
        tetrisApp.setMessage("Rotate right key was pressed! ");
        System.out.println("rotate right key was pressed!");
        
        piece.rotateRight(board); //calls rotateRight method from Piece classes
    }
    
}
