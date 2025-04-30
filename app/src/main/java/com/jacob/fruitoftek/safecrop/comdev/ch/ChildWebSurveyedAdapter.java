package com.jacob.fruitoftek.safecrop.comdev.ch;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.jacob.fruitoftek.safecrop.R;

import java.util.List;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import android.content.Context;
import android.content.Intent;
import androidx.appcompat.app.AlertDialog;

public class ChildWebSurveyedAdapter extends RecyclerView.Adapter<ChildWebSurveyedAdapter.ViewHolder> {

    private List<ChildModel> childList;
    private Context context;

    public ChildWebSurveyedAdapter(Context context, List<ChildModel> childList) {
        this.context = context;
        this.childList = childList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.child_item_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ChildModel child = childList.get(position);
        holder.farmerId.setText(child.getFarmerId());
        holder.farmerDistrict.setText(child.getFarmerDistrict());
        holder.farmerVillage.setText(child.getFarmerVillage());
        holder.oncreate.setText(child.getOnCreate());

        String signaturePath = child.getSignature();
        if (signaturePath != null && !signaturePath.isEmpty()) {
            Bitmap bitmap = BitmapFactory.decodeFile(signaturePath);
            if (bitmap != null) {
                holder.signatureImage.setImageBitmap(bitmap);
            } else {
                holder.signatureImage.setImageResource(R.drawable.user); // Optional placeholder
            }
        } else {
            holder.signatureImage.setImageResource(R.drawable.user); // Optional placeholder
        }

        holder.csmoreBtn.setOnClickListener(v -> showMoreDialog(position, child));
    }

    @Override
    public int getItemCount() {
        return childList.size();
    }

    private void showMoreDialog(int position, ChildModel model) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Choose an option");
        builder.setItems(new CharSequence[]{"View details", "Update details"}, (dialog, which) -> {
            switch (which) {
                case 0: // VIEW
                    Intent viewIntent = new Intent(context, ChildSurveyedDetailsActivity.class);
                    viewIntent.putExtra("child_model", model);
                    context.startActivity(viewIntent);
                    break;
                case 1: // EDIT
                    Intent editIntent = new Intent(context, UpdateSurvedChildActivity.class);
                    editIntent.putExtra("child_model", model);
                    context.startActivity(editIntent);
                    break;
            }
        });
        builder.show();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView farmerId, farmerDistrict, farmerVillage, oncreate;
        public ImageView signatureImage;
        public ImageButton csmoreBtn;

        public ViewHolder(View itemView) {
            super(itemView);
            farmerId = itemView.findViewById(R.id.farmerId);
            farmerDistrict = itemView.findViewById(R.id.farmerDistrict);
            farmerVillage = itemView.findViewById(R.id.farmerVillage);
            oncreate = itemView.findViewById(R.id.oncreate);
            signatureImage = itemView.findViewById(R.id.signatureImage);
            csmoreBtn = itemView.findViewById(R.id.csmoreBtn); // Bind the ImageButton
        }
    }
}

