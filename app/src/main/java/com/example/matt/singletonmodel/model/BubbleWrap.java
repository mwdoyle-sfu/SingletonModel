package com.example.matt.singletonmodel.model;

/**
 * Created by Matt on 2018-01-31.
 */

public class BubbleWrap {
    private static final int ADD_MORE_BUBBLES = 10;
    private int numBubbles;

    /*
        Singleton support
     */
    private static BubbleWrap instance;

    private BubbleWrap(){
        // Private constructor to prevent anyone else from instantiating
    }

    public static BubbleWrap getInstance(){
        if(instance == null){
            instance = new BubbleWrap();
        }
        return instance;
    }


    /*
        Normal Object Code
     */
    public int getNumBubbles() {
        return numBubbles;
    }

    public void addMoreBubbles(){
        numBubbles += ADD_MORE_BUBBLES;
    }

    public void popBubble() {
        numBubbles --;
    }
}
