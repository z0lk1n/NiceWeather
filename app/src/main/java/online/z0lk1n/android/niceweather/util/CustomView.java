package online.z0lk1n.android.niceweather.util;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import online.z0lk1n.android.niceweather.R;

public class CustomView extends View {
    private final static String TAG = "CustomView";
    private Paint paint;
    private int radius;
    private int color;
    private boolean pressed = false;
    View.OnClickListener listener;

    public CustomView(Context context) {
        super(context);
        init();
    }

    public CustomView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initAttr(context, attrs);
        init();
    }

    public CustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initAttr(context, attrs);
        init();
    }

    public CustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initAttr(context, attrs);
        init();
    }

    private void initAttr(Context context, AttributeSet attrs){
        TypedArray typedArray = context.obtainStyledAttributes(attrs,
                R.styleable.CustomView, 0, 0);
        setRadius(typedArray.getResourceId(R.styleable.CustomView_cv_Radius,
                100));
        setColor(typedArray.getResourceId(R.styleable.CustomView_cv_Color,
                Color.BLUE));
        typedArray.recycle();
    }

    private void init() {
        paint = new Paint();
        paint.setColor(color);
        paint.setStyle(Paint.Style.FILL);
    }

    public void setRadius(int radius){
        this.radius = radius;
    }

    public void setColor(int color){
        this.color = color;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(radius, radius, radius, paint);
        if(pressed){
            canvas.drawCircle(radius, radius, radius/10, paint);
        }
        else {
            canvas.drawCircle(radius, radius, radius, paint);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event){
        int Action = event.getAction();
        if(Action == MotionEvent.ACTION_DOWN){
            pressed = true;
            invalidate();
            if (listener != null) listener.onClick(this);
        }
        else if(Action == MotionEvent.ACTION_UP){
            pressed = false;
            invalidate();
        }
        return true;
    }

    @Override
    public void setOnClickListener(View.OnClickListener listener){
        this.listener = listener;
    }
}
