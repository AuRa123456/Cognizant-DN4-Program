USE ormlearn;

-- ----------------------------------------
-- COUNTRY TABLE (Hands-on 1)
-- ----------------------------------------
DROP TABLE IF EXISTS country;

CREATE TABLE country (
  co_code CHAR(2) NOT NULL,
  co_name VARCHAR(100),
  PRIMARY KEY (co_code)
);

INSERT INTO country VALUES
('BV', 'Bouvet Island'),
('DJ', 'Djibouti'),
('GP', 'Guadeloupe'),
('GS', 'South Georgia and the South Sandwich Islands'),
('LU', 'Luxembourg'),
('SS', 'South Sudan'),
('TF', 'French Southern Territories'),
('UM', 'United States Minor Outlying Islands'),
('ZA', 'South Africa'),
('ZM', 'Zambia'),
('ZW', 'Zimbabwe');

-- ----------------------------------------
-- STOCK TABLE (Hands-on 2)
-- ----------------------------------------
DROP TABLE IF EXISTS stock;

CREATE TABLE stock (
  st_id INT NOT NULL AUTO_INCREMENT,
  st_code VARCHAR(10),
  st_date DATE,
  st_open DECIMAL(10,2),
  st_close DECIMAL(10,2),
  st_volume BIGINT,
  PRIMARY KEY (st_id)
);

INSERT INTO stock (st_code, st_date, st_open, st_close, st_volume) VALUES
('FB', '2019-09-03', 184.00, 182.39, 9779400),
('FB', '2019-09-04', 184.65, 187.14, 11308000),
('FB', '2019-09-05', 188.53, 190.90, 13876700),
('GOOGL', '2019-04-23', 1256.64, 1270.59, 1593400),
('GOOGL', '2019-04-26', 1273.38, 1277.42, 1361400),
('GOOGL', '2019-10-17', 1251.40, 1252.80, 1047900),
('NFLX', '2018-12-24', 242.00, 233.88, 9547600),
('NFLX', '2018-12-21', 263.83, 246.39, 21397600),
('NFLX', '2018-12-26', 233.92, 253.67, 14402700),
('FB', '2019-01-31', 165.60, 166.69, 77233600),
('FB', '2018-10-31', 155.00, 151.79, 60101300),
('FB', '2018-12-19', 141.21, 133.24, 57404900);

-- ----------------------------------------
-- DEPARTMENT TABLE (Hands-on 3 & 4)
-- ----------------------------------------
DROP TABLE IF EXISTS department;

CREATE TABLE department (
  dp_id INT NOT NULL AUTO_INCREMENT,
  dp_name VARCHAR(100),
  PRIMARY KEY (dp_id)
);

INSERT INTO department (dp_name) VALUES
('HR'),
('Engineering'),
('Finance');

-- ----------------------------------------
-- EMPLOYEE TABLE (Hands-on 3, 4 & 5)
-- ----------------------------------------
DROP TABLE IF EXISTS employee;

CREATE TABLE employee (
  em_id INT NOT NULL AUTO_INCREMENT,
  em_name VARCHAR(100),
  em_salary DOUBLE,
  em_permanent BOOLEAN,
  em_date_of_birth DATE,
  em_dp_id INT,
  PRIMARY KEY (em_id),
  FOREIGN KEY (em_dp_id) REFERENCES department(dp_id)
);

INSERT INTO employee (em_name, em_salary, em_permanent, em_date_of_birth, em_dp_id) VALUES
('John Doe', 60000, TRUE, '1990-05-20', 1),
('Jane Smith', 75000, FALSE, '1992-08-10', 2),
('Mark Taylor', 55000, TRUE, '1988-03-15', 2);

-- ----------------------------------------
-- SKILL TABLE (Hands-on 3 & 6)
-- ----------------------------------------
DROP TABLE IF EXISTS skill;

CREATE TABLE skill (
  sk_id INT NOT NULL AUTO_INCREMENT,
  sk_name VARCHAR(100),
  PRIMARY KEY (sk_id)
);

INSERT INTO skill (sk_name) VALUES
('Java'),
('Spring'),
('SQL'),
('React');

-- ----------------------------------------
-- EMPLOYEE_SKILL TABLE (Many-to-Many)
-- ----------------------------------------
DROP TABLE IF EXISTS employee_skill;

CREATE TABLE employee_skill (
  es_em_id INT,
  es_sk_id INT,
  PRIMARY KEY (es_em_id, es_sk_id),
  FOREIGN KEY (es_em_id) REFERENCES employee(em_id),
  FOREIGN KEY (es_sk_id) REFERENCES skill(sk_id)
);

INSERT INTO employee_skill VALUES
(1, 1),
(1, 2),
(2, 3),
(3, 4);