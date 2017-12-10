package collections.nvm.cookbook.activity;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import collections.nvm.cookbook.R;
import collections.nvm.cookbook.adapter.GuidelineAdapter;
import collections.nvm.cookbook.adapter.NguyenLieuAdapter;
import collections.nvm.cookbook.adapter.SlideImageAdapter;
import collections.nvm.cookbook.utils.FoodItem;
import collections.nvm.cookbook.utils.GuideItem;
import collections.nvm.cookbook.utils.HelperScrollView;
import collections.nvm.cookbook.utils.NguyenLieu;

public class DetailActivity extends AppCompatActivity {

    private ViewPager viewPager; //View pager trong file activity_main.xml
    private SlideImageAdapter slideImageAdapter; // Class ingredientAdapter tao de dung cho view pager
    //    private int[] images = {R.mipmap.ic_launcher, R.mipmap.ic_launcher_round}; // mang luu cac dương dan cac hinh anh can the hien len viewpager

    /////////////////////////////////////////////////////////////////////

    private NguyenLieuAdapter ingredientAdapter;
    ////////////////////////////////////////////////////////////////////

    private ListView lvNguyenLieu;
    //    private Item mItem;
    private TextView tvTitle;

    private RecyclerView rcGuideline;
    private GuidelineAdapter mGuidelineAdapter;

    //    /////////////////////////////////////////////
//    firebase region
    private FirebaseAuth mFirebaseAuth;
    private DatabaseReference myRef;
    private FoodItem mItem;
    private List<GuideItem> mGuideItemList;
    private List<String> mPreviewImageList;
    private List<NguyenLieu> mIngredientList;
    private List<NguyenLieu> arrayNguyenLieu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
//        FirebaseDatabase.getInstance().setPersistenceEnabled(true); // enable store data on disk

        getBundle();

        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setWindowTitle(mItem.getName());
        this.setTitle(mItem.getName());

        tvTitle = (TextView) findViewById(R.id.tvTitle);
        tvTitle.setText(mItem.getName());
        //ánh xạ
        lvNguyenLieu = (ListView) findViewById(R.id.listViewNL);
        viewPager = (ViewPager) findViewById(R.id.pager);
        rcGuideline = (RecyclerView) findViewById(R.id.rcGuideline);

        mGuideItemList = new ArrayList<>();
        mPreviewImageList = new ArrayList<>();
        mIngredientList = new ArrayList<>();

        initSlideImage(mPreviewImageList);
        initIngredient(mIngredientList);
        initGuideline(mGuideItemList);
    }

    public void getBundle() {
        mItem = new FoodItem();
        boolean isHotFood = false;
        Bundle extras = getIntent().getExtras();
        if (extras == null) {

        } else {
//            mItem.setId(extras.getString("id"));
            mItem.setID(extras.getString("id", ""));
            mItem.setName(extras.getString("name", ""));
//            firebase region
            // Write a message to the database
            FirebaseDatabase database = FirebaseDatabase.getInstance();
            DatabaseReference myRef = database.getReference("data").child(mItem.getID());
            // Read from the database
            myRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    // This method is called once with the initial value and again
                    collectFoodData((Map<String, Object>) dataSnapshot.getValue());
                }

                @Override
                public void onCancelled(DatabaseError error) {
                    // Failed to read value
                    Log.e("TAG", "Failed to read value.", error.toException());
                }
            });
//            lấy dữ liệu của item theo id từ web
        }
    }

    public void initSlideImage(List<String> slideList) {
//        String[] images = {
//                "https://imgur.com/IGtj6rL",
//                "https://imgur.com/IGtj6rL",
//        };
//        slideList = new ArrayList<>(Arrays.asList(images));

//        myAdapter = new MyAdapter(this, images);
        slideImageAdapter = new SlideImageAdapter(this, slideList);
        viewPager.setAdapter(slideImageAdapter);
    }

    public void initIngredient(List<NguyenLieu> list) {

        //khởi tạo
        arrayNguyenLieu = new ArrayList<>();
        ingredientAdapter = new NguyenLieuAdapter(this, R.layout.display, list);
//        ingredientAdapter = new NguyenLieuAdapter(this, R.layout.display, arrayNguyenLieu);

        //Tạo demo
        arrayNguyenLieu.add(new NguyenLieu("Thịt heo", "500gr"));
        arrayNguyenLieu.add(new NguyenLieu("Thịt bò", "200gr"));
        arrayNguyenLieu.add(new NguyenLieu("Cá diêu hồng", "2 con"));
        arrayNguyenLieu.add(new NguyenLieu("Hành lá", "50gr"));
        arrayNguyenLieu.add(new NguyenLieu("Đậu phụ", "3 miếng"));
        arrayNguyenLieu.add(new NguyenLieu("Đường", "3 muỗng"));
        arrayNguyenLieu.add(new NguyenLieu("Chả cá", "1 kí"));
        arrayNguyenLieu.add(new NguyenLieu("Cải thảo", "1 bó"));
        arrayNguyenLieu.add(new NguyenLieu("Bắp cải", "1"));
        arrayNguyenLieu.add(new NguyenLieu("Cà chua", "3 trái"));
        arrayNguyenLieu.add(new NguyenLieu("Khoai lang", "3 củ"));
        arrayNguyenLieu.add(new NguyenLieu("Khoai tây", "3 củ"));

        lvNguyenLieu.setAdapter(ingredientAdapter);
        lvNguyenLieu.setFocusable(false);
        HelperScrollView.getListViewSize(lvNguyenLieu);
    }

    public void initGuideline(List<GuideItem> list) {
//        mPreviewImageList = new ArrayList<>();
//        mPreviewImageList.add(new GuideItem(1, "Mua nguyên liệu"));
//        mPreviewImageList.add(new GuideItem(2, "Cho vào nồi"));
//        mPreviewImageList.add(new GuideItem(3, "Bật lửa lên,c hờ 10 phút"));
//        mPreviewImageList.add(new GuideItem(4, "Bày ra dĩa và ăn"));

        StaggeredGridLayoutManager sglm = new StaggeredGridLayoutManager(1, LinearLayoutManager.HORIZONTAL);

        mGuidelineAdapter = new GuidelineAdapter(this, list);
        rcGuideline.setAdapter(mGuidelineAdapter);
        rcGuideline.setLayoutManager(sglm);
        rcGuideline.setFocusable(false);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater mi = getMenuInflater();
        mi.inflate(R.menu.empty_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                break;

        }
        return true;
    }

    public void onPlayVideo(View view) {
//        play youtube video
        Intent intent = new Intent(this, VideoActivity.class);
        intent.putExtra("link", mItem.getYoutubevideo());
        startActivity(intent);
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }

    public void onShareClicked(View view) {
//        share food
        Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
        sharingIntent.setType("text/plain"); // type of sharing
        String shareBody = this.mItem.getName() + " via LNPCollections. Visit us at: www...com";
//        sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Subject Here");
        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
        startActivity(Intent.createChooser(sharingIntent, "Share via"));
    }

    private void collectFoodData(Map<String, Object> users) {

        if (!mItem.getGuideline().isEmpty()) {
            mItem.getGuideline().clear();
        }
        if (!mItem.getImages().isEmpty()) {
            mItem.getImages().clear();
        }
        if (!mItem.getIngredient().isEmpty()) {
            mItem.getIngredient().clear();
        }

//        Map<String, Object> contentItem = (Map) entry.getValue();
        mItem.setName(users);
        mItem.setAvatar(users);
        mItem.setYoutubeVideo(users);
        mItem.setIsHot(users);

        mItem.setGuideline(users);
        mItem.setImages(users);
        mItem.setIngredient(users);

        parseFoodItemToList(mItem, mPreviewImageList, mGuideItemList, mIngredientList);
        initIngredient(mIngredientList);
        mGuidelineAdapter.notifyDataSetChanged();
        slideImageAdapter.notifyDataSetChanged();
        ingredientAdapter.notifyDataSetChanged();
    }

    public void parseFoodItemToList(FoodItem item,
                                    List<String> imagesList,
                                    List<GuideItem> guideList,
                                    List<NguyenLieu> ingredientList) {
//        empty the lists here
        if (!imagesList.isEmpty())
            imagesList.clear();
        if (!guideList.isEmpty())
            guideList.clear();
        if (!ingredientList.isEmpty())
            ingredientList.clear();
//        preview images here
        mItem.getImages().remove(0);
        imagesList.addAll(mItem.getImages());
//        guideline list
        List<String> l = item.getGuideline();
        for (int i = 1; i < l.size(); i++)
            guideList.add(new GuideItem(i, l.get(i)));

        // ingredient here
        Set keys = mItem.getIngredient().keySet();

        for (Iterator ite = keys.iterator(); ite.hasNext(); ) {
            String key = (String) ite.next();
            String value = mItem.getIngredient().get(key);
            ingredientList.add(new NguyenLieu(key, value));
        }
    }
}
