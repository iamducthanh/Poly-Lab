package com.edusys.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.edusys.helper.JDBCHelper;
import com.edusys.mapper.RowMapper;

public class AbstractDao {
	public <T> ArrayList<T> fillAll(String sql, RowMapper<T> rowMapper, Object... parameters) {
		try {
			ArrayList<T> result = new ArrayList<>();
			Connection conn = JDBCHelper.connect();
			PreparedStatement ps = conn.prepareStatement(sql);
			if(parameters != null) {
				setPreparedStatement(ps, parameters);
			}
			ResultSet resultSet = ps.executeQuery();
			while(resultSet.next()) {
				result.add(rowMapper.mapRow(resultSet));
			}
			return result;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public static void setPreparedStatement(PreparedStatement ps, Object... parameters) {
		for(int i=0;i< parameters.length;i++) {
			try {
				ps.setString(i+1, (String) parameters[i]);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void executeQuery(String sql, Object... parameters) {
		Connection conn = JDBCHelper.connect();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			if(parameters != null) {
				setPreparedStatement(ps, parameters);
			}
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static ResultSet fill(String sql, Object... parameters) {
		Connection conn = JDBCHelper.connect();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			if(parameters != null) {
				setPreparedStatement(ps, parameters);
			}
			ResultSet resultSet = ps.executeQuery();
			return resultSet;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}
