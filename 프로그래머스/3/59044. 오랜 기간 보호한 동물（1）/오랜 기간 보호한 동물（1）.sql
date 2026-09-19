# 1. 입양을 못 간 동물
# 2. 가장 오래 보호소에 있었던 동물 3마리
# 3. 동물 이름, 보호 시작일

SELECT i.NAME, i.DATETIME
FROM ANIMAL_INS i
WHERE NOT EXISTS(
    SELECT 1
    FROM ANIMAL_OUTS o
    WHERE i.ANIMAL_ID = o.ANIMAL_ID
)
ORDER BY i.DATETIME ASC
LIMIT 3;