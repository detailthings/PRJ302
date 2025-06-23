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
    
    public int create(T t) {
        return 0;
    }
    
    public int update(T t) {
        return 0;
    }
    
    public int delete(T t) {
        return 0;
    }
    
    public List<T> readAll() {
        return null;
    }
    
    public T readOnly(String str) {
        return null;
    }

}
