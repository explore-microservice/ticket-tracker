CREATE TABLE it_userworksonproject (id bigint GENERATED BY DEFAULT AS IDENTITY, userid bigint NOT NULL, projectid bigint NOT NULL, PRIMARY KEY (id));
CREATE TABLE it_ticket (id bigint NOT NULL, name varchar(255) NOT NULL, description varchar(255), creationdate timestamp NOT NULL, sprintid bigint, creatoruserid bigint NOT NULL, assigneeuserid bigint NOT NULL, PRIMARY KEY (id));
CREATE TABLE it_sprint (id bigint NOT NULL, name varchar(255) NOT NULL, description varchar(255), creationdate timestamp NOT NULL, startdate timestamp, enddate timestamp, projectid bigint NOT NULL, PRIMARY KEY (id));
CREATE TABLE it_comment (id bigint NOT NULL, content varchar(255) NOT NULL, creationdate timestamp NOT NULL, userid bigint NOT NULL, ticketid bigint NOT NULL, PRIMARY KEY (id));
CREATE TABLE it_user (id bigint NOT NULL, firstname varchar(50) NOT NULL, lastname varchar(50) NOT NULL, username varchar(20) NOT NULL UNIQUE, email varchar(255) NOT NULL UNIQUE, password varchar(255) NOT NULL, lastloggedin timestamp, PRIMARY KEY (id));
CREATE TABLE it_project (id bigint NOT NULL, name varchar(255) NOT NULL, description varchar(255), creationdate timestamp NOT NULL, startdate timestamp, enddate timestamp, PRIMARY KEY (id));
ALTER TABLE it_works ADD CONSTRAINT FKit_userwor916148 FOREIGN KEY (projectid) REFERENCES it_project (id);
ALTER TABLE it_works ADD CONSTRAINT FKit_userwor264313 FOREIGN KEY (userid) REFERENCES it_user (id);
ALTER TABLE it_ticket ADD CONSTRAINT creator FOREIGN KEY (creatoruserid) REFERENCES it_user (id);
ALTER TABLE it_sprint ADD CONSTRAINT FKit_sprint113670 FOREIGN KEY (projectid) REFERENCES it_project (id);
ALTER TABLE it_ticket ADD CONSTRAINT FKit_ticket163506 FOREIGN KEY (sprintid) REFERENCES it_sprint (id);
ALTER TABLE it_comment ADD CONSTRAINT FKit_comment150761 FOREIGN KEY (userid) REFERENCES it_user (id);
ALTER TABLE it_comment ADD CONSTRAINT FKit_comment978564 FOREIGN KEY (ticketid) REFERENCES it_ticket (id);
ALTER TABLE it_ticket ADD CONSTRAINT assignee FOREIGN KEY (assigneeuserid) REFERENCES it_user (id);