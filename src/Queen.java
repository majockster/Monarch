
public class Queen extends Piece{
	
	public Queen(int x, int y) {
		super(x,y);
	}
	public boolean isValidMove(int i, int j, boolean isWhiteTurn) {
		if(Math.abs(super.getX() - i) >= 1 && super.getY() - j == 0) {
			return true;
		}
		if(Math.abs(super.getY() - j) >= 1 && super.getX() - i == 0) {
			return true;
		}
		if(Math.abs(super.getX() - i) == Math.abs(super.getY() - j)) {
			return true;
		}
		return false;
	}

}
