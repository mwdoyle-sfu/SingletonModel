package com.example.matt.singletonmodel;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.matt.singletonmodel.model.BubbleWrap;

import java.util.Locale;

public class PopActivity extends AppCompatActivity {

    private BubbleWrap bubbleWrap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pop);

        bubbleWrap = BubbleWrap.getInstance();

        setupPopButton();
        updateUI();
    }

    private void setupPopButton() {
        Button btn = findViewById(R.id.popBtn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bubbleWrap.popBubble();
                Toast.makeText(PopActivity.this,"POP!", Toast.LENGTH_SHORT).show();
                updateUI();
            }
        });
    }

    private void updateUI() {
        TextView textView = findViewById(R.id.bubblesDisplayTxt);
        String msg = String.format(Locale.getDefault(),
                "Bubbles left: %d",
                bubbleWrap.getNumBubbles());
        textView.setText(msg);
    }
}
