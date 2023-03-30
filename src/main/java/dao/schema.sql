CREATE TABLE IF NOT EXISTS PRODUCT (
    product_Id varchar(50) not null,
    name varchar(50) not null,
    description varchar(5000),
    category varchar(50) not null,
    list_Price decimal(10,2) not null,
    quantity_In_Stock decimal(10,2) not null, 
   
    constraint product primary key (product_Id)
);

CREATE TABLE IF NOT EXISTS CUSTOMER (
    customer_Id Integer auto_increment (1000), 
    username varchar(50) not null unique,
    firstName varchar(50) not null,
    surname varchar(50) not null, 
    password varchar(50) not null, 
    emailAddress varchar(70) not null,
    shippingAddress varchar(120) not null,
    
    
    constraint customer primary key (customer_id)
);

CREATE TABLE IF NOT EXISTS SALE (
    saleId Integer auto_increment (1000), 
    localDateTime  varchar not null, 
    status varchar(40) not null, 
    customerId Integer,
    constraint sale_customer_fk foreign key (customerId) references Customer,
    constraint sale primary key (saleId)
);

CREATE TABLE IF NOT EXISTS SALE_ITEM (
    saleId integer not null, 
    quantityPurchased decimal(5,2) not null,
    sale_price decimal(5,2) not null,
    productId varchar(50) not null,
    constraint sale_item primary key (saleId, productId),
    constraint sale_Item_fk foreign key (saleId) references Sale,
    constraint sale_item_fk_product foreign key(productId) references Product
);
 
