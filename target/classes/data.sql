
--Таблица Подьзователи (Сотрудники)
DROP TABLE IF EXISTS user;

CREATE TABLE user (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  first_name VARCHAR(50) NOT NULL,
  last_name VARCHAR(50) NOT NULL,
  role_id INT DEFAULT NULL,
  foreign key (role_id) references role(id)
);

--Таблица Роли
DROP TABLE IF EXISTS role;

CREATE TABLE role(
  id INT AUTO_INCREMENT  PRIMARY KEY,
  role_name VARCHAR(50) NOT NULL,
);

--Таблица Группы
DROP TABLE IF EXISTS groups;

CREATE TABLE groups(
  id INT AUTO_INCREMENT  PRIMARY KEY,
  group_name VARCHAR(50) NOT NULL,
);

--Таблица связи Пользоватедь - Группа
DROP TABLE IF EXISTS user_group;

CREATE TABLE user_group(
  id INT AUTO_INCREMENT  PRIMARY KEY,
  group_id INT NOT NULL,
  user_id INT NOT NULL,
  foreign key (group_id) references groups(id),
  foreign key (user_id) references user(id)
);
