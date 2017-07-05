package com.hlv.dao;

import java.util.List;

 
public interface EntityDAO<T> {
 
    public void Create(T t);
    public void Update(T t);
    public void Delete(T t);
    public List<T> Find();    
    public T GetById(long id);
}