CREATE TABLE api_key (
	id BIGINT PRIMARY KEY AUTO_INCREMENT NOT NULL,
	created DATETIME NOT NULL,
	last_updated DATETIME NOT NULL,
	api_key CHAR(36) UNIQUE NOT NULL
);