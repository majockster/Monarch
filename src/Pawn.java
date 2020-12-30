
public class Pawn extends Piece{
	
	public Pawn(int x,int y) {
		super(x,y);
	}
	public boolean isValidMove(int i, int j, boolean isWhiteTurn) {
		if(isWhiteTurn == true) {
			
			if(super.getX() - i == 1 && super.getY() - j == 0) {
				return true;
			}
			if((super.getX() == 6) && super.getX() - i == 2 && super.getY() - j == 0) {
				return true;
			}
			
		}
		if(isWhiteTurn == false) {
			if(super.getX() - i == -1 && super.getY() - j == 0) {
				return true;
			}
			if((super.getX() == 1) && super.getX() - i == -2 && super.getY() - j == 0) {
				return true;
			}
			
		}
		return false;	
	}
	public boolean validKill(int i, int j, boolean isWhiteTurn) {
		if(isWhiteTurn == true) {
			if(super.getX() - i == 1 && Math.abs(super.getY() - j) == 1) {
				return true;
			}
			
		}
		if(isWhiteTurn == false) {
			if(super.getX() - i == -1 && Math.abs(super.getY() - j) == 1) {
				return true;
			}
			
		}
		return false;
	}
	
}
