package com.simform.rushabhmodi.androidlearning.exampleactivities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.simform.rushabhmodi.androidlearning.R;
import com.simform.rushabhmodi.androidlearning.other.SqliteHelper;
import com.simform.rushabhmodi.androidlearning.model.SqlitePojo;

public class SqliteDatabaseExampleActivity extends AppCompatActivity {

    private EditText numberSqlite, itemSqlite, descriptionSqlite;
    private TextView readSqlite;
    private SqliteHelper sqliteHelper;
    private SqlitePojo sqlitePojo;
    private String dbString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite_database_example);

        if (getSupportActionBar() != null)
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        numberSqlite = findViewById(R.id.edittext_sqlite_number);
        itemSqlite = findViewById(R.id.edittext_sqlite_item);
        descriptionSqlite = findViewById(R.id.edittext_sqlite_description);
        readSqlite = findViewById(R.id.textview_sqlite_read);
        sqlitePojo = new SqlitePojo();
        sqliteHelper = new SqliteHelper(this, null);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        finish();
        return false;
    }

    public void onSqliteClick(View view) {
        switch (view.getId()) {
            case R.id.btn_sqlite_insert:
                /*sqlitePojo = new SqlitePojo(Integer.parseInt(numberSqlite.getText().toString()),
                        itemSqlite.getText().toString(),
                        descriptionSqlite.getText().toString());*/
                if (numberSqlite.getText().toString().isEmpty()) {
                    sqlitePojo.setNumber(0);
                } else {
                    sqlitePojo.setNumber(Integer.parseInt(numberSqlite.getText().toString()));
                }
                sqlitePojo.setItem(itemSqlite.getText().toString());
                sqlitePojo.setDescription(descriptionSqlite.getText().toString());
                sqliteHelper.insertItem(sqlitePojo);
                printDatabase();
                break;

            case R.id.btn_sqlite_delete:
                sqliteHelper.deleteItem(itemSqlite.getText().toString());
                printDatabase();
                break;

            case R.id.btn_sqlite_show:
                printDatabase();
                break;
        }
    }

    private void printDatabase() {
        dbString = sqliteHelper.dbToString();
        readSqlite.setText(dbString);
        numberSqlite.setText("");
        itemSqlite.setText("");
        descriptionSqlite.setText("");
    }
}
