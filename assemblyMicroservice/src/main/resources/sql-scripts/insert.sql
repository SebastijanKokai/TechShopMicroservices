truncate table product_type;
truncate table product;
truncate table assembly;
truncate table order_product;
truncate table order_item;
truncate table customer;
truncate table deliverer;
truncate table employee;

--employee table
insert into employee (name, last_name, contact) values ('Mladen', 'Marinkovic', '066-666-33-20');
insert into employee (name, last_name, contact) values ('Mirko', 'Markovic', '066-666-33-21');
insert into employee (name, last_name, contact) values ('Marinko', 'Lebovic', '066-666-33-22');
insert into employee (name, last_name, contact) values ('Petar', 'Stanojevic', '066-666-33-23');
insert into employee (name, last_name, contact) values ('Slobodan', 'Ilic', '066-666-33-24');
insert into employee (name, last_name, contact) values ('Marko', 'Stokic', '066-666-33-25');
insert into employee (name, last_name, contact) values ('Aleksandar', 'Kostic', '066-666-33-26');

-- product_type table
insert into product_type (name) values ('Graficka kartica');
insert into product_type (name) values ('Procesor');
insert into product_type (name) values ('RAM');
insert into product_type (name) values ('Maticna ploca');
insert into product_type (name) values ('Napajanje');
insert into product_type (name) values ('Racunar');
insert into product_type (name) values ('Laptop');

-- product table
insert into product (name, available, product_type) values ('Kingston DDR4 4GB', 150, 3);
insert into product (name, available, product_type) values ('Kingston DDR4 8GB', 50, 3);
insert into product (name, available, product_type) values ('AMD FX-6300', 2, 2);
insert into product (name, available, product_type) values ('AMD FX-5500', 10, 2);
insert into product (name, available, product_type) values ('GeForce 1050 Ti', 5, 1);
insert into product (name, available, product_type) values ('GeForce MX 110', 5, 1);
insert into product (name, available, product_type) values ('GeForce MX 150', 5, 1);
insert into product (name, available, product_type) values ('Laptop 1', 5, 7);
insert into product (name, available, product_type) values ('Laptop 2', 5, 7);

-- assembly table
insert into assembly(assembly_id,part_id,quantity) values (8,7,1);
insert into assembly(assembly_id,part_id,quantity) values (8,1,2);
insert into assembly(assembly_id,part_id,quantity) values (8,3,1);
insert into assembly(assembly_id,part_id,quantity) values (9,4,1);
insert into assembly(assembly_id,part_id,quantity) values (9,2,1);
insert into assembly(assembly_id,part_id,quantity) values (9,6,1);


-- order_product table
insert into order_product (order_date, price, customer_id, deliverer_id, employee_id) values ('2012-03-03', 202.3, 1, 2, 2);
insert into order_product (order_date, price, customer_id, deliverer_id, employee_id) values ('2012-04-30', 202.3, 1, 3, 3);
insert into order_product (order_date, price, customer_id, deliverer_id, employee_id) values ('2012-08-24', 210.3, 1, 2, 3);
insert into order_product (order_date, price, customer_id, deliverer_id, employee_id) values ('2013-03-23', 218, 1, 3, 2);
insert into order_product (order_date, price, customer_id, deliverer_id, employee_id) values ('2014-02-04', 313, 1, 4, 5);
insert into order_product (order_date, price, customer_id, deliverer_id, employee_id) values ('2014-05-05', 120, 1, 5, 5);
insert into order_product (order_date, price, customer_id, deliverer_id, employee_id) values ('2014-06-21', 440, 1, 1, 1);
insert into order_product (order_date, price, customer_id, deliverer_id, employee_id) values ('2014-07-17', 500, 1, 2, 6);
insert into order_product (order_date, price, customer_id, deliverer_id, employee_id) values ('2015-07-13', 111.1, 1, 3, 6);
insert into order_product (order_date, price, customer_id, deliverer_id, employee_id) values ('2015-07-14', 150, 1, 6, 3);
insert into order_product (order_date, price, customer_id, deliverer_id, employee_id) values ('2015-07-15', 160, 2, 3, 4);
insert into order_product (order_date, price, customer_id, deliverer_id, employee_id) values ('2016-01-18', 170, 2, 4, 1);
insert into order_product (order_date, price, customer_id, deliverer_id, employee_id) values ('2016-02-19', 180, 2, 5, 2);
insert into order_product (order_date, price, customer_id, deliverer_id, employee_id) values ('2017-03-21', 190, 3, 6, 3);
insert into order_product (order_date, price, customer_id, deliverer_id, employee_id) values ('2017-04-22', 200, 3, 7, 4);
insert into order_product (order_date, price, customer_id, deliverer_id, employee_id) values ('2018-05-25', 215.4, 3, 8, 4);
insert into order_product (order_date, price, customer_id, deliverer_id, employee_id) values ('2019-06-26', 218.3, 4, 9, 4);
insert into order_product (order_date, price, customer_id, deliverer_id, employee_id) values ('2020-07-29', 199.99, 4, 1, 5);
insert into order_product (order_date, price, customer_id, deliverer_id, employee_id) values ('2020-08-31', 299.99, 5, 2, 6);
insert into order_product (order_date, price, customer_id, deliverer_id, employee_id) values ('2020-08-22', 399.99, 5, 3, 7);

-- order_item table
insert into order_item (product_id, order_id, quantity) values (1, 1, 1);
insert into order_item (product_id, order_id, quantity) values (2, 1, 2);
insert into order_item (product_id, order_id, quantity) values (3, 2, 3);
insert into order_item (product_id, order_id, quantity) values (4, 2, 4);
insert into order_item (product_id, order_id, quantity) values (5, 3, 1);
insert into order_item (product_id, order_id, quantity) values (1, 3, 2);
insert into order_item (product_id, order_id, quantity) values (2, 4, 1);
insert into order_item (product_id, order_id, quantity) values (3, 4, 1);
insert into order_item (product_id, order_id, quantity) values (4, 5, 1);
insert into order_item (product_id, order_id, quantity) values (5, 6, 2);
insert into order_item (product_id, order_id, quantity) values (1, 7, 2);
insert into order_item (product_id, order_id, quantity) values (2, 8, 2);
insert into order_item (product_id, order_id, quantity) values (3, 9, 2);
insert into order_item (product_id, order_id, quantity) values (4, 9, 2);
insert into order_item (product_id, order_id, quantity) values (5, 9, 3);
insert into order_item (product_id, order_id, quantity) values (1, 9, 3);
insert into order_item (product_id, order_id, quantity) values (2, 9, 4);
insert into order_item (product_id, order_id, quantity) values (3, 10, 5);
insert into order_item (product_id, order_id, quantity) values (4, 11, 6);
insert into order_item (product_id, order_id, quantity) values (5, 12, 1);
insert into order_item (product_id, order_id, quantity) values (6, 13, 2);
insert into order_item (product_id, order_id, quantity) values (7, 14, 3);
insert into order_item (product_id, order_id, quantity) values (7, 15, 3);
insert into order_item (product_id, order_id, quantity) values (7, 16, 5);
insert into order_item (product_id, order_id, quantity) values (1, 16, 1);
insert into order_item (product_id, order_id, quantity) values (2, 17, 1);
insert into order_item (product_id, order_id, quantity) values (3, 18, 1);
insert into order_item (product_id, order_id, quantity) values (4, 19, 1);
insert into order_item (product_id, order_id, quantity) values (5, 20, 1);
insert into order_item (product_id, order_id, quantity) values (6, 20, 2);
insert into order_item (product_id, order_id, quantity) values (1, 20, 2);

--deliverer table
insert into deliverer (company_name, address, contact) values ('BEX', 'Kisacka 48', '021234432');
insert into deliverer (company_name, address, contact) values ('City Express', 'Rumenacki put 148', '021239672');
insert into deliverer (company_name, address, contact) values ('AKS EXPRESS', 'Zmaj Jovina 34', '021114432');
insert into deliverer (company_name, address, contact) values ('LuMa Pro Sped', 'Kanalska 12', '021299932');
insert into deliverer (company_name, address, contact) values ('FLES DOSTAVA', 'Cika Stevina 4', '021222432');
insert into deliverer (company_name, address, contact) values ('IK Speditor Transport & Logistics', 'Bulevar Jase Tomica 48', '021230032');
insert into deliverer (company_name, address, contact) values ('Excellent Cargo', 'Kisacka 8', '021234608');
insert into deliverer (company_name, address, contact) values ('MILVIT DOO', 'Kornelija Stankovica 86', '021756432');
insert into deliverer (company_name, address, contact) values ('POST EXPRESS', 'Kisacka 48', '021994432');

--customer table
insert into customer (name, last_name, contact, address) values ('Pera', 'Peric', '066112233', 'Vojvodjanska 4');
insert into customer (name, last_name, contact, address) values ('Ivana', 'Ilic', '064112233', 'Kratka 65');
insert into customer (name, last_name, contact, address) values ('Marko', 'Maric', '061112233', 'Svetozara Miletica 14');
insert into customer (name, last_name, contact, address) values ('Ilija', 'Ilicic', '060112233', 'Kralja Petra I 12');
insert into customer (name, last_name, contact, address) values ('Marina', 'Ivic', '062112233', 'Sremska 89');
insert into customer (name, last_name, contact, address) values ('Sanja', 'Sanjic', '066342233', 'Nikole Pasica 34');
insert into customer (name, last_name, contact, address) values ('Petar', 'Petrovic','066772233', 'Svetog Save 22');


