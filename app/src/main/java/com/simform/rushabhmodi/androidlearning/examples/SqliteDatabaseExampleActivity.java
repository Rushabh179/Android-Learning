package com.simform.rushabhmodi.androidlearning.examples;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.simform.rushabhmodi.androidlearning.R;
import com.simform.rushabhmodi.androidlearning.other.SqliteHelper;
import com.simform.rushabhmodi.androidlearning.other.SqlitePojo;

public class SqliteDatabaseExampleActivity extends AppCompatActivity {

    private EditText writeSqlite;
    private TextView readSqlite;
    private SqliteHelper sqliteHelper;
    private SqlitePojo sqlitePojo;
    private String dbString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite_database_example);

        writeSqlite = findViewById(R.id.edittext_sqlite_write);
        readSqlite = findViewById(R.id.textview_sqlite_read);
        sqlitePojo = new SqlitePojo();
        sqliteHelper = new SqliteHelper(this, null, null, 1);
        printDatabase();
    }

    public void onSqliteClick(View view) {
        switch (view.getId()) {
            case R.id.btn_sqlite_insert:
                sqlitePojo.setItem(writeSqlite.getText().toString());
                sqliteHelper.insertItem(sqlitePojo);
                printDatabase();
                break;

            case R.id.btn_sqlite_delete:
                sqliteHelper.deleteItem(writeSqlite.getText().toString());
                printDatabase();
                break;
        }
    }

    private void printDatabase() {
        dbString = sqliteHelper.dbToString();
        readSqlite.setText(dbString);
        writeSqlite.setText("");
    }
}
