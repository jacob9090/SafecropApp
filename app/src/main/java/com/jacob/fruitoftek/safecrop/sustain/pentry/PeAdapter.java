package com.jacob.fruitoftek.safecrop.sustain.pentry;

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

public class PeAdapter extends RecyclerView.Adapter<PeAdapter.PEProViewHolder> {

    private List<PeModel> peList;
    private List<PeModel> filteredList;
    private Context context;
    private OnEmptyStateListener onEmptyStateListener;

    public PeAdapter(Context context, List<PeModel> peList) {
        this.context = context;
        this.peList = peList;
        this.filteredList = new ArrayList<>(peList);
    }

    @NonNull
    @Override
    public PeAdapter.PEProViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pe, parent, false);
        return new PeAdapter.PEProViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PeAdapter.PEProViewHolder holder, int position) {
        PeModel model = filteredList.get(position);
        holder.nameTextView.setText(model.getPequestion3());
        holder.districtTextView.setText(model.getPequestion1());
        holder.communityTextView.setText(model.getPequestion2());
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
            filteredList.addAll(peList);
        } else {
            for (PeModel model : peList) {
                if (model.getPequestion4().toLowerCase().contains(query.toLowerCase())) {
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
    public void updateList(List<PeModel> newList) {
        this.peList = newList;
        this.filteredList = new ArrayList<>(newList);
        notifyDataSetChanged();
    }

    private void showMoreDialog(int position, PeModel model) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Choose an option");
        builder.setItems(new CharSequence[]{"View details", "Update details"}, (dialog, which) -> {
            switch (which) {
                case 0: // VIEW
                    Intent viewIntent = new Intent(context, PEnteryDetailsActivity.class);
                    viewIntent.putExtra("pe_model", model);
                    context.startActivity(viewIntent);
                    break;
                case 1: // EDIT
//                    Intent editIntent = new Intent(context, UpdateSurveyedOrgProActivity.class);
//                    editIntent.putExtra("pe_model", model);
//                    context.startActivity(editIntent);
                    break;
            }
        });
        builder.show();
    }

    public static class PEProViewHolder extends RecyclerView.ViewHolder {
        public TextView nameTextView, districtTextView, communityTextView, createdAtTextView;
        public ImageView peproImage;
        ImageButton moreOptions;

        public PEProViewHolder(@NonNull View itemView) {
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
