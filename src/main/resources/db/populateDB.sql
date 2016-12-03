DELETE FROM locals;
DELETE FROM users;
DELETE FROM orders;
DELETE FROM products;
DELETE FROM currentstatus;


INSERT INTO users (id, userName, roles, active) VALUES
  (1000, 'name1', 'Руководитель', TRUE),
  (1001, 'name2', 'Руководитель', TRUE),
  (1002, 'name3', 'Снабженец', TRUE),
  (1003, 'name4', 'Продавец', TRUE),
  (1005, 'Имя4', 'Продавец', TRUE),
  (1004, 'name4', 'Продавец', FALSE);


INSERT INTO orders (order_id, startDateTime) VALUES
  (10000, '2016-05-10 10:00:00'),
  (10001, '2016-05-11 10:00:00'),
  (10002, '2016-05-12 10:00:00'),
  (10003, '2016-05-13 10:00:00'),
  (10004, '2016-05-13 10:00:00');

INSERT INTO products (product_id, product_name, startDateTime, order_id) VALUES
  (10000, 'product1', '2016-05-10 10:00:00', 10000),
  (10001, 'product2', '2016-05-11 10:00:00', 10001),
  (10002, 'product3', '2016-05-12 10:00:00', 10002),
  (10003, 'product4', '2016-05-13 10:00:00', 10003);
/*  (10004, 'product5', '2016-05-13 10:00:00', 10003),
  (10006, 'product6', '2016-05-13 10:00:00', 10003);*/

INSERT INTO locals (localname) VALUES
  ( 'Local1'),
  ( 'Local2'),
  ( 'место3');


INSERT INTO currentstatus (statusId, statusName, statusDate, statusGroup, product_id, id) VALUES
  (1, 'Обработан', '2016-05-10', 1, 10000, 1000),
  (2, 'Заказан', '2016-05-11', 2, 10001, 1001),
  (3, 'Проверен_и_отложен','2016-05-12',3, 10002, 1002),
  (4, 'Дозвон', '2016-05-13', 4, 10003, 1003);
/*
  (5, 'Обработан', '2016-05-14', 1, 10003, 1004),
  (6, 'Заказан', '2016-05-14', 2, 10003, 1004),
  (7, 'Проверен и отложен', '2016-05-14', 3, 10003, 1004);*/


