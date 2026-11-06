package com.example.hellotoast;

import android.content.res.ColorStateList;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public class MainActivity extends AppCompatActivity {

    private int mCount = 0;
    private TextView mShowCount;
    private Button mButtonZero;
    private Button mButtonCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mShowCount = findViewById(R.id.text_display_count);
        mButtonZero = findViewById(R.id.button_zero);
        mButtonCount = findViewById(R.id.button_count);

        if (savedInstanceState != null) {
            mCount = savedInstanceState.getInt("count", 0);
        }
        updateUI();
    }

    public void show_toast(View view) {
        Toast.makeText(this, "Hello Toast!", Toast.LENGTH_SHORT).show();
    }

    public void increase_count(View view) {
        mCount++;
        updateUI();
    }

    public void show_zero(View view) {
        mCount = 0;
        updateUI();
    }

    private void updateUI() {
        mShowCount.setText(String.valueOf(mCount));

        int zeroColor = (mCount == 0) ? R.color.gray : R.color.orange;
        mButtonZero.setBackgroundTintList(ColorStateList.valueOf(
                ContextCompat.getColor(this, zeroColor)));

        int countColor = (mCount % 2 == 0) ? R.color.blue : R.color.green;
        mButtonCount.setBackgroundTintList(ColorStateList.valueOf(
                ContextCompat.getColor(this, countColor)));
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("count", mCount);
    }
}