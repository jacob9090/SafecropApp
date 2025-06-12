package com.jacob.fruitoftek.safecrop.sustain.traintopic;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.jacob.fruitoftek.safecrop.R;

import java.util.ArrayList;
import java.util.List;
import android.widget.Filter;
import android.widget.Filterable;

public class TrainingListAdapter extends RecyclerView.Adapter<TrainingListAdapter.TrainingListHolder> implements Filterable {

    private List<TrainingListModal> trainingList;
    private List<TrainingListModal> trainingListFull; // A full copy for filtering
    private final OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(TrainingListModal training);
    }

    public TrainingListAdapter(List<TrainingListModal> trainingList, OnItemClickListener listener) {
        this.trainingList = trainingList;
        this.trainingListFull = new ArrayList<>(trainingList); // Keep a copy of the full list
        this.listener = listener;
    }

    public void updateList(List<TrainingListModal> newList) {
        trainingList = newList;
        trainingListFull = new ArrayList<>(newList); // Update the full list as well
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public TrainingListHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_training_layout, parent, false);
        return new TrainingListHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TrainingListHolder holder, int position) {
        TrainingListModal training = trainingList.get(position);
        holder.bind(training, listener);
    }

    @Override
    public int getItemCount() {
        return trainingList.size();
    }

    @Override
    public Filter getFilter() {
        return trainingFilter;
    }

    private final Filter trainingFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<TrainingListModal> filteredList = new ArrayList<>();
            if (constraint == null || constraint.length() == 0) {
                filteredList.addAll(trainingListFull);
            } else {
                String filterPattern = constraint.toString().toLowerCase().trim();
                for (TrainingListModal item : trainingListFull) {
                    if (item.getTopic().toLowerCase().contains(filterPattern)) {
                        filteredList.add(item);
                    }
                }
            }
            FilterResults results = new FilterResults();
            results.values = filteredList;
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            trainingList.clear();
            trainingList.addAll((List) results.values);
            notifyDataSetChanged();
        }
    };

    public static class TrainingListHolder extends RecyclerView.ViewHolder {

        private final TextView topic;
        private final TextView description;

        public TrainingListHolder(@NonNull View itemView) {
            super(itemView);
            topic = itemView.findViewById(R.id.topicTv);
            description = itemView.findViewById(R.id.descriptionTv);
        }

        public void bind(final TrainingListModal training, final OnItemClickListener listener) {
            topic.setText(training.getTopic());
            description.setText(training.getDescription());

            itemView.setOnClickListener(v -> listener.onItemClick(training));
        }
    }
}
