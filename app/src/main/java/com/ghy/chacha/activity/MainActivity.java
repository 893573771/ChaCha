package com.ghy.chacha.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.widget.Toast;

import com.ghy.baseapp.base.AbsBaseActivity;
import com.ghy.baseapp.component.slidingmenu.SlidingMenu;
import com.ghy.baseapp.view.MyTabView;
import com.ghy.chacha.R;
import com.ghy.chacha.fragment.PagerFragment1;
import com.ghy.chacha.fragment.PagerFragment2;
import com.ghy.chacha.fragment.PagerFragment3;

import java.util.ArrayList;
import java.util.List;

/**
 * 主界面
 * 使用fragment+viewPager的导航Tab Activity
 */
public class MainActivity extends AbsBaseActivity {

    private String[] mTitle = {"首页", "查查", "我"};
    private int[] mIconSelect = {R.mipmap.tab_icon_home_select, R.mipmap.tab_icon_search_select2, R.mipmap.tab_icon_me_select};
    private int[] mIconNormal = {R.mipmap.tab_icon_home, R.mipmap.tab_icon_search, R.mipmap.tab_icon_me};
    private ViewPager mViewPager;
    private MyTabView mTabView;

    private List<Fragment> fragments;

    private SlidingMenu slidingMenu;

    @Override
    protected int getLayoutID() {
        return R.layout.main_activity;
    }

    @Override
    protected boolean isOpenToolBar() {
        return true;
    }

    @Override
    protected String getToolBarTitle() {
        return "知道吗";
    }

    @Override
    protected boolean isOpenToolBarLeftBack() {
        return false;
    }

    @Override
    protected int setToolBarRightType() {
        return TOOLBAR_RIGHT_TYPE_IV;
    }

    @Override
    protected int setToolBarRightIv() {
        return R.mipmap.user_setting;
    }

    @Override
    protected String setToolBarRightIvTitle() {
        return "设置";
    }

    @Override
    protected void init() {

        initFragment();
//        initSlidingMenu();

        initViewPager();

        setRightSettingClick();

    }

    /**
     * 右侧设置按钮图标点击事件
     */
    private void setRightSettingClick() {
        setOnToolBarRightIvClickListener(new ToolBarRightIvClickListener() {
            @Override
            public void onToolBarRightIvClick() {
                startActivity(MainActivity.this,SettingActivity.class);
            }
        });
    }

    /**
     * 初始化ViewPager
     */
    private void initViewPager() {
        mTabView = (MyTabView) findViewById(R.id.id_tab);
        mViewPager = (ViewPager) findViewById(R.id.id_view_pager);
        mViewPager.setAdapter(new PageAdapter(getSupportFragmentManager()));
        mViewPager.setOffscreenPageLimit(2);
        mTabView.setViewPager(mViewPager);
    }

    /**
     * 初始化侧滑菜单
     */
    private void initSlidingMenu() {
        slidingMenu = new SlidingMenu(this);
        slidingMenu.setMode(SlidingMenu.LEFT);
        slidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
        slidingMenu.setBehindOffsetRes(R.dimen.slidingmenu_offset);
        slidingMenu.setFadeDegree(0.35f);
        slidingMenu.attachToActivity(this, SlidingMenu.SLIDING_CONTENT);
        slidingMenu.setMenu(R.layout.layout_sliding_menu);
    }

    /**
     * 初始化fragment
     */
    private void initFragment() {
        fragments = new ArrayList<>();
        Fragment fragment1 = new PagerFragment1();
        fragments.add(fragment1);
        Fragment fragment2 = new PagerFragment2();
        fragments.add(fragment2);
        Fragment fragment3 = new PagerFragment3();
        fragments.add(fragment3);
    }

    /**
     * 适配器
     * FragmentPagerAdapter
     */
    class PageAdapter extends FragmentPagerAdapter implements MyTabView.OnItemIconTextSelectListener {

        public PageAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int[] onIconSelect(int position) {
            int icon[] = new int[2];
            icon[0] = mIconSelect[position];
            icon[1] = mIconNormal[position];
            return icon;
        }

        @Override
        public String onTextSelect(int position) {
            return mTitle[position];
        }

        @Override
        public int getCount() {
            return mTitle.length;
        }
    }

    private long firstClickTime;

    @Override
    public void onBackPressed() {
        if (firstClickTime + 2000 > System.currentTimeMillis()) {
            super.onBackPressed();
        } else {
            Toast.makeText(MainActivity.this, "再按一次退出应用", Toast.LENGTH_SHORT).show();
        }
        firstClickTime = System.currentTimeMillis();
    }

}
