-- 코드를 입력하세요
SELECT USER_ID, PRODUCT_ID
FROM (
    SELECT USER_ID, PRODUCT_ID
    FROM ONLINE_SALE
    group by user_id, product_id
    having count(product_id) > 1
)
ORDER BY USER_ID, PRODUCT_ID DESC;