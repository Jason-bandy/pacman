package jp.or.iidukat.example.pacman;

import android.graphics.Bitmap;
import android.graphics.Rect;

public class PacmanConfig {
	public static float sDensity = 1.5f; 
	//TODO put the code into main instead of here. 
	public static int sBgViewWidth ;//464;
	public static int sBgViewHeight ;//168;
	public static int sBgPlayWidth;//464;
	public static int sBgPlayHeight ;//136;
	
	public static int sStepWidth = 0;//(int) (21/sDensity);//TODO density value instead of 1.5f
	public static final int sBg_res = R.drawable.pacmanentity;
	public static final int sBgTranslateX = 0;//246;
	public static final int sWordHPE = 6;
	public static final int sWordVPE = 9;
	public static final int sLinePE = 2;
	public static final int sPathPE = 2;
	public static final int sWidthPE = 21;
	public static final int sHeightPE = 36;
	
	
	public static final float sPenPosX = 6f;
	public static final float sPenPosY = 13;
	public static int sDots_left = 1;//(int) (10/1.5);
	public static final int sDots_top = 1;
	public static int sToolBarHeight;
	public static int sDotsSize = 0;
	public static int sBorderLeft ;
	public static int sBorderTop ;
	public static Bitmap sDotsBitmap = null;
	public static float sStepWidthF;
	public static float sScaleFactor;
	public static int sDrawTx;
	public static int sDrawTy;
	public static int sActorSize;
	public static int sActorLeftOffset;
	public static int sCanvasTop;
	public static int sCanvasLeft;
	public static float sSpeedFactor = 1.3f;
	public static int sBottomBarHeight;
	public static int sBgBitmapHeight;
	public static int sBgBitmapWidth;
	public static Rect mPlayFiledBgSrc;
	public static Rect mPlayFiledBgDst;
	public static int sOffsetElement = 1;
	public static int sFruit_x = 3;
	public static int sFruit_y = 24;
	public static int sScoreSize = 15;
	
	
	
	
	//布局排版
	int rowsCount = 18;
	int columsCount = 30;
	private int keyHeight = 100;
	private int viewHeight = 742;
	int peSize = (viewHeight - keyHeight)/columsCount;

}
