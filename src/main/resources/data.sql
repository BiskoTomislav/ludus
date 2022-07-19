INSERT INTO ROLES(name) VALUES('CREATOR');
INSERT INTO ROLES(name) VALUES('SUPERVISOR');
INSERT INTO ROLES(name) VALUES('PLAYER');
INSERT INTO ROLES(name) VALUES('VIP_PLAYER');
INSERT INTO ROLES(name) VALUES('ADMIN');

INSERT INTO USERS(username, password) VALUES('CreatorOne', 'CreatorOne');
INSERT INTO USERS(username, password) VALUES('PlayerOne', 'PlayerOne');
INSERT INTO USERS(username, password) VALUES('SupervisorOne', 'SupervisorOne');
INSERT INTO USERS(username, password) VALUES('VipPlayerOne', 'VipPlayerOne');
INSERT INTO USERS(username, password) VALUES('Admin', 'Admin');

INSERT INTO USER_ROLES(user_id, role_id) VALUES (1, 1);
INSERT INTO USER_ROLES(user_id, role_id) VALUES (2, 2);
INSERT INTO USER_ROLES(user_id, role_id) VALUES (3, 3);
INSERT INTO USER_ROLES(user_id, role_id) VALUES (4, 4);
INSERT INTO USER_ROLES(user_id, role_id) VALUES (5, 5);
