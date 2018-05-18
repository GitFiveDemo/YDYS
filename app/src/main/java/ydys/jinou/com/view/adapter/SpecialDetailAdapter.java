package ydys.jinou.com.view.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import ydys.jinou.com.R;
import ydys.jinou.com.model.bean.SpeciaDetailBean;

public class SpecialDetailAdapter extends RecyclerView.Adapter<SpecialDetailAdapter.SpecialDetailViewHolder> {

    Context context;
    List<SpeciaDetailBean.RetBean.ListBean> list;

    public SpecialDetailAdapter(Context context, List<SpeciaDetailBean.RetBean.ListBean> list) {
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
    public void onBindViewHolder(@NonNull SpecialDetailViewHolder holder, int position) {
        holder.simpleDraweeView.setImageURI(list.get(position).getChildList().get(0).getPic());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class SpecialDetailViewHolder extends RecyclerView.ViewHolder {

        private final SimpleDraweeView simpleDraweeView;

        public SpecialDetailViewHolder(View itemView) {
            super(itemView);
            simpleDraweeView = itemView.findViewById(R.id.simp_detail_view);
        }
    }
}
