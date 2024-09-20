-- 자동차 종류가 '세단', 'SUV' 인 차 중
-- 2022년 11월 1일 ~ 2022년 11월 30일까지 대여 가능
-- 30일간의대여 금액 50만원 이상 200만원 미만 자동차
-- 금액 내림차순, 종류 오름차순, 자동차 id 내림차순

WITH carId AS(
    select distinct car_id
    from car_rental_company_rental_history
    where end_date >= '2022-11-01'
), discount AS (
    select car_type, (1 - (discount_rate) * 0.01) as rate
    from CAR_RENTAL_COMPANY_DISCOUNT_PLAN
    where duration_type = '30일 이상'
)

SELECT car_id, car_type, ROUND(30 * DAILY_FEE * RATE) AS FEE
FROM car_rental_company_car 
join discount d using (car_type)

where car_id not in (select * from carId)
and car_type in ('세단', 'SUV')
having fee between 500000 and 2000000
order by fee desc, car_type, car_id desc