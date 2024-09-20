-- 수원 지역의 연도 별 평균 미세먼지 오염도, 평균 초미세먼지 오염도 조회
-- 컬럼명 각각 PM10, PM2.5, 값은 소수 셋째 자리 반올림
-- 연도 오름차순

SELECT YEAR(YM) AS 'YEAR', ROUND(AVG(PM_VAL1), 2) AS 'PM10', ROUND(AVG(PM_VAL2), 2) AS 'PM2.5'
FROM AIR_POLLUTION
WHERE LOCATION2 = '수원' AND LOCATION1 = '경기도'
GROUP BY YEAR
ORDER BY YEAR
