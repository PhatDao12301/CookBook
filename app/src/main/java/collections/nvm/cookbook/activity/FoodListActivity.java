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
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import collections.nvm.cookbook.adapter.FoodListAdapter;
import collections.nvm.cookbook.utils.FoodItem;
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
    ///////////////////////////////////////////////////////////////////////////
    private static final String ITEM_AVATAR = "avatar";
    private static final String ITEM_NAME = "name";
    private static final String ITEM_IMAGES = "images";
    private static final String ITEM_GUIDELINE = "guideline";
    private static final String ITEM_INGREDIENT = "ingredient";
    private static final String ITEM_ID = "id";

    private FirebaseAuth mFirebaseAuth;
    private DatabaseReference myRef;
    private List<FoodItem> foodList = new ArrayList<>();

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

        FirebaseDatabase.getInstance().setPersistenceEnabled(true); // enable store data on disk
        // Write a message to the database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("data");
        foodList = new ArrayList<>();
        // Read from the database
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again

                collectFood((Map<String, Object>) dataSnapshot.getValue());
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("TAG", "Failed to read value.", error.toException());
            }
        });

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

//        List<Item> items = new ArrayList<>();
//        for (int i = 0; i < titles.length; i++) {
//            items.add(new Item(titles[i], contents[i], newList[i]));
//
//        }

        fa = new FoodListAdapter(this, foodList, this);

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
        intent.putExtra("id", i.getId());
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

    private void collectFood(Map<String, Object> users) {

        if (!foodList.isEmpty()) {
            foodList.clear();
        }

        for (Map.Entry<String, Object> entry : users.entrySet()) {
            FoodItem fi = new FoodItem();

            Map<String, Object> singleItem = (Map) entry.getValue(); // get item with food ID
            fi.setID(entry.getKey());
//          get food item with other concept: name, avatar, ingredient, images, guideline
            Map<String, Object> contentItem = (Map) entry.getValue();
            fi.setName(contentItem);
            fi.setAvatar(contentItem);
            fi.setYoutubeVideo(contentItem);
            fi.setIsHot(contentItem);

            fi.setGuideline(contentItem);
            fi.setImages(contentItem);
            fi.setIngredient(contentItem);

            foodList.add(fi);
        }
    }

}
