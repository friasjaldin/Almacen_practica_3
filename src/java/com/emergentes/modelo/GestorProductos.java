/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.emergentes.modelo;
import java.util.ArrayList;
import java.util.Iterator;
/**
 *
 * @author CristhianFriasJaldin
 */

public class GestorProductos {
    private ArrayList<Productos> lista;

public GestorProductos(){
    lista=new ArrayList<Productos>();
}

    public ArrayList<Productos> getLista() {
        return lista;
    }

    public void setLista(ArrayList<Productos> lista) {
        this.lista = lista;
    }
    
    public void insertProducto(Productos item){
        lista.add(item);
    }
    public void modificarProducto(int pos, Productos item){
        lista.set(pos, item);
    }
    public void eliminarProducto(int pos){
        lista.remove(pos);
    }
    public int obtieneId()
    {
        int idaux=0;
        for(Productos item : lista){
            idaux=item.getId();
        }
        return idaux+1;
    }
    
    public int ubicarProducto(int id){
        int pos=-1;
        Iterator<Productos> it=lista.iterator();
        while(it.hasNext()){
            ++pos;
            Productos aux=it.next();
            if(aux.getId()==id){
                break;
            }
        }
        return pos;
    }
}
