package collections.nvm.cookbook.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import collections.nvm.cookbook.utils.NguyenLieu;
import collections.nvm.cookbook.R;

/**
 * Created by PHUONG-NAM on 11/10/2017.
 */

public class NguyenLieuAdapter extends BaseAdapter{

    public NguyenLieuAdapter(Context context, int layout, List<NguyenLieu> nguyenLieuList) {
        this.context = context;
        this.layout = layout;
        this.nguyenLieuList = nguyenLieuList;
    }

    private Context context;
    private int layout;
    private List<NguyenLieu> nguyenLieuList;
    @Override
    public int getCount() {
        return nguyenLieuList.size();
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
        TextView txtTenNL = (TextView) view.findViewById(R.id.tenNL);
        TextView txtSoLuong = (TextView) view.findViewById(R.id.soLuong);
        //gán data
        NguyenLieu nguyenlieu = nguyenLieuList.get(i);
        txtTenNL.setText(nguyenlieu.getTen());
        txtSoLuong.setText(nguyenlieu.getSoluong());
        return view;
    }
}
