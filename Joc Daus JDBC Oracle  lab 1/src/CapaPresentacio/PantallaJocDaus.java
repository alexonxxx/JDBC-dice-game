package CapaPresentacio;

import java.awt.Graphics;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import CapaAplicacio.ControladorJocDaus;
import CapaAplicacio.LoginController;
import CapaAplicacioDTO.JugadorDTO;
import CapaAplicacioDTO.PartidaDTO;
import CapaPersistencia.LoginBBDD;

@SuppressWarnings("serial")
public class PantallaJocDaus extends javax.swing.JFrame implements WindowListener {

	private ControladorJocDaus controladorJocDaus;
	private javax.swing.JTextField dau1;
	private javax.swing.JTextField dau2;
	private javax.swing.JTextField guanyades;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JLabel jLabel7;
	private javax.swing.JLabel jLabel8;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JTextArea jugadesLlista;
	private javax.swing.JButton jugar;
	private javax.swing.JButton llistaJugades;
	private javax.swing.JTextField resultat;
	private javax.swing.JTextField textJugador;
	private DausFondo panel;
	private JugadorDTO jugador;

	public PantallaJocDaus() throws Exception {
		initComponents();

		this.controladorJocDaus = new ControladorJocDaus();
		this.jugador= this.controladorJocDaus.getJugador();
		
		textJugador.setText(this.jugador.getNomJugador());
		int i = textJugador.getText().length();
		textJugador.setSelectionStart(0);
		textJugador.setSelectionEnd(i);
		this.setVisible(true);
	}

	private void initComponents() {
		setResizable(false);
		jLabel1 = new javax.swing.JLabel();
		jLabel1.setBounds(39, 38, 88, 17);
		textJugador = new javax.swing.JTextField();
		textJugador.setBounds(131, 35, 114, 23);
		jugar = new javax.swing.JButton();
		jugar.setBounds(87, 77, 88, 25);
		jLabel2 = new javax.swing.JLabel();
		jLabel2.setBounds(39, 145, 42, 17);
		jLabel3 = new javax.swing.JLabel();
		jLabel3.setBounds(91, 120, 0, 0);
		jLabel5 = new javax.swing.JLabel();
		jLabel5.setBounds(147, 145, 42, 17);
		resultat = new javax.swing.JTextField();
		resultat.setBounds(39, 183, 206, 34);
		llistaJugades = new javax.swing.JButton();
		llistaJugades.setBounds(370, 34, 151, 25);
		jScrollPane1 = new javax.swing.JScrollPane();
		jScrollPane1.setBounds(308, 85, 246, 240);
		jugadesLlista = new javax.swing.JTextArea();
		jLabel7 = new javax.swing.JLabel();
		jLabel7.setBounds(39, 280, 68, 17);
		guanyades = new javax.swing.JTextField();
		guanyades.setBounds(121, 277, 74, 23);
		dau1 = new javax.swing.JTextField();
		dau1.setBounds(82, 142, 55, 23);
		dau2 = new javax.swing.JTextField();
		dau2.setBounds(193, 142, 52, 23);
		jLabel8 = new javax.swing.JLabel();
		jLabel8.setBounds(199, 280, 14, 17);

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setTitle("Joc Daus");

		jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14));
		jLabel1.setText("Nom Jugador:");

		textJugador.setFont(new java.awt.Font("Tahoma", 0, 14));
		textJugador.setText("Anònim");
		textJugador.setName("nomJugador");
		textJugador.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				nomJugadorActionPerformed(evt);
			}
		});

		jugar.setFont(new java.awt.Font("Tahoma", 0, 14));
		jugar.setText("Jugar");
		jugar.setEnabled(false);
		jugar.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {

				jugarActionPerformed(evt);

			}
		});

		jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14));
		jLabel2.setText("Dau 1:");

		jLabel3.setName("dau1");

		jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14));
		jLabel5.setText("Dau 2:");

		resultat.setEditable(false);
		resultat.setFont(new java.awt.Font("Tahoma", 0, 14));
		resultat.setForeground(new java.awt.Color(204, 0, 0));

		llistaJugades.setFont(new java.awt.Font("Tahoma", 0, 14));
		llistaJugades.setText("Llistar Jugades");
		llistaJugades.setEnabled(false);
		llistaJugades.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				llistaJugadesActionPerformed(evt);
			}
		});

		jugadesLlista.setColumns(20);
		jugadesLlista.setEditable(false);
		jugadesLlista.setFont(new java.awt.Font("Tahoma", 0, 14));
		jugadesLlista.setRows(5);
		jScrollPane1.setViewportView(jugadesLlista);

		jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14));
		jLabel7.setText("Guanyades");

		guanyades.setEditable(false);
		guanyades.setFont(new java.awt.Font("Tahoma", 0, 14));
		guanyades.setText("            ");

		dau1.setEditable(false);
		dau1.setFont(new java.awt.Font("Tahoma", 0, 14));

		dau2.setEditable(false);
		dau2.setFont(new java.awt.Font("Tahoma", 0, 14));

		jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14));
		jLabel8.setText("%");

		java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		setBounds((screenSize.width - 598) / 2, (screenSize.height - 429) / 2, 598, 429);

		this.panel = new DausFondo();
		Graphics g = null;
		this.panel.paintComponents(g);
		getContentPane().add(this.panel);
		this.panel.setLayout(null);
		this.panel.add(jLabel3);
		this.panel.add(jLabel1);
		this.panel.add(textJugador);
		this.panel.add(resultat);
		this.panel.add(jLabel7);
		this.panel.add(guanyades);
		this.panel.add(jLabel8);
		this.panel.add(jLabel2);
		this.panel.add(dau1);
		this.panel.add(jLabel5);
		this.panel.add(dau2);
		this.panel.add(jugar);
		this.panel.add(llistaJugades);
		this.panel.add(jScrollPane1);
	}

	private void jugarActionPerformed(java.awt.event.ActionEvent evt) {
		PartidaDTO jugada;
		try {
			controladorJocDaus.jugar();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(this, e.getMessage(), "Error lectura BBDD", JOptionPane.ERROR_MESSAGE);
		}
		jugada = controladorJocDaus.getPartidaEnCurs();
		dau1.setText(jugada.getDau1());
		dau2.setText(jugada.getDau2());
		resultat.setText(jugada.getResultat());
		String s = String.format("%3.2f", controladorJocDaus.guanyadesPercent());
		guanyades.setText(s);

	}

	private void nomJugadorActionPerformed(java.awt.event.ActionEvent evt) {
		try {
			textJugador.setEnabled(false);
			controladorJocDaus.nouJugador(textJugador.getText());
			jugar.setEnabled(true);
			llistaJugades.setEnabled(true);
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(this, ex.getMessage(), "Error lectura BBDD", JOptionPane.ERROR_MESSAGE);
		}
	}

	private void llistaJugadesActionPerformed(java.awt.event.ActionEvent evt) {
		List<PartidaDTO> jugades;
		jugades =  controladorJocDaus.resultatPartides();
		String partides="";
		for(PartidaDTO p: jugades){
			partides+= p.getInfoResultat()+"\n";
		}
		jugadesLlista.setText(partides.toString());
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@SuppressWarnings("static-access")
	@Override
	public void windowClosing(WindowEvent e) {
		if (e.getSource() == this) {
			try {
				new LoginController().finalitzarJoc();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub

	}
}
