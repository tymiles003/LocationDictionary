package in.dictionary.location.adapter;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import in.dictionary.location.R;
import in.dictionary.location.model.LocationObject;

public class StoreRecyclerAdapter extends RecyclerView.Adapter
                                   <StoreRecyclerAdapter.LocationViewHolder> {
    List<LocationObject> locations;

    public StoreRecyclerAdapter(List<LocationObject> initLocations) {
        locations = initLocations;
    }

    public static class LocationViewHolder extends RecyclerView.ViewHolder {
        CardView storeLocationCardview;
        TextView locationName;
        TextView locationDescription;
        TextView locationTags;

        LocationViewHolder(View itemView) {
            super(itemView);
            storeLocationCardview = (CardView)itemView.findViewById(R.id.store_location_cardview);
            locationName = (TextView)itemView.findViewById(R.id.location_name);
            locationDescription = (TextView)itemView.findViewById(R.id.location_description);
            locationTags = (TextView)itemView.findViewById(R.id.location_tags);
        }
    }

    @Override
    public int getItemCount() {
        return locations.size();
    }

    @Override
    public LocationViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.location_card, viewGroup, false);
        return new LocationViewHolder(view);
    }

    @Override
    public void onBindViewHolder(LocationViewHolder personViewHolder, int i) {
        LocationObject locationObject = locations.get(i);
        personViewHolder.locationName.setText(locationObject.getName());
        personViewHolder.locationDescription.setText(locationObject.getDescription());
        String tags = "";
        for (String tag :locationObject.getTags()) {
            tags += "," + tag;
        }
        personViewHolder.locationTags.setText(tags);
    }
}
