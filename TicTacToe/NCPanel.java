package nc;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.*;
import javax.swing.JPanel;



public class NCPanel extends JPanel {
	private static final int NO_WIN = 0;
	private static final int HORIZONTAL_WIN = 1;
	private static final int VERTICAL_WIN = 2;
	private static final int LEFT_INCLINED_WIN = 3;
	private static final int RIGHT_INCLINED_WIN = 4;
	
	private int winComb = NO_WIN;
	private int winningI = -1;
	private int winningJ = -1;
	
    private boolean xOnTurn = true;
    private char[][] board = { {' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '} };

    double boardMarginRatio = 0.1;
    double elementMarginRatio = 0.2;

    int upBoardBorder;
    int downBoardBorder;
    int leftBoardBorder;
    int rightBoardBorder;
    int squareWidth;
    int squareHeight;

    private int checkWin(int i, int j) {
    	if (board[i][0] == board [i][1] && board[i][0] == board[i][2]) {
    		return HORIZONTAL_WIN;
    	} else if (board[0][j] == board [1][j] && board[0][j] == board[2][j]) {
    		return VERTICAL_WIN;
    	} else if (i == j && board[0][0] == board[1][1] && board[0][0] == board[2][2]) {
    		return LEFT_INCLINED_WIN;
    	} else if (i + j == 2 && board[0][2] == board[1][1] && board[0][2] == board[2][0]) {
    		return RIGHT_INCLINED_WIN;
    	} else {
    		return NO_WIN;
    	}
    }

    public NCPanel() {

        this.addMouseListener(new MouseListener() {

            @Override
            public void mouseReleased(MouseEvent e) {}

            @Override
            public void mousePressed(MouseEvent e) {
            	
            	if(winComb != 0) {
            		return;
            	}
            	
                int x = e.getX();
                int y = e.getY();

                for (int i = 0; i < 3; ++i) {

                    for (int j = 0; j < 3; ++j) {

                        if (board[i][j] == ' '
                                && x >leftBorder(j) && x < rightBorder(j)
                                && y < downBorder(i) && y > upBorder(i)) {

                            board[i][j] = xOnTurn ? 'x' : 'o';
                            winComb = checkWin(i, j);
                            
                            if(winComb > NO_WIN) {
                            	winningI = i;
                            	winningJ = j;
                            }
                            
                            xOnTurn = !xOnTurn;
                            repaint();

                        }

                    }

                }

            }

            @Override
            public void mouseExited(MouseEvent e) {}

            @Override
            public void mouseEntered(MouseEvent e) {}

            @Override
            public void mouseClicked(MouseEvent e) {}

        });

    }

    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);
        drawBoard(g);
        if(winComb != NO_WIN) {
        	drawWinner(g);
        }

    }

    private void drawWinner(Graphics g) {
    	Color color = new Color(255, 1, 1, 100); 
    	g.setColor(color); 
    	if (winComb == HORIZONTAL_WIN) {
    		g.drawLine(leftBorder(0), upBorder(winningI) + squareHeight / 2, rightBorder(2), upBorder(winningI) + squareHeight / 2); 
    	} else if (winComb == VERTICAL_WIN) { 
    		g.drawLine(leftBorder(winningJ) + squareWidth / 2, upBorder(0), leftBorder(winningJ) + squareWidth / 2, downBorder(2)); 
    	} else if (winComb == LEFT_INCLINED_WIN) { 
    		g.drawLine(leftBorder(0), upBorder(0), rightBorder(2), downBorder(2)); 
    	}else if (winComb == RIGHT_INCLINED_WIN) { 
    		g.drawLine(rightBorder(2), upBorder(0), leftBorder(0), downBorder(2)); 
    	} 
    }
    
    private void drawBoard(Graphics g) {

        upBoardBorder = (int)(boardMarginRatio * getHeight());
        downBoardBorder = (int)(getHeight() - boardMarginRatio * getHeight());
        leftBoardBorder = (int)(boardMarginRatio * getWidth());
        rightBoardBorder = (int)(getWidth() - boardMarginRatio * getHeight());
        squareWidth = (int)((getWidth() - 2 * boardMarginRatio * getWidth()) / 3);
        squareHeight = (int)((getHeight() - 2 * boardMarginRatio * getHeight()) / 3);

        for (int i = 1; i < 3; ++i) {

            g.drawLine(leftBoardBorder, upBorder(i), rightBoardBorder, upBorder(i));

            g.drawLine(leftBorder(i), upBoardBorder, leftBorder(i), downBoardBorder);

        }

        for (int i = 0; i < 3; ++i) {

            for (int j = 0; j < 3; ++j) {

                if (board[i][j] == 'x') {

                    g.drawLine((int)(leftBorder(j) + elementMarginRatio * squareWidth),
                            (int)(upBorder(i) + elementMarginRatio * squareHeight),
                            (int)(rightBorder(j) - elementMarginRatio * squareWidth),
                            (int)(downBorder(i) - elementMarginRatio * squareHeight));

                    g.drawLine((int)(rightBorder(j) - elementMarginRatio * squareWidth),
                            (int)(upBorder(i) + elementMarginRatio * squareHeight),
                            (int)(leftBorder(j) + elementMarginRatio * squareWidth),
                            (int)(downBorder(i) - elementMarginRatio * squareHeight));

                } else if (board[i][j] == 'o') {

                    g.drawOval((int)(leftBorder(j) + elementMarginRatio * squareWidth),
                            (int)(upBorder(i) + elementMarginRatio * squareHeight),
                            (int)(squareWidth - 2 * elementMarginRatio * squareWidth),
                            (int)(squareWidth - 2 * elementMarginRatio * squareHeight));

                }

            }

        }

    }

    private int leftBorder(int j) {

        return j * squareWidth + leftBoardBorder;

    }

    private int rightBorder(int j) {

        return (j + 1) * squareWidth + leftBoardBorder;

    }

    private int upBorder(int i) {

        return i * squareHeight + upBoardBorder;

    }

    private int downBorder(int i) {

        return (i + 1) * squareHeight + upBoardBorder;

    }

}