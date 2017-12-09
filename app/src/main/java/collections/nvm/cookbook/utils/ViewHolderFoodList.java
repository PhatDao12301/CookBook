package collections.nvm.cookbook.utils;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import collections.nvm.cookbook.R;
import collections.nvm.cookbook.listener.FoodItemClickListener;
import collections.nvm.cookbook.utils.Item;

/**
 * Created by Dao Tien Phat on 10/19/2017.
 */

public class ViewHolderFoodList extends RecyclerView.ViewHolder {
    public TextView title;
    public ImageView ivImage, ivHotFood;
    public FoodItemClickListener mListener;
    public LinearLayout list_item;
    private String imageUrl;

    public ViewHolderFoodList(View itemView, FoodItemClickListener listener) {
        super(itemView);
        this.title = itemView.findViewById(R.id.tvTitle);
        this.ivImage = itemView.findViewById(R.id.ivImage);
        this.ivHotFood = itemView.findViewById(R.id.ivHotFood);

        this.mListener = listener;
        this.list_item = itemView.findViewById(R.id.list_item);
    }


    public TextView getTitle() {
        return title;
    }

    public void setTitle(TextView title) {
        this.title = title;
    }

    public ImageView getIvImage() {
        return ivImage;
    }

    public void setIvImage(ImageView ivImage) {
        this.ivImage = ivImage;
    }

    public ImageView getIvHotFood() {
        return ivHotFood;
    }

    public void setIvHotFood(ImageView ivHotFood) {
        this.ivHotFood = ivHotFood;
    }

    public void isHotFood(Boolean b) {
        if (b == false)
            this.ivHotFood.setVisibility(View.INVISIBLE);
        else
            this.ivHotFood.setVisibility(View.VISIBLE);
    }

    public FoodItemClickListener getmListener() {
        return mListener;
    }

    public void setmListener(FoodItemClickListener mListener) {
        this.mListener = mListener;
    }

    public LinearLayout getList_item() {
        return list_item;
    }

    public void setList_item(LinearLayout list_item) {
        this.list_item = list_item;
    }

}
