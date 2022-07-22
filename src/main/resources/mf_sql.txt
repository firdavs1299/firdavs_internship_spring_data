create database firdavs_internship;
\c firdavs_internship;
create table interns(
	id serial primary key,
	firstname varchar(100),
	lastname varchar(100),
	age int,
	hobby varchar(100)
);

create table employees(
	id serial primary key,
	firstname varchar(100),
	lastname varchar(100),
	position varchar(100)
);

insert into interns(firstname,lastname,age,hobby) values(
	'Николай', 'Огурцов', 54, 'чтение'
);

insert into interns(firstname,lastname,age,hobby) values(
	'Алексей', 'Козлов', 23, 'катание на велосипеде'
);

insert into interns(firstname,lastname,age,hobby) values(
	'Александр', 'Макаров', 50, 'готовка еды'
);

insert into interns(firstname,lastname,age,hobby) values(
	'Кирил', 'Чесноков', 26, 'изучение истории'
);

insert into interns(firstname,lastname,age,hobby) values(
	'Сергей', 'Алексеев', 23, 'шахматы'
);

insert into interns(firstname,lastname,age,hobby) values(
	'Олег', 'Собалев', 29, 'изучение языков'
);

insert into interns(firstname,lastname,age,hobby) values(
	'Иван', 'Рашидов', 32, 'геология'
);

insert into interns(firstname,lastname,age,hobby) values(
	'Артем', 'Терешков', 43, 'плавание'
);

insert into interns(firstname,lastname,age,hobby) values(
	'Юлия', 'Андреева', 46, 'готовка мороженного'
);

insert into interns(firstname,lastname,age,hobby) values(
	'Кристина', 'Белкова', 25, 'компьютерные игры'
);






insert into employees(firstname,lastname, position) values(
	'Александра', 'Огурцова', 'программист'
);

insert into employees(firstname,lastname,position) values(
	'Полина', 'Козлова', 'администратор баз данных'
);

insert into employees(firstname,lastname,position) values(
	'Камила', 'Макарова', 'администратор сетей'
);

insert into employees(firstname,lastname,position) values(
	'Анастасия', 'Чеснокова', 'DevOps'
);

insert into employees(firstname,lastname,position) values(
	'Георгий', 'Алексеев', 'менеджер'
);

insert into employees(firstname,lastname,position) values(
	'Лена', 'Собалева', 'директор'
);

insert into employees(firstname,lastname,position) values(
	'Наталья', 'Рашидова', 'бухгалтер'
);

insert into employees(firstname,lastname,position) values(
	'Галина', 'Терешкова', 'заместитель директора'
);

insert into employees(firstname,lastname,position) values(
	'Вероника', 'Андреева', 'технический специалист'
);

insert into employees(firstname,lastname,position) values(
	'Любовь', 'Белкова', 'оператор'
);