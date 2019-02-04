package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bean.Hotel;
import com.exception.DatabaseException;

import dbUtility.DBStore;

public class HotelDao {

	public static int insertHotel(Hotel h) throws DatabaseException {

		int ret = 0;
		String insertIntoHotel = "INSERT INTO Hotal(hotelNum,name, city, location, rating, price,checkin, checkout) "
				+ "VALUES (?,?,?,?,?,?,?,?);";
		try (Connection conn = DBStore.getDataSource().getConnection();
				PreparedStatement pst = conn.prepareStatement(insertIntoHotel);) {

			pst.setInt(1, h.getHotelNum());
			pst.setString(2, h.getName());
			pst.setString(3, h.getCity());
			pst.setString(4, h.getLocation());
			pst.setString(5, h.getRating());
			pst.setDouble(6, h.getPrice());
			pst.setDate(7, h.getCheckin());
			pst.setDate(8, h.getCheckout());
			ret = pst.executeUpdate();
			System.out.println("commit");
			pst.close();
			conn.commit();
			return ret;
		} catch (SQLException e) {
			throw new DatabaseException("Saving Hotel information failed for " + h + " ; " + e.getMessage());
		}
	}

	public static Hotel getHotel(int id) throws DatabaseException {
		ResultSet rs;

		Hotel hotel = null;
		String selectHotel = "SELECT * FROM Hotel WHERE hotelNum=?";
		try (Connection conn = DBStore.getDataSource().getConnection();
				PreparedStatement pst = conn.prepareStatement(selectHotel);) {
			pst.setInt(1, id);
			rs = pst.executeQuery();

			if (rs.next()) {
				int hNum = rs.getInt("hotelId");
				String name = rs.getString("Name");
				String city = rs.getString("city");
				String location = rs.getString("location");
				String rating = rs.getString("rating");
				double price = rs.getDouble("price");
				Date checkin = rs.getDate("checkin");
				Date checkout = rs.getDate("checkout");
				hotel = new Hotel(hNum, name, city, location, rating, price, checkin, checkout);
			}
			rs.close();
			return hotel;
		} catch (

		SQLException e) {
			throw new DatabaseException("Fetch hotel info failed for " + id + " ; " + e.getMessage());
		}
	}
	
	
	public static List<Hotel> getHotel(String c, Date cin, Date cout) throws DatabaseException {
		ResultSet rs;

		List<Hotel> hotels = new ArrayList<>();
		Hotel hotel = null;
		String selectHotel = "SELECT * FROM Hotel WHERE city=? AND checkin=? AND checkout =?";
		try (Connection conn = DBStore.getDataSource().getConnection();
				PreparedStatement pst = conn.prepareStatement(selectHotel);) {
			pst.setString(1, c);
			pst.setDate(2, cin);
			pst.setDate(3, cout);
			rs = pst.executeQuery();

			if (rs.next()) {
				int hNum = rs.getInt("hotelNum");
				String name = rs.getString("Name");
				String city = rs.getString("city");
				String location = rs.getString("location");
				String rating = rs.getString("rating");
				double price = rs.getDouble("price");
				Date checkin = rs.getDate("checkin");
				Date checkout = rs.getDate("checkout");
				hotel = new Hotel(hNum, name, city, location, rating, price, checkin, checkout);
				hotels.add(hotel);
			}
			rs.close();
			return hotels;
		} catch (

		SQLException e) {
			throw new DatabaseException("Fetch hotal info failed for " + c + " ; " + e.getMessage());
		}
	}
	

	public static int updateHotel(Hotel h) throws DatabaseException {
		int ret = 0;
		String updateHotel = "UPDATE hotel SET name=?,city=?,location=?,rating=?,price=?,checkin=?,checkout=? WHERE hotelNum=?";

		try (Connection conn = DBStore.getDataSource().getConnection();
				PreparedStatement pst = conn.prepareStatement(updateHotel);) {

			pst.setString(1, h.getName());
			pst.setString(2, h.getCity());
			pst.setString(3, h.getLocation());
			pst.setString(4, h.getRating());
			pst.setDouble(5, h.getPrice());
			pst.setDate(6, h.getCheckin());
			pst.setDate(7, h.getCheckout());
			ret = pst.executeUpdate();
			conn.commit();

			return ret;
		} catch (

		SQLException e) {
			throw new DatabaseException("Update hotel failed for " + h + " ; " + e.getMessage());
		}
	}
}
