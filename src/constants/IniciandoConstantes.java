package constants;

import model.Comida;

import java.lang.runtime.SwitchBootstraps;
import java.util.ArrayList;
import java.util.List;

public class IniciandoConstantes {
    public static List<Comida> llenarConstanteComida() {
        List<Comida> comidas = new ArrayList<Comida>();

        comidas.add(new Comida("1","comidaNormal", "Cangreburguer con Queso", "La clasica con queso extra"));
        comidas.add(new Comida("2", "comidaNormal", "Cangreburguer Doble", "Doble carne, doble sabor"));
        comidas.add(new Comida("3","comidaNormal", "Papas Fondo de Bikini", "Papas fritas estilo marino"));
        comidas.add(new Comida("4","comidaNormal", "Combo Sencillo", "Cangreburguer + Papas + Refresco"));

        comidas.add(new Comida("5","bebidaNormal", "Refresco de Kelp", "Gaseosa tradicional de kelp"));
        comidas.add(new Comida("6","bebidaNormal", "Jugo de Medusa", "100% exprimido (cuidado con los piquetes)"));
        comidas.add(new Comida("7","bebidaNormal", "Agua Salada", "Filtrada (mas o menos)"));
        comidas.add(new Comida("8", "bebidaNormal", "Batido de Coral", "Batido dulce con toque de algas"));

        comidas.add(new Comida("9","comidaEmpresarial", "Cangreburguer Ejecutiva", "Servida en plato premium, con toque de coral"));
        comidas.add(new Comida("10","comidaEmpresarial", "Ensalada Oceanica Deluxe", "Lechuga marina, algas finas, crotones de coral"));
        comidas.add(new Comida("11","comidaEmpresarial", "Fondo Marino Especial", "Filete de medusa, con vegetales globo"));
        comidas.add(new Comida("12","comidaEmpresarial", "Combo Empresarial Gold", "Cangreburguer Ejecutiva + Ensalada + Bebida Pro"));

        comidas.add(new Comida("13","bebidaEmpresarial", "Cafe Fondo de Bikini", "Mezcla fuerte de grano del abismo"));
        comidas.add(new Comida("14","bebidaEmpresarial", "Te de Algas Premium", "Infusion calmante para tiburones ejecutivos"));
        comidas.add(new Comida("15","bebidaEmpresarial", "Agua Desionizada de Lujo", "0% sal, 100% elegancia"));
        comidas.add(new Comida("16","bebidaEmpresarial", "Batido Ejecutivo de Coral", "Version deluxe, servicio en copa de burbuja"));

        return comidas;
    }
}
