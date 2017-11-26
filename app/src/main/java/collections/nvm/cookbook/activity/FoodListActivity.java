package collections.nvm.cookbook.activity;

import android.content.Intent;
import android.graphics.Color;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import collections.nvm.cookbook.adapter.FoodListAdapter;
import collections.nvm.cookbook.utils.Item;
import collections.nvm.cookbook.R;
import collections.nvm.cookbook.listener.FoodItemClickListener;

public class FoodListActivity extends AppCompatActivity implements FoodItemClickListener,
        SwipeRefreshLayout.OnRefreshListener {
    private RecyclerView mStaggeredGridView;
    private FoodListAdapter fa;
    private SwipeRefreshLayout srlRefresh;
    private NavigationView nvDrawer;
    private DrawerLayout dlDrawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_list);

        setTitle("Lorem ipsum dela vega simo");
        setTitleColor(Color.WHITE);

        mStaggeredGridView = (RecyclerView) findViewById(R.id.mStaggeredGridView);
        srlRefresh = (SwipeRefreshLayout) findViewById(R.id.srlRefresh);
        nvDrawer = (NavigationView) findViewById(R.id.nvDrawer);
        dlDrawer = (DrawerLayout) findViewById(R.id.dlDrawer);

        setupDrawerContent(nvDrawer);
        srlRefresh.setOnRefreshListener(this);

        String[] titles = {"Lẩu cá bống", "Cơm chiên dương châu",
                "Gà tiềm thuốc bắc", "Tàu hũ chiên nước mắm",
                "Cháo gà Cao Lãnh", "Lẩu cá diêu hồng", "Mực xào xả ớt", "Giả cầy",
                "Pizza", "Trà sữa 3k", "Lẩu cá bống", "Cơm chiên dương châu",
                "Gà tiềm thuốc bắc", "Tàu hũ chiên nước mắm",
                "Cháo gà Cao Lãnh", "Lẩu cá diêu hồng", "Mực xào xả ớt", "Giả cầy",
                "Pizza", "Trà sữa 3k"};

        String[] contents = {"http://imageshack.com/a/img924/3642/yfkjtE.jpg",
                "http://imageshack.com/a/img922/5923/Ry1rSU.png",
                "http://imageshack.com/a/img924/3707/x60RKa.png",
                "http://imageshack.com/a/img924/3707/x60RKa.png",
                "http://imageshack.com/a/img924/5632/avsdDq.jpg",
                "http://imageshack.com/a/img923/2899/wVcdrE.png",
                "http://imageshack.com/a/img924/3642/yfkjtE.jpg",
                "http://imageshack.com/a/img922/5923/Ry1rSU.png",
                "http://imageshack.com/a/img924/3707/x60RKa.png",
                "http://imageshack.com/a/img924/3707/x60RKa.png",
                "http://imageshack.com/a/img924/5632/avsdDq.jpg",
                "http://imageshack.com/a/img923/2899/wVcdrE.png",
                "http://imageshack.com/a/img924/3642/yfkjtE.jpg",
                "http://imageshack.com/a/img922/5923/Ry1rSU.png",
                "http://imageshack.com/a/img924/3707/x60RKa.png",
                "http://imageshack.com/a/img924/3707/x60RKa.png",
                "http://imageshack.com/a/img924/5632/avsdDq.jpg",
                "http://imageshack.com/a/img923/2899/wVcdrE.png",
                "http://imageshack.com/a/img924/3642/yfkjtE.jpg",
                "http://imageshack.com/a/img922/5923/Ry1rSU.png",
        };

        Boolean[] newList = {true, false, true,
                true, false, true,
                false, false, true,
                false, true, true,
                false, true, false,
                false, true, false,
                false, false, true,
                false, true, true,
                false, true, false,};

        List<Item> items = new ArrayList<>();
        for (int i = 0; i < titles.length; i++) {
//            Drawable d = getResources().getAvatar(R.drawable.hamburger);
            items.add(new Item(titles[i], contents[i], newList[i]));

//            Drawable d2 = getResources().getAvatar(R.drawable.pasta);
//            items.add(new Item(titles[i], contents[i], false));
        }

        fa = new FoodListAdapter(this, items, this);

        StaggeredGridLayoutManager sglm = new StaggeredGridLayoutManager(3, LinearLayoutManager.VERTICAL);

        mStaggeredGridView.setHasFixedSize(true);
        mStaggeredGridView.setAdapter(fa);
        mStaggeredGridView.setLayoutManager(sglm);
    }

    @Override
    public void onRefresh() {
        //        refresh here
        this.fa.notifyDataSetChanged();
        this.srlRefresh.setRefreshing(false);
    }

    @Override
    public void onClickListener(Item i) {
        // intend here
        Toast.makeText(this, i.getTitle() + i.getImageUrl(), Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, DetailActivity.class);

        intent.putExtra("name", i.getTitle());
        intent.putExtra("url", i.getImageUrl());
        intent.putExtra("hot", i.getHotFood());
        startActivity(intent);
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);

    }

    public void setupDrawerContent(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                selectDrawerItem(item);
                return true;
            }
        });
    }

    private void selectDrawerItem(MenuItem item) {
        Fragment fragment = null;

        Class FragmentClass = null;
        switch (item.getItemId()) {
            case R.id.menu_aboutUs:
//                FragmentClass = SouthParkFragment.class;
                Intent i = new Intent(FoodListActivity.this, AboutActivity.class);
                startActivity(i);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                break;
            case R.id.menu_exit:
//                FragmentClass = FamilyGuyFragment.class;
                System.exit(0);
                break;
        }
        try {
            fragment = (Fragment) FragmentClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }


        dlDrawer.closeDrawers();
    }
}
