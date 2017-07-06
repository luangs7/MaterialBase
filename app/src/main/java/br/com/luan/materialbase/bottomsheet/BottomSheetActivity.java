package br.com.luan.materialbase.bottomsheet;

import android.os.Bundle;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import br.com.luan.materialbase.R;

public class BottomSheetActivity extends AppCompatActivity implements View.OnClickListener {
    protected Button button1;
    protected Button button2;
    protected Button button3;
    protected NestedScrollView bottomSheet;
    protected CoordinatorLayout mainContent;
    private BottomSheetBehavior mBottomSheetBehavior;
    private Menu menu;
    Toolbar mToolbar;

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
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        button1 = (Button) findViewById(R.id.button_1);
        button1.setOnClickListener(BottomSheetActivity.this);

        bottomSheet = (NestedScrollView) findViewById(R.id.bottom_sheet);
        mainContent = (CoordinatorLayout) findViewById(R.id.main_content);

        mBottomSheetBehavior = BottomSheetBehavior.from(bottomSheet);

        mBottomSheetBehavior.setPeekHeight(200);
        mBottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);




        mBottomSheetBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(View bottomSheet, int newState) {
                if (newState == BottomSheetBehavior.STATE_COLLAPSED) {
                    mBottomSheetBehavior.setPeekHeight(100);
                    hideOption();
                }

                if (newState == BottomSheetBehavior.STATE_EXPANDED) {
                    showOption();
                }else
                    hideOption();

            }

            @Override
            public void onSlide(View bottomSheet, float slideOffset) {
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        this.menu = menu;
        getMenuInflater().inflate(R.menu.menu_scrolling, menu);
        hideOption();
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        } else if (id == R.id.action_info) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void hideOption() {

        mToolbar.setVisibility(View.GONE);
    }

    private void showOption() {
        mToolbar.setVisibility(View.VISIBLE);

    }

}
