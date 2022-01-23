create table developers(
id serial primary key,
name varchar(50) not null,
age integer not null,
sex varchar(50) not null
);

create table skills(
id serial primary key,
language varchar(50) not null,
skill_rate varchar(50) not null
);

create table dev_to_skills(
id_dev integer not null,
id_skills integer not null,
constraint FK_id_dev foreign key (id_dev) references developers(id),
constraint FK_id_skills foreign key (id_skills) references skills(id)
);

create table projects(
id serial primary key,
name varchar(250) not null,
language varchar(50) not null,
date_added timestamp  default NULL,
cost integer
);

create table dev_to_project(
id_dev integer not null,
id_projects integer not null,
constraint FK_id_dev foreign key (id_dev) references developers(id),
constraint FK_id_projects foreign key (id_projects) references projects(id)
);

create table companies(
id serial primary key,
name varchar(250) not null,
number_of_projects integer
);

create table companies_to_projects(
id_projects integer not null,
id_companies integer not null,
constraint FK_id_projects foreign key (id_projects) references projects(id),
constraint FK_id_companies foreign key(id_companies) references companies(id)
);

create table customers(
id serial primary key,
name varchar(250) not null,
country varchar(250)
);

create table customers_for_projects(
id_customer integer not null,
id_projects integer not null,
constraint FK_id_customer foreign key (id_customer) references customers(id),
constraint FK_id_projects foreign key (id_projects) references projects(id)
);

insert into developers(name, age,sex) values ('Vlad',26,'male');
insert into developers (name, age,sex) values ('Alina', 24, 'female');
insert into developers (name,age,sex) values ('Dariya', 24, 'female');
insert into developers (name, age,sex) values ('Artem', 44, 'male');
insert into developers (name, age,sex) values ('Olena',66,'female');
insert into developers (name, age,sex) values ('Olga', 45, 'female');

insert into skills (language, skill_rate) values ('Java', 'Junior');
insert into skills (language, skill_rate) values ('Javascript', 'Junior');
insert into skills (language, skill_rate) values ('Javascript', 'Middle');
insert into skills (language, skill_rate) values ('Python', 'Middle');
insert into skills (language, skill_rate) values ('Python', 'Senior');
insert into skills (language, skill_rate) values ('Python', 'Junior');

insert into projects (name, language, cost, date_added) values ('Project_1', 'Java', 1000, current_timestamp);
insert into projects (name, language, cost, date_added) values ('Project_2', 'Javascript', 200, current_timestamp);
insert into projects (name, language, cost, date_added) values ('Project_3', 'Java+Javascript',3000, current_timestamp);
insert into projects (name, language, cost, date_added) values ('Project_4', 'Python',2000, current_timestamp);
insert into projects (name, language, cost, date_added) values ('Project_5', 'Python+Java',7000, current_timestamp);
insert into projects (name, language, cost, date_added) values ('Project_6', 'Python+Java',9000, current_timestamp);


insert into companies (name, number_of_projects) values ('Company_1', 2);
insert into companies (name, number_of_projects) values ('Company_2', 3);
insert into companies (name, number_of_projects) values ('Company_3', 5);
insert into companies (name, number_of_projects) values ('Company_4', 7);


insert into customers (name, country) values ('Customer_1', 'Ukraine');
insert into customers (name, country) values ('Customer_2', 'USA');
insert into customers (name, country) values ('Customer_3', 'Canada');
insert into customers (name, country) values ('Customer_4', 'China');
insert into customers (name, country) values ('Customer_5', 'India');
insert into customers (name, country) values ('Customer_6', 'UAE');

insert into dev_to_skills (id_dev, id_skills) values (1,1);
insert into dev_to_skills (id_dev, id_skills) values (2,2);
insert into dev_to_skills (id_dev, id_skills) values (3,3);
insert into dev_to_skills (id_dev, id_skills) values (4,4);
insert into dev_to_skills (id_dev, id_skills) values (5,5);
insert into dev_to_skills (id_dev, id_skills) values (6,6);
insert into dev_to_skills (id_dev, id_skills) values (2,1);
insert into dev_to_skills (id_dev, id_skills) values (3,2);
insert into dev_to_skills (id_dev, id_skills) values (4,3);

insert into dev_to_project (id_dev, id_projects) values (1,1);
insert into dev_to_project (id_dev, id_projects) values (2,2);
insert into dev_to_project (id_dev, id_projects) values (3,3);
insert into dev_to_project (id_dev, id_projects) values (4,4);
insert into dev_to_project (id_dev, id_projects) values (5,5);
insert into dev_to_project (id_dev, id_projects) values (6,6);
insert into dev_to_project (id_dev, id_projects) values (1,2);
insert into dev_to_project (id_dev, id_projects) values (2,3);
insert into dev_to_project (id_dev, id_projects) values (3,4);

insert into companies_to_projects (id_projects, id_companies) values (1,1);
insert into companies_to_projects (id_projects, id_companies) values (2,2);
insert into companies_to_projects (id_projects, id_companies) values (3,3);
insert into companies_to_projects (id_projects, id_companies) values (4,4);
insert into companies_to_projects (id_projects, id_companies) values (5,2);
insert into companies_to_projects (id_projects, id_companies) values (6,3);
insert into companies_to_projects (id_projects, id_companies) values (1,4);

insert into customers_for_projects (id_customer, id_projects) values (1,1);
insert into customers_for_projects (id_customer, id_projects) values (2,2);
insert into customers_for_projects (id_customer, id_projects) values (3,3);
insert into customers_for_projects (id_customer, id_projects) values (4,4);
insert into customers_for_projects (id_customer, id_projects) values (5,1);
insert into customers_for_projects (id_customer, id_projects) values (6,2);