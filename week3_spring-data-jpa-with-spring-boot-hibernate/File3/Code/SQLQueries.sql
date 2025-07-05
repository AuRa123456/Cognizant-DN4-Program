USE ormlearn;

DROP TABLE IF EXISTS employee_skill;
DROP TABLE IF EXISTS employee;
DROP TABLE IF EXISTS department;
DROP TABLE IF EXISTS skill;

CREATE TABLE department (
    dp_id INT PRIMARY KEY,
    dp_name VARCHAR(50)
);

CREATE TABLE skill (
    sk_id INT PRIMARY KEY,
    sk_name VARCHAR(50)
);

CREATE TABLE employee (
    em_id INT PRIMARY KEY,
    em_name VARCHAR(100),
    em_salary DOUBLE,
    em_permanent BOOLEAN,
    em_date_of_birth DATE,
    em_dp_id INT,
    FOREIGN KEY (em_dp_id) REFERENCES department(dp_id)
);

CREATE TABLE employee_skill (
    es_em_id INT,
    es_sk_id INT,
    PRIMARY KEY (es_em_id, es_sk_id),
    FOREIGN KEY (es_em_id) REFERENCES employee(em_id),
    FOREIGN KEY (es_sk_id) REFERENCES skill(sk_id)
);

INSERT INTO department VALUES (1, 'HR'), (2, 'Tech'), (3, 'Admin');

INSERT INTO skill VALUES (1, 'Java'), (2, 'SQL'), (3, 'Spring'), (4, 'Communication');

INSERT INTO employee VALUES
(1, 'Alice', 60000, TRUE, '1990-01-01', 2),
(2, 'Bob', 55000, TRUE, '1992-05-21', 3),
(3, 'Charlie', 50000, FALSE, '1995-10-11', 2),
(4, 'David', 45000, TRUE, '1989-09-09', 1);

INSERT INTO employee_skill VALUES
(1, 1), (1, 3),
(2, 2), (2, 4),
(3, 1), (3, 2),
(4, 4);


DROP TABLE IF EXISTS attempt_option;
DROP TABLE IF EXISTS attempt_question;
DROP TABLE IF EXISTS attempt;
DROP TABLE IF EXISTS options;
DROP TABLE IF EXISTS question;
DROP TABLE IF EXISTS user;

CREATE TABLE user (
    us_id INT PRIMARY KEY,
    us_name VARCHAR(50)
);

CREATE TABLE question (
    qu_id INT PRIMARY KEY,
    qu_text VARCHAR(255)
);

CREATE TABLE options (
    op_id INT PRIMARY KEY,
    op_text VARCHAR(100),
    op_score DOUBLE,
    op_correct BOOLEAN,
    op_qu_id INT,
    FOREIGN KEY (op_qu_id) REFERENCES question(qu_id)
);

CREATE TABLE attempt (
    at_id INT PRIMARY KEY,
    at_user_id INT,
    at_date DATETIME,
    FOREIGN KEY (at_user_id) REFERENCES user(us_id)
);

CREATE TABLE attempt_question (
    aq_id INT PRIMARY KEY,
    aq_at_id INT,
    aq_qu_id INT,
    FOREIGN KEY (aq_at_id) REFERENCES attempt(at_id),
    FOREIGN KEY (aq_qu_id) REFERENCES question(qu_id)
);

CREATE TABLE attempt_option (
    ao_id INT PRIMARY KEY,
    ao_aq_id INT,
    ao_op_id INT,
    FOREIGN KEY (ao_aq_id) REFERENCES attempt_question(aq_id),
    FOREIGN KEY (ao_op_id) REFERENCES options(op_id)
);

-- Users
INSERT INTO user VALUES (1, 'Alice'), (2, 'Bob');

-- Questions
INSERT INTO question VALUES 
(1, 'What is the extension of the hyper text markup language file?'),
(2, 'What is the maximum level of heading tag can be used in a HTML page?'),
(3, 'The HTML document itself begins with <html> and ends </html>. State True or False'),
(4, 'Choose the right option to store text value in a variable');

-- Options
INSERT INTO options VALUES 
(1, '.xhtm', 0.0, FALSE, 1),
(2, '.ht', 0.0, FALSE, 1),
(3, '.html', 1.0, TRUE, 1),
(4, '.htmx', 0.0, FALSE, 1),

(5, '5', 0.0, FALSE, 2),
(6, '3', 0.0, TRUE, 2),
(7, '4', 0.0, FALSE, 2),
(8, '6', 1.0, FALSE, 2),

(9, 'false', 0.0, FALSE, 3),
(10, 'true', 1.0, TRUE, 3),

(11, "'John'", 0.5, TRUE, 4),
(12, 'John', 0.0, FALSE, 4),
(13, '"John"', 0.5, FALSE, 4),
(14, '/John/', 0.0, FALSE, 4);

-- Attempt
INSERT INTO attempt VALUES (1, 1, '2024-07-05 10:00:00');

-- Attempt Questions
INSERT INTO attempt_question VALUES 
(1, 1, 1),
(2, 1, 2),
(3, 1, 3),
(4, 1, 4);

-- Attempt Options (selected options by user)
INSERT INTO attempt_option VALUES 
(1, 1, 3),
(2, 2, 6),
(3, 3, 10),
(4, 4, 11);