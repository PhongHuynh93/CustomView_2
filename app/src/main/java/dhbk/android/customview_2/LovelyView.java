package dhbk.android.customview_2;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by huynhducthanhphong on 3/9/16.
 */
public class LovelyView extends View {
    private int circleCol, labelCol;
    private String circleText;

    // paint for draw a custom view
    private Paint circlePaint;

    public LovelyView(Context context, AttributeSet attrs) {
        super(context, attrs);
        circlePaint = new Paint();
        TypedArray a = context.getTheme().obtainStyledAttributes(attrs, R.styleable.LovelyView, 0, 0);

        try {
            circleText = a.getString(R.styleable.LovelyView_circleLabel);
            circleCol = a.getInteger(R.styleable.LovelyView_circleColor, 0);
            labelCol = a.getInteger(R.styleable.LovelyView_labelColor, 0);
        } finally {
            a.recycle();
        }
    }

    // draw View
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        // lấy 1 nữa space còn trống
        int viewWidthHalf = this.getMeasuredWidth() / 2;
        int viewHeightHalf = this.getMeasuredHeight() / 2;

        // radius
        int radius = 0;
        if (viewWidthHalf > viewHeightHalf) {
            radius = viewHeightHalf - 10;
        } else {
            radius = viewWidthHalf - 10;
        }

        // circle
        circlePaint.setStyle(Paint.Style.FILL);
        circlePaint.setAntiAlias(true);
        circlePaint.setColor(circleCol);

        canvas.drawCircle(viewWidthHalf, viewHeightHalf, radius, circlePaint);

        // text
        circlePaint.setColor(labelCol);
        circlePaint.setTextAlign(Paint.Align.CENTER);
        circlePaint.setTextSize(50);

        canvas.drawText(circleText, viewWidthHalf, viewHeightHalf, circlePaint);
    }

    public String getCircleText() {
        return circleText;
    }

    public int getCircleCol() {
        return circleCol;
    }

    public int getLabelCol() {
        return labelCol;
    }

    public void setCircleCol(int circleCol) {
        this.circleCol = circleCol;
        // redraw the view, call onDraw()
        invalidate();
        requestLayout();
    }

    public void setLabelCol(int labelCol) {
        this.labelCol = labelCol;
        invalidate();
        requestLayout();
    }

    public void setCircleText(String circleText) {
        this.circleText = circleText;
        invalidate();
        requestLayout();
    }
}
