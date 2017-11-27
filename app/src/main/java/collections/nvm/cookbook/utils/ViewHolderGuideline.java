package collections.nvm.cookbook.utils;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import collections.nvm.cookbook.R;
import collections.nvm.cookbook.listener.FoodItemClickListener;

/**
 * Created by Dao Tien Phat on 11/27/2017.
 */

public class ViewHolderGuideline extends RecyclerView.ViewHolder {

    public TextView tvStep;
    public TextView tvContent;

    public ViewHolderGuideline(View itemView) {
        super(itemView);
        this.tvStep = itemView.findViewById(R.id.tvStep);
        this.tvContent = itemView.findViewById(R.id.tvContent);

    }

    public TextView getTvStep() {
        return tvStep;
    }

    public void setTvStep(TextView tvStep) {
        this.tvStep = tvStep;
    }

    public TextView getTvContent() {
        return tvContent;
    }

    public void setTvContent(TextView tvContent) {
        this.tvContent = tvContent;
    }
}
