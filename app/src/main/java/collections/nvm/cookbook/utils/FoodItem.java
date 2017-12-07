package collections.nvm.cookbook.utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Dao Tien Phat on 12/1/2017.
 */

public class FoodItem {

    private static final String ITEM_AVATAR = "avatar";
    private static final String ITEM_NAME = "name";
    private static final String ITEM_IMAGES = "images";
    private static final String ITEM_GUIDELINE = "guideline";
    private static final String ITEM_INGREDIENT = "ingredient";
    private static final String ITEM_ID = "id";
    private static final String ITEM_YOUTUBE_VIDEO = "youtubevideo";
    private static final String ITEM_IS_HOT = "isHot";

    public String avatar, name, ID, youtubevideo, isHot;
    //    public HashMap<String, String> guideline, images, ingredient;
    public List<String> guideline, images;
    public HashMap<String, String> ingredient;

    public FoodItem() {
    }

    //    protected FoodItem(Parcel in) {
//        avatar = in.readString();
//        name = in.readString();
//    }

//    public static final Creator<FoodItem> CREATOR = new Creator<FoodItem>() {
//        @Override
//        public FoodItem createFromParcel(Parcel in) {
//            return new FoodItem(in);
//        }
//
//        @Override
//        public FoodItem[] newArray(int size) {
//            return new FoodItem[size];
//        }
//    };

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getYoutubevideo() {
        return youtubevideo;
    }

    public void setYoutubevideo(String youtubevideo) {
        this.youtubevideo = youtubevideo;
    }

    //    public HashMap<String, String> getGuideline() {
//        return guideline;
//    }
//
//    public void setGuideline(HashMap<String, String> guideline) {
//        this.guideline = guideline;
//    }
//
//    public HashMap<String, String> getImages() {
//        return images;
//    }
//
//    public void setImages(HashMap<String, String> images) {
//        this.images = images;
//    }
//
    public HashMap<String, String> getIngredient() {
        return ingredient;
    }

    public void setIngredient(HashMap<String, String> ingredient) {
        this.ingredient = ingredient;
    }


    public List<String> getGuideline() {
        return guideline;
    }

    public void setGuideline(List<String> guideline) {
        this.guideline = guideline;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

//    public List<String> getIngredient() {
//        return ingredient;
//    }
//
//    public void setIngredient(List<String> ingredient) {
//        this.ingredient = ingredient;
//    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getIsHot() {
        return isHot;
    }

    public void setIsHot(String isHot) {
        this.isHot = isHot;
    }

    //    set property from Map<String, Object> entry
    public void setID(Map<String, Object> entry) {

//        ???????
    }

    public void setName(Map<String, Object> entry) {
        this.name = entry.get(ITEM_NAME).toString();
    }

    public void setAvatar(Map<String, Object> entry) {
        this.avatar = entry.get(ITEM_AVATAR).toString();
    }

    public void setYoutubeVideo(Map<String, Object> entry) {
        this.youtubevideo = entry.get(ITEM_YOUTUBE_VIDEO).toString();
    }

    public void setIsHot(Map<String, Object> entry) {
        this.isHot = entry.get(ITEM_IS_HOT).toString();
    }

    public void setImages(Map<String, Object> entry) {
//        Map<String, Object> imagesMap = (Map<String, Object>) entry.get(ITEM_IMAGES);
//        this.images = new HashMap<>();
//        for (Map.Entry<String, Object> entry1 : imagesMap.entrySet()) {
////            Map<String, String> contentItem = (Map) entry1.getValue();
//            images.put(entry1.getKey(), entry1.getValue().toString());
//        }
        this.images = new ArrayList<>();
        this.images.addAll((Collection<? extends String>) entry.get(ITEM_IMAGES));
    }

    public void setIngredient(Map<String, Object> entry) {
        Map<String, Object> ingredientMap = (Map<String, Object>) entry.get(ITEM_INGREDIENT);
        this.ingredient = new HashMap<>();
        for (Map.Entry<String, Object> entry1 : ingredientMap.entrySet()) {
//            Map<String, String> contentItem = (Map) entry1.getValue();
            ingredient.put(entry1.getKey(), entry1.getValue().toString());
        }
//        this.ingredient = new ArrayList<>();
//        this.ingredient.addAll((Collection<? extends String>) entry.get(ITEM_INGREDIENT));
    }

    public void setGuideline(Map<String, Object> entry) {
//        Map<String, Object> guidelineMap = (Map<String, Object>) entry.get(ITEM_GUIDELINE);
//        this.guideline = new HashMap<>();
//        for (Map.Entry<String, Object> entry1 : guidelineMap.entrySet()) {
////            Map<String, String> contentItem = (Map) entry1.getValue();
//            guideline.put(entry1.getKey(), entry1.getValue().toString());
//        }
        this.guideline = new ArrayList<>();
        this.guideline.addAll((Collection<? extends String>) entry.get(ITEM_GUIDELINE));
    }
}
