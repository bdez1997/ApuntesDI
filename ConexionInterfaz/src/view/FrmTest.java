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

public class FrmTest extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldHost;
	private JTextField textFieldPort;
	private JTextField textFieldName;

	
	public FrmTest() {
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
		
		JLabel lblHost = new JLabel("HOST:");
		lblHost.setBounds(34, 22, 43, 27);
		contentPanel.add(lblHost);
		
		JLabel lblPort = new JLabel("PORT:");
		lblPort.setBounds(34, 46, 43, 27);
		contentPanel.add(lblPort);
		
		JLabel lblName = new JLabel("NAME:");
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
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dbms.DBOracle.readConfig();
			}
		});
		btnNewButton.setBounds(44, 117, 89, 23);
		contentPanel.add(btnNewButton);
		
	}
}
