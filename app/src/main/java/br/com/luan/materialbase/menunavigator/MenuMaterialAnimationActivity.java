package br.com.luan.materialbase.menunavigator;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import br.com.luan.materialbase.R;


public class MenuMaterialAnimationActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    protected Toolbar toolbar;
    protected TabLayout tabLayout;
    protected TextView textView2;
    protected NavigationView navView;
    protected DrawerLayout drawerLayout;
    protected View contentView;
    private static final float END_SCALE = 0.7f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_menu_material);
        initView();
    }

    private void initView() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        textView2 = (TextView) findViewById(R.id.textView2);
        navView = (NavigationView) findViewById(R.id.nav_view);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        contentView =  findViewById(R.id.content);


        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.setDrawerListener(toggle);
        toggle.syncState();


        drawerLayout.setScrimColor(getResources().getColor(android.R.color.transparent));
        drawerLayout.setElevation(0f);
        drawerLayout.setScrimColor(Color.TRANSPARENT);
        drawerLayout.addDrawerListener(new DrawerLayout.SimpleDrawerListener() {
                                           @Override
                                           public void onDrawerSlide(View drawerView, float slideOffset) {

                                               // Scale the View based on current slide offset
                                               final float diffScaledOffset = slideOffset * (1 - END_SCALE);
                                               final float offsetScale = 1 - diffScaledOffset;
                                               contentView.setScaleX(offsetScale);
                                               contentView.setScaleY(offsetScale);

                                               // Translate the View, accounting for the scaled width
                                               final float xOffset = drawerView.getWidth() * slideOffset;
                                               final float xOffsetDiff = contentView.getWidth() * diffScaledOffset / 2;
                                               final float xTranslation = xOffset - xOffsetDiff;
                                               contentView.setTranslationX(xTranslation);
                                               contentView.setBackgroundColor(Color.parseColor("#000000"));
                                           }

                                           @Override
                                           public void onDrawerClosed(View drawerView) {
                                           }
                                       }
        );
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return false;
    }
}
