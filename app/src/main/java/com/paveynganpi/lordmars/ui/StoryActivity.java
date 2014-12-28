package com.paveynganpi.lordmars.ui;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.paveynganpi.lordmars.R;
import com.paveynganpi.lordmars.model.Page;
import com.paveynganpi.lordmars.model.Story;


public class StoryActivity extends ActionBarActivity {

    private Story mStory = new Story();
    private ImageView mImageView;
    private TextView mTextView;
    private Button mChoice1;
    private Button mChoice2;
    private String mName;
    private Page mCurrentPage;


    public static final String TAG = StoryActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);

        //get the intent from MainActivity
        Intent intent = getIntent();
         mName = intent.getStringExtra(getString(R.string.key_name));//get the Extra from the intent

        if (mName==null){
            mName="Friend";
        }

        Log.d(TAG, mName);

        mImageView = (ImageView) findViewById(R.id.storyImageView);
        mTextView = (TextView) findViewById(R.id.storyTextView);
        mChoice1 = (Button) findViewById(R.id.choiceButton1);
        mChoice2 = (Button) findViewById(R.id.choiceButton2);
        loadPage(0);

    }

    public void loadPage(int choice){

        mCurrentPage = mStory.getPage(choice);

        //transform the image id into an actual drawable
        Drawable drawable = getResources().getDrawable(mCurrentPage.getImageId());
        mImageView.setImageDrawable(drawable);

        //will add the mName if placeholder is included. it wont add if placeholder is not included
        String pageText = mCurrentPage.getText();
        pageText = String.format(pageText,mName);
        mTextView.setText(pageText);

        //if mcurrentpage has choice as null, then game is over
        if(mCurrentPage.isFinal()){

            mChoice1.setVisibility(View.INVISIBLE);
            mChoice2.setText("Play Again");

            mChoice2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    finish();//move out of the activity and return to main activity
                }
            });

        }
        else {
            mChoice1.setText(mCurrentPage.getChoice1().getText());
            mChoice2.setText(mCurrentPage.getChoice2().getText());

            //when choice1 button is clicked
            mChoice1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    int nextPage = mCurrentPage.getChoice1().getNextPage();
                    loadPage(nextPage);
                }
            });

            //when choice2 button is clicked
            mChoice2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    int nextPage = mCurrentPage.getChoice2().getNextPage();
                    loadPage(nextPage);
                }
            });
        }

    }


}
