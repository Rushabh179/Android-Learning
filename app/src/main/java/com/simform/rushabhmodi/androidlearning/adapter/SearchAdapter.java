package com.simform.rushabhmodi.androidlearning.adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import com.simform.rushabhmodi.androidlearning.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rushabh.modi on 13/02/18.
 */

public class SearchAdapter extends BaseAdapter implements Filterable {

    List<String> dataList;
    List<String> stringFilterList;
    ValueFilter valueFilter;
    private LayoutInflater layoutInflater;

    private TextView searchListTextView;

    public SearchAdapter(List<String> searchStringList) {
        dataList = searchStringList;
        stringFilterList = searchStringList;
    }

    @Override
    public int getCount() {
        return dataList.size();
    }

    @Override
    public String getItem(int position) {
        return dataList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @SuppressLint("ViewHolder")
    @Override
    public View getView(int position, View convertView, final ViewGroup parent) {
        layoutInflater = LayoutInflater.from(parent.getContext());
        convertView = layoutInflater.inflate(R.layout.list_item_search, parent, false);
        searchListTextView = convertView.findViewById(R.id.textview_search_list);
        searchListTextView.setText(dataList.get(position));
        return convertView;
    }

    @Override
    public Filter getFilter() {
        if (valueFilter == null) {
            valueFilter = new ValueFilter();
        }
        return valueFilter;
    }

    private class ValueFilter extends Filter {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            FilterResults results = new FilterResults();

            if (constraint != null && constraint.length() > 0) {
                List<String> filterList = new ArrayList<>();
                for (int i = 0; i < stringFilterList.size(); i++) {
                    if ((stringFilterList.get(i).toUpperCase()).contains(constraint.toString().toUpperCase())) {
                        filterList.add(stringFilterList.get(i));
                    }
                }
                results.count = filterList.size();
                results.values = filterList;
            } else {
                results.count = stringFilterList.size();
                results.values = stringFilterList;
            }
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            //noinspection unchecked
            dataList = (List<String>) results.values;
            notifyDataSetChanged();
        }
    }
}
