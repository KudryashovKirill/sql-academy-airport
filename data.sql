INSERT INTO company (name) VALUES
('Airline 1'),
('Airline 2'),
('Airline 3'),
('Airline 4'),
('Airline 5'),
('Airline 6'),
('Airline 7'),
('Airline 8'),
('Airline 9'),
('Airline 10'),
('Airline 11'),
('Airline 12'),
('Airline 13'),
('Airline 14'),
('Airline 15'),
('Airline 16'),
('Airline 17'),
('Airline 18'),
('Airline 19'),
('Airline 20'),
('Airline 21'),
('Airline 22'),
('Airline 23'),
('Airline 24'),
('Airline 25'),
('Airline 26'),
('Airline 27'),
('Airline 28'),
('Airline 29'),
('Airline 30'),
('Airline 31'),
('Airline 32'),
('Airline 33'),
('Airline 34'),
('Airline 35'),
('Airline 36'),
('Airline 37'),
('Airline 38'),
('Airline 39'),
('Airline 40'),
('Airline 41'),
('Airline 42'),
('Airline 43'),
('Airline 44'),
('Airline 45'),
('Airline 46'),
('Airline 47'),
('Airline 48'),
('Airline 49'),
('Airline 50'),
('Airline 51'),
('Airline 52'),
('Airline 53'),
('Airline 54'),
('Airline 55'),
('Airline 56'),
('Airline 57'),
('Airline 58'),
('Airline 59'),
('Airline 60'),
('Airline 61'),
('Airline 62'),
('Airline 63'),
('Airline 64'),
('Airline 65'),
('Airline 66'),
('Airline 67'),
('Airline 68'),
('Airline 69'),
('Airline 70'),
('Airline 71'),
('Airline 72'),
('Airline 73'),
('Airline 74'),
('Airline 75'),
('Airline 76'),
('Airline 77'),
('Airline 78'),
('Airline 79'),
('Airline 80'),
('Airline 81'),
('Airline 82'),
('Airline 83'),
('Airline 84'),
('Airline 85'),
('Airline 86'),
('Airline 87'),
('Airline 88'),
('Airline 89'),
('Airline 90'),
('Airline 91'),
('Airline 92'),
('Airline 93'),
('Airline 94'),
('Airline 95'),
('Airline 96'),
('Airline 97'),
('Airline 98'),
('Airline 99'),
('Airline 100'),
('Airline 101'),
('Airline 102'),
('Airline 103'),
('Airline 104'),
('Airline 105'),
('Airline 106'),
('Airline 107'),
('Airline 108'),
('Airline 109'),
('Airline 110');

INSERT INTO trip (company, plane, town_from, town_to, time_out, time_in)
SELECT
    gs,
    CASE
        WHEN gs % 5 = 0 THEN 'Boeing 777'
        WHEN gs % 4 = 0 THEN 'Airbus A321'
        WHEN gs % 3 = 0 THEN 'Boeing 737'
        WHEN gs % 2 = 0 THEN 'Airbus A320'
        ELSE 'Embraer 190'
    END,
    CASE (gs % 10)
        WHEN 0 THEN 'Berlin'
        WHEN 1 THEN 'Paris'
        WHEN 2 THEN 'Rome'
        WHEN 3 THEN 'Madrid'
        WHEN 4 THEN 'London'
        WHEN 5 THEN 'Vienna'
        WHEN 6 THEN 'Prague'
        WHEN 7 THEN 'Amsterdam'
        WHEN 8 THEN 'Lisbon'
        ELSE 'Athens'
    END,
    CASE ((gs + 3) % 10)
        WHEN 0 THEN 'Berlin'
        WHEN 1 THEN 'Paris'
        WHEN 2 THEN 'Rome'
        WHEN 3 THEN 'Madrid'
        WHEN 4 THEN 'London'
        WHEN 5 THEN 'Vienna'
        WHEN 6 THEN 'Prague'
        WHEN 7 THEN 'Amsterdam'
        WHEN 8 THEN 'Lisbon'
        ELSE 'Athens'
    END,
    TIMESTAMP '2026-03-01 08:00:00' + (gs || ' days')::interval,
    TIMESTAMP '2026-03-01 10:00:00' + (gs || ' days')::interval
FROM generate_series(1,110) AS gs;

INSERT INTO passenger (name)
SELECT
    CASE (gs % 10)
        WHEN 0 THEN 'John'
        WHEN 1 THEN 'Emma'
        WHEN 2 THEN 'Liam'
        WHEN 3 THEN 'Olivia'
        WHEN 4 THEN 'Noah'
        WHEN 5 THEN 'Ava'
        WHEN 6 THEN 'Lucas'
        WHEN 7 THEN 'Mia'
        WHEN 8 THEN 'Ethan'
        ELSE 'Sophia'
    END
    || ' ' ||
    CASE (gs % 10)
        WHEN 0 THEN 'Smith'
        WHEN 1 THEN 'Johnson'
        WHEN 2 THEN 'Williams'
        WHEN 3 THEN 'Brown'
        WHEN 4 THEN 'Jones'
        WHEN 5 THEN 'Garcia'
        WHEN 6 THEN 'Miller'
        WHEN 7 THEN 'Davis'
        WHEN 8 THEN 'Wilson'
        ELSE 'Taylor'
    END
    || ' #' || gs
FROM generate_series(1,300) AS gs;

INSERT INTO pass_in_trip (trip, passenger, place)
SELECT
    (random() * 109 + 1)::int AS trip_id,
    (random() * 299 + 1)::int AS passenger_id,
    ( (random()*29 + 1)::int ||
      CHR(65 + (random()*5)::int) ) AS place
FROM generate_series(1,600)
ON CONFLICT DO NOTHING;