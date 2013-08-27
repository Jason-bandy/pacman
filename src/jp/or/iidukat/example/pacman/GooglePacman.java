package jp.or.iidukat.example.pacman;

import android.app.Activity;
import android.media.AudioManager;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;

public class GooglePacman extends Activity implements OnClickListener {

    private static final String TAG = "GooglePacman";
	private PacmanGame game;
    private GameView gameView;
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        PacmanGame game = initGame();
        initGameView(game);
        initMainView();
        
        setVolumeControlStream(AudioManager.STREAM_MUSIC);
    }

    @Override
    public void onResume() {
        super.onResume();
        game.resume();
    }
    
    @Override
    public void onPause() {
        game.pause();
        super.onPause();
    }
    
    private void initMainView() {
        setContentView(R.layout.main);
        
        View newGameButton = findViewById(R.id.new_game_button);
        newGameButton.setOnClickListener(this);
        View killScreenButton = findViewById(R.id.killscreen_button);
        killScreenButton.setOnClickListener(this);
        View exitButton = findViewById(R.id.exit_button);
        exitButton.setOnClickListener(this);
    }
    
    private void initGameView(PacmanGame game) {
        gameView = new GameView(this);
        game.view = gameView;
        gameView.game = game;
    }
    
    private PacmanGame initGame() {
    	initDisplayParameter();
    	
        game = new PacmanGame(this);
        game.init();
        
        return game;
    }
    
    private void initDisplayParameter() {
    	 DisplayMetrics metric = new DisplayMetrics();
         getWindowManager().getDefaultDisplay().getMetrics(metric);
         int width = metric.widthPixels;  // 屏幕宽度（像素）
         int height = metric.heightPixels;  // 屏幕高度（像素）
         float hDivw = height/width;
         final float density = metric.density;
         final int densitydpi = metric.densityDpi;
         PacmanConfig.sDensity = density;
         final int sw = width;
         int elementWidth;
		if (hDivw > 1.566||true){// 1.667 = 800/480;
        	 
        	 PacmanConfig.sBgPlayWidth = (int) (sw);
        	 PacmanConfig.sBgViewWidth = (int) (PacmanConfig.sBgPlayWidth);

        	elementWidth = (sw-PacmanConfig.sBorderLeft*2)/PacmanConfig.sWidthPE;
        	
        	PacmanConfig.sBgPlayHeight = height;
        	PacmanConfig.sBgViewHeight = elementWidth*PacmanConfig.sHeightPE;
        	 Log.d(TAG, "border width " + (sw-PacmanConfig.sBorderLeft));
        	 Log.d(TAG, "element width " + elementWidth + " densitydpi " + densitydpi);
         } else{
        	 PacmanConfig.sBgPlayHeight = height;
         	PacmanConfig.sBgViewHeight = height;
        	 
        	 elementWidth = (height - PacmanConfig.sToolBarHeight)/PacmanConfig.sHeightPE;
        	 
        	 PacmanConfig.sBgPlayWidth = width;
        	 PacmanConfig.sBgViewWidth = elementWidth*(PacmanConfig.sWidthPE+2);
         }
		float elementWidthByDpF = elementWidth;
		Log.d(TAG, "element width " + elementWidthByDpF );
		PacmanConfig.sStepWidth = (int)elementWidthByDpF;
		PacmanConfig.sStepWidthF = elementWidthByDpF;
	}
    
    private void transitionToGameView() {
        setContentView(gameView);
        gameView.setFocusable(true);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
        case R.id.new_game_button:
            transitionToGameView();
            game.startNewGame();
            break;
        case R.id.killscreen_button:
            transitionToGameView();
            game.showKillScreen();
            break;
        case R.id.exit_button:
            finish();
            break;
        }
        
    }
    
}