-- 보호 시작일 보다 입양일이 더 빠른 동물
-- 보호 시작일이 빠른 순으로

SELECT O.ANIMAL_ID, O.NAME
FROM ANIMAL_OUTS O JOIN ANIMAL_INS I USING(ANIMAL_ID)
WHERE O.DATETIME <= I.DATETIME
ORDER BY I.DATETIME