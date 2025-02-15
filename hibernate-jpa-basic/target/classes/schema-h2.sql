DROP TABLE IF EXISTS TBL_EMPLOYEE;
CREATE TABLE TBL_EMPLOYEE (
    id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(250) NOT NULL,
    last_name VARCHAR(250) NOT NULL,
    email VARCHAR(250) DEFAULT NULL
);
DROP TABLE IF EXISTS TBL_SCOPE;
CREATE TABLE TBL_SCOPE (
    id INT AUTO_INCREMENT PRIMARY KEY,
    scope_name VARCHAR(250) NOT NULL,
    scope_description VARCHAR(250) NOT NULL,
    task_id INT



);
DROP TABLE IF EXISTS TBL_TASK;
CREATE TABLE TBL_TASK (
    id INT AUTO_INCREMENT PRIMARY KEY,
    task_name VARCHAR(250) NOT NULL,
    task_description VARCHAR(250) NOT NULL,
    employee_id INT,
    scope_id INT,
    FOREIGN KEY (employee_id) REFERENCES TBL_EMPLOYEE(id),
    FOREIGN KEY (scope_id) REFERENCES TBL_SCOPE(id)
);


