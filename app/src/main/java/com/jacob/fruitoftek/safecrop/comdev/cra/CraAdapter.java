package com.jacob.fruitoftek.safecrop.comdev.cra;

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

public class CraAdapter extends RecyclerView.Adapter<CraAdapter.GraViewHolder> {

    private List<CraModel> craList;
    private List<CraModel> filteredList;
    private Context context;
    private CraAdapter.OnEmptyStateListener onEmptyStateListener;

    public CraAdapter(Context context, List<CraModel> craList) {
        this.context = context;
        this.craList = craList;
        this.filteredList = new ArrayList<>(craList);
    }

    @NonNull
    @Override
    public CraAdapter.GraViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cra, parent, false);
        return new CraAdapter.GraViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CraAdapter.GraViewHolder holder, int position) {
        CraModel model = filteredList.get(position);
        holder.nameTextView.setText(model.getCraquestion1());
        holder.districtTextView.setText(model.getCraquestion2());
        holder.communityTextView.setText(model.getCraquestion3());
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
            filteredList.addAll(craList);
        } else {
            for (CraModel model : craList) {
                if (model.getCraquestion2().toLowerCase().contains(query.toLowerCase())) {
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
    public void updateList(List<CraModel> newList) {
        this.craList = newList;
        this.filteredList = new ArrayList<>(newList);
        notifyDataSetChanged();
    }

    private void showMoreDialog(int position, CraModel model) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Choose an option");
        builder.setItems(new CharSequence[]{"View details", "Update details"}, (dialog, which) -> {
            switch (which) {
                case 0: // VIEW
                    Intent viewIntent = new Intent(context, CraSurveyedDetailsActivity.class);
                    viewIntent.putExtra("gra_model", model);
                    context.startActivity(viewIntent);
                    break;
                case 1: // EDIT
                    Intent editIntent = new Intent(context, UpdateCraSurveyeActivity.class);
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

    public void setOnEmptyStateListener(CraAdapter.OnEmptyStateListener onEmptyStateListener) {
        this.onEmptyStateListener = onEmptyStateListener;
    }
}
