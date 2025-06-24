-- scenario 1
BEGIN
  FOR rec IN (SELECT CustomerID FROM Customers WHERE TRUNC(MONTHS_BETWEEN(SYSDATE, DOB) / 12) > 60) LOOP
    UPDATE Loans
    SET InterestRate = InterestRate - 1
    WHERE CustomerID = rec.CustomerID;
  END LOOP;
END;

-- scenario 2
BEGIN
  UPDATE Customers
  SET IsVIP = TRUE
  WHERE Balance > 10000;
END;

-- scenario 3
BEGIN
  FOR rec IN (SELECT * FROM Loans WHERE EndDate BETWEEN SYSDATE AND SYSDATE + 30) LOOP
    DBMS_OUTPUT.PUT_LINE('Reminder: Loan ' || rec.LoanID || ' for Customer ' || rec.CustomerID || ' is due soon.');
  END LOOP;
END;