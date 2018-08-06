package com.issuetracker.webapp.pojo;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Optional;

public class UserResultSetExtractor implements ResultSetExtractor<Collection<UserWithProjects>> {

    @Override
    public Collection<UserWithProjects> extractData(ResultSet rs) throws SQLException, DataAccessException {
        HashMap<Long, UserWithProjects> users = new HashMap<>();

        while(rs.next()){
            Long userKey = rs.getLong("userid");

            if(!users.containsKey(userKey)){
                users.put(userKey, UserWithProjects.builder()
                        .user(User.builder()
                                .id(userKey)
                                .firstName(rs.getString("firstName"))
                                .lastName(rs.getString("lastName"))
                                .username(rs.getString("username"))
                                .email(rs.getString("email"))
                                .password(rs.getString("password"))
                                .lastLoggedIn(Optional.ofNullable(rs.getTimestamp("lastLoggedIn"))
                                        .map(Timestamp::toLocalDateTime).orElse(null))
                                .build())
                        .projects(new HashSet<>())
                .build());
            }

            users.get(userKey).addProject(
                    Project.builder()
                            .id(rs.getLong("projectid"))
                            .name(rs.getString("name"))
                            .description(rs.getString("description"))
                            .creationDate(rs.getTimestamp("creationDate").toLocalDateTime())
                            .startDate(Optional.ofNullable(rs.getTimestamp("startDate"))
                                    .map(Timestamp::toLocalDateTime).orElse(null))
                            .endDate(Optional.ofNullable(rs.getTimestamp("endDate"))
                                    .map(Timestamp::toLocalDateTime).orElse(null))
                            .build()
            );
        }
        return users.values();
    }
}
