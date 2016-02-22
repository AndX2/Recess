package ru.yandex.android.andrew.recess.adapter;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import ru.yandex.android.andrew.recess.R;
import ru.yandex.android.andrew.recess.utils.Utils;
import ru.yandex.android.andrew.recess.pojo.SyllabusEntry;

/**
 * Created by Andrew on 09.02.2016.
 */
public class SyllabusRecyclerAdapter extends RecyclerView.Adapter<SyllabusRecyclerAdapter.ViewHolder> {

    List<SyllabusEntry> syllabusEntryList;

    public SyllabusRecyclerAdapter(List<SyllabusEntry> syllabusEntryList) {
        this.syllabusEntryList = syllabusEntryList;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        CardView cardView;
        TextView txtBeginTime;
        TextView txtEndTime;
        Switch isEnabled;
        ImageView btnDelete;



        public ViewHolder(View view) {
            super(view);
            cardView = (CardView) view.findViewById(R.id.cardView);
            txtBeginTime = (TextView) view.findViewById(R.id.txtBeginTime);
            txtEndTime = (TextView) view.findViewById(R.id.txtEndTime);
            isEnabled = (Switch)view.findViewById(R.id.isEnabled);
            btnDelete = (ImageView)view.findViewById(R.id.btnDelete);

        }
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.syllabus_entry_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        String tmp = String.format("%1$02d", Utils.getHourFromDBPresentation(syllabusEntryList.get(position).getBeginTime())) +
                " : " + String.format("%1$02d", Utils.getMinuteFromDBPresentation(syllabusEntryList.get(position).getBeginTime()));
        holder.txtBeginTime.setText(tmp);
        holder.txtEndTime.setText(String.format("%1$02d", Utils.getHourFromDBPresentation(syllabusEntryList.get(position).getEndTime())) +
                " : " + String.format("%1$02d", Utils.getMinuteFromDBPresentation(syllabusEntryList.get(position).getEndTime())));
        holder.isEnabled.setChecked(syllabusEntryList.get(position).getEnabled());
        holder.btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(Utils.LOG_TAG, "Click btnDelete pos " + position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return syllabusEntryList.size();
    }




}
