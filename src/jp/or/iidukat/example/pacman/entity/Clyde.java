package jp.or.iidukat.example.pacman.entity;

import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;

import jp.or.iidukat.example.pacman.Direction;
import jp.or.iidukat.example.pacman.PacmanConfig;
import jp.or.iidukat.example.pacman.PacmanGame;
import android.graphics.Bitmap;

public class Clyde extends Ghost {

    private static final InitPosition INIT_POS =
        InitPosition.createGhostInitPosition(9, 18, Direction.UP, 0, 20);

    // movements of Clyde in the pen
    private static final Map<GhostMode, MoveInPen[]> MOVES_IN_PEN;
    static {
        Map<GhostMode, MoveInPen[]> m =
            new EnumMap<GhostMode, MoveInPen[]>(GhostMode.class);
        m.put(
            GhostMode.IN_PEN,
            new MoveInPen[] {
                new MoveInPen(9, 17, Direction.UP, 16, 0.48f),
                new MoveInPen(9, 16, Direction.DOWN, 18f, 0.48f),
                new MoveInPen(9, 18, Direction.UP, 17, 0.48f),
              });
        m.put(
            GhostMode.LEAVING_PEN,
            new MoveInPen[] {
                new MoveInPen(9, 18, Direction.RIGHT, 10f, LEAVING_PEN_SPEED),
                new MoveInPen(10, 18, Direction.UP, 15, LEAVING_PEN_SPEED),
            });
        m.put(
            GhostMode.ENTERING_PEN,
            new MoveInPen[] {
                new MoveInPen(10, 15, Direction.DOWN, 18, 1.6f),
                new MoveInPen(10, 18, Direction.LEFT, 9f, 1.6f),
            });
        m.put(
            GhostMode.RE_LEAVING_FROM_PEN,
            new MoveInPen[] {
            	new MoveInPen(9, 18, Direction.RIGHT, 10f, LEAVING_PEN_SPEED),
            	new MoveInPen(10, 18, Direction.UP, 15, LEAVING_PEN_SPEED),
            });
        MOVES_IN_PEN = Collections.unmodifiableMap(m);
    }

    Clyde(Bitmap sourceImage, PacmanGame game) {
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
        // If near the player, trace it.
        // If distant from the player,  go to the location assigned in the scatter mode.
        PlayfieldActor pacman = game.getPacman();
        float distance = getDistance(pacman.tilePos, this.tilePos);
        this.targetPos =
            distance > 64
                ? new float[] { pacman.tilePos[0], pacman.tilePos[1] }
                : this.scatterPos;
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
        return 7;
    }
}
