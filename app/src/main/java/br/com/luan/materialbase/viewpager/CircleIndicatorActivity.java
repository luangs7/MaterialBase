package br.com.luan.materialbase.viewpager;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.gigamole.infinitecycleviewpager.HorizontalInfiniteCycleViewPager;

import java.util.ArrayList;
import java.util.List;

import br.com.luan.materialbase.R;
import me.relex.circleindicator.CircleIndicator;

public class CircleIndicatorActivity extends AppCompatActivity {

    protected ViewPager pager;
    protected CircleIndicator indicator;
    protected HorizontalInfiniteCycleViewPager list;
    IndicatorAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_circle_indicator);
        initView();
    }

    private void initView() {
        pager = (ViewPager) findViewById(R.id.pager);
        indicator = (CircleIndicator) findViewById(R.id.indicator);
        list = (HorizontalInfiniteCycleViewPager) findViewById(R.id.list);
        List<String> stringList = new ArrayList<>();
        stringList.add("a");
        stringList.add("b");
        stringList.add("c");
        stringList.add("d");
        stringList.add("e");

        adapter = new IndicatorAdapter(this,stringList);

        list.setScrollDuration(500);
        list.setAdapter(adapter);
        list.setMediumScaled(true);
        list.setMaxPageScale(0.8F);
        list.setMinPageScale(0.5F);
        list.setCenterPageScaleOffset(30.0F);
        list.setMinPageScaleOffset(5.0F);



    }

    @Override
    public void onBackPressed() {
        Toast.makeText(this, String.valueOf(list.getRealItem()), Toast.LENGTH_SHORT).show();
        super.onBackPressed();
    }
}
