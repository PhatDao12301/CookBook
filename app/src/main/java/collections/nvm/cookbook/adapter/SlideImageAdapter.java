package collections.nvm.cookbook.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.List;

import collections.nvm.cookbook.R;

/**
 * Created by PHANTHELINH on 11/18/2017.
 */

public class SlideImageAdapter extends PagerAdapter {

    private Context context;
    private LayoutInflater inflater;
    private int[] images;// = {R.mipmap.ic_launcher, R.mipmap.ic_launcher_round};
    private List<String> urlList;

    public SlideImageAdapter(Context context, int[] images) {
        this.context = context;
        this.images = images;
        inflater = LayoutInflater.from(context);
    }

    public SlideImageAdapter(Context context, List<String> list) {
        this.context = context;
        this.urlList = list;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
//        return images.length;
        return urlList.size();
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View myView = inflater.inflate(R.layout.swipe, container, false);

        ImageView imageView = (ImageView) myView.findViewById(R.id.imageView);
        //Set duong dan hinh anh dua len ImageView
//        imageView.setImageResource(images[position]); //position tư tang len, ban dau la 0

        Picasso.with(context).load(urlList.get(position))
                .placeholder(android.R.drawable.btn_dialog).into(imageView);

        container.addView(myView, 0);
        return myView;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view.equals(object);
    }
}
