# 데이터베이스 생성
CREATE DATABASE dangol default CHARACTER SET UTF8;

CREATE USER 'dangol'@'localhost' IDENTIFIED BY 'dangol1234';
CREATE USER 'dangol'@'%' IDENTIFIED BY 'dangol1234';
GRANT ALL PRIVILEGES ON dangol.* TO 'dangol'@'%';
FLUSH PRIVILEGES;