-- 코드를 입력하세요
SELECT ROUND(AVG(daily_fee)) as AVERAGE_FEE
FROM car_rental_company_car
where car_type = 'SUV';