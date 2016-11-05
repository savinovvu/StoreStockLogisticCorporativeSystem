DELETE FROM users;
DELETE FROM orders;
DELETE FROM products;


INSERT INTO users (id, userName, roles, active) VALUES
  (1000, 'name1', 'ADMIN', TRUE ),
  (1001, 'name2', 'COMMANDER', TRUE ),
  (1002, 'name3', 'LOGISTIC', TRUE ),
  (1003, 'name4', 'VENDOR',TRUE ),
  (1004, 'name4', 'VENDOR', FALSE );


INSERT INTO orders (order_id, startDateTime) VALUES
  (10000, '2016-05-10 10:00:00'),
  (10001, '2016-05-11 10:00:00'),
  (10002, '2016-05-12 10:00:00'),
  (10003, '2016-05-13 10:00:00');


INSERT INTO products (product_id, product_name, startDateTime, order_id) VALUES
  (10000, 'product1', '2016-05-10 10:00:00', 10000),
  (10001, 'product2', '2016-05-11 10:00:00', 10001),
  (10002, 'product3', '2016-05-12 10:00:00', 10002),
  (10003, 'product4', '2016-05-13 10:00:00', 10003);


