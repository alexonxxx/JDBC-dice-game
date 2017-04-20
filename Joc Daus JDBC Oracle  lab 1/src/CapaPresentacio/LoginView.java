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

import CapaAplicacio.ControladorJocDaus;
import CapaAplicacio.LoginController;
import java.awt.Font;

@SuppressWarnings("serial")
public class LoginView extends JFrame implements ActionListener, KeyListener{

	private JPanel contentPane;
	private JPanel panel;
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
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		initComponents();
	}

	private void initComponents() {
		this.btnEntrar = new JButton("Entrar");
		this.btnEntrar.addActionListener(this);
		

		this.panel = new JPanel();
		this.panel.setBounds(100, 48, 319, 120);
		this.contentPane.add(this.panel);
		this.panel.setLayout(null);

		this.lblUsuari = new JLabel("Usuari:");
		this.lblUsuari.setBounds(43, 88, 94, 16);
		
		this.panel.add(this.lblUsuari);

		this.txtUsuari = new JTextField();
		this.txtUsuari.setBounds(43, 115, 160, 26);
		this.txtUsuari.setBorder(BorderFactory.createLineBorder(Color.blue));
		this.panel.add(this.txtUsuari);
		this.txtUsuari.setColumns(10);

		this.lblPassword = new JLabel("Contrasenya:");
		this.lblPassword.setBounds(236, 88, 94, 16);
		this.panel.add(this.lblPassword);

		this.txtPassword = new JPasswordField();
		this.txtPassword.setBounds(232, 115, 160, 26);
		this.txtPassword.setBorder(BorderFactory.createLineBorder(Color.blue));
		this.txtPassword.addKeyListener(this);
		this.panel.add(this.txtPassword);

		this.btnEntrar = new JButton("Entrar");
		this.btnEntrar.addActionListener(this);
		this.btnEntrar.setBounds(175, 179, 117, 29);
		this.panel.add(this.btnEntrar);
		
		JLabel lblNewLabel = new JLabel("LoginBBDD");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setForeground(Color.blue);
		lblNewLabel.setBounds(175, 29, 76, 26);
		panel.add(lblNewLabel);


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
			e1.printStackTrace();
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
				e1.printStackTrace();
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
