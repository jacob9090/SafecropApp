package com.jacob.fruitoftek.safecrop.sustain.inspection;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import android.content.Intent;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;

import com.jacob.fruitoftek.safecrop.R;

public class InspectionAdapter extends RecyclerView.Adapter<InspectionAdapter.InspectionViewHolder> {

    private List<InspectionModel> inspectionList;
    private List<InspectionModel> filteredList;
    private Context context;
    private OnEmptyStateListener onEmptyStateListener;

    public InspectionAdapter(Context context, List<InspectionModel> inspectionList) {
        this.context = context;
        this.inspectionList = inspectionList;
        this.filteredList = new ArrayList<>(inspectionList);
    }

    @NonNull
    @Override
    public InspectionAdapter.InspectionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_inspection, parent, false);
        return new InspectionAdapter.InspectionViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull InspectionAdapter.InspectionViewHolder holder, int position) {
        InspectionModel model = filteredList.get(position);
        holder.nameTextView.setText(model.getFarmer_id());
        holder.districtTextView.setText(model.getFarmer_name());
        holder.communityTextView.setText(model.getDistrict());
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
            filteredList.addAll(inspectionList);
        } else {
            for (InspectionModel model : inspectionList) {
                if (model.getFarmer_id().toLowerCase().contains(query.toLowerCase())) {
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
    public void updateList(List<InspectionModel> newList) {
        this.inspectionList = newList;
        this.filteredList = new ArrayList<>(newList);
        notifyDataSetChanged();
    }

    private void showMoreDialog(int position, InspectionModel model) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Choose an option");
        builder.setItems(new CharSequence[]{"View details", "Update details"}, (dialog, which) -> {
            switch (which) {
                case 0: // VIEW
                    Intent viewIntent = new Intent(context, InspectionDetailsActivity.class);
                    viewIntent.putExtra("inspection_model", model);
                    context.startActivity(viewIntent);
                    break;
                case 1: // EDIT
                    Intent editIntent = new Intent(context, UpdateInspectionActivity.class);
                    editIntent.putExtra("inspection_model", model);
                    context.startActivity(editIntent);
                    break;
            }
        });
        builder.show();
    }

    public static class InspectionViewHolder extends RecyclerView.ViewHolder {
        public TextView nameTextView, districtTextView, communityTextView, createdAtTextView;
        public ImageView peproImage;
        ImageButton moreOptions;

        public InspectionViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.nameTextView);
            districtTextView = itemView.findViewById(R.id.districtTextView);
            communityTextView = itemView.findViewById(R.id.communityTextView);
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