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
                .creationDate(resultSet.getTimestamp("creationDate").toLocalDateTime())
                .startDate(Optional.ofNullable(resultSet.getTimestamp("startDate"))
                        .map(Timestamp::toLocalDateTime).orElse(null))
                .endDate(Optional.ofNullable(resultSet.getTimestamp("endDate"))
                        .map(Timestamp::toLocalDateTime).orElse(null))
                .build();
    }
}
