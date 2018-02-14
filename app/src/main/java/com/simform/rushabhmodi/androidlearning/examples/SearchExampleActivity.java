package com.simform.rushabhmodi.androidlearning.examples;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.simform.rushabhmodi.androidlearning.R;
import com.simform.rushabhmodi.androidlearning.adapter.SearchAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class SearchExampleActivity extends AppCompatActivity {

    private SearchView searchSearchView;
    private ListView searchListView;

    private List<String> searchStringList;
    private ArrayAdapter<String> searchAdapter;

    private SearchAdapter customSearchAdapter;

    private String searchType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_example);

        searchSearchView = findViewById(R.id.searchview_search);
        searchListView = findViewById(R.id.listview_search);

        searchType = getIntent().getStringExtra(getString(R.string.search_type));

        searchStringList = new ArrayList<>();
        searchStringList.add("One");
        searchStringList.add("Two");
        searchStringList.add("Three");
        searchStringList.add("Four");
        searchStringList.add("Five");
        searchStringList.add("Six");
        searchStringList.add("Seven");
        searchStringList.add("Eight");
        searchStringList.add("Nine");
        searchStringList.add("Ten");
        searchStringList.add("Eleven");
        searchStringList.add("Twelve");
        searchStringList.add("Thirteen");
        searchStringList.add("Fourteen");
        searchStringList.add("Fifteen");

        if (Objects.equals(searchType, getString(R.string.search_simple))) {
            searchAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, searchStringList);
            searchListView.setAdapter(searchAdapter);
        } else if (Objects.equals(searchType, getString(R.string.search_enhanced))) {
            customSearchAdapter = new SearchAdapter(searchStringList);
            searchListView.setAdapter(customSearchAdapter);
        }

        searchListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getBaseContext(), adapterView.getItemAtPosition(i).toString(), Toast.LENGTH_SHORT).show();
            }
        });

        searchSearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if (Objects.equals(searchType, getString(R.string.search_simple))) {
                    searchAdapter.getFilter().filter(newText);
                } else if (Objects.equals(searchType, getString(R.string.search_enhanced))) {
                    customSearchAdapter.getFilter().filter(newText);
                }
                return false;
            }
        });

    }
}
