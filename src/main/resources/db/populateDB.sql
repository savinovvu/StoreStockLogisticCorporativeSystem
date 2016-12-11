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

INSERT INTO orders (startDate, active, customerName, customerPhone, orderComment) VALUES
  ('2016-05-10', TRUE, 'customerName1', '8(000)000-0001', 'хороший товар1'),
  ('2016-05-11', TRUE, 'customerName2', '8(000)000-0002', 'хороший товар2'),
  ('2016-05-12', TRUE, 'customerName3', '8(000)000-0003', 'хороший товар3'),
  ('2016-05-13', TRUE, 'customerName4', '8(000)000-0004', 'хороший товар4'),
  ('2016-05-13', TRUE, 'customerName5', '8(000)000-0005', 'хороший товар5');

INSERT INTO products (vendorCode, product_name, countProducts, prepayment,deliveryProductDate, order_id) VALUES
  (1, 'product1', 1, 10001,'2016-05-10', 1),
  (2, 'product2', 2, 20002,'2016-05-11', 2),
  (3, 'product3', 3, 30003,'2016-05-12', 3),
  (4, 'product4', 4, 40004,'2016-05-13', 4);


INSERT INTO locals (localname) VALUES
  ('Local1'),
  ('Local2'),
  ('место3');


INSERT INTO currentstatus (statusName, statusDate, product_id, id) VALUES
  ('Обработан', '2016-05-10', 1, 1000),
  ('Заказан', '2016-05-11', 2, 1001),
  ('Проверен_и_отложен', '2016-05-12', 3, 1002),
  ('Обработан', '2016-05-13', 4, 1003),
  ('Не_заказан', '2016-05-13', 4, 1003),
  ('Заказан', '2016-05-13', 4, 1003),
  ('Отсутствует', '2016-05-13', 4, 1003),
  ('Проверен_и_отложен', '2016-05-13', 4, 1003),
  ('Дозвон', '2016-05-13', 4, 1003),
  ('Не_Звонили', '2016-05-13', 4, 1003),
  ('Дозвон', '2016-05-13', 4, 1003),
  ('Не_выдан', '2016-05-13', 4, 1003),
  ('Дозвон', '2016-05-13', 1, 1003),
  ('Выдан', '2016-05-13', 2, 1003),
  ('Отменен', '2016-05-13', 3, 1003);



