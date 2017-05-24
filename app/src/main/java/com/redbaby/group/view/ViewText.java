package com.redbaby.group.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * date: 2017/5/23.
 * author: 王艺凯 (lenovo )
 * function:
 */

public class ViewText extends TextView {
    public ViewText(Context context) {
        super(context);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public ViewText(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public ViewText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public ViewText(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    private int sroke_width = 1;

    @Override
    protected void onDraw(Canvas canvas) {


        Paint paint = new Paint();
        //  将边框设为红色
        paint.setColor(Color.RED);
        //  画TextView的4个边
        canvas.drawLine(0, 0, this.getWidth() - sroke_width, 0, paint);
        canvas.drawLine(0, 0, 0, this.getHeight() - sroke_width, paint);
        canvas.drawLine(this.getWidth() - sroke_width, 0, this.getWidth() - sroke_width, this.getHeight() - sroke_width, paint);
        canvas.drawLine(0, this.getHeight() - sroke_width, this.getWidth() - sroke_width, this.getHeight() - sroke_width, paint);

        super.onDraw(canvas);
    }
}
