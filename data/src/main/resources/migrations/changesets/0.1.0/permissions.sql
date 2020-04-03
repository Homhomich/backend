CREATE TABLE permissions(
permission_id INT PRIMARY KEY,
name VARCHAR(30)
);

CREATE TABLE role_permissions(
role_id INT NOT NULL,
permission_id INT NOT NULL,
PRIMARY KEY  (role_id, permission_id),
CONSTRAINT role_permissions_role_id_fk FOREIGN KEY (role_id) REFERENCES  roles(role_id) ON DELETE CASCADE,
CONSTRAINT role_permissions_perm_id_fk FOREIGN KEY (permission_id) REFERENCES  permissions(permission_id) ON DELETE CASCADE
);

INSERT INTO permissions VALUES
(1, 'GET_USERS'),
(2, 'CREATE_USERS'),
(3, 'DELETE_USERS'),
(4, 'UPDATE_USERS');

INSERT INTO role_permissions (role_id, permission_id) VALUES
(1, 1),
(1, 2),
(1, 3),
(1, 4),
(2, 1);
