package com.issuetracker.webapp.pojo;

import com.issuetracker.webapp.pojo.utils.ColumnUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.HashMap;
import java.util.Optional;

import static com.issuetracker.webapp.pojo.utils.ColumnUtils.PROJECT_CREATIONDATE;
import static com.issuetracker.webapp.pojo.utils.ColumnUtils.PROJECT_DESCRIPTION;
import static com.issuetracker.webapp.pojo.utils.ColumnUtils.PROJECT_ENDDATE;
import static com.issuetracker.webapp.pojo.utils.ColumnUtils.PROJECT_ID;
import static com.issuetracker.webapp.pojo.utils.ColumnUtils.PROJECT_NAME;
import static com.issuetracker.webapp.pojo.utils.ColumnUtils.PROJECT_PREFIX;
import static com.issuetracker.webapp.pojo.utils.ColumnUtils.PROJECT_STARTDATE;
import static com.issuetracker.webapp.pojo.utils.ColumnUtils.USER_EMAIL;
import static com.issuetracker.webapp.pojo.utils.ColumnUtils.USER_FIRSTNAME;
import static com.issuetracker.webapp.pojo.utils.ColumnUtils.USER_ID;
import static com.issuetracker.webapp.pojo.utils.ColumnUtils.USER_LASTLOGGEDIN;
import static com.issuetracker.webapp.pojo.utils.ColumnUtils.USER_LASTNAME;
import static com.issuetracker.webapp.pojo.utils.ColumnUtils.USER_PASSWORD;
import static com.issuetracker.webapp.pojo.utils.ColumnUtils.USER_PREFIX;
import static com.issuetracker.webapp.pojo.utils.ColumnUtils.USER_USERNAME;

public class UserResultSetExtractor implements ResultSetExtractor<Collection<UserWithProjects>> {

    @Override
    public Collection<UserWithProjects> extractData(ResultSet rs) throws SQLException, DataAccessException {
        HashMap<Long, UserWithProjects> usersWithRelatedProjects = new HashMap<>();

        while(rs.next()){
            Long userKey = rs.getLong(USER_PREFIX + USER_ID);

            usersWithRelatedProjects.putIfAbsent(userKey, UserWithProjects.builder()
                    .user(User.builder()
                            .id(userKey)
                            .firstName(rs.getString(USER_FIRSTNAME))
                            .lastName(rs.getString(USER_LASTNAME))
                            .username(rs.getString(USER_USERNAME))
                            .email(rs.getString(USER_EMAIL))
                            .password(rs.getString(USER_PASSWORD))
                            .lastLoggedIn(Optional.ofNullable(rs.getTimestamp(USER_LASTLOGGEDIN))
                                    .map(Timestamp::toLocalDateTime).orElse(null))
                            .build())
            .build());

            Project project = Project.builder()
                    .id(rs.getLong(PROJECT_PREFIX + PROJECT_ID))
                    .name(rs.getString(PROJECT_NAME))
                    .description(rs.getString(PROJECT_DESCRIPTION))
                    .creationDate(rs.getTimestamp(PROJECT_CREATIONDATE).toLocalDateTime())
                    .startDate(Optional.ofNullable(rs.getTimestamp(PROJECT_STARTDATE))
                            .map(Timestamp::toLocalDateTime).orElse(null))
                    .endDate(Optional.ofNullable(rs.getTimestamp(PROJECT_ENDDATE))
                            .map(Timestamp::toLocalDateTime).orElse(null))
                    .build();

            usersWithRelatedProjects.computeIfPresent(userKey, (key, value) -> value.toBuilder().project(project).build());
        }
        return usersWithRelatedProjects.values();
    }
}
