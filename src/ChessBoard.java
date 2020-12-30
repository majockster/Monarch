import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
public class ChessBoard extends JFrame{

	private Container contents;
	private JButton[][] tiles = new JButton[8][8];//Components
	private JButton[][] tiles2 = new JButton[8][8];//Copy of the components
	private Color colorBlack = Color.DARK_GRAY;//Black tiles
	private Piece[]chessPiece = new Piece[32];//Chesspiece objects
	
	//White chesspiece icons to add on buttons
	private ImageIcon Wknight = new ImageIcon("src\\white_knight.png");
	private ImageIcon Wking = new ImageIcon("src\\white_king.png");
	private ImageIcon Wqueen = new ImageIcon("src\\white_queen.png");
	private ImageIcon Wpawn = new ImageIcon("src\\white_pawn.png");
	private ImageIcon Wrook = new ImageIcon("src\\white_rook.png");
	private ImageIcon Wbishop = new ImageIcon("src\\white_bishop.png");
	
	//Black chesspiece icons to add on buttons
	private ImageIcon Bknight = new ImageIcon("src\\black_knight.png");
	private ImageIcon Bking = new ImageIcon("src\\black_king.png");
	private ImageIcon Bqueen = new ImageIcon("src\\black_queen.png");
	private ImageIcon Bpawn = new ImageIcon("src\\black_pawn.png");
	private ImageIcon Brook = new ImageIcon("src\\black_rook.png");
	private ImageIcon Bbishop = new ImageIcon("src\\black_bishop.png");
	
	public ChessBoard() {
		super("Monarch");
		
		//White pawns
		chessPiece[0] = new Pawn(6,0);
		chessPiece[1] = new Pawn(6,1);
		chessPiece[2] = new Pawn(6,2);
		chessPiece[3] = new Pawn(6,3); 
		chessPiece[4] = new Pawn(6,4);
		chessPiece[5] = new Pawn(6,5);
		chessPiece[6] = new Pawn(6,6);
		chessPiece[7] = new Pawn(6,7);
		//Other white pieces
		chessPiece[8] = new Rook(7,0);
		chessPiece[9] = new Knight(7,1);
		chessPiece[10] = new Bishop(7,2);
		chessPiece[11] = new Queen(7,3);
		chessPiece[12] = new King(7,4);
		chessPiece[13] = new Bishop(7,5);
		chessPiece[14] = new Knight(7,6);
		chessPiece[15] = new Rook(7,7);
		//Black pawns
		chessPiece[16] = new Pawn(1,0);
		chessPiece[17] = new Pawn(1,1);
		chessPiece[18] = new Pawn(1,2);
		chessPiece[19] = new Pawn(1,3);
		chessPiece[20] = new Pawn(1,4);
		chessPiece[21] = new Pawn(1,5);
		chessPiece[22] = new Pawn(1,6);
		chessPiece[23] = new Pawn(1,7);
		//Other black pieces
		chessPiece[24] = new Rook(0,0);
		chessPiece[25] = new Knight(0,1);
		chessPiece[26] = new Bishop(0,2);
		chessPiece[27] = new Queen(0,3);
		chessPiece[28] = new King(0,4);
		chessPiece[29] = new Bishop(0,5);
		chessPiece[30] = new Knight(0,6);
		chessPiece[31] = new Rook(0,7);
		
		contents = getContentPane();//To add objects to a JFrame
		contents.setLayout(new GridLayout(8,8));//Sets frame layout to a grid layout
		
		ButtonHandler bHandler = new ButtonHandler();//Action Listener(Event handlers)
		
		
		//Creating and adding board components
		for(int i = 0; i < 8; i++) {
			
			for(int j = 0; j < 8; j++) {
				
				tiles[i][j] = new JButton();//Every tile is a button
				tiles2[i][j] = new JButton();
				
				if((i+j)% 2 != 0) {//Setting black tiles
					tiles[i][j].setBackground(colorBlack);
					tiles2[i][j].setBackground(colorBlack);
				}
				contents.add(tiles[i][j]);//adding the buttons to the frame
				
				tiles[i][j].addActionListener(bHandler);//Adding event when button is clicked
				
				if(i == 0 && j == 6 || i == 0 && j == 1) {
					tiles[i][j].setIcon(Bknight);
					
				}
				if(i == 0 && j == 0 || i == 0 && j == 7) {
					tiles[i][j].setIcon(Brook);
				}
				if(i == 0 && j == 2 || i == 0 && j == 5) {
					tiles[i][j].setIcon(Bbishop);
				}
				if(i == 0 && j == 3) {
					tiles[i][j].setIcon(Bqueen);
				}
				if(i == 0 && j == 4) {
					tiles[i][j].setIcon(Bking);
				}
				if(i == 1) {
					tiles[i][j].setIcon(Bpawn);
				}
				if(i == 6) {
					tiles[i][j].setIcon(Wpawn);
				}
				if(i == 7 && j == 6 || i == 7 && j == 1) {
					tiles[i][j].setIcon(Wknight);
				}
				if(i == 7 && j == 0 || i == 7 && j == 7) {
					tiles[i][j].setIcon(Wrook);
				}
				if(i == 7 && j == 2 || i == 7 && j == 5) {
					tiles[i][j].setIcon(Wbishop);
				}
				if(i == 7 && j == 3) {
					tiles[i][j].setIcon(Wqueen);
				}
				if(i == 7 && j == 4) {
					tiles[i][j].setIcon(Wking);
				}
				
			}
		}
		
		//Size and display window
		setSize(500,500);
		setResizable(true);
		setLocationRelativeTo(null);//Centers window
		setVisible(true);
		
		 
	}
	/**
	 * Displays in color the different move possibilities a selected piece can make
	 * @param xClicked
	 * @param yClicked
	 * @param isWhiteTurn
	 */
	public void DisplayMovePossibilities(int xClicked, int yClicked, boolean isWhiteTurn) {
		
		boolean firstPawnMove = true;
				
		for(int i = 0; i < chessPiece.length; i++) {
			
			if(isWhiteTurn == false) {//Black turn
				
				
					for(int x = 0; x < 8; x++) {
						for(int y = 0; y < 8; y++) {
							
							if(xClicked == chessPiece[i].getX() && yClicked == chessPiece[i].getY()) {	
								//Displaying color for castling
								if(x == chessPiece[28].getX() && y == chessPiece[28].getY() && chessPiece[28].getMoveCounter() == 0 && chessPiece[24].getX() != -1 && chessPiece[28].getX() != -1 && chessPiece[24].getMoveCounter() == 0 && tiles[0][1].getIcon() == null && tiles[0][2].getIcon() == null && tiles[0][3].getIcon() == null) {
									tiles[0][2].setBackground(Color.RED);
								}
								//Displaying color for castling
								if(x == chessPiece[28].getX() && y == chessPiece[28].getY() && chessPiece[28].getMoveCounter() == 0 && chessPiece[31].getX() != -1 && chessPiece[12].getX() != -1 && chessPiece[31].getMoveCounter() == 0 && tiles[0][5].getIcon() == null && tiles[0][6].getIcon() == null) {
									tiles[0][6].setBackground(Color.RED);
								}
								//Only displaying legal moves (taking obstacles into account)
								if((chessPiece[i].isValidMove(x, y, isWhiteTurn) == true ||(chessPiece[i].getClass().getSimpleName().equals("Pawn") && tiles[x][y].getIcon() != null && (chessPiece[i].isValidMove(x, y, isWhiteTurn) == true || chessPiece[i].validKill(x, y, isWhiteTurn)))) && isWhiteTurn == false) {
									
									//A friendly piece is an obstacle, must be skipped
									if(tiles[x][y].getIcon() != null && tiles[x][y].getIcon().toString().contains("black")) {
										
										continue;
									}
									if(tiles[x][y].getIcon() != null && tiles[x][y].getIcon().toString().contains("white")) {
										if(chessPiece[i].getClass().getSimpleName().equals("Pawn") && y == yClicked && x == 2) {
											firstPawnMove = false;
										}
										//continue;
									}
									//Avoiding crash
									if((!tiles[xClicked][yClicked].getIcon().toString().contains("black_knight") && !tiles[xClicked][yClicked].getIcon().toString().contains("black_king")) && !PathIsFree(xClicked, yClicked, x, y, isWhiteTurn)) {
										continue;
									}
									//Tile of checked king must not be colored
									if((x == chessPiece[12].getX() && y == chessPiece[12].getY() && chessPiece[12].isKingIsChecked() == true) || (x == chessPiece[28].getX() && y == chessPiece[28].getY() && chessPiece[28].isKingIsChecked() == true)) {
										continue;
									}
									if(firstPawnMove == false) {
										continue;
									}
									System.out.println("Displaying black");
									tiles[x][y].setBackground(Color.RED);
									
									
								}
								
							}
						}
					}
			}
			firstPawnMove = true;
			
			if(isWhiteTurn == true) {//White turn
				
				
					for(int x = 7; x > -1; x--) {
						for(int y = 7; y > -1; y--) {
							
							if(xClicked == chessPiece[i].getX() && yClicked == chessPiece[i].getY()) {
								
								//Displaying color for castling
								if(x == chessPiece[12].getX() && y == chessPiece[12].getY() && chessPiece[12].getMoveCounter() == 0 && chessPiece[8].getX() != -1 && chessPiece[12].getX() != -1 && chessPiece[8].getMoveCounter() == 0 && tiles[7][1].getIcon() == null && tiles[7][2].getIcon() == null && tiles[7][3].getIcon() == null) {
									tiles[7][2].setBackground(Color.GREEN);
								}
								//Displaying color for castling
								if(x == chessPiece[12].getX() && y == chessPiece[12].getY() && chessPiece[12].getMoveCounter() == 0 && chessPiece[15].getX() != -1 && chessPiece[12].getX() != -1 && chessPiece[15].getMoveCounter() == 0 && tiles[7][5].getIcon() == null && tiles[7][6].getIcon() == null) {
									tiles[7][6].setBackground(Color.GREEN);
								}
								//Only displaying legal moves(taking into account obstacles)
								if((chessPiece[i].isValidMove(x, y, isWhiteTurn) == true || (chessPiece[i].getClass().getSimpleName().equals("Pawn") && tiles[x][y].getIcon() != null && (chessPiece[i].isValidMove(x, y, isWhiteTurn) == true || chessPiece[i].validKill(x, y, isWhiteTurn)))) && isWhiteTurn == true) {
									//Tile of checked king cannot colored
									if((x == chessPiece[28].getX() && y == chessPiece[28].getY() && chessPiece[28].isKingIsChecked() == true) || (x == chessPiece[12].getX() && y == chessPiece[12].getY() && chessPiece[12].isKingIsChecked() == true)) {
										continue;
									}
									//A friendly piece is an obstacle, must not be colored
									if(tiles[x][y].getIcon() != null && tiles[x][y].getIcon().toString().contains("white")) {
										continue;
									}
									if(tiles[x][y].getIcon() != null && tiles[x][y].getIcon().toString().contains("black")) {
										if(chessPiece[i].getClass().getSimpleName().equals("Pawn") && y == yClicked && x == 5) {
											firstPawnMove = false;
										}
										//continue;
									}
									//Avoiding crash
									if((!tiles[xClicked][yClicked].getIcon().toString().contains("white_knight") && !tiles[xClicked][yClicked].getIcon().toString().contains("white_king")) && !PathIsFree(xClicked, yClicked, x, y, isWhiteTurn)) {
										continue;	
									}
									if(firstPawnMove == false) {
										continue;
									}
									System.out.println("Displaying white");
									tiles[x][y].setBackground(Color.GREEN);
									
									
									//Rook check king 	
								}
							}
					}
				}
			}
		
		}
		return;	
	}
	/**
	 * Tests if a potential new position threatens a friendly king
	 * @param a
	 * @param b
	 * @param isWhiteTurn
	 */
	public void KingInDanger(int a, int b, boolean isWhiteTurn) {
		
		for(int i = 0; i < chessPiece.length; i++) {
			
			if(isWhiteTurn == false) {//Black turn
				
				for(int x = 0; x < 8; x++) {
					for(int y = 0; y < 8; y++) {
						//Skip over friendly pieces
						if(tiles[x][y].getIcon() != null && tiles[x][y].getIcon().toString().contains("black")) {
							continue;
						}
						//A pawn can threaten the king
						if(tiles[x][y].getIcon() != null && tiles[x][y].getIcon().toString().contains("white_pawn") && x == chessPiece[i].getX() && y == chessPiece[i].getY() && (x != a || y!= b)&& chessPiece[i].validKill(a, b, !isWhiteTurn)) {
							chessPiece[28].setKingInDanger(true);
							return;
						}
						//A king in any enemy piece's way can be threatened
						if(tiles[x][y].getIcon() != null && tiles[x][y].getIcon().toString().contains("white") && !tiles[x][y].getIcon().toString().contains("pawn") && x == chessPiece[i].getX() && y == chessPiece[i].getY() && (x != a || y != b) && chessPiece[i].isValidMove(a, b, true) == true && PathIsFree(x, y, a, b, !isWhiteTurn)) {
							chessPiece[28].setKingInDanger(true);
							return;
						}
					}
				}
			
				chessPiece[28].setKingInDanger(false);//If after searching board no piece threatens the king
				
			}
			
			
			if(isWhiteTurn == true) {//White turn
				
				for(int x = 7; x > -1; x--) {
					for(int y = 7; y > -1; y--) {
						//Skip over friendly pieces
						if(tiles[x][y].getIcon() != null && tiles[x][y].getIcon().toString().contains("white")) {
							continue;
						}
						//A pawn can threaten the king
						if(tiles[x][y].getIcon() != null && tiles[x][y].getIcon().toString().contains("black_pawn") && x == chessPiece[i].getX() && y == chessPiece[i].getY() && (x != a || y!= b) && chessPiece[i].validKill(a, b, !isWhiteTurn)) {
							chessPiece[12].setKingInDanger(true);
							return;
						}
						//A king in any enemy piece's way can be threatened
						if(tiles[x][y].getIcon() != null && tiles[x][y].getIcon().toString().contains("black") && !tiles[x][y].getIcon().toString().contains("pawn") && x == chessPiece[i].getX() && y == chessPiece[i].getY() && (x != a || y!= b) && chessPiece[i].isValidMove(a, b, false) == true && PathIsFree(x, y, a, b, !isWhiteTurn)) {
							chessPiece[12].setKingInDanger(true);
							return;
						}
					} 
				}
				chessPiece[12].setKingInDanger(false); //If after searching board no piece threatens the king
				
			}
			
		}
		return;
		
	}
	
	/**
	 * The process of moving a piece(+killing a piece)
	 * @param i
	 * @param j
	 * @param xClicked
	 * @param yClicked
	 * @param isWhiteTurn
	 */
	public void processClick(int i, int j, int xClicked, int yClicked, boolean isWhiteTurn) {
		 boolean WKingIsChecked = false;
		 boolean BKingIsChecked = false;
		 boolean NoObstacles = false;
		 
		if(isWhiteTurn == true) {
			System.out.println("Moving white piece...");
			
			for(int k = 0; k < chessPiece.length; k++) {
				
				//Pawn kills
				if(tiles[xClicked][yClicked].getIcon().equals(Wpawn) && chessPiece[k].getClass().getSimpleName().equals("Pawn") && xClicked == chessPiece[k].getX() && yClicked == chessPiece[k].getY() && tiles[i][j].getIcon() != null) {
					chessPiece[12].setKingInDanger(false);
					
					
					if(chessPiece[k].validKill(i, j, isWhiteTurn) == false) {//An invalid kill is an invalid move
						chessPiece[k].setCanMove(false);
						return;
					}
					chessPiece[k].setCanMove(true);
					
					NoObstacles = PathIsFree(xClicked,yClicked,i,j,isWhiteTurn);//Making sure the pawn is free to move
					if(NoObstacles == false) {
						chessPiece[k].setValidTile(false);
						return;
					}
					
					chessPiece[k].setValidTile(true);
					
					//If the friendly king is checked
					if(chessPiece[12].isKingIsChecked()) {
							
					chessPiece[12].setKingInDanger(true);	
					
					for(int x = 0; x < chessPiece.length; x++) {
						System.out.println("xChecked: " + chessPiece[x].getxChecked() + " yChecked: " + chessPiece[x].getyChecked());
						System.out.println("i: " + chessPiece[k].getX() + " j: " + chessPiece[k].getY());
						System.out.println("PAWN KILLING CHECKING PIECE");
						
						//If a piece kills checking piece
						if(chessPiece[x].getxChecked() == i && chessPiece[x].getyChecked() == j) {
							
							WKingIsChecked = false;
							chessPiece[12].setKingIsChecked(WKingIsChecked);
							chessPiece[12].setKingInDanger(false);
							
							tiles[xClicked][yClicked].setIcon(null);
							tiles[i][j].setIcon(Wpawn);
							chessPiece[k].setX(i);
							chessPiece[k].setY(j);
							BKingIsChecked = isChecked(chessPiece[k].getX(), chessPiece[k].getY(), isWhiteTurn);
							chessPiece[28].setKingIsChecked(BKingIsChecked);
					
							if(BKingIsChecked) {
								chessPiece[28].setKingInDanger(true);
							}
							//Changing tile color of checked king
							for(int y = 0; y < 8; y++) {
								for(int z = 0; z < 8; z++) {
									
									if(y == chessPiece[12].getX() && z == chessPiece[12].getY()) {
										System.out.println("tiles2: "+tiles2[y][z].getBackground());
										System.out.println("tiles: "+tiles[y][z].getBackground());
										tiles[y][z].setBackground(tiles2[y][z].getBackground());
										chessPiece[x].setxChecked(-1);//Or set to 0, -1 as if setting an int to null
										chessPiece[x].setyChecked(-1);
										return;
									}
								}
							}
							
							
						}
						
						
						
					}
					//If king is still in danger/making sure king's safety is the priority
					if(chessPiece[12].isKingInDanger()) {
						tiles[i][j].setIcon(null);
						tiles[xClicked][yClicked].setIcon(Wpawn);
						chessPiece[k].setX(xClicked);
						chessPiece[k].setY(yClicked);
						chessPiece[k].setCanMove(false);
						System.out.println("MOVE INVALID TRY AGAIN");
						return;
					}
					
					}
					
					
					Icon killed = tiles[i][j].getIcon();
					
					tiles[xClicked][yClicked].setIcon(null);//verify later
					tiles[i][j].setIcon(Wpawn);
					chessPiece[k].setX(i);
					chessPiece[k].setY(j);
					
					for(int x = 0; x < chessPiece.length; x++) {
						
						
						//If pawn killed regular piece
						if(chessPiece[x].getPastXC() == -1 && chessPiece[x].getPastYC() == -1 && i == chessPiece[x].getX() && j == chessPiece[x].getY()) {
							chessPiece[x].setX(-1);
							chessPiece[x].setY(-1);
							//break;
						}
						//If pawn killed piece that has already checked king before
						if(chessPiece[x].getPastXC() > -1 && chessPiece[x].getPastYC() > -1 && i == chessPiece[x].getPastXC() && j == chessPiece[x].getPastYC() && tiles[chessPiece[x].getPastXC()][chessPiece[x].getPastYC()].getIcon().toString().contains("black")) {
							chessPiece[x].setPastXC(-1);
							chessPiece[x].setPastYC(-1);
							chessPiece[x].setX(-1);
							chessPiece[x].setY(-1);
							//break;
						}
						//If pawn exposes king to a check
						//else {
							
							for(int y = 0; y < 8; y++) {
								for(int z = 0; z < 8; z++) {
								
									if(tiles[y][z].getIcon() != null && tiles[y][z].getIcon().toString().contains("black")  && y == chessPiece[x].getX() && z == chessPiece[x].getY() && chessPiece[x].isValidMove(chessPiece[12].getX(), chessPiece[12].getY(), isWhiteTurn) && PathIsFree(y, z, chessPiece[12].getX(), chessPiece[12].getY(),false)) {
										chessPiece[12].setKingInDanger(true);
										tiles[i][j].setIcon(null);
										tiles[i][j].setIcon(killed);
										tiles[xClicked][yClicked].setIcon(Wpawn);
										chessPiece[k].setX(xClicked);
										chessPiece[k].setY(yClicked);
										System.out.println("EXPOSING KING");
										return;
									}
								}
							}
						
						//}
					}
					//Moving pawn normally
					tiles[i][j].setIcon(Wpawn);
					chessPiece[k].setX(i);
					chessPiece[k].setY(j);
					
					
					
					BKingIsChecked = isChecked(chessPiece[k].getX(), chessPiece[k].getY(), isWhiteTurn);
					chessPiece[28].setKingIsChecked(BKingIsChecked);
				
					if(BKingIsChecked) {
						chessPiece[28].setKingInDanger(true);
					}
					
					
					return;
				}
				//Moving pawn but no kill
				if(tiles[xClicked][yClicked].getIcon().equals(Wpawn) && chessPiece[k].getClass().getSimpleName().equals("Pawn") && xClicked == chessPiece[k].getX() && yClicked == chessPiece[k].getY()) {
					
					
					chessPiece[12].setKingInDanger(false);
					//Making sure a pawn makes a legal move
					if(chessPiece[k].isValidMove(i, j, isWhiteTurn) == false) {
						chessPiece[k].setCanMove(false);
						System.out.println("MOVE INVALID TRY AGAIN");
						return;
					}
					chessPiece[k].setCanMove(true);
					//Making the pawn is free to move
					NoObstacles = PathIsFree(xClicked,yClicked,i,j,isWhiteTurn);
					if(NoObstacles == false) {
						chessPiece[k].setValidTile(false);
						return;
					}
					chessPiece[k].setValidTile(true);
					
					//If friendly king is checked
					if(chessPiece[12].isKingIsChecked()) {
						
						chessPiece[12].setKingInDanger(true);	
						System.out.println("PAWN WILL PROTECT KING");
						//Moving the pawn
						tiles[xClicked][yClicked].setIcon(null);
						tiles[i][j].setIcon(Wpawn);
						chessPiece[k].setX(i);
						chessPiece[k].setY(j);
						//Test if pawn is checking opposite king
						BKingIsChecked = isChecked(chessPiece[k].getX(), chessPiece[k].getY(), isWhiteTurn);
						chessPiece[28].setKingIsChecked(BKingIsChecked);
						if(BKingIsChecked) {
							chessPiece[28].setKingInDanger(true);
						}
						
					for(int x = 0; x < chessPiece.length; x++) {
						
						System.out.println("xChecked: " + chessPiece[x].getxChecked() + " yChecked: " + chessPiece[x].getyChecked());
						System.out.println("i: " + chessPiece[k].getX() + " j: " + chessPiece[k].getY());
						
						//When a pawn gets in the path of a checking piece
						if(chessPiece[x].getxChecked() > -1 && chessPiece[x].getyChecked() > -1 && PathIsFree(chessPiece[x].getxChecked(),chessPiece[x].getyChecked(), chessPiece[12].getX(), chessPiece[12].getY(), false) == false ) {
							WKingIsChecked = false;
							chessPiece[12].setKingIsChecked(WKingIsChecked);
							chessPiece[12].setKingInDanger(false);
	
							for(int y = 0; y < 8; y++) {
								for(int z = 0; z < 8; z++) {
									//Changing tile color of checked king
									if(y == chessPiece[12].getX() && z == chessPiece[12].getY()) {
										System.out.println("tiles2: "+tiles2[y][z].getBackground());
										System.out.println("tiles: "+tiles[y][z].getBackground());
										tiles[y][z].setBackground(tiles2[y][z].getBackground());
										chessPiece[x].setPastXC(chessPiece[x].getxChecked());//Adding checking coord to a temp variable
										chessPiece[x].setPastYC(chessPiece[x].getyChecked());
										chessPiece[x].setxChecked(-1);//Or set to 0, -1 as if setting an int to null
										chessPiece[x].setyChecked(-1);
										
										return;
									}
								}
							}
							
						}	
						
					}
					//If king is still in danger/making sure king's safety is priority
					if(chessPiece[12].isKingInDanger()) {
						tiles[i][j].setIcon(null);
						tiles[xClicked][yClicked].setIcon(Wpawn);
						chessPiece[k].setX(xClicked);
						chessPiece[k].setY(yClicked);
						chessPiece[k].setCanMove(false);
						System.out.println("MOVE INVALID TRY AGAIN");
						return;
					}
					
					}
					
					tiles[xClicked][yClicked].setIcon(null);
					tiles[i][j].setIcon(Wpawn);
					chessPiece[k].setX(i);
					chessPiece[k].setY(j);
					
					for(int x = 0; x < chessPiece.length; x++) {
						
						
						for(int y = 0; y < 8; y++) {
							for(int z = 0; z < 8; z++) {
								//if moving the pawn exposes the king to a check
								if(tiles[y][z].getIcon() != null && tiles[y][z].getIcon().toString().contains("black")  && y == chessPiece[x].getX() && z == chessPiece[x].getY() && chessPiece[x].isValidMove(chessPiece[12].getX(), chessPiece[12].getY(), isWhiteTurn) && PathIsFree(y, z, chessPiece[12].getX(), chessPiece[12].getY(),false) == true) {
									chessPiece[12].setKingInDanger(true);
									tiles[i][j].setIcon(null);
									tiles[xClicked][yClicked].setIcon(Wpawn);
									chessPiece[k].setX(xClicked);
									chessPiece[k].setY(yClicked);
									System.out.println("EXPOSING KING");
									return;
								}
							}
						}
					}
					
					//Moving the pawn normally
					tiles[i][j].setIcon(Wpawn);
					chessPiece[k].setX(i);
					chessPiece[k].setY(j);
					BKingIsChecked = isChecked(chessPiece[k].getX(), chessPiece[k].getY(), isWhiteTurn);
					chessPiece[28].setKingIsChecked(BKingIsChecked);
					if(BKingIsChecked) {
						chessPiece[28].setKingInDanger(true);
					}
					chessPiece[k].setHasUnchecked(false);
					
				
					return;
				}
				
				if(tiles[xClicked][yClicked].getIcon().equals(Wknight) && chessPiece[k].getClass().getSimpleName().equals("Knight") && xClicked == chessPiece[k].getX() && yClicked == chessPiece[k].getY() && chessPiece[k].isValidMove(i,j,isWhiteTurn)) {
					
					chessPiece[12].setKingInDanger(false);
					//Making sure the knight makes a legal move
					if(chessPiece[k].isValidMove(i, j, isWhiteTurn) == false) {
						chessPiece[k].setCanMove(false);
						System.out.println("MOVE INVALID TRY AGAIN");
						return;
					}
					chessPiece[k].setCanMove(true);
					
					
					//If the friendly king is checked
					if(chessPiece[12].isKingIsChecked()) {
					
					chessPiece[12].setKingInDanger(true);
					//Moving the knight
					tiles[xClicked][yClicked].setIcon(null);
					tiles[i][j].setIcon(Wknight);
					chessPiece[k].setX(i);
					chessPiece[k].setY(j);
					BKingIsChecked = isChecked(chessPiece[k].getX(), chessPiece[k].getY(), isWhiteTurn);
					chessPiece[28].setKingIsChecked(BKingIsChecked);
					if(BKingIsChecked) {
						chessPiece[28].setKingInDanger(true);
					}
					
					for(int x = 0; x < chessPiece.length; x++) {
						//If the knight kills the checking piece
						if(chessPiece[x].getxChecked() == i && chessPiece[x].getyChecked() == j) {
							WKingIsChecked = false;
							chessPiece[12].setKingIsChecked(WKingIsChecked);
							chessPiece[12].setKingInDanger(false);
							
							for(int y = 0; y < 8; y++) {
								for(int z = 0; z < 8; z++) {
									//Changing tile color for checked king
									if(y == chessPiece[12].getX() && z == chessPiece[12].getY()) {
										System.out.println("tiles2: "+tiles2[y][z].getBackground());
										System.out.println("tiles: "+tiles[y][z].getBackground());
										tiles[y][z].setBackground(tiles2[y][z].getBackground());
										chessPiece[x].setxChecked(-1);//Or set to 0, -1 as if setting an int to null
										chessPiece[x].setyChecked(-1);
										return;
									}
								}
							}
						}
						//If the knight is in the path of the checking piece
						if(chessPiece[x].getxChecked() > -1 && chessPiece[x].getyChecked() > -1 && PathIsFree(chessPiece[x].getxChecked(),chessPiece[x].getyChecked(), chessPiece[12].getX(), chessPiece[12].getY(), false) == false) {
							WKingIsChecked = false;
							chessPiece[12].setKingIsChecked(WKingIsChecked);
							chessPiece[12].setKingIsChecked(false);
							
							for(int y = 0; y < 8; y++) {
								for(int z = 0; z < 8; z++) {
									//Changing tile color for checked king
									if(y == chessPiece[12].getX() && z == chessPiece[12].getY()) {
										System.out.println("tiles2: "+tiles2[y][z].getBackground());
										System.out.println("tiles: "+tiles[y][z].getBackground());
										tiles[y][z].setBackground(tiles2[y][z].getBackground());
										chessPiece[x].setPastXC(chessPiece[x].getxChecked());//Adding checking coord to temp variable
										chessPiece[x].setPastYC(chessPiece[x].getyChecked());
										chessPiece[x].setxChecked(-1);//Or set to 0, -1 as if setting an int to null
										chessPiece[x].setyChecked(-1);
										return;
									}
								}
							}
						}
						
						
					}
					//If the king is still in danger/making the king's safety is priority
					if(chessPiece[12].isKingInDanger()) {
						tiles[i][j].setIcon(null);
						tiles[xClicked][yClicked].setIcon(Wknight);
						chessPiece[k].setX(xClicked);
						chessPiece[k].setY(yClicked);
						chessPiece[k].setCanMove(false);
						System.out.println("MOVE INVALID TRY AGAIN");
						return;
					}
					
					}
					
					tiles[xClicked][yClicked].setIcon(null);
					
					for(int x = 0; x < chessPiece.length; x++) {
						
						//If a knight kills a piece normally
						if(chessPiece[x].getPastXC() == -1 && chessPiece[x].getPastYC()== -1 && i == chessPiece[x].getX() && j == chessPiece[x].getY()) {
							chessPiece[x].setX(-1);
							chessPiece[x].setY(-1);
							break;
						}
						//If a knight kills a piece that has previously checked a friendly king
						if(chessPiece[x].getPastXC() > -1 && chessPiece[x].getPastYC() > -1 && i == chessPiece[x].getPastXC() && j == chessPiece[x].getPastYC() && tiles[chessPiece[x].getPastXC()][chessPiece[x].getPastYC()].getIcon().toString().contains("black")) {
							chessPiece[x].setPastXC(-1);
							chessPiece[x].setPastYC(-1);
							chessPiece[x].setX(-1);
							chessPiece[x].setY(-1);
							break;
						}
						
						else {
						//If king is still in danger/making sure king's safety is priority
							for(int y = 0; y < 8; y++) {
								for(int z = 0; z < 8; z++) {
								
									if(tiles[y][z].getIcon() != null && tiles[y][z].getIcon().toString().contains("black")  && y == chessPiece[x].getX() && z == chessPiece[x].getY() && chessPiece[x].isValidMove(chessPiece[12].getX(), chessPiece[12].getY(), isWhiteTurn) && PathIsFree(y, z, chessPiece[12].getX(), chessPiece[12].getY(),false)) {
										chessPiece[12].setKingInDanger(true);
										tiles[xClicked][yClicked].setIcon(Wknight);
										System.out.println("EXPOSING KING");
										return;
									}
								}
							}
						
						}
					}

					//Moving the knight normally
					tiles[i][j].setIcon(Wknight);
					chessPiece[k].setX(i);
					chessPiece[k].setY(j);
					BKingIsChecked = isChecked(chessPiece[k].getX(), chessPiece[k].getY(), isWhiteTurn);
					chessPiece[28].setKingIsChecked(BKingIsChecked);
					if(BKingIsChecked) {
						chessPiece[28].setKingInDanger(true);
					}
					
					return;
				}
				
				if(tiles[xClicked][yClicked].getIcon().equals(Wrook) && chessPiece[k].getClass().getSimpleName().equals("Rook") && xClicked == chessPiece[k].getX() && yClicked == chessPiece[k].getY()) {
					
					chessPiece[12].setKingInDanger(false);
					
					//Making sure the rook makes a legal move
					if(chessPiece[k].isValidMove(i, j, isWhiteTurn) == false) {
						chessPiece[k].setCanMove(false);
						System.out.println("MOVE INVALID TRY AGAIN");
						return;
					}
					chessPiece[k].setCanMove(true);
					
					//Making sure the rook is free to move
					NoObstacles = PathIsFree(xClicked,yClicked,i,j,isWhiteTurn);
					if(NoObstacles == false) {
						chessPiece[k].setValidTile(false);
						return;
					}
					chessPiece[k].setValidTile(true);
					
					//If the friendly king is checked
					if(chessPiece[12].isKingIsChecked()) {
					
					chessPiece[12].setKingInDanger(true);	
					//Moving rook
					tiles[xClicked][yClicked].setIcon(null);
					tiles[i][j].setIcon(Wrook);
					chessPiece[k].setX(i);
					chessPiece[k].setY(j);
					chessPiece[k].setMoveCounter(chessPiece[k].getMoveCounter() + 1);//Incrementing move counter to test for castling
					BKingIsChecked = isChecked(chessPiece[k].getX(), chessPiece[k].getY(), isWhiteTurn);
					chessPiece[28].setKingIsChecked(BKingIsChecked);
					if(BKingIsChecked) {
						chessPiece[28].setKingInDanger(true);
					}	
						
					for(int x = 0; x < chessPiece.length; x++) {
						//If rook kills checking piece
						if(chessPiece[x].getxChecked() == i && chessPiece[x].getyChecked() == j) {
							WKingIsChecked = false;
							chessPiece[12].setKingIsChecked(WKingIsChecked);
							chessPiece[12].setKingInDanger(false);
							
							for(int y = 0; y < 8; y++) {
								for(int z = 0; z < 8; z++) {
									//Changing tile color of checked king
									if(y == chessPiece[12].getX() && z == chessPiece[12].getY()) {
										System.out.println("tiles2: "+tiles2[y][z].getBackground());
										System.out.println("tiles: "+tiles[y][z].getBackground());
										tiles[y][z].setBackground(tiles2[y][z].getBackground());
										chessPiece[x].setxChecked(-1);//Or set to 0, -1 as if setting an int to null
										chessPiece[x].setyChecked(-1);
										return;
									}
								}
							}
						}
						//If rook moves into path of checking piece
						if(chessPiece[x].getxChecked() > -1 && chessPiece[x].getyChecked() > -1 && PathIsFree(chessPiece[x].getxChecked(),chessPiece[x].getyChecked(), chessPiece[12].getX(), chessPiece[12].getY(), false) == false) {
							WKingIsChecked = false;
							chessPiece[12].setKingIsChecked(WKingIsChecked);
							chessPiece[12].setKingInDanger(false);
							
							for(int y = 0; y < 8; y++) {
								for(int z = 0; z < 8; z++) {
									//Changing tile color of checked king
									if(y == chessPiece[12].getX() && z == chessPiece[12].getY()) {
										System.out.println("tiles2: "+tiles2[y][z].getBackground());
										System.out.println("tiles: "+tiles[y][z].getBackground());
										tiles[y][z].setBackground(tiles2[y][z].getBackground());
										chessPiece[x].setPastXC(chessPiece[x].getxChecked());//Assigning coordinates of checking piece to a temp variable
										chessPiece[x].setPastYC(chessPiece[x].getyChecked());
										chessPiece[x].setxChecked(-1);//Or set to 0, -1 as if setting an int to null
										chessPiece[x].setyChecked(-1);
										return;
									}
								}
							}
						}
						
						
					}
					//If king is still threatened/making sure king's safety is priority
					if(chessPiece[12].isKingInDanger()) {
						tiles[i][j].setIcon(null);
						tiles[xClicked][yClicked].setIcon(Wrook);
						chessPiece[k].setX(xClicked);
						chessPiece[k].setY(yClicked);
						chessPiece[k].setCanMove(false);
						chessPiece[k].setMoveCounter(chessPiece[k].getMoveCounter() - 1);
						System.out.println("MOVE INVALID TRY AGAIN");
						return;
					}
					
					}
					
					tiles[xClicked][yClicked].setIcon(null);
					
					for(int x = 0; x < chessPiece.length; x++) {
						//If rook kills normal piece
						if(chessPiece[x].getPastXC() == -1 && chessPiece[x].getPastYC() == -1 && i == chessPiece[x].getX() && j == chessPiece[x].getY()) {
							chessPiece[x].setX(-1);
							chessPiece[x].setY(-1);
							break;
						}
						//If rook kills piece that has previously checked friendly king
						if(chessPiece[x].getPastXC() > -1 && chessPiece[x].getPastYC() > -1 && i == chessPiece[x].getPastXC() && j == chessPiece[x].getPastYC() && tiles[chessPiece[x].getPastXC()][chessPiece[x].getPastYC()].getIcon().toString().contains("black")) {
							chessPiece[x].setPastXC(-1);
							chessPiece[x].setPastYC(-1);
							chessPiece[x].setX(-1);
							chessPiece[x].setY(-1);
							break;
						}
						
						else {
						//Making sure rook does not expose friendly king	
						for(int y = 0; y < 8; y++) {
							for(int z = 0; z < 8; z++) {
								
								if(tiles[y][z].getIcon() != null && tiles[y][z].getIcon().toString().contains("black")  && y == chessPiece[x].getX() && z == chessPiece[x].getY() && chessPiece[x].isValidMove(chessPiece[12].getX(), chessPiece[12].getY(), isWhiteTurn) && PathIsFree(y, z, chessPiece[12].getX(), chessPiece[12].getY(),false)) {
									chessPiece[12].setKingInDanger(true);
									tiles[xClicked][yClicked].setIcon(Wrook);
									System.out.println("EXPOSING KING");
									return;
								}
							}
						}
						
						}
					}

					//Moving normally
					tiles[i][j].setIcon(Wrook);
					chessPiece[k].setX(i);
					chessPiece[k].setY(j);
					chessPiece[k].setMoveCounter(chessPiece[k].getMoveCounter() + 1);//Incrementing move counter to test for castling
					
					BKingIsChecked = isChecked(chessPiece[k].getX(), chessPiece[k].getY(), isWhiteTurn);
					chessPiece[28].setKingIsChecked(BKingIsChecked);
					if(BKingIsChecked) {
						chessPiece[28].setKingInDanger(true);
					}	
					return;
				}
				
				//Moving bishop
				if(tiles[xClicked][yClicked].getIcon().equals(Wbishop) && chessPiece[k].getClass().getSimpleName().equals("Bishop") && xClicked == chessPiece[k].getX() && yClicked == chessPiece[k].getY()) {
					
					chessPiece[12].setKingInDanger(false);
					//Making sure bishop makes a legal move
					if(chessPiece[k].isValidMove(i, j, isWhiteTurn) == false) {
						chessPiece[k].setCanMove(false);
						System.out.println("MOVE INVALID TRY AGAIN");
						return;
					}
					chessPiece[k].setCanMove(true);
					//Making sure bishop is free to move
					NoObstacles = PathIsFree(xClicked,yClicked,i,j,isWhiteTurn);
					if(NoObstacles == false) {
						chessPiece[k].setValidTile(false);
						return;
					}
					chessPiece[k].setValidTile(true);
					
					//If friendly king is checked 
					if(chessPiece[12].isKingIsChecked()) {	
						
					chessPiece[12].setKingInDanger(true);	
					//Moving bishop
					tiles[xClicked][yClicked].setIcon(null);
					tiles[i][j].setIcon(Wbishop);
					chessPiece[k].setX(i);
					chessPiece[k].setY(j);
					
					BKingIsChecked = isChecked(chessPiece[k].getX(), chessPiece[k].getY(), isWhiteTurn);
					chessPiece[28].setKingIsChecked(BKingIsChecked);
					if(BKingIsChecked) {
						chessPiece[28].setKingInDanger(true);
					}	
						
					for(int x = 0; x < chessPiece.length; x++) {
						//If bishop killed checking piece
						if(chessPiece[x].getxChecked() == i && chessPiece[x].getyChecked() == j) {
							
							WKingIsChecked = false;
							chessPiece[12].setKingIsChecked(WKingIsChecked);
							chessPiece[12].setKingInDanger(false);
							
							for(int y = 0; y < 8; y++) {
								for(int z = 0; z < 8; z++) {
									//Changing color tile of checked king
									if(y == chessPiece[12].getX() && z == chessPiece[12].getY()) {
										System.out.println("tiles2: "+tiles2[y][z].getBackground());
										System.out.println("tiles: "+tiles[y][z].getBackground());
										tiles[y][z].setBackground(tiles2[y][z].getBackground());
										chessPiece[x].setxChecked(-1);//Or set to 0, -1 as if setting an int to null
										chessPiece[x].setyChecked(-1);
										return;
									}
								}
							}
						}
						//If bishop moves in the path of checking piece
						if(chessPiece[x].getxChecked() > -1 && chessPiece[x].getyChecked() > -1 && PathIsFree(chessPiece[x].getxChecked(),chessPiece[x].getyChecked(), chessPiece[12].getX(), chessPiece[12].getY(), false) == false) {
							WKingIsChecked = false;
							chessPiece[12].setKingIsChecked(WKingIsChecked);
							chessPiece[12].setKingInDanger(false);
							
							for(int y = 0; y < 8; y++) {
								for(int z = 0; z < 8; z++) {
									//Changing color tile of checked king
									if(y == chessPiece[12].getX() && z == chessPiece[12].getY()) {
										System.out.println("tiles2: "+tiles2[y][z].getBackground());
										System.out.println("tiles: "+tiles[y][z].getBackground());
										tiles[y][z].setBackground(tiles2[y][z].getBackground());
										chessPiece[x].setPastXC(chessPiece[x].getxChecked());//Assigning coordinates of checking piece to a temp variable
										chessPiece[x].setPastYC(chessPiece[x].getyChecked());
										chessPiece[x].setxChecked(-1);//Or set to 0, -1 as if setting an int to null
										chessPiece[x].setyChecked(-1);
										return;
									}
								}
							}
						}
						
						
					}
					
					//If the king is still in danger/making sure the king's safety is priority
					if(chessPiece[12].isKingInDanger()) {
						tiles[i][j].setIcon(null);
						tiles[xClicked][yClicked].setIcon(Wbishop);
						chessPiece[k].setX(xClicked);
						chessPiece[k].setY(yClicked);
						chessPiece[k].setCanMove(false);
						System.out.println("MOVE INVALID TRY AGAIN");
						return;
					}
					
					}
					
					tiles[xClicked][yClicked].setIcon(null);
					
					for(int x = 0; x < chessPiece.length; x++) {
						//If bishop kills normal piece
						if(chessPiece[x].getPastXC() == -1 && chessPiece[x].getPastYC() == -1 && i == chessPiece[x].getX() && j == chessPiece[x].getY()) {
							chessPiece[x].setX(-1);
							chessPiece[x].setY(-1);
							break;
						}
						//If bishop kills piece that has previously checked the king
						if(chessPiece[x].getPastXC() > -1 && chessPiece[x].getPastYC() > -1 && i == chessPiece[x].getPastXC() && j == chessPiece[x].getPastYC() && tiles[chessPiece[x].getPastXC()][chessPiece[x].getPastYC()].getIcon().toString().contains("black")) {
							chessPiece[x].setPastXC(-1);
							chessPiece[x].setPastYC(-1);
							chessPiece[x].setX(-1);
							chessPiece[x].setY(-1);
							
							break;
						}
						
						//Making sure bishop doesnt expose the king 
						else {
							
						for(int y = 0; y < 8; y++) {
							for(int z = 0; z < 8; z++) {
								
								if(tiles[y][z].getIcon() != null && tiles[y][z].getIcon().toString().contains("black")  && y == chessPiece[x].getX() && z == chessPiece[x].getY() && chessPiece[x].isValidMove(chessPiece[12].getX(), chessPiece[12].getY(), isWhiteTurn) && PathIsFree(y, z, chessPiece[12].getX(), chessPiece[12].getY(),false)) {
									chessPiece[12].setKingInDanger(true);
									tiles[xClicked][yClicked].setIcon(Wbishop);
									System.out.println("EXPOSING KING");
									return;
								}
							}
						}
						
						}
					}

					//Moving normally
					tiles[i][j].setIcon(Wbishop);
					chessPiece[k].setX(i);
					chessPiece[k].setY(j);
					
					BKingIsChecked = isChecked(chessPiece[k].getX(), chessPiece[k].getY(), isWhiteTurn);
					chessPiece[28].setKingIsChecked(BKingIsChecked);
					if(BKingIsChecked) {
						chessPiece[28].setKingInDanger(true);
					}	
					
					return;
				}
				
				//Moving queen
				if(tiles[xClicked][yClicked].getIcon().equals(Wqueen) && chessPiece[k].getClass().getSimpleName().equals("Queen") && xClicked == chessPiece[k].getX() && yClicked == chessPiece[k].getY()) {
					
					chessPiece[12].setKingInDanger(false);
					//Making sure queen makes a legal move
					if(chessPiece[k].isValidMove(i, j, isWhiteTurn) == false) {
						chessPiece[k].setCanMove(false);
						System.out.println("MOVE INVALID TRY AGAIN");
						return;
					}
					chessPiece[k].setCanMove(true);
					//Making sure the queen is free to move
					NoObstacles = PathIsFree(xClicked,yClicked,i,j,isWhiteTurn);
					if(NoObstacles == false) {
						chessPiece[k].setValidTile(false);
						return;
					}
					chessPiece[k].setValidTile(true);
					
					
					//If friendly king is checked
					if(chessPiece[12].isKingIsChecked()) {
					
					chessPiece[12].setKingInDanger(true);	
					
					//Moving queen
					tiles[xClicked][yClicked].setIcon(null);
					tiles[i][j].setIcon(Wqueen);
					chessPiece[k].setX(i);
					chessPiece[k].setY(j);
					BKingIsChecked = isChecked(chessPiece[k].getX(), chessPiece[k].getY(), isWhiteTurn);
					chessPiece[28].setKingIsChecked(BKingIsChecked);
					if(BKingIsChecked) {
						chessPiece[28].setKingInDanger(true);
					}
							
					for(int x = 0; x < chessPiece.length; x++) {
						
						//If queen kills checking piece
						if(chessPiece[x].getxChecked() == i && chessPiece[x].getyChecked() == j) {
							WKingIsChecked = false;
							chessPiece[12].setKingIsChecked(WKingIsChecked);
							chessPiece[12].setKingInDanger(false);
							
							for(int y = 0; y < 8; y++) {
								for(int z = 0; z < 8; z++) {
									//Changing color tile of checked king
									if(y == chessPiece[12].getX() && z == chessPiece[12].getY()) {
										System.out.println("tiles2: "+tiles2[y][z].getBackground());
										System.out.println("tiles: "+tiles[y][z].getBackground());
										tiles[y][z].setBackground(tiles2[y][z].getBackground());
										chessPiece[x].setxChecked(-1);//Or set to 0, -1 as if setting an int to null
										chessPiece[x].setyChecked(-1);
										return;
									}
								}
							}
						}
						//If queen moves in the path of checking piece
						if(chessPiece[x].getxChecked() > -1 && chessPiece[x].getyChecked() > -1 && PathIsFree(chessPiece[x].getxChecked(),chessPiece[x].getyChecked(), chessPiece[12].getX(), chessPiece[12].getY(), false) == false) {
							WKingIsChecked = false;
							chessPiece[12].setKingIsChecked(WKingIsChecked);
							chessPiece[12].setKingInDanger(false);
							
							for(int y = 0; y < 8; y++) {
								for(int z = 0; z < 8; z++) {
									//Changing color tile of checked king
									if(y == chessPiece[12].getX() && z == chessPiece[12].getY()) {
										System.out.println("tiles2: "+tiles2[y][z].getBackground());
										System.out.println("tiles: "+tiles[y][z].getBackground());
										tiles[y][z].setBackground(tiles2[y][z].getBackground());
										chessPiece[x].setPastXC(chessPiece[x].getxChecked());//Assigning coordinates of checking piece to a temp variable
										chessPiece[x].setPastYC(chessPiece[x].getyChecked());
										chessPiece[x].setxChecked(-1);//Or set to 0, -1 as if setting an int to null
										chessPiece[x].setyChecked(-1);
										return;
									}
								}
							}
						}
						
					}
					//If king is still in danger/making sure king's safety is priority
					if(chessPiece[12].isKingInDanger()) {
						tiles[i][j].setIcon(null);
						tiles[xClicked][yClicked].setIcon(Wqueen);
						chessPiece[k].setX(xClicked);
						chessPiece[k].setY(yClicked);
						chessPiece[k].setCanMove(false);
						System.out.println("MOVE INVALID TRY AGAIN");
						return;
					}
					
					}
					
					tiles[xClicked][yClicked].setIcon(null);
					
					for(int x = 0; x < chessPiece.length; x++) {
						//If queen kills normal piece
						if(chessPiece[x].getPastXC() == -1 && chessPiece[x].getPastYC() == -1 && i == chessPiece[x].getX() && j == chessPiece[x].getY()) {
							chessPiece[x].setX(-1);
							chessPiece[x].setY(-1);
							break;
						}
						//If queen kills piece that has previously checked king
						if(chessPiece[x].getPastXC() > -1 && chessPiece[x].getPastYC() > -1 && i == chessPiece[x].getPastXC() && j == chessPiece[x].getPastYC() && tiles[chessPiece[x].getPastXC()][chessPiece[x].getPastYC()].getIcon().toString().contains("black")) {
							chessPiece[x].setPastXC(-1);
							chessPiece[x].setPastYC(-1);
							chessPiece[x].setX(-1);
							chessPiece[x].setY(-1);
							break;
						}
						//Making sure queen does not expose king
						else {
							
						for(int y = 0; y < 8; y++) {
							for(int z = 0; z < 8; z++) {
								
								if(tiles[y][z].getIcon() != null && tiles[y][z].getIcon().toString().contains("black")  && y == chessPiece[x].getX() && z == chessPiece[x].getY() && chessPiece[x].isValidMove(chessPiece[12].getX(), chessPiece[12].getY(), isWhiteTurn) && PathIsFree(y, z, chessPiece[12].getX(), chessPiece[12].getY(),false)) {
									chessPiece[12].setKingInDanger(true);
									tiles[xClicked][yClicked].setIcon(Wqueen);
									System.out.println("EXPOSING KING");
									return;
								}
							}
						}
						
						}
					}

					//Moving queen
					tiles[i][j].setIcon(Wqueen);
					chessPiece[k].setX(i);
					chessPiece[k].setY(j);
					BKingIsChecked = isChecked(chessPiece[k].getX(), chessPiece[k].getY(), isWhiteTurn);
					chessPiece[28].setKingIsChecked(BKingIsChecked);
					if(BKingIsChecked) {
						chessPiece[28].setKingInDanger(true);
					}
					chessPiece[k].setHasUnchecked(false);
					return;
				}
				//Moving king
				if(tiles[xClicked][yClicked].getIcon().equals(Wking) && chessPiece[k].getClass().getSimpleName().equals("King") && xClicked == chessPiece[k].getX() && yClicked == chessPiece[k].getY() && (chessPiece[k].isValidMove(i,j,isWhiteTurn) || chessPiece[k].getMoveCounter() == 0)) {
					
					
					//If king is checked
					if(chessPiece[12].isKingIsChecked()) {
					
					
					
					for(int x = 0; x < chessPiece.length; x++) {
						//If king kills checking piece
						if(chessPiece[x].getxChecked() == i && chessPiece[x].getyChecked() == j) {
							System.out.println("KING KILLING CHECKING PIECE");
							
							tiles[xClicked][yClicked].setIcon(null);
							KingInDanger(i, j, isWhiteTurn);
						
							if(chessPiece[12].isKingInDanger()) {
								tiles[xClicked][yClicked].setIcon(Wking);
								System.out.println("KING IN DANGER");
								return;
							}
							
							tiles[i][j].setIcon(Wking);
							
							WKingIsChecked = false;
							chessPiece[12].setKingIsChecked(WKingIsChecked);
							chessPiece[12].setKingInDanger(false);
							for(int y = 0; y < 8; y++) {
								for(int z = 0; z < 8; z++) {
									//Changing tile color of king
									if(y == chessPiece[12].getX() && z == chessPiece[12].getY()) {
										System.out.println("tiles2: "+tiles2[y][z].getBackground());
										System.out.println("tiles: "+tiles[y][z].getBackground());
										tiles[y][z].setBackground(tiles2[y][z].getBackground());
										//Moving king
										chessPiece[k].setX(i);
										chessPiece[k].setY(j);
										chessPiece[x].setxChecked(-1);//Or set to 0, -1 as if setting an int to null
										chessPiece[x].setyChecked(-1);
										chessPiece[x].setX(-1);
										chessPiece[x].setY(-1);
										chessPiece[k].setMoveCounter(chessPiece[k].getMoveCounter() + 1);//Incrementing move counter to test for castling
										return;
									}
								}
							}
						}
						}
					//If the king moves away from checking piece path
					for(int x = 0; x < chessPiece.length; x++) {
						
							tiles[xClicked][yClicked].setIcon(null);
										
							KingInDanger(i, j, isWhiteTurn);
										
							if(chessPiece[12].isKingInDanger()) {
								tiles[xClicked][yClicked].setIcon(Wking);
								System.out.println("KING IN DANGER");
								return;
							}
							WKingIsChecked = false;
							chessPiece[12].setKingIsChecked(WKingIsChecked);
							chessPiece[12].setKingInDanger(false);
							for(int y = 0; y < 8; y++) {
								for(int z = 0; z < 8; z++) {
									//Changing tile color of checked king
									if(y == chessPiece[12].getX() && z == chessPiece[12].getY()) {
										
										System.out.println("tiles2: "+tiles2[y][z].getBackground());
										System.out.println("tiles: "+tiles[y][z].getBackground());
										tiles[y][z].setBackground(tiles2[y][z].getBackground());
										chessPiece[x].setxChecked(-1);//Or set to 0, -1 as if setting an int to null
										chessPiece[x].setyChecked(-1);
										
									
										//Moving king
										tiles[i][j].setIcon(Wking);
										chessPiece[k].setX(i);
										chessPiece[k].setY(j);
										chessPiece[k].setMoveCounter(chessPiece[k].getMoveCounter() + 1);//Incrementing move counter to test for castling
										return;
									}
								}
							
						}
						
						
					}
					}
					
				
					tiles[xClicked][yClicked].setIcon(null);
					KingInDanger(i, j, isWhiteTurn);
					
					if(chessPiece[12].isKingInDanger()) {
						tiles[xClicked][yClicked].setIcon(Wking);
						System.out.println("KING IN DANGER");
						return;
					}
					//Castling
					if(chessPiece[k].getMoveCounter() == 0 && chessPiece[8].getMoveCounter() == 0 && chessPiece[k].getX() != -1 && chessPiece[8].getX() != -1 && (i == 7 || j == 2) && tiles[7][1].getIcon() == null && tiles[7][2].getIcon() == null && tiles[7][3].getIcon() == null) {
						tiles[i][j].setIcon(Wking);
						chessPiece[k].setX(i);
						chessPiece[k].setY(j);
						chessPiece[k].setMoveCounter(chessPiece[k].getMoveCounter() + 1);
						
						tiles[7][0].setIcon(null);
						tiles[7][3].setIcon(Wrook);
						chessPiece[8].setX(7);
						chessPiece[8].setY(3);
						chessPiece[8].setMoveCounter(chessPiece[8].getMoveCounter() + 1);
						return;
					}
					
					if(chessPiece[k].getMoveCounter() == 0 && chessPiece[15].getMoveCounter() == 0 && chessPiece[k].getX() != -1 && chessPiece[15].getX() != -1 && (i == 7 || j == 6) && tiles[7][5].getIcon() == null && tiles[7][6].getIcon() == null) {
						tiles[i][j].setIcon(Wking);
						chessPiece[k].setX(i);
						chessPiece[k].setY(j);
						chessPiece[k].setMoveCounter(chessPiece[k].getMoveCounter() + 1);
						
						tiles[7][7].setIcon(null);
						tiles[7][5].setIcon(Wrook);
						chessPiece[15].setX(7);
						chessPiece[15].setY(5);
						chessPiece[15].setMoveCounter(chessPiece[15].getMoveCounter() + 1);
						return;
					}
					
					for(int x = 0; x < chessPiece.length; x++) {
						//If king kills a normal piece
						if(i == chessPiece[x].getX() && j == chessPiece[x].getY()) {
							chessPiece[x].setX(-1);
							chessPiece[x].setY(-1);
						}
					}
					
					//Moving king
					tiles[i][j].setIcon(Wking);
					chessPiece[k].setX(i);
					chessPiece[k].setY(j);
					chessPiece[k].setMoveCounter(chessPiece[k].getMoveCounter() + 1);//Incrementing move counter to test for castling
					return;
				}
				
			}
		}
		//Black move
		if(isWhiteTurn == false) {
			System.out.println("Moving the black piece...");
			for(int k = 0; k < chessPiece.length; k++) {
				
				//Pawn kills
				if(tiles[xClicked][yClicked].getIcon().equals(Bpawn) && chessPiece[k].getClass().getSimpleName().equals("Pawn") && xClicked == chessPiece[k].getX() && yClicked == chessPiece[k].getY() && tiles[i][j].getIcon() != null) {
					
					chessPiece[28].setKingInDanger(false);
					
					if(chessPiece[k].validKill(i, j, isWhiteTurn) == false) {
						chessPiece[k].setCanMove(false);
						return;
					}
					chessPiece[k].setCanMove(true);
					NoObstacles = PathIsFree(xClicked,yClicked,i,j,isWhiteTurn);
					if(NoObstacles == false) {
						chessPiece[k].setValidTile(false);
						return;
					}
					chessPiece[k].setValidTile(true);
					
					
					
					
					if(chessPiece[28].isKingIsChecked()) {
					
					chessPiece[28].setKingInDanger(true);	
					tiles[xClicked][yClicked].setIcon(null);
					tiles[i][j].setIcon(Bpawn);
					chessPiece[k].setX(i);
					chessPiece[k].setY(j);
					
					WKingIsChecked = isChecked(chessPiece[k].getX(), chessPiece[k].getY(), isWhiteTurn);
					chessPiece[12].setKingIsChecked(WKingIsChecked);
					if(WKingIsChecked) {
						chessPiece[12].setKingInDanger(true);
					}
							
					for(int x = 0; x < chessPiece.length; x++) {
						
						if(chessPiece[x].getxChecked() == i && chessPiece[x].getyChecked() == j) {
							BKingIsChecked = false;
							chessPiece[28].setKingIsChecked(BKingIsChecked);
							chessPiece[28].setKingInDanger(false);
							for(int y = 0; y < 8; y++) {
								for(int z = 0; z < 8; z++) {
								
									if(y == chessPiece[28].getX() && z == chessPiece[28].getY()) {
										System.out.println("tiles2: "+tiles2[y][z].getBackground());
										System.out.println("tiles: "+tiles[y][z].getBackground());
										tiles[y][z].setBackground(tiles2[y][z].getBackground());
										chessPiece[x].setxChecked(-1);//Or set to 0, -1 as if setting an int to null
										chessPiece[x].setyChecked(-1);
										return;
									}
								}
							}
						}
						
					}
					
					if(chessPiece[28].isKingInDanger()) {
						tiles[i][j].setIcon(null);
						tiles[xClicked][yClicked].setIcon(Bpawn);
						chessPiece[k].setX(xClicked);
						chessPiece[k].setY(yClicked);
						chessPiece[k].setCanMove(false);
						System.out.println("MOVE INVALID TRY AGAIN");
						return;
					}
					
					}
					Icon killed = tiles[i][j].getIcon();
					
					tiles[xClicked][yClicked].setIcon(null);
					tiles[i][j].setIcon(Bpawn);
					chessPiece[k].setX(i);
					chessPiece[k].setY(j);
					
					
					
					for(int x = 0; x < chessPiece.length; x++) {
						
						if(chessPiece[x].getPastXC() == -1 && chessPiece[x].getPastYC() == -1 && i == chessPiece[x].getX() && j == chessPiece[x].getY()) {
							chessPiece[x].setX(-1);
							chessPiece[x].setY(-1);
							//break;
						}
						if(chessPiece[x].getPastXC() > -1 && chessPiece[x].getPastYC() > -1 && i == chessPiece[x].getPastXC() && j == chessPiece[x].getPastYC() && tiles[chessPiece[x].getPastXC()][chessPiece[x].getPastYC()].getIcon().toString().contains("white")) {
							chessPiece[x].setPastXC(-1);
							chessPiece[x].setPastYC(-1);
							chessPiece[x].setX(-1);
							chessPiece[x].setY(-1);
							//break;
						}
						
						//else {
							
						for(int y = 0; y < 8; y++) {
							for(int z = 0; z < 8; z++) {
								
								if(tiles[y][z].getIcon() != null && tiles[y][z].getIcon().toString().contains("white")  && y == chessPiece[x].getX() && z == chessPiece[x].getY() && chessPiece[x].isValidMove(chessPiece[28].getX(), chessPiece[28].getY(), isWhiteTurn) && PathIsFree(y, z, chessPiece[28].getX(), chessPiece[28].getY(),true)) {
									chessPiece[28].setKingInDanger(true);
									tiles[xClicked][yClicked].setIcon(null);
									tiles[i][j].setIcon(killed);
									tiles[xClicked][yClicked].setIcon(Bpawn);
									chessPiece[k].setX(xClicked);
									chessPiece[k].setY(yClicked);
									System.out.println("EXPOSING KING");
									return;
								}
							}
						}
						
						//}
					}
					
					tiles[i][j].setIcon(Bpawn);
					chessPiece[k].setX(i);
					chessPiece[k].setY(j);
					
					WKingIsChecked = isChecked(chessPiece[k].getX(), chessPiece[k].getY(), isWhiteTurn);
					chessPiece[12].setKingIsChecked(WKingIsChecked);
					if(WKingIsChecked) {
						chessPiece[12].setKingInDanger(true);
					}
					
					return;
				}
				
				if(tiles[xClicked][yClicked].getIcon().equals(Bpawn) && chessPiece[k].getClass().getSimpleName().equals("Pawn") && xClicked == chessPiece[k].getX() && yClicked == chessPiece[k].getY()) {
					
					chessPiece[28].setKingInDanger(false);
					
					if(chessPiece[k].isValidMove(i, j, isWhiteTurn) == false) {
						chessPiece[k].setCanMove(false);
						System.out.println("MOVE INVALID TRY AGAIN");
						return;
					}
					chessPiece[k].setCanMove(true);
					
					NoObstacles = PathIsFree(xClicked,yClicked,i,j,isWhiteTurn);
					if(NoObstacles == false) {
						chessPiece[k].setValidTile(false);
						return;
					}
					chessPiece[k].setValidTile(true);
			
					
					
					if(chessPiece[28].isKingIsChecked()) {
						
					chessPiece[28].setKingInDanger(true);	
					tiles[xClicked][yClicked].setIcon(null);
					tiles[i][j].setIcon(Bpawn);
					chessPiece[k].setX(i);
					chessPiece[k].setY(j);
					
					WKingIsChecked = isChecked(chessPiece[k].getX(), chessPiece[k].getY(), isWhiteTurn);
					chessPiece[12].setKingIsChecked(WKingIsChecked);
					if(WKingIsChecked) {
						chessPiece[12].setKingInDanger(true);
					}
						
					for(int x = 0; x < chessPiece.length; x++) {
						
						if(chessPiece[x].getxChecked() > -1 && chessPiece[x].getyChecked() > -1 && PathIsFree(chessPiece[x].getxChecked(),chessPiece[x].getyChecked(), chessPiece[28].getX(), chessPiece[28].getY(), true) == false) {
							BKingIsChecked = false;
							chessPiece[28].setKingIsChecked(BKingIsChecked);
							chessPiece[28].setKingInDanger(false);
							for(int y = 0; y < 8; y++) {
								for(int z = 0; z < 8; z++) {
								
									if(y == chessPiece[28].getX() && z == chessPiece[28].getY()) {
										System.out.println("tiles2: "+tiles2[y][z].getBackground());
										System.out.println("tiles: "+tiles[y][z].getBackground());
										tiles[y][z].setBackground(tiles2[y][z].getBackground());
										chessPiece[x].setPastXC(chessPiece[x].getxChecked());
										chessPiece[x].setPastYC(chessPiece[x].getyChecked());
										chessPiece[x].setxChecked(-1);//Or set to 0, -1 as if setting an int to null
										chessPiece[x].setyChecked(-1);
										return;
									}
								}
							}
						}
					}
					
					if(chessPiece[28].isKingInDanger()) {
						tiles[i][j].setIcon(null);
						tiles[xClicked][yClicked].setIcon(Bpawn);
						chessPiece[k].setX(xClicked);
						chessPiece[k].setY(yClicked);
						chessPiece[k].setCanMove(false);
						System.out.println("MOVE INVALID TRY AGAIN");
						return;
					}
					
					}
					
					tiles[xClicked][yClicked].setIcon(null);
					tiles[i][j].setIcon(Bpawn);
					chessPiece[k].setX(i);
					chessPiece[k].setY(j);
					for(int x = 0; x < chessPiece.length; x++) {
							
						for(int y = 0; y < 8; y++) {
							for(int z = 0; z < 8; z++) {
								
								if(tiles[y][z].getIcon() != null && tiles[y][z].getIcon().toString().contains("white")  && y == chessPiece[x].getX() && z == chessPiece[x].getY() && chessPiece[x].isValidMove(chessPiece[28].getX(), chessPiece[28].getY(), isWhiteTurn) && PathIsFree(y, z, chessPiece[28].getX(), chessPiece[28].getY(),true)) {
									chessPiece[28].setKingInDanger(true);
									tiles[xClicked][yClicked].setIcon(Bpawn);
									chessPiece[k].setX(xClicked);
									chessPiece[k].setY(yClicked);
									System.out.println("EXPOSING KING");
									return;
								}
							}
						}
						
						
					}

					tiles[i][j].setIcon(Bpawn);
					chessPiece[k].setX(i);
					chessPiece[k].setY(j);
					
					WKingIsChecked = isChecked(chessPiece[k].getX(), chessPiece[k].getY(), isWhiteTurn);
					chessPiece[12].setKingIsChecked(WKingIsChecked);
					if(WKingIsChecked) {
						chessPiece[12].setKingInDanger(true);
					}
					return;
				}
				
				if(tiles[xClicked][yClicked].getIcon().equals(Bknight) && chessPiece[k].getClass().getSimpleName().equals("Knight") && xClicked == chessPiece[k].getX() && yClicked == chessPiece[k].getY() && chessPiece[k].isValidMove(i,j,isWhiteTurn)) {
					
					chessPiece[28].setKingInDanger(false);
				
					
					
					if(chessPiece[28].isKingIsChecked()) {
					
					chessPiece[28].setKingInDanger(true);	
					tiles[xClicked][yClicked].setIcon(null);
					tiles[i][j].setIcon(Bknight);
					chessPiece[k].setX(i);
					chessPiece[k].setY(j);
					WKingIsChecked = isChecked(chessPiece[k].getX(), chessPiece[k].getY(), isWhiteTurn);
					chessPiece[12].setKingIsChecked(WKingIsChecked);
					if(WKingIsChecked) {
						chessPiece[12].setKingInDanger(true);
					}
						
					for(int x = 0; x < chessPiece.length; x++) {
						
						if(chessPiece[x].getxChecked() == i && chessPiece[x].getyChecked() == j) {
							BKingIsChecked = false;
							chessPiece[28].setKingIsChecked(BKingIsChecked);
							chessPiece[28].setKingInDanger(false);
							for(int y = 0; y < 8; y++) {
								for(int z = 0; z < 8; z++) {
								
									if(y == chessPiece[28].getX() && z == chessPiece[28].getY()) {
										System.out.println("tiles2: "+tiles2[y][z].getBackground());
										System.out.println("tiles: "+tiles[y][z].getBackground());
										tiles[y][z].setBackground(tiles2[y][z].getBackground());
										chessPiece[x].setxChecked(-1);//Or set to 0, -1 as if setting an int to null
										chessPiece[x].setyChecked(-1);
										return;
									}
								}
							}
						}
						if(chessPiece[x].getxChecked() > -1 && chessPiece[x].getyChecked() > -1 && PathIsFree(chessPiece[x].getxChecked(),chessPiece[x].getyChecked(), chessPiece[28].getX(), chessPiece[28].getY(), true) == false) {
							BKingIsChecked = false;
							chessPiece[28].setKingIsChecked(BKingIsChecked);
							chessPiece[28].setKingInDanger(false);
							for(int y = 0; y < 8; y++) {
								for(int z = 0; z < 8; z++) {
								
									if(y == chessPiece[28].getX() && z == chessPiece[28].getY()) {
										System.out.println("hello MAMA");
										System.out.println("tiles2: "+tiles2[y][z].getBackground());
										System.out.println("tiles: "+tiles[y][z].getBackground());
										tiles[y][z].setBackground(tiles2[y][z].getBackground());
										chessPiece[x].setPastXC(chessPiece[x].getxChecked());
										chessPiece[x].setPastYC(chessPiece[x].getyChecked());
										chessPiece[x].setxChecked(-1);//Or set to 0, -1 as if setting an int to null
										chessPiece[x].setyChecked(-1);
										return;
									}
								}
							}
						}
						
					}
					
					if(chessPiece[28].isKingInDanger()) {
						tiles[i][j].setIcon(null);
						tiles[xClicked][yClicked].setIcon(Bknight);
						chessPiece[k].setX(xClicked);
						chessPiece[k].setY(yClicked);
						chessPiece[k].setCanMove(false);
						System.out.println("MOVE INVALID TRY AGAIN");
						return;
					}
					
					}
					
					tiles[xClicked][yClicked].setIcon(null);
					
					for(int x = 0; x < chessPiece.length; x++) {
						
						if(chessPiece[x].getPastXC() == -1 && chessPiece[x].getPastYC() == -1 && i == chessPiece[x].getX() && j == chessPiece[x].getY()) {
							chessPiece[x].setX(-1);
							chessPiece[x].setY(-1);
							break;
						}
						if(chessPiece[x].getPastXC() > -1 && chessPiece[x].getPastYC() > -1 && i == chessPiece[x].getPastXC() && j == chessPiece[x].getPastYC() && tiles[chessPiece[x].getPastXC()][chessPiece[x].getPastYC()].getIcon().toString().contains("white")) {
							chessPiece[x].setPastXC(-1);
							chessPiece[x].setPastYC(-1);
							chessPiece[x].setX(-1);
							chessPiece[x].setY(-1);
							break;
						}
						
						else {
							
						for(int y = 0; y < 8; y++) {
							for(int z = 0; z < 8; z++) {
								
								if(tiles[y][z].getIcon() != null && tiles[y][z].getIcon().toString().contains("white")  && y == chessPiece[x].getX() && z == chessPiece[x].getY() && chessPiece[x].isValidMove(chessPiece[28].getX(), chessPiece[28].getY(), isWhiteTurn) && PathIsFree(y, z, chessPiece[28].getX(), chessPiece[28].getY(),true)) {
									chessPiece[28].setKingInDanger(true);
									tiles[xClicked][yClicked].setIcon(Bknight);
									System.out.println("EXPOSING KING");
									return;
								}
							}
						}
						
						}
					}

					
					tiles[i][j].setIcon(Bknight);
					chessPiece[k].setX(i);
					chessPiece[k].setY(j);
					WKingIsChecked = isChecked(chessPiece[k].getX(), chessPiece[k].getY(), isWhiteTurn);
					chessPiece[12].setKingIsChecked(WKingIsChecked);
					if(WKingIsChecked) {
						chessPiece[12].setKingInDanger(true);
					}
					
					return;
				}
				
				if(tiles[xClicked][yClicked].getIcon().equals(Brook) && chessPiece[k].getClass().getSimpleName().equals("Rook") && xClicked == chessPiece[k].getX() && yClicked == chessPiece[k].getY()) {
					
					chessPiece[28].setKingInDanger(false);
					
					if(chessPiece[k].isValidMove(i, j, isWhiteTurn) == false) {
						chessPiece[k].setCanMove(false);
						System.out.println("MOVE INVALID TRY AGAIN");
						return;
					}
					chessPiece[k].setCanMove(true);
					
					NoObstacles = PathIsFree(xClicked,yClicked,i,j,isWhiteTurn);
					if(NoObstacles == false) {
						chessPiece[k].setValidTile(false);
						return;
					}
					chessPiece[k].setValidTile(true);
					
					
					
					if(chessPiece[28].isKingIsChecked()) {
					
					chessPiece[28].setKingInDanger(true);	
					tiles[xClicked][yClicked].setIcon(null);
					tiles[i][j].setIcon(Brook);
					chessPiece[k].setX(i);
					chessPiece[k].setY(j);
					chessPiece[k].setMoveCounter(chessPiece[k].getMoveCounter() + 1);
					
					WKingIsChecked = isChecked(chessPiece[k].getX(), chessPiece[k].getY(), isWhiteTurn);
					chessPiece[12].setKingIsChecked(WKingIsChecked);
					if(WKingIsChecked) {
						chessPiece[12].setKingInDanger(true);
					}
						
					for(int x = 0; x < chessPiece.length; x++) {
						
						if(chessPiece[x].getxChecked() == i && chessPiece[x].getyChecked() == j) {
							BKingIsChecked = false;
							chessPiece[28].setKingIsChecked(BKingIsChecked);
							chessPiece[28].setKingInDanger(false);
							
							for(int y = 0; y < 8; y++) {
								for(int z = 0; z < 8; z++) {
								
									if(y == chessPiece[28].getX() && z == chessPiece[28].getY()) {
										System.out.println("tiles2: "+tiles2[y][z].getBackground());
										System.out.println("tiles: "+tiles[y][z].getBackground());
										tiles[y][z].setBackground(tiles2[y][z].getBackground());
										chessPiece[x].setxChecked(-1);//Or set to 0, -1 as if setting an int to null
										chessPiece[x].setyChecked(-1);
										return;
									}
								}
							}
						}
						if(chessPiece[x].getxChecked() > -1 && chessPiece[x].getyChecked() > -1 && PathIsFree(chessPiece[x].getxChecked(),chessPiece[x].getyChecked(), chessPiece[28].getX(), chessPiece[28].getY(), true) == false) {
							BKingIsChecked = false;
							chessPiece[28].setKingIsChecked(BKingIsChecked);
							chessPiece[28].setKingInDanger(false);
							
							for(int y = 0; y < 8; y++) {
								for(int z = 0; z < 8; z++) {
								
									if(y == chessPiece[28].getX() && z == chessPiece[28].getY()) {
										System.out.println("tiles2: "+tiles2[y][z].getBackground());
										System.out.println("tiles: "+tiles[y][z].getBackground());
										tiles[y][z].setBackground(tiles2[y][z].getBackground());
										chessPiece[x].setPastXC(chessPiece[x].getxChecked());
										chessPiece[x].setPastYC(chessPiece[x].getyChecked());
										chessPiece[x].setxChecked(-1);//Or set to 0, -1 as if setting an int to null
										chessPiece[x].setyChecked(-1);
										return;
									}
								}
							}
						}
						
					}
					
					if(chessPiece[28].isKingInDanger()) {
						tiles[i][j].setIcon(null);
						tiles[xClicked][yClicked].setIcon(Brook);
						chessPiece[k].setX(xClicked);
						chessPiece[k].setY(yClicked);
						chessPiece[k].setCanMove(false);
						System.out.println("MOVE INVALID TRY AGAIN");
						chessPiece[k].setMoveCounter(chessPiece[k].getMoveCounter() - 1);
						return;
					}
					
					}
					
					
					tiles[xClicked][yClicked].setIcon(null);
					
					for(int x = 0; x < chessPiece.length; x++) {
						
						if(chessPiece[x].getPastXC() == -1 && chessPiece[x].getPastYC() == -1 && i == chessPiece[x].getX() && j == chessPiece[x].getY()) {
							chessPiece[x].setX(-1);
							chessPiece[x].setY(-1);
							break;
						}
						if(chessPiece[x].getPastXC() > -1 && chessPiece[x].getPastYC() > -1 && i == chessPiece[x].getPastXC() && j == chessPiece[x].getPastYC() && tiles[chessPiece[x].getPastXC()][chessPiece[x].getPastYC()].getIcon().toString().contains("white")) {
							chessPiece[x].setPastXC(-1);
							chessPiece[x].setPastYC(-1);
							chessPiece[x].setX(-1);
							chessPiece[x].setY(-1);
							
							break;
						}
						
						else {
							
						for(int y = 0; y < 8; y++) {
							for(int z = 0; z < 8; z++) {
								
								if(tiles[y][z].getIcon() != null && tiles[y][z].getIcon().toString().contains("white")  && y == chessPiece[x].getX() && z == chessPiece[x].getY() && chessPiece[x].isValidMove(chessPiece[28].getX(), chessPiece[28].getY(), isWhiteTurn) && PathIsFree(y, z, chessPiece[28].getX(), chessPiece[28].getY(),true)) {
									chessPiece[28].setKingInDanger(true);
									tiles[xClicked][yClicked].setIcon(Brook);
									System.out.println("EXPOSING KING");
									return;
								}
							}
						}
						
						}
					}

					
					tiles[i][j].setIcon(Brook);
					chessPiece[k].setX(i);
					chessPiece[k].setY(j);
					WKingIsChecked = isChecked(chessPiece[k].getX(), chessPiece[k].getY(), isWhiteTurn);
					chessPiece[12].setKingIsChecked(WKingIsChecked);
					if(WKingIsChecked) {
						chessPiece[12].setKingInDanger(true);
					}
					chessPiece[k].setMoveCounter(chessPiece[k].getMoveCounter() + 1);
					return;
				}
				
				if(tiles[xClicked][yClicked].getIcon().equals(Bbishop) && chessPiece[k].getClass().getSimpleName().equals("Bishop") && xClicked == chessPiece[k].getX() && yClicked == chessPiece[k].getY()) {
					
					chessPiece[28].setKingInDanger(false);
					
					if(chessPiece[k].isValidMove(i, j, isWhiteTurn) == false) {
						chessPiece[k].setCanMove(false);
						System.out.println("MOVE INVALID TRY AGAIN");
						return;
					}
					chessPiece[k].setCanMove(true);
					
					NoObstacles = PathIsFree(xClicked,yClicked,i,j,isWhiteTurn);
					if(NoObstacles == false) {
						chessPiece[k].setValidTile(false);
						return;
					}
					chessPiece[k].setValidTile(true);
					
					
					
					if(chessPiece[28].isKingIsChecked()) {
					
					chessPiece[28].setKingInDanger(true);	
					tiles[xClicked][yClicked].setIcon(null);
					tiles[i][j].setIcon(Bbishop);
					chessPiece[k].setX(i);
					chessPiece[k].setY(j);
					WKingIsChecked = isChecked(chessPiece[k].getX(), chessPiece[k].getY(), isWhiteTurn);
					chessPiece[12].setKingIsChecked(WKingIsChecked);
					if(WKingIsChecked) {
						chessPiece[12].setKingInDanger(true);
					}
						
					for(int x = 0; x < chessPiece.length; x++) {
						
						if(chessPiece[x].getxChecked() == i && chessPiece[x].getyChecked() == j) {
							BKingIsChecked = false;
							chessPiece[28].setKingIsChecked(BKingIsChecked);
							chessPiece[28].setKingInDanger(false);
							
							for(int y = 0; y < 8; y++) {
								for(int z = 0; z < 8; z++) {
								
									if(y == chessPiece[28].getX() && z == chessPiece[28].getY()) {
										System.out.println("tiles2: "+tiles2[y][z].getBackground());
										System.out.println("tiles: "+tiles[y][z].getBackground());
										tiles[y][z].setBackground(tiles2[y][z].getBackground());
										chessPiece[x].setxChecked(-1);//Or set to 0, -1 as if setting an int to null
										chessPiece[x].setyChecked(-1);
										return;
									}
								}
							}
						}
						if(chessPiece[x].getxChecked() > -1 && chessPiece[x].getyChecked() > -1 && PathIsFree(chessPiece[x].getxChecked(),chessPiece[x].getyChecked(), chessPiece[28].getX(), chessPiece[28].getY(), true) == false) {
							BKingIsChecked = false;
							chessPiece[28].setKingIsChecked(BKingIsChecked);
							chessPiece[28].setKingInDanger(false);
							
							for(int y = 0; y < 8; y++) {
								for(int z = 0; z < 8; z++) {
								
									if(y == chessPiece[28].getX() && z == chessPiece[28].getY()) {
										System.out.println("tiles2: "+tiles2[y][z].getBackground());
										System.out.println("tiles: "+tiles[y][z].getBackground());
										tiles[y][z].setBackground(tiles2[y][z].getBackground());
										chessPiece[x].setPastXC(chessPiece[x].getxChecked());
										chessPiece[x].setPastYC(chessPiece[x].getyChecked());
										chessPiece[x].setxChecked(-1);//Or set to 0, -1 as if setting an int to null
										chessPiece[x].setyChecked(-1);
										return;
									}
								}
							}
						}
						
						}
					
					if(chessPiece[28].isKingInDanger()) {
						tiles[i][j].setIcon(null);
						tiles[xClicked][yClicked].setIcon(Bbishop);
						chessPiece[k].setX(xClicked);
						chessPiece[k].setY(yClicked);
						chessPiece[k].setCanMove(false);
						System.out.println("MOVE INVALID TRY AGAIN");
						return;
					}
					
					}
					
					tiles[xClicked][yClicked].setIcon(null);
					
					for(int x = 0; x < chessPiece.length; x++) {
						
						if(chessPiece[x].getPastXC() == -1 && chessPiece[x].getPastYC() == -1 && i == chessPiece[x].getX() && j == chessPiece[x].getY()) {
							chessPiece[x].setX(-1);
							chessPiece[x].setY(-1);
							break;
						}
						if(chessPiece[x].getPastXC() > -1 && chessPiece[x].getPastYC() > -1 && i == chessPiece[x].getPastXC() && j == chessPiece[x].getPastYC() && tiles[chessPiece[x].getPastXC()][chessPiece[x].getPastYC()].getIcon().toString().contains("white")) {
							chessPiece[x].setPastXC(-1);
							chessPiece[x].setPastYC(-1);
							chessPiece[x].setX(-1);
							chessPiece[x].setY(-1);
							break;
						}
						
						else {
							
						for(int y = 0; y < 8; y++) {
							for(int z = 0; z < 8; z++) {
								
								if(tiles[y][z].getIcon() != null && tiles[y][z].getIcon().toString().contains("white")  && y == chessPiece[x].getX() && z == chessPiece[x].getY() && chessPiece[x].isValidMove(chessPiece[28].getX(), chessPiece[28].getY(), isWhiteTurn) && PathIsFree(y, z, chessPiece[28].getX(), chessPiece[28].getY(),true)) {
									chessPiece[28].setKingInDanger(true);
									tiles[xClicked][yClicked].setIcon(Bbishop);
									System.out.println("EXPOSING KING");
									return;
								}
							}
						}
						
						}
					}

					
					tiles[i][j].setIcon(Bbishop);
					chessPiece[k].setX(i);
					chessPiece[k].setY(j);
					WKingIsChecked = isChecked(chessPiece[k].getX(), chessPiece[k].getY(), isWhiteTurn);
					chessPiece[12].setKingIsChecked(WKingIsChecked);
					if(WKingIsChecked) {
						chessPiece[12].setKingInDanger(true);
					}
					
					return;
				}
				
				if(tiles[xClicked][yClicked].getIcon().equals(Bqueen) && chessPiece[k].getClass().getSimpleName().equals("Queen") && xClicked == chessPiece[k].getX() && yClicked == chessPiece[k].getY()) {
					
					chessPiece[28].setKingInDanger(false);
					
					if(chessPiece[k].isValidMove(i, j, isWhiteTurn) == false) {
						chessPiece[k].setCanMove(false);
						System.out.println("MOVE INVALID TRY AGAIN");
						return;
					}
					chessPiece[k].setCanMove(true);
					
					NoObstacles = PathIsFree(xClicked,yClicked,i,j,isWhiteTurn);
					if(NoObstacles == false) {
						chessPiece[k].setValidTile(false);
						return;
					}
					chessPiece[k].setValidTile(true);
					
					
					
					if(chessPiece[28].isKingIsChecked()) {
						
					chessPiece[28].setKingInDanger(true);	
					tiles[xClicked][yClicked].setIcon(null);
					tiles[i][j].setIcon(Bqueen);
					chessPiece[k].setX(i);
					chessPiece[k].setY(j);
					WKingIsChecked = isChecked(chessPiece[k].getX(), chessPiece[k].getY(), isWhiteTurn);
					chessPiece[12].setKingIsChecked(WKingIsChecked);
					if(WKingIsChecked) {
						chessPiece[12].setKingInDanger(true);
					}
						
					for(int x = 0; x < chessPiece.length; x++) {
						
						if(chessPiece[x].getxChecked() == i && chessPiece[x].getyChecked() == j) {
							BKingIsChecked = false;
							chessPiece[28].setKingIsChecked(BKingIsChecked);
							chessPiece[28].setKingInDanger(false);
							
							for(int y = 0; y < 8; y++) {
								for(int z = 0; z < 8; z++) {
								
									if(y == chessPiece[28].getX() && z == chessPiece[28].getY()) {
										System.out.println("tiles2: "+tiles2[y][z].getBackground());
										System.out.println("tiles: "+tiles[y][z].getBackground());
										tiles[y][z].setBackground(tiles2[y][z].getBackground());
										chessPiece[x].setxChecked(-1);//Or set to 0, -1 as if setting an int to null
										chessPiece[x].setyChecked(-1);
										return;
									}
								}
							}
						}
						if(chessPiece[x].getxChecked() > -1 && chessPiece[x].getyChecked() > -1 && PathIsFree(chessPiece[x].getxChecked(),chessPiece[x].getyChecked(), chessPiece[28].getX(), chessPiece[28].getY(), true) == false) {
							BKingIsChecked = false;
							chessPiece[28].setKingIsChecked(BKingIsChecked);
							chessPiece[28].setKingInDanger(false);
							
							for(int y = 0; y < 8; y++) {
								for(int z = 0; z < 8; z++) {
								
									if(y == chessPiece[28].getX() && z == chessPiece[28].getY()) {
										System.out.println("tiles2: "+tiles2[y][z].getBackground());
										System.out.println("tiles: "+tiles[y][z].getBackground());
										tiles[y][z].setBackground(tiles2[y][z].getBackground());
										chessPiece[x].setPastXC(chessPiece[x].getxChecked());
										chessPiece[x].setPastYC(chessPiece[x].getyChecked());
										chessPiece[x].setxChecked(-1);//Or set to 0, -1 as if setting an int to null
										chessPiece[x].setyChecked(-1);
										return;
									}
								}
							}
						}
					}
					
					if(chessPiece[28].isKingInDanger()) {
						tiles[i][j].setIcon(null);
						tiles[xClicked][yClicked].setIcon(Bqueen);
						chessPiece[k].setX(xClicked);
						chessPiece[k].setY(yClicked);
						chessPiece[k].setCanMove(false);
						System.out.println("MOVE INVALID TRY AGAIN");
						return;
					}
					
					}
					
					tiles[xClicked][yClicked].setIcon(null);
					
					for(int x = 0; x < chessPiece.length; x++) {
						
						if(chessPiece[x].getPastXC() == -1 && chessPiece[x].getPastYC() == -1 && i == chessPiece[x].getX() && j == chessPiece[x].getY()) {
							chessPiece[x].setX(-1);
							chessPiece[x].setY(-1);
							break;
						}
						if(chessPiece[x].getPastXC() > -1 && chessPiece[x].getPastYC() > -1 && i == chessPiece[x].getPastXC() && j == chessPiece[x].getPastYC() && tiles[chessPiece[x].getPastXC()][chessPiece[x].getPastYC()].getIcon().toString().contains("white")) {
							chessPiece[x].setPastXC(-1);
							chessPiece[x].setPastYC(-1);
							chessPiece[x].setX(-1);
							chessPiece[x].setY(-1);
							break;
						}
						
						else {
							
						for(int y = 0; y < 8; y++) {
							for(int z = 0; z < 8; z++) {
								
								if(tiles[y][z].getIcon() != null && tiles[y][z].getIcon().toString().contains("white")  && y == chessPiece[x].getX() && z == chessPiece[x].getY() && chessPiece[x].isValidMove(chessPiece[28].getX(), chessPiece[28].getY(), isWhiteTurn) && PathIsFree(y, z, chessPiece[28].getX(), chessPiece[28].getY(),true)) {
									chessPiece[28].setKingInDanger(true);
									tiles[xClicked][yClicked].setIcon(Bqueen);
									System.out.println("EXPOSING KING");
									return;
								}
							}
						}
						
						}
					}

					
					tiles[i][j].setIcon(Bqueen);
					chessPiece[k].setX(i);
					chessPiece[k].setY(j);
					WKingIsChecked = isChecked(chessPiece[k].getX(), chessPiece[k].getY(), isWhiteTurn);
					chessPiece[12].setKingIsChecked(WKingIsChecked);
					if(WKingIsChecked) {
						chessPiece[12].setKingInDanger(true);
					}
					
					return;
				}
				
				if(tiles[xClicked][yClicked].getIcon().equals(Bking) && chessPiece[k].getClass().getSimpleName().equals("King") && xClicked == chessPiece[k].getX() && yClicked == chessPiece[k].getY() && (chessPiece[k].isValidMove(i,j,isWhiteTurn) || chessPiece[k].getMoveCounter() == 0)) {
					
					
					
					if(chessPiece[28].isKingIsChecked()) {
						
					
						
					for(int x = 0; x < chessPiece.length; x++) {
						
						
						if(chessPiece[x].getxChecked() == i && chessPiece[x].getyChecked() == j) {
							
							tiles[xClicked][yClicked].setIcon(null);
							KingInDanger(i, j, isWhiteTurn);
						
							if(chessPiece[28].isKingInDanger()) {
								tiles[xClicked][yClicked].setIcon(Bking);
								System.out.println("KING IN DANGER");
								return;
							}	
							
							BKingIsChecked = false;
							chessPiece[28].setKingIsChecked(BKingIsChecked);
							chessPiece[28].setKingInDanger(false);
							
							for(int y = 0; y < 8; y++) {
								for(int z = 0; z < 8; z++) {
								
									if(y == chessPiece[28].getX() && z == chessPiece[28].getY()) {
										System.out.println("tiles2: "+tiles2[y][z].getBackground());
										System.out.println("tiles: "+tiles[y][z].getBackground());
										tiles[y][z].setBackground(tiles2[y][z].getBackground());
										chessPiece[x].setxChecked(-1);//Or set to 0, -1 as if setting an int to null
										chessPiece[x].setyChecked(-1);
										chessPiece[x].setX(-1);
										chessPiece[x].setY(-1);
										
										tiles[i][j].setIcon(Bking);
										chessPiece[k].setX(i);
										chessPiece[k].setY(j);
										chessPiece[k].setMoveCounter(chessPiece[k].getMoveCounter() + 1);
										return;
									}
								}
							}
						}
					}
					for(int x = 0; x < chessPiece.length; x++) {
						
						tiles[xClicked][yClicked].setIcon(null);
						KingInDanger(i, j, isWhiteTurn);
					
						if(chessPiece[28].isKingInDanger()) {
							tiles[xClicked][yClicked].setIcon(Bking);
							System.out.println("KING IN DANGER");
							return;
						}	
						
							BKingIsChecked = false;
							chessPiece[28].setKingIsChecked(BKingIsChecked);
							chessPiece[28].setKingInDanger(false);
							
							for(int y = 0; y < 8; y++) {
								for(int z = 0; z < 8; z++) {
								
									if(y == chessPiece[28].getX() && z == chessPiece[28].getY()) {
										System.out.println("tiles2: "+tiles2[y][z].getBackground());
										System.out.println("tiles: "+tiles[y][z].getBackground());
										tiles[y][z].setBackground(tiles2[y][z].getBackground());
										chessPiece[x].setxChecked(-1);//Or set to 0, -1 as if setting an int to null
										chessPiece[x].setyChecked(-1);
								
										tiles[xClicked][yClicked].setIcon(null);
										tiles[i][j].setIcon(Bking);
										chessPiece[k].setX(i);
										chessPiece[k].setY(j);
										chessPiece[k].setMoveCounter(chessPiece[k].getMoveCounter() + 1);
										return;
									}
								}
							}
						
					}
					}
					tiles[xClicked][yClicked].setIcon(null);
					KingInDanger(i, j, isWhiteTurn);
				
					if(chessPiece[28].isKingInDanger()) {
						tiles[xClicked][yClicked].setIcon(Bking);
						System.out.println("KING IN DANGER");
						return;
					}	
					
					if(chessPiece[k].getMoveCounter() == 0 && chessPiece[24].getMoveCounter() == 0 && chessPiece[k].getX() != -1 && chessPiece[24].getX() != -1 && (i == 0 || j == 2) && tiles[0][1].getIcon() == null && tiles[0][2].getIcon() == null && tiles[0][3].getIcon() == null) {
						tiles[i][j].setIcon(Bking);
						chessPiece[k].setX(i);
						chessPiece[k].setY(j);
						chessPiece[k].setMoveCounter(chessPiece[k].getMoveCounter() + 1);
						
						tiles[0][0].setIcon(null);
						tiles[0][3].setIcon(Brook);
						chessPiece[24].setX(0);
						chessPiece[24].setY(3);
						chessPiece[24].setMoveCounter(chessPiece[24].getMoveCounter() + 1);
						return;
					}
					
					if(chessPiece[k].getMoveCounter() == 0 && chessPiece[31].getMoveCounter() == 0 && chessPiece[k].getX() != -1 && chessPiece[31].getX() != -1 && (i == 0 || j == 6) && tiles[0][5].getIcon() == null && tiles[0][6].getIcon() == null) {
						tiles[i][j].setIcon(Bking);
						chessPiece[k].setX(i);
						chessPiece[k].setY(j);
						chessPiece[k].setMoveCounter(chessPiece[k].getMoveCounter() + 1);
						
						tiles[0][7].setIcon(null);
						tiles[0][5].setIcon(Brook);
						chessPiece[31].setX(0);
						chessPiece[31].setY(5);
						chessPiece[31].setMoveCounter(chessPiece[31].getMoveCounter() + 1);
						return;
					}

					for(int x = 0; x < chessPiece.length; x++) {
						
						if(i == chessPiece[x].getX() && j == chessPiece[x].getY()) {
							chessPiece[x].setX(-1);
							chessPiece[x].setY(-1);
						}
					}

					
					tiles[i][j].setIcon(Bking);
					chessPiece[k].setX(i);
					chessPiece[k].setY(j);
					chessPiece[k].setMoveCounter(chessPiece[k].getMoveCounter() + 1);
					return;
				}
				
			}
		}
			
		
		
		
		
		 
	}
	/**
	 * Returns a boolean that determines if a piece is free to move
	 * @param xClicked
	 * @param yClicked
	 * @param x
	 * @param y
	 * @param isWhiteTurn
	 * @return true if no obstacle in path of piece new position
	 */
	public boolean PathIsFree(int xClicked, int yClicked, int x, int y, boolean isWhiteTurn) {
		int x_TargetTile = x;
		int y_TargetTile = y;
		//Initial coordinates subject to change, act as pointers
		int x_initial = xClicked;
		int y_initial = yClicked;
		int Xdelta = 0;
		int Ydelta = 0;
		
		Xdelta = xClicked - x_TargetTile;//Distance in x
		Ydelta = yClicked - y_TargetTile;//Distance in y
		
		
		while((x_initial != x_TargetTile || y_initial != y_TargetTile ) && isWhiteTurn == true && x_initial > -1 && x_initial < 8 && y_initial > -1 && y_initial < 8) {
			//Bishop
			if(tiles[xClicked][yClicked].getIcon().equals(Wbishop)) {
				System.out.println("white bishop");
				//Checking all directions 
				if(Xdelta > 0 && Ydelta > 0 && Math.abs(Xdelta) == Math.abs(Ydelta)) {
					System.out.println("Up-left diag");
					x_initial--;
					y_initial--;
				}
				if(Xdelta > 0 && Ydelta < 0 && Math.abs(Xdelta) == Math.abs(Ydelta)) {
					System.out.println("Up-right diag");
					x_initial--;
					y_initial++;
				}
				if(Xdelta < 0 && Ydelta < 0 && Math.abs(Xdelta) == Math.abs(Ydelta)) {
					System.out.println("Low-right diag");
					x_initial++;
					y_initial++;
				}
				if(Xdelta < 0 && Ydelta > 0 && Math.abs(Xdelta) == Math.abs(Ydelta)) {
					System.out.println("Low-left diag");
					x_initial++;
					y_initial--;
				}
				
				else if(Math.abs(Xdelta) != Math.abs(Ydelta)) {//Making sure the method checks diagonally
					return false;
				}
				
				//Checking for obstacles
				System.out.println("Selected piece is at: "+xClicked + " " + yClicked);
				System.out.println("Checking for obstacles: " + x_initial + " " + y_initial);
				
				if(tiles[x_initial][y_initial].getIcon() != null && x_initial != x_TargetTile && y_initial != y_TargetTile) {
					System.out.println("Obstacle found!");
					return false;
				}	
			
			}
			//Queen
			if(tiles[xClicked][yClicked].getIcon().equals(Wqueen)) {
				System.out.println("white queen");
				//Diagonal
				if(Xdelta > 0 && Ydelta > 0 && Math.abs(Xdelta) == Math.abs(Ydelta)) {
					System.out.println("Up-left diag");
					x_initial--;
					y_initial--;
					if(tiles[x_initial][y_initial].getIcon() != null && x_initial != x_TargetTile && y_initial != y_TargetTile) {
						System.out.println("Obstacle found!");
						return false;
					}
				}
				if(Xdelta > 0 && Ydelta < 0 && Math.abs(Xdelta) == Math.abs(Ydelta)) {
					System.out.println("Up-right diag");
					x_initial--;
					y_initial++;
					if(tiles[x_initial][y_initial].getIcon() != null && x_initial != x_TargetTile && y_initial != y_TargetTile) {
						System.out.println("Obstacle found!");
						return false;
					}
				}
				if(Xdelta < 0 && Ydelta < 0 && Math.abs(Xdelta) == Math.abs(Ydelta)) {
					System.out.println("Low-right diag");
					x_initial++;
					y_initial++;
					if(tiles[x_initial][y_initial].getIcon() != null && x_initial != x_TargetTile && y_initial != y_TargetTile) {
						System.out.println("Obstacle found!");
						return false;
					}
				}
				if(Xdelta < 0 && Ydelta > 0 && Math.abs(Xdelta) == Math.abs(Ydelta)) {
					System.out.println("Low-left diag");
					x_initial++;
					y_initial--;
					if(tiles[x_initial][y_initial].getIcon() != null && x_initial != x_TargetTile && y_initial != y_TargetTile) {
						System.out.println("Obstacle found!");
						return false;
					}
				}
				//Sideways and forward
				if(Xdelta > 0 && Ydelta == 0) {	
					System.out.println("Forward");
					x_initial--;
					if(tiles[x_initial][y_initial].getIcon() != null && x_initial != x_TargetTile) {
						System.out.println("Obstacle found!");
						return false;
					}
				}
				if(Xdelta < 0 && Ydelta == 0) {
					System.out.println("Backward");
					x_initial++;
					if(tiles[x_initial][y_initial].getIcon() != null && x_initial != x_TargetTile) {
						System.out.println("Obstacle found!");
						return false;
					}
				}
				if(Xdelta == 0 && Ydelta > 0) {
					System.out.println("Left");
					y_initial--;
					if(tiles[x_initial][y_initial].getIcon() != null && y_initial != y_TargetTile) {
						System.out.println("Obstacle found!");
						return false;
					}
				}
				if(Xdelta == 0 && Ydelta < 0) {
					System.out.println("Right");
					y_initial++;
					if(tiles[x_initial][y_initial].getIcon() != null && y_initial != y_TargetTile) {
						System.out.println("Obstacle found!");
						return false;
					}
				}
				//If it's not a legal direction
				else if(Math.abs(Xdelta) != Math.abs(Ydelta) && !(Math.abs(Xdelta) > 0 && Ydelta == 0) && !(Xdelta == 0 && Math.abs(Ydelta) > 0) ) {
					return false;
				}
				
				System.out.println("Selected piece is at: "+xClicked + " " + yClicked);
				System.out.println("Checking for obstacles: " + x_initial + " " + y_initial);
				
			}
			//Rook
			if(tiles[xClicked][yClicked].getIcon().equals(Wrook)) {
				System.out.println("white rook");
				//Checking all legal directions
				if(Xdelta > 0 && Ydelta == 0) {
					System.out.println("Forward");
					x_initial--;
					if(tiles[x_initial][y_initial].getIcon() != null && x_initial != x_TargetTile) {
						System.out.println("Obstacle found!");
						return false;
					}
				}
				else if(Xdelta < 0 && Ydelta == 0) {
					System.out.println("Backward");
					x_initial++;
					if(tiles[x_initial][y_initial].getIcon() != null && x_initial != x_TargetTile) {
						System.out.println("Obstacle found!");
						return false;
					}
				}
				else if(Xdelta == 0 && Ydelta > 0) {
					System.out.println("Left");
					y_initial--;
					if(tiles[x_initial][y_initial].getIcon() != null && y_initial != y_TargetTile) {
						System.out.println("Obstacle found!");
						return false;
					}
				}
				else if(Xdelta == 0 && Ydelta < 0) {
					System.out.println("Right");
					y_initial++;
					if(tiles[x_initial][y_initial].getIcon() != null && y_initial != y_TargetTile) {
						System.out.println("Obstacle found!");
						return false;
					}
				}
				//If move is not legal
				else if(Math.abs(Xdelta) != Math.abs(Ydelta) && !(Math.abs(Xdelta) > 0 && Ydelta == 0) && !(Xdelta == 0 && Math.abs(Ydelta) > 0) ) {
					return false;
				}
				
				System.out.println("Selected piece is at: "+xClicked + " " + yClicked);
				System.out.println("Checking for obstacles: " + x_initial + " " + y_initial);
				
					
			}
			//Pawn
			if(tiles[xClicked][yClicked].getIcon().equals(Wpawn)) {
				System.out.println("White pawn");
				
				System.out.println("Selected piece is at: "+xClicked + " " + yClicked);
				System.out.println("Checking for obstacles...");
				
				//Diagonal and forward
				if(Xdelta == 1 && Ydelta == 1){
					x_initial--;
					y_initial--;
					if(tiles[x_initial][y_initial].getIcon() != null) {
						return true;
					}
				}
				if(Xdelta == 1 && Ydelta == -1) {
					x_initial--;
					y_initial++;
					if(tiles[x_initial][y_initial].getIcon() != null) {
						return true;
					}
				}
				if(Xdelta == 1 && Ydelta == 0) {
					x_initial--;
					if(tiles[x_initial][y_initial].getIcon() != null) {
						System.out.println("Obstacle found!");
						return false;
					}
					else {
						System.out.println("Pawn is free to move forward.");
					}
				}
				if(Xdelta == 2 && Ydelta == 0) {
					x_initial -= 2;
					if(tiles[x_initial][y_initial].getIcon() != null) {
						System.out.println("Obstacle found!");
						return false;
					}
					else {
						System.out.println("Pawn is free to move forward.");
					}
				}
				
			}
			
			
			
			
			

		}
		
		
		
		while((x_initial != x_TargetTile || y_initial != y_TargetTile ) && isWhiteTurn == false && x_initial > -1 && x_initial < 8 && y_initial > -1 && y_initial < 8) {
			if(tiles[xClicked][yClicked].getIcon().equals(Bbishop)) {
				System.out.println("black bishop");
				//Checking all directions 
				if(Xdelta > 0 && Ydelta > 0 && Math.abs(Xdelta) == Math.abs(Ydelta)) {
					System.out.println("Up-left diag");
					x_initial--;
					y_initial--;
				}
				if(Xdelta > 0 && Ydelta < 0 && Math.abs(Xdelta) == Math.abs(Ydelta)) {
					System.out.println("Up-right diag");
					x_initial--;
					y_initial++;
				}
				if(Xdelta < 0 && Ydelta < 0 && Math.abs(Xdelta) == Math.abs(Ydelta)) {
					System.out.println("Low-right diag");
					x_initial++;
					y_initial++;
				}
				if(Xdelta < 0 && Ydelta > 0 && Math.abs(Xdelta) == Math.abs(Ydelta)) {
					System.out.println("Low-left diag");
					x_initial++;
					y_initial--;
				}
				
				else if(Math.abs(Xdelta) != Math.abs(Ydelta)) {
					return false;
				}
				
				//Checking for obstacles
				System.out.println("Selected piece is at: "+xClicked + " " + yClicked);
				System.out.println("Checking for obstacles: " + x_initial + " " + y_initial);
				
				if(tiles[x_initial][y_initial].getIcon() != null && x_initial != x_TargetTile && y_initial != y_TargetTile) {
					System.out.println("Obstacle found!");
					return false;
				}	
			
			}
			
			if(tiles[xClicked][yClicked].getIcon().equals(Bqueen)) {
				System.out.println("black queen");
				//Diagonal
				if(Xdelta > 0 && Ydelta > 0 && Math.abs(Xdelta) == Math.abs(Ydelta)) {
					System.out.println("Up-left diag");
					x_initial--;
					y_initial--;
					if(tiles[x_initial][y_initial].getIcon() != null && x_initial != x_TargetTile && y_initial != y_TargetTile) {
						System.out.println("Obstacle found!");
						return false;
					}
				}
				if(Xdelta > 0 && Ydelta < 0 && Math.abs(Xdelta) == Math.abs(Ydelta)) {
					System.out.println("Up-right diag");
					x_initial--;
					y_initial++;
					if(tiles[x_initial][y_initial].getIcon() != null && x_initial != x_TargetTile && y_initial != y_TargetTile) {
						System.out.println("Obstacle found!");
						return false;
					}
				}
				if(Xdelta < 0 && Ydelta < 0 && Math.abs(Xdelta) == Math.abs(Ydelta)) {
					System.out.println("Low-right diag");
					x_initial++;
					y_initial++;
					if(tiles[x_initial][y_initial].getIcon() != null && x_initial != x_TargetTile && y_initial != y_TargetTile) {
						System.out.println("Obstacle found!");
						return false;
					}
				}
				if(Xdelta < 0 && Ydelta > 0 && Math.abs(Xdelta) == Math.abs(Ydelta)) {
					System.out.println("Low-left diag");
					x_initial++;
					y_initial--;
					if(tiles[x_initial][y_initial].getIcon() != null && x_initial != x_TargetTile && y_initial != y_TargetTile) {
						System.out.println("Obstacle found!");
						return false;
					}
				}
				//Sideways and forward
				if(Xdelta > 0 && Ydelta == 0) {	
					System.out.println("Forward");
					x_initial--;
					if(tiles[x_initial][y_initial].getIcon() != null && x_initial != x_TargetTile) {
						System.out.println("Obstacle found!");
						return false;
					}
				}
				if(Xdelta < 0 && Ydelta == 0) {
					System.out.println("Backward");
					x_initial++;
					if(tiles[x_initial][y_initial].getIcon() != null && x_initial != x_TargetTile) {
						System.out.println("Obstacle found!");
						return false;
					}
					else {
						System.out.println(tiles[x_initial][y_initial].getIcon());
						System.out.println("xini = "+x_initial);
						System.out.println("xtarget = "+x_TargetTile);
					}
				}
				if(Xdelta == 0 && Ydelta > 0) {
					System.out.println("Left");
					y_initial--;
					if(tiles[x_initial][y_initial].getIcon() != null && y_initial != y_TargetTile) {
						System.out.println("Obstacle found!");
						return false;
					}
				}
				if(Xdelta == 0 && Ydelta < 0) {
					System.out.println("Right");
					y_initial++;
					if(tiles[x_initial][y_initial].getIcon() != null && y_initial != y_TargetTile) {
						System.out.println("Obstacle found!");
						return false;
					}
				}
				else if(Math.abs(Xdelta) != Math.abs(Ydelta) && !(Math.abs(Xdelta) > 0 && Ydelta == 0) && !(Xdelta == 0 && Math.abs(Ydelta) > 0) ) {
					return false;
				}
				
				System.out.println("Selected piece is at: "+xClicked + " " + yClicked);
				System.out.println("Checking for obstacles: " + x_initial + " " + y_initial);
			}
			if(tiles[xClicked][yClicked].getIcon().equals(Brook)) {
				System.out.println("black rook");
				
				if(Xdelta > 0 && Ydelta == 0) {
					System.out.println("Forward");
					x_initial--;
					if(tiles[x_initial][y_initial].getIcon() != null && x_initial != x_TargetTile) {
						System.out.println("Obstacle found!");
						return false;
					}
				}
				else if(Xdelta < 0 && Ydelta == 0) {
					System.out.println("Backward");
					x_initial++;
					if(tiles[x_initial][y_initial].getIcon() != null && x_initial != x_TargetTile) {
						System.out.println("Obstacle found!");
						return false;
					}
				}
				else if(Xdelta == 0 && Ydelta > 0) {
					System.out.println("Left");
					y_initial--;
					if(tiles[x_initial][y_initial].getIcon() != null && y_initial != y_TargetTile) {
						System.out.println("Obstacle found!");
						return false;
					}
				}
				else if(Xdelta == 0 && Ydelta < 0) {
					System.out.println("Right");
					y_initial++;
					if(tiles[x_initial][y_initial].getIcon() != null && y_initial != y_TargetTile) {
						System.out.println("Obstacle found!");
						return false;
					}
				}
				else if(Math.abs(Xdelta) != Math.abs(Ydelta) && !(Math.abs(Xdelta) > 0 && Ydelta == 0) && !(Xdelta == 0 && Math.abs(Ydelta) > 0) ) {
					return false;
				}
				
				System.out.println("Selected piece is at: "+xClicked + " " + yClicked);
				System.out.println("Checking for obstacles: " + x_initial + " " + y_initial);
				
			}
			if(tiles[xClicked][yClicked].getIcon().equals(Bpawn)) {
				System.out.println("Black pawn");
				
				System.out.println("Selected piece is at: "+xClicked + " " + yClicked);
				System.out.println("Checking for obstacles...");
				if(Xdelta == -1 && Ydelta == 1){
					x_initial++;
					y_initial--;
					if(tiles[x_initial][y_initial].getIcon() != null) {
						return true;
					}
				}
				if(Xdelta == -1 && Ydelta == -1) {
					x_initial++;
					y_initial++;
					if(tiles[x_initial][y_initial].getIcon() != null) {
						return true;
					}
				}
				if(Xdelta == -1 && Ydelta == 0) {
					x_initial++;
					if(tiles[x_initial][y_initial].getIcon() != null) {
						System.out.println("Obstacle found!");
						return false;
					}
					else {
						System.out.println("Pawn is free to move forward.");
					}
				}
				if(Xdelta == -2 && Ydelta == 0) {
					x_initial += 2;
					if(tiles[x_initial][y_initial].getIcon() != null) {
						System.out.println("Obstacle found!");
						return false;
					}
					else {
						System.out.println("Pawn is free to move forward.");
					}
				}
				
				
			}
			
			
			
			
			

		}
		return true;
		
		
	}
	/**
	 * Returns a boolean that determines whether a king would be checked
	 * @param x_CheckedPiece
	 * @param y_CheckedPiece
	 * @param isWhiteTurn
	 * @return true if a king is checked
	 */
	public boolean isChecked(int x_CheckedPiece, int y_CheckedPiece, boolean isWhiteTurn) {
		int x_Wking = 0;
		int y_Wking = 0;
		int x_Bking = 0;
		int y_Bking = 0;
		//Initial coordinates subject to change, act like pointers
		int x = x_CheckedPiece;
		int y = y_CheckedPiece;
		int XdeltaWking = 0;
		int YdeltaWking = 0;
		int XdeltaBking = 0;
		int YdeltaBking = 0;
		boolean pathFree = false;
		
		
		
		//Locating the coordinates of the king
		if(isWhiteTurn == true) {
			x_Bking = chessPiece[28].getX();
			y_Bking = chessPiece[28].getY();
			XdeltaBking = x_CheckedPiece - x_Bking;
			YdeltaBking = y_CheckedPiece - y_Bking;
			System.out.println("BKing at: " + x_Bking + " " + y_Bking);
		
		}
		else if(isWhiteTurn == false) {
			x_Wking = chessPiece[12].getX();
			y_Wking = chessPiece[12].getY();
			XdeltaWking = x_CheckedPiece - x_Wking;
			YdeltaWking = y_CheckedPiece - y_Wking;
			System.out.println("WKing at: " + x_Wking + " " + y_Wking);
		}
		
		while((x != x_Bking || y != y_Bking) && isWhiteTurn == true && x > -1 && x < 8 && y > -1 && y < 8) {
			//Checking all pieces
			if(tiles[x_CheckedPiece][y_CheckedPiece].getIcon().equals(Wbishop)) {
				System.out.println("white bishop");
				//Checking all directions 
				if(XdeltaBking > 0 && YdeltaBking > 0 && Math.abs(XdeltaBking) == Math.abs(YdeltaBking)) {
					System.out.println("Up-left diag");
					x--;
					y--;
				}
				if(XdeltaBking > 0 && YdeltaBking < 0 && Math.abs(XdeltaBking) == Math.abs(YdeltaBking)) {
					System.out.println("Up-right diag");
					x--;
					y++;
				}
				if(XdeltaBking < 0 && YdeltaBking < 0 && Math.abs(XdeltaBking) == Math.abs(YdeltaBking)) {
					System.out.println("Low-right diag");
					x++;
					y++;
				}
				if(XdeltaBking < 0 && YdeltaBking > 0 && Math.abs(XdeltaBking) == Math.abs(YdeltaBking)) {
					System.out.println("Low-left diag");
					x++;
					y--;
				}
				//If direction is an illegal move
				else if(Math.abs(XdeltaBking) != Math.abs(YdeltaBking)) {
					return false;
				}
				
				//Checking for obstacles
				System.out.println("Checked piece is at: "+x_CheckedPiece + " " + y_CheckedPiece);
				System.out.println("Checking for obstacles: " + x + " " + y);
				
				if(tiles[x][y].getIcon() != null && !tiles[x][y].getIcon().equals(Bking)) {
					System.out.println("Obstacle found!");
					return false;
				}
				pathFree = true;
			}
			
			if(tiles[x_CheckedPiece][y_CheckedPiece].getIcon().equals(Wqueen)) {
				System.out.println("white queen");
				//Diagonal
				if(XdeltaBking > 0 && YdeltaBking > 0 && Math.abs(XdeltaBking) == Math.abs(YdeltaBking)) {
					System.out.println("Up-left diag");
					x--;
					y--;
				}
				if(XdeltaBking > 0 && YdeltaBking < 0 && Math.abs(XdeltaBking) == Math.abs(YdeltaBking)) {
					System.out.println("Up-right diag");
					x--;
					y++;
				}
				if(XdeltaBking < 0 && YdeltaBking < 0 && Math.abs(XdeltaBking) == Math.abs(YdeltaBking)) {
					System.out.println("Low-right diag");
					x++;
					y++;
				}
				if(XdeltaBking < 0 && YdeltaBking > 0 && Math.abs(XdeltaBking) == Math.abs(YdeltaBking)) {
					System.out.println("Low-left diag");
					x++;
					y--;
				}
				//Sideways and forward
				if(XdeltaBking > 0 && YdeltaBking == 0) {
					System.out.println("Forward");
					x--;
				}
				if(XdeltaBking < 0 && YdeltaBking == 0) {
					System.out.println("Backward");
					x++;
				}
				if(XdeltaBking == 0 && YdeltaBking > 0) {
					System.out.println("Left");
					y--;
				}
				if(XdeltaBking == 0 && YdeltaBking < 0) {
					System.out.println("Right");
					y++;
				}
				//If direction is an illegal move
				else if(Math.abs(XdeltaBking) != Math.abs(YdeltaBking) && !(Math.abs(XdeltaBking) > 0 && YdeltaBking == 0) && !(XdeltaBking == 0 && Math.abs(YdeltaBking) > 0) ) {
					return false;
				}
				//Checking for obstacles
				System.out.println("Checked piece is at: "+x_CheckedPiece + " " + y_CheckedPiece);
				System.out.println("Checking for obstacles: " + x + " " + y);
				
					
					if(tiles[x][y].getIcon() != null && !tiles[x][y].getIcon().equals(Bking)) {
						System.out.println("Obstacle found!");
						return false;
					}
					pathFree = true;
				
			}
			
			if(tiles[x_CheckedPiece][y_CheckedPiece].getIcon().equals(Wrook)) {
				System.out.println("white rook");
				//Checking all legal directions
				if(XdeltaBking > 0 && YdeltaBking == 0) {
					System.out.println("Forward");
					x--;
				}
				if(XdeltaBking < 0 && YdeltaBking == 0) {
					System.out.println("Backward");
					x++;
				}
				if(XdeltaBking == 0 && YdeltaBking > 0) {
					System.out.println("Left");
					y--;
				}
				if(XdeltaBking == 0 && YdeltaBking < 0) {
					System.out.println("Right");
					y++;
				}
				//If direction is an illegal move
				else if(Math.abs(XdeltaBking) != Math.abs(YdeltaBking) && !(Math.abs(XdeltaBking) > 0 && YdeltaBking == 0) && !(XdeltaBking == 0 && Math.abs(YdeltaBking) > 0) ) {
					return false;
				}
				//Checking for obstacles
				System.out.println("Checked piece is at: "+x_CheckedPiece + " " + y_CheckedPiece);
				System.out.println("Checking for obstacles: " + x + " " + y);
				
					
					if(tiles[x][y].getIcon() != null && !tiles[x][y].getIcon().equals(Bking)) {
						System.out.println("Obstacle found!");
						return false;
					}
					pathFree = true;
			}
			if(tiles[x_CheckedPiece][y_CheckedPiece].getIcon().equals(Wpawn)) {
				System.out.println("White pawn");
				//Checking all legal moves
				System.out.println("Checked piece is at: "+x_CheckedPiece + " " + y_CheckedPiece);
				if(XdeltaBking == 1 && YdeltaBking == 1){
					x--;
					y--;
				}
				if(XdeltaBking == 1 && YdeltaBking == -1) {
					x--;
					y++;
				}
				//If direction is an illegal move
				if(tiles[x][y].getIcon() != null && !tiles[x][y].getIcon().equals(Bking)) {
					System.out.println("Obstacle found!");
					return false;
				}
				
				pathFree = true;
			}
			if(tiles[x_CheckedPiece][y_CheckedPiece].getIcon().equals(Wknight)) {
				System.out.println("White knight");
				
				//All legal directions
				if(XdeltaBking == 2 && YdeltaBking == -1) {
					x -= 2;
					y++;
				}
				if(XdeltaBking == 2 && YdeltaBking == 1) {
					x -= 2;
					y--;
				}
				if(XdeltaBking == 1 && YdeltaBking == -2) {
					x--;
					y += 2;
				}
				if(XdeltaBking == 1 && YdeltaBking == 2) {
					x--;
					y -= 2;
				}
				if(XdeltaBking == -1 && YdeltaBking == -2) {
					x++;
					y += 2;
				}
				if(XdeltaBking == -1 && YdeltaBking == 2) {
					x++;
					y -= 2;
				}
				if(XdeltaBking == -2 && YdeltaBking == -1) {
					x += 2;
					y++;
				}
				if(XdeltaBking == -2 && YdeltaBking == 1) {
					x += 2;
					y--;
				}
				//If direction is an illegal move
				else if(tiles[x][y].getIcon() != null && !tiles[x][y].getIcon().equals(Bking)){
					return false;
				}
				System.out.println("Checked piece is at: "+x_CheckedPiece + " " + y_CheckedPiece);
				pathFree = true;
			}
		}
		
		while((x != x_Wking || y != y_Wking) && isWhiteTurn == false && x > -1 && x < 8 && y > -1 && y < 8) {
			
			if(tiles[x_CheckedPiece][y_CheckedPiece].getIcon().equals(Bbishop)) {
				
				System.out.println("black bishop");
				//Checking all directions 
				if(XdeltaWking > 0 && YdeltaWking > 0 && Math.abs(XdeltaWking) == Math.abs(YdeltaWking)) {
					System.out.println("Up-left diag");
					x--;
					y--;
				}
				if(XdeltaWking > 0 && YdeltaWking < 0 && Math.abs(XdeltaWking) == Math.abs(YdeltaWking)) {
					System.out.println("Up-right diag");
					x--;
					y++;
				}
				if(XdeltaWking < 0 && YdeltaWking < 0 && Math.abs(XdeltaWking) == Math.abs(YdeltaWking)) {
					System.out.println("Low-right diag");
					x++;
					y++;
				}
				if(XdeltaWking < 0 && YdeltaWking > 0 && Math.abs(XdeltaWking) == Math.abs(YdeltaWking)) {
					System.out.println("Low-left diag");
					x++;
					y--;
				}
				
				else if(Math.abs(XdeltaWking) != Math.abs(YdeltaWking)) {
					return false;
				}
				
				//Checking for obstacles
				System.out.println("Checked piece is at: "+x_CheckedPiece + " " + y_CheckedPiece);
				System.out.println("Checking for obstacles: " + x + " " + y);
				
				if(tiles[x][y].getIcon() != null && !tiles[x][y].getIcon().equals(Wking)) {
					System.out.println("Obstacle found!");
					return false;
				}
				pathFree = true;
			}
			
			if(tiles[x_CheckedPiece][y_CheckedPiece].getIcon().equals(Bqueen)) {
				
				System.out.println("black queen");
				//Diagonal
				if(XdeltaWking > 0 && YdeltaWking > 0 && Math.abs(XdeltaWking) == Math.abs(YdeltaWking)) {
					System.out.println("Up-left diag");
					x--;
					y--;
				}
				if(XdeltaWking > 0 && YdeltaWking < 0 && Math.abs(XdeltaWking) == Math.abs(YdeltaWking)) {
					System.out.println("Up-right diag");
					x--;
					y++;
				}
				if(XdeltaWking < 0 && YdeltaWking < 0 && Math.abs(XdeltaWking) == Math.abs(YdeltaWking)) {
					System.out.println("Low-right diag");
					x++;
					y++;
				}
				if(XdeltaWking < 0 && YdeltaWking > 0 && Math.abs(XdeltaWking) == Math.abs(YdeltaWking)) {
					System.out.println("Low-left diag");
					x++;
					y--;
				}
				//Sideways and forward
				if(XdeltaWking > 0 && YdeltaWking == 0) {
					System.out.println("Forward");
					x--;
				}
				if(XdeltaWking < 0 && YdeltaWking == 0) {
					System.out.println("Backward");
					x++;
				}
				if(XdeltaWking == 0 && YdeltaWking > 0) {
					System.out.println("Left");
					y--;
				}
				if(XdeltaWking == 0 && YdeltaWking < 0) {
					System.out.println("Right");
					y++;
				}
				else if(Math.abs(XdeltaWking) != Math.abs(YdeltaWking) && !(Math.abs(XdeltaWking) > 0 && YdeltaWking == 0) && !(XdeltaWking == 0 && Math.abs(YdeltaWking) > 0) ) {
					return false;
				}
				
				System.out.println("Checked piece is at: "+x_CheckedPiece + " " + y_CheckedPiece);
				System.out.println("Checking for obstacles: " + x + " " + y);
				
					
					if(tiles[x][y].getIcon() != null && !tiles[x][y].getIcon().equals(Wking)) {
						System.out.println("Obstacle found!");
						return false;
					}
					pathFree = true;
				
			}
			
			if(tiles[x_CheckedPiece][y_CheckedPiece].getIcon().equals(Brook)) {
				
				System.out.println("black rook");
				
				if(XdeltaWking > 0 && YdeltaWking == 0) {
					System.out.println("Forward");
					x--;
				}
				if(XdeltaWking < 0 && YdeltaWking == 0) {
					System.out.println("Backward");
					x++;
				}
				if(XdeltaWking == 0 && YdeltaWking > 0) {
					System.out.println("Left");
					y--;
				}
				if(XdeltaWking == 0 && YdeltaWking < 0) {
					System.out.println("Right");
					y++;
				}
				else if(Math.abs(XdeltaWking) != Math.abs(YdeltaWking) && !(Math.abs(XdeltaWking) > 0 && YdeltaWking == 0) && !(XdeltaWking == 0 && Math.abs(YdeltaWking) > 0) ) {
					return false;
				}
				
				System.out.println("Checked piece is at: "+x_CheckedPiece + " " + y_CheckedPiece);
				System.out.println("Checking for obstacles: " + x + " " + y);
				
					
					if(tiles[x][y].getIcon() != null && !tiles[x][y].getIcon().equals(Wking)) {
						System.out.println("Obstacle found!");
						return false;
					}
					pathFree = true;
			}
			if(tiles[x_CheckedPiece][y_CheckedPiece].getIcon().equals(Bpawn)) {
				
				System.out.println("black pawn");
				
				System.out.println("Checked piece is at: "+x_CheckedPiece + " " + y_CheckedPiece);
				if(XdeltaWking == -1 && YdeltaWking == 1){
					x++;
					y--;
				}
				if(XdeltaWking == -1 && YdeltaWking == -1) {
					x++;
					y++;
				}

				if(tiles[x][y].getIcon() != null && !tiles[x][y].getIcon().equals(Wking)) {
					System.out.println("Obstacle found!");
					return false;
				}
				pathFree = true;
			}
			if(tiles[x_CheckedPiece][y_CheckedPiece].getIcon().equals(Bknight)) {
				
				System.out.println("black knight");
				
				
				if(XdeltaWking == 2 && YdeltaWking == -1) {
					x -= 2;
					y++;
				}
				if(XdeltaWking == 2 && YdeltaWking == 1) {
					x -= 2;
					y--;
				}
				if(XdeltaWking == 1 && YdeltaWking == -2) {
					x--;
					y += 2;
				}
				if(XdeltaWking == 1 && YdeltaWking == 2) {
					x--;
					y -= 2;
				}
				if(XdeltaWking == -1 && YdeltaWking == -2) {
					x++;
					y += 2;
				}
				if(XdeltaWking == -1 && YdeltaWking == 2) {
					x++;
					y -= 2;
				}
				if(XdeltaWking == -2 && YdeltaWking == -1) {
					x += 2;
					y++;
				}
				if(XdeltaWking == -2 && YdeltaWking == 1) {
					x += 2;
					y--;
				}
				else if(tiles[x][y].getIcon() != null && !tiles[x][y].getIcon().equals(Wking)){
					return false;
				}
				System.out.println("Checked piece is at: "+x_CheckedPiece + " " + y_CheckedPiece);
				pathFree = true;
			}
		}
		//If no obstacles, king is therefore checked
		for(int i = 0; i < chessPiece.length; i++) {
			if(tiles[x_CheckedPiece][y_CheckedPiece].getIcon() != null && chessPiece[i].getX() == x_CheckedPiece && chessPiece[i].getY() == y_CheckedPiece) {
				chessPiece[i].setxChecked(x_CheckedPiece);
				chessPiece[i].setyChecked(y_CheckedPiece);
				System.out.println(chessPiece[i].getClass().getSimpleName() + " " + chessPiece[i].getxChecked() + " " + chessPiece[i].getyChecked());			
			}
		}
		
		return true;
	}
	
	
	
	private class ButtonHandler implements ActionListener{
		private boolean isSelected;
		private boolean isWhiteTurn;
		private int WmoveCounter;
		private int BmoveCounter;
		private int xClicked;
		private int yClicked;
		
		
		
		
		public ButtonHandler() {
			isSelected = false;
			isWhiteTurn = true;	
			
		}
		public void actionPerformed(ActionEvent e) {
			
			Object source = e.getSource();//An event has a source
			
			//Traversing the board
			
			for(int i = 0; i < 8; i++) {
				
				for(int j = 0; j < 8; j++) {
					
					//White move
					//Selects a piece
					if(source == tiles[i][j] && tiles[i][j].getIcon() != null && isSelected == false && isWhiteTurn == true && tiles[i][j].getIcon().toString().contains("white")) {
						
						System.out.println("White Piece selected.");
						
						 
						DisplayMovePossibilities(i, j, isWhiteTurn);//Displaying move possibilities when piece is selected
								
						 
						WmoveCounter = 0;//Can only move once per turn
						
						if(chessPiece[12].isKingIsChecked() && tiles[i][j].getIcon().toString().contains("white_king")) {
							tiles[i][j].setBackground(Color.ORANGE);//If friendly king is checked
						}
						else {
							tiles[i][j].setBackground(Color.GREEN);//When a piece is selected the tile turns green
						}
						//Assigning clicked coordinates to temp variables
						xClicked = i;
						yClicked = j;
						
						
						isSelected = true;
						return;
					}
					
					//Deselecting a piece
					if(source == tiles[i][j] && source == tiles[xClicked][yClicked] && isSelected == true && isWhiteTurn == true) {
						System.out.println("White Piece deselected.");
						
						//Changing highlighted tile to normal
						for(int x = 0; x < 8; x++) {
							for(int y = 0; y < 8; y++) {
								
								if(tiles[x][y].getBackground().equals(Color.GREEN)) {
									tiles[x][y].setBackground(tiles2[x][y].getBackground());
								}
							}
						}
						isSelected = false;
						return;
					}
					
					//White kills black piece
					if(source == tiles[i][j] && tiles[i][j].getIcon() != null && tiles[i][j].getIcon().toString().contains("black") && isSelected == true && WmoveCounter == 0 && isWhiteTurn == true) {
						System.out.println("White Piece killing Black Piece");
						
						processClick(i,j,xClicked,yClicked,isWhiteTurn);
						
						for(int c = 0; c < chessPiece.length; c++) {
							//Piece will not move if illegal tile is selected
							if(chessPiece[c].isValidTile() == false) {
								chessPiece[c].setValidTile(true);
								return;
							}
							//Piece will not move if it can't move
							if(chessPiece[c].isCanMove() == false) {
								chessPiece[c].setCanMove(true);
								return;
							}
						}
						//If king is in danger, piece will not move
						if(chessPiece[12].isKingInDanger()) {
							return;
						}
						//Changing color tile if opposing king is checked
						if(chessPiece[28].isKingIsChecked() == true) {
							
							tiles[chessPiece[28].getX()][chessPiece[28].getY()].setBackground(Color.ORANGE);
						}
						//Making sure the kill is legal
						for(int k = 0; k < chessPiece.length; k++) {
							if(tiles[xClicked][yClicked].getIcon() != null && chessPiece[k].getX() == xClicked && chessPiece[k].getY() == yClicked && chessPiece[k].isValidTile() == false) {
								return;
							}
						}
						//Changing color back to normal color after being selected and moved
						for(int x = 0; x < 8; x++) {
							for(int y = 0; y < 8; y++) {
								
								if(tiles[x][y].getBackground().equals(Color.GREEN)) {
									tiles[x][y].setBackground(tiles2[x][y].getBackground());
									
								}
							}
						}
						
						
						System.out.println("White Piece selected moved.");
						
						
						System.out.println("White turn end");
						
						isWhiteTurn = false;
						WmoveCounter++;
						xClicked = 0;
						yClicked = 0;
						isSelected = false;
						return;
					}
					
					//Moving white piece
					if(source == tiles[i][j] && tiles[i][j].getIcon() == null && isSelected == true && WmoveCounter == 0 && isWhiteTurn == true) {
						
						
						System.out.println("i: " + i + " j: " + j + " xClicked: " + xClicked + " yClicked: " + yClicked);
						
						processClick(i,j,xClicked,yClicked,isWhiteTurn);
						
						for(int c = 0; c < chessPiece.length; c++) {
							//Piece will not move if an illegal tile is selected
							if(chessPiece[c].isValidTile() == false) {
								chessPiece[c].setValidTile(true);
								return;
							}
							//Piece will not move if it can't move
							if(chessPiece[c].isCanMove() == false) {
								chessPiece[c].setCanMove(true);
								return;
							}
						}
						//If friendly king is in danger
						if(chessPiece[12].isKingInDanger()) {
							return;
						}
						//If opposing king is checked
						if(chessPiece[28].isKingIsChecked() == true) {
							tiles[chessPiece[28].getX()][chessPiece[28].getY()].setBackground(Color.ORANGE);//Changing tile color
						}
						
						
						for(int x = 0; x < 8; x++) {
							for(int y = 0; y < 8; y++) {
								//Resetting tile color to deselect tile
								if(tiles[x][y].getBackground().equals(Color.GREEN)) {
									tiles[x][y].setBackground(tiles2[x][y].getBackground());
									
								}
							}
						}
						System.out.println("White Piece selected moved.");
						System.out.println("White turn end");
						
						isWhiteTurn = false;
						WmoveCounter++;
						xClicked = 0;
						yClicked = 0;
						isSelected = false;
						return;
					}
					
					
					//Black move
					//Selects a piece
					if(source == tiles[i][j] && tiles[i][j].getIcon() != null && isSelected == false && isWhiteTurn == false && tiles[i][j].getIcon().toString().contains("black")) {
						System.out.println("Black Piece selected.");
						
						DisplayMovePossibilities(i, j, isWhiteTurn);
						
						BmoveCounter = 0;
						
						  
						if(chessPiece[28].isKingIsChecked() && tiles[i][j].getIcon().toString().contains("black_king")) {
							tiles[i][j].setBackground(Color.ORANGE);//When a piece is selected the tile turns red
						}
						else {
							tiles[i][j].setBackground(Color.RED);
						}
						xClicked = i;
						yClicked = j;
						
						
						isSelected = true;
						return;
					}
					
					//Deselecting a piece
					if(source == tiles[i][j] && source == tiles[xClicked][yClicked] && isSelected == true && isWhiteTurn == false) {
						System.out.println("Black Piece deselected.");
					
						for(int x = 0; x < 8; x++) {
							for(int y = 0; y < 8; y++) {
								
								if(tiles[x][y].getBackground().equals(Color.RED)) {
									tiles[x][y].setBackground(tiles2[x][y].getBackground());
									
								}
							}
						}
						isSelected = false;
						return;
					}
					
					//Killing a white piece
					if(source == tiles[i][j] && tiles[i][j].getIcon() != null && tiles[i][j].getIcon().toString().contains("white") && isSelected == true && BmoveCounter == 0 && isWhiteTurn == false) {
						System.out.println("Black Piece killing White Piece");
						
						processClick(i,j,xClicked,yClicked,isWhiteTurn);
						
						for(int c = 0; c < chessPiece.length; c++) {
							if(chessPiece[c].isValidTile() == false) {
								chessPiece[c].setValidTile(true);
								return;
							}
							if(chessPiece[c].isCanMove() == false) {
								chessPiece[c].setCanMove(true);
								return;
							}
							
						}
						if(chessPiece[28].isKingInDanger()) {
							return;
						}
						
						if(chessPiece[12].isKingIsChecked() == true) {
							tiles[chessPiece[12].getX()][chessPiece[12].getY()].setBackground(Color.ORANGE);
						}
						
						for(int k = 0; k < chessPiece.length; k++) {
							if(tiles[xClicked][yClicked].getIcon() != null && chessPiece[k].getX() == xClicked && chessPiece[k].getY() == yClicked && chessPiece[k].isValidTile() == false) {
								return;
							}
						}
						System.out.println("Black Piece selected moved.");
						
					
						for(int x = 0; x < 8; x++) {
							for(int y = 0; y < 8; y++) {
								
								if(tiles[x][y].getBackground().equals(Color.RED)) {
									tiles[x][y].setBackground(tiles2[x][y].getBackground());
									
								}
							}
						}
						System.out.println("Black turn end");
						
						isWhiteTurn = true;
						BmoveCounter++;
						xClicked = 0;
						yClicked = 0;
						isSelected = false;
						return;
					}
					
					//Moves a piece
					if(source == tiles[i][j] && tiles[i][j].getIcon() == null && isSelected == true && BmoveCounter == 0 && isWhiteTurn == false) {
						System.out.println("i: " + i + " j: " + j + " xClicked: " + xClicked + " yClicked: " + yClicked + " " + isWhiteTurn);
						processClick(i,j,xClicked,yClicked,isWhiteTurn);
						
						for(int c = 0; c < chessPiece.length; c++) {
							if(chessPiece[c].isValidTile() == false) {
								chessPiece[c].setValidTile(true);
								return;
							}
							if(chessPiece[c].isCanMove() == false) {
								chessPiece[c].setCanMove(true);
								return;
							}
						}
						if(chessPiece[28].isKingInDanger()) {
							return;
						}
						
						System.out.println("Black Piece selected moved.");
						
						if(chessPiece[12].isKingIsChecked() == true) {
							tiles[chessPiece[12].getX()][chessPiece[12].getY()].setBackground(Color.ORANGE);
						}
						
						
						for(int x = 0; x < 8; x++) {
							for(int y = 0; y < 8; y++) {
								
								if(tiles[x][y].getBackground().equals(Color.RED)) {
									tiles[x][y].setBackground(tiles2[x][y].getBackground());
									
								}
							}
						}
						System.out.println("Black turn end");
						
						isWhiteTurn = true;
						BmoveCounter++;
						xClicked = 0;
						yClicked = 0;
						isSelected = false;
						return;
					}
					
					
					
				}
			}
			
		}
	}
}
