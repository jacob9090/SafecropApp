package com.jacob.fruitoftek.safecrop.comdev.lra;

import android.content.Context;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;

import com.jacob.fruitoftek.safecrop.R;

public class LraAdapter extends RecyclerView.Adapter<LraAdapter.LraViewHolder> {

    private List<LraModel> lraList;
    private List<LraModel> filteredList;
    private Context context;
    private LraAdapter.OnEmptyStateListener onEmptyStateListener;

    public LraAdapter(Context context, List<LraModel> lraList) {
        this.context = context;
        this.lraList = lraList;
        this.filteredList = new ArrayList<>(lraList);
    }

    @NonNull
    @Override
    public LraAdapter.LraViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_lra, parent, false);
        return new LraAdapter.LraViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LraAdapter.LraViewHolder holder, int position) {
        LraModel model = filteredList.get(position);
        holder.nameTextView.setText(model.getLraquestion1());
        holder.districtTextView.setText(model.getLraquestion2());
        holder.communityTextView.setText(model.getLraquestion3());
        holder.createdAtTextView.setText(model.getOnCreate());

        holder.moreOptions.setOnClickListener(v -> showMoreDialog(position, model));
    }

    @Override
    public int getItemCount() {
        return filteredList.size();
    }

    public void filter(String query) {
        filteredList.clear();
        if (query.isEmpty()) {
            filteredList.addAll(lraList);
        } else {
            for (LraModel model : lraList) {
                if (model.getLraquestion2().toLowerCase().contains(query.toLowerCase())) {
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
    public void updateList(List<LraModel> newList) {
        this.lraList = newList;
        this.filteredList = new ArrayList<>(newList);
        notifyDataSetChanged();
    }

    private void showMoreDialog(int position, LraModel model) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Choose an option");
        builder.setItems(new CharSequence[]{"View details", "Update details"}, (dialog, which) -> {
            switch (which) {
                case 0: // VIEW
                    Intent viewIntent = new Intent(context, LraSurveyedDetailsActivity.class);
                    viewIntent.putExtra("lra_model", model);
                    context.startActivity(viewIntent);
                    break;
                case 1: // EDIT
                    Intent editIntent = new Intent(context, UpdateLraSurveyeActivity.class);
                    editIntent.putExtra("lra_model", model);
                    context.startActivity(editIntent);
                    break;
            }
        });
        builder.show();
    }

    public static class LraViewHolder extends RecyclerView.ViewHolder {
        public TextView nameTextView, districtTextView, communityTextView, locationTextView, createdAtTextView, updatedAtTextView;
        public ImageView graImage, signatureImage;
        ImageButton moreOptions;

        public LraViewHolder(@NonNull View itemView) {
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

    public void setOnEmptyStateListener(LraAdapter.OnEmptyStateListener onEmptyStateListener) {
        this.onEmptyStateListener = onEmptyStateListener;
    }
}
