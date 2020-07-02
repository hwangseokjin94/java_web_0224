create table products
(
    products_idx number primary key,  -- 제품번호
    products_name varchar2(100),  -- 제품명
    stock number,  -- 재고
    price number,  -- 가격
    products_image varchar2(100)  -- 대표이미지
);

create table users
(
    users_idx number primary key,
    users_name varchar2(100),
    users_id varchar2(100),
    users_pw varchar2(100)
);

create table orders 
(
    orders_idx number primary key,  -- 주문번호
    users_idx number references users(users_idx),  -- 고객번호
    orders_date date,  -- 주문일자
    totalprice number,  -- 총금액
    orders_state varchar2(100)  -- 처리상태
);

create table orderdetail
(
    orderdetail_idx number primary key,  -- 주문상세번호
    orders_idx number references orders(orders_idx),  -- 주문번호
    products_idx number references products(products_idx),  -- 제품번호
    amount number  -- 주문수량
);
    