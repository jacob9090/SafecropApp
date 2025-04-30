package com.jacob.fruitoftek.safecrop.comdev.com;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.jacob.fruitoftek.safecrop.R;

import java.util.ArrayList;
import java.util.List;

import android.content.Intent;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;

public class CommunityAdapter extends RecyclerView.Adapter<CommunityAdapter.ComViewHolder>{
    
    private List<ComModel> comlList;
    private List<ComModel> filteredList;
    private Context context;
    private OnEmptyStateListener onEmptyStateListener;

    public CommunityAdapter(Context context, List<ComModel> comlList) {
        this.context = context;
        this.comlList = comlList;
        this.filteredList = new ArrayList<>(comlList);
    }

    @NonNull
    @Override
    public CommunityAdapter.ComViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_community, parent, false);
        return new CommunityAdapter.ComViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CommunityAdapter.ComViewHolder holder, int position) {
        ComModel model = filteredList.get(position);
//        holder.nameTextView.setText(model.getCommquestion1());
        holder.districtTextView.setText(model.getCommquestion1());
        holder.communityTextView.setText(model.getCommquestion2());
//        holder.locationTextView.setText(model.getCom_location());
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
            holder.comImage.setImageURI(model.getFarmer_photo());
        } else {
            holder.comImage.setImageResource(R.drawable.farmer_not_found);
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
            filteredList.addAll(comlList);
        } else {
            for (ComModel model : comlList) {
                if (model.getCommquestion1().toLowerCase().contains(query.toLowerCase())) {
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
    public void updateList(List<ComModel> newList) {
        this.comlList = newList;
        this.filteredList = new ArrayList<>(newList);
        notifyDataSetChanged();
    }

    private void showMoreDialog(int position, ComModel model) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Choose an option");
        builder.setItems(new CharSequence[]{"View details", "Update details"}, (dialog, which) -> {
            switch (which) {
                case 0: // VIEW
                    Intent viewIntent = new Intent(context, CommunitySurveyedDetailsActivity.class);
                    viewIntent.putExtra("com_model", model);
                    context.startActivity(viewIntent);
                    break;
                case 1: // EDIT
                    Intent editIntent = new Intent(context, UpdateSurveyedCommunitiesActivity.class);
                    editIntent.putExtra("com_model", model);
                    context.startActivity(editIntent);
                    break;
            }
        });
        builder.show();
    }

    public static class ComViewHolder extends RecyclerView.ViewHolder {
        public TextView nameTextView, districtTextView, communityTextView, locationTextView, createdAtTextView, updatedAtTextView;
        public ImageView comImage, signatureImage;
        ImageButton moreOptions;

        public ComViewHolder(@NonNull View itemView) {
            super(itemView);
//            nameTextView = itemView.findViewById(R.id.nameTextView);
            districtTextView = itemView.findViewById(R.id.comdistrictTextView);
            communityTextView = itemView.findViewById(R.id.comcommunityTextView);
//            locationTextView = itemView.findViewById(R.id.locationTextView);
            comImage = itemView.findViewById(R.id.comphotoTextView);
//            signatureImage = itemView.findViewById(R.id.signatureTextView);
            createdAtTextView = itemView.findViewById(R.id.comcreatedAtTextView);
//            updatedAtTextView = itemView.findViewById(R.id.updatedAtTextView);
            moreOptions = itemView.findViewById(R.id.comMoreBtn);
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
