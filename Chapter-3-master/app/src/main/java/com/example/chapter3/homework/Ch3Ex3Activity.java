package com.example.chapter3.homework;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;
import java.util.List;
import java.util.ArrayList;


/**
 * 使用 ViewPager 和 Fragment 做一个简单版的好友列表界面
 * 1. 使用 ViewPager 和 Fragment 做个可滑动界面
 * 2. 使用 TabLayout 添加 Tab 支持
 * 3. 对于好友列表 Fragment，使用 Lottie 实现 Loading 效果，在 5s 后展示实际的列表，要求这里的动效是淡入淡出
 */
public class Ch3Ex3Activity extends AppCompatActivity {

    private List<Fragment> list;
    private ViewPager myViewPager;
    private TabFragmentPagerAdapter adapter;

    private TextView  text_Control;
    private TextView  text_Oversee;
    private TextView  text_connectDevice;
    private TextView  topTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ch3ex3);
        initView();



        // TODO: ex3-1. 添加 ViewPager 和 Fragment 做可滑动界面



        // TODO: ex3-2, 添加 TabLayout 支持 Tab
    }

    public class TabFragmentPagerAdapter extends FragmentPagerAdapter {
        private FragmentManager mfragmentManager;
        private List<Fragment> mlist;


        public TabFragmentPagerAdapter(FragmentManager fm, List<Fragment> list) {
            super(fm);
            this.mlist = list;
        }

        @Override
        public void setPrimaryItem(ViewGroup container, int position, Object object) {
            super.setPrimaryItem(container, position, object);
        }

        @Override
        public Fragment getItem(int arg0) {
            return mlist.get(arg0);//显示第几个页面
        }

        @Override
        public int getCount() {
            return mlist.size();//有几个页面
        }
    }

    private void initView()
    {
        text_Control=(TextView)  findViewById(R.id.textView_control ) ;
        text_Oversee =(TextView)  findViewById(R.id.textView_oversee ) ;
        text_connectDevice =(TextView)  findViewById(R.id.textView_connectDevice  ) ;

        myViewPager = (ViewPager) findViewById(R.id.myViewPager);
        //绑定点击事件
        myViewPager.setOnPageChangeListener(new MyPagerChangeListener()) ;
        //把Fragment添加到List集合里面
        list = new ArrayList<>();
        list.add(new Fragment1() );
        list.add(new Fragment2() );
        list.add(new Fragment3() );
        adapter = new TabFragmentPagerAdapter(getSupportFragmentManager(), list);
        myViewPager.setAdapter(adapter);
        myViewPager.setCurrentItem(1);  //初始化显示第一个页面

    }

    public class MyPagerChangeListener implements ViewPager.OnPageChangeListener {

        @Override
        public void onPageScrollStateChanged(int arg0) {
        }

        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2) {
        }

        @Override
        public void onPageSelected(int arg0) {
            switch (arg0) {//字体颜色改变
                case 0:
                    text_Control  .setTextColor(Color.GREEN  );
                    text_Oversee  .setTextColor(Color.BLACK );
                    text_connectDevice   .setTextColor(Color.BLACK );
                    break;
                case 1:
                    text_Control .setTextColor(Color.BLACK );
                    text_Oversee .setTextColor(Color.GREEN );
                    text_connectDevice  .setTextColor(Color.BLACK );
                    break;
                case 2:
                    text_Control .setTextColor(Color.BLACK );
                    text_Oversee .setTextColor(Color.BLACK  );
                    text_connectDevice  .setTextColor(Color.GREEN );
                    break;
            }

        }

    }

}
