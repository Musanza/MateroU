package com.example.materou;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public class ListViewAdapter extends BaseAdapter {
    ArrayList<Model> arrayList;
    LayoutInflater inflater;
    Context mContext;
    List<Model> modelList;

    public ListViewAdapter(Context context, List<Model> modelList2) {
        this.mContext = context;
        this.modelList = modelList2;
        this.inflater = LayoutInflater.from(context);
        ArrayList<Model> arrayList2 = new ArrayList<>();
        this.arrayList = arrayList2;
        arrayList2.addAll(modelList2);
    }

    public class ViewHolder {
        TextView mLatTv;
        TextView mLngTv;
        TextView mTitleTv;
        TextView mInfoTv;

        public ViewHolder() {
        }
    }

    public int getCount() {
        return this.modelList.size();
    }

    public Object getItem(int position) {
        return this.modelList.get(position);
    }

    public long getItemId(int position) {
        return (long) position;
    }

    public View getView(final int position, View view, ViewGroup parent) {
        ViewHolder holder;
        if (view == null) {
            holder = new ViewHolder();
            view = this.inflater.inflate(R.layout.row, (ViewGroup) null);
            holder.mTitleTv = (TextView) view.findViewById(R.id.mainTitle);
            holder.mInfoTv = (TextView) view.findViewById(R.id.infoText);
            holder.mLatTv = (TextView) view.findViewById(R.id.mainLat);
            holder.mLngTv = (TextView) view.findViewById(R.id.mainLng);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        holder.mTitleTv.setText(this.modelList.get(position).getTitle());
        holder.mInfoTv.setText(this.modelList.get(position).getInfo());
        holder.mLatTv.setText(this.modelList.get(position).getLat());
        holder.mLngTv.setText(this.modelList.get(position).getLng());
        view.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(com.example.materou.ListViewAdapter.this.mContext, MapsActivity.class);
                intent.putExtra("actionBarTitle", com.example.materou.ListViewAdapter.this.modelList.get(position).getTitle());
                intent.putExtra("latitudeTv", com.example.materou.ListViewAdapter.this.modelList.get(position).getLat());
                intent.putExtra("longitudeTv", com.example.materou.ListViewAdapter.this.modelList.get(position).getLng());
                com.example.materou.ListViewAdapter.this.mContext.startActivity(intent);
            }
        });
        return view;
    }

    public void filter(String charText) {
        String charText2 = charText.toLowerCase(Locale.getDefault());
        this.modelList.clear();
        if (charText2.length() == 0) {
            this.modelList.addAll(this.arrayList);
        } else {
            Iterator<Model> it = this.arrayList.iterator();
            while (it.hasNext()) {
                Model model = it.next();
                if (model.getTitle().toLowerCase(Locale.getDefault()).contains(charText2)) {
                    this.modelList.add(model);
                }
            }
        }
        notifyDataSetChanged();
    }
}
