package com.myproject.Pojo;


public class Corona
{
    private String Message;

    private Countries[] Countries;

    private String ID;

    private Global Global;

    private String Date;

    public String getMessage ()
    {
        return Message;
    }

    public void setMessage (String Message)
    {
        this.Message = Message;
    }

    public Countries[] getCountries ()
    {
        return Countries;
    }

    public void setCountries (Countries[] Countries)
    {
        this.Countries = Countries;
    }

    public String getID ()
    {
        return ID;
    }

    public void setID (String ID)
    {
        this.ID = ID;
    }

    public Global getGlobal ()
    {
        return Global;
    }

    public void setGlobal (Global Global)
    {
        this.Global = Global;
    }

    public String getDate ()
    {
        return Date;
    }

    public void setDate (String Date)
    {
        this.Date = Date;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [Message = "+Message+", Countries = "+Countries+", ID = "+ID+", Global = "+Global+", Date = "+Date+"]";
    }
}