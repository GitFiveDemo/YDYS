package ydys.jinou.com.view.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import ydys.jinou.com.R;
import ydys.jinou.com.model.cache.CollectCacheBean;
import ydys.jinou.com.view.activity.WebActivity;

/**
 * author: 晨光光
 * date : 2018/5/24 11:07
 */
public class CollectAdapter extends RecyclerView.Adapter<CollectAdapter.CollectViewHolder> {

    private Context context;
    private List<CollectCacheBean> list;

    public CollectAdapter(Context context, List<CollectCacheBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public CollectViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.layout_special_item, null);
        return new CollectViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CollectViewHolder holder, int position) {
        CollectCacheBean collectCacheBean = list.get(position);
        String pictureUrl = collectCacheBean.getPictureUrl();
        final String sharedUrl = collectCacheBean.getSharedUrl();
        String title = collectCacheBean.getTitle();
        if (pictureUrl != null)
            holder.draweeView.setImageURI(Uri.parse(pictureUrl));
        holder.textView.setText(title);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, WebActivity.class);
                intent.putExtra("shared", sharedUrl);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class CollectViewHolder extends RecyclerView.ViewHolder {
        private SimpleDraweeView draweeView;
        private TextView textView;

        public CollectViewHolder(View itemView) {
            super(itemView);
            draweeView = itemView.findViewById(R.id.simp_view);
            textView = itemView.findViewById(R.id.text);
        }
    }
}
