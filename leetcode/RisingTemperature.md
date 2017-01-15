# Rising Temperature

Given a Weather table, write a SQL query to find all dates' Ids with higher temperature compared to its previous (yesterday's) dates.
```
+---------+------------+------------------+
| Id(INT) | Date(DATE) | Temperature(INT) |
+---------+------------+------------------+
|       1 | 2015-01-01 |               10 |
|       2 | 2015-01-02 |               25 |
|       3 | 2015-01-03 |               20 |
|       4 | 2015-01-04 |               30 |
+---------+------------+------------------+
```
For example, return the following Ids for the above Weather table:
```
+----+
| Id |
+----+
|  2 |
|  4 |
+----+
```

**SQL:**
```sql
SELECT wt1.Id
FROM Weather wt1, Weather wt2
WHERE wt1.Temperature > wt2.Temperature AND
      TO_DAYS(wt1.DATE) - TO_DAYS(wt2.DATE) = 1;

SELECT t1.Id
FROM Weather t1
INNER JOIN Weather t2
ON TO_DAYS(t1.Date) = TO_DAYS(t2.Date) + 1
WHERE t1.Temperature > t2.Temperature;

SELECT a.Id FROM Weather AS a, Weather AS b
WHERE DATEDIFF(a.Date, b.Date)=1 AND a.Temperature > b.Temperature;
```
