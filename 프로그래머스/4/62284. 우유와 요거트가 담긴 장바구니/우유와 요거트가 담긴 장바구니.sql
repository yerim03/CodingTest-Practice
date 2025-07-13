-- 코드를 입력하세요
-- 우유와 요거트를 동시에 구입한 장바구니의 아이디
SELECT DISTINCT(C.CART_ID)
FROM CART_PRODUCTS C, (SELECT CART_ID
                      FROM CART_PRODUCTS
                      WHERE NAME = 'Milk') M
WHERE C.CART_ID = M.CART_ID AND NAME = 'Yogurt'
ORDER BY 1;