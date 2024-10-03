WITH t AS ( 
  SELECT ID AS NAME, 
    ((YEAR(FINISH_DATE) - YEAR(START_DATE)) * 12 + (MONTH(FINISH_DATE) - MONTH (START_DATE))) AS MONTH_COUNT
  FROM PROJECT
)
SELECT *  FROM t WHERE MONTH_COUNT = (SELECT MAX(MONTH_COUNT) FROM t);
