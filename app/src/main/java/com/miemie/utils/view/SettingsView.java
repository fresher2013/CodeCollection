package com.miemie.utils.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.SweepGradient;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import java.util.Timer;
import java.util.TimerTask;

public class SettingsView extends View {
    public SettingsView(Context context) {
        super(context);
    }

    public SettingsView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public SettingsView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public SettingsView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }
}

//public class SettingsView extends View {
//
//    public final static int MODE_BEAUTY = Constants.CAM_MODE_BEAUTY;
//    public final static int MODE_FILTER = Constants.CAM_MODE_FILTER;
//    public final static int MODE_AUTO_COUNT = 2;
//    public final static int MODE_BRIGHTNESS = Constants.CAM_MODE_BRIGHTNESS;
//    public final static int MODE_CONTRAST = Constants.CAM_MODE_CONTRAST;
//    public final static int MODE_WB = Constants.CAM_MODE_WB;
//    public final static int MODE_SATURATION = Constants.CAM_MODE_SATURATION;
//    public final static int MODE_COUNT = 6;
//    private static final String TAG = SettingsView.class.getSimpleName();
//
//    private static final int TIMEOUT_SETTINGS_VIEW = 10000;
//
//    /* The mode of touch. */
//    private static final int HANDLE_NONE = 0;
//    private static final int HANDLE_DOWN = (1 << 0);
//    private static final int HANDLE_MOVE = (1 << 1);
//    private static final int HANDLE_UP = (1 << 2);
//
//    private final static float MODE_MAX_ICON_ANGLE = -10f;
//    private final static float MODE_MIN_ICON_ANGLE = 100f;
//
//    private final static int WB_MODE_COUNT = Constants.CAM_WB_MODE_COUNT;
//
//    private final static int BEAUTY_MODE_COUNT = Constants.CAM_BEAUTY_MODE_COUNT;
//    private final static float MODE_SEEKBAR_START_ANGLE = MODE_MAX_ICON_ANGLE + 5;
//    private final static float MODE_SEEKBAR_END_ANGLE = MODE_MIN_ICON_ANGLE - 5;
//    private final static float FILTER_ITEM_BIG_ANGLE = 30;
//    private final static float FILTER_ITEM_ANGLE = 20;
//    private final static float FILTER_ITEM_ANGLE_GAP = 4;
//    private final static float BEAUTY_MODE_START_ANGLE = -105;
//    private final static float BEAUTY_MODE_ITEM_ANGLE = 28;
//    private final static float BEAUTY_MODE_ITEM_ANGLE_GAP = 3;
//    private final static float WB_MODE_START_ANGLE = -105;
//    private final static float WB_MODE_ITEM_ANGLE = 24;
//    private final static float WB_MODE_ITEM_ANGLE_GAP = 4;
//    private final AngleRange[] mBeautyModeAngleRanges = new AngleRange[]{
//            new AngleRange(89, BEAUTY_MODE_ITEM_ANGLE),
//            new AngleRange(120, BEAUTY_MODE_ITEM_ANGLE),
//            new AngleRange(151, BEAUTY_MODE_ITEM_ANGLE),
//            new AngleRange(182, BEAUTY_MODE_ITEM_ANGLE)
//    };
//    private final AngleRange[] mWBModeAngleRanges = new AngleRange[]{
//            new AngleRange(89, WB_MODE_ITEM_ANGLE),
//            new AngleRange(117, WB_MODE_ITEM_ANGLE),
//            new AngleRange(145, WB_MODE_ITEM_ANGLE),
//            new AngleRange(173, WB_MODE_ITEM_ANGLE),
//    };
//    private final AngleRange[] mFilterModeAngleRanges = new AngleRange[]{
//            new AngleRange(119, FILTER_ITEM_ANGLE),
//            new AngleRange(143, FILTER_ITEM_ANGLE),
//            new AngleRange(167, FILTER_ITEM_ANGLE),
//            new AngleRange(191, FILTER_ITEM_ANGLE),
//    };
//    private final AngleRange[] mModeAngleRanges = new AngleRange[]{
//            new AngleRange(90, 40),
//            new AngleRange(150, 40),
//            new AngleRange(210, 40),
//            new AngleRange(270, 40),
//            new AngleRange(330, 40),
//            new AngleRange(30, 40)
//    };
//    private final AngleRange[] mAutoModeAngleRanges = new AngleRange[]{
//            new AngleRange(30, 40),
//            new AngleRange(90, 40),
//            new AngleRange(150, 40),
//    };
//    private int mFilterModeCount;
//    private float mCircle1Radius;
//    private float mCircle2Radius;
//    private float mCircle3Radius;
//    private float mCircle4Radius;
//    private float mCircle5Radius;
//    private float mHalfWidth;
//    private float mHalfHeight;
//    private float mRingWidth;
//    private float mPoint1Radius;
//    private float mPoint2Radius;
//    private int mCircle1Color;
//    private int mCircle2Color;
//    private int mCircle3Color;
//    private Paint mCircle1Paint;
//    private Paint mCircle2Paint;
//    private Paint mCircle3Paint;
//    private Paint mPointPaint;
//    private Paint mTextPaint;
//    private Paint mDarkTextPaint;
//    private Paint mSelectedTextPaint;
//    private Drawable mModeDrawable;
//    private Drawable[] mModeDrawables;
//    private Drawable[] mSelectedModeDrawables;
//    private Drawable[] mModeBrightnessDrawables;
//    private Drawable[] mModeContrastDrawables;
//    private Drawable[] mModeWBDrawables;
//    private Drawable[] mModeFilterDrawables;
//    private Point[] mModeBeautyPoints;
//    private String[] mModeBeautyTexts;
//    private Rect[] mModeTextRects;
//    private String[] mModeTexts;
//    private float mDensity;
//    // for filter circle
//    private float mFilterDownAngle = 0;
//    private float mFilterOffsetAngle = 0;
//    private float mFilterTargetAngle = 0;
//    // for mode circle
//    private float mModeDownAngle = 0;
//    private float mModeOffsetAngle = 0;
//    private float mModeTargetAngle = 0;
//    private int mMode;
//    private int mModeIndex;
//    private int mNextModeIndex;
//
//    private float mLastDownX;
//    private float mLastDownY;
//    private long mLastDownTime;
//    private Timer mTimer;
//    private UpdateTimerTask mTask;
//    // The Handle mode.
//    private int mHandleMode;
//    private int mFilterIndex;
//    private int mNextFilterIndex;
//    private int mRingColors[] = new int[3];
//    private int mSaturationRingColors[] = new int[3];
//    private int mArcColors[] = new int[2];
//    private int mFocusArcColors[] = new int[2];
//    private int mGapArcColors[] = new int[2];
//
//    private int mBrightnessValue;
//    private int mContrastValue;
//    private int mSaturationValue;
//    private int mBeautyModeIndex;
//    private int mWBModeIndex;
//    private int mFilterModeIndex;
//    private OnChangeListener mOnChangeListener;
//    private MagicFilterType[] mFilterTypes;
//    private Handler mHandler = new Handler();
//    private Runnable mHideRunnable = new Runnable() {
//        @Override
//        public void run() {
//            setVisibility(View.GONE);
//        }
//    };
//    private Handler mCircle2UpdateHandler = new Handler() {
//        @Override
//        public void handleMessage(Message msg) {
//            int step = msg.arg1;
//            if (mModeTargetAngle != mModeOffsetAngle) {
//                if (mModeOffsetAngle > mModeTargetAngle) {
//                    mModeOffsetAngle -= step;
//                    if (mModeOffsetAngle < mModeTargetAngle) {
//                        mModeOffsetAngle = mModeTargetAngle;
//                    }
//                } else if (mModeOffsetAngle < mModeTargetAngle) {
//                    mModeOffsetAngle += step;
//                    if (mModeOffsetAngle > mModeTargetAngle) {
//                        mModeOffsetAngle = mModeTargetAngle;
//                    }
//                }
//                Log.d(TAG, "mCircle2UpdateHandler mModeOffsetAngle " + mModeOffsetAngle + " mModeTargetAngle " + mModeTargetAngle);
//                invalidate();
//            } else {
//                cancelTask();
//                setHandleMode(HANDLE_NONE);
//                mModeIndex = mNextModeIndex;
//                invalidate();
//            }
//        }
//    };
//    private Handler mCircle3UpdateHandler = new Handler() {
//        @Override
//        public void handleMessage(Message msg) {
//            int step = msg.arg1;
//            if (mFilterTargetAngle != mFilterOffsetAngle) {
//                if (mFilterOffsetAngle > mFilterTargetAngle) {
//                    mFilterOffsetAngle -= step;
//                    if (mFilterOffsetAngle < mFilterTargetAngle) {
//                        mFilterOffsetAngle = mFilterTargetAngle;
//                    }
//                } else if (mFilterOffsetAngle < mFilterTargetAngle) {
//                    mFilterOffsetAngle += step;
//                    if (mFilterOffsetAngle > mFilterTargetAngle) {
//                        mFilterOffsetAngle = mFilterTargetAngle;
//                    }
//                }
//                invalidate();
//            } else {
//                mFilterIndex = mNextFilterIndex;
//                mFilterOffsetAngle = 0;
//                mFilterTargetAngle = 0;
//                cancelTask();
//                invalidate();
//            }
//        }
//    };
//
//    public SettingsView(Context context) {
//        super(context);
//        init(null, 0);
//    }
//
//    private void init(AttributeSet attrs, int defStyle) {
//        mTimer = new Timer();
//        Resources res = getResources();
//        mDensity = res.getDisplayMetrics().density;
//        mCircle1Radius = dpToPx(mDensity, 46);
//        mCircle2Radius = dpToPx(mDensity, 110);
//        mCircle3Radius = dpToPx(mDensity, 154);
//        mCircle4Radius = dpToPx(mDensity, 156);
//        mCircle5Radius = dpToPx(mDensity, 172);
//        mRingWidth = dpToPx(mDensity, 4);
//        mPoint1Radius = dpToPx(mDensity, 10);
//        mPoint2Radius = dpToPx(mDensity, 8);
//
//        mCircle1Color = Color.parseColor("#80C5FF");
//        mCircle2Color = Color.parseColor("#008AFF");
//        mCircle3Color = Color.parseColor("#B2008AFF");
//
//        mRingColors[0] = Color.parseColor("#f5f5f5");
//        mRingColors[1] = Color.parseColor("#0d0d0d");
//        mRingColors[2] = Color.parseColor("#f5f5f5");
//
//        mSaturationRingColors[0] = Color.parseColor("#f93400");
//        mSaturationRingColors[1] = Color.parseColor("#070100");
//        mSaturationRingColors[2] = Color.parseColor("#f93400");
//
//        mArcColors[0] = Color.parseColor("#95cdfd");
//        mArcColors[1] = Color.parseColor("#95cdfd");
//
//        mFocusArcColors[0] = Color.parseColor("#ffffff");
//        mFocusArcColors[1] = Color.parseColor("#ffffff");
//
//        mGapArcColors[0] = mCircle3Color;
//        mGapArcColors[1] = mCircle3Color;
//
//        initPaint();
//        initDrawables(res);
//        invalidateTextPaintAndMeasurements(res);
//    }
//
//    private int dpToPx(float density, float dp) {
//        return Math.round(dp * density);
//    }
//
//    private void initPaint() {
//        Paint paint = new Paint();
//        paint.setAntiAlias(true);
//        paint.setFlags(Paint.ANTI_ALIAS_FLAG);
//
//        mCircle1Paint = new Paint(paint);
//        mCircle1Paint.setColor(mCircle1Color);
//
//        mCircle2Paint = new Paint(paint);
//        mCircle2Paint.setColor(mCircle2Color);
//
//        mCircle3Paint = new Paint(paint);
//        mCircle3Paint.setColor(mCircle3Color);
//
//        mPointPaint = new Paint(paint);
//        mPointPaint.setColor(Color.parseColor("#FFFFFF"));
//
//        mTextPaint = new Paint(paint);
//        mTextPaint.setTextAlign(Paint.Align.LEFT);
//        mTextPaint.setColor(Color.parseColor("#FFFFFF"));
//        mTextPaint.setStrokeWidth(2);
//        mTextPaint.setTextSize(Utils.spToPx(14));
//
//        mSelectedTextPaint = new TextPaint(mTextPaint);
//        mSelectedTextPaint.setColor(Color.parseColor("#ff3600"));
//
//        mDarkTextPaint = new Paint(paint);
//        mDarkTextPaint.setTextAlign(Paint.Align.LEFT);
//        mDarkTextPaint.setColor(Color.parseColor("#000000"));
//        mDarkTextPaint.setStrokeWidth(4);
//        mDarkTextPaint.setTextSize(Utils.spToPx(36));
//    }
//
//    private void initDrawables(Resources res) {
//        mModeDrawable = res.getDrawable(R.drawable.ic_cam_settings_mode);
//        mModeDrawables = new Drawable[MODE_COUNT];
//        mModeDrawables[MODE_BEAUTY] = res.getDrawable(R.drawable.ic_cam_settings_mode_beauty);
//        mModeDrawables[MODE_FILTER] = res.getDrawable(R.drawable.ic_cam_settings_mode_filter);
//        mModeDrawables[MODE_CONTRAST] = res.getDrawable(R.drawable.ic_cam_settings_mode_contrast);
//        mModeDrawables[MODE_BRIGHTNESS] = res.getDrawable(R.drawable.ic_cam_settings_mode_brightness);
//        mModeDrawables[MODE_SATURATION] = res.getDrawable(R.drawable.ic_cam_settings_mode_saturation);
//        mModeDrawables[MODE_WB] = res.getDrawable(R.drawable.ic_cam_settings_mode_wb);
//
//        mSelectedModeDrawables = new Drawable[MODE_COUNT];
//        mSelectedModeDrawables[MODE_BEAUTY] = res.getDrawable(R.drawable.ic_cam_settings_mode_beauty);
//        mSelectedModeDrawables[MODE_FILTER] = res.getDrawable(R.drawable.ic_cam_settings_mode_filter);
//        mSelectedModeDrawables[MODE_CONTRAST] = res.getDrawable(R.drawable.ic_cam_settings_mode_contrast);
//        mSelectedModeDrawables[MODE_BRIGHTNESS] = res.getDrawable(R.drawable.ic_cam_settings_mode_brightness);
//        mSelectedModeDrawables[MODE_SATURATION] = res.getDrawable(R.drawable.ic_cam_settings_mode_saturation);
//        mSelectedModeDrawables[MODE_WB] = res.getDrawable(R.drawable.ic_cam_settings_mode_wb);
//
//        mModeBrightnessDrawables = new Drawable[2];
//        mModeBrightnessDrawables[0] = res.getDrawable(R.drawable.ic_cam_settings_mode_brightness_max);
//        mModeBrightnessDrawables[1] = res.getDrawable(R.drawable.ic_cam_settings_mode_brightness_min);
//
//        mModeContrastDrawables = new Drawable[2];
//        mModeContrastDrawables[0] = res.getDrawable(R.drawable.ic_cam_settings_mode_contrast_max);
//        mModeContrastDrawables[1] = res.getDrawable(R.drawable.ic_cam_settings_mode_contrast_min);
//
//        mModeWBDrawables = new Drawable[WB_MODE_COUNT];
//        mModeWBDrawables[0] = res.getDrawable(R.drawable.ic_cam_settings_mode_wb_auto);
//        mModeWBDrawables[1] = res.getDrawable(R.drawable.ic_cam_settings_mode_wb_indoor);
//        mModeWBDrawables[2] = res.getDrawable(R.drawable.ic_cam_settings_mode_wb_fluorescent);
//        mModeWBDrawables[3] = res.getDrawable(R.drawable.ic_cam_settings_mode_wb_sun);
//        mModeWBDrawables[4] = res.getDrawable(R.drawable.ic_cam_settings_mode_wb_overcast);
//    }
//
//    private void invalidateTextPaintAndMeasurements(Resources res) {
//        Paint.FontMetrics fontMetrics = mTextPaint.getFontMetrics();
//        mModeBeautyPoints = new Point[4];
//        mModeBeautyTexts = new String[4];
//        mModeBeautyTexts[0] = res.getText(R.string.mode_beauty_disable).toString();
//        mModeBeautyTexts[1] = res.getText(R.string.mode_beauty_low).toString();
//        mModeBeautyTexts[2] = res.getText(R.string.mode_beauty_medium).toString();
//        mModeBeautyTexts[3] = res.getText(R.string.mode_beauty_high).toString();
//
//        float h = fontMetrics.bottom;
//        for (int i = 0; i < mModeBeautyPoints.length; i++) {
//            float w = mTextPaint.measureText(mModeBeautyTexts[i]);
//            mModeBeautyPoints[i] = new Point((int) w, (int) h);
//        }
//
//
//        mModeTextRects = new Rect[2];
//        mModeTexts = new String[2];
//        mModeTexts[0] = res.getText(R.string.mode_auto).toString();
//        mModeTexts[1] = res.getText(R.string.mode_manual).toString();
//
//        for (int i = 0; i < mModeTextRects.length; i++) {
//            Rect bounds = new Rect();
//            mDarkTextPaint.getTextBounds(mModeTexts[i], 0, mModeTexts[i].length(), bounds);
//            mModeTextRects[i] = bounds;
//        }
//    }
//
//    public SettingsView(Context context, AttributeSet attrs) {
//        super(context, attrs);
//        init(attrs, 0);
//    }
//
//    public SettingsView(Context context, AttributeSet attrs, int defStyle) {
//        super(context, attrs, defStyle);
//        init(attrs, defStyle);
//    }
//
//    public void setFilterTypes(MagicFilterType[] mFilterTypes) {
//        this.mFilterTypes = mFilterTypes;
//        mFilterModeCount = mFilterTypes.length;
//        mModeFilterDrawables = new Drawable[mFilterModeCount];
//
//        Resources res = getResources();
//        for (int i = 0; i < mModeFilterDrawables.length; i++) {
//            mModeFilterDrawables[i] = res.getDrawable(FilterTypeHelper.FilterType2Thumb(mFilterTypes[i]));
//        }
//    }
//
//    public void initValue(int mode, int beauty, int filter, int wb, int contrast, int brightness, int saturation) {
//        this.mMode = mode;
//        this.mBeautyModeIndex = beauty;
//        this.mFilterModeIndex = filter;
//        this.mWBModeIndex = wb;
//        this.mContrastValue = contrast;
//        this.mSaturationValue = saturation;
//        this.mBrightnessValue = brightness;
//    }
//
//    private void setModeValue(int mode, int value) {
//        switch (mode) {
//            case MODE_BEAUTY:
//                mBeautyModeIndex = value;
//                break;
//            case MODE_FILTER:
//                mFilterModeIndex = value;
//                break;
//            case MODE_CONTRAST:
//                mContrastValue = value;
//                break;
//            case MODE_WB:
//                mWBModeIndex = value;
//                break;
//            case MODE_SATURATION:
//                mSaturationValue = value;
//                break;
//            case MODE_BRIGHTNESS:
//                mBrightnessValue = value;
//                break;
//            default:
//                return;
//        }
//        if (mOnChangeListener != null) {
//            mOnChangeListener.onModeValueChange(mode, value);
//        }
//        invalidate();
//    }
//
//    public void setOnChangeListener(OnChangeListener listener) {
//        this.mOnChangeListener = listener;
//    }
//
//    @Override
//    public void setVisibility(int visibility) {
//        int old = getVisibility();
//        super.setVisibility(visibility);
//        if (old == visibility) {
//            return;
//        }
//
//        if (visibility == View.GONE) {
//            mHandler.removeCallbacks(mHideRunnable);
//        } else {
//            kickDog();
//        }
//        if (mOnChangeListener != null) {
//            mOnChangeListener.onViewVisibilityChange(visibility);
//        }
//    }
//
//    private void kickDog() {
//        mHandler.removeCallbacks(mHideRunnable);
//        mHandler.postDelayed(mHideRunnable, TIMEOUT_SETTINGS_VIEW);
//    }
//
//    @Override
//    public boolean onTouchEvent(MotionEvent event) {
//        if (false) {
//            float x = event.getX();
//            float y = event.getY();
//            float distance = getDistanceToCenter(x, y);
//            float angle = getAngle(x, y);
//            Log.d(TAG, "onTouchEvent angle:" + angle + " distance:" + distance);
//            return true;
//        }
//
//        kickDog();
//
//        switch (event.getAction()) {
//            case MotionEvent.ACTION_UP: {
//                long time = SystemClock.elapsedRealtime() - mLastDownTime;
//                Log.d(TAG, "onTouchEvent ACTION_UP time " + time);
//                if (time < 150) {
//                    onClick(event);
//                    return true;
//                }
//                return onTouchEventInternal(event);
//            }
//            case MotionEvent.ACTION_DOWN: {
//                mLastDownX = event.getX();
//                mLastDownY = event.getY();
//                mLastDownTime = SystemClock.elapsedRealtime();
//                return onTouchEventInternal(event);
//            }
//            case MotionEvent.ACTION_MOVE: {
//                return onTouchEventInternal(event);
//            }
//        }
//        return super.onTouchEvent(event);
//    }
//
//    @Override
//    protected void onDraw(Canvas canvas) {
//        super.onDraw(canvas);
//        mHalfHeight = getHeight() / 2;
//        mHalfWidth = getWidth() / 2;
//        canvas.drawARGB(0, 0, 0, 0);
//        drawCircle3(canvas);
//        drawSettingModeView(canvas);
//        drawCircle2(canvas);
//        drawCircle2ModeIcon(canvas);
//        drawCircle1(canvas);
//    }
//
//    private float getSeekbarAngle(float angle) {
//        if (angle > MODE_SEEKBAR_END_ANGLE) {
//            return MODE_SEEKBAR_END_ANGLE;
//        } else if (angle < MODE_SEEKBAR_START_ANGLE) {
//            return MODE_SEEKBAR_START_ANGLE;
//        }
//        return angle;
//    }
//
//    private void drawRing(Canvas canvas, float radius, float width, int[] colors) {
//        drawArc(canvas, radius, width, colors, 0, 360, -100);
//    }
//
//    private void drawArc(Canvas canvas, float radius, float width, int[] colors, float startAngle, float endAngle, float rotate) {
//        drawArc(canvas, radius, width, colors, startAngle, endAngle, rotate, false);
//    }
//
//    private void drawArc(Canvas canvas, float radius, float width, int[] colors, float startAngle, float endAngle, float rotate, boolean srcIn) {
//        Paint ringColorPaint = new Paint();
//        ringColorPaint.setStyle(Paint.Style.STROKE);
//        ringColorPaint.setStrokeWidth(width);
//        ringColorPaint.setAntiAlias(true);
//        ringColorPaint.setShader(new SweepGradient(0, 0, colors, null));
//        canvas.save();
//        canvas.translate(mHalfWidth, mHalfHeight);
//        canvas.rotate(rotate);
//        RectF rectF = new RectF(-radius, -radius, radius, radius);
//        if (srcIn) {
//            Paint p = new Paint();
//            p.setColor(Color.TRANSPARENT);
//            p.setStyle(Paint.Style.STROKE);
//            p.setStrokeWidth(width);
//            p.setAntiAlias(true);
//            p.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
//            canvas.drawArc(rectF, startAngle, endAngle, false, p);
//        }
//        canvas.drawArc(rectF, startAngle, endAngle, false, ringColorPaint);
//        canvas.restore();
//    }
//
//    private void drawBrightnessModeView(Canvas canvas) {
//        drawRing(canvas, mCircle4Radius, mRingWidth, mRingColors);
//        drawPointer(canvas, mCircle4Radius, mPoint1Radius, mPoint2Radius, getSeekBarModeAngle(mModeIndex));
//        canvas.save();
//        canvas.translate(mHalfWidth, mHalfHeight);
//        Drawable icon = mModeBrightnessDrawables[1];
//        float r = (mCircle3Radius + mCircle2Radius) / 2;
//        float x0 = (float) (r * Math.sin(MODE_MIN_ICON_ANGLE * Math.PI / 180));
//        float y0 = -(float) (r * Math.cos(MODE_MIN_ICON_ANGLE * Math.PI / 180));
//        drawDrawableAtPosition(canvas, icon, x0, y0, 1);
//        canvas.rotate(MODE_MAX_ICON_ANGLE);
//        float areaHeight = (mCircle3Radius - mCircle2Radius) * .5f;
//        icon = mModeBrightnessDrawables[0];
//        drawDrawableAtPosition(canvas, icon, 0, -(mCircle3Radius + mCircle2Radius) / 2, (areaHeight / icon.getMinimumHeight()));
//        canvas.restore();
//    }
//
//    private void drawContrastModeView(Canvas canvas) {
//        drawRing(canvas, mCircle4Radius, mRingWidth, mRingColors);
//        drawPointer(canvas, mCircle4Radius, mPoint1Radius, mPoint2Radius, getSeekBarModeAngle(mModeIndex));
//
//        canvas.save();
//        canvas.translate(mHalfWidth, mHalfHeight);
//        Drawable icon = mModeContrastDrawables[1];
//        float r = (mCircle3Radius + mCircle2Radius) / 2;
//        float x0 = (float) (r * Math.sin(MODE_MIN_ICON_ANGLE * Math.PI / 180));
//        float y0 = -(float) (r * Math.cos(MODE_MIN_ICON_ANGLE * Math.PI / 180));
//        drawDrawableAtPosition(canvas, icon, x0, y0, 1);
//        canvas.rotate(MODE_MAX_ICON_ANGLE);
//        icon = mModeContrastDrawables[0];
//        drawDrawableAtPosition(canvas, icon, 0, -(mCircle3Radius + mCircle2Radius) / 2, 1);
//        canvas.restore();
//    }
//
//    private void drawSaturationModeView(Canvas canvas) {
//        drawRing(canvas, mCircle4Radius, mRingWidth, mSaturationRingColors);
//        drawPointer(canvas, mCircle4Radius, mPoint1Radius, mPoint2Radius, getSeekBarModeAngle(mModeIndex));
//    }
//
//    private void drawFilterModeView(Canvas canvas) {
//        if (mFilterModeCount <= 0) {
//            return;
//        }
//
//        float bigAngle = FILTER_ITEM_BIG_ANGLE;
//        float smallAngle = FILTER_ITEM_ANGLE;
//        float angleGap = FILTER_ITEM_ANGLE_GAP;
//        int index = mFilterIndex;
//        int count = Math.min(8, mFilterModeCount);
//        float base = bigAngle - (smallAngle + angleGap) + (mFilterOffsetAngle % (smallAngle + angleGap));
//        int offset = (int) (mFilterOffsetAngle / (smallAngle + angleGap));
//        index -= offset;
//        Log.d(TAG, "drawFilterModeView " + mFilterOffsetAngle + " index " + index + " offset " + offset);
//        for (int i = 0; i < count; i++) {
//            int pos = index + i;
//            if (pos < 0) {
//                pos += mModeFilterDrawables.length;
//            } else if (pos >= mModeFilterDrawables.length) {
//                pos -= mModeFilterDrawables.length;
//            }
//            if (i == 0)
//                Log.d(TAG, "drawFilterModeView  pos " + pos);
//            Drawable drawable = mModeFilterDrawables[pos];
//            drawArcPicture(canvas, drawable, mCircle4Radius, mCircle2Radius + 10, smallAngle, base + (smallAngle + angleGap) * i);
//        }
//        drawArc(canvas, (mCircle4Radius + mCircle2Radius) / 2, (mCircle4Radius - mCircle2Radius), mGapArcColors,
//                0, (bigAngle + smallAngle + angleGap) + 1, -90 - (bigAngle / 2 + smallAngle), true);
//        drawArcPicture(canvas, mModeFilterDrawables[mFilterModeIndex], mCircle5Radius, mCircle2Radius + 10, bigAngle, 0);
//    }
//
//    private void drawArcPicture(Canvas canvas, Drawable drawable, float r1, float r2,
//                                float angel, float rotate) {
//        float o_x = (float) (mCircle5Radius * Math.sin(angel / 2 / 180 * Math.PI));
//        float o_y = r1;
//        canvas.save();
//        canvas.translate(mHalfWidth, mHalfHeight);
//        canvas.rotate(rotate);
//        canvas.translate(-o_x, -o_y);
//        float startAngel = -90 - angel / 2;
//        float endAngel = -90 + angel / 2;
//
//        RectF rect1 = new RectF(o_x - r1, o_y - r1, o_x + r1, o_y + r1);
//        RectF rect2 = new RectF(o_x - r2, o_y - r2, o_x + r2, o_y + r2);
//
//        float x0 = (float) (o_x + r2 * Math.cos(startAngel * Math.PI / 180));
//        float y0 = (float) (o_y + r2 * Math.sin(startAngel * Math.PI / 180));
//
//        float x1 = (float) (o_x + r1 * Math.cos(startAngel * Math.PI / 180));
//        float y1 = (float) (o_y + r1 * Math.sin(startAngel * Math.PI / 180));
//        float x2 = (float) (o_x + r1 * Math.cos(endAngel * Math.PI / 180));
//        float y2 = (float) (o_y + r1 * Math.sin(endAngel * Math.PI / 180));
//        float x3 = (float) (o_x + r2 * Math.cos(endAngel * Math.PI / 180));
//        float y3 = (float) (o_y + r2 * Math.sin(endAngel * Math.PI / 180));
//
//        Path path = new Path();
//        path.moveTo(x0, y0);
//        path.addArc(rect2, startAngel, endAngel - startAngel);
//        path.lineTo(x2, y2);
//        path.addArc(rect1, startAngel, endAngel - startAngel);
//        path.lineTo(x0, y0);
//        canvas.clipPath(path);
//
//        drawable.setBounds((int) x1, 0, (int) x2, (int) y3);
//        drawable.draw(canvas);
//        canvas.restore();
//    }
//
//    private void drawBeautyModeView(Canvas canvas) {
//        float startAngle = BEAUTY_MODE_START_ANGLE;
//        float angle = BEAUTY_MODE_ITEM_ANGLE;
//        float angleGap = BEAUTY_MODE_ITEM_ANGLE_GAP;
//        int count = BEAUTY_MODE_COUNT;
//        for (int i = 0; i < count; i++) {
//            if (mBeautyModeIndex == i)
//                drawArc(canvas, mCircle4Radius, mRingWidth, mFocusArcColors, 0, angle, startAngle + (angle + angleGap) * i);
//            else
//                drawArc(canvas, mCircle4Radius, mRingWidth, mArcColors, 0, angle, startAngle + (angle + angleGap) * i);
//        }
//
//        float total = (angle + angleGap) * count;
//        drawArc(canvas, mCircle4Radius, mRingWidth, mArcColors, 0, (360 - total - angleGap), startAngle + total);
//
//        canvas.save();
//        canvas.translate(mHalfWidth, mHalfHeight);
//        canvas.rotate(startAngle + 90 + angle / 2);
//        for (int i = 0; i < mModeBeautyTexts.length; i++) {
//            String text = mModeBeautyTexts[i];
//            float w = mModeBeautyPoints[i].x;
//            float h = mModeBeautyPoints[i].y;
//            if (i == mBeautyModeIndex)
//                canvas.drawText(text, -w / 2, -(mCircle3Radius + mCircle2Radius - h) / 2, mSelectedTextPaint);
//            else
//                canvas.drawText(text, -w / 2, -(mCircle3Radius + mCircle2Radius - h) / 2, mTextPaint);
//            canvas.rotate(angle + angleGap);
//        }
//        canvas.restore();
//    }
//
//    private void drawWBModeView(Canvas canvas) {
//        float startAngle = WB_MODE_START_ANGLE;
//        float angle = WB_MODE_ITEM_ANGLE;
//        float angleGap = WB_MODE_ITEM_ANGLE_GAP;
//        int count = WB_MODE_COUNT;
//        for (int i = 0; i < count; i++) {
//            if (mWBModeIndex == i)
//                drawArc(canvas, mCircle4Radius, mRingWidth, mFocusArcColors, 0, angle, startAngle + (angle + angleGap) * i);
//            else
//                drawArc(canvas, mCircle4Radius, mRingWidth, mArcColors, 0, angle, startAngle + (angle + angleGap) * i);
//        }
//
//        float total = (angle + angleGap) * count;
//        drawArc(canvas, mCircle4Radius, mRingWidth, mArcColors, 0, (360 - total - angleGap), startAngle + total);
//
//        canvas.save();
//        canvas.translate(mHalfWidth, mHalfHeight);
//        canvas.rotate(startAngle + 90 + angle / 2);
//        float areaHeight = (mCircle3Radius - mCircle2Radius) * .5f;
//        for (int i = 0; i < mModeWBDrawables.length; i++) {
//            Drawable drawable = mModeWBDrawables[i];
//            drawDrawableAtPosition(canvas, drawable, 0, -(mCircle3Radius + mCircle2Radius) / 2, (areaHeight / drawable.getMinimumHeight()));
//            canvas.rotate(angle + angleGap);
//        }
//        canvas.restore();
//    }
//
//    private void drawPointer(Canvas canvas, float radius, float pointR1, float pointR2, float rotate) {
//        canvas.save();
//        canvas.translate(mHalfWidth, mHalfHeight);
//        canvas.rotate(rotate);
//        mPointPaint.setAlpha(100);
//        canvas.drawCircle(0, -radius, pointR1, mPointPaint);
//        mPointPaint.setAlpha(200);
//        canvas.drawCircle(0, -radius, pointR2, mPointPaint);
//        canvas.restore();
//    }
//
//    private void drawSettingModeView(Canvas canvas) {
//        switch (mModeIndex) {
//            case MODE_BEAUTY:
//                drawBeautyModeView(canvas);
//                break;
//            case MODE_FILTER:
//                drawFilterModeView(canvas);
//                break;
//            case MODE_BRIGHTNESS:
//                drawBrightnessModeView(canvas);
//                break;
//            case MODE_CONTRAST:
//                drawContrastModeView(canvas);
//                break;
//            case MODE_WB:
//                drawWBModeView(canvas);
//                break;
//            case MODE_SATURATION:
//                drawSaturationModeView(canvas);
//                break;
//        }
//    }
//
//    private void drawCircle2ModeIcon(Canvas canvas) {
//        canvas.save();
//        canvas.translate(mHalfWidth, mHalfHeight);
//        int base = -mModeIndex * 60;
//        if (mHandleMode != HANDLE_NONE)
//            canvas.rotate(base + mModeOffsetAngle);
//        else
//            canvas.rotate(base);
//        float areaHeight = (mCircle2Radius - mCircle1Radius);
//        areaHeight = areaHeight / 2;
//        int len = (mMode == Constants.CAM_MODE_AUTO) ? MODE_AUTO_COUNT : mModeDrawables.length;
//        for (int i = 0; i < len; i++) {
//            Drawable drawable = mModeDrawables[i];
//            if (i == mModeIndex && mHandleMode == HANDLE_NONE) {
//                drawable = mSelectedModeDrawables[i];
//            }
//            canvas.save();
//            canvas.rotate(i * 60);
//            drawDrawableAtPosition(canvas, drawable, 0, -(mCircle2Radius + mCircle1Radius) * .55f, (areaHeight / drawable.getMinimumHeight()));
//            canvas.restore();
//        }
//        canvas.restore();
//    }
//
//    private void drawDrawableAtPosition(Canvas canvas, Drawable drawable, float centerX, float centerY, float scale) {
//        float w = drawable.getMinimumWidth() * scale;
//        float h = drawable.getMinimumHeight() * scale;
//        drawable.setBounds((int) (centerX - w / 2), (int) (centerY - h / 2), (int) (centerX + w / 2), (int) (centerY + h / 2));
//        drawable.draw(canvas);
//    }
//
//    private void drawCircle1(Canvas canvas) {
//        canvas.save();
//        canvas.translate(mHalfWidth, mHalfHeight);
//        canvas.drawCircle(0, 0, mCircle1Radius, mCircle1Paint);
//        drawDrawableAtPosition(canvas, mModeDrawable, 0, 0, 1);
//
//        int index = mMode;
//        Rect rect = mModeTextRects[index];
//
//        float x = -rect.width() / 2 - rect.left;
//        float y = rect.height() / 2;
//
//        canvas.drawText(mModeTexts[index], x, y, mDarkTextPaint);
//        canvas.restore();
//    }
//
//    private void drawCircle2(Canvas canvas) {
//        canvas.save();
//        canvas.translate(mHalfWidth, mHalfHeight);
//        canvas.drawCircle(0, 0, mCircle2Radius, mCircle2Paint);
//        canvas.restore();
//    }
//
//    private void drawCircle3(Canvas canvas) {
//        canvas.save();
//        canvas.translate(mHalfWidth, mHalfHeight);
//        canvas.drawCircle(0, 0, mCircle3Radius, mCircle3Paint);
//        canvas.restore();
//    }
//
//    private void doCircle2Up() {
//        cancelTask();
//
//        float total = Math.abs(mModeTargetAngle - mModeOffsetAngle);
//        final int frameCount = 20;
//        final int timeInMs = 300;
//
//        mTask = new UpdateTimerTask(mCircle2UpdateHandler, (total / frameCount + 1));
//        mTimer.schedule(mTask, 0, (timeInMs / frameCount));
//    }
//
//    private void doCircle3Up() {
//        cancelTask();
//        float total = Math.abs(mFilterOffsetAngle - mFilterTargetAngle);
//        final int frameCount = 20;
//        final int timeInMs = 300;
//        mTask = new UpdateTimerTask(mCircle3UpdateHandler, (total / frameCount + 1));
//        mTimer.schedule(mTask, 0, (timeInMs / frameCount));
//    }
//
//    private void setHandleMode(int mode) {
//        this.mHandleMode = mode;
//    }
//
//    private float getAngle(float x, float y) {
//        return (float) ((getRadian(x, y) / Math.PI * 180));
//    }
//
//    private float getRadian(float x, float y) {
//        float centerX = getWidth() / 2;
//        float centerY = getHeight() / 2;
//        float dx = x - centerX;
//        float dy = y - centerY;
//        return (float) (Math.atan2(dy, dx) + Math.PI);
//    }
//
//    private float getDistanceToCenter(float x, float y) {
//        float centerX = getWidth() / 2;
//        float centerY = getHeight() / 2;
//        float dx = x - centerX;
//        float dy = y - centerY;
//        return (float) Math.sqrt(dx * dx + dy * dy);
//    }
//
//    private void onClickAutoModeIcon(float angle) {
//        Log.d(TAG, "onClickAutoModeIcon " + angle + " mModeIndex " + mModeIndex);
//        int index = 0;
//        for (index = 0; index < mAutoModeAngleRanges.length; index++) {
//            AngleRange range = mAutoModeAngleRanges[index];
//            if (range.inRange(angle)) {
//                break;
//            }
//        }
//        switch (mModeIndex) {
//            case MODE_BEAUTY: {
//                if (index == 2) {
//                    mNextModeIndex = MODE_FILTER;
//                    mModeOffsetAngle = 0;
//                    mModeTargetAngle = -60;
//                    setHandleMode(HANDLE_UP);
//                    doCircle2Up();
//                }
//                break;
//            }
//            case MODE_FILTER: {
//                if (index == 0) {
//                    mNextModeIndex = MODE_BEAUTY;
//                    mModeOffsetAngle = 0;
//                    mModeTargetAngle = 60;
//                    setHandleMode(HANDLE_UP);
//                    doCircle2Up();
//                }
//                break;
//            }
//        }
//    }
//
//    private void onClickModeIcon(float angle) {
//        if (mMode == Constants.CAM_MODE_AUTO) {
//            onClickAutoModeIcon(angle);
//            return;
//        }
//        Log.d(TAG, "onClickModeIcon " + angle + " mModeIndex " + mModeIndex);
//        int index = 0;
//        int len = (mMode == Constants.CAM_MODE_AUTO) ? MODE_AUTO_COUNT : mModeAngleRanges.length;
//        for (index = 0; index < len; index++) {
//            AngleRange range = mModeAngleRanges[index];
//            if (range.inRange(angle)) {
//                break;
//            }
//        }
//        Log.d(TAG, "onClickModeIcon index " + index);
//        if (index < len) {
//            int nextIndex = index + mModeIndex;
//            if (nextIndex >= mModeAngleRanges.length) {
//                nextIndex -= mModeAngleRanges.length;
//            }
//            mNextModeIndex = nextIndex;
//            mModeOffsetAngle = 0;
//            mModeTargetAngle = -index * 60;
//            Log.d(TAG, "onClickModeIcon index " + mNextModeIndex);
//            setHandleMode(HANDLE_UP);
//            doCircle2Up();
//        }
//    }
//
//    private void onClick(MotionEvent event) {
//        float distance = getDistanceToCenter(mLastDownX, mLastDownY);
//        float angle = getAngle(event.getX(), event.getY());
//        Log.d(TAG, "onClick distance " + distance + " angle " + angle);
//        if (distance < mCircle1Radius) {
//            onClickModeSwitch();
//        } else if (distance < mCircle2Radius) {
//            onClickModeIcon(angle);
//        } else if (distance < mCircle3Radius) {
//            if (mModeIndex == MODE_BEAUTY) {
//                onClickBeautyModeIcon(angle);
//            } else if (mModeIndex == MODE_WB) {
//                onClickWBModeIcon(angle);
//            } else if (mModeIndex == MODE_FILTER) {
//                onClickFilterModeIcon(angle);
//            }
//        }
//    }
//
//    private void onClickFilterModeIcon(float angle) {
//        Log.d(TAG, "onClickFilterModeIcon angle " + angle);
//        int index = 0;
//        for (index = 0; index < mFilterModeAngleRanges.length; index++) {
//            AngleRange range = mFilterModeAngleRanges[index];
//            if (range.inRange(angle)) {
//                break;
//            }
//        }
//
//        int value = (mFilterIndex + 1 + index);
//        if (value >= mFilterModeCount) {
//            value -= mFilterModeCount;
//        }
//        setModeValue(mModeIndex, value);
//    }
//
//    private void onClickWBModeIcon(float angle) {
//        Log.d(TAG, "onClickWBModeIcon angle " + angle);
//        int index = 0;
//        for (index = 0; index < mWBModeAngleRanges.length; index++) {
//            AngleRange range = mWBModeAngleRanges[index];
//            if (range.inRange(angle)) {
//                break;
//            }
//        }
//        setModeValue(mModeIndex, index);
//    }
//
//    private void onClickBeautyModeIcon(float angle) {
//        Log.d(TAG, "onClickBeautyModeIcon angle " + angle);
//        int index = 0;
//        for (index = 0; index < mBeautyModeAngleRanges.length; index++) {
//            AngleRange range = mBeautyModeAngleRanges[index];
//            if (range.inRange(angle)) {
//                break;
//            }
//        }
//        setModeValue(mModeIndex, index);
//    }
//
//    private void onClickModeSwitch() {
//        mMode = (mMode == Constants.CAM_MODE_AUTO) ? Constants.CAM_MODE_MANUAL : Constants.CAM_MODE_AUTO;
//        if (mOnChangeListener != null) {
//            mOnChangeListener.onModeValueChange(Constants.CAM_MODE, mMode);
//        }
//        mModeIndex = MODE_BEAUTY;
//        invalidate();
//    }
//
//    private boolean onTouchEventInternal(MotionEvent event) {
//        float distance = getDistanceToCenter(mLastDownX, mLastDownY);
//        if (distance < mCircle1Radius) {
//            return true;
//        } else if (distance < mCircle2Radius) {
//            return onCircle2TouchEvent(event);
//        } else if (distance < mCircle5Radius) {
//            if (mModeIndex == MODE_FILTER) {
//                if (distance < mCircle3Radius)
//                    return onCircle3TouchEventForFilterMode(event);
//            } else if (mModeIndex == MODE_BRIGHTNESS
//                    || mModeIndex == MODE_CONTRAST
//                    || mModeIndex == MODE_SATURATION) {
//                float r1 = mCircle4Radius - mPoint1Radius;
//                float r2 = mCircle4Radius + mPoint1Radius;
//                if (distance >= r1 && distance <= r2)
//                    return onCircle3TouchEventForSeekBarMode(event);
//            }
//        }
//
//        return true;
//    }
//
//    private float getSeekBarModeAngle(int mode) {
//        switch (mode) {
//            case MODE_CONTRAST:
//                return (100 - mContrastValue) + MODE_SEEKBAR_START_ANGLE;
//            case MODE_BRIGHTNESS:
//                return (100 - mBrightnessValue) + MODE_SEEKBAR_START_ANGLE;
//            case MODE_SATURATION:
//                return (100 - mSaturationValue) + MODE_SEEKBAR_START_ANGLE;
//        }
//        return MODE_SEEKBAR_START_ANGLE;
//    }
//
//    private void setSeekBarModeAngle(int mode, float angle) {
//        float value = angle;
//        if (value < MODE_SEEKBAR_START_ANGLE) {
//            value = MODE_SEEKBAR_START_ANGLE;
//        }
//        if (value > MODE_SEEKBAR_END_ANGLE) {
//            value = MODE_SEEKBAR_END_ANGLE;
//        }
//        value -= MODE_SEEKBAR_START_ANGLE;
//        int intValue = new Float(value).intValue();
//        setModeValue(mode, (100 - intValue));
//    }
//
//    private boolean onCircle3TouchEventForSeekBarMode(MotionEvent event) {
//        float angle = getAngle(event.getX(), event.getY());
//        angle -= 90;
//        Log.d(TAG, "onCircle3TouchEventForSeekBarMode angle:" + angle);
//        switch (event.getAction()) {
//            case MotionEvent.ACTION_DOWN: {
//                AngleRange range = new AngleRange(getSeekBarModeAngle(mModeIndex), 8);
//                if (!range.inRange(angle)) {
//                    return false;
//                }
//                invalidate();
//                break;
//            }
//            case MotionEvent.ACTION_MOVE:
//            case MotionEvent.ACTION_UP:
//                setSeekBarModeAngle(mModeIndex, angle);
//                break;
//        }
//        return true;
//    }
//
//    private boolean onCircle3TouchEventForFilterMode(MotionEvent event) {
//        float angle = getAngle(event.getX(), event.getY());
//        Log.d(TAG, "onCircle3TouchEventForFilterMode angle:" + angle);
//        switch (event.getAction()) {
//            case MotionEvent.ACTION_DOWN:
//                cancelTask();
//                mFilterDownAngle = angle;
//                break;
//            case MotionEvent.ACTION_MOVE:
//                mFilterOffsetAngle = (angle - mFilterDownAngle);
//                invalidate();
//                break;
//            case MotionEvent.ACTION_UP:
//                mFilterOffsetAngle = (angle - mFilterDownAngle);
//                int offset = (int) (mFilterOffsetAngle / (FILTER_ITEM_ANGLE + FILTER_ITEM_ANGLE_GAP));
//                if (offset * (FILTER_ITEM_ANGLE + FILTER_ITEM_ANGLE_GAP) != mFilterOffsetAngle) {
//                    if (mFilterOffsetAngle > 0) {
//                        offset += 1;
//                    } else if (mFilterOffsetAngle < 0) {
//                        offset -= 1;
//                    }
//                }
//                mFilterTargetAngle = offset * (FILTER_ITEM_ANGLE + FILTER_ITEM_ANGLE_GAP);
//                mNextFilterIndex = mFilterIndex - offset;
//                if (mNextFilterIndex < 0) {
//                    mNextFilterIndex += mModeFilterDrawables.length;
//                } else if (mNextFilterIndex > mModeFilterDrawables.length) {
//                    mNextFilterIndex -= mModeFilterDrawables.length;
//                }
//                Log.d(TAG, "onCircle3TouchEventForFilterMode mFilterIndex " + mFilterIndex + " mNextFilterIndex " + mNextFilterIndex);
//                doCircle3Up();
//                invalidate();
//                break;
//        }
//        return true;
//    }
//
//    private void cancelTask() {
//        if (mTask != null) {
//            mTask.cancel();
//            mTask = null;
//        }
//    }
//
//    private boolean onCircle2TouchEventWhenAutoMode(MotionEvent event) {
//        float angle = getAngle(event.getX(), event.getY());
//        switch (event.getAction()) {
//            case MotionEvent.ACTION_DOWN:
//                cancelTask();
//                setHandleMode(HANDLE_DOWN);
//                mModeDownAngle = angle;
//                break;
//            case MotionEvent.ACTION_MOVE:
//                mModeOffsetAngle = angle - mModeDownAngle;
//                Log.e(TAG, "onCircle2TouchEventWhenAutoMode mModeOffsetAngle " + mModeOffsetAngle);
//                invalidate();
//                break;
//            case MotionEvent.ACTION_UP:
//                setHandleMode(HANDLE_UP);
//                mModeOffsetAngle = angle - mModeDownAngle;
//                if (mModeIndex == MODE_BEAUTY) {
//                    if (mModeOffsetAngle >= -20) {
//                        mNextModeIndex = MODE_BEAUTY;
//                        mModeTargetAngle = 0;
//                    } else {
//                        mNextModeIndex = MODE_FILTER;
//                        mModeTargetAngle = -60;
//                    }
//                } else if (mModeIndex == MODE_FILTER) {
//                    if (mModeOffsetAngle <= 20) {
//                        mNextModeIndex = MODE_FILTER;
//                        mModeTargetAngle = -60;
//                    } else {
//                        mNextModeIndex = MODE_BEAUTY;
//                        mModeTargetAngle = 60;
//                    }
//                }
//
//                Log.e(TAG, "onCircle2TouchEventWhenAutoMode mModeTargetAngle " + mModeTargetAngle + " mModeOffsetAngle " + mModeOffsetAngle);
//                Log.e(TAG, "onCircle2TouchEventWhenAutoMode mModeIndex " + mModeIndex + " mNextModeIndex " + mNextModeIndex);
//                doCircle2Up();
//                invalidate();
//                break;
//        }
//        return true;
//    }
//
//    private boolean onCircle2TouchEvent(MotionEvent event) {
//        if (mMode == Constants.CAM_MODE_AUTO) {
//            return onCircle2TouchEventWhenAutoMode(event);
//        }
//
//        float angle = getAngle(event.getX(), event.getY());
//        switch (event.getAction()) {
//            case MotionEvent.ACTION_DOWN:
//                cancelTask();
//                setHandleMode(HANDLE_DOWN);
//                mModeDownAngle = angle;
//                break;
//            case MotionEvent.ACTION_MOVE:
//                mModeOffsetAngle = angle - mModeDownAngle;
//                invalidate();
//                break;
//            case MotionEvent.ACTION_UP:
//                setHandleMode(HANDLE_UP);
//                mModeOffsetAngle = angle - mModeDownAngle;
//                Log.e(TAG, "onCircle2TouchEvent Angle change " + mModeOffsetAngle);
//                int current = new Float(mModeOffsetAngle).intValue();
//                int offset = 0;
//                if (mModeOffsetAngle > 0) {
//                    offset = (current + 60) / 60;
//                    if (offset * 60 < current + 30) {
//                        offset += 1;
//                    }
//                } else if (mModeOffsetAngle < 0) {
//                    offset = current / 60;
//                }
//                mNextModeIndex = mModeIndex - offset;
//                if (mNextModeIndex >= MODE_COUNT) {
//                    mNextModeIndex -= MODE_COUNT;
//                } else if (mNextModeIndex < 0) {
//                    mNextModeIndex += MODE_COUNT;
//                }
//                mModeTargetAngle = offset * 60;
//
//                Log.e(TAG, "onCircle2TouchEvent mModeTargetAngle " + mModeTargetAngle + " mModeOffsetAngle " + mModeOffsetAngle);
//                Log.e(TAG, "onCircle2TouchEvent mModeIndex " + mModeIndex + " mNextModeIndex " + mNextModeIndex);
//                doCircle2Up();
//                invalidate();
//                break;
//        }
//        return true;
//    }
//
//    public interface OnChangeListener {
//        void onModeValueChange(int mode, int value);
//
//        void onViewVisibilityChange(int visibility);
//    }
//
//    class AngleRange {
//        private final float mLower;
//        private final float mUpper;
//
//        public AngleRange(float center, float range) {
//            mLower = center - range / 2;
//            mUpper = center + range / 2;
//        }
//
//        public boolean inRange(float value) {
//            if (value < mLower) {
//                return false;
//            }
//            if (value > mUpper) {
//                return false;
//            }
//            return true;
//        }
//    }
//
//    class UpdateTimerTask extends TimerTask {
//        Handler mHandler;
//        int mStep;
//
//
//        public UpdateTimerTask(Handler handler, float step) {
//            this.mHandler = handler;
//            this.mStep = new Float(step).intValue();
//        }
//
//        @Override
//        public void run() {
//            Message msg = mHandler.obtainMessage();
//            msg.arg1 = mStep;
//            mHandler.sendMessage(msg);
//        }
//    }
//
//}
