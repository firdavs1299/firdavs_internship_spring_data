drop table if exists interns;
drop table if exists employees;
drop table if exists users;
drop table if exists roles;

create table interns(
	id int primary key,
	firstname varchar(100),
	lastname varchar(100),
	age int,
	hobby varchar(100)
);

create table employees(
	id int primary key,
	firstname varchar(100),
	lastname varchar(100),
	position varchar(100)
);

create table roles(
	id int primary key,
	role varchar(100),
	name varchar(100)
);


create table users(
	id int primary key,
	name varchar(100),
	surname varchar(100),
	age int,
	email varchar(100),
	password varchar(100),
	role_id int,
	isactive boolean,
	foreign key(role_id) references roles(id)
);

create view users_with_role as 
select 	u.id,
		u.name,
		u.surname,
		u.age, 
		u.email, 
		u.password,
		u.role_id,
		u.isactive,
		r.role, 
		r.name as role_name 
		from users as 
		u inner join roles as r on u.role_id=r.id;

insert into roles(id, role, name) values(1, 'ADMIN', 'Админ');
insert into roles(id, role, name) values(2, 'MANAGER', 'Менеджер');
insert into roles(id, role, name) values(3, 'MENTOR', 'Ментор');



insert into users(id, name, surname, age, email, password, role_id, isactive) values(1, 'Фирдавс', 'Фозилов', 23, 'firdavs.1299@mail.ru', '$2a$10$njkyJCXGqmuQyTERdJQSP.qlp8uD.xTa5GsjuahqWEbp4OlZUey6q', 1, true);
insert into users(id, name, surname, age, email, password, role_id, isactive) values(2, 'Анна', 'Иванова', 32, 'anna1344@gmail.com', '$2a$10$njkyJCXGqmuQyTERdJQSP.qlp8uD.xTa5GsjuahqWEbp4OlZUey6q', 2, true);
insert into users(id, name, surname, age, email, password, role_id, isactive) values(3, 'Александр', 'Уткин', 44, 'sasha9988@yandex.ru', '$2a$10$njkyJCXGqmuQyTERdJQSP.qlp8uD.xTa5GsjuahqWEbp4OlZUey6q', 2, true);
insert into users(id, name, surname, age, email, password, role_id, isactive) values(4, 'Ирина', 'Огурцова', 21, 'irina0099@mail.ru', '$2a$10$njkyJCXGqmuQyTERdJQSP.qlp8uD.xTa5GsjuahqWEbp4OlZUey6q', 1, true);
insert into users(id, name, surname, age, email, password, role_id, isactive) values(5, 'Евгений', 'Алексеев', 20, 'jenya8977@gmail.com', '$2a$10$njkyJCXGqmuQyTERdJQSP.qlp8uD.xTa5GsjuahqWEbp4OlZUey6q', 3, true);



insert into interns(id, firstname,lastname,age,hobby) values(1,
	'Николай', 'Огурцов', 54, 'чтение'
);

insert into interns(id, firstname,lastname,age,hobby) values(2,
	'Алексей', 'Козлов', 23, 'катание на велосипеде'
);

insert into interns(id, firstname,lastname,age,hobby) values(3,
	'Александр', 'Макаров', 50, 'готовка еды'
);

insert into interns(id,firstname,lastname,age,hobby) values(4,
	'Кирил', 'Чесноков', 26, 'изучение истории'
);

insert into interns(id,firstname,lastname,age,hobby) values(5,
	'Сергей', 'Алексеев', 23, 'шахматы'
);

insert into interns(id,firstname,lastname,age,hobby) values(6,
	'Олег', 'Собалев', 29, 'изучение языков'
);

insert into interns(id,firstname,lastname,age,hobby) values(7,
	'Иван', 'Рашидов', 32, 'геология'
);

insert into interns(id,firstname,lastname,age,hobby) values(8,
	'Артем', 'Терешков', 43, 'плавание'
);

insert into interns(id,firstname,lastname,age,hobby) values(9,
	'Юлия', 'Андреева', 46, 'готовка мороженного'
);

insert into interns(id,firstname,lastname,age,hobby) values(10,
	'Кристина', 'Белкова', 25, 'компьютерные игры'
);






insert into employees(id,firstname,lastname, position) values(1,
	'Александра', 'Огурцова', 'программист'
);

insert into employees(id,firstname,lastname,position) values(2,
	'Полина', 'Козлова', 'администратор баз данных'
);

insert into employees(id,firstname,lastname,position) values(3,
	'Камила', 'Макарова', 'администратор сетей'
);

insert into employees(id,firstname,lastname,position) values(4,
	'Анастасия', 'Чеснокова', 'DevOps'
);

insert into employees(id,firstname,lastname,position) values(5,
	'Георгий', 'Алексеев', 'менеджер'
);

insert into employees(id,firstname,lastname,position) values(6,
	'Лена', 'Собалева', 'директор'
);

insert into employees(id,firstname,lastname,position) values(7,
	'Наталья', 'Рашидова', 'бухгалтер'
);

insert into employees(id,firstname,lastname,position) values(8,
	'Галина', 'Терешкова', 'заместитель директора'
);

insert into employees(id,firstname,lastname,position) values(9,
	'Вероника', 'Андреева', 'технический специалист'
);

insert into employees(id,firstname,lastname,position) values(10,
	'Любовь', 'Белкова', 'оператор'
);