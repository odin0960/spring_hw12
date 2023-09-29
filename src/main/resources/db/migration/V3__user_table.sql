create TABLE IF NOT EXISTS users (
	id BIGINT PRIMARY KEY AUTO_INCREMENT,
	username VARCHAR (20) NOT NULL UNIQUE CHECK (CHAR_LENGTH(username) >= 3),
	password VARCHAR (200) NOT NULL CHECK (CHAR_LENGTH(password) >= 8),
	role VARCHAR (20) NOT NULL
);

INSERT INTO users (username, password, role)
VALUES
	('user',
	'$2a$12$iLJwc3vDlHxZQlTHVhLO/Odiov0m2KvRTGaIbciDXdb6C61fqkjh6', --jdbcDefault
	'ADMIN');