package com.jacob.fruitoftek.safecrop.sustain.fiis;

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
import com.squareup.picasso.Picasso;

import java.io.File;
import java.util.ArrayList;

public class AdapterRecordFIIS extends RecyclerView.Adapter<AdapterRecordFIIS.HolderRecord> {

    private final Context context;
    private final ArrayList<ModelRecordFIIS> recordsList;
    private final MyFIISDbHelper dbHelper;

    public AdapterRecordFIIS(Context context, ArrayList<ModelRecordFIIS> recordsList) {
        this.context = context;
        this.recordsList = recordsList;
        dbHelper = new MyFIISDbHelper(context);
    }

    @NonNull
    @Override
    public HolderRecord onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.gmr_row_record, parent, false);
        return new HolderRecord(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HolderRecord holder, int position) {
        ModelRecordFIIS model = recordsList.get(position);

        holder.q2.setText(model.getQuestionfiis6());
        holder.q3.setText(model.getQuestionfiis2());
        holder.q4.setText(model.getQuestionfiis8());
        holder.q5.setText(model.getQuestionfiis9());

        if (model.getProfileImage() != null) {
            Picasso.get().load(new File(model.getProfileImage())).into(holder.profileImage);
        } else {
            holder.profileImage.setImageResource(R.drawable.ic_person_black);
        }

        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, RecordDetailActivityFIIS.class);
            intent.putExtra("ID", model.getId()); // Ensure ID is passed correctly
            context.startActivity(intent);
        });

        holder.moreBtn.setOnClickListener(v -> showMoreDialog(position, model));
    }

    private void showMoreDialog(int position, ModelRecordFIIS model) {
        String[] options = {"Edit", "Delete"};

        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setItems(options, (dialog, which) -> {
            if (which == 0) {
                Intent intent = new Intent(context, UpdateFIIS.class);
                intent.putExtra("ID", model.getId());
                intent.putExtra("QUESTIONFIIS1", model.getQuestionfiis1());
                intent.putExtra("QUESTIONFIIS2", model.getQuestionfiis2());
                intent.putExtra("QUESTIONFIIS3", model.getQuestionfiis3());
                intent.putExtra("QUESTIONFIIS4", model.getQuestionfiis4());
                intent.putExtra("QUESTIONFIIS5", model.getQuestionfiis5());
                intent.putExtra("QUESTIONFIIS6", model.getQuestionfiis6());
                intent.putExtra("QUESTIONFIIS7", model.getQuestionfiis7());
                intent.putExtra("QUESTIONFIIS8", model.getQuestionfiis8());
                intent.putExtra("QUESTIONFIIS9", model.getQuestionfiis9());
                intent.putExtra("QUESTIONFIIS10", model.getQuestionfiis10());
                intent.putExtra("QUESTIONFIIS11", model.getQuestionfiis11());
                intent.putExtra("QUESTIONFIIS12", model.getQuestionfiis12());
                intent.putExtra("QUESTIONFIIS13", model.getQuestionfiis13());
                intent.putExtra("QUESTIONFIIS14", model.getQuestionfiis14());
                intent.putExtra("QUESTIONFIIS15", model.getQuestionfiis15());
                intent.putExtra("QUESTIONFIIS16", model.getQuestionfiis16());
                intent.putExtra("QUESTIONFIIS17", model.getQuestionfiis17());
                intent.putExtra("QUESTIONFIIS18", model.getQuestionfiis18());
                intent.putExtra("QUESTIONFIIS19", model.getQuestionfiis19());
                intent.putExtra("QUESTIONFIIS20", model.getQuestionfiis20());
                intent.putExtra("QUESTIONFIIS21", model.getQuestionfiis21());
                intent.putExtra("QUESTIONFIIS22", model.getQuestionfiis22());
                intent.putExtra("QUESTIONFIIS23", model.getQuestionfiis23());
                intent.putExtra("QUESTIONFIIS24", model.getQuestionfiis24());
                intent.putExtra("QUESTIONFIIS25", model.getQuestionfiis25());
                intent.putExtra("QUESTIONFIIS26", model.getQuestionfiis26());
                intent.putExtra("QUESTIONFIIS27", model.getQuestionfiis27());
                intent.putExtra("QUESTIONFIIS28", model.getQuestionfiis28());
                intent.putExtra("QUESTIONFIIS29", model.getQuestionfiis29());
                intent.putExtra("QUESTIONFIIS30", model.getQuestionfiis30());
                intent.putExtra("QUESTIONFIIS31", model.getQuestionfiis31());
                intent.putExtra("QUESTIONFIIS32", model.getQuestionfiis32());
                intent.putExtra("QUESTIONFIIS33", model.getQuestionfiis33());
                intent.putExtra("QUESTIONFIIS34", model.getQuestionfiis34());
                intent.putExtra("QUESTIONFIIS35", model.getQuestionfiis35());
                intent.putExtra("QUESTIONFIIS36", model.getQuestionfiis36());
                intent.putExtra("QUESTIONFIIS37", model.getQuestionfiis37());
                intent.putExtra("QUESTIONFIIS38", model.getQuestionfiis38());
                intent.putExtra("QUESTIONFIIS39", model.getQuestionfiis39());
                intent.putExtra("QUESTIONFIIS40", model.getQuestionfiis40());
                intent.putExtra("QUESTIONFIIS41", model.getQuestionfiis41());
                intent.putExtra("QUESTIONFIIS42", model.getQuestionfiis42());
                intent.putExtra("QUESTIONFIIS43", model.getQuestionfiis43());
                intent.putExtra("QUESTIONFIIS44", model.getQuestionfiis44());
                intent.putExtra("QUESTIONFIIS45", model.getQuestionfiis45());
                intent.putExtra("QUESTIONFIIS46", model.getQuestionfiis46());
                intent.putExtra("QUESTIONFIIS47", model.getQuestionfiis47());
                intent.putExtra("QUESTIONFIIS48", model.getQuestionfiis48());
                intent.putExtra("QUESTIONFIIS49", model.getQuestionfiis49());
                intent.putExtra("QUESTIONFIIS50", model.getQuestionfiis50());
                intent.putExtra("QUESTIONFIIS51", model.getQuestionfiis51());
                intent.putExtra("QUESTIONFIIS52", model.getQuestionfiis52());
                intent.putExtra("QUESTIONFIIS53", model.getQuestionfiis53());
                intent.putExtra("QUESTIONFIIS54", model.getQuestionfiis54());
                intent.putExtra("QUESTIONFIIS55", model.getQuestionfiis55());
                intent.putExtra("QUESTIONFIIS56", model.getQuestionfiis56());
                intent.putExtra("QUESTIONFIIS57", model.getQuestionfiis57());
                intent.putExtra("QUESTIONFIIS58", model.getQuestionfiis58());
                intent.putExtra("QUESTIONFIIS59", model.getQuestionfiis59());
                intent.putExtra("QUESTIONFIIS60", model.getQuestionfiis60());
                intent.putExtra("QUESTIONFIIS61", model.getQuestionfiis61());
                intent.putExtra("QUESTIONFIIS62", model.getQuestionfiis62());
                intent.putExtra("QUESTIONFIIS63", model.getQuestionfiis63());
                intent.putExtra("QUESTIONFIIS64", model.getQuestionfiis64());
                intent.putExtra("QUESTIONFIIS65", model.getQuestionfiis65());
                intent.putExtra("QUESTIONFIIS66", model.getQuestionfiis66());
                intent.putExtra("QUESTIONFIIS67", model.getQuestionfiis67());
                intent.putExtra("QUESTIONFIIS68", model.getQuestionfiis68());
                intent.putExtra("QUESTIONFIIS69", model.getQuestionfiis69());
                intent.putExtra("QUESTIONFIIS70", model.getQuestionfiis70());
                intent.putExtra("QUESTIONFIIS71", model.getQuestionfiis71());
                intent.putExtra("QUESTIONFIIS72", model.getQuestionfiis72());
                intent.putExtra("QUESTIONFIIS73", model.getQuestionfiis73());
                intent.putExtra("QUESTIONFIIS74", model.getQuestionfiis74());
                intent.putExtra("QUESTIONFIIS75", model.getQuestionfiis75());
                intent.putExtra("QUESTIONFIIS76", model.getQuestionfiis76());
                intent.putExtra("QUESTIONFIIS77", model.getQuestionfiis77());
                intent.putExtra("QUESTIONFIIS78", model.getQuestionfiis78());
                intent.putExtra("QUESTIONFIIS79", model.getQuestionfiis79());
                intent.putExtra("QUESTIONFIIS80", model.getQuestionfiis80());
                intent.putExtra("QUESTIONFIIS81", model.getQuestionfiis81());
                intent.putExtra("QUESTIONFIIS82", model.getQuestionfiis82());
                intent.putExtra("QUESTIONFIIS83", model.getQuestionfiis83());
                intent.putExtra("QUESTIONFIIS84", model.getQuestionfiis84());
                intent.putExtra("QUESTIONFIIS85", model.getQuestionfiis85());
                intent.putExtra("QUESTIONFIIS86", model.getQuestionfiis86());
                intent.putExtra("QUESTIONFIIS87", model.getQuestionfiis87());
                intent.putExtra("QUESTIONFIIS88", model.getQuestionfiis88());
                intent.putExtra("QUESTIONFIIS89", model.getQuestionfiis89());
                intent.putExtra("QUESTIONFIIS90", model.getQuestionfiis90());
                intent.putExtra("QUESTIONFIIS91", model.getQuestionfiis91());
                intent.putExtra("QUESTIONFIIS92", model.getQuestionfiis92());
                intent.putExtra("QUESTIONFIIS93", model.getQuestionfiis93());
                intent.putExtra("QUESTIONFIIS94", model.getQuestionfiis94());
                intent.putExtra("QUESTIONFIIS95", model.getQuestionfiis95());
                intent.putExtra("QUESTIONFIIS96", model.getQuestionfiis96());
                intent.putExtra("QUESTIONFIIS97", model.getQuestionfiis97());
                intent.putExtra("QUESTIONFIIS98", model.getQuestionfiis98());
                intent.putExtra("QUESTIONFIIS99", model.getQuestionfiis99());
                intent.putExtra("QUESTIONFIIS100", model.getQuestionfiis100());
                intent.putExtra("QUESTIONFIIS101", model.getQuestionfiis101());
                intent.putExtra("QUESTIONFIIS102", model.getQuestionfiis102());
                intent.putExtra("QUESTIONFIIS103", model.getQuestionfiis103());
                intent.putExtra("QUESTIONFIIS104", model.getQuestionfiis104());
                intent.putExtra("QUESTIONFIIS105", model.getQuestionfiis105());
                intent.putExtra("QUESTIONFIIS106", model.getQuestionfiis106());
                intent.putExtra("QUESTIONFIIS107", model.getQuestionfiis107());
                intent.putExtra("QUESTIONFIIS108", model.getQuestionfiis108());
                intent.putExtra("QUESTIONFIIS109", model.getQuestionfiis109());
                intent.putExtra("QUESTIONFIIS110", model.getQuestionfiis110());
                intent.putExtra("QUESTIONFIIS111", model.getQuestionfiis111());
                intent.putExtra("QUESTIONFIIS112", model.getQuestionfiis112());
                intent.putExtra("QUESTIONFIIS113", model.getQuestionfiis113());
                intent.putExtra("QUESTIONFIIS114", model.getQuestionfiis114());
                intent.putExtra("QUESTIONFIIS115", model.getQuestionfiis115());
                intent.putExtra("QUESTIONFIIS116", model.getQuestionfiis116());
                intent.putExtra("QUESTIONFIIS117", model.getQuestionfiis117());
                intent.putExtra("QUESTIONFIIS118", model.getQuestionfiis118());
                intent.putExtra("QUESTIONFIIS119", model.getQuestionfiis119());
                intent.putExtra("QUESTIONFIIS120", model.getQuestionfiis120());
                intent.putExtra("QUESTIONFIIS121", model.getQuestionfiis121());
                intent.putExtra("QUESTIONFIIS122", model.getQuestionfiis122());
                intent.putExtra("QUESTIONFIIS123", model.getQuestionfiis123());
                intent.putExtra("QUESTIONFIIS124", model.getQuestionfiis124());
                intent.putExtra("QUESTIONFIIS125", model.getQuestionfiis125());
                intent.putExtra("QUESTIONFIIS126", model.getQuestionfiis126());
                intent.putExtra("QUESTIONFIIS127", model.getQuestionfiis127());
                intent.putExtra("QUESTIONFIIS128", model.getQuestionfiis128());
                intent.putExtra("QUESTIONFIIS129", model.getQuestionfiis129());
                intent.putExtra("QUESTIONFIIS130", model.getQuestionfiis130());
                intent.putExtra("QUESTIONFIIS131", model.getQuestionfiis131());
                intent.putExtra("QUESTIONFIIS132", model.getQuestionfiis132());
                intent.putExtra("QUESTIONFIIS133", model.getQuestionfiis133());
                intent.putExtra("QUESTIONFIIS134", model.getQuestionfiis134());
                intent.putExtra("QUESTIONFIIS135", model.getQuestionfiis135());
                intent.putExtra("QUESTIONFIIS136", model.getQuestionfiis136());
                intent.putExtra("QUESTIONFIIS137", model.getQuestionfiis137());
                intent.putExtra("QUESTIONFIIS138", model.getQuestionfiis138());
                intent.putExtra("QUESTIONFIIS139", model.getQuestionfiis139());
                intent.putExtra("QUESTIONFIIS140", model.getQuestionfiis140());
                intent.putExtra("QUESTIONFIIS141", model.getQuestionfiis141());
                intent.putExtra("QUESTIONFIIS142", model.getQuestionfiis142());
                intent.putExtra("QUESTIONFIIS143", model.getQuestionfiis143());
                intent.putExtra("QUESTIONFIIS144", model.getQuestionfiis144());
                intent.putExtra("QUESTIONFIIS145", model.getQuestionfiis145());
                intent.putExtra("QUESTIONFIIS146", model.getQuestionfiis146());
                intent.putExtra("QUESTIONFIIS147", model.getQuestionfiis147());
                intent.putExtra("QUESTIONFIIS148", model.getQuestionfiis148());
                intent.putExtra("QUESTIONFIIS149", model.getQuestionfiis149());
                intent.putExtra("QUESTIONFIIS150", model.getQuestionfiis150());
                intent.putExtra("QUESTIONFIIS151", model.getQuestionfiis151());
                intent.putExtra("QUESTIONFIIS152", model.getQuestionfiis152());
                intent.putExtra("QUESTIONFIIS153", model.getQuestionfiis153());
                intent.putExtra("QUESTIONFIIS154", model.getQuestionfiis154());
                intent.putExtra("QUESTIONFIIS155", model.getQuestionfiis155());
                intent.putExtra("QUESTIONFIIS156", model.getQuestionfiis156());
                intent.putExtra("QUESTIONFIIS157", model.getQuestionfiis157());
                intent.putExtra("QUESTIONFIIS158", model.getQuestionfiis158());
                intent.putExtra("QUESTIONFIIS159", model.getQuestionfiis159());
                intent.putExtra("QUESTIONFIIS160", model.getQuestionfiis160());
                intent.putExtra("QUESTIONFIIS161", model.getQuestionfiis161());
                intent.putExtra("QUESTIONFIIS162", model.getQuestionfiis162());
                intent.putExtra("QUESTIONFIIS163", model.getQuestionfiis163());
                intent.putExtra("QUESTIONFIIS164", model.getQuestionfiis164());
                intent.putExtra("QUESTIONFIIS165", model.getQuestionfiis165());
                intent.putExtra("QUESTIONFIIS166", model.getQuestionfiis166());
                intent.putExtra("QUESTIONFIIS167", model.getQuestionfiis167());
                intent.putExtra("QUESTIONFIIS168", model.getQuestionfiis168());
                intent.putExtra("QUESTIONFIIS169", model.getQuestionfiis169());
                intent.putExtra("QUESTIONFIIS170", model.getQuestionfiis170());
                intent.putExtra("QUESTIONFIIS171", model.getQuestionfiis171());
                intent.putExtra("QUESTIONFIIS172", model.getQuestionfiis172());
                intent.putExtra("QUESTIONFIIS173", model.getQuestionfiis173());
                intent.putExtra("QUESTIONFIIS174", model.getQuestionfiis174());
                intent.putExtra("QUESTIONFIIS175", model.getQuestionfiis175());
                intent.putExtra("QUESTIONFIIS176", model.getQuestionfiis176());
                intent.putExtra("QUESTIONFIIS177", model.getQuestionfiis177());
                intent.putExtra("QUESTIONFIIS178", model.getQuestionfiis178());
                intent.putExtra("QUESTIONFIIS179", model.getQuestionfiis179());
                intent.putExtra("QUESTIONFIIS180", model.getQuestionfiis180());
                intent.putExtra("QUESTIONFIIS181", model.getQuestionfiis181());
                intent.putExtra("QUESTIONFIIS182", model.getQuestionfiis182());
                intent.putExtra("QUESTIONFIIS183", model.getQuestionfiis183());
                intent.putExtra("QUESTIONFIIS184", model.getQuestionfiis184());
                intent.putExtra("QUESTIONFIIS185", model.getQuestionfiis185());
                intent.putExtra("QUESTIONFIIS186", model.getQuestionfiis186());
                intent.putExtra("QUESTIONFIIS187", model.getQuestionfiis187());
                intent.putExtra("QUESTIONFIIS188", model.getQuestionfiis188());
                intent.putExtra("QUESTIONFIIS189", model.getQuestionfiis189());
                intent.putExtra("QUESTIONFIIS190", model.getQuestionfiis190());
                intent.putExtra("QUESTIONFIIS191", model.getQuestionfiis191());
                intent.putExtra("QUESTIONFIIS192", model.getQuestionfiis192());
                intent.putExtra("QUESTIONFIIS193", model.getQuestionfiis193());
                intent.putExtra("QUESTIONFIIS194", model.getQuestionfiis194());
                intent.putExtra("QUESTIONFIIS195", model.getQuestionfiis195());
                intent.putExtra("QUESTIONFIIS196", model.getQuestionfiis196());
                intent.putExtra("PROFILE_IMAGE", model.getProfileImage());
                context.startActivity(intent);
            } else if (which == 1) {
                dbHelper.deleteData(model.getId());
                recordsList.remove(position);
                notifyItemRemoved(position);
                notifyItemRangeChanged(position, recordsList.size());
            }
        });
        builder.create().show();
    }

    static class HolderRecord extends RecyclerView.ViewHolder {
        ImageView profileImage;
        TextView q2, q3, q4, q5;
        ImageButton moreBtn;

        public HolderRecord(@NonNull View itemView) {
            super(itemView);
            profileImage = itemView.findViewById(R.id.gmrhhprofileIV);
            q2 = itemView.findViewById(R.id.gmrhhfq3TvCode);
            q3 = itemView.findViewById(R.id.gmrfarmerNameTv);

            q4 = itemView.findViewById(R.id.gmrfarmerDisTv);
            q5 = itemView.findViewById(R.id.gmrfarmerComTv);
            moreBtn = itemView.findViewById(R.id.gmrhhmoreBtn);
        }
    }

    @Override
    public int getItemCount() {
        return recordsList.size();
    }
}