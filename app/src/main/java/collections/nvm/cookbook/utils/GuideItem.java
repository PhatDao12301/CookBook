package collections.nvm.cookbook.utils;

/**
 * Created by Dao Tien Phat on 11/26/2017.
 */

public class GuideItem {
    private String content;
    private int step;

    public GuideItem() {
    }

    public GuideItem(int step, String content) {
        this.content = content;
        this.step = step;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getStep() {
        return step;
    }

    public void setStep(int step) {
        this.step = step;
    }
}
