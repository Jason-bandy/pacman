package jp.or.iidukat.example.pacman.entity;

import jp.or.iidukat.example.pacman.PacmanConfig;
import android.graphics.Bitmap;
import android.graphics.Canvas;

public class Sound extends BaseEntity {

    public Sound(Bitmap sourceImage) {
        super(sourceImage);
    }

    public void init() {
        Appearance a = getAppearance();
        a.setLeft(8*12 + PacmanConfig.sStepWidth*PacmanConfig.sOffsetElement);
        a.setTop(PacmanConfig.sBgPlayHeight-12);
        a.setWidth(12);
        a.setHeight(12);
//        a.prepareBkPos(PacmanConfig.sBorderLeft, PacmanConfig.sBorderTop);
        a.prepareBkPos(216, 105);
    }

    //TODO turn on and turn off change position.
    public void turnOn() {
        getAppearance().changeBkPos(216, 105, false);
    }

    public void turnOff() {
        getAppearance().changeBkPos(236, 105, false);
    }

    @Override
    void doDraw(Canvas canvas) {
        getAppearance().drawBitmap(canvas);
    }
}
