package com.simform.rushabhmodi.androidlearning.test;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.simform.rushabhmodi.androidlearning.R;

import java.util.ArrayList;
import java.util.List;

public class ContentProviderExampleActivity extends AppCompatActivity {

    private RecyclerView contactRecyclerView;
    private List<String> contactNameList;
    private ContentProviderRecyclerAdapter contentProviderRecyclerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.base_layout_recyclerview);

        contactRecyclerView = findViewById(R.id.recyclerview_base);
        //contactNameList = new ArrayList<>();

        //contentProviderRecyclerAdapter = new ContentProviderRecyclerAdapter(contactNameList);

        new LoadContacts().execute();
    }

    @SuppressLint("StaticFieldLeak")
    private class LoadContacts extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... voids) {
            contactNameList = readContacts();

            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);

            if (contactNameList != null && contactNameList.size() > 0) {

                // then set total contacts to subtitle
                //getSupportActionBar().setSubtitle(contactNameList.size() + " Contacts");
                //contentProviderRecyclerAdapter = null;
                contentProviderRecyclerAdapter = new ContentProviderRecyclerAdapter(contactNameList);
                contactRecyclerView.setAdapter(contentProviderRecyclerAdapter);// set adapter
                contentProviderRecyclerAdapter.notifyDataSetChanged();
            } else {
                // If adapter is null then show toast
                Toast.makeText(ContentProviderExampleActivity.this, "There are no contacts.", Toast.LENGTH_LONG).show();
            }

        }
    }

    private List<String> readContacts() {
        contactNameList = new ArrayList<>();
        Uri uri = ContactsContract.Contacts.CONTENT_URI; // Contact URI
        Cursor contactsCursor = getContentResolver().query(uri, null, null,
                null, ContactsContract.Contacts.DISPLAY_NAME + " ASC ");

        assert contactsCursor != null;
        if (contactsCursor.moveToFirst()) {
            do {
                long contctId = contactsCursor.getLong(contactsCursor
                        .getColumnIndex("_ID")); // Get contact ID
                Uri dataUri = ContactsContract.Data.CONTENT_URI; // URI to get
                // data of
                // contacts
                Cursor dataCursor = getContentResolver().query(dataUri, null,
                        ContactsContract.Data.CONTACT_ID + " = " + contctId,
                        null, null);

                String displayName = "";

                assert dataCursor != null;
                if (dataCursor.moveToFirst()) {
                    displayName = dataCursor
                            .getString(dataCursor
                                    .getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
                }
                contactNameList.add(displayName);
            } while (contactsCursor.moveToNext());
        }
        return contactNameList;
    }
}
