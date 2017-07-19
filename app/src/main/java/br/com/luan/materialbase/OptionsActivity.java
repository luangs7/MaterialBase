package br.com.luan.materialbase;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import br.com.luan.materialbase.bottomnavigation.BottomNavigationActivity;
import br.com.luan.materialbase.bottomsheet.BottomSheetActivity;
import br.com.luan.materialbase.menunavigator.MenuMaterialAnimationActivity;
import br.com.luan.materialbase.parallax.Parallax1Activity;
import br.com.luan.materialbase.viewpager.CircleIndicatorActivity;

public class OptionsActivity extends AppCompatActivity implements View.OnClickListener {

    protected Button parallax;
    protected Button navigator;
    protected Button tabs;
    protected Button bottom;
    protected Button bottomsheet;

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
            mStartActivity(new MenuMaterialAnimationActivity());
        }else if (view.getId() == R.id.tabs) {
            mStartActivity(new  CircleIndicatorActivity());
        }else if (view.getId() == R.id.bottom) {
            mStartActivity(new BottomNavigationActivity());
        }else if (view.getId() == R.id.bottomsheet) {
            mStartActivity(new BottomSheetActivity());
        }
//        else if (view.getId() == R.id.print) {
//            print();
//        }
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
        bottomsheet = (Button) findViewById(R.id.bottomsheet);
        bottomsheet.setOnClickListener(OptionsActivity.this);

    }


    public void mStartActivity(Activity mActivity){
        Intent intent = new Intent(getBaseContext(),mActivity.getClass());
        startActivity(intent,
                ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
    }


    public void print(){
        try
        {
            Socket sock = new Socket("192.168.1.222", 9100);
            PrintWriter oStream = new PrintWriter(sock.getOutputStream());
            oStream.println("HI,test from Android Device");
            oStream.println("\n\n\n");
            oStream.close();
            sock.close();
        }
        catch (UnknownHostException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
