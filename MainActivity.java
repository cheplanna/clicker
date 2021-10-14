package com.example.clicker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private long count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        TextView textCountView = findViewById(R.id.countText);
        ImageView image = findViewById(R.id.action_image);
        Button decButton = findViewById(R.id.decButton);
        Button resetButton = findViewById(R.id.resetButton);

        image.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        count++; updateClickCountText(textCountView);
                    }
                }
                );
        decButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (count != 0) {
                            count--;
                        }
                        updateClickCountText(textCountView);
                    }
                }
                );
        resetButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        count = 0;
                        updateClickCountText(textCountView);
                    }
                }
                );
    } private void updateClickCountText(TextView textView) {
        String newClickCountText = "На собачку нажали " + count + " раз";
        long last_digit = count % 10;
        if (count != 12 && count != 13 && count != 14 && (last_digit == 2 || last_digit == 3 || last_digit == 4)) {
            newClickCountText += "а";
        }
        textView.setText(newClickCountText.toCharArray(), 0, newClickCountText.length());
    }
}





