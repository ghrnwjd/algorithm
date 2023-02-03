-- 코드를 입력하세요
SELECT flavor
FROM first_half natural join icecream_info
where total_order >= 3000 and ingredient_type = 'fruit_based';