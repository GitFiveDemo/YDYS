package ydys.jinou.com.view.adapter;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.dl7.player.media.IjkPlayerView;

import java.util.List;

import ydys.jinou.com.R;
import ydys.jinou.com.model.bean.HomeBean;
import ydys.jinou.com.view.activity.MessageMovieActivity;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private Context context;
    private List<HomeBean.RetBean.ListBean.ChildListBean> list;

    public MyAdapter(Context context, List<HomeBean.RetBean.ListBean.ChildListBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.first_item, null);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.ViewHolder holder, int position) {
        ImageView imageview = holder.getImageview();
        TextView movie_name = holder.getMovie_name();
        String pic = list.get(position).getPic();
        if (pic==null){

        }else{
            String s = pic.split("\\|")[0];
            Glide.with(context).load(s).into(imageview);
        }
        holder.getImageview().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context, MessageMovieActivity.class);
                context.startActivity(intent);
            }
        });

        String title = list.get(position).getTitle();
        movie_name.setText(title);

    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final ImageView imageview;
        private final TextView movie_name;

        public ViewHolder(View itemView) {
            super(itemView);
            imageview = itemView.findViewById(R.id.imageview);
            movie_name = itemView.findViewById(R.id.movie_name);

        }

        public TextView getMovie_name() {
            return movie_name;
        }

        public ImageView getImageview() {
            return imageview;
        }
    }

}
