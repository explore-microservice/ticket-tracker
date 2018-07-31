package com.issuetracker.webapp.pojo;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Optional;

public class ProjectRowMapper implements RowMapper<Project> {

    @Override
    public Project mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        return Project.builder()
                .id(resultSet.getLong("id"))
                .name(resultSet.getString("name"))
                .description(resultSet.getString("description"))
                .creationdate(Optional.ofNullable(resultSet.getTimestamp("creationdate"))
                        .map(Timestamp::toLocalDateTime).orElse(null))
                .startdate(Optional.ofNullable(resultSet.getTimestamp("startdate"))
                        .map(Timestamp::toLocalDateTime).orElse(null))
                .enddate(Optional.ofNullable(resultSet.getTimestamp("enddate"))
                        .map(Timestamp::toLocalDateTime).orElse(null))
                .build();
    }
}
