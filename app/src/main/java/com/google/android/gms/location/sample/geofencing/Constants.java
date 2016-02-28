/**
 * Copyright 2014 Google Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.android.gms.location.sample.geofencing;

import com.google.android.gms.maps.model.LatLng;

import java.util.HashMap;

/**
 * Constants used in this sample.
 */
public final class Constants {

    private Constants() {
    }

    public static final String PACKAGE_NAME = "com.google.android.gms.location.Geofence";

    public static final String SHARED_PREFERENCES_NAME = PACKAGE_NAME + ".SHARED_PREFERENCES_NAME";

    public static final String GEOFENCES_ADDED_KEY = PACKAGE_NAME + ".GEOFENCES_ADDED_KEY";

    /**
     * Used to set an expiration time for a geofence. After this amount of time Location Services
     * stops tracking the geofence.
     */
    public static final long GEOFENCE_EXPIRATION_IN_HOURS = 100;

    /**
     * For this sample, geofences expire after twelve hours.
     */
    public static final long GEOFENCE_EXPIRATION_IN_MILLISECONDS =
            GEOFENCE_EXPIRATION_IN_HOURS * 60 * 60 * 1000;
    public static final float GEOFENCE_RADIUS_IN_METERS = 500;

    /**
     * Map for storing information geofences
     */
    public static final HashMap<String, LatLng> BAY_AREA_LANDMARKS = new HashMap<String, LatLng>();
    static {
        // Work
        BAY_AREA_LANDMARKS.put("Office", new LatLng(59.949655, 30.389269));

        // Subway work
        BAY_AREA_LANDMARKS.put("Chernishevskaya", new LatLng(59.944551, 30.359845));

        // Subway home
        BAY_AREA_LANDMARKS.put("Zvezdnaya", new LatLng(59.833269, 30.349314));

        // Home
        BAY_AREA_LANDMARKS.put("Home", new LatLng(59.837408, 30.357862));

        // Smolniy
        BAY_AREA_LANDMARKS.put("Smolniy", new LatLng(59.946208, 30.396333));

        // Krujki
        BAY_AREA_LANDMARKS.put("Krujki", new LatLng(59.838544, 30.348088));
    }

    public static final HashMap<String, String> BAY_AREA_WIFI = new HashMap<String, String>();
    static {
        // Work
        BAY_AREA_WIFI.put("Office", "ABR");

        // Subway work
        BAY_AREA_WIFI.put("Home", "friends");

    }
}
