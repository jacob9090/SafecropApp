package com.jacob.fruitoftek.safecrop.comdev.obs;

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

public class ObsAdapter extends RecyclerView.Adapter<ObsAdapter.ObsViewHolder> {

    private List<ObsModel> obsList;
    private List<ObsModel> filteredList;
    private Context context;
    private OnEmptyStateListener onEmptyStateListener;

    public ObsAdapter(Context context, List<ObsModel> obsList) {
        this.context = context;
        this.obsList = obsList;
        this.filteredList = new ArrayList<>(obsList);
    }

    @NonNull
    @Override
    public ObsAdapter.ObsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_obs, parent, false);
        return new ObsAdapter.ObsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ObsAdapter.ObsViewHolder holder, int position) {
        ObsModel model = filteredList.get(position);
        holder.nameTextView.setText(model.getObs_name());
        holder.districtTextView.setText(model.getObs_district());
        holder.communityTextView.setText(model.getObs_community());
        holder.createdAtTextView.setText(model.getOnCreate());

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
            holder.obsImage.setImageURI(model.getFarmer_photo());
        } else {
            holder.obsImage.setImageResource(R.drawable.farmer_not_found);
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
            filteredList.addAll(obsList);
        } else {
            for (ObsModel model : obsList) {
                if (model.getObs_name().toLowerCase().contains(query.toLowerCase())) {
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
    public void updateList(List<ObsModel> newList) {
        this.obsList = newList;
        this.filteredList = new ArrayList<>(newList);
        notifyDataSetChanged();
    }

    private void showMoreDialog(int position, ObsModel model) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Choose an option");
        builder.setItems(new CharSequence[]{"View details", "Update details"}, (dialog, which) -> {
            switch (which) {
                case 0: // VIEW
                    Intent viewIntent = new Intent(context, ObsSurveyedDetailsActivity.class);
                    viewIntent.putExtra("obs_model", model);
                    context.startActivity(viewIntent);
                    break;
                case 1: // EDIT
                    Intent editIntent = new Intent(context, UpdateSurveyedObsActivity.class);
                    editIntent.putExtra("obs_model", model);
                    context.startActivity(editIntent);
                    break;
            }
        });
        builder.show();
    }

    public static class ObsViewHolder extends RecyclerView.ViewHolder {
        public TextView nameTextView, districtTextView, communityTextView, locationTextView, createdAtTextView, updatedAtTextView;
        public ImageView obsImage, signatureImage;
        ImageButton moreOptions;

        public ObsViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.nameTextView);
            districtTextView = itemView.findViewById(R.id.districtTextView);
            communityTextView = itemView.findViewById(R.id.communityTextView);
            obsImage = itemView.findViewById(R.id.photoTextView);
            createdAtTextView = itemView.findViewById(R.id.createdAtTextView);
            moreOptions = itemView.findViewById(R.id.obsMoreBtn);
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
