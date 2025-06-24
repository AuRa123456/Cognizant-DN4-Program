-- scenario 1
DECLARE
  CURSOR c_transactions IS
    SELECT * FROM Transactions WHERE TRUNC(TransactionDate, 'MM') = TRUNC(SYSDATE, 'MM');
BEGIN
  FOR rec IN c_transactions LOOP
    DBMS_OUTPUT.PUT_LINE('Customer for Account ' || rec.AccountID || ' made a ' || rec.TransactionType || ' of ' || rec.Amount);
  END LOOP;
END;

--scenario 2
DECLARE
  CURSOR c_accounts IS SELECT AccountID FROM Accounts;
BEGIN
  FOR acc IN c_accounts LOOP
    UPDATE Accounts
    SET Balance = Balance - 100
    WHERE AccountID = acc.AccountID;
  END LOOP;
END;

-- scenario 3
DECLARE
  CURSOR c_loans IS SELECT LoanID FROM Loans;
BEGIN
  FOR rec IN c_loans LOOP
    UPDATE Loans
    SET InterestRate = InterestRate + 0.5
    WHERE LoanID = rec.LoanID;
  END LOOP;
END;