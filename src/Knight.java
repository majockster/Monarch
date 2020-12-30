
public class Knight extends Piece{
	
	public Knight(int x, int y) {
		super(x,y);
	}
	public boolean isValidMove(int i, int j, boolean isWhiteTurn) {
		int deltaX = Math.abs(i - super.getX());
		int deltaY = Math.abs(j - super.getY());
		
		if(deltaX == 1 && deltaY == 2) {
			return true;//If move valid, false otherwise
		}
		if(deltaX == 2 && deltaY == 1) {
			return true;
		}
		return false;
	}
}
