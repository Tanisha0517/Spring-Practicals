package com.rays.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.rays.dto.UserDTO;

public class UserMapper implements RowMapper<UserDTO> {

	@Override
	public UserDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		UserDTO dto = new UserDTO();
		dto.setId(rs.getInt("id")); //1
		dto.setFirstName(rs.getString("first_name")); //2
		dto.setLastName(rs.getString("last_name")); //3
		dto.setLogin(rs.getString("login")); //4
		dto.setPassword(rs.getString("password")); //5
		return dto;
	}

}
