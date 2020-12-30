public class Piece {
	private int x;
	private int y;
	private int xChecked;
	private int yChecked;
	private int pastXC;
	private int pastYC;
	private int moveCounter;
	private boolean validTile;
	private boolean kingInDanger;
	private boolean KingIsChecked;
	private boolean canMove;
	private boolean hasUnchecked;
	
	public Piece() {
		
	}
	public Piece(int x, int y) {
		this.x = x;
		this.y = y;
		xChecked = -1;//Avoiding confusion with an actual piece checking at 0,0
		yChecked = -1;
		pastXC = -1;
		pastYC = -1;
		moveCounter = 0;
		validTile = true;
		canMove = true;
		KingIsChecked = false;
		kingInDanger = false;
		hasUnchecked = false;
	}
	public boolean isValidMove(int i, int j, boolean isWhiteTurn) {
		return true;
	}
	public boolean validKill(int i, int j, boolean isWhiteTurn) {
		return true;
	}
	public int getxChecked() {
		return xChecked;
	}
	public void setxChecked(int xChecked) {
		this.xChecked = xChecked;
	}
	public int getyChecked() {
		return yChecked;
	}
	public void setyChecked(int yChecked) {
		this.yChecked = yChecked;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public boolean isValidTile() {
		return validTile;
	}
	public void setValidTile(boolean validTile) {
		this.validTile = validTile;
	}
	public boolean isKingIsChecked() {
		return KingIsChecked;
	}
	public void setKingIsChecked(boolean kingIsChecked) {
		KingIsChecked = kingIsChecked;
	}
		public boolean isCanMove() {
		return canMove;
	}
	public void setCanMove(boolean canMove) {
		this.canMove = canMove;
	}
	public boolean isKingInDanger() {
		return kingInDanger;
	}
	public void setKingInDanger(boolean kingInDanger) {
		this.kingInDanger = kingInDanger;
	}
	public int getPastXC() {
		return pastXC;
	}
	public void setPastXC(int pastXC) {
		this.pastXC = pastXC;
	}
	public int getPastYC() {
		return pastYC;
	}
	public void setPastYC(int pastYC) {
		this.pastYC = pastYC;
	}
	public boolean isHasUnchecked() {
		return hasUnchecked;
	}
	public void setHasUnchecked(boolean hasUnchecked) {
		this.hasUnchecked = hasUnchecked;
	}
	public int getMoveCounter() {
		return moveCounter;
	}
	public void setMoveCounter(int moveCounter) {
		this.moveCounter = moveCounter;
	}
	
	
}
