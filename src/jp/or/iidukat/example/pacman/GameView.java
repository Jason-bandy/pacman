package jp.or.iidukat.example.pacman;

import jp.or.iidukat.example.pacman.entity.PacmanCanvas;
import android.content.Context;
import android.graphics.Canvas;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

public class GameView extends View {

    /*public static final int PacmanConfig.sBgPlayWidth = 401;
    public static final int PacmanConfig.sBgPlayHeight = 622;*/
    
    private static final String TAG = "GameView";
	private int canvasHeight = -1;
    private int canvasWidth = -1;

    PacmanGame game;

    final RefreshHandler redrawHandler = new RefreshHandler();

    class RefreshHandler extends Handler {

        @Override
        public void handleMessage(Message msg) {
            game.tick();
            GameView.this.invalidate();
        }

        public void sleep(long delayMillis) {
            this.removeMessages(0);
            sendMessageDelayed(obtainMessage(0), delayMillis);
        }
    }

    public GameView(Context context) {
        super(context);
    }

    public GameView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    
    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        canvasWidth = w > PacmanConfig.sBgPlayWidth ? w : PacmanConfig.sBgPlayWidth;
        canvasHeight = h > PacmanConfig.sBgPlayHeight ? h : PacmanConfig.sBgPlayHeight;
        PacmanConfig.sCanvasLeft = (canvasWidth - PacmanConfig.sBgPlayWidth) / 2;
        PacmanConfig.sCanvasTop = (canvasHeight - PacmanConfig.sBgPlayHeight) / 2;
        Log.d(TAG, "onsize changed " + w + " h " + h + " left " + PacmanConfig.sCanvasLeft + " top " + PacmanConfig.sCanvasTop);
    }

    @Override
    public void onDraw(Canvas canvas) {
        PacmanCanvas canvasEl = game.getCanvasEl();
        canvasEl.setLeft(PacmanConfig.sCanvasLeft);
        canvasEl.setTop(PacmanConfig.sCanvasTop);
        canvasEl.draw(canvas);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        switch (event.getAction() & MotionEvent.ACTION_MASK) {
        case MotionEvent.ACTION_DOWN:
            game.handleTouchStart(event);
            break;
        case MotionEvent.ACTION_UP:
            game.handleTouchEnd(event);
            break;
        case MotionEvent.ACTION_MOVE:
            game.handleTouchMove(event);
            break;
        }

        return true;
    }
}
