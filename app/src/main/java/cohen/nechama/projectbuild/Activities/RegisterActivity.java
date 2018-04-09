package cohen.nechama.projectbuild.Activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import com.firebase.ui.auth.AuthUI;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Arrays;

import cohen.nechama.projectbuild.R;
import cohen.nechama.projectbuild.obj.Neighbor;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    private static final int RC_SIGN_IN = 123;
    private EditText etName;
    private EditText etPhone;
    private Spinner spBuild;

    FloatingActionButton fabRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //1) login to firebase. (must have a user)

        findViewsById();
        loginToFireBase();
        fabRegister.setOnClickListener(this);
    }

    private void findViewsById() {
        fabRegister = findViewById(R.id.fabRegister);
        etName = findViewById(R.id.etName);
        etPhone = findViewById(R.id.etPhone);
        spBuild = findViewById(R.id.spnBuild);
    }

    private void loginToFireBase() {
        startActivityForResult(
                AuthUI.getInstance()
                        .createSignInIntentBuilder()
                        .setIsSmartLockEnabled(false)
                        .setAvailableProviders(Arrays.asList(
                                new AuthUI.IdpConfig.EmailBuilder().build(),
                                new AuthUI.IdpConfig.PhoneBuilder().build(),
                                new AuthUI.IdpConfig.GoogleBuilder().build()
                        ))
                        .build(),
                RC_SIGN_IN);
    }


    //get response from firebase:
    @Override
    protected void onActivityResult(int requestCode, int resultCode, final Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {

            //Buildings
            DatabaseReference buildingsRef = FirebaseDatabase.getInstance().getReference("Buildings");
            buildingsRef.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    ArrayList<String> buildings = new ArrayList<>();

                    for (DataSnapshot building : dataSnapshot.getChildren()) {
                        String buildingAddress = building.getValue(String.class);
                        String buildingID = building.getKey();

                        buildings.add(buildingAddress);
                    }

                    //Trick for String only Spinner
                    ArrayAdapter<String> adapter = new ArrayAdapter<>(RegisterActivity.this, android.R.layout.simple_spinner_item, buildings);
                    spBuild.setAdapter(adapter);
                }

                @Override
                public void onCancelled(DatabaseError e) {
                    Snackbar.make(fabRegister, e.getMessage(), Snackbar.LENGTH_LONG)
                            .setAction("Ok", null).show();
                }
            });

            //good
        } else {
            new AlertDialog.Builder(this).setTitle("האפליקציה דורשת חיבור").setPositiveButton("צא החוצה", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    System.exit(0);
                }
            }).show();
        }
    }


    //    Fab Register Clicked:
    @Override
    public void onClick(View view) {



        //get the current user:
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            String userId = user.getUid();
            String name = etName.getText().toString();
            String phone = etPhone.getText().toString();
            String building = spBuild.getSelectedItem().toString();

            Neighbor n = new Neighbor(name, phone, building);

            FirebaseDatabase database = FirebaseDatabase.getInstance();
            DatabaseReference myRef = database.getReference("Neighbors");
            myRef.child(userId).setValue(n).addOnSuccessListener(new OnSuccessListener<Void>() {
                @Override
                public void onSuccess(Void aVoid) {
                    gotoMain();
                }
            });
        }

        //gotoMain();


    }

    private void gotoMain() {
        Intent intentGoMenu = new Intent(RegisterActivity.this, MenuActivity.class);
        String userName = etName.getText().toString();
        intentGoMenu.putExtra("the_user_name", userName);
        startActivity(intentGoMenu);
    }
}


/*
*


        myRef.addValueEventListener(new ValueEventListener() {

            public static final String TAG = "";

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                Log.d(TAG, "Value is: " + value);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });





//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
            }
        });


    */