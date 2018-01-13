package com.example.sarah.plasticbeach.adapters;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sarah.plasticbeach.R;
import com.example.sarah.plasticbeach.models.Beach;

import java.util.List;

import static android.content.ContentValues.TAG;

/**
 * Created by Sarah on 13/01/2018.
 */

public class BeachAdapter extends ArrayAdapter<Beach>{
    private final List<Beach> beaches;

    public BeachAdapter(@NonNull Context context, int resource, @NonNull List<Beach> beaches) {
        super(context, resource, beaches);

        this.beaches = beaches;
    }

    @Override
    public int getCount()
    {
        Log.v(TAG, "in getCount()");
        return beaches.size();
    }

    @Override
    public Beach getItem(int position)
    {
        Log.v(TAG, "in getItem() for position " + position);
        return beaches.get(position);
    }

    @Override
    public long getItemId(int position)
    {
        Log.v(TAG, "in getItemId() for position " + position);
        return position;
    }

    @Override
    public int getViewTypeCount()
    {
        Log.v(TAG, "in getViewTypeCount()");
        return 1;
    }

    @Override
    public int getItemViewType(int position)
    {
        Log.v(TAG, "in getItemViewType() for position " + position);
        return 0;
    }

    @Override
    public void notifyDataSetChanged()
    {
        super.notifyDataSetChanged();
    }



    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        Beach beach = beaches.get(position);

        LayoutInflater mInflater = (LayoutInflater) this.getContext()
                .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);

        convertView = mInflater.inflate(R.layout.beach, null);

        ((TextView) convertView.findViewById(R.id.beach_user)).setText(beach.getUsername());
        ((TextView) convertView.findViewById(R.id.beach_description)).setText(beach.getDescription());
        ((ImageView) convertView.findViewById(R.id.beach_photo)).setImageDrawable(beach.getPhoto());
        ((TextView) convertView.findViewById(R.id.beach_date)).setText(beach.getDate().toString());

        return convertView;
    }
}
