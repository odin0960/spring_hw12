create TABLE note (
	id BIGINT PRIMARY KEY AUTO_INCREMENT,
	title VARCHAR (50) NOT NULL CHECK (CHAR_LENGTH(title) >= 3),
	content VARCHAR (2000) NOT NULL CHECK (CHAR_LENGTH(content) >= 3)
);