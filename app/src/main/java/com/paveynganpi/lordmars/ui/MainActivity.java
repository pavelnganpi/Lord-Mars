package com.paveynganpi.lordmars.ui;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.paveynganpi.lordmars.R;


public class MainActivity extends ActionBarActivity {

    //member variables
    private EditText mNameField;//stores the name from the text field with id nameEditText
    private Button mStartButton;//references the start button

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mNameField = (EditText) findViewById(R.id.nameEditText);
        mStartButton = (Button) findViewById(R.id.startButton);

        mStartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = mNameField.getText().toString();
               startStory(name);

            }
        });
    }

    //calls the StartActivity activity
    public void startStory(String name){

        Intent intent = new Intent(this, StoryActivity.class);
        intent.putExtra(getString(R.string.key_name),name);//getting the string "name" from the string resource
        startActivity(intent);

    }

    //when the mainActivity resumes
    @Override
    protected void onResume() {
        super.onResume();
        mNameField.setText("");//reset the text in the textfield to an empty string
    }
}
