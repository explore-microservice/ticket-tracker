package com.issuetracker.webapp.pojo;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Optional;

public class UserRowMapper implements RowMapper<User> {

    @Override
    public User mapRow(ResultSet resultSet, int i) throws SQLException {
        return User.builder()
                .id(resultSet.getLong("id"))
                .firstname(resultSet.getString("firstname"))
                .lastname(resultSet.getString("lastname"))
                .username(resultSet.getString("username"))
                .email(resultSet.getString("email"))
                .password(resultSet.getString("password"))
                .lastLoggedIn(Optional.ofNullable(resultSet.getTimestamp("lastloggedin")).map(Timestamp::toLocalDateTime).orElse(null))
                .build();
    }
}
