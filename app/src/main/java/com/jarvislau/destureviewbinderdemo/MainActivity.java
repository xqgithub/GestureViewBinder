package com.jarvislau.destureviewbinderdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.jarvislau.destureviewbinder.GestureViewBinder;

/**
 * 手势放大或者缩小、平移
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final RelativeLayout targetView = findViewById(R.id.targetView);
        RelativeLayout groupView = findViewById(R.id.groupView);
        final ImageView iv_test = findViewById(R.id.iv_test);
        TextView tv_test = findViewById(R.id.tv_test);


        targetView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "targetView", Toast.LENGTH_SHORT).show();
            }
        });

        iv_test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "iv_test", Toast.LENGTH_SHORT).show();
            }
        });

        tv_test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iv_test.setClickable(false);
            }
        });


        final GestureViewBinder bind = GestureViewBinder.bind(this, groupView, targetView);
        bind.setFullGroup(true);
        bind.setOnScaleListener(new GestureViewBinder.OnScaleListener() {
            @Override
            public void onScale(float scale) {
//                Log.i("TAG", scale + "");
            }

            @Override
            public void isScaleEnd(boolean isScaleEnd) {
                Log.i("TAG", "isScaleEnd =-= " + isScaleEnd);
            }
        });

    }

}