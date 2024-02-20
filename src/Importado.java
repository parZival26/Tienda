public class Importado extends Producto {
    public String licenciaImportacion;

    public Importado(int codigo, String nombre, String licenciaImportacion) {
        super(codigo, nombre);
        this.licenciaImportacion = licenciaImportacion;
    }

}
