
public class Bishop extends Piece{

	public Bishop(int x, int y) {
		super(x,y);
	}
	
	public boolean isValidMove(int i, int j, boolean isWhiteTurn) {
		if(Math.abs(super.getX() - i) == Math.abs(super.getY() - j)) {
			return true;
		}
		return false;
	}
}
