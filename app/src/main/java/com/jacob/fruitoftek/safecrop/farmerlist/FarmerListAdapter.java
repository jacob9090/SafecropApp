package com.jacob.fruitoftek.safecrop.farmerlist;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.jacob.fruitoftek.safecrop.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;
import android.widget.Filter;
import android.widget.Filterable;

public class FarmerListAdapter extends RecyclerView.Adapter<FarmerListAdapter.FarmerListHolder> implements Filterable {

    private List<FarmerListModal> farmerList;
    private List<FarmerListModal> farmerListFull; // A full copy for filtering
    private final OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(FarmerListModal farmer);
    }

    public FarmerListAdapter(List<FarmerListModal> farmerList, OnItemClickListener listener) {
        this.farmerList = farmerList;
        this.farmerListFull = new ArrayList<>(farmerList); // Keep a copy of the full list
        this.listener = listener;
    }

    public void updateList(List<FarmerListModal> newList) {
        farmerList = newList;
        farmerListFull = new ArrayList<>(newList); // Update the full list as well
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public FarmerListHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_farmer_layout, parent, false);
        return new FarmerListHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FarmerListHolder holder, int position) {
        FarmerListModal farmer = farmerList.get(position);
        holder.bind(farmer, listener);
    }

    @Override
    public int getItemCount() {
        return farmerList.size();
    }

    @Override
    public Filter getFilter() {
        return farmerFilter;
    }

    private final Filter farmerFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<FarmerListModal> filteredList = new ArrayList<>();
            if (constraint == null || constraint.length() == 0) {
                filteredList.addAll(farmerListFull);
            } else {
                String filterPattern = constraint.toString().toLowerCase().trim();
                for (FarmerListModal item : farmerListFull) {
                    if (item.getFid().toLowerCase().contains(filterPattern)) {
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
            farmerList.clear();
            farmerList.addAll((List) results.values);
            notifyDataSetChanged();
        }
    };

    public static class FarmerListHolder extends RecyclerView.ViewHolder {

        private final TextView fid;
        private final TextView name;
        private final TextView surname;
        private final TextView district;
        private final TextView village;
        private final ImageView photo;

        public FarmerListHolder(@NonNull View itemView) {
            super(itemView);
            fid = itemView.findViewById(R.id.fidTv);
            name = itemView.findViewById(R.id.nameTv);
            surname = itemView.findViewById(R.id.surnameTv);
            district = itemView.findViewById(R.id.districtTv);
            village = itemView.findViewById(R.id.villageTv);
            photo = itemView.findViewById(R.id.imgPhoto);
        }

        public void bind(final FarmerListModal farmer, final OnItemClickListener listener) {
            fid.setText(farmer.getFid());
            name.setText(farmer.getName());
            surname.setText(farmer.getSurname());
            district.setText(farmer.getDistrict());
            village.setText(farmer.getVillage());

            String photoUrl = farmer.getPhoto();
            if (photoUrl == null || photoUrl.isEmpty()) {
                photo.setImageResource(R.drawable.user); // Placeholder
            } else {
                Picasso.get()
                        .load(photoUrl)
                        .error(R.drawable.user) // Fallback for failed loads
                        .placeholder(R.drawable.user) // Placeholder while loading
                        .into(photo);
            }

            itemView.setOnClickListener(v -> listener.onItemClick(farmer));
        }
    }
}
