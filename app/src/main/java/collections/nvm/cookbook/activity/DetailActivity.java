package collections.nvm.cookbook.activity;

import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import collections.nvm.cookbook.R;
import collections.nvm.cookbook.adapter.GuidelineAdapter;
import collections.nvm.cookbook.adapter.NguyenLieuAdapter;
import collections.nvm.cookbook.adapter.SlideImageAdapter;
import collections.nvm.cookbook.utils.GuideItem;
import collections.nvm.cookbook.utils.HelperScrollView;
import collections.nvm.cookbook.utils.Item;
import collections.nvm.cookbook.utils.NguyenLieu;

public class DetailActivity extends AppCompatActivity {

    private ViewPager viewPager; //View pager trong file activity_main.xml
    private SlideImageAdapter slideImageAdapter; // Class adapter tao de dung cho view pager
    //    private int[] images = {R.mipmap.ic_launcher, R.mipmap.ic_launcher_round}; // mang luu cac dương dan cac hinh anh can the hien len viewpager
    private List<String> list;

    /////////////////////////////////////////////////////////////////////

    private ArrayList<NguyenLieu> arrayNguyenLieu;
    private NguyenLieuAdapter adapter = null;
    ////////////////////////////////////////////////////////////////////

    private ListView lvNguyenLieu;
    public Item mItem;
    private TextView tvTitle;

    private RecyclerView rcGuideline;
    private GuidelineAdapter mGuidelineAdapter;
    private List<GuideItem> mGuideItemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        getBundle();
        slideImage();

        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setWindowTitle(mItem.getTitle());
        this.setTitle(mItem.getTitle());

        tvTitle = (TextView) findViewById(R.id.tvTitle);
        tvTitle.setText(mItem.getTitle());

        initIngredient(new ArrayList<NguyenLieu>());
        initGuideline(mGuideItemList);
    }

    public void getBundle() {
        mItem = new Item();
        boolean isHotFood = false;
        Bundle extras = getIntent().getExtras();
        if (extras == null) {

        } else {
//            mItem.setId(extras.getString("id"));
            mItem.setId("");
            mItem.setTitle(extras.getString("name"));

//            lấy dữ liệu của item theo id từ web
        }
    }

    public void slideImage() {
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

        };
        list = new ArrayList<>();
//        list.add(String.valueOf(contents));
        Collections.addAll(list, contents);

        viewPager = (ViewPager) findViewById(R.id.pager);
//        myAdapter = new MyAdapter(this, images);
        slideImageAdapter = new SlideImageAdapter(this, list);
        viewPager.setAdapter(slideImageAdapter);
    }

    public void initIngredient(List<NguyenLieu> list) {
        //ánh xạ
        lvNguyenLieu = (ListView) findViewById(R.id.listViewNL);
        //khởi tạo
        arrayNguyenLieu = new ArrayList<NguyenLieu>();
        adapter = new NguyenLieuAdapter(this, R.layout.display, arrayNguyenLieu);

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

        lvNguyenLieu.setAdapter(adapter);
        HelperScrollView.getListViewSize(lvNguyenLieu);
    }

    public void initGuideline(List<GuideItem> list) {
        rcGuideline = (RecyclerView) findViewById(R.id.rcGuideline);
        list = new ArrayList<>();
        list.add(new GuideItem(1, "Mua nguyên liệu"));
        list.add(new GuideItem(2, "Cho vào nồi"));
        list.add(new GuideItem(3, "Bật lửa lên,c hờ 10 phút"));
        list.add(new GuideItem(4, "Bày ra dĩa và ăn"));

        StaggeredGridLayoutManager sglm = new StaggeredGridLayoutManager(1, LinearLayoutManager.HORIZONTAL);

        mGuidelineAdapter = new GuidelineAdapter(this, list);
        rcGuideline.setAdapter(mGuidelineAdapter);
        rcGuideline.setLayoutManager(sglm);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater mi = getMenuInflater();
        mi.inflate(R.menu.empty_menu, menu);
        return true;
    }
}
