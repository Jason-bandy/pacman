package jp.or.iidukat.example.pacman;

public class PacmanConfig {
	public final static int sBgViewWidth = 400;//464;
	public final static int sBgViewHeight = 600;//168;
	public final static int sBgPlayWidth = 400;//464;
	public final static int sBgPlayHeight = 580;//136;
	
	public final static int sStepWidth = 21;
	public static final int sBg_res = R.drawable.pacman_m4399_2;
	public static final int sBgTranslateX = 256;//246;
	public static final int sWordHPE = 6;
	public static final int sWordVPE = 10;
	public static final int sLinePE = 2;
	public static final int sPathPE = 2;
	public static final int sWidthPE = 18;
	public static final int sHeightPE = 30;
	
	
	public static final float sPenPosX = 5.5f;
	public static final float sPenPosY = 6;
	
	
	
	
	//布局排版
	int rowsCount = 18;
	int columsCount = 30;
	private int keyHeight = 100;
	private int viewHeight = 742;
	int peSize = (viewHeight - keyHeight)/columsCount;

}
