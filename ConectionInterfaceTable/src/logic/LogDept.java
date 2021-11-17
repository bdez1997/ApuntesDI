package logic;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;


public class LogDept {
	
	
	
	public static void getList() {
		
		  DefaultTableModel tableQuery = new DefaultTableModel();
		  
		try {
			// Conexionn a BBDD
			dbms.DBOracle.conectar();
			String sql = view.FrmPrincipal.txtSQL.getText();

			// Ejecutamos orden SQL
			Statement myOrder = dbms.DBOracle.getConn().createStatement();
			myOrder.execute(sql);

			ResultSet resultado = myOrder.getResultSet();
			ResultSetMetaData info = resultado.getMetaData();

			int numCampos = info.getColumnCount();

			for (int i = 1; i <= numCampos; i++) {
				
				tableQuery.addColumn(info.getColumnName(i));
				
			}
			
			String[] sShowDataColumn= new String[numCampos];
			while (resultado.next()) {

				for (int i = 1; i <= numCampos; i++) {
					sShowDataColumn[i-1]=resultado.getString(i);
				}
				
				tableQuery.addRow(sShowDataColumn);
				
				/*
				 * System.out.print("Nombre: "+resultado.getString("ENAME"));
				 * System.out.print("Salario: "+resultado.getInt(2));
				 */

			}
			view.FrmPrincipal.tableEjercicio.setModel(tableQuery);
			dbms.DBOracle.desconectar();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
