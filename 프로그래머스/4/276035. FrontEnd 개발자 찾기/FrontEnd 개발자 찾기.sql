-- 코드를 작성해주세요
with frontend as (
    select sum(code)
    from skillcodes
    where category = 'Front End'
)

select id, email, first_name, last_name
from developers
where skill_code & (select * from frontend) >= 1
order by id