package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmConexion extends JDialog {

	private final JPanel contentPanel = new JPanel();
	
	public static JTextField textFieldHost;
	public static JTextField textFieldPort;
	public static JTextField textFieldName;
	private JLabel lblHost;
	private JLabel lblPort;
	private JLabel lblName;
	

	
	public FrmConexion() {
		dbms.DBOracle.readConfig();
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 237, 190);
		crearComponentes();
		setVisible(true);
	}
	
	public void crearComponentes(){
		
		
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		lblHost = new JLabel("HOST:");
		lblHost.setBounds(34, 22, 43, 27);
		contentPanel.add(lblHost);
		
		lblPort = new JLabel("PORT:");
		lblPort.setBounds(34, 46, 43, 27);
		contentPanel.add(lblPort);
		
		lblName = new JLabel("NAME:");
		lblName.setBounds(34, 72, 43, 24);
		contentPanel.add(lblName);
		
		textFieldHost = new JTextField();
		textFieldHost.setBounds(79, 25, 115, 20);
		contentPanel.add(textFieldHost);
		textFieldHost.setColumns(10);
		
		textFieldPort = new JTextField();
		textFieldPort.setBounds(79, 49, 115, 20);
		contentPanel.add(textFieldPort);
		textFieldPort.setColumns(10);
		
		textFieldName = new JTextField();
		textFieldName.setBounds(79, 74, 115, 20);
		contentPanel.add(textFieldName);
		textFieldName.setColumns(10);
		
		textFieldHost.setText(dbms.DBOracle.sHost);
		textFieldPort.setText(dbms.DBOracle.sPort);
		textFieldName.setText(dbms.DBOracle.sName);
		
		JButton btnAceptarConn = new JButton("Aceptar");
		btnAceptarConn.setBounds(10, 117, 89, 23);
		contentPanel.add(btnAceptarConn);
		
		JButton btnCancelarConn = new JButton("Cancelar");
		btnCancelarConn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelarConn.setBounds(122, 117, 89, 23);
		contentPanel.add(btnCancelarConn);
		
		btnAceptarConn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dbms.DBOracle.writeConfig();
			}
		});
		
	}
}
