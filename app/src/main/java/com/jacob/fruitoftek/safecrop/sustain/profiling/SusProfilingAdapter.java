package com.jacob.fruitoftek.safecrop.sustain.profiling;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.jacob.fruitoftek.safecrop.R;

import android.content.Intent;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.appcompat.app.AlertDialog;

public class SusProfilingAdapter extends RecyclerView.Adapter<SusProfilingAdapter.SusProfilingViewHolder> {

    private List<SusProfilingModel> susprofilingList;
    private List<SusProfilingModel> filteredList;
    private Context context;
    private OnEmptyStateListener onEmptyStateListener;

    public SusProfilingAdapter(Context context, List<SusProfilingModel> susprofilingList) {
        this.context = context;
        this.susprofilingList = susprofilingList;
        this.filteredList = new ArrayList<>(susprofilingList);
    }

    @NonNull
    @Override
    public SusProfilingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_susprofiling, parent, false);
        return new SusProfilingViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SusProfilingViewHolder holder, int position) {
        SusProfilingModel model = filteredList.get(position);
        holder.nameTextView.setText(model.getFarmer_id());
        holder.districtTextView.setText(model.getFarmer_name());
        holder.communityTextView.setText(model.getDistrict());
        holder.createdAtTextView.setText(model.getOnCreate());

//        if (model.getSignature() != null) {
//            holder.peproImage.setImageURI(model.getSignature());
//        } else {
//            holder.peproImage.setImageResource(R.drawable.farmer_not_found);
//        }

        holder.moreOptions.setOnClickListener(v -> showMoreDialog(position, model));
    }

    @Override
    public int getItemCount() {
        return filteredList.size();
    }

    public void filter(String query) {
        filteredList.clear();
        if (query.isEmpty()) {
            filteredList.addAll(susprofilingList);
        } else {
            for (SusProfilingModel model : susprofilingList) {
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
    public void updateList(List<SusProfilingModel> newList) {
        this.susprofilingList = newList;
        this.filteredList = new ArrayList<>(newList);
        notifyDataSetChanged();
    }

    private void showMoreDialog(int position, SusProfilingModel model) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Choose an option");
        builder.setItems(new CharSequence[]{"View details", "Update details"}, (dialog, which) -> {
            switch (which) {
                case 0: // VIEW
                    Intent viewIntent = new Intent(context, SusProfilingDetailsActivity.class);
                    viewIntent.putExtra("susprofiling_model", model);
                    context.startActivity(viewIntent);
                    break;
                case 1: // EDIT
                    Intent editIntent = new Intent(context, UpdateProfilingActivity.class);
                    editIntent.putExtra("susprofiling_model", model);
                    context.startActivity(editIntent);
                    break;
            }
        });
        builder.show();
    }

    public static class SusProfilingViewHolder extends RecyclerView.ViewHolder {
        public TextView nameTextView, districtTextView, communityTextView, createdAtTextView;
        ImageButton moreOptions;

        public SusProfilingViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.nameTextView);
            districtTextView = itemView.findViewById(R.id.districtTextView);
            communityTextView = itemView.findViewById(R.id.communityTextView);
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
