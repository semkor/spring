USE database_name;

CREATE TABLE PERSON(
   ID INT AUTO_INCREMENT,
   CONSTRAINT PLANE_PK PRIMARY KEY (ID),
   NAME VARCHAR(20),
   LAST_NAME VARCHAR(20),
   SEX ENUM('MAN', 'WOMAN'),
   LOGIN VARCHAR(20),
   PASSWORD VARCHAR(20)
);

CREATE TABLE ARTICLES(
   ID INT AUTO_INCREMENT,
   CONSTRAINT PLANE_PK PRIMARY KEY (ID),
   CATEGORY VARCHAR(50),
   SUBCATEGORY ENUM('SALE', 'PURCHASE'),
   ARTICLE_NAME VARCHAR(50),
   CONTEXT LONGTEXT,
   CITY VARCHAR(50),
   TELEPHONE VARCHAR(20),
   PRICE INT,
   CURRENCY_PRICE ENUM('USD','UAH','EURO'),
   DATE_FROM DATE,
   DATE_TO DATE,
   PERSON_ID INT,
      CONSTRAINT PERSON_FK FOREIGN KEY (PERSON_ID) REFERENCES PERSON(ID)
);

# --------------------------------------- запросы  по фильтру (аккаунт не активен)  ------------------------------------

# по всем параметрам фильтра
SELECT * FROM ARTICLES WHERE CITY = ? AND CATEGORY = ? AND CONTEXT LIKE ?;

# параметры Сity / Category
SELECT * FROM ARTICLES WHERE CITY = ? AND CATEGORY = ?;

# параметры Сity / ArticleName
SELECT * FROM ARTICLES WHERE CITY = ? AND CONTEXT LIKE ?;

# параметры Сategory / ArticleName
SELECT * FROM ARTICLES WHERE CATEGORY = ? AND CONTEXT LIKE ?;

# параметры City
SELECT * FROM ARTICLES WHERE CITY = ?;

# параметры Сategory
SELECT * FROM ARTICLES WHERE CATEGORY = ?;

# параметры Context
SELECT * FROM ARTICLES WHERE CONTEXT LIKE ?;

# ------------------------------------- запросы  по фильтру (аккаунт активен)  -----------------------------------------

SELECT * FROM PERSON WHERE PERSON.LOGIN = ?  AND PERSON.PASSWORD = ?;

SELECT * FROM ARTICLES WHERE ARTICLES.PERSON_ID = ?;