package com.example.ashwin.firebaserecyclercardview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    private Person mPerson;
    private TextView mNameTextView, mAddressTextView;
    private ImageView mPhotoImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null && bundle.containsKey("person")) {
            mPerson = (Person) bundle.getParcelable("person");
        }

        initViews();

        if (mPerson != null) {
            setPersonDetails();
        }
    }

    private void initViews() {
        mNameTextView = (TextView) findViewById(R.id.name);
        mAddressTextView = (TextView) findViewById(R.id.address);
        mPhotoImageView = (ImageView) findViewById(R.id.photo);
    }

    private void setPersonDetails() {
        mNameTextView.setText(mPerson.getName());
        mAddressTextView.setText(mPerson.getAddress());
        new AsyncTaskLoadPhoto(mPhotoImageView).execute(mPerson.getPhoto());
    }
}
