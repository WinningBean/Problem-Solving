WITH RECURSIVE E_GEN AS (
    (
        SELECT
            ID,
            PARENT_ID,
            1 AS 'GEN'
        FROM
            ECOLI_DATA
        WHERE
            PARENT_ID IS NULL
    )
    UNION
    (
        SELECT
            A.ID,
            A.PARENT_ID,
            B.GEN + 1 AS 'GEN'
        FROM
            ECOLI_DATA AS A
        INNER JOIN
            E_GEN AS B
        ON
            A.PARENT_ID = B.ID
    )
)

SELECT
    ID
FROM
    E_GEN
WHERE
    GEN = 3
ORDER BY
    ID ASC;