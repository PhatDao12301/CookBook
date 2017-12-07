package collections.nvm.cookbook.utils;

import android.graphics.drawable.Drawable;

import java.util.ArrayList;
import java.util.List;

import collections.nvm.cookbook.R;

/**
 * Created by Dao Tien Phat on 10/16/2017.
 */

public class Item {

    private String id;
    private String title, imageUrl, youtubeUrl;
    private Drawable avatar;
    private Boolean isHotFood;
    private List<String> guidelineList, urlList, ingredientList;
    private List<Drawable> images;

    public Item() {
        id = title = imageUrl = youtubeUrl = "";
        isHotFood = false;
        guidelineList = new ArrayList<>();
        urlList = new ArrayList<>();
        ingredientList = new ArrayList<>();
        images = new ArrayList<>();
    }

    public Item(String title, String imageurl, Boolean ishotfood) {
        this.title = title;
        this.imageUrl = imageurl;
        this.isHotFood = ishotfood;
    }


    public Item(String title, Drawable ivImage, Boolean ishotfood) {
        this.title = title;
//        this.author = content;
        this.avatar = ivImage;
        this.isHotFood = ishotfood;
    }

    public Item(String id, String title,
                String imageUrl, Drawable avatar,
                Boolean isHotFood, List<String> guidelineList,
                List<String> urlList, List<String> ingredientList,
                List<Drawable> images) {
        this.id = id;
        this.title = title;
        this.imageUrl = imageUrl;
        this.avatar = avatar;
        this.isHotFood = isHotFood;
        this.guidelineList = guidelineList;
        this.urlList = urlList;
        this.ingredientList = ingredientList;
        this.images = images;
    }

    //    public Item(View itemView) {
////        super(itemView);
//        this.title = itemView.findViewById(R.id.tvTitle);
//        this.author = itemView.findViewById(R.id.tvAuthor);
//        this.avatar = itemView.findViewById(R.id.ivImage);
//    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Drawable getAvatar() {
        return avatar;
    }

    public void setAvatar(Drawable avatar) {
        this.avatar = avatar;
    }

    public Boolean getHotFood() {
        return isHotFood;
    }

    public void setHotFood(Boolean hot) {
        isHotFood = hot;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<String> getGuidelineList() {
        return guidelineList;
    }

    public void setGuidelineList(List<String> guidelineList) {
        this.guidelineList = guidelineList;
    }

    public List<String> getUrlList() {
        return urlList;
    }

    public void setUrlList(List<String> urlList) {
        this.urlList = urlList;
    }

    public List<String> getIngredientList() {
        return ingredientList;
    }

    public void setIngredientList(List<String> ingredientList) {
        this.ingredientList = ingredientList;
    }

    public List<Drawable> getImages() {
        return images;
    }

    public void setImages(List<Drawable> images) {
        this.images = images;
    }

    public String getYoutubeUrl() {
        return youtubeUrl;
    }

    public void setYoutubeUrl(String youtubeUrl) {
        this.youtubeUrl = youtubeUrl;
    }
}
