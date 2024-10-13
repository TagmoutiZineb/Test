package dbconnection;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;

public class CLApplication {

	public static void main(String args[]) {
		Database db = new Database();
		db.setUser("postgres");
		db.setPassword("12022001");
		db.setUrl("localhost", 5432, "postgres");
		db.openConnection();
		// db.dbQuery("create schema neuschema");
		// db.dbQuery("set search_path to neuschema");
		// db.dbQuery("create table xyz (id serial , name text)");
		db.dbQuery("set search_path to auftragsverwaltung ");
		String sQuery = "Select id , gebietname from gebiet";
		ArrayList<String[]> queryResult = db.dbQueryResult(sQuery);
		for (String[] row : queryResult) {
			for (String value : row) {
				System.out.println(value + "\t");
			}
			System.out.println();
		}
		db.closeConnection();

	}

}
