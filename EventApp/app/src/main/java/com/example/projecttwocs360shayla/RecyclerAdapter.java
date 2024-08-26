package com.example.projecttwocs360shayla;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.projecttwocs360shayla.model.Event;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
    private ArrayList<Event> eventList;
    private int selectedPosition = 0;

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private final TextView date;
        private final TextView eventName;
        private final TextView eventDescription;

        public ViewHolder(View view) {
            super(view);
            // Define click listener for the ViewHolder's View
            itemView.setOnClickListener(this);

            date = (TextView) view.findViewById(R.id.date);
            eventName = (TextView) view.findViewById(R.id.EventName);
            eventDescription = (TextView) view.findViewById(R.id.eventDescription);
        }
        @Override
        public void onClick(View view){
            if(getBindingAdapterPosition() == RecyclerView.NO_POSITION){
                return;
            }
            notifyItemChanged(selectedPosition);
            selectedPosition = getBindingAdapterPosition();
            notifyItemChanged(selectedPosition);
        }

        public TextView getDate() {
            return date;
        }

        public TextView getEventName(){
            return eventName;
        }

        public TextView getEventDescription(){
            return eventDescription;
        }

    }
    public RecyclerAdapter(ArrayList<Event> list) {
        this.eventList = list;
    }

    // Create new views
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.card_items, viewGroup, false);

        return new ViewHolder(view);
    }

    // Replace the contents of a view
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        Event event = eventList.get(position);

        viewHolder.itemView.setBackgroundColor(selectedPosition == position ? Color.YELLOW : Color.TRANSPARENT);

        SimpleDateFormat format = new SimpleDateFormat("MM-dd-yy", Locale.US);
        String dateString = format.format(new Date(event.getMyDate()));

        viewHolder.getDate().setText(dateString);
        viewHolder.getEventName().setText(event.getEventTitle());
        viewHolder.getEventDescription().setText(event.getEventDescription());
    }

    // Return the size
    @Override
    public int getItemCount() {
        return eventList.size();
    }


    public void setEventList(ArrayList<Event> list){
        eventList = list;
    }

    public Event getSelectedEvent() {
        Event event = eventList.get(selectedPosition);
        return event;
    }


}
