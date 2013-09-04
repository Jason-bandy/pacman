package jp.or.iidukat.example.pacman.entity;

import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;

import jp.or.iidukat.example.pacman.Direction;
import jp.or.iidukat.example.pacman.PacmanConfig;
import jp.or.iidukat.example.pacman.Direction.Move;
import jp.or.iidukat.example.pacman.entity.Ghost.GhostMode;
import jp.or.iidukat.example.pacman.entity.Ghost.MoveInPen;
import jp.or.iidukat.example.pacman.PacmanGame;
import android.graphics.Bitmap;

public class Inky extends Ghost {

    private static final InitPosition INIT_POS =
        InitPosition.createGhostInitPosition(8.625f, 17, Direction.UP, 57, 20);

    // movements of Inky in the pen
    private static final Map<GhostMode, MoveInPen[]> MOVES_IN_PEN;
    static {
        Map<GhostMode, MoveInPen[]> m =
            new EnumMap<GhostMode, MoveInPen[]>(GhostMode.class);
            m.put(
            		GhostMode.IN_PEN,
            		new MoveInPen[] {
            				new MoveInPen(8.6f, 17, Direction.UP, 16.5f, 0.48f),
            				new MoveInPen(8.6f, 16.5f, Direction.DOWN, 18f, 0.48f),
            				new MoveInPen(8.6f, 18, Direction.UP, 17, 0.48f),
            		});
            m.put(
            		GhostMode.LEAVING_PEN,
            		new MoveInPen[] {
            				new MoveInPen(8.6f, 18, Direction.RIGHT, 10.5f, LEAVING_PEN_SPEED),
            				new MoveInPen(10.5f, 18, Direction.UP, 15, LEAVING_PEN_SPEED),
            		});
            m.put(
            		GhostMode.ENTERING_PEN,
            		new MoveInPen[] {
            				new MoveInPen(10.5f, 15, Direction.DOWN, 18, 1.6f),
            				new MoveInPen(10.5f, 18, Direction.LEFT, 8.625f, 1.6f),
            		});
            m.put(
            		GhostMode.RE_LEAVING_FROM_PEN,
            		new MoveInPen[] {
            				new MoveInPen(9, 18, Direction.RIGHT, 10.5f, LEAVING_PEN_SPEED),
            				new MoveInPen(10.5f, 18, Direction.UP, 15, LEAVING_PEN_SPEED),
            		});
        MOVES_IN_PEN = Collections.unmodifiableMap(m);
    }

    Inky(Bitmap sourceImage, PacmanGame game) {
        super(sourceImage, game);
    }
    
    @Override
    InitPosition getInitPosition() {
        return INIT_POS;
    }
    
    @Override
    public void updateTargetPos() {
        if (this.mode != GhostMode.CHASE) {
            return;
        }
        
        // the player are attacked on both sides by Inky and Blinky
        PlayfieldActor pacman = game.getPacman();
        Move pacmanMove = pacman.dir.getMove();
        PlayfieldActor blinky = game.getBlinky();
        float[] pacmanDest = new float[] { pacman.tilePos[0], pacman.tilePos[1] };
        pacmanDest[pacmanMove.getAxis()] += 16 * pacmanMove.getIncrement();
        if (pacman.dir == Direction.UP) {
            pacmanDest[1] -= 16;
        }
        this.targetPos[0] = pacmanDest[0] * 2 - blinky.tilePos[0];
        this.targetPos[1] = pacmanDest[1] * 2 - blinky.tilePos[1];
    }
    
    @Override
    MoveInPen[] getMovesInPen() {
        if (MOVES_IN_PEN.containsKey(mode)) {
            return MOVES_IN_PEN.get(mode);
        } else {
            return new MoveInPen[0];
        }
    }
    
    @Override
    int getOrdinaryImageRow() {
        return 6;
    }
}
