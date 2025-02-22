WITH RANKED_ECOLI AS (
    SELECT 
        ID,
        SIZE_OF_COLONY,
        NTILE(4) OVER (ORDER BY SIZE_OF_COLONY DESC) AS COLONY_RANK
    FROM ECOLI_DATA
)

SELECT 
    ID,
    CASE 
        WHEN COLONY_RANK = 1 THEN 'CRITICAL'
        WHEN COLONY_RANK = 2 THEN 'HIGH'
        WHEN COLONY_RANK = 3 THEN 'MEDIUM'
        ELSE 'LOW'
    END AS COLONY_NAME
FROM RANKED_ECOLI
ORDER BY ID;
