package com.ncr.chess;

public class ChessBoard {

	public static int MAX_BOARD_WIDTH = 8;// changed to 8 from 7 since the size of chess is 8*8
	public static int MAX_BOARD_HEIGHT = 8;// changed to 8 from 7 since the size of chess is 8*8
	private int blackPawnsValue = 0;
	private int whitePawnsValue = 0;
	private Pawn[][] pieces;

	
	public ChessBoard() {
		pieces = new Pawn[MAX_BOARD_WIDTH][MAX_BOARD_HEIGHT];
	}

	public void addPiece(Pawn pawn, int xCoordinate, int yCoordinate, PieceColor pieceColor) {
		if (!isLegalBoardPosition(xCoordinate, yCoordinate)) {
			System.out.println("Select correct position for correct co-ordinates");
			pawn.setXCoordinate(-1);
			pawn.setYCoordinate(-1);
			pawn.setChessBoard(this);
			pawn.setPieceColor(pieceColor);
			return;
		}
	
		if (pieces[xCoordinate][yCoordinate] != null) {
			pawn.setXCoordinate(-1);
			pawn.setYCoordinate(-1);
			pawn.setChessBoard(this);
			pawn.setPieceColor(pieceColor);
			return;
		}
       
		pawn.setXCoordinate(xCoordinate);
		pawn.setYCoordinate(yCoordinate);
		pawn.setChessBoard(this);
		pawn.setPieceColor(pieceColor);

		switch (pieceColor) {

		case WHITE:
			if (whitePawnsValue <= 7) {
				if (xCoordinate == 1 && 0 <= yCoordinate && yCoordinate < MAX_BOARD_WIDTH) {
					pieces[xCoordinate][yCoordinate] = pawn;
				}
				whitePawnsValue++;
			}
			break;
		case BLACK:
			if (blackPawnsValue <= 7) {
				if (xCoordinate == 6 && 0 <= yCoordinate && yCoordinate < MAX_BOARD_WIDTH) {
					pieces[xCoordinate][yCoordinate] = pawn;
				}
				blackPawnsValue++;
			}
			break;

		}
	}

	public boolean isLegalBoardPosition(int xCoordinate, int yCoordinate) {
		
		if (0 <= yCoordinate && yCoordinate < MAX_BOARD_WIDTH) {
			if (0 <= xCoordinate && xCoordinate < MAX_BOARD_HEIGHT) {
				return true;
			}
		}
		return false;
	}
}
