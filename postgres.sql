SELECT * FROM users;

INSERT INTO users(name,email,password,role)
VALUES(
'Hasini',
'annamhasini16@gmail.com',
'123',
'USER'
);

INSERT INTO events
(title, description, event_date, start_time, end_time, venue, capacity)
VALUES
(
'Dance',
'College Event',
'2026-06-15',
'10:00:00',
'12:00:00',
'Ground',
100
);

INSERT INTO events
(title, description, event_date, start_time, end_time, venue, capacity)
VALUES
(
'Singing',
'Fest',
'2026-07-03',
'08:30:00',
'09:00:00',
'Auditorium',
200
);

SELECT * FROM events;

SELECT * FROM events WHERE id = 9;

SELECT * FROM registrations;

UPDATE users
SET role='USER' 
WHERE email='annamhasini16@gmail.com';

SELECT * FROM users;