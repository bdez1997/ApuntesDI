package dbms;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.StringTokenizer;

import model.Config;

public class DBOracle {

	private static File fchConfig =new File("config.cfg");
	public static String sHost,sPort,sName,sUser,sPass;
	private static Connection conn;
	private static Config dbProperties=new Config();
	private static String dbURL;
	
	public static void desconectar() throws SQLException {
		conn.close();
	}
	
	public static boolean tryConnection() {
		boolean Conectado=false;  
	try {
		conectar();
		desconectar();
		Conectado=true;
	} catch (Exception e) {
		Conectado=false;
	}
	return Conectado;
		
	}
	
	public static Connection getConn() {
		return conn;
	}
	public static void writeConfig() {
		
		try {
		
			RandomAccessFile fchConfigAll=new RandomAccessFile(fchConfig.getAbsolutePath(),"rw");
			dbProperties.setHOST(view.FrmConexion.textFieldHost.getText());
			dbProperties.setPORT(view.FrmConexion.textFieldPort.getText());
			dbProperties.setNAME(view.FrmConexion.textFieldName.getText());
			
			String sTexto=dbProperties.toString();
			
		fchConfigAll.writeBytes(sTexto);
		fchConfigAll.close();
								
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void writeLogin() {
			
		dbProperties.getHOST();
		dbProperties.getPORT();
		dbProperties.getNAME();
		
		try {
			
			RandomAccessFile fchConfigAll=new RandomAccessFile(fchConfig.getAbsolutePath(),"rw");
			
			dbProperties.setUSER(view.FrmLogin.txtUser.getText());
			dbProperties.setPASS(String.valueOf(view.FrmLogin.txtPassword.getPassword()));
			
			String sTexto=dbProperties.toString();
			
		fchConfigAll.writeBytes(sTexto);
		fchConfigAll.close();
								
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	public static void readConfig() {
		
		
		String sSeparador=":";
		
		try {
			BufferedReader br = new BufferedReader(new FileReader("config.cfg"));
			String sTexto=br.readLine();		
			String[] keyValue;
			String[] values = new String[5];
			int con = 0;
			while(sTexto!=null) {
				keyValue = sTexto.split(sSeparador);
				values[con] = keyValue[1];
				sTexto = br.readLine();
				con++;
			}
			
			sHost=values[0];
			sPort=values[1];
			sName=values[2];
			sUser=values[3];
			sPass=values[4];
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static void conectar() throws Exception {
		readConfig();
		
		dbURL="jdbc:oracle:thin:@"+sHost+":"+sPort+":"+sName;
		
		System.out.println(sHost+" "+sPort+" "+sName+" "+sUser+ sPass);
		
		//cargar el Driver en memoria 
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		//Establecemos la conexion
		
		conn=DriverManager.getConnection(dbURL,sUser,sPass);
		
		
	}
	
}
