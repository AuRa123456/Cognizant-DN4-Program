-- scenario 1
CREATE OR REPLACE PROCEDURE SafeTransferFunds(p_from NUMBER, p_to NUMBER, p_amount NUMBER) IS
BEGIN
  UPDATE Accounts SET Balance = Balance - p_amount WHERE AccountID = p_from;
  IF SQL%ROWCOUNT = 0 THEN
    RAISE_APPLICATION_ERROR(-20001, 'Source account not found');
  END IF;

  UPDATE Accounts SET Balance = Balance + p_amount WHERE AccountID = p_to;
  IF SQL%ROWCOUNT = 0 THEN
    RAISE_APPLICATION_ERROR(-20002, 'Destination account not found');
  END IF;

  COMMIT;
EXCEPTION
  WHEN OTHERS THEN
    ROLLBACK;
    DBMS_OUTPUT.PUT_LINE('Transfer failed: ' || SQLERRM);
END;

-- scenario 2
CREATE OR REPLACE PROCEDURE UpdateSalary(p_id NUMBER, p_percent NUMBER) IS
BEGIN
  UPDATE Employees SET Salary = Salary + (Salary * p_percent / 100) WHERE EmployeeID = p_id;
  IF SQL%ROWCOUNT = 0 THEN
    DBMS_OUTPUT.PUT_LINE('Employee ID not found.');
  END IF;
EXCEPTION
  WHEN OTHERS THEN
    DBMS_OUTPUT.PUT_LINE('Error updating salary: ' || SQLERRM);
END;

-- scenario 3
CREATE OR REPLACE PROCEDURE AddNewCustomer(p_id NUMBER, p_name VARCHAR2, p_dob DATE, p_balance NUMBER) IS
BEGIN
  INSERT INTO Customers (CustomerID, Name, DOB, Balance, LastModified)
  VALUES (p_id, p_name, p_dob, p_balance, SYSDATE);
EXCEPTION
  WHEN DUP_VAL_ON_INDEX THEN
    DBMS_OUTPUT.PUT_LINE('Customer already exists.');
  WHEN OTHERS THEN
    DBMS_OUTPUT.PUT_LINE('Error adding customer: ' || SQLERRM);
END;