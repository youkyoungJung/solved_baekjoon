SELECT p.PRODUCT_ID, p.PRODUCT_NAME, sum(p.price*o.amount) as total_sales
from food_product p, food_order o
where p.product_id = o.product_id
and to_char(o.produce_date, 'yyyy-mm') = '2022-05'
group by p.PRODUCT_ID, p.PRODUCT_NAME
order by total_sales desc, p.product_id asc;