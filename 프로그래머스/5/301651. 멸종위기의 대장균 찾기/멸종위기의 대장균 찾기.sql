WITH RECURSIVE E_GEN AS (
    (
        SELECT
            ID,
            PARENT_ID,
            1 AS GEN
        FROM ECOLI_DATA
        WHERE
            PARENT_ID IS NULL
    )
    UNION
    (
        SELECT
            A.ID,
            A.PARENT_ID,
            B.GEN + 1 AS GEN
        FROM ECOLI_DATA AS A
        JOIN E_GEN AS B
        ON A.PARENT_ID = B.ID
    )
)

SELECT
    COUNT(B.ID) AS COUNT,
    B.GEN AS GENERATION
FROM ECOLI_DATA AS A
RIGHT JOIN E_GEN AS B
ON A.PARENT_ID = B.ID
WHERE A.ID IS NULL
GROUP BY B.GEN
ORDER BY GENERATION ASC;