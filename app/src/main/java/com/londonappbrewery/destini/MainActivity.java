package com.londonappbrewery.destini;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // TODO: Steps 4 & 8 - Declare member variables here:
    TextView mTextView;
    Button mButton_Top;
    Button mButton_Bottom;
    int mStoryIndex;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // TODO: Step 5 - Wire up the 3 views from the layout to the member variables:
        mTextView = (TextView) findViewById(R.id.storyTextView);
        mButton_Top = (Button) findViewById(R.id.buttonTop);
        mButton_Bottom = (Button) findViewById(R.id.buttonBottom);

        if (savedInstanceState!=null){
            mStoryIndex = savedInstanceState.getInt("storyIndexKey");
            if (mStoryIndex == 2) {
                mTextView.setText(R.string.T2_Story);
                mButton_Top.setText(R.string.T2_Ans1);
                mButton_Bottom.setText(R.string.T2_Ans2);
            } else if (mStoryIndex == 3) {
                mTextView.setText(R.string.T3_Story);
                mButton_Top.setText(R.string.T3_Ans1);
                mButton_Bottom.setText(R.string.T3_Ans2);
            }else {
                if (mStoryIndex == 4) {
                    mTextView.setText(R.string.T4_End);
                    mButton_Top.setVisibility(View.GONE);
                    mButton_Bottom.setVisibility(View.GONE);
                } else if (mStoryIndex == 5) {
                    mTextView.setText(R.string.T5_End);
                    mButton_Top.setVisibility(View.GONE);
                    mButton_Bottom.setVisibility(View.GONE);
                } else {
                    mTextView.setText(R.string.T6_End);
                    mButton_Top.setVisibility(View.GONE);
                    mButton_Bottom.setVisibility(View.GONE);
                }
            }
        }else  mStoryIndex=1;

        // TODO: Steps 6, 7, & 9 - Set a listener on the top button:
        mButton_Top.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mStoryIndex==1 || mStoryIndex==2){
                    mTextView.setText(R.string.T3_Story);
                    mButton_Top.setText(R.string.T3_Ans1);
                    mButton_Bottom.setText(R.string.T3_Ans2);
                    mStoryIndex=3;
                } else {
                    mTextView.setText(R.string.T6_End);
                    mButton_Top.setVisibility(View.GONE);
                    mButton_Bottom.setVisibility(View.GONE);
                    mStoryIndex=6;
                }
            }
        });

        // TODO: Steps 6, 7, & 9 - Set a listener on the bottom button:
        mButton_Bottom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mStoryIndex ==1) {
                    mTextView.setText(R.string.T2_Story);
                    mButton_Top.setText(R.string.T2_Ans1);
                    mButton_Bottom.setText(R.string.T2_Ans2);
                    mStoryIndex=2;
                } else if (mStoryIndex==2){
                    mTextView.setText(R.string.T4_End);
                    mButton_Top.setVisibility(View.GONE);
                    mButton_Bottom.setVisibility(View.GONE);
                    mStoryIndex=4;
                }else{
                    mTextView.setText(R.string.T5_End);
                    mButton_Top.setVisibility(View.GONE);
                    mButton_Bottom.setVisibility(View.GONE);
                    mStoryIndex=5;
                }
            }
        });
    }
    @Override
    public void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        outState.putInt("storyIndexKey", mStoryIndex);
    }
}
