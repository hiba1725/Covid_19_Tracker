package com.example.covid19tracker.ui.locations_list;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.covid19tracker.R;

import java.io.IOException;
import java.net.Socket;

import static androidx.lifecycle.ViewModelProviders.*;

public class LocationsListFragment extends Fragment {

    private LocationsListViewModel homeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(LocationsListViewModel.class);
        View root = inflater.inflate(R.layout.fragment_locations_list, container, false);
        final TableLayout locationsListTable = (TableLayout) root.findViewById(R.id.locations_list_table);
        TableRow row = new TableRow(getActivity());
        locationsListTable.addView(row, new TableLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        return root;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.locations_list_menu, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.action_sort_number:
                //sort locations by number of patients
                return true;
            case R.id.action_sort_name:
                //sort locations by name of locations
                return true;

            default:

                return super.onOptionsItemSelected(item);

        }

    }
}
