package ydys.jinou.com.view.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import ydys.jinou.com.R;
import ydys.jinou.com.model.bean.SpeciaBean;

public class SpecialAdapter extends RecyclerView.Adapter<SpecialAdapter.MySpecialViewHolder> {
   private Context context;
   private List<SpeciaBean.RetBean.ListBean> list;

    public SpecialAdapter(Context context, List<SpeciaBean.RetBean.ListBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MySpecialViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.layout_special_item, null);
        MySpecialViewHolder mySpecialViewHolder = new MySpecialViewHolder(view);
        return mySpecialViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MySpecialViewHolder holder, int position) {
        holder.simpleDraweeView.setImageURI(list.get(position).getPic());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MySpecialViewHolder extends RecyclerView.ViewHolder {

        private final SimpleDraweeView simpleDraweeView;

        public MySpecialViewHolder(View itemView) {
            super(itemView);
            simpleDraweeView = itemView.findViewById(R.id.simp_view);
        }
    }
}
