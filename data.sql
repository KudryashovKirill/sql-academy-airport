INSERT INTO good_types (good_type_name) VALUES
('Electronics'),
('Clothing'),
('Books'),
('Toys'),
('Sports'),
('Furniture'),
('Food'),
('Beauty'),
('Stationery'),
('Automotive');

INSERT INTO good_types (good_type_name)
SELECT 'Type ' || g
FROM generate_series(11,100) g;

INSERT INTO goods (good_name, type) VALUES
('Laptop', 1),
('Smartphone', 1),
('T-Shirt', 2),
('Novel', 3),
('Basketball', 5),
('Desk', 6),
('Chocolate', 7),
('Lipstick', 8),
('Notebook', 9),
('Car Battery', 10);

INSERT INTO goods (good_name, type)
SELECT 'Good ' || g, (g % 10) + 1
FROM generate_series(11,100) g;

INSERT INTO family_members (status, member_name, birthday) VALUES
('Active', 'Alice Johnson', '1990-01-15'),
('Inactive', 'Bob Smith', '1985-06-22'),
('Active', 'Charlie Brown', '2000-09-05'),
('Active', 'Diana Prince', '1995-12-12'),
('Inactive', 'Ethan Hunt', '1982-03-03'),
('Active', 'Fiona Apple', '1999-07-19'),
('Active', 'George Martin', '1978-11-11'),
('Inactive', 'Hannah Montana', '2002-05-23'),
('Active', 'Ian McKellen', '1939-05-25'),
('Inactive', 'Jane Doe', '1991-08-08');

INSERT INTO family_members (status, member_name, birthday)
SELECT
  CASE WHEN g % 2 = 0 THEN 'Active' ELSE 'Inactive' END,
  'Member ' || g,
  '2000-01-01'::date + (g || ' days')::interval
FROM generate_series(11,100) g;


INSERT INTO payments (family_member, good, amount, unit_price, date)
SELECT
  (random()*99 + 1)::int,
  (random()*99 + 1)::int,
  (random()*10 + 1)::int,
  (random()*500 + 10)::int,
  NOW() - ((random()*365)::int || ' days')::interval
FROM generate_series(1,100);