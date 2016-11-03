DELETE FROM product_price;


INSERT INTO product_price (productName,  productPrice , validFrom  , validTo) VALUES
    ('name1', 10, null , null  ),
    ('name2', 15, null ,'2015-03-01'),
    ('name2', 20, '2015-03-02' ,'2015-03-10'),
    ('name2', 25, '2015-03-15' ,null);

