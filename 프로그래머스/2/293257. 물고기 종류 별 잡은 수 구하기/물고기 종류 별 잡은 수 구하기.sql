SELECT
    COUNT(*) AS FISH_COUNT, 
    FISH_NAME
FROM 
    FISH_INFO NATURAL JOIN FISH_NAME_INFO
GROUP BY FISH_NAME
ORDER BY FISH_COUNT DESC;