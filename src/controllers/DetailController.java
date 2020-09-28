package controllers;

import java.util.*;

import daos.DetailDAO;
import models.Detail;
import main.OperasiCRUD;
import interfaces.DetailInterface;

public class DetailController extends Observable
{
private DetailInterface dao = new DetailDAO();
private OperasiCRUD crud;

    public void setDml (Detail dt, OperasiCRUD c)
    {
    boolean hasil = false;
    this.crud = c;
    
        switch (c)
        {
            case INSERT:
            {
                hasil = dao.insert(dt);
                break;
            }
            
            case UPDATE:
            {
                hasil = dao.update(dt);
                break;
            }

            case DELETE:
            {
                hasil = dao.delete(dt);
                break;
            }            
        }
        
        setChanged();
        
        if (hasil)
        {
            notifyObservers(dt);
        }
            else
            {
                notifyObservers();
            }
    }
    
    public OperasiCRUD getCRUDState()
    {
        return crud;
    }
    
    public List<Detail> getAllDetail()
    {
        return dao.getAllDetail();
    }
    
    public Detail getByID(String id)
    {
        return dao.getByID(id);
    }
}