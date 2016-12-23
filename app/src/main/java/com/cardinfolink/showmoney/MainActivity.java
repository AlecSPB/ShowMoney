package com.cardinfolink.showmoney;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.cardinfolink.showmoney.about.AboutFragment;
import com.cardinfolink.showmoney.base.BaseFragment;
import com.cardinfolink.showmoney.main.KeyboardFragment;
import com.cardinfolink.showmoney.orders.OrdersFragment;
import com.cardinfolink.showmoney.refund.RefundFragment;
import com.cardinfolink.showmoney.settings.SettingsFragment;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, DrawerLayout.DrawerListener {

    private DrawerLayout drawer;
    private KeyboardFragment keyboardFragment;
    private RefundFragment refundFragment;
    private OrdersFragment ordersFragment;
    private SettingsFragment settingsFragment;
    private AboutFragment aboutFragment;

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
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        MenuItem item = navigationView.getMenu().findItem(R.id.nav_get_money);
        handleItemSelected(item);

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        handleItemSelected(item);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)){
            drawer.closeDrawer(GravityCompat.START);
        }else if (drawer.isDrawerOpen(GravityCompat.END)){
            drawer.closeDrawer(GravityCompat.END);
        }
        return true;
    }

    private void handleItemSelected(MenuItem item) {
        if (item == null) {
            return;
        }
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        BaseFragment currentFragment = null;
        String tag = "";
        String title = getString(R.string.app_name);
        switch (item.getItemId()) {
            case R.id.nav_get_money:
                tag = KeyboardFragment.class.getSimpleName();
                if (keyboardFragment == null) {
                    keyboardFragment = new KeyboardFragment();
                }
                currentFragment = keyboardFragment;
                title = getString(R.string.str_get_money);
                break;
            case R.id.nav_refund:
                tag = RefundFragment.class.getSimpleName();
                if (refundFragment == null) {
                    refundFragment = new RefundFragment();
                }
                currentFragment = refundFragment;
                title = getString(R.string.str_reund);
                break;
            case R.id.nav_orders:
                tag = OrdersFragment.class.getSimpleName();
                if (ordersFragment == null) {
                    ordersFragment = new OrdersFragment();
                }
                currentFragment = ordersFragment;
                title = getString(R.string.str_orders);
                break;
            case R.id.nav_settings:
                tag = SettingsFragment.class.getSimpleName();
                if (settingsFragment == null) {
                    settingsFragment = new SettingsFragment();
                }
                currentFragment = settingsFragment;
                title = getString(R.string.str_settings);
                break;
            case R.id.nav_about:
                tag = AboutFragment.class.getSimpleName();
                if (aboutFragment == null) {
                    aboutFragment = new AboutFragment();
                }
                currentFragment = aboutFragment;
                title = getString(R.string.str_about);
                break;
            default:
                break;
        }
        transaction.replace(R.id.fl_content, currentFragment, tag);
//        transaction.addToBackStack(tag);
        transaction.commit();
        item.setChecked(true);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(title);
        }
    }

    @Override
    public void onDrawerSlide(View drawerView, float slideOffset) {
        View mContent = drawer.getChildAt(0);
        float scale = 1 - slideOffset;
        if (drawerView.getTag().equals("START")) {
            //设置菜单透明度
            drawerView.setAlpha(0.6f + 0.4f * (1 - scale));
            //在滑动时内容界面的宽度为 屏幕宽度减去菜单界面所占宽度
            mContent.setTranslationX(drawerView.getMeasuredWidth() * (1 - scale));
            //设置内容界面操作无效（比如有button就会点击无效）
            mContent.invalidate();
        } else if (drawerView.getTag().equals("END")) {
            drawerView.setAlpha(0.6f + 0.4f * (1 - scale));
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
}
