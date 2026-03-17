package App;

import models.Item;
import models.Personaje;
import models.TipoEquipamiento;
import models.TipoItem;

import java.util.Map;

public class App {
    static void main() {
        Personaje personaje = new Personaje("Link");
        personaje.agregarItemInventario(new Item("Espada Maestra", "La espada de los dioses", 18, TipoItem.ARMA));
        personaje.agregarItemInventario(new Item("Escudo Hyliano", "Forjado en el reyno de hyrule", 18, TipoItem.ARMADURA));
        personaje.agregarItemInventario(new Item("Elixir rojo", "cura 6 corazones", 18, TipoItem.CONSUMIBLE));
        personaje.agregarItemInventario(new Item("Botas zora", "puedes sumergirte en el agua", 18, TipoItem.ARMADURA));


        personaje.agregarEquipo(TipoEquipamiento.MANO_PRINCIPAL, personaje.buscarItem("Espada Maestra"));
        personaje.agregarEquipo(TipoEquipamiento.PIERNAS, personaje.buscarItem("Botas zora"));

        IO.println("--- EQUIPO ---");
        for (Map.Entry<TipoEquipamiento, Item> entry : personaje.getEquipo()) {
            IO.println(entry.getKey() + ": " + entry.getValue());
        }

        IO.println("--- INVENTARIO ---");
        for (Item item : personaje.getInventario()) {
            IO.println(item);
        }

    }
}
