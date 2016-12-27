package com.cardinfolink.showmoney;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.cardinfolink.showmoney.base.BaseFragment;
import com.cardinfolink.showmoney.listener.OnFragmentResumeObservable;
import com.cardinfolink.showmoney.model.User;
import com.cardinfolink.showmoney.ui.about.AboutFragment;
import com.cardinfolink.showmoney.ui.main.KeyboardFragment;
import com.cardinfolink.showmoney.ui.main.LeftMenuFragment;
import com.cardinfolink.showmoney.ui.main.RightMenuFragment;
import com.cardinfolink.showmoney.ui.orders.OrdersFragment;
import com.cardinfolink.showmoney.ui.orders.SearchFragment;
import com.cardinfolink.showmoney.ui.refund.RefundFragment;
import com.cardinfolink.showmoney.ui.settings.SettingsFragment;
import com.cardinfolink.showmoney.util.AnimatedFragmentWrapper;

import java.util.Locale;

public class MainActivity extends AppCompatActivity
        implements DrawerLayout.DrawerListener, LeftMenuFragment.OnLeftMenuSelectedListener,
        OnFragmentResumeObservable {

    private DrawerLayout drawer;
    private KeyboardFragment keyboardFragment;
    private RefundFragment refundFragment;
    private OrdersFragment ordersFragment;
    private SettingsFragment settingsFragment;
    private AboutFragment aboutFragment;

    private User user;

    BaseFragment nextShowFragment, showingFragment;

    TextView tvTitle, tvRightMenu;
    ImageView ivUserIcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.addDrawerListener(this);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

//        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
//        navigationView.setNavigationItemSelectedListener(this);
//        MenuItem item = navigationView.getMenu().findItem(R.id.nav_get_money);
//        handleItemSelected(item);

        initTitle();
        initMenus();
    }

    private void initTitle() {
        tvTitle = (TextView) findViewById(R.id.tv_title);
        tvRightMenu = (TextView) findViewById(R.id.tv_right_menu);
        ivUserIcon = (ImageView) findViewById(R.id.iv_user_icon);
    }

    private void initMenus() {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fl_left, new LeftMenuFragment(), "START");
        transaction.replace(R.id.fl_right, new RightMenuFragment(), "END");
        transaction.commit();
        user = new User();
        user.setStoreAssistId("10000000000000000001");
        user.setUserStoreId("0010");
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else if (drawer.isDrawerOpen(GravityCompat.END)) {
            drawer.closeDrawer(GravityCompat.END);
        } else {
            int backStackEntryCount = getSupportFragmentManager().getBackStackEntryCount();
            if (backStackEntryCount >= 1) {
                super.onBackPressed();
                backToOriginStatue();
            } else {
                super.onBackPressed();
            }

        }
    }

    /**
     * 从开启的Fragment回到原类的状态
     */
    private void backToOriginStatue() {
        if (nextShowFragment == null) {
            return;
        }
        getSupportFragmentManager().beginTransaction().show(nextShowFragment).commit();
        int item = -1;
        String title = "";
        if (nextShowFragment instanceof KeyboardFragment) {
            item = 0;
            title = getString(R.string.str_get_money);
        } else if (nextShowFragment instanceof RefundFragment) {
            item = 1;
            title = getString(R.string.str_reund);
            setActionBar(getString(R.string.str_reund), false);
        } else if (nextShowFragment instanceof OrdersFragment) {
            item = 2;
            title = getString(R.string.str_orders);
        } else if (nextShowFragment instanceof SettingsFragment) {
            item = 3;
            title = getString(R.string.str_settings);
        } else if (nextShowFragment instanceof AboutFragment) {
            item = 4;
            title = getString(R.string.str_about);
        }
        setActionBar(title, false);
        setRightInfo(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_user || id == R.id.show_right) {
            drawer.openDrawer(GravityCompat.END);
            return true;
        } else if (id == android.R.id.home) {
            onBackPressed();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onDrawerSlide(View drawerView, float slideOffset) {
        View mContent = drawer.getChildAt(0);
        float scale = 1 - slideOffset;
        if (drawerView.getTag().equals("START")) {
            //设置菜单透明度
//            drawerView.setAlpha(0.6f + 0.4f * (1 - scale));
            //在滑动时内容界面的宽度为 屏幕宽度减去菜单界面所占宽度
            mContent.setTranslationX(drawerView.getMeasuredWidth() * (1 - scale));
            //设置内容界面操作无效（比如有button就会点击无效）
            mContent.invalidate();
        } else if (drawerView.getTag().equals("END")) {
//            drawerView.setAlpha(0.6f + 0.4f * (1 - scale));
            //在滑动时内容界面的宽度为 屏幕宽度减去菜单界面所占宽度
            mContent.setTranslationX(-drawerView.getMeasuredWidth() * (1 - scale));
            //设置内容界面操作无效（比如有button就会点击无效）
            mContent.invalidate();
        }
    }

    @Override
    public void onDrawerOpened(View drawerView) {
    }

    @Override
    public void onDrawerClosed(View drawerView) {
    }

    @Override
    public void onDrawerStateChanged(int newState) {

    }

    @Override
    public void onMenuItemSelected(View view, int position) {
        handleItemSelected(position);
    }

    private void handleItemSelected(int item) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        String tag = "";
        String title = getString(R.string.app_name);
        drawer.closeDrawer(GravityCompat.START);

        switch (item) {
            case 0:
                tag = KeyboardFragment.class.getSimpleName();
                if (keyboardFragment == null) {
                    keyboardFragment = new KeyboardFragment();
                }
                nextShowFragment = keyboardFragment;
                title = getString(R.string.str_get_money);
                break;
            case 1:
                tag = RefundFragment.class.getSimpleName();
                if (refundFragment == null) {
                    refundFragment = new RefundFragment();
                }
                nextShowFragment = refundFragment;
                title = getString(R.string.str_reund);
                break;
            case 2:
                tag = OrdersFragment.class.getSimpleName();
                if (ordersFragment == null) {
                    ordersFragment = new OrdersFragment();
                }
                nextShowFragment = ordersFragment;
                title = getString(R.string.str_orders);
                break;
            case 3:
                tag = SettingsFragment.class.getSimpleName();
                if (settingsFragment == null) {
                    settingsFragment = new SettingsFragment();
                }
                nextShowFragment = settingsFragment;
                title = getString(R.string.str_settings);
                break;
            case 4:
                tag = AboutFragment.class.getSimpleName();
                if (aboutFragment == null) {
                    aboutFragment = new AboutFragment();
                }
                nextShowFragment = aboutFragment;
                title = getString(R.string.str_about);
                break;
            default:
                break;
        }

        setRightInfo(item);

        new AnimatedFragmentWrapper(transaction)
                .replace(R.id.fl_content, nextShowFragment, tag)
                .show(nextShowFragment)
                .commit();

        clearBackStack();
        setActionBar(title, false);
        showingFragment = nextShowFragment;
    }

    private void setRightInfo(int item) {
        View.OnClickListener onClickListener = null;


        switch (item) {
            case 0:
                tvRightMenu.setText(String.format(Locale.getDefault(), "%s%n%s", "", user.getUserStoreId()));
                ivUserIcon.setImageResource(R.drawable.ic_menu_share);
                onClickListener = new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        drawer.openDrawer(Gravity.END);
                    }
                };
                break;
            case 1:
                tvRightMenu.setText(null);
                ivUserIcon.setImageDrawable(null);
                onClickListener = null;
                break;
            case 2:
                tvRightMenu.setText(null);
                ivUserIcon.setImageResource(R.mipmap.ic_modify);
                onClickListener = new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        SearchFragment searchFragment = new SearchFragment();

                        new AnimatedFragmentWrapper(getSupportFragmentManager().beginTransaction())
                                .setCustomAnims(R.anim.slide_right_enter, R.anim.slide_left_exit)
                                .add(R.id.fl_content, searchFragment, SearchFragment.class.getSimpleName())
                                .addToBackStack(SearchFragment.class.getSimpleName())
                                .commit();
                        setRightInfo(6);
                    }
                };
                break;
            case 3:
                tvRightMenu.setText(null);
                ivUserIcon.setImageDrawable(null);
                onClickListener = null;
                break;
            case 4:
                tvRightMenu.setText(null);
                ivUserIcon.setImageDrawable(null);
                onClickListener = null;
                break;
            default:
                tvRightMenu.setText(null);
                ivUserIcon.setImageDrawable(null);
                onClickListener = null;
                break;
        }
        tvRightMenu.setOnClickListener(onClickListener);
        ivUserIcon.setOnClickListener(onClickListener);
    }


    /**
     * 清除回退栈
     */
    private void clearBackStack() {
        while (getSupportFragmentManager().getBackStackEntryCount() > 0) {
            super.onBackPressed();
        }
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }


    private void addNewFragment(Fragment fragment, String tag) {
        if (fragment == null) {
            return;
        }
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        new AnimatedFragmentWrapper(transaction)
                .hide(showingFragment)
                .setCustomAnims(R.anim.slide_right_enter, R.anim.slide_left_exit, R.anim.slide_left_enter, R.anim.slide_right_exit)
                .add(R.id.fl_content, fragment, tag)
                .addToBackStack(tag)
                .commit();
    }

    /**
     * 添加新的Fragment后修改Toolbar内容
     *
     * @param title
     * @param showBackIcon
     */
    @Override
    public void update(String title, boolean showBackIcon) {
        setActionBar(title, showBackIcon);
    }

    public void setActionBar(String title, boolean showBackIcon) {
        if (tvTitle != null) {
            tvTitle.setText(title);
        }
//
//        if (getSupportActionBar() != null) {
//            getSupportActionBar().setTitle(title);
//        }
    }


}
