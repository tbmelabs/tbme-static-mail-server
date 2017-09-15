CREATE DATABASE tbmemail;
USE tbmemail;

-- Please change the password in your productive environment!
CREATE USER 'tbmemail_flyway'@'localhost' IDENTIFIED BY 'flyway';
GRANT ALL ON * . * TO 'tbmemail_flyway'@'localhost';

-- Please change the password in your productive environment!
CREATE USER 'tbmemail_hibernate'@'localhost' IDENTIFIED BY 'hibernate';
GRANT SELECT, INSERT, UPDATE, DELETE ON * . * TO 'tbmemail_hibernate'@'localhost';