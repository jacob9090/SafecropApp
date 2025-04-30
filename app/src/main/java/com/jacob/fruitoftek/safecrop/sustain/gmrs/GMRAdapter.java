package com.jacob.fruitoftek.safecrop.sustain.gmrs;

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

public class GMRAdapter extends RecyclerView.Adapter<GMRAdapter.GMRViewHolder> {
    private List<GMRModel> gmrList;
    private Context context;
    private List<GMRModel> filteredList;

    public GMRAdapter(Context context, List<GMRModel> gmrList) {
        this.context = context;
        this.gmrList = gmrList;
        this.filteredList = new ArrayList<>(gmrList);
    }

    @NonNull
    @Override
    public GMRViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_gmr_profiled_list, parent, false);
        return new GMRViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GMRViewHolder holder, int position) {
        GMRModel model = filteredList.get(position);
        holder.gmrFarmerCode.setText(model.getGmrquestion5());
        holder.gmrFarmerName.setText(model.getGmrquestion6());

        if (model.getFarmerPhoto() != null) {
            holder.farmerPhoto.setImageURI(model.getFarmerPhoto());
        } else {
            holder.farmerPhoto.setImageResource(R.drawable.farmer_not_found);
        }

        holder.gmrFarmerDistrict.setText(model.getGmrquestion1());
        holder.gmrFarmerCom.setText(model.getGmrquestion2());

        holder.moreOptions.setOnClickListener(v -> showMoreDialog(position, model));
    }

    @Override
    public int getItemCount() {
        return filteredList.size();
    }

    public void filter(String query) {
        filteredList.clear();
        if (query.isEmpty()) {
            filteredList.addAll(gmrList);
        } else {
            for (GMRModel model : gmrList) {
                if (model.getGmrquestion5().toLowerCase().contains(query.toLowerCase())) {
                    filteredList.add(model);
                }
            }
        }
        notifyDataSetChanged();
    }

    private void showMoreDialog(int position, GMRModel model) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Choose an option");
        builder.setItems(new CharSequence[]{"View details", "Update details"}, (dialog, which) -> {
            switch (which) {
                case 0: // VIEW
                    Intent viewIntent = new Intent(context, GMRSurveyedDetailsActivity.class);
                    viewIntent.putExtra("gmr_model", model);
                    context.startActivity(viewIntent);
                    break;
                case 1: // EDIT
                    Intent editIntent = new Intent(context, EditGMRSurvedActivity.class);
                    editIntent.putExtra("gmr_model", model);
                    context.startActivity(editIntent);
                    break;
            }
        });
        builder.show();
    }

    public static class GMRViewHolder extends RecyclerView.ViewHolder {
        TextView gmrFarmerCode, gmrFarmerName, gmrFarmerDistrict, gmrFarmerCom;
        ImageView idPhoto, farmerPhoto, tpPhoto, gmrquestion5;
        ImageButton moreOptions;

        public GMRViewHolder(@NonNull View itemView) {
            super(itemView);
            gmrFarmerCode = itemView.findViewById(R.id.gmrFarmerCode);
            gmrFarmerName = itemView.findViewById(R.id.gmrFarmerName);
            farmerPhoto = itemView.findViewById(R.id.gmrImgFarmerPhoto);
            gmrFarmerDistrict = itemView.findViewById(R.id.gmrFarmerDistrict);
            gmrFarmerCom = itemView.findViewById(R.id.gmrFarmerCom);
            moreOptions = itemView.findViewById(R.id.gmrMoreBtn);
        }
    }
}
