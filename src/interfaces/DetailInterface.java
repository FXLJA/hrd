package interfaces;

import java.util.List;

import models.Detail;

public interface DetailInterface 
{
    public boolean insert (Detail dt);
    public boolean update (Detail dt);
    public boolean delete (Detail dt);

    public List<Detail> getAllDetail(); 
    public Detail getByID(String id);
}