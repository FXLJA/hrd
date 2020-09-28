package controllers;

import java.util.*;

import daos.JabatanDAO;
import models.Jabatan;
import main.OperasiCRUD;
import interfaces.JabatanInterface;

public class JabatanController extends Observable
{
private JabatanInterface dao = new JabatanDAO();
private OperasiCRUD crud;

    public void setDml (Jabatan j, OperasiCRUD c)
    {
    boolean hasil = false;
    this.crud = c;
    
        switch (c)
        {
            case INSERT:
            {
                hasil = dao.insert(j);
                break;
            }
            
            case UPDATE:
            {
                hasil = dao.update(j);
                break;
            }

            case DELETE:
            {
                hasil = dao.delete(j);
                break;
            }            
        }
        
        setChanged();
        
        if (hasil)
        {
            notifyObservers(j);
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
    
    public List<Jabatan> getAllJabatan()
    {
        return dao.getAllJabatan();
    }
    
    public Jabatan getbyID(String kode_jabatan)
    {
        return dao.getbyID(kode_jabatan);
    }
}