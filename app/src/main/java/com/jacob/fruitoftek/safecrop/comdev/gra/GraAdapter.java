package com.jacob.fruitoftek.safecrop.comdev.gra;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.jacob.fruitoftek.safecrop.R;

import java.util.ArrayList;
import java.util.List;

public class GraAdapter extends RecyclerView.Adapter<GraAdapter.GraViewHolder> {

    private List<GraModel> graList;
    private List<GraModel> filteredList;
    private Context context;
    private GraAdapter.OnEmptyStateListener onEmptyStateListener;

    public GraAdapter(Context context, List<GraModel> graList) {
        this.context = context;
        this.graList = graList;
        this.filteredList = new ArrayList<>(graList);
    }

    @NonNull
    @Override
    public GraAdapter.GraViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_gra, parent, false);
        return new GraAdapter.GraViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GraAdapter.GraViewHolder holder, int position) {
        GraModel model = filteredList.get(position);
        holder.nameTextView.setText(model.getGraquestion1());
        holder.districtTextView.setText(model.getGraquestion2());
        holder.communityTextView.setText(model.getGraquestion3());
        holder.createdAtTextView.setText(model.getOnCreate());

        if (model.getFarmer_photo() != null) {
            holder.graImage.setImageURI(model.getFarmer_photo());
        } else {
            holder.graImage.setImageResource(R.drawable.farmer_not_found);
        }

        holder.moreOptions.setOnClickListener(v -> showMoreDialog(position, model));
    }

    @Override
    public int getItemCount() {
        return filteredList.size();
    }

    public void filter(String query) {
        filteredList.clear();
        if (query.isEmpty()) {
            filteredList.addAll(graList);
        } else {
            for (GraModel model : graList) {
                if (model.getGraquestion2().toLowerCase().contains(query.toLowerCase())) {
                    filteredList.add(model);
                }
            }
        }

        // Notify empty state
        if (onEmptyStateListener != null) {
            onEmptyStateListener.onEmptyState(filteredList.isEmpty());
        }

        notifyDataSetChanged();
    }

    // Add updateList method
    public void updateList(List<GraModel> newList) {
        this.graList = newList;
        this.filteredList = new ArrayList<>(newList);
        notifyDataSetChanged();
    }

    private void showMoreDialog(int position, GraModel model) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Choose an option");
        builder.setItems(new CharSequence[]{"View details", "Update details"}, (dialog, which) -> {
            switch (which) {
                case 0: // VIEW
                    Intent viewIntent = new Intent(context, GraSurveyedDetailsActivity.class);
                    viewIntent.putExtra("gra_model", model);
                    context.startActivity(viewIntent);
                    break;
                case 1: // EDIT
                    Intent editIntent = new Intent(context, UpdateGraSurveyeActivity.class);
                    editIntent.putExtra("gra_model", model);
                    context.startActivity(editIntent);
                    break;
            }
        });
        builder.show();
    }

    public static class GraViewHolder extends RecyclerView.ViewHolder {
        public TextView nameTextView, districtTextView, communityTextView, locationTextView, createdAtTextView, updatedAtTextView;
        public ImageView graImage, signatureImage;
        ImageButton moreOptions;

        public GraViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.nameTextView);
            districtTextView = itemView.findViewById(R.id.districtTextView);
            communityTextView = itemView.findViewById(R.id.communityTextView);
            graImage = itemView.findViewById(R.id.photoView);
            createdAtTextView = itemView.findViewById(R.id.createdAtTextView);
            moreOptions = itemView.findViewById(R.id.graMoreBtn);
        }
    }

    // Callback interface
    public interface OnEmptyStateListener {
        void onEmptyState(boolean isEmpty);
    }

    public void setOnEmptyStateListener(GraAdapter.OnEmptyStateListener onEmptyStateListener) {
        this.onEmptyStateListener = onEmptyStateListener;
    }
}