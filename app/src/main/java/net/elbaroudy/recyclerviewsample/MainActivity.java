package net.elbaroudy.recyclerviewsample;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ProgressBar loadingProgressBar;
    RecyclerView somethingRecyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        init();
        loadData(new NetworkCallback() {
            @Override
            public void onSuccess(List<Something> somethingList) {
                // Once we have the date we render it
                showData(somethingList);
            }
        });

    }

    private void showData(List<Something> data) {

        //First we hide the progressbar/spinner and show the recycler view
        loadingProgressBar.setVisibility(View.GONE);
        somethingRecyclerView.setVisibility(View.VISIBLE);

        //then we set the adapter and the data

        adapter = new SomethingAdapter(data);
        somethingRecyclerView.setAdapter(adapter);
    }

    private void loadData(final NetworkCallback callback) {
        // We simulate a network call by calling a callback after 10 seconds with the generated data.
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                List<Something> result = generateData(25);

                callback.onSuccess(result);
            }
        }, 10 * 1000);
    }

    private List<Something> generateData(int elements) {
        List <Something> result = new ArrayList<>();
        for (int elementPosition = 0; elementPosition < elements; elementPosition++) {
            double price = new Random().nextDouble();
            String name = "SomeName " + elementPosition;;
            Something element = new Something(String.valueOf(price), name, "Sunday");
            result.add(element);
        }
        return result;

    }

    private void init() {
        // Init views to reference them
        loadingProgressBar = findViewById(R.id.progressBar);
        somethingRecyclerView = findViewById(R.id.itemsList);

        //prepare the UI: First we show the progress spinner, and hide the recycler view
        loadingProgressBar.setVisibility(View.VISIBLE);
        somethingRecyclerView.setVisibility(View.INVISIBLE);

        //setup the recycler view
        layoutManager = new LinearLayoutManager(this);
        somethingRecyclerView.setLayoutManager(layoutManager);

    }
}
