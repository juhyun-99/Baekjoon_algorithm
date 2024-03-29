-- 코드를 입력하세요
SELECT O.PRODUCT_ID, P.PRODUCT_NAME, SUM(O.AMOUNT * P.PRICE) AS TOTAL_SALES
FROM FOOD_ORDER AS O JOIN FOOD_PRODUCT AS P ON O.PRODUCT_ID = P.PRODUCT_ID
WHERE YEAR(O.PRODUCE_DATE) = 2022 AND MONTH(O.PRODUCE_DATE) = 5
GROUP BY O.PRODUCT_ID
ORDER BY 3 DESC, 1