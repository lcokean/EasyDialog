package com.michael.easydialogdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.michael.easydialog.EasyDialog;


/**
 * This class shows how to use EasyDialog
 * <p/>
 * Created by michael on 15/4/15.
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private RelativeLayout rlBackground;
    private Button btnTopLeft;
    private Button btnTopRight;
    private Button btnMiddleTop;
    private Button btnMiddleLeft;
    private Button btnMiddleRight;
    private Button btnMiddleBottom;
    private Button btnBottomLeft;
    private Button btnBottomRight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iniComponent();
    }

    private void iniComponent() {
        rlBackground = (RelativeLayout) findViewById(R.id.rlBackground);
        btnTopLeft = (Button) findViewById(R.id.btnTopLeft);
        btnTopRight = (Button) findViewById(R.id.btnTopRight);
        btnMiddleTop = (Button) findViewById(R.id.btnMiddleTop);
        btnMiddleLeft = (Button) findViewById(R.id.btnMiddleLeft);
        btnMiddleRight = (Button) findViewById(R.id.btnMiddleRight);
        btnMiddleBottom = (Button) findViewById(R.id.btnMiddleBottom);
        btnBottomLeft = (Button) findViewById(R.id.btnBottomLeft);
        btnBottomRight = (Button) findViewById(R.id.btnBottomRight);

        btnTopLeft.setOnClickListener(this);
        btnTopRight.setOnClickListener(this);
        btnMiddleTop.setOnClickListener(this);
        btnMiddleLeft.setOnClickListener(this);
        btnMiddleRight.setOnClickListener(this);
        btnMiddleBottom.setOnClickListener(this);
        btnBottomLeft.setOnClickListener(this);
        btnBottomRight.setOnClickListener(this);
        rlBackground.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int[] location = new int[2];
                location[0] = (int) event.getX();
                location[1] = (int) event.getY();
                location[1] = location[1] + getStatusBarHeight();
                Toast.makeText(MainActivity.this, "x:" + location[0] + " y:" + location[1], Toast.LENGTH_SHORT).show();

//                View easyView = MainActivity.this.getLayoutInflater().inflate(R.layout.layout_tip_list_view, null);

                new EasyDialog.Builder(MainActivity.this)
//                        .setLayout(easyView)
                        .setLayoutResourceId(R.layout.layout_tip_content_horizontal)
                        .setBackgroundColor(MainActivity.this.getResources().getColor(R.color.background_color_black))
                        .setLocation(location)
                        .setGravity(EasyDialog.GRAVITY_TOP)
                        .setTouchOutsideDismiss(true)
                        .setMatchParent(false)
                        .setMargin(24, 24, 24, 24)
                        .setOutsideColor(MainActivity.this.getResources().getColor(R.color.outside_color_gray))
                        .create()
                        .show();

                return false;
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnTopLeft:
                View view = this.getLayoutInflater().inflate(R.layout.layout_tip_content_horizontal, null);
                new EasyDialog.Builder(MainActivity.this)
//                        .setLayoutResourceId(R.layout.layout_tip_content_horizontal)//layout resource id
                        .setLayout(view)
                        .setBackgroundColor(MainActivity.this.getResources().getColor(R.color.background_color_black))
//                        .setLocation(new location[])//point in screen
                        .setLocationByAttachedView(btnTopLeft)
                        .setGravity(EasyDialog.GRAVITY_BOTTOM)
                        .setTouchOutsideDismiss(true)
                        .setMatchParent(true)
                        .setMargin(24, 24, 24, 24)
                        .setOutsideColor(MainActivity.this.getResources().getColor(R.color.outside_color_trans))
                        .create()
                        .addAnimationTranslationShow(EasyDialog.DIRECTION_X, 1000, -600, 100, -50, 50, 0)
                        .addAnimationAlphaShow(1000, 0.3f, 1.0f)
                        .addAnimationTranslationDismiss(EasyDialog.DIRECTION_X, 500, -50, 800)
                        .addAnimationAlphaDismiss(500, 1.0f, 0.0f)
                        .show();
                break;

            case R.id.btnTopRight:
                new EasyDialog.Builder(MainActivity.this)
                        .setLayoutResourceId(R.layout.layout_tip_image_text)
                        .setGravity(EasyDialog.GRAVITY_BOTTOM)
                        .setBackgroundColor(MainActivity.this.getResources().getColor(R.color.background_color_black))
                        .setLocationByAttachedView(btnTopRight)
                        .setTouchOutsideDismiss(true)
                        .setMatchParent(false)
                        .setMargin(24, 24, 24, 24)
                        .setOutsideColor(MainActivity.this.getResources().getColor(R.color.outside_color_trans))
                        .setOnEasyDialogDismissed(new EasyDialog.OnEasyDialogDismissed() {
                            @Override
                            public void onDismissed() {
                                Toast.makeText(MainActivity.this, "dismiss", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setOnEasyDialogShow(new EasyDialog.OnEasyDialogShow() {
                            @Override
                            public void onShow() {
                                Toast.makeText(MainActivity.this, "show", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .create()
                        .addAnimationTranslationShow(EasyDialog.DIRECTION_X, 350, 400, 0)
                        .addAnimationTranslationDismiss(EasyDialog.DIRECTION_X, 350, 0, 400)
                        .show();
                break;
            case R.id.btnMiddleTop:
                new EasyDialog.Builder(MainActivity.this)
                        .setLayoutResourceId(R.layout.layout_tip_content_horizontal)
                        .setBackgroundColor(MainActivity.this.getResources().getColor(R.color.background_color_blue))
                        .setLocationByAttachedView(btnMiddleTop)
                        .setGravity(EasyDialog.GRAVITY_TOP)
                        .setTouchOutsideDismiss(true)
                        .setMatchParent(false)
                        .setMargin(24, 24, 24, 24)
                        .setOutsideColor(MainActivity.this.getResources().getColor(R.color.outside_color_pink))
                        .create()
                        .addAnimationTranslationShow(EasyDialog.DIRECTION_Y, 1000, -800, 100, -50, 50, 0)
                        .addAnimationTranslationDismiss(EasyDialog.DIRECTION_Y, 500, 0, -800)
                        .show();
                break;
            case R.id.btnMiddleLeft:
                new EasyDialog.Builder(MainActivity.this)
                        .setLayoutResourceId(R.layout.layout_tip_text)
                        .setBackgroundColor(MainActivity.this.getResources().getColor(R.color.background_color_purple))
                        .setLocationByAttachedView(btnMiddleLeft)
                        .setGravity(EasyDialog.GRAVITY_RIGHT)
                        .setTouchOutsideDismiss(true)
                        .setMatchParent(false)
                        .setOutsideColor(MainActivity.this.getResources().getColor(R.color.outside_color_gray))
                        .create()
                        .addAnimationAlphaShow(300, 0.0f, 1.0f)
                        .addAnimationAlphaDismiss(300, 1.0f, 0.0f)
                        .show();
                break;
            case R.id.btnMiddleRight:
                new EasyDialog.Builder(MainActivity.this)
                        .setLayoutResourceId(R.layout.layout_tip_text)
                        .setBackgroundColor(MainActivity.this.getResources().getColor(R.color.background_color_red))
                        .setLocationByAttachedView(btnMiddleRight)
                        .setGravity(EasyDialog.GRAVITY_LEFT)
                        .setTouchOutsideDismiss(true)
                        .setMatchParent(false)
                        .setOutsideColor(MainActivity.this.getResources().getColor(R.color.outside_color_gray))
                        .create()
                        .addAnimationAlphaShow(300, 0.0f, 1.0f)
                        .addAnimationAlphaDismiss(300, 1.0f, 0.0f)
                        .show();
                break;
            case R.id.btnMiddleBottom:
                new EasyDialog.Builder(MainActivity.this)
                        .setLayoutResourceId(R.layout.layout_tip_content_horizontal)
                        .setGravity(EasyDialog.GRAVITY_BOTTOM)
                        .setBackgroundColor(MainActivity.this.getResources().getColor(R.color.background_color_brown))
                        .setLocationByAttachedView(btnMiddleBottom)
                        .setTouchOutsideDismiss(true)
                        .setMatchParent(true)
                        .setMargin(24, 24, 24, 24)
                        .setOutsideColor(MainActivity.this.getResources().getColor(R.color.outside_color_gray))
                        .create()
                        .addAnimationTranslationShow(EasyDialog.DIRECTION_Y, 1000, 800, -100, -50, 50, 0)
                        .addAnimationTranslationDismiss(EasyDialog.DIRECTION_Y, 500, 0, 800)
                        .addAnimationAlphaShow(1000, 0.3f, 1.0f)
                        .show();
                break;
            case R.id.btnBottomLeft:
                new EasyDialog.Builder(MainActivity.this)
                        .setLayoutResourceId(R.layout.layout_tip_text)
                        .setBackgroundColor(MainActivity.this.getResources().getColor(R.color.background_color_pink))
                        .setLocationByAttachedView(btnBottomLeft)
                        .setGravity(EasyDialog.GRAVITY_TOP)
                        .setTouchOutsideDismiss(true)
                        .setMatchParent(false)
                        .setMargin(24, 24, 24, 24)
                        .setOutsideColor(MainActivity.this.getResources().getColor(R.color.outside_color_trans))
                        .create()
                        .addAnimationAlphaShow(600, 0.0f, 1.0f)
                        .addAnimationAlphaDismiss(600, 1.0f, 0.0f)
                        .show();
                break;
            case R.id.btnBottomRight:
                new EasyDialog.Builder(MainActivity.this)
                        .setLayoutResourceId(R.layout.layout_tip_image_text)
                        .setBackgroundColor(MainActivity.this.getResources().getColor(R.color.background_color_yellow))
                        .setLocationByAttachedView(btnBottomRight)
                        .setGravity(EasyDialog.GRAVITY_TOP)
                        .setTouchOutsideDismiss(true)
                        .setMatchParent(false)
                        .setMargin(24, 24, 24, 24)
                        .setOutsideColor(MainActivity.this.getResources().getColor(R.color.outside_color_trans))
                        .create()
                        .addAnimationTranslationShow(EasyDialog.DIRECTION_X, 300, 400, 0)
                        .addAnimationTranslationShow(EasyDialog.DIRECTION_Y, 300, 400, 0)
                        .addAnimationTranslationDismiss(EasyDialog.DIRECTION_X, 300, 0, 400)
                        .addAnimationTranslationDismiss(EasyDialog.DIRECTION_Y, 300, 0, 400)
                        .show();
                break;
        }
    }

    private int getStatusBarHeight() {
        int result = 0;
        int resourceId = this.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = this.getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }
}

