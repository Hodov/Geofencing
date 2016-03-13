package com.google.android.gms.location.sample.geofencing;



import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.firebase.client.AuthData;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;

import java.util.Map;

/**
 * Created by Andrey on 12.03.2016.
 */
public class LoginFragment extends Fragment {
    private Button mLoginButton;
    private EditText mLoginText;
    private EditText mPasswordText;

    // The onCreateView method is called when Fragment should create its View object hierarchy,
    // either dynamically or via XML layout inflation.
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        // Defines the xml file for the fragment

        View view = inflater.inflate(R.layout.fragment_login, parent, false);

        //Get the login widgets
        mLoginButton = (Button) view.findViewById(R.id.loginbutton);
        mLoginText = (EditText) view.findViewById(R.id.email);
        mPasswordText = (EditText) view.findViewById(R.id.pass);

        mLoginButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                MySingleton s = (MySingleton) getActivity().getApplication();
                signInUser(s.myFirebaseRef, mLoginText.getText().toString(), mPasswordText.getText().toString());
                // Perform action on click
            }
        });

        return view;
    }

    // This event is triggered soon after onCreateView().
    // Any view setup should occur here.  E.g., view lookups and attaching view listeners.
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        // Setup any handles to view objects here
        // EditText etFoo = (EditText) view.findViewById(R.id.etFoo);
    }

    private void signInUser(Firebase myFirebaseRef, String login, String pass) {
        final String userLogin = login;

        // Create a handler to handle the result of the authentication
        Firebase.AuthResultHandler authResultHandler = new Firebase.AuthResultHandler() {
            @Override
            public void onAuthenticated(AuthData authData) {
                // Authenticated successfully with payload authData
                System.out.println("Залогинился");
            }

            @Override
            public void onAuthenticationError(FirebaseError firebaseError) {
                // Authenticated failed with error firebaseError
                System.out.println("Еррор");
                System.out.println(firebaseError);
            }
        };
        // Or with an email/password combination
        System.out.println(userLogin + "  + " + pass);
        myFirebaseRef.authWithPassword(userLogin, pass, authResultHandler);

        /*

        myFirebaseRef.createUser(login, pass, new Firebase.ValueResultHandler<Map<String, Object>>() {
            @Override
            public void onSuccess(Map<String, Object> result) {
                System.out.println("Successfully created user account with uid: " + result.get("uid"));

                Firebase ref = new Firebase("https://barfly.firebaseio.com/users/" + userLogin);
                ref.child("uid").setValue(result.get("uid"));
            }

            @Override
            public void onError(FirebaseError firebaseError) {
                System.out.println("Unsuccessfully created user account: " + firebaseError);
                // there was an error
            }
        });

    }
*/

    }
}
