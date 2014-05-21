package com.example.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class MessageDaoImpl implements MessageDao {
	private JdbcTemplate jdbcTemplate;
	private String message;

	public String getMessage() {
		String sql = "SELECT fld_password FROM tbl_user WHERE fld_username=? ;";
		List matches = jdbcTemplate.query(sql, new Object[] {"admin"},
			new RowMapper(){
				public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
					String sample = null;
					sample = rs.getString(1);
					return sample;
				}
			}
		);
		return (matches.size() > 0 ? matches.get(0).toString() : null);
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}


}
