package com.andreldm.candidatus;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;

import com.andreldm.candidatus.adapter.CustomPagerAdapter;

import java.util.List;
import java.util.Vector;

public class MainActivity extends FragmentActivity {

    private ViewPager mViewPager;
    private CustomPagerAdapter mCustomPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.initPaging();
    }

    private void initPaging() {
        List<Fragment> fragments = new Vector<Fragment>();
        fragments.add(Fragment.instantiate(this, PesquisaFragment.class.getName()));
        fragments.add(Fragment.instantiate(this, Pesquisa2Fragment.class.getName()));
        mCustomPagerAdapter  = new CustomPagerAdapter(super.getSupportFragmentManager(), fragments);

        ViewPager pager = (ViewPager)super.findViewById(R.id.pager);
        pager.setAdapter(mCustomPagerAdapter);
    }

}
