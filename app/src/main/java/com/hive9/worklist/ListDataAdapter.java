package com.hive9.worklist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hIVE9 on 04/08/2016.
 */
public class ListDataAdapter extends ArrayAdapter {

    List list = new ArrayList();

    public ListDataAdapter(Context context, int resource) {
        super(context, resource);
    }

    static class LayoutHandler
    {
        TextView NAME,DEVICE,REPAIR,STATUS,PRIORITY,BOOKED;


    }


    @Override
    public void add(Object object)
    {
        super.add(object);
        list.add(object);
    }

    @Override
    public int getCount()
    {

        return list.size();
    }

    @Override
    public Object getItem(int position)
    {
        return list.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){

        View row = convertView;
        LayoutHandler layoutHandler;

        if(row == null)
        {
            LayoutInflater layoutInflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = layoutInflater.inflate(R.layout.raw_layout,parent,false);
            layoutHandler = new LayoutHandler();
            layoutHandler.NAME = (TextView) row.findViewById(R.id.text_user_name);
            layoutHandler.DEVICE = (TextView) row.findViewById(R.id.text_user_device);
            layoutHandler.REPAIR = (TextView) row.findViewById(R.id.text_user_repair);
            layoutHandler.STATUS = (TextView) row.findViewById(R.id.text_user_status);
            layoutHandler.PRIORITY = (TextView) row.findViewById(R.id.text_user_priority);
            layoutHandler.BOOKED = (TextView) row.findViewById(R.id.text_user_booked);



            row.setTag(layoutHandler);



        }else{

            layoutHandler = (LayoutHandler) row.getTag();
        }
        DataProvider dataProvider = (DataProvider) this.getItem(position);
        layoutHandler.NAME.setText(dataProvider.getName());
        layoutHandler.DEVICE.setText(dataProvider.getDevice());
        layoutHandler.REPAIR.setText(dataProvider.getRepair());
        layoutHandler.STATUS.setText(dataProvider.getStatus());
        layoutHandler.PRIORITY.setText(dataProvider.getPriority());
        layoutHandler.BOOKED.setText(dataProvider.getBooked());





        return row;
    }
}
