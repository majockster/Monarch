
public class Rook extends Piece{
	
	public Rook(int x, int y) {
		super(x,y);
	}
	public boolean isValidMove(int i, int j, boolean isWhiteTurn) {
		if(Math.abs(super.getX() - i) >=1 && super.getY() - j == 0) {
			return true;
		}
		if(super.getX() - i == 0 && Math.abs(super.getY() - j) >= 1) {
			return true;
		}
		return false;
	}
}
