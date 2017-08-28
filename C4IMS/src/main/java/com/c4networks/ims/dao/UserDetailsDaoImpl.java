package com.c4networks.ims.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.c4networks.ims.model.UserDetailsBean;

@Repository
public class UserDetailsDaoImpl implements UserDetailsDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public Integer registerNewUser(Integer seqId, UserDetailsBean userBean) {
		Connection con;
		PreparedStatement pstmt;
		Integer result = 0;
		try {
			con = jdbcTemplate.getDataSource().getConnection();
			pstmt = con.prepareStatement("insert into CUSTOMER_DETAILS set values (?,?,?,?,?,?,?,?,?,?,?,?,?)");
			pstmt.setInt(0, seqId);
			pstmt.setString(1, "VRMS0000" + seqId);
			pstmt.setString(2, userBean.getFirstName());
			pstmt.setString(3, userBean.getLastName());
			pstmt.setString(4, userBean.getEmail());
			pstmt.setString(5, userBean.getStatus());
			pstmt.setString(6, userBean.getAddress());
			pstmt.setString(7, userBean.getPhone());
			pstmt.setString(8, userBean.getMobile());
			pstmt.setInt(9, userBean.getCreatedBy());
			pstmt.setDate(10, new java.sql.Date(new Date().getTime()));
			pstmt.setInt(11, userBean.getLastModifiedBy());
			pstmt.setDate(12, new java.sql.Date(userBean.getLastModifiedDate().getTime()));
			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// TODO Auto-generated method stub
		return result;
	}

	@Override
	public Integer processUserLogin(String userName, String password) {
		Connection con;
		PreparedStatement pstmt;
		Integer result = 0;
		try {
			con = jdbcTemplate.getDataSource().getConnection();
			pstmt = con.prepareStatement("select * from CUSTOMER_DETAILS where email = ?");
			pstmt.setString(1, userName);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				rs.getString("email");
				if (password.equals("chinni")) {
					result = 1;
				} else {
					result = 2;
				}
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;
	}

	public Integer getNextValueFromCustDetails() {
		Connection con;
		Integer result = 0;
		try {
			con = jdbcTemplate.getDataSource().getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select customer_details_seq.nextval from dual");
			while (rs.next()) {
				result = rs.getInt(0);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

}
