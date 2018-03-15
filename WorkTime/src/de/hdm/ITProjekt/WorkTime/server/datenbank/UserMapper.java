package de.hdm.ITProjekt.WorkTime.server.datenbank;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import de.hdm.ITProjekt.WorkTime.shared.User;

public class UserMapper {

	public static Vector<User> findAll() {
		Connection con = DBConnection.connection();
		Vector<User> result = new Vector<User>();

		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM User ORDER BY name asc");

			while (rs.next()) {
				User u = new User();
				u.setId(rs.getInt("id"));
				u.setEmail(rs.getString("email"));
				u.setName(rs.getString("name"));
				u.setPasswort(rs.getString("passwort"));
				u.setTyp(rs.getInt("typ"));
				u.setVorname(rs.getString("vorname"));
				u.setLetzterLogin(rs.getDate("letzterLogin"));

				result.addElement(u);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public static User finByEmail(String email) {
		Connection con = DBConnection.connection();
		User u = null;
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT email FROM User" + email);

			if (rs.next()) {
				u = new User();
				// u = new User(rs.getString("email")); Zeigt einen Fehler an, so steht es im
				// Bsp. von Chris?!
				u.setId(rs.getInt("id"));
				u.setEmail(rs.getString("email"));
				u.setName(rs.getString("name"));
				u.setPasswort(rs.getString("passwort"));
				u.setTyp(rs.getInt("typ"));
				u.setVorname(rs.getString("vorname"));
				u.setLetzterLogin(rs.getDate("letzterLogin"));

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return u;

	}

	public static User findById(int id) {
		Connection con = DBConnection.connection();
		User u = null;
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM User WHERE id = " + id);
			if (rs.next()) {
				u = new User();
				u.setId(rs.getInt("id"));
				u.setEmail(rs.getString("email"));
				u.setName(rs.getString("name"));
				u.setPasswort(rs.getString("passwort"));
				u.setTyp(rs.getInt("typ"));
				u.setVorname(rs.getString("vorname"));
				u.setLetzterLogin(rs.getDate("letzterLogin"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return u;

	}

}
