package krishnaapps.com.viewmodelretrofitexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.List;

import krishnaapps.com.viewmodelretrofitexample.Adapter.RecyclerViewData;
import krishnaapps.com.viewmodelretrofitexample.Model.Hero;
import krishnaapps.com.viewmodelretrofitexample.viewModel.HeroViewModel;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerViewData recyclerViewData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        HeroViewModel heroViewModel = ViewModelProviders.of(this).get(HeroViewModel.class);
        heroViewModel.getHeroes().observe(this, new Observer<List<Hero>>() {
            @Override
            public void onChanged(List<Hero> list) {
                recyclerViewData = new RecyclerViewData(MainActivity.this, list);
                recyclerView.setAdapter(recyclerViewData);
            }
        });
    }
}
