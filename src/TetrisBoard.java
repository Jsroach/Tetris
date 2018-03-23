/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

/**
 * A Pane in which tetris squares can be displayed.
 * 
 * @author pipWolfe & Jack Roach
 */
public class TetrisBoard extends Pane{
    // The size of the side of a tetris square
    public static final int SQUARE_SIZE = 20;
    // The number of squares that fit on the screen in the x and y dimensions
    public static final int X_DIM_SQUARES = 15;
    public static final int Y_DIM_SQUARES = 30; // change this constant if the
    // board is too big for your screen
    
    public static TetrisSquare[][] board = new TetrisSquare[X_DIM_SQUARES][Y_DIM_SQUARES]; //keeps track of presence of blocks on screen

    /**
     * Sizes the board to hold the specified number of squares in the x and y
     * dimensions.
     */
    public TetrisBoard() {
        this.setPrefHeight(Y_DIM_SQUARES*SQUARE_SIZE);
        this.setPrefWidth(X_DIM_SQUARES*SQUARE_SIZE);
        BackgroundFill myBF = new BackgroundFill(Color.LIGHTSTEELBLUE,//LIGHTGOLDENRODYELLOW 
        		new CornerRadii(1),
            new Insets(0.0,0.0,0.0,0.0));// or null for the padding
        setBackground(new Background(myBF));

    }
    
    /**
     * shifts every row above the inputted row number down 1 square
     * @param y
     */
    public static void shiftDown(int y){
    	for (int x = 0; x < X_DIM_SQUARES; x++){
    		board[x][y].removeFromDrawing();
			board[x][y] = null;  
    	}
    	for (int i = y; i > 0; i--){
    		System.out.println("Shifting row: " + i);
    		for(int x = 0; x < X_DIM_SQUARES; x++){
    			if (board[x][i-1] != null){
    				board[x][i-1].moveToTetrisLocation(x, i);
    			}
    			board[x][i] = board[x][i-1];
    			board[x][i-1] = null;  
    		}
    	}
    }
    
    /**
     * checks board array to see if the given coordinates contain a square
     * @param x
     * @param y
     * @return
     */
    public boolean isOccupied(int x, int y){
    	if (x < 0 || x >= X_DIM_SQUARES || y < 0 || y >= Y_DIM_SQUARES){
    		return false;
    	}
    	else{
    		if (board[x][y] == null){
        		return false;
        	}
        	else{
        		return true;
        	}
    	}
    	
    }
    
    /**
     * checks board array to see if a given row is full
     * @param row
     * @return
     */
    public boolean isRowFull(int row){
    	int fill_count = 0;
    	for (int i = 0; i < X_DIM_SQUARES; i++){
    		if (isOccupied(i,row) == true){
    			fill_count++;
    		}
    	}
    	if (fill_count == X_DIM_SQUARES){
    		return true;
    	}
    	else{
    		return false;
    	}
    }
    
    
}
