-- 중성화되었는지 아닌지 파악
-- 아이디와 이름, 중성화 여부
-- 아이디순 조회
-- 중성화 되었다면 O, 아니면 X

SELECT ANIMAL_ID, NAME, (
CASE
    WHEN (SEX_UPON_INTAKE LIKE 'Intact%')THEN 'X'
    ELSE 'O'
END
) AS 중성화

FROM ANIMAL_INS
ORDER BY ANIMAL_ID