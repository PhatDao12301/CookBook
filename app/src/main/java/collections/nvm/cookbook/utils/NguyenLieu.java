package collections.nvm.cookbook.utils;

/**
 * Created by PHUONG-NAM on 11/10/2017.
 */

public class NguyenLieu {
    public String ten;
    public String soluong;

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getSoluong() {
        return soluong;
    }

    public void setSoluong(String soluong) {
        this.soluong = soluong;
    }

    //Constructor
    public NguyenLieu(String ten, String soluong) {
        this.ten = ten;
        this.soluong = soluong;
    }
}

