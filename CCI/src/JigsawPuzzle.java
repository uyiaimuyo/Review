/**
 * Created by Aysar on 2/10/2015.
 * Implement a jigsaw puzzle. Design the data structures and explain an
 * algorithm to solve the puzzle.
 *
 * How does user interface?
 * User picks up piece of puzzle and connects with other pieces until all pieces match
 * original image/full puzzle
 *
 * Core objects: 1 Player, jigsaw puzzle pieces, puzzle image/board
 * after each connection check match?
 *
 */
public class JigsawPuzzle {
    PuzzlePiece[][] solution;
    PuzzlePiece[][] currentPieces;
    Edge[] in, out, flat;
    Edge[] unconnected;

    enum Connection{
        in, out, flat;
    }
    public class Edge {
        PuzzlePiece owner;
        Connection c;
        boolean canConnect(Edge e){ return true; }
    }
    public class PuzzlePiece {
        Edge top, right, bottom, left;
        int value;
    }

    public void solve(){
        for(int i=0; i<unconnected.length; i++) {
            if (unconnected[i].c == Connection.in) {
                for(int j=0; j<out.length; j++) {
                    if (unconnected[i].canConnect(out[j])) {
                        // they match, so remove unconnected[i] from unconnect
                        // add out[j] to currentPieces solution
                        // find out[j]'s other edges
                    }
                }
            }
        }
    }
}
