-- scenario 1
CREATE OR REPLACE FUNCTION CalculateAge(p_dob DATE) RETURN NUMBER IS
BEGIN
  RETURN TRUNC(MONTHS_BETWEEN(SYSDATE, p_dob) / 12);
END;

-- scenario 2
CREATE OR REPLACE FUNCTION CalculateMonthlyInstallment(p_amount NUMBER, p_rate NUMBER, p_years NUMBER)
RETURN NUMBER IS
  v_monthly_rate NUMBER := p_rate / 1200;
  v_months NUMBER := p_years * 12;
BEGIN
  RETURN p_amount * v_monthly_rate / (1 - POWER(1 + v_monthly_rate, -v_months));
END;

-- scenario 3
CREATE OR REPLACE FUNCTION HasSufficientBalance(p_account_id NUMBER, p_amount NUMBER)
RETURN BOOLEAN IS
  v_balance NUMBER;
BEGIN
  SELECT Balance INTO v_balance FROM Accounts WHERE AccountID = p_account_id;
  RETURN v_balance >= p_amount;
EXCEPTION
  WHEN OTHERS THEN
    RETURN FALSE;
END;