DROP TABLE users IF EXISTS;
DROP TABLE products IF EXISTS;
DROP TABLE orders IF EXISTS;



DROP SEQUENCE USER_SEQ IF EXISTS;
DROP SEQUENCE ORDER_SEQ IF EXISTS;
DROP SEQUENCE PRODUCT_SEQ IF EXISTS;

CREATE SEQUENCE USER_SEQ  AS INTEGER  START WITH 1000;
CREATE SEQUENCE ORDER_SEQ  AS INTEGER  START WITH 10000;
CREATE SEQUENCE PRODUCT_SEQ  AS INTEGER  START WITH 10000;



CREATE TABLE users
(
  id       INTEGER GENERATED BY DEFAULT AS SEQUENCE USER_SEQ PRIMARY KEY,
  userName VARCHAR(255),
  roles     VARCHAR(255)

);





CREATE TABLE orders
(

  order_id INTEGER GENERATED BY DEFAULT AS SEQUENCE ORDER_SEQ  PRIMARY KEY,
  startDateTime TIMESTAMP NOT NULL

);




CREATE TABLE products
(
  product_id   INTEGER GENERATED BY DEFAULT AS SEQUENCE PRODUCT_SEQ  PRIMARY KEY,
  product_name VARCHAR(255),
  startDateTime TIMESTAMP  NOT NULL,
  order_id   INTEGER ,
  FOREIGN KEY (order_id) REFERENCES ORDERS (order_id)  ON DELETE CASCADE
);
CREATE UNIQUE INDEX products_unique_order ON products (order_id);

