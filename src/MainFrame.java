import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MainFrame extends JFrame {
    private ArrayList<Producto> listaProductos;
    private JTextArea areaTexto;

    public static void initialize() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainFrame();
            }
        });
    }

    public MainFrame() {
        listaProductos = new ArrayList<>();

        areaTexto = new JTextArea(10, 30);
        areaTexto.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(areaTexto);

        JButton botonCrearNacional = new JButton("Crear Producto Nacional");
        botonCrearNacional.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String codigoStr = JOptionPane.showInputDialog("Ingrese el código del producto");
                int codigo;
                try {
                    codigo = Integer.parseInt(codigoStr);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "El código debe ser un número entero válido", "Error",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }
                String nombre = JOptionPane.showInputDialog("Ingrese el nombre del producto");
                String registroDIAN = JOptionPane.showInputDialog("Ingrese el registro DIAN del producto");
                Producto productoNacional = new Nacional(codigo, nombre, registroDIAN);
                listaProductos.add(productoNacional);
            }
        });

        JButton botonCrearImportado = new JButton("Crear Producto Importado");
        botonCrearImportado.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String codigoStr = JOptionPane.showInputDialog("Ingrese el código del producto");
                int codigo;
                try {
                    codigo = Integer.parseInt(codigoStr);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "El código debe ser un número entero válido", "Error",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }
                String nombre = JOptionPane.showInputDialog("Ingrese el nombre del producto");
                String licenciaImportacion = JOptionPane
                        .showInputDialog("Ingrese la licencia de importación del producto");
                Producto productoImportado = new Importado(codigo, nombre, licenciaImportacion);
                listaProductos.add(productoImportado);
            }
        });

        JButton buscar = new JButton("Buscar Producto");
        buscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String codigoStr = JOptionPane.showInputDialog("Ingrese el código del producto");
                int codigo;
                try {
                    codigo = Integer.parseInt(codigoStr);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "El código debe ser un número entero válido", "Error",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }
                String nombre = Producto.buscar(codigo, listaProductos);
                JOptionPane.showMessageDialog(null, "El producto con código " + codigo + " es " + nombre);
            }
        });

        JButton botonListar = new JButton("Listar Productos");
        botonListar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ListarProductos.listar(areaTexto, listaProductos);
            }
        });

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        mainPanel.add(botonCrearNacional);
        mainPanel.add(botonCrearImportado);
        mainPanel.add(buscar);
        mainPanel.add(botonListar);
        mainPanel.add(scrollPane);

        add(mainPanel);

        setTitle("Tienda");
        setSize(500, 600);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

}