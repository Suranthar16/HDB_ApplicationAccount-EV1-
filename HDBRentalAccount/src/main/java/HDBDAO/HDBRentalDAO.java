package HDBDAO;

import HDBDTO.HDBRentalDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import HDBDB.HDBRentalDB;

public class HDBRentalDAO {

	public boolean create(HDBRentalDTO dto) {

		System.out.println("In to DAO");

		HDBRentalDB db = new HDBRentalDB();
		Connection conn = db.getConnection();
		boolean result1 = false;

		String sql = "INSERT INTO test1.rentalaccount(Applicant_name,Applicant_NRIC,Applicant_DOB,Applicant_Flat_Choice,Applicant_Zone)VALUES(?,?,?,?,?);";
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, dto.getName());
			ps.setString(2, dto.getNRIC());
			ps.setString(3, dto.getDOB());
			ps.setString(4, dto.getChoice());
			ps.setString(5, dto.getZone());

			double result = 0;
			result = ps.executeUpdate();
			System.out.println(result);
			if (result > 0) {
				result1 = true;
				System.out.println("insert success!");
			}
		}  catch (SQLException e) {

			System.out.println(e);
		} catch (Exception e) {

			System.out.println(e);
		} finally {
			if (conn != null) {
				try {
					ps.close();
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return result1;
	}

	public ArrayList<HDBRentalDTO> Applicantinfo() {

		HDBRentalDB db = new HDBRentalDB();
		Connection conn = db.getConnection();

		ArrayList<HDBRentalDTO> Applicantlist = new ArrayList<HDBRentalDTO>();
		System.out.println(conn);
		ResultSet rs = null;
		PreparedStatement ps = null;

		String sql = "select * from test1.rentalaccount;";

		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			System.out.println(rs);

			while (rs.next()) {

				HDBRentalDTO dto1 = new HDBRentalDTO();
				String ID = rs.getString("Applicant_id");
				System.out.println("ID-->" + ID);
				dto1.setID(ID);

				String Name = rs.getString("Applicant_name");
				System.out.println("Name---->" + Name);
				dto1.setName(Name);

				String NRIC = rs.getString("Applicant_NRIC");
				System.out.println("NRIC---->" + NRIC);
				dto1.setNRIC(NRIC);

				String DOB = rs.getString("Applicant_DOB");
				System.out.println("DOB---->" + DOB);
				dto1.setDOB(DOB);

				String Choice = rs.getString("Applicant_Flat_Choice");
				System.out.println("Choice---->" + Choice);
				dto1.setChoice(Choice);

				String Zone = rs.getString("Applicant_Zone");
				System.out.println("Zone---->" + Zone);
				dto1.setZone(Zone);

				Applicantlist.add(dto1);
			}

		}  catch (SQLException e) {

			System.out.println(e);
		} catch (Exception e) {

			System.out.println(e);
		} finally {
			if (conn != null) {
				try {
					ps.close();
					rs.close();
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		return Applicantlist;
	}

	public ArrayList<HDBRentalDTO> Specificinfo(String userID) {

		HDBRentalDB db = new HDBRentalDB();
		Connection conn = db.getConnection();

		ArrayList<HDBRentalDTO> Specificlist = new ArrayList<HDBRentalDTO>();
		System.out.println(conn);
		ResultSet rs = null;
		PreparedStatement ps = null;

		String sql = "select * from test1.rentalaccount WHERE Applicant_id=?;";

		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, userID);
			rs = ps.executeQuery();
			System.out.println(rs);

			while (rs.next()) {

				HDBRentalDTO dto1 = new HDBRentalDTO();
				String ID = rs.getString("Applicant_id");
				System.out.println("ID-->" + ID);
				dto1.setID(ID);

				String Name = rs.getString("Applicant_name");
				System.out.println("Name---->" + Name);
				dto1.setName(Name);

				String NRIC = rs.getString("Applicant_NRIC");
				System.out.println("NRIC---->" + NRIC);
				dto1.setNRIC(NRIC);

				String DOB = rs.getString("Applicant_DOB");
				System.out.println("DOB---->" + DOB);
				dto1.setDOB(DOB);

				String Choice = rs.getString("Applicant_Flat_Choice");
				System.out.println("Choice---->" + Choice);
				dto1.setChoice(Choice);

				String Zone = rs.getString("Applicant_Zone");
				System.out.println("Zone---->" + Zone);
				dto1.setZone(Zone);

				Specificlist.add(dto1);
			}

		}  catch (SQLException e) {

			System.out.println(e);
		} catch (Exception e) {

			System.out.println(e);
		} finally {
			if (conn != null) {
				try {
					ps.close();
					rs.close();
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		return Specificlist;
	}

	public boolean updateaccount(String id, String Zone) {

		HDBRentalDB db = new HDBRentalDB();
		Connection conn = db.getConnection();
		boolean result1 = false;

		String sql = "UPDATE test1.rentalaccount SET Applicant_Zone=? WHERE Applicant_id=?;";
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, Zone);
			ps.setString(2, id);

			double result = 0;
			result = ps.executeUpdate();
			System.out.println(result);
			if (result > 0) {
				result1 = true;
				System.out.println("insert success!");
			}
		}  catch (SQLException e) {

			System.out.println(e);
		} catch (Exception e) {

			System.out.println(e);
		} finally {
			if (conn != null) {
				try {
					ps.close();
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		return result1;
	}

	public boolean deleteaccount(String Id) {

		HDBRentalDB db = new HDBRentalDB();
		Connection conn = db.getConnection();
		boolean result1 = false;

		String sql = "Delete From test1.rentalaccount Where Applicant_id=?";
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, Id);

			double result = 0;
			result = ps.executeUpdate();
			System.out.println(result);
			if (result > 0) {
				result1 = true;
				System.out.println("Delete success!");
			}
		}  catch (SQLException e) {

			System.out.println(e);
		} catch (Exception e) {

			System.out.println(e);
		} finally {
			if (conn != null) {
				try {
					ps.close();
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		System.out.println(conn);
		return result1;
	}

}
