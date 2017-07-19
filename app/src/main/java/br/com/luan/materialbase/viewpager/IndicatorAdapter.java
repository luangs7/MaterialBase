package br.com.luan.materialbase.viewpager;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import br.com.luan.materialbase.R;


/**
 * Created by DevMaker on 3/16/16.
 */
public class IndicatorAdapter  extends PagerAdapter {

    private final Context mContext;
    private List<String> String;
    private LayoutInflater mLayoutInflater;


    public IndicatorAdapter(final Context context, List<String> mList) {
        mContext = context;
        mLayoutInflater = LayoutInflater.from(context);
        this.String = mList;
    }

    @Override
    public int getCount() {
        return String.size();
    }

    @Override
    public int getItemPosition(final Object object) {
        return POSITION_NONE;
    }

    @Override
    public Object instantiateItem(final ViewGroup container, final int position) {
        final View view;

            view = mLayoutInflater.inflate(R.layout.adapter_indicator, container, false);
            //setupItem(view, String.get(position));


        container.addView(view);
        return view;
    }

    @Override
    public boolean isViewFromObject(final View view, final Object object) {
        return view.equals(object);
    }

    @Override
    public void destroyItem(final ViewGroup container, final int position, final Object object) {
        container.removeView((View) object);
    }

}
