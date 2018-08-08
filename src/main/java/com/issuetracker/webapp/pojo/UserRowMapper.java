package com.issuetracker.webapp.pojo;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Optional;

import static com.issuetracker.webapp.pojo.utils.ColumnUtils.USER_EMAIL;
import static com.issuetracker.webapp.pojo.utils.ColumnUtils.USER_FIRSTNAME;
import static com.issuetracker.webapp.pojo.utils.ColumnUtils.USER_ID;
import static com.issuetracker.webapp.pojo.utils.ColumnUtils.USER_LASTLOGGEDIN;
import static com.issuetracker.webapp.pojo.utils.ColumnUtils.USER_LASTNAME;
import static com.issuetracker.webapp.pojo.utils.ColumnUtils.USER_PASSWORD;
import static com.issuetracker.webapp.pojo.utils.ColumnUtils.USER_USERNAME;

public class UserRowMapper implements RowMapper<User> {

    @Override
    public User mapRow(ResultSet resultSet, int i) throws SQLException {
        return User.builder()
                .id(resultSet.getLong(USER_ID))
                .firstName(resultSet.getString(USER_FIRSTNAME))
                .lastName(resultSet.getString(USER_LASTNAME))
                .username(resultSet.getString(USER_USERNAME))
                .email(resultSet.getString(USER_EMAIL))
                .password(resultSet.getString(USER_PASSWORD))
                .lastLoggedIn(Optional.ofNullable(resultSet.getTimestamp(USER_LASTLOGGEDIN)).map(Timestamp::toLocalDateTime).orElse(null))
                .build();
    }
}
