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

/* @Column(name = "customerName")
    @JsonProperty("customerName")
    private String customerName;

    @Column(name = "customerPhone")
    @JsonProperty("customerPhone")
    private String customerPhone;

    @Column(name = "comment")
    @JsonProperty("comment")*/
INSERT INTO orders (order_id, startDate, active, customerName,customerPhone ,orderComment) VALUES
  (10000, '2016-05-10', TRUE,'customerName1','8(000)000-0001','хороший товар1'),
  (10001, '2016-05-11', TRUE,'customerName2','8(000)000-0002','хороший товар2'),
  (10002, '2016-05-12', TRUE,'customerName3','8(000)000-0003','хороший товар3'),
  (10003, '2016-05-13', TRUE,'customerName4','8(000)000-0004','хороший товар4'),
  (10004, '2016-05-13', TRUE,'customerName5','8(000)000-0005','хороший товар5');

INSERT INTO products (product_id,vendorCode, product_name,  order_id) VALUES
  (10000,1, 'product1',  10000),
  (10001,2, 'product2',  10001),
  (10002,3, 'product3',  10002),
  (10003,4, 'product4',  10003);
/*  (10004, 'product5', '2016-05-13 10:00:00', 10003),
  (10006, 'product6', '2016-05-13 10:00:00', 10003);*/

INSERT INTO locals (localname) VALUES
  ( 'Local1'),
  ( 'Local2'),
  ( 'место3');


INSERT INTO currentstatus (statusId, statusName, statusDate, product_id, id) VALUES
  (1, 'Обработан', '2016-05-10',  10000, 1000),
  (2, 'Заказан', '2016-05-11',  10001, 1001),
  (3, 'Проверен_и_отложен','2016-05-12', 10002, 1002),

  (4, 'Обработан', '2016-05-13',  10003, 1003),
  (5, 'Не_заказан', '2016-05-13',  10003, 1003),
  (6, 'Заказан', '2016-05-13',  10003, 1003),
  (7, 'Отсутствует', '2016-05-13',  10003, 1003),
  (8, 'Проверен_и_отложен', '2016-05-13',  10003, 1003),
  (9, 'Дозвон', '2016-05-13',  10003, 1003),
  (10, 'Не_Звонили', '2016-05-13',  10003, 1003),
  (11, 'Дозвон', '2016-05-13',  10003, 1003),
  (12, 'Не_выдан', '2016-05-13',  10003, 1003),
  (13, 'Выдан', '2016-05-13',  10000, 1003),
  (14, 'Выдан', '2016-05-13',  10001, 1003),
  (15, 'Отменен', '2016-05-13',  10002, 1003);



