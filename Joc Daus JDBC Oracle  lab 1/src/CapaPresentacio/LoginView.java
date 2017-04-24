package CapaPresentacio;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


import javax.swing.BorderFactory;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import CapaAplicacio.LoginController;

import java.awt.Font;
import java.awt.Graphics;


@SuppressWarnings("serial")
public class LoginView extends JFrame implements ActionListener, KeyListener{

	private JPanel contentPane;
	private JPanel panel;
	private JLabel lblTitol;
	private JButton btnEntrar;
	private JTextField txtUsuari;
	private JPasswordField txtPassword;
	private JLabel lblUsuari;
	private JLabel lblPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginView frame = new LoginView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 200, 470, 340);
		setTitle("Login");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setResizable(false);
		setContentPane(contentPane);
		initComponents();
	}

	private void initComponents() {
		
		this.panel = new FondoPantalla();
		Graphics g=null;
		this.panel.paintComponents(g);
		this.contentPane.add(this.panel);
		this.panel.setLayout(null);
		
		this.lblTitol = new JLabel("Joc de Daus");
		this.lblTitol.setBounds(170, 31, 94, 16);
		this.lblTitol.setFont(new Font("Tahoma", Font.BOLD, 15));
		this.lblTitol.setForeground(Color.blue);
		this.panel.add(this.lblTitol);
		
		this.lblUsuari = new JLabel("Usuari:");
		this.lblUsuari.setBounds(43, 91, 94, 16);
		
		this.panel.add(this.lblUsuari);

		this.txtUsuari = new JTextField();
		this.txtUsuari.setBounds(43, 118, 160, 26);
		this.txtUsuari.setBorder(BorderFactory.createLineBorder(Color.blue));
		this.txtUsuari.setColumns(10);
		this.panel.add(this.txtUsuari);

		this.lblPassword = new JLabel("Contrasenya:");
		this.lblPassword.setBounds(237, 91, 94, 16);
		this.panel.add(this.lblPassword);

		this.txtPassword = new JPasswordField();
		this.txtPassword.setBounds(237, 118, 160, 26);
		this.txtPassword.setBorder(BorderFactory.createLineBorder(Color.blue));
		this.txtPassword.addKeyListener(this);
		this.panel.add(this.txtPassword);
		
		this.btnEntrar = new JButton("Entrar");
		this.btnEntrar.addActionListener(this);
		this.btnEntrar.setBounds(157, 169, 117, 29);
		this.panel.add(this.btnEntrar);
		
		
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.btnEntrar) {
			btnEntrarActionPerformed(e);
		}
		
	}
	


	private void btnEntrarActionPerformed(ActionEvent e) {
		String password = new String(this.txtPassword.getPassword());

		try {
			new LoginController().login(this.txtUsuari.getText(), password);
			new PantallaJocDaus();
			this.dispose();
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(this, e1.getMessage(), "Error Login", JOptionPane.ERROR_MESSAGE);
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_ENTER) {
			String password = new String(this.txtPassword.getPassword());

			try {
				new LoginController().login(this.txtUsuari.getText(), password);
				new PantallaJocDaus();
				this.dispose();
			} catch (Exception e1) {
				
				JOptionPane.showMessageDialog(this, e1.getMessage(), "Error Login", JOptionPane.ERROR_MESSAGE);
			
			}
		}
		
	}


	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
