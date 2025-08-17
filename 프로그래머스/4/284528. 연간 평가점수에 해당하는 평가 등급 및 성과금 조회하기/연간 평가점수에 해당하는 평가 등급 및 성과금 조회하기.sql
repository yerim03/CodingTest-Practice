-- 코드를 작성해주세요
-- 사원별 성과금 정보 조회
-- 사번(empno), 성명(empname), 평가 등급(grade), 성과금 조회(bonus)
-- 성과금 = HR_EMPLOYEES.SAL * (성과금)

SELECT E.EMP_NO, E.EMP_NAME,
CASE WHEN AVG(G.SCORE) >= 96 THEN 'S'
     WHEN AVG(G.SCORE) >= 90 THEN 'A'
     WHEN AVG(G.SCORE) >= 80 THEN 'B'
     ELSE 'C'
END AS GRADE,
CASE WHEN AVG(G.SCORE) >= 96 THEN E.SAL * 0.2
     WHEN AVG(G.SCORE) >= 90 THEN E.SAL * 0.15
     WHEN AVG(G.SCORE) >= 80 THEN E.SAL * 0.1
     ELSE 0
END AS BONUS
FROM HR_EMPLOYEES E JOIN HR_GRADE G
ON E.EMP_NO = G.EMP_NO
GROUP BY E.EMP_NO
ORDER BY 1;
