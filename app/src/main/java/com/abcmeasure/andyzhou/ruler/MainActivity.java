package com.abcmeasure.andyzhou.ruler;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;

import com.abcmeasure.andyzhou.ruler.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private final String TAG = MainActivity.class.getSimpleName();
    RecyclerView mRecyclerView;
    RulerRecyclerAdapter recyclerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        DisplayMetrics metrics = getResources().getDisplayMetrics();
        binding.setTouchPanelModel(new TouchPanelViewModel(metrics.xdpi));
        recyclerAdapter = new RulerRecyclerAdapter(100, metrics.xdpi);
        mRecyclerView = (RecyclerView) findViewById(R.id.rv_ruler);
        if (mRecyclerView != null) {
            mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        mRecyclerView.setAdapter(recyclerAdapter);
    }
}
