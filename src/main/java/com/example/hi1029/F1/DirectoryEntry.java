/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.example.hi1029.F1;

/**
 *
 * @author bfelt
 */
public class DirectoryEntry {
    
    public String name;
    public String number;
    
    public DirectoryEntry(String name, String number){
        this.name=name;
        this.number=number;
    }
    @Override
    public boolean equals(Object object){
        if(object instanceof DirectoryEntry){
            return name.equals(((DirectoryEntry) object).name);
        }
        return false;
    }
    
}
