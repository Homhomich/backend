INSERT INTO roles (role_id, name)
VALUES (3, 'DELIVERY');

INSERT INTO permissions VALUES
(5, 'GET_ORDERS'),
(6, 'CREATE_ORDERS'),
(7, 'DELETE_ORDERS'),
(8, 'UPDATE_ORDERS');


INSERT INTO role_permissions (role_id, permission_id) VALUES
(1, 5),
(1, 6),
(1, 7),
(1, 8),
(2, 6),
(2, 8),
(3, 1),
(3, 5),
(3, 8);
