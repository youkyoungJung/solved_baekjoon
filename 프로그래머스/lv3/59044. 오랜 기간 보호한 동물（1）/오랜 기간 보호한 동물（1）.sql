-- SELECT NAME, DATETIME
-- FROM ANIMAL_INS
-- WHERE ANIMAL_ID NOT IN(
-- SELECT ANIMAL_ID
-- FROM ANIMAL_OUTS
-- )
-- AND ROWNUM <= 3
-- ORDER BY DATETIME 

SELECT NAME,DATETIME
    FROM ANIMAL_INS
    WHERE ANIMAL_ID NOT IN (SELECT ANIMAL_ID FROM ANIMAL_OUTS)
    ORDER BY DATETIME FETCH FIRST 3 ROWS ONLY;