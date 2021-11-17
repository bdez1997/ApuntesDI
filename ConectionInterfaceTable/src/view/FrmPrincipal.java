package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dbms.DBOracle;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class FrmPrincipal extends JFrame {

	private JPanel contentPane;
	public static JTextPane txtSQL;
	public static JTable tableEjercicio;
	
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
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new BorderLayout(0, 0));
		
		JButton btnEjecutar = new JButton("Ejecutar");
		panel.add(btnEjecutar, BorderLayout.EAST);
		
		txtSQL = new JTextPane();
		txtSQL.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		panel.add(txtSQL, BorderLayout.CENTER);
		
		
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		tableEjercicio = new JTable();
		scrollPane.setViewportView(tableEjercicio);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnuOracle = new JMenu("Oracle");
		menuBar.add(mnuOracle);
		
		JMenuItem mntmConexion = new JMenuItem("Conexion");
		mnuOracle.add(mntmConexion);
		
		JMenuItem mntmLogin = new JMenuItem("Login");
		mnuOracle.add(mntmLogin);
		
		JSeparator separator = new JSeparator();
		mnuOracle.add(separator);
		
		JMenuItem mntmTest = new JMenuItem("Test");
		mnuOracle.add(mntmTest);
		
		mntmConexion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new FrmConexion();
			}
		});
		
		mntmLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new FrmLogin();
			}
		});
		
		mntmTest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean boPrueba;
				boPrueba=DBOracle.tryConnection();
				
				if(boPrueba) {
					System.out.println("Se ha conectado");
				}else {
					System.out.println("La chupas crack");
				}
			}
		});
		
		btnEjecutar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				logic.LogDept.getList();
			}
		});
		
	}

}
