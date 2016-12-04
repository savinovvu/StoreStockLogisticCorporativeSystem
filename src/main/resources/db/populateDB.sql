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


INSERT INTO orders (order_id, startDate, active, customerName, customerPhone, orderComment) VALUES
  (1, '2016-05-10', TRUE, 'customerName1', '8(000)000-0001', 'хороший товар1'),
  (2, '2016-05-11', TRUE, 'customerName2', '8(000)000-0002', 'хороший товар2'),
  (3, '2016-05-12', TRUE, 'customerName3', '8(000)000-0003', 'хороший товар3'),
  (4, '2016-05-13', TRUE, 'customerName4', '8(000)000-0004', 'хороший товар4'),
  (5, '2016-05-13', TRUE, 'customerName5', '8(000)000-0005', 'хороший товар5');

INSERT INTO products (product_id, vendorCode, product_name, countProducts, prepayment, order_id) VALUES
  (1, 1, 'product1', 1, 10001, 1),
  (2, 2, 'product2', 2, 20002, 2),
  (3, 3, 'product3', 3, 30003, 3),
  (4, 4, 'product4', 4, 40004, 4);
/*  (10004, 'product5', '2016-05-13 10:00:00', 10003),
  (10006, 'product6', '2016-05-13 10:00:00', 10003);*/

INSERT INTO locals (localname) VALUES
  ('Local1'),
  ('Local2'),
  ('место3');


INSERT INTO currentstatus (statusId, statusName, statusDate, product_id, id) VALUES
  (1, 'Обработан', '2016-05-10', 1, 1000),
  (2, 'Заказан', '2016-05-11', 2, 1001),
  (3, 'Проверен_и_отложен', '2016-05-12', 3, 1002),

  (4, 'Обработан', '2016-05-13', 4, 1003),
  (5, 'Не_заказан', '2016-05-13', 4, 1003),
  (6, 'Заказан', '2016-05-13', 4, 1003),
  (7, 'Отсутствует', '2016-05-13', 4, 1003),
  (8, 'Проверен_и_отложен', '2016-05-13', 4, 1003),
  (9, 'Дозвон', '2016-05-13', 4, 1003),
  (10, 'Не_Звонили', '2016-05-13', 4, 1003),
  (11, 'Дозвон', '2016-05-13', 4, 1003),
  (12, 'Не_выдан', '2016-05-13', 4, 1003),
  (13, 'Выдан', '2016-05-13', 1, 1003),
  (14, 'Выдан', '2016-05-13', 2, 1003),
  (15, 'Отменен', '2016-05-13', 3, 1003);



