package jp.or.iidukat.example.pacman;

import android.graphics.Bitmap;

public class PacmanConfig {
	public static float sDensity = 1.5f; 
	//TODO put the code into main instead of here. 
	public static int sBgViewWidth = (int) (400/sDensity);//464;
	public static int sBgViewHeight = (int) (600/sDensity);//168;
	public static int sBgPlayWidth = (int) (480/sDensity);//464;
	public static int sBgPlayHeight = (int) (800/sDensity);//136;
	
	public static int sStepWidth = 13;//(int) (21/sDensity);//TODO density value instead of 1.5f
	public static final int sBg_res = R.drawable.pacman_m4399_3;
	public static final int sBgTranslateX = 0;//246;
	public static final int sWordHPE = 6;
	public static final int sWordVPE = 9;
	public static final int sLinePE = 2;
	public static final int sPathPE = 2;
	public static final int sWidthPE = 21;
	public static final int sHeightPE = 36;
	
	
	public static final float sPenPosX = 6f;
	public static final float sPenPosY = 13;
	public static final int sDots_left = 30-5;//(int) (10/1.5);
	public static final int sDots_top = 30;
	public static final int sToolBarHeight = 50;
	public static int sBorderLeft = 30-5;
	public static int sBorderTop = 30-16;
	public static Bitmap sDotsBitmap = null;
	public static float sStepWidthF;
	public static float sScaleFactor;
	public static int sDrawTx;
	public static int sDrawTy;
	
	
	
	
	//布局排版
	int rowsCount = 18;
	int columsCount = 30;
	private int keyHeight = 100;
	private int viewHeight = 742;
	int peSize = (viewHeight - keyHeight)/columsCount;

}
