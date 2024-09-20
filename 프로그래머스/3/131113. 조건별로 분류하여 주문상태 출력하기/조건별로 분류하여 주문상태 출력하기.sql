-- 2022년 5월 1일 기준으로
-- 주문ID, 제품ID, 출고일자, 출고여부를 조회하는 SQL
-- 2022년 5월 1일까지 '출고 완료', 이후 날짜는 '출고 대기', 미정이면 '출고미정'
-- 주문ID 기준 오름차순

SELECT ORDER_ID, PRODUCT_ID, DATE_FORMAT(OUT_DATE, '%Y-%m-%d')AS OUT_DATE, 
(
    CASE
        WHEN TIMESTAMPDIFF(DAY, '2022-05-01', OUT_DATE) <= 0 THEN '출고완료'
        WHEN TIMESTAMPDIFF(DAY, '2022-05-01', OUT_DATE) > 0 THEN '출고대기'
        ELSE '출고미정'
    END
) AS 출고여부

FROM FOOD_ORDER
