package ydys.jinou.com.view.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import ydys.jinou.com.R;
import ydys.jinou.com.model.bean.SpeciaBean;
import ydys.jinou.com.view.activity.SpecialDetailActivity;

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
    public void onBindViewHolder(@NonNull MySpecialViewHolder holder, final int position) {
        holder.simpleDraweeView.setImageURI(list.get(position).getPic());
        holder.simpleDraweeView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, SpecialDetailActivity.class);
                intent.putExtra("loadURL",list.get(position).getLoadURL());
                context.startActivity(intent);
            }
        });
        holder.relative_layout.getBackground().setAlpha(100);
        holder.text.setText(list.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MySpecialViewHolder extends RecyclerView.ViewHolder {

        private final SimpleDraweeView simpleDraweeView;
        private RelativeLayout relative_layout;
        private final TextView text;

        public MySpecialViewHolder(View itemView) {
            super(itemView);
            simpleDraweeView = itemView.findViewById(R.id.simp_view);
            relative_layout = itemView.findViewById(R.id.relative_layout);
            text = itemView.findViewById(R.id.text);
        }
    }
}
