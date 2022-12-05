-- Insertion Querys
-- Fri Nov 18 10:16:18 2022


-- Product Types
INSERT INTO bank_products.productType(name) VALUES ("Cuenta Corriente"),("Seguro Automotriz"),("Cuenta Ahorros"),("Crédito Consumo"),("Crédito Hipotecario"),("Tarjeta Gold"),("Tarjeta Platinum"), ("Tarjeta Infinite");

-- Clients
insert into bank_products.client (id, firstName, lastName, email, username, password) values ('123456789', 'Nicolas', 'Ramirez', 'nico98@a.com', 'nico', 'nico');
insert into bank_products.client (id, firstName, lastName, email, username, password) values ('379545502', 'Tilda', 'Nowell', 'tnowell0@i2i.jp', 'tnowell0', 'beFrKRv6i');
insert into bank_products.client (id, firstName, lastName, email, username, password) values ('332196844', 'Philipa', 'Kemsley', 'pkemsley1@sphinn.com', 'pkemsley1', 'zSxEMvcttR');
insert into bank_products.client (id, firstName, lastName, email, username, password) values ('779372141', 'Erek', 'Frigout', 'efrigout2@auda.org.au', 'efrigout2', 'ceB2cyL');

-- Products
insert into bank_products.product (id, type, idClient) values ('10203040', 1, 123456789);
insert into bank_products.product (id, type, idClient) values ('10203042', 3, 123456789);
insert into bank_products.product (id, type, idClient) values ('22232425', 6, 123456789);
insert into bank_products.product (id, type, idClient) values ('16142223', 3, 379545502);
insert into bank_products.product (id, type, idClient) values ('23456788', 4, 332196844);
insert into bank_products.product (id, type, idClient) values ('24252627', 5, 123456789);