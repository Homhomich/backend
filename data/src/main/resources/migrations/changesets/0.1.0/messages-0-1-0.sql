CREATE TABLE messages (
    message_id SERIAL PRIMARY KEY,
    creation_time TIMESTAMP NOT NULL,
    text VARCHAR(1000),
    sender_id INTEGER NOT NULL,
    recipient_id INTEGER NOT NULL,
    is_read BOOLEAN NOT NULL,
    CONSTRAINT message_sender_fk FOREIGN KEY (sender_id) REFERENCES users (user_id)
        ON UPDATE CASCADE
        ON DELETE CASCADE,
    CONSTRAINT message_recipient_fk FOREIGN KEY (recipient_id) REFERENCES users (user_id)
        ON UPDATE CASCADE
        ON DELETE CASCADE
);