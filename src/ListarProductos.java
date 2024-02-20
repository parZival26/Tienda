import java.util.ArrayList;
import javax.swing.JTextArea;

public class ListarProductos {
    public static void listar(JTextArea areaTexto, ArrayList<Producto> listaProductos) {
        areaTexto.setText("");
        for (Producto producto : listaProductos) {
            if (producto instanceof Nacional) {
                areaTexto.append("Tipo de producto: Nacional ");
            } else if (producto instanceof Importado) {
                areaTexto.append("Tipo de producto: Importado ");
            }

            areaTexto.append("Código: " + producto.getCodigo() + " Nombre: " + producto.getNombre() + "\n");

        }
    }
}
