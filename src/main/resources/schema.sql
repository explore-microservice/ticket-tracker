CREATE TABLE it_user (id int NOT NULL, firstname varchar(50) NOT NULL, lastname varchar(50) NOT NULL, username varchar(20) NOT NULL, password varchar(255) NOT NULL, lastloggedin timestamp, PRIMARY KEY (id));
CREATE TABLE it_project (id int NOT NULL, name varchar(255) NOT NULL, description varchar(255), creationdate timestamp NOT NULL, startdate timestamp, enddate timestamp, PRIMARY KEY (id));
CREATE TABLE it_userworksonproject (userid int NOT NULL, projectid int NOT NULL, PRIMARY KEY (userid, projectid));
CREATE TABLE it_issue (id int NOT NULL, name varchar(255) NOT NULL, description varchar(255), creationdate timestamp NOT NULL, sprintid int, creatoruserid int NOT NULL, assigneeuserid int NOT NULL, PRIMARY KEY (id));
CREATE TABLE it_sprint (id int NOT NULL, name varchar(255) NOT NULL, description varchar(255), creationdate timestamp NOT NULL, startdate timestamp, enddate timestamp, projectid int NOT NULL, PRIMARY KEY (id));
CREATE TABLE it_comment (id int NOT NULL, content varchar(255) NOT NULL, creationdate timestamp NOT NULL, userid int NOT NULL, issueid int NOT NULL, PRIMARY KEY (id));
ALTER TABLE it_userworksonproject ADD CONSTRAINT FKit_userwor916148 FOREIGN KEY (projectid) REFERENCES it_project (id);
ALTER TABLE it_userworksonproject ADD CONSTRAINT FKit_userwor264313 FOREIGN KEY (userid) REFERENCES it_user (id);
ALTER TABLE it_issue ADD CONSTRAINT creator FOREIGN KEY (creatoruserid) REFERENCES it_user (id);
ALTER TABLE it_sprint ADD CONSTRAINT FKit_sprint113670 FOREIGN KEY (projectid) REFERENCES it_project (id);
ALTER TABLE it_issue ADD CONSTRAINT FKit_issue163506 FOREIGN KEY (sprintid) REFERENCES it_sprint (id);
ALTER TABLE it_comment ADD CONSTRAINT FKit_comment150761 FOREIGN KEY (userid) REFERENCES it_user (id);
ALTER TABLE it_comment ADD CONSTRAINT FKit_comment978564 FOREIGN KEY (issueid) REFERENCES it_issue (id);
ALTER TABLE it_issue ADD CONSTRAINT assignee FOREIGN KEY (assigneeuserid) REFERENCES it_user (id);