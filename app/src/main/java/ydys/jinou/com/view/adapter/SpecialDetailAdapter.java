package ydys.jinou.com.view.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import ydys.jinou.com.R;
import ydys.jinou.com.model.bean.SpeciaDetailBean;
import ydys.jinou.com.view.activity.MessageMovieActivity;


public class SpecialDetailAdapter extends RecyclerView.Adapter<SpecialDetailAdapter.SpecialDetailViewHolder> {

    Context context;
    List<SpeciaDetailBean.RetBean.ListBean.ChildListBean> list;
    public SpecialDetailAdapter(Context context,List<SpeciaDetailBean.RetBean.ListBean.ChildListBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public SpecialDetailViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.layout_special_detail_item, null);
        SpecialDetailViewHolder specialDetailViewHolder = new SpecialDetailViewHolder(view);
        return specialDetailViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull SpecialDetailViewHolder holder, final int position) {
        holder.getSimpleDraweeView().setImageURI(list.get(position).getPic());



        holder.getSimpleDraweeView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, MessageMovieActivity.class);

                intent.putExtra("id", list.get(position).getDataId());
                intent.putExtra("url", list.get(position).getShareURL());
                intent.putExtra("title", list.get(position).getTitle());
                intent.putExtra("jianjie", list.get(position).getDescription());
                intent.putExtra("picture",list.get(position).getPic());
                context.startActivity(intent);

            }
        });
        holder.getName().setText(list.get(position).getTitle());
    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    class SpecialDetailViewHolder extends RecyclerView.ViewHolder {

        private final SimpleDraweeView simpleDraweeView;
        private final TextView name;

        public SpecialDetailViewHolder(View itemView) {
            super(itemView);
            simpleDraweeView = itemView.findViewById(R.id.simp_detail_view);
            name = itemView.findViewById(R.id.name);
        }

        public SimpleDraweeView getSimpleDraweeView() {
            return simpleDraweeView;
        }

        public TextView getName() {
            return name;
        }
    }
}
