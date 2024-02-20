public class Nacional extends Producto {
    public String registroDIAN;

    public Nacional(int codigo, String nombre, String registroDIAN) {
        super(codigo, nombre);
        this.registroDIAN = registroDIAN;
    }

}
