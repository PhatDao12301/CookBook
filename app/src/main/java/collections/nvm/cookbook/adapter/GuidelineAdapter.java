package collections.nvm.cookbook.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import collections.nvm.cookbook.R;
import collections.nvm.cookbook.utils.GuideItem;
import collections.nvm.cookbook.utils.NguyenLieu;

/**
 * Created by Dao Tien Phat on 11/26/2017.
 */

public class GuidelineAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<GuideItem> guideItemList;

    public GuidelineAdapter(Context context, int layout, List<GuideItem> guideItemList) {
        this.context = context;
        this.layout = layout;
        this.guideItemList = guideItemList;
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(layout,null);
        //ánh xạ
        TextView tvStep = (TextView) view.findViewById(R.id.tvStep);
        TextView tvContent = (TextView) view.findViewById(R.id.tvContent);
        //gán data
        GuideItem guideItem = guideItemList.get(i);
        tvStep.setText(guideItem.getStep());
        tvContent.setText(guideItem.getContent());
        return view;
    }
}
