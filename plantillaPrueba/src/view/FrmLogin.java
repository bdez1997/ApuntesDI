package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmLogin extends JDialog {

	private final JPanel contentPanel = new JPanel();
	public static JTextField txtUser;
	public static JPasswordField txtPassword;

	public FrmLogin() {
		dbms.DBOracle.readConfig();
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 303, 214);
		crearComponentes();
		setVisible(true);
	}

	private void crearComponentes() {
		
		
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblUser = new JLabel("USER:");
		lblUser.setBounds(61, 31, 36, 24);
		contentPanel.add(lblUser);
		
		txtUser = new JTextField();
		txtUser.setBounds(103, 33, 111, 20);
		contentPanel.add(txtUser);
		txtUser.setColumns(10);
		
		JLabel lblPass = new JLabel("PASS:");
		lblPass.setBounds(61, 66, 36, 14);
		contentPanel.add(lblPass);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(103, 63, 111, 20);
		contentPanel.add(txtPassword);
		
		JButton btnCancelarLog = new JButton("Cancelar");
		btnCancelarLog.setBounds(163, 120, 89, 23);
		contentPanel.add(btnCancelarLog);
		
		txtUser.setText(dbms.DBOracle.sUser);
		txtPassword.setText(dbms.DBOracle.sUser);
		
		
		JButton btnAceptarLog = new JButton("Login");
		btnAceptarLog.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dbms.DBOracle.writeLogin();
			}
		});
		
		btnAceptarLog.setBounds(27, 120, 89, 23);
		contentPanel.add(btnAceptarLog);
		
	}
}
