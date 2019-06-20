package com.mynote.kano;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class RepositoryAdapter extends BaseAdapter {
    private LayoutInflater inflater;
    private ArrayList<Repository> data;
    private int layout;

    public RepositoryAdapter(Context context, int layout, ArrayList<Repository> data){
        this.inflater=(LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        this.layout=layout;
        this.data=data;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position).getName();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            convertView = inflater.inflate(layout,parent, false);
        }
        Repository repository = data.get(position);

        TextView name = (TextView)convertView.findViewById(R.id.name);
        name.setText(repository.getName());
        return convertView;
    }
}
