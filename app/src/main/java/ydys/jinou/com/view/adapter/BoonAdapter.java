package ydys.jinou.com.view.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.List;

import ydys.jinou.com.R;
import ydys.jinou.com.model.bean.BoonBean;

/**
 * author: 晨光光
 * date : 2018/5/18 16:17
 */
public class BoonAdapter extends RecyclerView.Adapter<BoonAdapter.BoonViewHolder> {

    private Context context;
    private List<BoonBean.ResultsBean> list;

    public BoonAdapter(Context context, List<BoonBean.ResultsBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public BoonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.boon_item_view_layout, null);
        return new BoonViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BoonViewHolder holder, int position) {
        ImageView imageView = holder.itemView.findViewById(R.id.boon_item_img);
        Glide.with(context).load(list.get(position).getUrl()).into(imageView);
    }

    @Override
    public int getItemCount() {
        if (list == null)
            return 0;
        return list.size();
    }

    class BoonViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        public BoonViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.boon_item_img);
        }
    }
}
