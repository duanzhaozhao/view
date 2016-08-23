package com.example.viewpager_fragment;

import android.media.Image;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
ViewPager viewPager;
    ImageView line;
    int currentIndex,screenWidth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = (ViewPager) findViewById(R.id.pager);
        line = (ImageView) findViewById(R.id.id_tab_line_iv);
        MyAdapter myAdapter = new MyAdapter(getSupportFragmentManager());
        viewPager.setAdapter(myAdapter);
        initTabLineWidth();
        viewPager.setCurrentItem(0);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                LinearLayout.LayoutParams lp = (LinearLayout.LayoutParams) line.getLayoutParams();
                if ( currentIndex==0&&position == 0)//0-1
                {
                    Log.i("aaa","aaaa1");
                    lp.leftMargin = (int) (positionOffset * (screenWidth * 1.0 / 3) + currentIndex
                            * (screenWidth / 3));

                } else if (currentIndex == 1 && position == 0)//1-0
                {
                    Log.i("aaa","aaaa2");
                    lp.leftMargin = (int) (-(1 - positionOffset)
                            * (screenWidth * 1.0 / 3) + currentIndex
                            * (screenWidth / 3));

                } else if (currentIndex == 1 && position == 1)//1-2
                {
                    Log.i("aaa","aaaa3");
                    lp.leftMargin = (int) (positionOffset * (screenWidth * 1.0 / 3) + currentIndex
                            * (screenWidth / 3));
                }else if (currentIndex == 2 && position == 1) {//2-1
                    Log.i("aaa","aaaa4");
                    lp.leftMargin = (int) (-(1 - positionOffset)
                            * (screenWidth * 1.0 / 3) + currentIndex
                            * (screenWidth / 3));
                }

                line.setLayoutParams(lp);
            }

            @Override
            public void onPageSelected(int position) {

                currentIndex = position;
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    private class MyAdapter extends FragmentPagerAdapter {

        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            Log.i("position", String.valueOf(position));
            return MyFragment.newInstance(position);
        }

        @Override
        public int getCount() {
            return 3;
        }

    }

    /**
     * 设置滑动条的宽度为屏幕的1/3(根据Tab的个数而定)
     */
    private void initTabLineWidth() {
            DisplayMetrics dpMetrics = new DisplayMetrics();
            getWindow().getWindowManager().getDefaultDisplay()
                    .getMetrics(dpMetrics);
            screenWidth = dpMetrics.widthPixels;
            LinearLayout.LayoutParams lp = (LinearLayout.LayoutParams) line
                    .getLayoutParams();
            lp.width = screenWidth / 3;
            line.setLayoutParams(lp);
        }
    }