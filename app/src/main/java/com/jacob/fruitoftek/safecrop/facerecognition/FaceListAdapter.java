package com.jacob.fruitoftek.safecrop.facerecognition;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.jacob.fruitoftek.safecrop.R;

import java.util.List;

public class FaceListAdapter extends RecyclerView.Adapter<FaceListAdapter.FaceViewHolder> {
    private Context context;
    private List<FaceModel> faceList;

    public FaceListAdapter(Context context, List<FaceModel> faceList) {
        this.context = context;
        this.faceList = faceList;
    }

    @NonNull
    @Override
    public FaceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_face, parent, false);
        return new FaceViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FaceViewHolder holder, int position) {
        FaceModel model = faceList.get(position);
        holder.nameText.setText(model.name);
        holder.faceImage.setImageBitmap(BitmapFactory.decodeFile(model.imagePath));
    }

    @Override
    public int getItemCount() {
        return faceList.size();
    }

    public static class FaceViewHolder extends RecyclerView.ViewHolder {
        ImageView faceImage;
        TextView nameText;

        public FaceViewHolder(@NonNull View itemView) {
            super(itemView);
            faceImage = itemView.findViewById(R.id.faceImage);
            nameText = itemView.findViewById(R.id.faceName);
        }
    }
}
