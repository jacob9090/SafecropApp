package com.jacob.fruitoftek.safecrop.sustain.fiis;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.jacob.fruitoftek.safecrop.R;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class ListFIISFarmersAdapter extends RecyclerView.Adapter<ListFIISFarmersAdapter.MyHolder> implements Filterable {

    private Context context;
    private List<ListFIISFarmersModel> modelList;
    private List<ListFIISFarmersModel> modelListFilter;

    public ListFIISFarmersAdapter(Context context, List<ListFIISFarmersModel> modelList) {
        this.context = context;
        this.modelList = modelList;
        this.modelListFilter = modelList;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.row_item, parent, false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        String farmerid = modelListFilter.get(position).getFarmerid();
        String farmername = modelListFilter.get(position).getFarmerName();
        String farmerdistrict = modelListFilter.get(position).getFarmerDistrict();
        String farmercommunity = modelListFilter.get(position).getFarmerCommunity();
        int image = modelListFilter.get(position).getImage();
        holder.farmerid.setText(farmerid);
        holder.farmerName.setText(farmername);
        holder.farmerDistrict.setText(farmerdistrict);
        holder.farmerCommunity.setText(farmercommunity);
        holder.imageView.setImageResource(R.drawable.profile);
    }

    @Override
    public int getItemCount() {
        return modelListFilter.size();
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                String character = constraint.toString();
                if (character.isEmpty()) {
                    modelListFilter = modelList;
                } else {
                    List<ListFIISFarmersModel> filterList = new ArrayList<>();
                    for (ListFIISFarmersModel row : modelList) {
                        if (row.getFarmerid().toLowerCase().contains(character.toLowerCase())) {
                            filterList.add(row);
                        }
                    }
                    modelListFilter = filterList;
                }
                FilterResults filterResults = new FilterResults();
                filterResults.values = modelListFilter;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                modelListFilter = (ArrayList<ListFIISFarmersModel>) results.values;
                notifyDataSetChanged();

                // Show/hide "check spelling" message based on results
                if (context instanceof ListFIISFarmersActivity) {
                    ListFIISFarmersActivity activity = (ListFIISFarmersActivity) context;
                    activity.showNoResultsMessage(modelListFilter.isEmpty());
                }
            }
        };
    }

    class MyHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        CircleImageView imageView;
        TextView farmerid, farmerName, farmerDistrict, farmerCommunity;

        public MyHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.profile_image);
            farmerid = itemView.findViewById(R.id.farmerid);
            farmerName = itemView.findViewById(R.id.farmerfname);
            farmerDistrict = itemView.findViewById(R.id.farmeroname);
            farmerCommunity = itemView.findViewById(R.id.district);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int position = getAbsoluteAdapterPosition();
            Intent intent = new Intent(context, ProfileExistingFarmerOneFIIS.class);
            intent.putExtra("farmerid", modelListFilter.get(position).getFarmerid());
            intent.putExtra("farmername", modelListFilter.get(position).getFarmerName());
            intent.putExtra("farmerdistrict", modelListFilter.get(position).getFarmerDistrict());
            intent.putExtra("farmercommunity", modelListFilter.get(position).getFarmerCommunity());
            context.startActivity(intent);
        }
    }
}

