INSERT INTO companies (name)
SELECT 'Company ' || x
FROM SYSTEM_RANGE(1, 100);

-- Вставка пассажиров
INSERT INTO passengers (name)
SELECT 'Passenger ' || x
FROM SYSTEM_RANGE(1, 100);

-- Вставка рейсов
INSERT INTO trips (company, plane, town_from, town_to, time_out, time_in)
SELECT
    MOD(x, 100) + 1,
    CASE
        WHEN MOD(x, 5) = 0 THEN 'Boeing 777'
        WHEN MOD(x, 4) = 0 THEN 'Airbus A321'
        WHEN MOD(x, 3) = 0 THEN 'Boeing 737'
        WHEN MOD(x, 2) = 0 THEN 'Airbus A320'
        ELSE 'Embraer 190'
    END,
    CASE MOD(x, 10)
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
    CASE MOD(x + 3, 10)
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
    DATEADD('DAY', x, TIMESTAMP '2026-03-01 08:00:00'),
    DATEADD('DAY', x, TIMESTAMP '2026-03-01 10:00:00')
FROM SYSTEM_RANGE(1, 120);

-- Вставка посадок пассажиров
INSERT INTO pass_in_trip (passenger, trip, place)
SELECT
    MOD(x, 100) + 1,
    MOD(x, 120) + 1,
    CHAR(65 + MOD(x, 6)) || (MOD(x, 30) + 1)
FROM SYSTEM_RANGE(1, 200);