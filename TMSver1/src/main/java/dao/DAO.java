/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.util.List;

/**
 *
 * @author admin
 * @param <T>
 */
public abstract class DAO<T> {
    
    public abstract int create(T t);
    
    public abstract int update(T t);
    
    public abstract int delete(T t);
    
    public abstract List<T> readAll();
    
    public abstract T readOnly(String str);

}
