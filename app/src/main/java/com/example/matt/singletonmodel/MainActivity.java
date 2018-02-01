package com.example.matt.singletonmodel;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.matt.singletonmodel.model.BubbleWrap;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private BubbleWrap bubbleWrap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bubbleWrap = BubbleWrap.getInstance();

        setupAddMoreButton();
        SetupPopActivityButton();
    }

    @Override
    protected void onResume() {
        super.onResume();
        updateUI();
    }

    private void setupAddMoreButton() {
        Button btn = findViewById(R.id.addMoreBtn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bubbleWrap.addMoreBubbles();
                updateUI();
            }
        });

    }

    private void SetupPopActivityButton() {
        Button btn = findViewById(R.id.startPoppingBtn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Launch activity
                Intent intent = new Intent(MainActivity.this, PopActivity.class);
                startActivity(intent);
            }
        });

    }

    private void updateUI() {
        TextView textView = findViewById(R.id.bubblesLeftTxt);
        String msg = String.format(Locale.getDefault(),
                "%d bubbles left!",
                bubbleWrap.getNumBubbles());
        textView.setText(msg);
    }
}
