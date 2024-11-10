import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Font;


import javax.swing.BorderFactory;

import javax.swing.border.Border;

public class VentanaInicio extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textusuario;
	private JPasswordField textpass;
    private Usuario usuarioRegistrado = new Usuario("TuNombre", "uem", "Alumno");
	
    public VentanaInicio() {
		setResizable(false);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setBounds(100, 100, 720, 514);
	    
	    //	AQUI CREO UNA FUENTE CON UN ESTILO COMUN
	    Font commonFont = new Font("Roboto", Font.PLAIN, 14);
	    Border commonBorder = BorderFactory.createLineBorder(Color.GRAY, 1);
	    Color backgroundColor = Color.WHITE;  
	    Color textColor = Color.BLACK;        
	    
	    
	    contentPane = new JPanel();
	    contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));

	    setContentPane(contentPane);
	    contentPane.setLayout(new BorderLayout(0, 0));
	    
	    JPanel panel = new JPanel();
	    panel.setBackground(new Color(169, 169, 169));
	    contentPane.add(panel, BorderLayout.CENTER);
	    panel.setLayout(null);
	   
	    // AQUI TENGO UN PROBLEMA, EN EL DESING LA IMAGEN SE VE PERFECTA, PERO AL EJECUTAR SE NOTA ALGO PIXELADA, POR QUE?
	    JLabel lblNewLabel = new JLabel("New label");
	    lblNewLabel.setIcon(new ImageIcon(VentanaInicio.class.getResource("/imagenes/universidad-europea-logo_poc9mEM.originalpequeña.png")));
	    lblNewLabel.setBounds(326, 169, 370, 119);
	    panel.add(lblNewLabel);
	   
	    // AQUI AGREGO TODOS LOS BOTONES
	    JLabel lblUsuario = new JLabel("USUARIO:");
	    lblUsuario.setFont(commonFont);
	    lblUsuario.setForeground(textColor);
	    lblUsuario.setBounds(45, 169, 120, 25); 
	    lblUsuario.setVerticalAlignment(SwingConstants.CENTER); 
	    panel.add(lblUsuario);
	    
	    JLabel lblContraseña = new JLabel("CONTRASEÑA:");
	    lblContraseña.setFont(commonFont);
	    lblContraseña.setForeground(textColor);
	    lblContraseña.setBounds(45, 217, 120, 25); 
	    lblContraseña.setVerticalAlignment(SwingConstants.CENTER); 
	    panel.add(lblContraseña);
	    
	    JLabel lblCargo = new JLabel("CARGO:");
	    lblCargo.setFont(commonFont);
	    lblCargo.setForeground(textColor);
	    lblCargo.setBounds(45, 266, 120, 25); 
	    lblCargo.setVerticalAlignment(SwingConstants.CENTER); 
	    panel.add(lblCargo);
	    
	    String[] opciones = { "Alumno", "Profesor"};
        JComboBox<String> comboBox = new JComboBox<>(opciones);
        comboBox.setBounds(170, 266, 150, 25);
	    panel.add(comboBox);
	    
	    //NO SE SI LA COMPARACION ENTRE LOS DATOS INGRESADOS Y LOS DEL USUARIO SE DEBERIA REALIZAR DIRECTAMENTE EN LA LOGICA DEL BOTON ENTRAR O EN OTRA PARTE
	    JButton btnEntrar = new JButton("ENTRAR");
	    btnEntrar.addActionListener(new ActionListener() {
	    	@Override
	    	public void actionPerformed(ActionEvent e) {
	    		String nombreIngresado = textusuario.getText();
	            String contrasenaIngresada = new String(textpass.getPassword());
	            String cargoSeleccionado = (String) comboBox.getSelectedItem();
	            if (nombreIngresado.equals(usuarioRegistrado.getNombre()) &&
	                    contrasenaIngresada.equals(usuarioRegistrado.getContrasena()) &&
	                    cargoSeleccionado.equals(usuarioRegistrado.getCargo())) {
	                    JOptionPane.showMessageDialog(null, "Bienvenido, " + usuarioRegistrado.getNombre() + "!");
	                } else {
	                    JOptionPane.showMessageDialog(null, "Datos incorrectos", "Error", JOptionPane.ERROR_MESSAGE);
	                }
	    	}
	    });
	    btnEntrar.setBounds(441, 396, 85, 21);
	    panel.add(btnEntrar);
	    
	    JButton btnSalir = new JButton("SALIR");
	    btnSalir.setBounds(574, 396, 85, 21);
	    panel.add(btnSalir);
	    
	    btnSalir.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            System.exit(0);
	        }
	    });
	    
	    JButton btnLimpiar = new JButton("LIMPIAR");
	    btnLimpiar.setFont(new Font("Roboto Black", Font.PLAIN, 10));
	    btnLimpiar.setBounds(116, 318, 85, 21);
	    panel.add(btnLimpiar);
	    
	    btnLimpiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textusuario.setText(""); 
                textpass.setText("");  
            }
        });
	    
	    textusuario = new JTextField();
	    textusuario.setFont(commonFont);
	    textusuario.setBackground(backgroundColor);
	    textusuario.setForeground(textColor);
	    textusuario.setBorder(commonBorder);
	    textusuario.setBounds(170, 169, 150, 25);  
	    panel.add(textusuario);
	    
	    textpass = new JPasswordField();
	    textpass.setFont(commonFont);
	    textpass.setBackground(backgroundColor);
	    textpass.setForeground(textColor);
	    textpass.setBorder(commonBorder);
	    textpass.setBounds(170, 217, 150, 25);
	    panel.add(textpass);
	    
	}
}