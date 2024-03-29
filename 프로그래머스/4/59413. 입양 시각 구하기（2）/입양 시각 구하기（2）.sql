-- 코드를 입력하세요
set @hour = -1;

select @hour := @hour + 1 as HOUR,
(SELECT COUNT(*) FROM ANIMAL_OUTS WHERE HOUR(DATETIME) = @hour)
FROM ANIMAL_OUTS
WHERE @hour <= 22