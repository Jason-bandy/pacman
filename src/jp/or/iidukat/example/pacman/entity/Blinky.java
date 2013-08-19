package jp.or.iidukat.example.pacman.entity;

import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;

import jp.or.iidukat.example.pacman.Direction;
import jp.or.iidukat.example.pacman.PacmanConfig;
import jp.or.iidukat.example.pacman.PacmanGame;
import android.graphics.Bitmap;

public class Blinky extends Ghost {

    private static final InitPosition INIT_POS =
        InitPosition.createGhostInitPosition(2.5f, 2, Direction.RIGHT, 57, -4);

    // movements of Blinky in the pen
    private static final Map<GhostMode, MoveInPen[]> MOVES_IN_PEN;
    static {
        Map<GhostMode, MoveInPen[]> m =
            new EnumMap<GhostMode, MoveInPen[]>(GhostMode.class);
        m.put(
            GhostMode.ENTERING_PEN,
            new MoveInPen[] { new MoveInPen(PacmanConfig.sPenPosX, PacmanConfig.sPenPosY, Direction.DOWN, 7, 1.6f) });
        m.put(
            GhostMode.RE_LEAVING_FROM_PEN,
            new MoveInPen[] { new MoveInPen(PacmanConfig.sPenPosX, PacmanConfig.sPenPosY, Direction.UP, 4, LEAVING_PEN_SPEED) });

        MOVES_IN_PEN = Collections.unmodifiableMap(m);
    }

    Blinky(Bitmap sourceImage, PacmanGame game) {
        super(sourceImage, game);
    }

    @Override
    InitPosition getInitPosition() {
        return INIT_POS;
    }
    
    @Override
    public void updateTargetPos() {
        // chase the player
        PlayfieldActor pacman = game.getPacman();
        if (game.getDotsRemaining() < game.getLevels().getElroyDotsLeftPart1()
                && this.mode == GhostMode.SCATTER
                && (!game.isLostLifeOnThisLevel() || game.getClyde().mode != GhostMode.IN_PEN)) {
            this.targetPos = new float[] { pacman.tilePos[0], pacman.tilePos[1] };
        } else if (this.mode == GhostMode.CHASE) {
            this.targetPos = new float[] { pacman.tilePos[0], pacman.tilePos[1] };
        }
    }
    
    @Override
    float getNormalSpeed() {
        return (this.mode == GhostMode.SCATTER
                    || this.mode == GhostMode.CHASE)
                    ? game.getCruiseElroySpeed()
                    : this.fullSpeed;
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
        return 4;
    }
}
