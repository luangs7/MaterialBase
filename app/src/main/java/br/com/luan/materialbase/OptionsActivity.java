package br.com.luan.materialbase;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import br.com.luan.materialbase.bottomnavigation.BottomNavigationActivity;
import br.com.luan.materialbase.menunavigator.MenuMaterialActivity;
import br.com.luan.materialbase.parallax.Parallax1Activity;
import br.com.luan.materialbase.tablayout.TabsActivity;

public class OptionsActivity extends AppCompatActivity implements View.OnClickListener {

    protected Button parallax;
    protected Button navigator;
    protected Button tabs;
    protected Button bottom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_options);
        initView();
    }


    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.parallax) {
            mStartActivity(new Parallax1Activity());
        } else if (view.getId() == R.id.navigator) {
            mStartActivity(new MenuMaterialActivity());
        }else if (view.getId() == R.id.tabs) {
            mStartActivity(new TabsActivity());
        }else if (view.getId() == R.id.bottom) {
            mStartActivity(new BottomNavigationActivity());
        }
    }

    private void initView() {
        parallax = (Button) findViewById(R.id.parallax);
        parallax.setOnClickListener(OptionsActivity.this);
        navigator = (Button) findViewById(R.id.navigator);
        tabs = (Button) findViewById(R.id.tabs);
        tabs.setOnClickListener(OptionsActivity.this);
        navigator.setOnClickListener(OptionsActivity.this);
        bottom = (Button) findViewById(R.id.bottom);
        bottom.setOnClickListener(OptionsActivity.this);

    }


    public void mStartActivity(Activity mActivity){
        Intent intent = new Intent(getBaseContext(),mActivity.getClass());
        startActivity(intent,
                ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
    }
}
