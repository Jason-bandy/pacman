package jp.or.iidukat.example.pacman;

import android.graphics.Bitmap;

public class PacmanConfig {
	public final static int sBgViewWidth = 400;//464;
	public final static int sBgViewHeight = 600;//168;
	public final static int sBgPlayWidth = (int) (480/1.5f);//464;
	public final static int sBgPlayHeight = (int) (800/1.5f);//136;
	
	public final static int sStepWidth = (int) (20/1.5f);//TODO density value instead of 1.5f
	public static final int sBg_res = R.drawable.pacman_m4399_3;
	public static final int sBgTranslateX = 0;//246;
	public static final int sWordHPE = 6;
	public static final int sWordVPE = 10;
	public static final int sLinePE = 2;
	public static final int sPathPE = 2;
	public static final int sWidthPE = 18;
	public static final int sHeightPE = 30;
	
	
	public static final float sPenPosX = 6f;
	public static final float sPenPosY = 13;
	public static final int sDots_left = 2;
	public static final int sDots_top = -10;
	public static final float sDensity = 1f;
	public static Bitmap sDotsBitmap = null;
	
	
	
	
	//布局排版
	int rowsCount = 18;
	int columsCount = 30;
	private int keyHeight = 100;
	private int viewHeight = 742;
	int peSize = (viewHeight - keyHeight)/columsCount;

}
