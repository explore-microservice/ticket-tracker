package com.issuetracker.webapp.pojo;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Optional;

import static com.issuetracker.webapp.pojo.utils.ColumnUtils.PROJECT_CREATIONDATE;
import static com.issuetracker.webapp.pojo.utils.ColumnUtils.PROJECT_DESCRIPTION;
import static com.issuetracker.webapp.pojo.utils.ColumnUtils.PROJECT_ENDDATE;
import static com.issuetracker.webapp.pojo.utils.ColumnUtils.PROJECT_ID;
import static com.issuetracker.webapp.pojo.utils.ColumnUtils.PROJECT_NAME;
import static com.issuetracker.webapp.pojo.utils.ColumnUtils.PROJECT_STARTDATE;

public class ProjectRowMapper implements RowMapper<Project> {

    @Override
    public Project mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        return Project.builder()
                .id(resultSet.getLong(PROJECT_ID))
                .name(resultSet.getString(PROJECT_NAME))
                .description(resultSet.getString(PROJECT_DESCRIPTION))
                .creationDate(resultSet.getTimestamp(PROJECT_CREATIONDATE).toLocalDateTime())
                .startDate(Optional.ofNullable(resultSet.getTimestamp(PROJECT_STARTDATE))
                        .map(Timestamp::toLocalDateTime).orElse(null))
                .endDate(Optional.ofNullable(resultSet.getTimestamp(PROJECT_ENDDATE))
                        .map(Timestamp::toLocalDateTime).orElse(null))
                .build();
    }
}
