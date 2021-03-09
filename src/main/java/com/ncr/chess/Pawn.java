package com.ncr.chess;

public class Pawn {

	private ChessBoard chessBoard;
	private int xCoordinate;
	private int yCoordinate;
	private PieceColor pieceColor;

	public Pawn(PieceColor pieceColor) {
		this.pieceColor = pieceColor;
	}

	public ChessBoard getChessBoard() {
		return chessBoard;
	}

	public void setChessBoard(ChessBoard chessBoard) {
		this.chessBoard = chessBoard;
	}

	public int getXCoordinate() {
		return xCoordinate;
	}

	public void setXCoordinate(int value) {
		this.xCoordinate = value;
	}

	public int getYCoordinate() {
		return yCoordinate;
	}

	public void setYCoordinate(int value) {
		this.yCoordinate = value;
	}

	public PieceColor getPieceColor() {
		return this.pieceColor;
	}

	public void setPieceColor(PieceColor value) {
		pieceColor = value;
	}

	public void move(MovementType movementType, int newX, int newY) {
		
		switch (movementType) {

		case MOVE:
			if (this.getYCoordinate() != newY) {
				return;
			}
			if (this.getPieceColor().equals(PieceColor.WHITE)) {

				int latestXCoordinate = this.getXCoordinate();
				if (latestXCoordinate + 1 != newX) {
					return;
				}
				this.setXCoordinate(newX);
			}

			if (this.getPieceColor().equals(PieceColor.BLACK)) {
				int latestXCoordinate = this.getXCoordinate();
				if (latestXCoordinate - 1 != newX) {
					return;
				}
				this.setXCoordinate(newX);
			}
			break;

		case CAPTURE:
			if (this.getPieceColor().equals(PieceColor.WHITE)) {
				int latestXCoordinate = this.getXCoordinate() + 1;
				int latestYCoordinateLeft = this.getYCoordinate() + 1;
				int latestYCoordinateRight = this.getYCoordinate() - 1;
				if (latestXCoordinate == newX && (latestYCoordinateRight == newY || latestYCoordinateLeft == newY)) {
					if(latestYCoordinateRight < 7 && latestYCoordinateLeft>=0) {
						this.setXCoordinate(newX);
						this.setYCoordinate(newY);
					} else {
						return;
					}
					
				} else {
					return;
				}
			}
			if (this.getPieceColor().equals(PieceColor.BLACK)) {
				int latestXCoordinate = this.getXCoordinate() - 1;
				int latestYCoordinateLeft = this.getYCoordinate() + 1;
				int latestYCoordinateRight = this.getYCoordinate() - 1;
				if (latestXCoordinate == newX && (latestYCoordinateRight == newY || latestYCoordinateLeft == newY)) {
					if(latestYCoordinateRight < 7 && latestYCoordinateLeft>=0) {
						this.setXCoordinate(newX);
						this.setYCoordinate(newY);
					} else {
						return;
					}
				} else {
					return;
				}
			}
		}
	}

	@Override
	public String toString() {
		return getCurrentPositionAsString();
	}

	protected String getCurrentPositionAsString() {
		String eol = System.lineSeparator();
		return String.format("Current X: {1}{0}Current Y: {2}{0}Piece Color: {3}", eol, xCoordinate, yCoordinate,
				pieceColor);
	}
}
