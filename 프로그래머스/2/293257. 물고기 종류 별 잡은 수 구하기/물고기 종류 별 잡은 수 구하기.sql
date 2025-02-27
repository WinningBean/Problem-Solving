SELECT COUNT(ID) AS FISH_COUNT,
    (SELECT FISH_NAME
     FROM FISH_NAME_INFO AS FNI
     WHERE FNI.FISH_TYPE = FI.FISH_TYPE) AS FISH_NAME
FROM FISH_INFO AS FI
GROUP BY FISH_TYPE
ORDER BY FISH_COUNT DESC;