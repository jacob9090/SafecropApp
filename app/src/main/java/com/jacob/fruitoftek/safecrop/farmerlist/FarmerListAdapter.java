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
    private final List<FarmerListModal> farmerListFull;
    private final OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(FarmerListModal farmer);
    }

    public FarmerListAdapter(List<FarmerListModal> farmerList, OnItemClickListener listener) {
        this.farmerList = new ArrayList<>(farmerList);
        this.farmerListFull = new ArrayList<>(farmerList);
        this.listener = listener;
    }

    public void updateList(List<FarmerListModal> newList) {
        // Clear both lists and add new data
        farmerList.clear();
        farmerList.addAll(newList);
        farmerListFull.clear();
        farmerListFull.addAll(newList);
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
                    // Consider other fields for search, e.g., farmer name, community, etc.
                    if (item.getFarmer_id().toLowerCase().contains(filterPattern) ||
                            item.getFarmer_name().toLowerCase().contains(filterPattern) ||
                            item.getCommunity().toLowerCase().contains(filterPattern) ||
                            item.getDistrict().toLowerCase().contains(filterPattern)) {
                        filteredList.add(item);
                    }
                }
            }
            FilterResults results = new FilterResults();
            results.values = filteredList;
            results.count = filteredList.size(); // It's good practice to set count
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            // This is where the unchecked cast warning occurs
            // Fix: Cast to the specific generic type List<FarmerListModal>
            farmerList.clear();
            if (results.values != null) {
                farmerList.addAll((List<FarmerListModal>) results.values);
            }
            notifyDataSetChanged();
        }
    };

    public static class FarmerListHolder extends RecyclerView.ViewHolder {

        private final TextView farmer_id;
        private final TextView farmer_name;
        private final TextView district;
        private final TextView community;
        private final ImageView photo;

        public FarmerListHolder(@NonNull View itemView) {
            super(itemView);
            farmer_id = itemView.findViewById(R.id.farmer_idTv);
            farmer_name = itemView.findViewById(R.id.farmer_nameTv);
            district = itemView.findViewById(R.id.districtTv);
            community = itemView.findViewById(R.id.communityTv);
            photo = itemView.findViewById(R.id.imgPhoto);
        }

        public void bind(final FarmerListModal farmer, final OnItemClickListener listener) {
            farmer_id.setText(farmer.getFarmer_id());
            farmer_name.setText(farmer.getFarmer_name());
            district.setText(farmer.getDistrict());
            community.setText(farmer.getCommunity());

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


//public class FarmerListAdapter extends RecyclerView.Adapter<FarmerListAdapter.FarmerListHolder> implements Filterable {
//
//    private List<FarmerListModal> farmerList;
//    private List<FarmerListModal> farmerListFull; // A full copy for filtering
//    private final OnItemClickListener listener;
//
//    public interface OnItemClickListener {
//        void onItemClick(FarmerListModal farmer);
//    }
//
//    public FarmerListAdapter(List<FarmerListModal> farmerList, OnItemClickListener listener) {
//        this.farmerList = farmerList;
//        this.farmerListFull = new ArrayList<>(farmerList); // Keep a copy of the full list
//        this.listener = listener;
//    }
//
//    public void updateList(List<FarmerListModal> newList) {
//        farmerList = newList;
//        farmerListFull = new ArrayList<>(newList); // Update the full list as well
//        notifyDataSetChanged();
//    }
//
//    @NonNull
//    @Override
//    public FarmerListHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_farmer_layout, parent, false);
//        return new FarmerListHolder(view);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull FarmerListHolder holder, int position) {
//        FarmerListModal farmer = farmerList.get(position);
//        holder.bind(farmer, listener);
//    }
//
//    @Override
//    public int getItemCount() {
//        return farmerList.size();
//    }
//
//    @Override
//    public Filter getFilter() {
//        return farmerFilter;
//    }
//
//    private final Filter farmerFilter = new Filter() {
//        @Override
//        protected FilterResults performFiltering(CharSequence constraint) {
//            List<FarmerListModal> filteredList = new ArrayList<>();
//            if (constraint == null || constraint.length() == 0) {
//                filteredList.addAll(farmerListFull);
//            } else {
//                String filterPattern = constraint.toString().toLowerCase().trim();
//                for (FarmerListModal item : farmerListFull) {
//                    if (item.getFarmer_id().toLowerCase().contains(filterPattern)) {
//                        filteredList.add(item);
//                    }
//                }
//            }
//            FilterResults results = new FilterResults();
//            results.values = filteredList;
//            return results;
//        }
//
//        @Override
//        protected void publishResults(CharSequence constraint, FilterResults results) {
//            farmerList.clear();
//            farmerList.addAll((List) results.values);
//            notifyDataSetChanged();
//        }
//    };
//
//    public static class FarmerListHolder extends RecyclerView.ViewHolder {
//
//        private final TextView farmer_id;
//        private final TextView farmer_name;
//        private final TextView district;
//        private final TextView community;
//        private final ImageView photo;
//
//        public FarmerListHolder(@NonNull View itemView) {
//            super(itemView);
//            farmer_id = itemView.findViewById(R.id.farmer_idTv);
//            farmer_name = itemView.findViewById(R.id.farmer_nameTv);
//            district = itemView.findViewById(R.id.districtTv);
//            community = itemView.findViewById(R.id.communityTv);
//            photo = itemView.findViewById(R.id.imgPhoto);
//        }
//
//        public void bind(final FarmerListModal farmer, final OnItemClickListener listener) {
//            farmer_id.setText(farmer.getFarmer_id());
//            farmer_name.setText(farmer.getFarmer_name());
//            district.setText(farmer.getDistrict());
//            community.setText(farmer.getCommunity());
//
//            String photoUrl = farmer.getPhoto();
//            if (photoUrl == null || photoUrl.isEmpty()) {
//                photo.setImageResource(R.drawable.user); // Placeholder
//            } else {
//                Picasso.get()
//                        .load(photoUrl)
//                        .error(R.drawable.user) // Fallback for failed loads
//                        .placeholder(R.drawable.user) // Placeholder while loading
//                        .into(photo);
//            }
//
//            itemView.setOnClickListener(v -> listener.onItemClick(farmer));
//        }
//    }
//}
