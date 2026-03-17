package models;

import lombok.Getter;

import java.util.*;

@Getter

public class Personaje {
    private String nombre;
    private Map<String, Item> inventario;
    private Map <TipoEquipamiento, Item> equipo;

    public Personaje(String nombre) {
        this.nombre = nombre;
        this.inventario = new HashMap<>();
        this.equipo= new TreeMap<>();
    }



    public void agregarItemInventario(Item item){
        this.inventario.put(item.getNombre(),item);
    }
    public void eliminarItemInventario(String nombreItem){
        this.inventario.remove(nombreItem);
    }

    /**
     * devolvemos una lista con todos los items del inventario del personaje
     * @return
     */
    public List<Item> getInventario(){
        return new ArrayList<>(inventario.values());
    }

    /**
     * buscamos item en el inventario del personaje por su nombre
     * @return
     */
    public  Item buscarItem(String nombreItem){
        return inventario.get(nombreItem);
    }

    public void agregarEquipo(TipoEquipamiento tipoEquipamiento ,Item item){
        //1.verificar que el item no este en el equipo
        // 2. verificar que el item este en el inventario
        //3.si habia algo en el equipo de la zona,devolverlo al inventario
        //4.agregar item al equipo
        //5.eliminar item del inventario

        //no vamos a comprobar que el item este en el inventario
        if (equipo.containsKey(tipoEquipamiento)){
            //mover item al inventario y poner el nuevo
            Item antiguo= equipo.get(tipoEquipamiento);
            inventario.put(antiguo.getNombre(),antiguo);
        }
        //poner el nuevo
        //ToDo-habria que comprobar TipoItem para ver si puedo ponerlo donde corresponde
        equipo.put(tipoEquipamiento,item);
        //eliminar el nuevo item del inventario
        inventario.remove(item.getNombre());
        }

    /**
     * elimina un item del equipo del personaje y se devuelve al inventario
     * @param tipoEquipamiento
     */

    public void quitarEquipo(TipoEquipamiento tipoEquipamiento){
        Item item= equipo.get(tipoEquipamiento);
        equipo.remove(tipoEquipamiento);
        inventario.put(item.getNombre(),item);
        }

        public List<Map.Entry<TipoEquipamiento, Item>> getEquipo(){
        return new ArrayList<>(equipo.entrySet());

        }



    }


