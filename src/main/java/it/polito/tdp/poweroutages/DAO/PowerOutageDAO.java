package it.polito.tdp.poweroutages.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import it.polito.tdp.poweroutages.model.Nerc;

public class PowerOutageDAO {
	
	public List<Nerc> getNercList() {

		String sql = "SELECT id, value FROM nerc";
		List<Nerc> nercList = new ArrayList<>();

		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			ResultSet res = st.executeQuery();

			while (res.next()) {
				Nerc n = new Nerc(res.getInt("id"), res.getString("value"));
				nercList.add(n);
			}

			conn.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return nercList;
	}
	
	
	public List<ProveOutages> getAllProve(){
		String sql = "SELECT id, customers_affected, date_event_finished, date_event_began "
				+ "FROM poweroutages";
		List<ProveOutages> listaprove = new ArrayList<>();
		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			ResultSet res = st.executeQuery();

			while (res.next()) {
				LocalDateTime datain = res.getTimestamp("date_event_began").toLocalDateTime();
				LocalDateTime datafin = res.getTimestamp("date_event_finished").toLocalDateTime();
				
				ProveOutages po = new ProveOutages(res.getInt("id"), res.getInt("customers_affected"), datain, datafin);
				
				listaprove.add(po);
			}

			conn.close();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return listaprove;

	}

}
