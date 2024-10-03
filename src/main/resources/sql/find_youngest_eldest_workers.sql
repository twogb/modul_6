SELECT 'OLDEST' AS TYPE, NAME, BIRTHDAY
FROM WORKER w
WHERE BIRTHDAY = (
  SELECT MIN(BIRTHDAY) 
  FROM WORKER)
UNION
SELECT 'YOUNGEST', NAME, BIRTHDAY
FROM WORKER w
WHERE BIRTHDAY = (
  SELECT MAX(BIRTHDAY) 
  FROM WORKER);