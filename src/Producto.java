import java.util.ArrayList;

public class Producto {
    private int codigo;
    public String nombre;

    public Producto(int codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public int getCodigo() {
        return codigo;
    }

    public static String buscar(int codigo, ArrayList<Producto> productos) {
        for (Producto producto : productos) {
            if (producto.getCodigo() == codigo) {
                return producto.nombre;
            }
        }
        return "No existe";

    }

    public String getNombre() {
        return nombre;
    }

}
