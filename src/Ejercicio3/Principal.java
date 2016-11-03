package Ejercicio3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.*;

public class Principal {

	public static void main(String[] args) {
		selectMySql();

	}

	public static void selectMySql() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
		Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/acadt","root","");
		System.out.println(conexion.getMetaData());
		Statement st= conexion.createStatement();
		//kllghfg
		ResultSet rs = st.executeQuery("SELECT apellido, oficio, salario FROM empleados where dept_no=20  ");
	//En el ejercicio pone que busquemos del departamento 10, pero yo pongo 20 porque me los he creado así en la BD
		while (rs.next()) {
			
		System.out.println(rs.getString(1));
		System.out.println(rs.getString(2));
		System.out.println(rs.getFloat(3));
		
			
		}
		rs.close();
		st.close();
		conexion.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
