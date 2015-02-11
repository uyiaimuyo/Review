import java.util.Scanner;

/**
 * Created by Aysar on 2/10/2015.
 *
 * Design a chess game using object oriented principles.
 *
 * Core objects: 2 players (move), chess pieces (valid moves), chess board (matrix of location of pieces)
 * , game (isChecked, isCheckmate)
 *
 * How does interaction happen?
 * player gives coords of piece they want to move and then 2 coords to where
 *
 * the is a solution with barebones overview, not meant to be actual impl (just OO design)
 */
public class Chess {

    public class Board {
        private Piece[][] board;

        public Board() {
            this.board = new Piece[8][8];

            //setup the board with starting pieces
            Piece.COLOR c = Piece.COLOR.WHITE;
            for (int i=1; i<7; i+=5) {
                for(int j=0; j<board[i].length; j++) {
                    board[i][j] = new Pawn(c, 0, 6);
                }
                c = Piece.COLOR.BLACK;
            }
        }

        public void move(Player player, int x, int y, int xEnd, int yEnd) {

        }

        public boolean isCheckMate() {
            return false;
        }
    }

    public interface Piece {
        enum COLOR {WHITE, BLACK};
        void moveTo(Loc end);
    }

    public class Loc {
        int x;
        int y;
        public Loc(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public abstract class PieceAbstract {
        protected Piece.COLOR color;
        protected String imgPath;
        protected Loc loc;
    }

    public class Pawn extends PieceAbstract implements Piece {
        public Pawn(COLOR color, int x, int y) {
            this.color = color;
            this.imgPath = "pawn.jpg";
            this.loc = new Loc(x, y);
        }

        public void moveTo(Loc end) {
        }
    }

    public class Castle extends PieceAbstract implements Piece {
        public Castle(COLOR color, int x, int y) {
            this.color = color;
            this.imgPath = "castle.jpg";
            this.loc = new Loc(x, y);
        }

        public void moveTo(Loc end) {
        }
    }

    public class Player {
        Piece.COLOR color;
        public Player(Piece.COLOR color) {
            this.color = color;
        }
    }

    // should be static but not doing it because I wouldn't be able
    // access other above classes because I want to keep this all in 1 file for simplicity
    // this isn't to be run anyways and is for an overview of how a Chess game would be architected
    public void main(String[] args) {

        boolean inplay = true;
        boolean newgame = true;

        while(newgame) {
            Board board = new Board();
            Player p1 = new Player(Piece.COLOR.WHITE);
            Player p2 = new Player(Piece.COLOR.BLACK);

            Scanner in = new Scanner(System.in);

            while(inplay) {
                board.move(p1, 1,1, 1,2);

                if (board.isCheckMate()){
                    System.out.println("p1 wins!");
                    break;
                }
                board.move(p2, 6,6, 6,5);
            }
        }
    }
}
