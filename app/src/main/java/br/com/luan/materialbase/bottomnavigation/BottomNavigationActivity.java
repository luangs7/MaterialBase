package br.com.luan.materialbase.bottomnavigation;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.Toast;

import br.com.luan.materialbase.R;

public class BottomNavigationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_navigation);

        BottomNavigationView bottomNavigationView = (BottomNavigationView)
                findViewById(R.id.bottom_navigation);

        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.action_favorites:
                                Toast.makeText(BottomNavigationActivity.this, "Item 1", Toast.LENGTH_SHORT).show();
                                break;
                            case R.id.action_schedules:
                                Toast.makeText(BottomNavigationActivity.this, "Item 2", Toast.LENGTH_SHORT).show();
                                break;
                            case R.id.action_music:
                                Toast.makeText(BottomNavigationActivity.this, "Item 3", Toast.LENGTH_SHORT).show();
                                break;
                        }
                        return true;
                    }
                });
    }
}
