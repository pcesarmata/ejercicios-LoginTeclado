package net.tecgurus;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class LoginTecladoView {

	private JFrame frame;
	private JTextField txtUsuario;
	private JPasswordField txtPassword;
	
	// Instanciamos la clase Usuario creando el objeto alumno
	// para acceder a sus atributos (usr y pass)
	UsuarioTeclado alumno = new UsuarioTeclado();
	
	// Creamos el objeto teclado para settear el usuario y password
	Scanner teclado = new Scanner(System.in);
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginTecladoView window = new LoginTecladoView();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * Constructor que sirve para inicializar la ventana y sus propiedades.
	 */
	public LoginTecladoView() {
		
		System.out.println("Ingresa el usuario a settear: ");
		alumno.setUsr(teclado.nextLine());
		System.out.println("Ingresa el password a settear: ");
		alumno.setPass(teclado.nextLine());
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 346, 280);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblUsuario = new JLabel("Usuario: ");
		lblUsuario.setBounds(39, 70, 73, 14);
		frame.getContentPane().add(lblUsuario);
		
		JLabel lblPassword = new JLabel("Password: ");
		lblPassword.setBounds(39, 140, 73, 14);
		frame.getContentPane().add(lblPassword);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(184, 67, 86, 20);
		frame.getContentPane().add(txtUsuario);
		txtUsuario.setColumns(10);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(184, 137, 86, 20);
		frame.getContentPane().add(txtPassword);
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.setBounds(100, 188, 89, 23);
		// Se implementa una accion al botón
		btnEntrar.addActionListener(new ActionListener() {
			// Agregamos el metodo de consultarUsuario al botón
			@Override
			public void actionPerformed(ActionEvent arg0) {
				consultarUsuario();
			}
		});
		
		frame.getContentPane().add(btnEntrar);
	}
	
	public void consultarUsuario(){
		String usuario = txtUsuario.getText();
		String password = String.valueOf(txtPassword.getPassword());
		
		// Validamos si las cajas de texto están vacias.
		if (usuario.isEmpty()) {
			JOptionPane.showMessageDialog(null, "El usuario es requerido", "ERROR", JOptionPane.ERROR_MESSAGE);
			return;
		} else if (password.isEmpty()){
			JOptionPane.showMessageDialog(null, "El password es requerido", "ERROR", JOptionPane.ERROR_MESSAGE);
			return;
		}

//		***Se comienza por esta validacion.***
//		// Validamos si el usuario es correcto.
//		if (usuario.equals(alumno.getUsr())) {
//			System.out.println("Usuario correcto");
//		} else {
//			System.out.println("Usuario incorrecto");
//		}
		
//		// Validamos si el usuario es correcto.
//		if (password.equals(alumno.getPass())) {
//			System.out.println("Password correcto");
//		} else {
//			System.out.println("Password incorrecto");
//		}

		// Validamos el usuario.
		if (usuario.equals(alumno.getUsr())) {
			System.out.println("El usuario es correcto");
		} else {
			System.out.println("El usuario es incorrecto");
		}
		
		// Validamos la contraseña.
		if (password.equals(alumno.getPass())) {
			System.out.println("La contraseña es correcta");
		} else {
			System.out.println("La contraseña es incorrecta");
		}
		
		// Validamos tanto usuario como contraseña en el mismo if
		if (alumno.getUsr().equals(usuario) && alumno.getPass().equals(password)) {
			System.out.println("Usuario loggeado correctamente");
		} else {
			System.out.println("Usuario loggeado incorrectamente");
		}
	}
}