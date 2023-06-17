-- 1. В подключенном MySQL репозитории создать базу данных “Друзья человека”

DROP DATABASE IF EXISTS human_friends;
CREATE DATABASE IF NOT EXISTS human_friends;
USE human_friends;


-- 2. Создать таблицы с иерархией из диаграммы в БД

CREATE TABLE IF NOT EXISTS animal_types
(
	id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    animal_type VARCHAR(20) NOT NULL
);

CREATE TABLE IF NOT EXISTS dog
(
	id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    animal_name VARCHAR(20) NOT NULL,
    date_birth DATE, -- YYYY-MM-DD
    commands VARCHAR(20),
    animal_type_id int,
    FOREIGN KEY (animal_type_id) REFERENCES animal_types(id)
);

CREATE TABLE IF NOT EXISTS cat
(
	id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    animal_name VARCHAR(20) NOT NULL,
    date_birth DATE,
    commands VARCHAR(20),
    animal_type_id int,
    FOREIGN KEY (animal_type_id) REFERENCES animal_types(id)
);

CREATE TABLE IF NOT EXISTS hamster
(
	id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    animal_name VARCHAR(20) NOT NULL,
    date_birth DATE,
    commands VARCHAR(20),
    animal_type_id int,
    FOREIGN KEY (animal_type_id) REFERENCES animal_types(id)
);

CREATE TABLE IF NOT EXISTS horse
(
	id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    animal_name VARCHAR(20) NOT NULL,
    date_birth DATE,
    commands VARCHAR(20),
    animal_type_id int,
    FOREIGN KEY (animal_type_id) REFERENCES animal_types(id)
);

CREATE TABLE IF NOT EXISTS camel
(
	id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    animal_name VARCHAR(20) NOT NULL,
    date_birth DATE, 
    commands VARCHAR(20),
    animal_type_id int,
    FOREIGN KEY (animal_type_id) REFERENCES animal_types(id)
);

CREATE TABLE IF NOT EXISTS donkey
(
	id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    animal_name VARCHAR(20) NOT NULL,
    date_birth DATE, 
    commands VARCHAR(20),
    animal_type_id int,
    FOREIGN KEY (animal_type_id) REFERENCES animal_types(id)
);


-- 3. Заполнить низкоуровневые таблицы именами(животных), командами которые они выполняют и датами рождения

INSERT animal_types (animal_type) VALUES
('pets'),
('pack_anymals');
SELECT * FROM animal_types;

INSERT dog (animal_name, date_birth, commands, animal_type_id) VALUES
('Dog1', '2020-12-29', 'bite, bark, paw', '1'),
('Dog2', '2010-02-10', 'sit, jump, down', '1'),
('Dog3', '2023-01-01', 'come, drop it', '1');
SELECT * FROM dog;

INSERT cat (animal_name, date_birth, commands, animal_type_id) VALUES
('Cat1', '2019-06-09', 'kis-kis, eat', '1'),
('Cat2', '2016-12-12', 'kis-kis, eat, sleep', '1'),
('Cat3', '2023-04-15', 'kis-kis', '1');
SELECT * FROM cat;

INSERT hamster (animal_name, date_birth, commands, animal_type_id) VALUES
('Hamster1', '2022-08-05', 'run, jump, hide', '1'),
('Hamster2', '2021-01-19', 'run, jump', '1'),
('Hamster3', '2023-05-26', 'empty', '1');
SELECT * FROM hamster;

INSERT horse (animal_name, date_birth, commands, animal_type_id) VALUES
('Horse1', '2015-08-30', 'go, down, back', '2'),
('Horse2', '2017-03-20', 'come, run, stop', '2'),
('Horse3', '2022-07-05', 'go, stop', '2');
SELECT * FROM horse;

INSERT camel (animal_name, date_birth, commands, animal_type_id) VALUES
('Camel1', '2016-08-25', 'go, down, back', '2'),
('Camel2', '2013-01-29', 'run, stop, back', '2'),
('Camel3', '2023-02-07', 'come, stop', '2');
SELECT * FROM camel;

INSERT donkey (animal_name, date_birth, commands, animal_type_id) VALUES
('Donkey1', '2020-04-13', 'go, stop, round', '2'),
('Donkey2', '2020-09-19', 'go, stop, round', '2'),
('Donkey3', '2017-10-15', 'go, stop, round', '2');
SELECT * FROM donkey;


-- 4. Удалив из таблицы верблюдов, т.к. верблюдов решили перевезти в другой питомник на зимовку. 

DELETE FROM camel WHERE animal_type_id = 2;
SELECT * FROM camel;

# DROP TABLE camel; -- второй вариант


-- 5. Объединить таблицы лошади, и ослы в одну таблицу.

CREATE TABLE IF NOT EXISTS  mules
(
id INT PRIMARY KEY AUTO_INCREMENT NOT NULL
)
SELECT animal_name, date_birth, commands, animal_type_id 
FROM horse 
UNION 
SELECT animal_name, date_birth, commands, animal_type_id 
FROM donkey;

 
/*  6.Создать новую таблицу “молодые животные” в которую попадут все
животные старше 1 года, но младше 3 лет и в отдельном столбце с точностью
до месяца подсчитать возраст животных в новой таблице. */

CREATE TABLE IF NOT EXISTS young_animals
(
id INT PRIMARY KEY AUTO_INCREMENT NOT NULL
)
SELECT animal_name, date_birth, commands, animal_type_id 
FROM dog
UNION
SELECT animal_name, date_birth, commands, animal_type_id 
FROM cat
UNION
SELECT animal_name, date_birth, commands, animal_type_id 
FROM hamster
UNION
SELECT animal_name, date_birth, commands, animal_type_id 
FROM mules; -- верблюды переехали, остались ослы и лошади

SELECT id, animal_name, date_birth, commands, animal_type_id, (SELECT TIMESTAMPDIFF(MONTH, date_birth, NOW())) as age_in_month 
FROM young_animals
WHERE (SELECT TIMESTAMPDIFF(MONTH, date_birth, NOW())) > 12 and (SELECT TIMESTAMPDIFF(MONTH, date_birth, NOW())) < 36;


-- 7.Объединить все таблицы в одну, при этом сохраняя поля, указывающие на прошлую принадлежность к старым таблицам
CREATE TABLE IF NOT EXISTS animals
SELECT * FROM dog
UNION ALL
SELECT * FROM cat
UNION ALL
SELECT * FROM hamster
UNION ALL
SELECT * FROM mules

# id у всех животных осталось из старых таблиц
