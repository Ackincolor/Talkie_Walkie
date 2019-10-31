package com.ackincolor.talkiewalkie.adapters;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ackincolor.talkiewalkie.R;
import com.ackincolor.talkiewalkie.entities.AndroidDevice;

import java.util.ArrayList;
import java.util.List;

import androidx.recyclerview.widget.RecyclerView;

public class MyAndroidDeviceAdapter extends RecyclerView.Adapter<MyAndroidDeviceAdapter.MyViewHolder> {

    private List<AndroidDevice> mDataset;
    public class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView textView;
        public MyViewHolder(View v) {
            super(v);
            textView = v.findViewById(R.id.textView);
        }

    }
    public MyAndroidDeviceAdapter (ArrayList<AndroidDevice> list){
        this.mDataset = list;
    }
    public MyAndroidDeviceAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                                  int viewType) {
        // create a new view
        TextView v = (TextView) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.my_text_view, parent, true);
        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.textView.setText(mDataset.get(position).getName());
        Log.d("DEBUG",mDataset.get(position).getName()+" coucou");
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.size();
    }
    public void setData(List<AndroidDevice> list){
        this.mDataset = list;
        this.notifyDataSetChanged();
    }


}
