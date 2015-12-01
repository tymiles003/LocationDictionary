package in.dictionary.location.fragment;

import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import in.dictionary.location.R;
import in.dictionary.location.adapter.StoreRecyclerAdapter;
import in.dictionary.location.model.LocationDatabase;
import in.dictionary.location.model.LocationObject;

public class LocationStoreFragment extends Fragment implements View.OnClickListener, LocationListener {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_store_location, container, false);

        LocationDatabase database = LocationDatabase.getInstance();
        RecyclerView storedLocationList = ((RecyclerView) view.findViewById(R.id.stored_location_list));
        storedLocationList.setHasFixedSize(true);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        storedLocationList.setLayoutManager(linearLayoutManager);
        storedLocationList.setItemAnimator(new DefaultItemAnimator());
        StoreRecyclerAdapter storeRecyclerAdapter = new StoreRecyclerAdapter(database.getLocations());
        storedLocationList.setAdapter(storeRecyclerAdapter);

        FloatingActionButton storeNewLocation = ((FloatingActionButton)
                view.findViewById(R.id.store_new_location));

        storeNewLocation.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View view) {
        LocationManager manager = (LocationManager)
                getActivity().getSystemService(Context.LOCATION_SERVICE);
        boolean statusOfGPS = manager.isProviderEnabled(LocationManager.GPS_PROVIDER);

        if(statusOfGPS) {
            // ToDo add
        } else {
            startActivity(new Intent(android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS));
        }
    }

    @Override
    public void onLocationChanged(Location location) {
        LocationObject locationObject = new LocationObject();
        locationObject.setName("");
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }
}
