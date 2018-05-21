package ydys.jinou.com.view.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by 王有道 on 2018/3/29.
 */

public class ListAdapet extends BaseAdapter {
    Context context;
    List<String> list;
    public ListAdapet(Context context, List<String> list) {
        this.context=context;

        this.list=list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        TextView textView = new TextView(context);
        textView.setText(list.get(i));
        textView.setTextSize(20);

        return textView;
    }
}
