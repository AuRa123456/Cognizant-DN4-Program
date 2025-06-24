-- scenario 1
CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest IS
BEGIN
  UPDATE Accounts
  SET Balance = Balance + (Balance * 0.01)
  WHERE AccountType = 'Savings';
END;

-- scenario 2
CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus(p_dept VARCHAR2, p_bonus NUMBER) IS
BEGIN
  UPDATE Employees
  SET Salary = Salary + (Salary * p_bonus / 100)
  WHERE Department = p_dept;
END;

-- scenario 3
CREATE OR REPLACE PROCEDURE TransferFunds(p_from NUMBER, p_to NUMBER, p_amount NUMBER) IS
  v_balance NUMBER;
BEGIN
  SELECT Balance INTO v_balance FROM Accounts WHERE AccountID = p_from;

  IF v_balance >= p_amount THEN
    UPDATE Accounts SET Balance = Balance - p_amount WHERE AccountID = p_from;
    UPDATE Accounts SET Balance = Balance + p_amount WHERE AccountID = p_to;
    COMMIT;
  ELSE
    DBMS_OUTPUT.PUT_LINE('Insufficient balance.');
  END IF;
EXCEPTION
  WHEN OTHERS THEN
    ROLLBACK;
    DBMS_OUTPUT.PUT_LINE('Transfer failed: ' || SQLERRM);
END;