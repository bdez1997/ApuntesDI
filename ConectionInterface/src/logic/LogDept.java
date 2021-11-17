package logic;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;


public class LogDept {
	
	public static String sMostrar="";
	public static void getList() {

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
				sMostrar+=info.getColumnName(i) + "             ";
			}
			sMostrar+="\n";

			while (resultado.next()) {

				for (int i = 1; i <= numCampos; i++) {
					sMostrar+=resultado.getString(i) + "             ";
				}
				sMostrar+="\n";

				/*
				 * System.out.print("Nombre: "+resultado.getString("ENAME"));
				 * System.out.print("Salario: "+resultado.getInt(2));
				 */

			}
			view.FrmPrincipal.txtReultSet.setText(sMostrar);
			dbms.DBOracle.desconectar();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
