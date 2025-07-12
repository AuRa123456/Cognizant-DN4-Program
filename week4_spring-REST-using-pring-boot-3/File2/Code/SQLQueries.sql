USE ormlearn

-- Department Table
CREATE TABLE IF NOT EXISTS department (
    dp_id INT PRIMARY KEY AUTO_INCREMENT,
    dp_name VARCHAR(255)
);

-- Sample Departments
INSERT INTO department (dp_name) VALUES ('Technology');
INSERT INTO department (dp_name) VALUES ('Finance');
INSERT INTO department (dp_name) VALUES ('HR');

-- Skill Table
CREATE TABLE IF NOT EXISTS skill (
    sk_id INT PRIMARY KEY AUTO_INCREMENT,
    sk_name VARCHAR(255)
);

-- Sample Skills
INSERT INTO skill (sk_name) VALUES ('Java');
INSERT INTO skill (sk_name) VALUES ('Spring Boot');
INSERT INTO skill (sk_name) VALUES ('SQL');

-- Employee Table
CREATE TABLE IF NOT EXISTS employee (
    em_id INT PRIMARY KEY AUTO_INCREMENT,
    em_name VARCHAR(255),
    em_salary DOUBLE,
    em_permanent BOOLEAN,
    em_date_of_birth DATE,
    em_dp_id INT,
    FOREIGN KEY (em_dp_id) REFERENCES department(dp_id)
);

-- Sample Employees
INSERT INTO employee (em_name, em_salary, em_permanent, em_date_of_birth, em_dp_id)
VALUES 
('Alice', 55000.00, true, '1990-01-15', 1),
('Bob', 47000.00, false, '1988-07-21', 2),
('Charlie', 62000.00, true, '1992-11-30', 1);

-- Employee-Skill Mapping (Many-to-Many)
CREATE TABLE IF NOT EXISTS employee_skill (
    es_em_id INT,
    es_sk_id INT,
    PRIMARY KEY (es_em_id, es_sk_id),
    FOREIGN KEY (es_em_id) REFERENCES employee(em_id),
    FOREIGN KEY (es_sk_id) REFERENCES skill(sk_id)
);

-- Sample Skill Assignments
INSERT INTO employee_skill (es_em_id, es_sk_id) VALUES (1, 1); -- Alice - Java
INSERT INTO employee_skill (es_em_id, es_sk_id) VALUES (1, 2); -- Alice - Spring Boot
INSERT INTO employee_skill (es_em_id, es_sk_id) VALUES (2, 3); -- Bob - SQL
INSERT INTO employee_skill (es_em_id, es_sk_id) VALUES (3, 1); -- Charlie - Java
INSERT INTO employee_skill (es_em_id, es_sk_id) VALUES (3, 2); -- Charlie - Spring Boot
