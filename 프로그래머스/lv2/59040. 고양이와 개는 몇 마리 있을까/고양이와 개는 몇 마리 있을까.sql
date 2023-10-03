-- 코드를 입력하세요
SELECT ANIMAL_TYPE, count(*) as count
from ANIMAL_INS
group by animal_type
order by FIELD(ANIMAL_TYPE, 'Cat', 'Dog');