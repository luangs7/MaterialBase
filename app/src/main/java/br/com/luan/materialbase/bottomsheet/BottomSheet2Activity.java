package br.com.luan.materialbase.bottomsheet;

import android.os.Bundle;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

import br.com.luan.materialbase.R;

import static br.com.luan.materialbase.bottomsheet.BottomSheetActivity.setMargins;

public class BottomSheet2Activity extends AppCompatActivity implements View.OnClickListener {
    protected Button button1;
    protected Button button2;
    protected Button button3;
    protected NestedScrollView bottomSheet;
    protected CoordinatorLayout mainContent;
    private BottomSheetBehavior mBottomSheetBehavior;
    private Menu menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_bottom_sheet);
        initView();
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.button_1) {
            mBottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
        }
    }

    private void initView() {
        final Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        button1 = (Button) findViewById(R.id.button_1);
        button1.setOnClickListener(BottomSheet2Activity.this);

        bottomSheet = (NestedScrollView) findViewById(R.id.bottom_sheet);
        mainContent = (CoordinatorLayout) findViewById(R.id.main_content);

        mBottomSheetBehavior = BottomSheetBehavior.from(bottomSheet);

        mBottomSheetBehavior.setPeekHeight(200);
        mBottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);




        mBottomSheetBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(View bottomSheet, int newState) {
                if (newState == BottomSheetBehavior.STATE_COLLAPSED) {
                    mBottomSheetBehavior.setPeekHeight(200);

                }else
                    setMargins(bottomSheet,0,0,0,0);
            }

            @Override
            public void onSlide(View bottomSheet, float slideOffset) {
            }
        });


    }



}
