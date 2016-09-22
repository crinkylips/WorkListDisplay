package com.hive9.worklist;

/**
 * Created by hIVE9 on 04/08/2016.
 */
public class DataProvider {

    private String name;
    private String device;
    private String repair;
    private String status;
    private String priority;
    private String booked;


    public DataProvider(String name, String device, String repair,String status,String priority,String booked){

        this.name = name;
        this.device = device;
        this.repair = repair;
        this.status = status;
        this.priority = priority;
        this.booked = booked;


    }

    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name = name;
    }

    public String getDevice()
    {
        return device;
    }
    public void setDevice (String device)
    {
        this.device = device;
    }

    public String getRepair()
    {
        return repair;
    }
    public void setRepair(String repair)
    {
        this.repair = repair;
    }

    public String getStatus()
    {
        return status;
    }
    public void setStatus(String status)
    {
        this.status = status;
    }

    public String getPriority()
    {
        return priority;
    }
    public void setPriority(String priority)
    {
        this.priority = priority;
    }

    public String getBooked()
    {
        return booked;
    }
    public void setBooked(String booked)
    {
        this.booked = booked;
    }




}
