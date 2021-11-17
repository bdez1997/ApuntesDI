package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmPrincipal extends JFrame {

	private JPanel contentPane;

	public FrmPrincipal() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);		
		crearComponentes();
		setVisible(true);
		
	}

	private void crearComponentes() {
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnuOracle = new JMenu("Oracle");
		menuBar.add(mnuOracle);
		
		JMenuItem mntmConexion = new JMenuItem("Conexion");
		mntmConexion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new FrmTest();
			}
		});
		mnuOracle.add(mntmConexion);
		
		JMenuItem mntmLogin = new JMenuItem("Login");
		mnuOracle.add(mntmLogin);
		
		JSeparator separator = new JSeparator();
		mnuOracle.add(separator);
		
		JMenuItem mntmTest = new JMenuItem("Test");
		mnuOracle.add(mntmTest);
		
		
	}

}
