package com.digi.gadisolutions.ui.search
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.SearchView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.MenuItemCompat
import com.digi.gadisolutions.R



class SearchActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)
        getSupportActionBar()!!.setDisplayShowTitleEnabled(false);
    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.app_bar_menu, menu)
        val searchViewItem: MenuItem = menu.findItem(R.id.app_bar_search)
        val searchView =  MenuItemCompat.getActionView(searchViewItem) as SearchView
        searchView.onActionViewExpanded()
        searchView.setIconifiedByDefault(false);
        searchView.setQueryHint("search");


        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                searchView.clearFocus()
                /*   if(list.contains(query)){
                    adapter.getFilter().filter(query);
                }else{
                    Toast.makeText(MainActivity.this, "No Match found",Toast.LENGTH_LONG).show();
                }*/return false
            }

            override fun onQueryTextChange(newText: String): Boolean {
//                adapter.getFilter().filter(newText)
                return false
            }
        })

        return super.onCreateOptionsMenu(menu);
    }




}
