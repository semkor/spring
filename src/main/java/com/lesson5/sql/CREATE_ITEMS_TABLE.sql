USE database_name;

CREATE TABLE ITEMS(
   ID INT AUTO_INCREMENT,
   CONSTRAINT FILES_PK PRIMARY KEY (ID),
   DESCRIPTION VARCHAR(20) NOT NULL
);