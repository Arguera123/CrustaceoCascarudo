package constants;

import model.Comida;

import java.lang.runtime.SwitchBootstraps;
import java.util.ArrayList;
import java.util.List;

public class IniciandoConstantes {
    public static List<Comida> llenarConstanteComida(Integer correlativo) {
        List<Comida> comidas = new ArrayList<Comida>();

        switch (correlativo) {
            case 1:
                comidas.add(new Comida("comidaNormal", "Cangreburguer con Queso", "La clasica con queso extra"));
                comidas.add(new Comida("comidaNormal", "Cangreburguer Doble", "Doble carne, doble sabor"));
                comidas.add(new Comida("comidaNormal", "Papas Fondo de Bikini", "Papas fritas estilo marino"));
                comidas.add(new Comida("comidaNormal", "Combo Sencillo", "Cangreburguer + Papas + Refresco"));
                break;
            case 2:
                comidas.add(new Comida("bebidaNormal", "Refresco de Kelp", "Gaseosa tradicional de kelp"));
                comidas.add(new Comida("bebidaNormal", "Jugo de Medusa", "100% exprimido (cuidado con los piquetes)"));
                comidas.add(new Comida("bebidaNormal", "Agua Salada", "Filtrada (mas o menos)"));
                comidas.add(new Comida("bebidaNormal", "Batido de Coral", "Batido dulce con toque de algas"));
                break;
            case 3:
                comidas.add(new Comida("comidaEmpresarial", "Cangreburguer Ejecutiva", "Servida en plato premium, con toque de coral"));
                comidas.add(new Comida("comidaEmpresarial", "Ensalada Oceanica Deluxe", "Lechuga marina, algas finas, crotones de coral"));
                comidas.add(new Comida("comidaEmpresarial", "Fondo Marino Especial", "Filete de medusa, con vegetales globo"));
                comidas.add(new Comida("comidaEmpresarial", "Combo Empresarial Gold", "Cangreburguer Ejecutiva + Ensalada + Bebida Pro"));
                break;
            case 4:
                comidas.add(new Comida("bebidaEmpresarial", "Cafe Fondo de Bikini", "Mezcla fuerte de grano del abismo"));
                comidas.add(new Comida("bebidaEmpresarial", "Te de Algas Premium", "Infusion calmante para tiburones ejecutivos"));
                comidas.add(new Comida("bebidaEmpresarial", "Agua Desionizada de Lujo", "0% sal, 100% elegancia"));
                comidas.add(new Comida("bebidaEmpresarial", "Batido Ejecutivo de Coral", "Version deluxe, servicio en copa de burbuja"));
                break;
            default:
                break;
        }
        return comidas;
    }
}
