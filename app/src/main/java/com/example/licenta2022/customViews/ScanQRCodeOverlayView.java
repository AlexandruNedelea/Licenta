package com.example.licenta2022.customViews;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import com.example.licenta2022.helpers.ViewUtils;

public class ScanQRCodeOverlayView extends View {
    private Paint mBackgroundPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private Paint mRoundedRectPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private Paint mStrokePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private int scanAreaSize = 400;
    private RectF scanAreaRect;

    public ScanQRCodeOverlayView(Context context) {
        super(context);
        init();
    }

    public ScanQRCodeOverlayView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ScanQRCodeOverlayView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public ScanQRCodeOverlayView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    public int getScanAreaSize() {
        return scanAreaSize;
    }

    public void setScanAreaSize(int scanAreaSize) {
        this.scanAreaSize = scanAreaSize;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawPaint(mBackgroundPaint);
        float centerX = this.getWidth() / 2f;
        float centerY = this.getHeight() / 2f;
        var scanAreaRect = new RectF(centerX - (scanAreaSize / 2), centerY - (scanAreaSize / 2), centerX + (scanAreaSize / 2), centerY + (scanAreaSize / 2));
        var cornerRadius = ViewUtils.getInstance().convertDpToPixel(40f, getContext());

        canvas.drawRoundRect(scanAreaRect, cornerRadius, cornerRadius, mRoundedRectPaint);
        canvas.drawRoundRect(scanAreaRect, cornerRadius, cornerRadius, mStrokePaint);
    }

    private void init() {
        setLayerType(View.LAYER_TYPE_SOFTWARE, null);

        mRoundedRectPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
        mRoundedRectPaint.setColor(Color.TRANSPARENT);

        mBackgroundPaint.setColor(Color.parseColor("#60000000"));

        mStrokePaint.setStyle(Paint.Style.STROKE);
        mStrokePaint.setColor(Color.WHITE);
        mStrokePaint.setStrokeWidth(ViewUtils.getInstance().convertDpToPixel(2f, getContext()));
        mStrokePaint.setStrokeCap(Paint.Cap.ROUND);
        mStrokePaint.setDither(true);
        mStrokePaint.setAntiAlias(true);
    }
}
