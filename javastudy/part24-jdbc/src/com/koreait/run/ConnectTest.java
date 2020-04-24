package com.koreait.run;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.koreait.connect.DBConnect;

public class ConnectTest {
	public static void main(String[] args) {
		DBConnect connect = new DBConnect();
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			 conn = connect.getConnection();
			String sql = "DELETE FROM JOB";
			ps = conn.prepareStatement(sql);
			int result = ps.executeUpdate();
			System.out.println(result);
		
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (ps != null) {
					ps.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
			}
		}
	}
}
