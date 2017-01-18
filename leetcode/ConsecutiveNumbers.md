# Consecutive Numbers

Write a SQL query to find all numbers that appear at least three times consecutively.
```
+----+-----+
| Id | Num |
+----+-----+
| 1  |  1  |
| 2  |  1  |
| 3  |  1  |
| 4  |  2  |
| 5  |  1  |
| 6  |  2  |
| 7  |  2  |
+----+-----+
```
For example, given the above Logs table, 1 is the only number that appears consecutively for at least three times.

**SQL:**
```sql
SELECT DISTINCT l1.Num AS ConsecutiveNums
FROM Logs l1, Logs l2, Logs l3
WHERE l1.Id = l2.Id - 1 AND l2.Id = l3.Id - 1 AND l1.Num = l2.Num AND l2.Num = l3.Num;

SELECT DISTINCT Num AS ConsecutiveNums FROM (
    SELECT
        Num,
        CASE
            WHEN @prevNum = Num THEN @count := @count + 1
            WHEN (@prevNum := Num) IS NOT NULL THEN @count := 1
        END n
    FROM Logs, (SELECT @prevNum := NULL) r
    ORDER BY Id
) a WHERE n >= 3;
```
