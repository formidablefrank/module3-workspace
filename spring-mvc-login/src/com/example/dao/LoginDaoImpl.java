package com.example.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.model.User;

@Repository("dao")
public class LoginDaoImpl implements LoginDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public boolean isValid(User user) {
		return getUser(user.getUsername(), user.getPassword()) != null;
	}
	
	public User getUser(String username, String password){
		String sql = "SELECT fld_username, fld_password FROM tbl_user WHERE fld_username=? AND fld_password=?;";
		List matches = jdbcTemplate.query(sql, new Object[] {username, password},
			new RowMapper(){
				public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
					User user = new User(rs.getString(1), rs.getString(2));
					return user;
				}
			}
		);
		return (matches.size() > 0 ? (User) matches.get(0) : null);
	}

}
