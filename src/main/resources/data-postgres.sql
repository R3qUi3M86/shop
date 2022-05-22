INSERT INTO public.category(department, description, name)
VALUES ('hardware','A tablet computer, commonly shortened to tablet, is a thin, flat mobile computer with a touchscreen display.','Tablets');
INSERT INTO public.category(department, description, name)
VALUES ('hardware', 'A small, portable personal computer (PC) with a screen and alphanumeric keyboard.', 'Laptops');
INSERT INTO public.category(department, description, name)
VALUES ('hardware', 'A portable device that combines mobile telephone and computing functions into one unit.', 'Smartphones');

INSERT INTO public.supplier(description, name)
VALUES ('Digital content and services','Amazon');
INSERT INTO public.supplier(description, name)
VALUES ('Computers','Lenovo');
INSERT INTO public.supplier(description, name)
VALUES ('Steve Jobs is cool','Apple');

INSERT INTO public.product(default_currency, default_price, description, name, category_id, supplier_id)
VALUES ('USD', 49.9,'Fantastic price. Large content ecosystem. Good parental controls. Helpful technical support.','Amazon Fire',1,1);
INSERT INTO public.product(default_currency, default_price, description, name, category_id, supplier_id)
VALUES ('USD', 479,'Keyboard cover is included. Fanless Core m5 processor. Full-size USB ports. Adjustable kickstand.','Lenovo IdeaPad Miix 700',1,2);
INSERT INTO public.product(default_currency, default_price, description, name, category_id, supplier_id)
VALUES ('USD', 89,'Amazon''s latest Fire HD 8 tablet is a great value for media consumption.','Amazon Fire HD 8',1,1);
INSERT INTO public.product(default_currency, default_price, description, name, category_id, supplier_id)
VALUES ('USD', 50.1,'Cool Phone','Iphone 11',3,3);
INSERT INTO public.product(default_currency, default_price, description, name, category_id, supplier_id)
VALUES ('USD', 455.1,'Even Better','Iphone 11 Pro',3,3);
INSERT INTO public.product(default_currency, default_price, description, name, category_id, supplier_id)
VALUES ('USD',0.1,'Im cheap','MAC 13',3,2);
INSERT INTO public.product(default_currency, default_price, description, name, category_id, supplier_id)
VALUES ('USD',999.99,'worth it','Laptop Lenovo IdeaPad',2,2);
INSERT INTO public.product(default_currency, default_price, description, name, category_id, supplier_id)
VALUES ('USD',111,'wow','Amazon Laptop',2,1);
INSERT INTO public.product(default_currency, default_price, description, name, category_id, supplier_id)
VALUES ('USD',456.1,'Even Better','Amazon Phone',3,1);

INSERT INTO public.user(email, password, user_name)
VALUES ('stiepan','spiepan@yahoo.com', 'qwe');