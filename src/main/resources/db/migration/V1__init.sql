CREATE TABLE clients
(
    id   INTEGER      NOT NULL PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(256) NOT NULL
);

CREATE TABLE applications
(
    id           INTEGER      NOT NULL PRIMARY KEY AUTO_INCREMENT,
    client_id    INTEGER      NOT NULL,
    created      TIMESTAMP(6) NOT NULL DEFAULT CURRENT_TIMESTAMP,
    product_name VARCHAR(256) NOT NULL
);

/* TEST DATA */
INSERT INTO clients (name)
VALUES ('Иванов'),
       ('Петров'),
       ('Сидоров');

INSERT INTO applications (client_id, product_name)
VALUES (1, 'MORTGAGE');

INSERT INTO applications (client_id, product_name)
VALUES (2, 'LOAN');

INSERT INTO applications (client_id, product_name)
VALUES (3, 'REFINANCING');


INSERT INTO applications (client_id, product_name, created)
VALUES (1, 'LOAN', TIMESTAMPADD('minute', -1, CURRENT_TIMESTAMP()));
INSERT INTO applications (client_id, product_name, created)
VALUES (1, 'REFINANCING', TIMESTAMPADD('minute', -2, CURRENT_TIMESTAMP()));

INSERT INTO applications (client_id, product_name, created)
VALUES (2, 'MORTGAGE', TIMESTAMPADD('minute', -1, CURRENT_TIMESTAMP()));
INSERT INTO applications (client_id, product_name, created)
VALUES (2, 'REFINANCING', TIMESTAMPADD('minute', -2, CURRENT_TIMESTAMP()));

INSERT INTO applications (client_id, product_name, created)
VALUES (3, 'MORTGAGE', TIMESTAMPADD('minute', -1, CURRENT_TIMESTAMP()));
INSERT INTO applications (client_id, product_name, created)
VALUES (3, 'LOAN', TIMESTAMPADD('minute', -2, CURRENT_TIMESTAMP()));



