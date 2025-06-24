-- scenario 1
CREATE OR REPLACE PACKAGE EmployeeManagement AS
  PROCEDURE HireEmployee(p_id NUMBER, p_name VARCHAR2, p_position VARCHAR2, p_salary NUMBER, p_dept VARCHAR2, p_hire DATE);
  PROCEDURE UpdateEmployee(p_id NUMBER, p_salary NUMBER);
  FUNCTION GetAnnualSalary(p_id NUMBER) RETURN NUMBER;
END EmployeeManagement;
/

CREATE OR REPLACE PACKAGE BODY EmployeeManagement AS
  PROCEDURE HireEmployee(p_id NUMBER, p_name VARCHAR2, p_position VARCHAR2, p_salary NUMBER, p_dept VARCHAR2, p_hire DATE) IS
  BEGIN
    INSERT INTO Employees (EmployeeID, Name, Position, Salary, Department, HireDate)
    VALUES (p_id, p_name, p_position, p_salary, p_dept, p_hire);
  EXCEPTION
    WHEN DUP_VAL_ON_INDEX THEN
      DBMS_OUTPUT.PUT_LINE('Employee already exists.');
    WHEN OTHERS THEN
      DBMS_OUTPUT.PUT_LINE('Error hiring employee: ' || SQLERRM);
  END;

  PROCEDURE UpdateEmployee(p_id NUMBER, p_salary NUMBER) IS
  BEGIN
    UPDATE Employees SET Salary = p_salary WHERE EmployeeID = p_id;
    IF SQL%ROWCOUNT = 0 THEN
      DBMS_OUTPUT.PUT_LINE('Employee not found.');
    END IF;
  END;

  FUNCTION GetAnnualSalary(p_id NUMBER) RETURN NUMBER IS
    v_salary NUMBER;
  BEGIN
    SELECT Salary INTO v_salary FROM Employees WHERE EmployeeID = p_id;
    RETURN v_salary * 12;
  EXCEPTION
    WHEN NO_DATA_FOUND THEN
      DBMS_OUTPUT.PUT_LINE('Employee not found.');
      RETURN NULL;
  END;

END EmployeeManagement;
/

-- scenario 2
CREATE OR REPLACE PACKAGE EmployeeManagement AS
  PROCEDURE HireEmployee(p_id NUMBER, p_name VARCHAR2, p_position VARCHAR2, p_salary NUMBER, p_dept VARCHAR2, p_hire DATE);
  PROCEDURE UpdateEmployee(p_id NUMBER, p_salary NUMBER);
  FUNCTION GetAnnualSalary(p_id NUMBER) RETURN NUMBER;
END EmployeeManagement;
/

CREATE OR REPLACE PACKAGE BODY EmployeeManagement AS

  PROCEDURE HireEmployee(p_id NUMBER, p_name VARCHAR2, p_position VARCHAR2, p_salary NUMBER, p_dept VARCHAR2, p_hire DATE) IS
  BEGIN
    INSERT INTO Employees (EmployeeID, Name, Position, Salary, Department, HireDate)
    VALUES (p_id, p_name, p_position, p_salary, p_dept, p_hire);
  EXCEPTION
    WHEN DUP_VAL_ON_INDEX THEN
      DBMS_OUTPUT.PUT_LINE('Employee already exists.');
    WHEN OTHERS THEN
      DBMS_OUTPUT.PUT_LINE('Error hiring employee: ' || SQLERRM);
  END;

  PROCEDURE UpdateEmployee(p_id NUMBER, p_salary NUMBER) IS
  BEGIN
    UPDATE Employees SET Salary = p_salary WHERE EmployeeID = p_id;
    IF SQL%ROWCOUNT = 0 THEN
      DBMS_OUTPUT.PUT_LINE('Employee not found.');
    END IF;
  END;

  FUNCTION GetAnnualSalary(p_id NUMBER) RETURN NUMBER IS
    v_salary NUMBER;
  BEGIN
    SELECT Salary INTO v_salary FROM Employees WHERE EmployeeID = p_id;
    RETURN v_salary * 12;
  EXCEPTION
    WHEN NO_DATA_FOUND THEN
      DBMS_OUTPUT.PUT_LINE('Employee not found.');
      RETURN NULL;
  END;

END EmployeeManagement;
/

-- scenario 3
CREATE OR REPLACE PACKAGE AccountOperations AS
  PROCEDURE OpenAccount(p_accountID NUMBER, p_customerID NUMBER, p_type VARCHAR2, p_balance NUMBER);
  PROCEDURE CloseAccount(p_accountID NUMBER);
  FUNCTION GetTotalBalance(p_customerID NUMBER) RETURN NUMBER;
END AccountOperations;
/

CREATE OR REPLACE PACKAGE BODY AccountOperations AS

  PROCEDURE OpenAccount(p_accountID NUMBER, p_customerID NUMBER, p_type VARCHAR2, p_balance NUMBER) IS
  BEGIN
    INSERT INTO Accounts (AccountID, CustomerID, AccountType, Balance, LastModified)
    VALUES (p_accountID, p_customerID, p_type, p_balance, SYSDATE);
  EXCEPTION
    WHEN DUP_VAL_ON_INDEX THEN
      DBMS_OUTPUT.PUT_LINE('Account already exists.');
    WHEN OTHERS THEN
      DBMS_OUTPUT.PUT_LINE('Error opening account: ' || SQLERRM);
  END;

  PROCEDURE CloseAccount(p_accountID NUMBER) IS
  BEGIN
    DELETE FROM Accounts WHERE AccountID = p_accountID;
    IF SQL%ROWCOUNT = 0 THEN
      DBMS_OUTPUT.PUT_LINE('Account not found.');
    END IF;
  END;

  FUNCTION GetTotalBalance(p_customerID NUMBER) RETURN NUMBER IS
    v_total NUMBER;
  BEGIN
    SELECT SUM(Balance) INTO v_total FROM Accounts WHERE CustomerID = p_customerID;
    RETURN v_total;
  EXCEPTION
    WHEN NO_DATA_FOUND THEN
      DBMS_OUTPUT.PUT_LINE('Customer has no accounts.');
      RETURN 0;
  END;

END AccountOperations;
/