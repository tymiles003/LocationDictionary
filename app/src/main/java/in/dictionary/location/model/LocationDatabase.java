package in.dictionary.location.model;

import java.util.ArrayList;
import java.util.List;

public class LocationDatabase {

    List<LocationObject> locations = new ArrayList<>();
    private static LocationDatabase locationManager;

    public List<LocationObject> getLocations() {
        return locations;
    }

    public void addLocations(LocationObject location) {
        this.locations.add(location);
    }

    public static LocationDatabase getInstance() {
        if (locationManager == null) {
            locationManager = new LocationDatabase();
        }
        return locationManager;
    }
}
