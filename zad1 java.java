import java.sql.*; //biblioteka sqla

public class App {
	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver"; //sterownik
	static final String DB_URL = "jdbc:mysql://10.0.10.3:3306/baza"; //adres
	static final String USER = "pieczy"; //nazwa uzytkownika
	static final String PASSWORD = "password"; //haslo
	
	public static void main(String[] args) {
		Connection c = null; //zmienna polaczenia do bazy
		Statement s = null; //zmienna danych
		try{
			Class.forName(JDBC_DRIVER); //wybór sterownika
			c = DriverManager.getConnection(DB_URL,USER,PASSWORD); //połączenie
			s = c.createStatement(); //tworzenie zmiennej danych
				s.executeUpdate("CREATE TABLE Tab (id int, A1 varchar(30));"); //tworzenie tabeli
				s.executeUpdate("INSERT INTO Tab (id,A1) VALUES (1,'tak');"); //pierwsza zmienna
				s.executeUpdate("INSERT INTO Tab (id,A1) VALUES (2,'nie');"); //druga zmienna
				s.executeUpdate("INSERT INTO Tab (id,A1) VALUES (3,'moze');"); //trzecia zmienna
				ResultSet result = s.executeQuery("SELECT * FROM Tab"); //dodaj do bazy
				
			while(result.next()){
				int id = result.getInt("id"); //zmienna id
				String a = result.getString("A1"); //zmienna a
				
				System.out.print("ID: " + id); //wyswietl id
				System.out.print(", A1: " + a); //wyswielt zmienna
			}
			result.close(); //skoncz wyswietlac wyniki
			s.close(); //skończ zmienną danych
			c.close(); //skończ zmienną połączenia do bazy
		}
	}
}