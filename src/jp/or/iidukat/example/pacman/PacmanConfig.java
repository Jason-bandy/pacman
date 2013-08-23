package jp.or.iidukat.example.pacman;

import android.graphics.Bitmap;

public class PacmanConfig {
	public static float sDensity = 1.5f; 
	//TODO put the code into main instead of here. 
	public final static int sBgViewWidth = (int) (400/sDensity);//464;
	public final static int sBgViewHeight = (int) (600/sDensity);//168;
	public final static int sBgPlayWidth = (int) (480/sDensity);//464;
	public final static int sBgPlayHeight = (int) (800/sDensity);//136;
	
	public final static int sStepWidth = 13;//(int) (21/sDensity);//TODO density value instead of 1.5f
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
	public static final int sDots_left = 0;//(int) (10/1.5);
	public static final int sDots_top = -10;
	public static Bitmap sDotsBitmap = null;
	
	
	
	
	//布局排版
	int rowsCount = 18;
	int columsCount = 30;
	private int keyHeight = 100;
	private int viewHeight = 742;
	int peSize = (viewHeight - keyHeight)/columsCount;

}
