create table customer(
customerId integer not null,
customerName varchar(255) not null,
customerAccountType varchar(255),
primary key(customerId)
);

I
INSERT INTO customer (customerId, customerName, customerAccountType ) 
VALUES(10001,  'Raza', 'Hyderabad');
INSERT INTO customer (customerId, customerName, customerAccountType ) 
VALUES(10002,  'Sindhu', 'Pune');
INSERT INTO customer (customerId, customerName, customerAccountType ) 
VALUES(10003,  'nitro', 'SouthIndian');

