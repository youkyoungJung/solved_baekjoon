-- 입양간 기록은 있는데, 보호소에 들어온 기록이 없는 동물

SELECT ANIMAL_ID, NAME
FROM ANIMAL_OUTS
WHERE ANIMAL_ID NOT IN (
    SELECT ANIMAL_ID
    FROM ANIMAL_INS
)