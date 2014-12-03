package com.zhoujg77.mytopbar;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by zhoujg77 on 14-12-3.
 */
public class TopBar extends RelativeLayout {
    private Button leftButton, rightButton;
    private TextView titleTextView;


    private int leftTextColor;
    private Drawable leftBackground;
    private String leftText;


    private int rightTextColor;
    private Drawable rightBackground;
    private String rightText;

    private float titleTextSize;
    private int titleTextColor;
    private String title;

    private LayoutParams leftParams ,rightParams,titleParams;


    private topbarClickLister lister;
    //定义接口
    public interface topbarClickLister{
        public void leftClick();
        public void rightClick();
    }

    public void setOnTopBarClickLister(topbarClickLister lister){
        this.lister = lister;
    }


    public TopBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray ta = context.obtainStyledAttributes(attrs,R.styleable.Topbar);

        leftTextColor = ta.getColor(R.styleable.Topbar_lifeTextColor,0);
       leftBackground = ta.getDrawable(R.styleable.Topbar_leftBackground);
         leftText = ta.getString(R.styleable.Topbar_leftText);


        rightTextColor = ta.getColor(R.styleable.Topbar_rightTextColor,0);
        rightBackground = ta.getDrawable(R.styleable.Topbar_rightBackground);
        rightText = ta.getString(R.styleable.Topbar_rightText);

        titleTextSize = ta.getDimension(R.styleable.Topbar_titleTextSize,0);
        titleTextColor = ta.getColor(R.styleable.Topbar_rightTextColor,0);
        title = ta.getString(R.styleable.Topbar_title);

        ta.recycle(); //避免缓存引起的错误！释放资源

        leftButton = new Button(context);
        rightButton = new Button(context);
        titleTextView = new TextView(context);

        leftButton.setTextColor(leftTextColor);
        leftButton.setBackground(leftBackground);
        leftButton.setText(leftText);


        rightButton.setTextColor(rightTextColor);
        rightButton.setBackground(rightBackground);
        rightButton.setText(rightText);

        titleTextView.setText(title);
        titleTextView.setTextSize(titleTextSize);
        titleTextView.setTextColor(titleTextColor);
        titleTextView.setGravity(Gravity.CENTER);

        setBackgroundColor(0xFFF59563);


        leftParams = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        leftParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT,TRUE);

        addView(leftButton,leftParams);

        rightParams = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        rightParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT,TRUE);

        addView(rightButton,rightParams);

        titleParams = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT);
        titleParams.addRule(RelativeLayout.CENTER_IN_PARENT,TRUE);

        addView(titleTextView,titleParams);




        leftButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                    lister.leftClick();
            }
        });

        rightButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                      lister.rightClick();
            }
        });



    }
}
