package com.example.game;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class GameMap extends View {

    public int getPosX() {
        return posX();
    }

    private int posX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY() {
        this.posX = posY;
    }

    private int posX = 400;
    private int posY = 400;
    private int bitmap_width;
    private Bitmap bitmap;
    private int bitmap_height;

    public GameMap(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        Paint paint0 = new Paint();
        paint0.setColor(0);
        canvas.drawLine(400, 0, 0, 600, paint);
        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.fish);
        bitmap_width = bitmap.getWidth();
        bitmap_height = bitmap.getHeight();
        canvas.drawBitmap(bitmap, 300, 300, paint);
        for (int i = 0; i < getHeight() - bitmap.getHeight(); i += 50) {
            canvas.drawBitmap(bitmap, 400, 300, paint);
        }
    }

    void moveUp() {
        if (posY > 0) {
            posY -= 50;
        } else
            posY = getHeight()-bitmap_height;
    }
    void moveDown() {
        if (posY < getHeight()-bitmap_height) {
            posY += 50;
        } else
            posY = 0;
    }
    void moveLeft() {
        if (posX > 0) {
            posX -= 50;
        } else
            posX = getWidth() - bitmap_width;
    }
    void moveRight() {
        if (posX < getWidth() - bitmap_width) {
            posX += 50;
        } else
            posX = 0;
    }
}