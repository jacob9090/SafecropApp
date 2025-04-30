package com.jacob.fruitoftek.safecrop.comdev.hh;

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

public class HhAdapter extends RecyclerView.Adapter<HhAdapter.HhViewHolder> {

    private List<HhModel> hhList;
    private List<HhModel> filteredList;
    private Context context;
    private OnEmptyStateListener onEmptyStateListener;

    public HhAdapter(Context context, List<HhModel> hhList) {
        this.context = context;
        this.hhList = hhList;
        this.filteredList = new ArrayList<>(hhList);
    }

    @NonNull
    @Override
    public HhAdapter.HhViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_hh, parent, false);
        return new HhAdapter.HhViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HhAdapter.HhViewHolder holder, int position) {
        HhModel model = filteredList.get(position);
        holder.nameTextView.setText(model.getHh_name());
        holder.districtTextView.setText(model.getHh_district());
        holder.communityTextView.setText(model.getHh_community());
//        holder.locationTextView.setText(model.getHh_location());
        holder.createdAtTextView.setText(model.getOnCreate());
//        holder.updatedAtTextView.setText(model.getOnUpdate());

//        String signaturePath = model.getSignature();
//        if (signaturePath != null && !signaturePath.isEmpty()) {
//            Bitmap bitmap = BitmapFactory.decodeFile(signaturePath);
//            if (bitmap != null) {
//                holder.signatureImage.setImageBitmap(bitmap);
//            } else {
//                holder.signatureImage.setImageResource(R.drawable.user); // Placeholder
//            }
//        } else {
//            holder.signatureImage.setImageResource(R.drawable.user); // Placeholder
//        }

        if (model.getFarmer_photo() != null) {
            holder.hhImage.setImageURI(model.getFarmer_photo());
        } else {
            holder.hhImage.setImageResource(R.drawable.farmer_not_found);
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
            filteredList.addAll(hhList);
        } else {
            for (HhModel model : hhList) {
                if (model.getHh_name().toLowerCase().contains(query.toLowerCase())) {
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
    public void updateList(List<HhModel> newList) {
        this.hhList = newList;              // Update the original list
        this.filteredList = new ArrayList<>(newList); // Update the filtered list
        notifyDataSetChanged();                 // Notify the adapter about the data change
    }

    private void showMoreDialog(int position, HhModel model) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Choose an option");
        builder.setItems(new CharSequence[]{"View details", "Update details"}, (dialog, which) -> {
            switch (which) {
                case 0: // VIEW
                    Intent viewIntent = new Intent(context, HhSurveyedDetailsActivity.class);
                    viewIntent.putExtra("hh_model", model);
                    context.startActivity(viewIntent);
                    break;
                case 1: // EDIT
                    Intent editIntent = new Intent(context, UpdateHhSurveyedActivity.class);
                    editIntent.putExtra("hh_model", model);
                    context.startActivity(editIntent);
                    break;
            }
        });
        builder.show();
    }

    public static class HhViewHolder extends RecyclerView.ViewHolder {
        public TextView nameTextView, districtTextView, communityTextView, locationTextView, createdAtTextView, updatedAtTextView;
        public ImageView hhImage, signatureImage;
        ImageButton moreOptions;

        public HhViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.nameTextView);
            districtTextView = itemView.findViewById(R.id.districtTextView);
            communityTextView = itemView.findViewById(R.id.communityTextView);
//            locationTextView = itemView.findViewById(R.id.locationTextView);
            hhImage = itemView.findViewById(R.id.photoTextView);
//            signatureImage = itemView.findViewById(R.id.signatureTextView);
            createdAtTextView = itemView.findViewById(R.id.createdAtTextView);
//            updatedAtTextView = itemView.findViewById(R.id.updatedAtTextView);
            moreOptions = itemView.findViewById(R.id.hhMoreBtn);
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
