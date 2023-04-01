-- 코드를 입력하세요
SELECT
    floor(price/10000)*10000 as price_group
    , count(product_id) AS PRODUCTS
from product
group by floor(price/10000)
order by floor(price/10000) asc
;