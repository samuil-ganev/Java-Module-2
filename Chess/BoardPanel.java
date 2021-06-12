package gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import board.Board;

public class BoardPanel extends JPanel{
	
	int margin = 10;
	double imageRatio = 0.9;
	int squareSide = (this.getWidth() - 2 * margin) / 8;;
	Board board;
	Color dark = new Color (224, 123, 57);
	Color light = new Color (235, 139, 66);
	
	public BoardPanel () {
		board = new Board ();
	}
	
	private void drawPieces (Graphics g) {
		for (int i = 0; i < 8; ++i ) {
			for (int j = 0; j < 8; ++j) {
				if (board.getTile(i, j).isOccupied()) {
					Image img = board.getPiece(i, j).getImage();
					Image newImg = img.getScaledInstance((int) (imageRatio * squareSide), (int) (imageRatio * squareSide), Image.SCALE_DEFAULT);
					g.drawImage(newImg, margin + j * squareSide, margin + i * squareSide, this);
				}
			}
		}
	}
	
	@Override
	protected void paintComponent (Graphics g) {
		if (this.getHeight() > this. getWidth()) {
			squareSide = (this.getWidth() - 2 * margin) / 8;
		} else {
			squareSide = (this.getHeight() - 2 * margin) / 8;
		}
		super.paintComponent(g); 
		for (int i = 0; i < 8; ++i) {
			for (int j = 0; j < 8; ++j) {
				if (i % 2 == j % 2) {
					g.setColor(light);
					g.fillRect(margin + i * squareSide, margin + j * squareSide, squareSide, squareSide);
				} else {
					g.setColor(dark);
					g.fillRect(margin + i * squareSide, margin + j * squareSide, squareSide, squareSide);
				}
			}
		}
		
		drawPieces(g);
		
		
	}
	
}
