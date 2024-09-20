-- 2022년 4월 13일 취소되지 않는 흉부외과 진료 예약 내역 조회
-- 진료예약번호, 환자이름, 진료과코드, 의사이름, 진료예약일시 항목 출력
-- 진료예약일시 오름차순 

SELECT A.APNT_NO, P.PT_NAME, P.PT_NO, D.MCDP_CD, D.DR_NAME, A.APNT_YMD
FROM PATIENT P JOIN APPOINTMENT A ON P.PT_NO = A.PT_NO
JOIN DOCTOR D ON D.DR_ID = A.MDDR_ID
 
WHERE A.APNT_CNCL_YN = 'N'
AND DATE_FORMAT(APNT_YMD, '%Y-%m-%d') = '2022-04-13'

ORDER BY APNT_YMD