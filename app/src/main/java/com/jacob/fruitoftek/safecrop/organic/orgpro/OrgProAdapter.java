package com.jacob.fruitoftek.safecrop.organic.orgpro;

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
import com.jacob.fruitoftek.safecrop.comdev.sch.SchoolModel;
import com.jacob.fruitoftek.safecrop.comdev.sch.SchoolSurveyedDetailsActivity;
import com.jacob.fruitoftek.safecrop.comdev.sch.UpdateSurveyedSchoolsActivity;

import java.util.ArrayList;
import java.util.List;

public class OrgProAdapter extends RecyclerView.Adapter<OrgProAdapter.SchoolViewHolder> {

    private List<SchoolModel> schoolList;
    private List<SchoolModel> filteredList;
    private Context context;
    private OnEmptyStateListener onEmptyStateListener;

    public OrgProAdapter(Context context, List<SchoolModel> schoolList) {
        this.context = context;
        this.schoolList = schoolList;
        this.filteredList = new ArrayList<>(schoolList);
    }

    @NonNull
    @Override
    public OrgProAdapter.SchoolViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_school, parent, false);
        return new OrgProAdapter.SchoolViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OrgProAdapter.SchoolViewHolder holder, int position) {
        SchoolModel model = filteredList.get(position);
        holder.nameTextView.setText(model.getSch_name());
        holder.districtTextView.setText(model.getSch_district());
        holder.communityTextView.setText(model.getSch_community());
//        holder.locationTextView.setText(model.getSch_location());
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
            holder.schImage.setImageURI(model.getFarmer_photo());
        } else {
            holder.schImage.setImageResource(R.drawable.farmer_not_found);
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
            filteredList.addAll(schoolList);
        } else {
            for (SchoolModel model : schoolList) {
                if (model.getSch_name().toLowerCase().contains(query.toLowerCase())) {
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
    public void updateList(List<SchoolModel> newList) {
        this.schoolList = newList;
        this.filteredList = new ArrayList<>(newList);
        notifyDataSetChanged();
    }

    private void showMoreDialog(int position, SchoolModel model) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Choose an option");
        builder.setItems(new CharSequence[]{"View details", "Update details"}, (dialog, which) -> {
            switch (which) {
                case 0: // VIEW
                    Intent viewIntent = new Intent(context, SchoolSurveyedDetailsActivity.class);
                    viewIntent.putExtra("sch_model", model);
                    context.startActivity(viewIntent);
                    break;
                case 1: // EDIT
                    Intent editIntent = new Intent(context, UpdateSurveyedSchoolsActivity.class);
                    editIntent.putExtra("sch_model", model);
                    context.startActivity(editIntent);
                    break;
            }
        });
        builder.show();
    }

    public static class SchoolViewHolder extends RecyclerView.ViewHolder {
        public TextView nameTextView, districtTextView, communityTextView, locationTextView, createdAtTextView, updatedAtTextView;
        public ImageView schImage, signatureImage;
        ImageButton moreOptions;

        public SchoolViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.nameTextView);
            districtTextView = itemView.findViewById(R.id.districtTextView);
            communityTextView = itemView.findViewById(R.id.communityTextView);
//            locationTextView = itemView.findViewById(R.id.locationTextView);
            schImage = itemView.findViewById(R.id.photoTextView);
//            signatureImage = itemView.findViewById(R.id.signatureTextView);
            createdAtTextView = itemView.findViewById(R.id.createdAtTextView);
//            updatedAtTextView = itemView.findViewById(R.id.updatedAtTextView);
            moreOptions = itemView.findViewById(R.id.schMoreBtn);
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
