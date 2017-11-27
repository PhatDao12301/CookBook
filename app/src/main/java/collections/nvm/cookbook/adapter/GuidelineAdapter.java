package collections.nvm.cookbook.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;

import java.util.List;

import collections.nvm.cookbook.R;
import collections.nvm.cookbook.utils.GuideItem;
import collections.nvm.cookbook.utils.Item;
import collections.nvm.cookbook.utils.ViewHolderFoodList;
import collections.nvm.cookbook.utils.ViewHolderGuideline;

/**
 * Created by Dao Tien Phat on 11/26/2017.
 */

public class GuidelineAdapter extends RecyclerView.Adapter<ViewHolderGuideline> {
    private Context context;
    private List<GuideItem> guideItemList;

    public GuidelineAdapter(Context context, List<GuideItem> guideItemList) {
        this.context = context;
        this.guideItemList = guideItemList;
    }

    @Override
    public ViewHolderGuideline onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.guide_item, parent, false);
        ViewHolderGuideline vh = new ViewHolderGuideline(v); // pass the view to View Holder
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolderGuideline holder, int position) {
        holder.tvStep.setText("Bước " + this.guideItemList.get(position).getStep() + ": ");
        holder.tvContent.setText(this.guideItemList.get(position).getContent());
    }

    @Override
    public int getItemCount() {
        return guideItemList.size();
    }

}
