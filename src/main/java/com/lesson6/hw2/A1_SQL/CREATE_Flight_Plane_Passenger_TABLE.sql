USE database_name;

CREATE TABLE PLANE(
    ID INT AUTO_INCREMENT,
    CONSTRAINT PLANE_PK PRIMARY KEY (ID),
    MODEL VARCHAR(50),
    CODE VARCHAR(50),
    YEAR_PRODUCED DATE,
    AVG_FUEL_CONSUMPTION DEC(7,2)
);


CREATE TABLE PASSENGER(
    ID INT AUTO_INCREMENT,
    CONSTRAINT PASSENGER_PK PRIMARY KEY (ID),
    LAST_NAME VARCHAR(50),
    NATIONALITY VARCHAR(50),
    DATE_OF_BIRTH DATE,
    PASSPORT_CODE VARCHAR(50)
);


CREATE TABLE FLIGHT(
   ID INT AUTO_INCREMENT,
   CONSTRAINT FLIGHT_PK PRIMARY KEY (ID),
   PLANE_ID INT,
        CONSTRAINT PLANE_FK FOREIGN KEY (PLANE_ID) REFERENCES PLANE(ID),
   DATE_FLIGHT DATE,
   CITY_FROM VARCHAR(50),
   CITY_TO VARCHAR(50)
);


CREATE TABLE PASSENGER_FLIGHT(
    FLIGHT_ID INT,
        CONSTRAINT PASSENGER_FLIGHT_FLIGHT_ID_FK FOREIGN KEY (FLIGHT_ID) REFERENCES FLIGHT(ID),
    PASSENGER_ID INT,
        CONSTRAINT PASSENGER_FLIGHT_PASSENGER_ID_FK FOREIGN KEY (PASSENGER_ID) REFERENCES PASSENGER(ID)
);


# --------------------------------------------------- фильтры ----------------------------------------------------------
# дата отправки
SELECT * FROM FLIGHT WHERE DATE_FLIGHT = '2022-03-15';

# по промежутку даты (с даты по дату)
SELECT * FROM FLIGHT
INNER JOIN PLANE ON PLANE.ID = FLIGHT.ID
WHERE DATE_FLIGHT BETWEEN DATE('2022-03-17') AND DATE('2022-03-18');

# город отправки
SELECT * FROM FLIGHT
INNER JOIN PLANE ON PLANE.ID = FLIGHT.ID
WHERE FLIGHT.CITY_FROM = 'KIEV';

# город назначения
SELECT * FROM FLIGHT
INNER JOIN PLANE ON PLANE.ID = FLIGHT.ID
WHERE FLIGHT.CITY_TO = 'MOSCOW';

# модель самолета
SELECT * FROM FLIGHT
INNER JOIN PLANE ON PLANE.ID = FLIGHT.PLANE_ID
WHERE PLANE.MODEL = 'GoTo';


# --------------------------------------------------- полеты -----------------------------------------------------------
#  список ТОП 10 самых  популярных рейсов по городам назначения   - mostPopularTo()
SELECT CITY_TO, COUNT(CITY_TO) FROM FLIGHT
GROUP BY FLIGHT.CITY_TO
ORDER BY COUNT(CITY_TO) DESC
LIMIT 3;


# cписок ТОП - 10 самых популярных рейсов по городам вылета   - mostPopularFrom()
SELECT CITY_FROM,COUNT(CITY_FROM) FROM FLIGHT
GROUP BY FLIGHT.CITY_FROM
ORDER BY COUNT(CITY_FROM) DESC
LIMIT 3;


# ------------------------------------------------- самолеты -----------------------------------------------------------
# самолеты старше 20 лет   - oldPlanes()
SELECT * FROM PLANE WHERE TIMESTAMPDIFF(YEAR,PLANE.YEAR_PRODUCED,CURDATE())>2;

# самолеты, у которых больше 300 полетов за год  - regularPlanes (int year)
SELECT ID, MODEL,CODE,YEAR_PRODUCED, AVG_FUEL_CONSUMPTION FROM (
SELECT PLANE.ID AS ID, MODEL, CODE, YEAR_PRODUCED, AVG_FUEL_CONSUMPTION, COUNT(PLANE.ID) AS RESULT FROM PLANE
JOIN FLIGHT ON PLANE_ID = PLANE.ID
WHERE YEAR(FLIGHT.DATE_FLIGHT) = ?
GROUP BY ID) AS TABLES
WHERE  RESULT > 2;



# ------------------------------------------------- пассажиры ----------------------------------------------------------
# пассажиры с больше 2 полетов за год
SELECT ID,LAST_NAME, NATIONALITY, DATE_OF_BIRTH,PASSPORT_CODE FROM(
SELECT PASSENGER.ID,LAST_NAME, NATIONALITY, DATE_OF_BIRTH,PASSPORT_CODE, COUNT(PASSENGER.ID) AS RESULT_PAS FROM PASSENGER
JOIN PASSENGER_FLIGHT on PASSENGER_FLIGHT.PASSENGER_ID = PASSENGER.ID
JOIN FLIGHT on FLIGHT.ID = PASSENGER_FLIGHT.FLIGHT_ID
WHERE YEAR(FLIGHT.DATE_FLIGHT) = ?
GROUP BY PASSENGER.ID) AS TABLE_RESULT
WHERE TABLE_RESULT.RESULT_PAS > 2;
