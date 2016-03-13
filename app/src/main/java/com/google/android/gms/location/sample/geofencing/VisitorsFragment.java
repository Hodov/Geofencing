package com.google.android.gms.location.sample.geofencing;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;


/**
 * Created by Andrey on 12.03.2016.
 */
public class VisitorsFragment extends Fragment{

        // The onCreateView method is called when Fragment should create its View object hierarchy,
        // either dynamically or via XML layout inflation.
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
            // Defines the xml file for the fragment
            ArrayList<String> items = new ArrayList<String>();
            items.add("1");
            items.add("2");
            items.add("2");

            ArrayAdapter<String> itemsAdapter =
                    new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, items);

            ListView listView = (ListView) getActivity().findViewById(R.id.lvItems);
            listView.setAdapter(itemsAdapter);

            return inflater.inflate(R.layout.fragment_visitors, parent, false);
        }

        // This event is triggered soon after onCreateView().
        // Any view setup should occur here.  E.g., view lookups and attaching view listeners.
        @Override
        public void onViewCreated(View view, Bundle savedInstanceState) {
            // Setup any handles to view objects here
            // EditText etFoo = (EditText) view.findViewById(R.id.etFoo);
        }

}


