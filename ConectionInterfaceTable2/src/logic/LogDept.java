package logic;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.table.DefaultTableModel;

public class LogDept {

	public static int iNumRow;
	public static int iNumColumn;
	public static String sSelectedTable;
	

	public static void getInfo() {
		
		DefaultTableModel tableQuery = new DefaultTableModel();

		try {
			// Conexionn a BBDD
			dbms.DBOracle.conectar();

			// Ejecutamos orden SQL
			Statement myOrder = dbms.DBOracle.getConn().createStatement();
			String sql = "select table_name from user_tables order by table_name";
			myOrder.execute(sql);

			ResultSet resultado = myOrder.getResultSet();
			ResultSetMetaData info = resultado.getMetaData();

			iNumColumn = info.getColumnCount();
			int numCampos = info.getColumnCount();

			for (int i = 1; i <= numCampos; i++) {

				tableQuery.addColumn(info.getTableName(i));

			}

			String[] sShowDataColumn = new String[numCampos];
			
			while (resultado.next()) {

				for (int i = 1; i <= numCampos; i++) {
					sShowDataColumn[i - 1] = resultado.getString(i);
				}
				iNumRow = resultado.getRow();
				tableQuery.addRow(sShowDataColumn);

			}
			view.FrmPrincipal.lstNameTable.setModel(tableQuery);

			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void getList() {
		sSelectedTable=view.FrmPrincipal.lstNameTable.getValueAt(view.FrmPrincipal.lstNameTable.getSelectedRow(),0).toString();

		DefaultTableModel tableQuery = new DefaultTableModel();

		try {
			// Conexionn a BBDD
			dbms.DBOracle.conectar();

			// Ejecutamos orden SQL
			Statement myOrder = dbms.DBOracle.getConn().createStatement();
			String sql = "SELECT * FROM "+ sSelectedTable;
			myOrder.execute(sql);

			ResultSet resultado = myOrder.getResultSet();
			ResultSetMetaData info = resultado.getMetaData();

			int numCampos = info.getColumnCount();

			for (int i = 1; i <= numCampos; i++) {

				tableQuery.addColumn(info.getColumnLabel(i));

			}

			String[] sShowDataColumn = new String[numCampos];
			while (resultado.next()) {

				for (int i = 1; i <= numCampos; i++) {
					sShowDataColumn[i - 1] = resultado.getString(i);
				}

				tableQuery.addRow(sShowDataColumn);

			}
			view.FrmPrincipal.tableEjercicio.setModel(tableQuery);
			dbms.DBOracle.desconectar();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
