package com.example.materou;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import java.util.ArrayList;

public class UtilityActivity extends AppCompatActivity {

    ListViewAdapter adapter;
    ArrayList<Model> arrayList = new ArrayList<>();
    String[] latitide;
    ListView listView;
    String[] longitide;
    String[] title;
    String[] info;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_utility);
        this.listView = (ListView) findViewById(R.id.listView);
        this.title = new String[]{"ATM", "Gas Bills","TV Bills","Destiny School","Kasamba Secondary",
                "Water Bills", "Police Station","Waste Collection"};
        this.info = new String[]{"Bank services","Spectra Oil Service Station","Matero Mall","Education",
                "Education","Matero Mall", "Security Services","TrahBack Buy-back center Matero"};
        this.latitide = new String[]{"-15.383892401788867","-15.383961","-15.381420","-15.387825",
                "-15.387457","-15.381420","-15.382998","-15.387444"};
        this.longitide = new String[]{"28.26781824048382","28.268131","28.260443","28.256998",
                "28.264066","28.260443","28.268512","28.263906"};
        for (int i = 0; i < this.title.length; i++) {
            this.arrayList.add(new Model(this.title[i], this.info[i], this.latitide[i], this.longitide[i]));
        }
        ListViewAdapter listViewAdapter = new ListViewAdapter(this, this.arrayList);
        this.adapter = listViewAdapter;
        this.listView.setAdapter(listViewAdapter);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        ((SearchView) menu.findItem(R.id.action_search).getActionView()).setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            public boolean onQueryTextChange(String newText) {
                if (TextUtils.isEmpty(newText)) {
                    UtilityActivity.this.adapter.filter("");
                    UtilityActivity.this.listView.clearTextFilter();
                    return true;
                }
                UtilityActivity.this.adapter.filter(newText);
                return true;
            }
        });
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();
        if (itemId == R.id.action_about) {
            Toast.makeText(this, "About Page", Toast.LENGTH_SHORT).show();
        } else if (itemId == R.id.action_search) {
            return true;
        } else {
            if (itemId == R.id.action_utilities) {
                startActivity(new Intent(this, UtilityActivity.class));
            }
        }
        return super.onOptionsItemSelected(item);
    }
}