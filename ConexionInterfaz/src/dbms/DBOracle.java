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
	private static Config dbProperties=new Config("10.192.120.60","1521","ORCL","BERMUDEZ","medac2021");
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
			
			dbProperties.setHOST(sHost);
			
			String sTExto=dbProperties.toString();
			
		fchConfigAll.writeBytes(sTExto);
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
		
		
		dbURL="jdbc:oracle:thin:@"+dbProperties.getHOST()+":"+dbProperties.getPORT()+":"+dbProperties.getNAME();
		
		//cargar el Driver en memoria 
		
		Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
		
		//Establecemos la conexion
		
		conn=DriverManager.getConnection(dbURL,dbProperties.getUSER(),dbProperties.getPASS());
		
		
	}

	public static void writeLogin() {
		// TODO Auto-generated method stub
		
	}
	
}
