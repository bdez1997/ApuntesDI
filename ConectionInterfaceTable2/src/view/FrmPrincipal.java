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
import javax.swing.JList;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FrmPrincipal extends JFrame {

	public static JPanel contentPane;
	public static JTable lstNameTable;
	public static JTable tableEjercicio;
	
	
	public FrmPrincipal() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 541, 397);		
		crearComponentes();
		setVisible(true);
		
	}

	private void crearComponentes() {	
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		logic.LogDept.getInfo();
		
		lstNameTable = new JTable();
		lstNameTable.setBounds(10, 29, 149, 277);
		logic.LogDept.getInfo();
		contentPane.add(lstNameTable);
		
		tableEjercicio = new JTable();
		tableEjercicio.setBounds(192, 29, 323, 277);
		contentPane.add(tableEjercicio);
				
		
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
		
		lstNameTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				logic.LogDept.getList();
				
			}
		});
		
		
		
	}
}
