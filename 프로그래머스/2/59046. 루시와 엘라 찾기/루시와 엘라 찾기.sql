-- 보호소에 들어온 동물
-- 아이디, 이름, 성별 및 중성화 여부 조회
-- 아이디 순 조회

SELECT ANIMAL_ID, NAME, SEX_UPON_INTAKE
FROM ANIMAL_INS
WHERE NAME IN ('Lucy', 'Ella','Pickle', 'Rogan', 'Sabrina', 'Mitty')
ORDER BY ANIMAL_ID