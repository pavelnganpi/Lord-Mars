package com.paveynganpi.lordmars.model;

/**
 * Created by paveynganpi on 12/27/14.
 */
public class Choice {

    private String mText;//text that describes the choice
    private int mNextPage; //index of the pages in the array to link one to the other

    public Choice(String text, int nextPage){

        mText = text;
        mNextPage = nextPage;
    }

    public String getText() {
        return mText;
    }

    public void setText(String text) {
        mText = text;
    }

    public int getNextPage() {
        return mNextPage;
    }

    public void setNextPage(int nextPage) {
        mNextPage = nextPage;
    }
}
