package com.example.agarw.earthipidea;

/**
 * Created by agarw on 12/22/2017.
 */

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.agarw.earthipidea.R;

import java.util.List;


public class EarthquakeAdapter extends RecyclerView.Adapter<EarthquakeAdapter.EarthquakeViewHolder> {

    private List<Earthquake> earthquakeList;
    public EarthquakeAdapter(List<Earthquake> earthquakeList) {
        this.earthquakeList = earthquakeList;
    }

    @Override
    public EarthquakeAdapter.EarthquakeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.earthquake_list_row, parent, false);

        return new EarthquakeViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(EarthquakeAdapter.EarthquakeViewHolder holder, int position) {
        holder.title.setText(earthquakeList.get(position).getTitle());
        holder.magnitude.setText("magnitude " + "" + earthquakeList.get(position).getMagnitude());
        holder.location.setText("location " + "" + earthquakeList.get(position).getLocation());
        holder.latitude.setText("latitude " + "" + earthquakeList.get(position).getLatitude());
        holder.longitude.setText("longitude " + "" + earthquakeList.get(position).getLongitude());
        holder.depth.setText("depth " + "" + earthquakeList.get(position).getDepth());
        holder.date_time.setText("date and time " + "" + earthquakeList.get(position).getDate_time());

    }

    @Override
    public int getItemCount() {
        return earthquakeList.size();
    }

    public class EarthquakeViewHolder extends RecyclerView.ViewHolder {
        public TextView title;
        public TextView magnitude;
        public TextView location;
        public TextView latitude;
        public TextView longitude;
        public TextView depth;
        public TextView date_time;

        public EarthquakeViewHolder(View view) {
            super(view);
            title = (TextView)view.findViewById(R.id.title);
            magnitude = (TextView)view.findViewById(R.id.magnitude);
            location = (TextView)view.findViewById(R.id.location);
            latitude = (TextView)view.findViewById(R.id.latitude);
            longitude = (TextView)view.findViewById(R.id.longitude);
            depth = (TextView)view.findViewById(R.id.depth);
            date_time = (TextView)view.findViewById(R.id.date_time);

        }






    }
}




