DELETE FROM statuses;

INSERT INTO statuses (status_id, name)
VALUES (1, 'STARTED_MAKING'),
       (2, 'WAITING_FOR_DELIVERYMAN'),
       (3, 'TO_RESTAURANT'),
       (4, 'GET_THE_ORDER'),
       (5, 'ON_THE_WAY_TO_CUSTOMER'),
       (6, 'WAITING_FOR_CUSTOMER'),
       (7, 'READY');