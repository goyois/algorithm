SELECT  FLAVOR
  FROM  (
         SELECT  A.FLAVOR AS FLAVOR
               , SUM(A.TOTAL_ORDER)+SUM(B.TOTAL_ORDER) AS CNT
           FROM  FIRST_HALF A
               , JULY B
          WHERE  A.FLAVOR = B.FLAVOR
          GROUP
             BY  A.FLAVOR,B.FLAVOR
          ORDER
             BY  CNT DESC
          FETCH FIRST 3 ROWS ONLY
         )