package net.elbaroudy.recyclerviewsample;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

class SomethingAdapter extends RecyclerView.Adapter {

    private final List<Something> data;

    public SomethingAdapter(List<Something> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int position) {
        // We create/inflate the row view
        View rowView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.something_item_layout, parent, false);

        return new SomethingViewHolder(rowView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        ((SomethingViewHolder) viewHolder).render(data.get(i));
    }

    @Override
    public int getItemCount() {
        // We return the numbers of elements our data set has, IMPORTANT: Auto generated config by
        // Android Studio returns 0  and then the recycler view is always empty.
        return data.size();
    }

    public static class SomethingViewHolder extends RecyclerView.ViewHolder {
        // This class "holds" the views contained on every row
        // we create it with the containing row and then we use it to "find views" of the desired
        // elements

        // we also add a render method which will know how to paint the row

        TextView price;
        TextView name;
        TextView day;

        SomethingViewHolder(View v) {
            super(v);
            price = v.findViewById(R.id.tvPrice);
            name = v.findViewById(R.id.tvName);
            day = v.findViewById(R.id.tvDay);


            price.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(view.getContext(),
                            " You clicked on price", Toast.LENGTH_LONG).show();
                }
            });
        }

        void render(Something something) {
            // here we "draw/render" the elements
            name.setText(something.getName());
            price.setText(String.format("%s €", something.getPrice()));
            day.setText(something.getDay());
        }


    }
}
