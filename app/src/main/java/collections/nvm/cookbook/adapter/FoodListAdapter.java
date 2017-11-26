package collections.nvm.cookbook.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;

import java.util.List;

import collections.nvm.cookbook.utils.Item;
import collections.nvm.cookbook.R;
import collections.nvm.cookbook.utils.ViewHolder;
import collections.nvm.cookbook.listener.FoodItemClickListener;


/**
 * Created by Dao Tien Phat on 10/16/2017.
 */

public class FoodListAdapter extends RecyclerView.Adapter<ViewHolder> {
    private List<Item> mItems;
    private Context mContext;
    private FoodItemClickListener mListener;

    public FoodListAdapter(@NonNull Context context, @NonNull List<Item> objects, FoodItemClickListener listener) {
//        super(context, -1);
        this.mItems = objects;
        this.mContext = context;
        this.mListener = listener;
    }

    public void setItems(List<Item> items) {
        this.mItems.clear();
        this.mItems.addAll(items);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.food_list_item, parent, false);
        ViewHolder vh = new ViewHolder(v, mListener); // pass the view to View Holder
        return vh;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        holder.title.setText(mItems.get(position).getTitle());
//        holder.author.setText(mItems.get(position).getAuthor());
//        holder.ivImage.setImageDrawable(mItems.get(position).getAvatar());
        Glide.with(mContext)
                .load(mItems.get(position).getImageUrl())
                .placeholder(R.drawable.place_holder)
                .into(holder.ivImage);

        holder.isHotFood(mItems.get(position).getHotFood());
        holder.getList_item().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.onClickListener(new Item(holder.getTitle().getText().toString(),
                        mItems.get(position).getImageUrl(),
                        true));
            }
        });
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }


//    public void addItem(FoodUtil item) {
//        if (mItems != null) {
//            mItems.add(item);
//        }
//    }

//    @NonNull
//    @Override
//    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
//        ViewHolder viewHolder;
//        if (convertView == null) {
//            convertView = LayoutInflater.from(getContext())
//                    .inflate(R.layout.food_list_item, parent, false);
//
//            viewHolder = new ViewHolder(convertView);
//            viewHolder.title = (TextView) convertView.findViewById(R.id.title);
//            viewHolder.author = (TextView) convertView.findViewById(R.id.author);
//            viewHolder.ivImage = (ImageView) convertView.findViewById(R.id.ivImage);
//
//            convertView.setTag(viewHolder);
//
//        } else {
//            viewHolder = (ViewHolder) convertView.getTag();
//        }
//        Item item = getItem(position);
//
//        //Fill the data
//        viewHolder.title.setText(item.getTitle());
//        viewHolder.author.setText(item.getAuthor());
//
//        //viewHolder.ivImage.setImageResource(R.drawable.sample); // run
//
//        viewHolder.ivImage.setImageDrawable(item.getAvatar());
//
//        return convertView;
//    }


}
