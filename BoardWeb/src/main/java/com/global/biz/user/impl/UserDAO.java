package com.global.biz.user.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.springframework.stereotype.Repository;

import com.global.biz.common.JDBCUtil;
import com.global.biz.user.UserVO;

@Repository("userDAO")
public class UserDAO {
	
	// jdbc ���ú���
	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	
	// SQL ���
	private final String USER_GET = "select * from users where id=? and password=?";
	
	// CRUD �޼ҵ� ����
	public UserVO getUser(UserVO vo) {
		
		UserVO user = null;
		
		try {
			
			System.out.println("====> JDBC�� getUser() ��� ó��....");
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(USER_GET);
			stmt.setString(1, vo.getId());
			stmt.setString(2, vo.getPassword());
			rs = stmt.executeQuery();
			
			if(rs.next()) {
				user = new UserVO();
				user.setId(rs.getString("id"));
				user.setPassword(rs.getString("password"));
				user.setName(rs.getString("name"));
				user.setRole(rs.getString("role"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		
		return user;
	}
	
}
