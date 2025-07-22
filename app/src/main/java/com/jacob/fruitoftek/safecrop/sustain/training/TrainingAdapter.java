package com.jacob.fruitoftek.safecrop.sustain.training;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import android.content.Intent;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;

import com.jacob.fruitoftek.safecrop.R;

public class TrainingAdapter extends RecyclerView.Adapter<TrainingAdapter.TrainingViewHolder> {

    private List<TrainingModel> trainingList;
    private List<TrainingModel> filteredList;
    private Context context;
    private OnEmptyStateListener onEmptyStateListener;

    public TrainingAdapter(Context context, List<TrainingModel> trainingList) {
        this.context = context;
        this.trainingList = trainingList;
        this.filteredList = new ArrayList<>(trainingList);
    }

    @NonNull
    @Override
    public TrainingAdapter.TrainingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_training, parent, false);
        return new TrainingAdapter.TrainingViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TrainingAdapter.TrainingViewHolder holder, int position) {
        TrainingModel model = filteredList.get(position);
        holder.farmerIDTv.setText(model.getTraining_code());
//        holder.farmerNameTv.setText(model.getCommunity());
        holder.districtTv.setText(model.getDistrict());
        holder.communityTv.setText(model.getCommunity());
        holder.createdAtTextView.setText(model.getOnCreate());

        if (model.getFarmer_photo() != null) {
            holder.peproImage.setImageURI(model.getFarmer_photo());
        } else {
            holder.peproImage.setImageResource(R.drawable.farmer_not_found);
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
            filteredList.addAll(trainingList);
        } else {
            for (TrainingModel model : trainingList) {
                if (model.getTraining_code().toLowerCase().contains(query.toLowerCase())) {
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
    public void updateList(List<TrainingModel> newList) {
        this.trainingList = newList;
        this.filteredList = new ArrayList<>(newList);
        notifyDataSetChanged();
    }

    private void showMoreDialog(int position, TrainingModel model) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Choose an option");
        builder.setItems(new CharSequence[]{"View details", "Update details"}, (dialog, which) -> {
            switch (which) {
                case 0: // VIEW
                    Intent viewIntent = new Intent(context, TrainingDetailsActivity.class);
                    viewIntent.putExtra("training_model", model);
                    context.startActivity(viewIntent);
                    break;
                case 1: // EDIT
                    Intent editIntent = new Intent(context, UpdateTrainingActivity.class);
                    editIntent.putExtra("training_model", model);
                    context.startActivity(editIntent);
                    break;
            }
        });
        builder.show();
    }

    public static class TrainingViewHolder extends RecyclerView.ViewHolder {
        public TextView farmerIDTv, districtTv, communityTv, createdAtTextView;
        public ImageView peproImage;
        ImageButton moreOptions;

        public TrainingViewHolder(@NonNull View itemView) {
            super(itemView);
            farmerIDTv = itemView.findViewById(R.id.farmerIDTv);
//            farmerNameTv = itemView.findViewById(R.id.farmerNameTv);
            districtTv = itemView.findViewById(R.id.districtTv);
            communityTv = itemView.findViewById(R.id.communityTv);
            peproImage = itemView.findViewById(R.id.photoTextView);
            createdAtTextView = itemView.findViewById(R.id.createdAtTextView);
            moreOptions = itemView.findViewById(R.id.peMoreBtn);
        }
    }

    // Callback interface
    public interface OnEmptyStateListener {
        void onEmptyState(boolean isEmpty);
    }

    public void setOnEmptyStateListener(OnEmptyStateListener onEmptyStateListener) {
        this.onEmptyStateListener = onEmptyStateListener;
    }
}
