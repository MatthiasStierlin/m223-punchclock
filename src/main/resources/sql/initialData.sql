/*
This file gets executed every single that the application is rerun.
Created on: 16.11.2020
By: Matthias Stierlin
 */
insert into project (name, description) values ('Excalibur', 'This is a secret project!');
insert into project (name, description) values ('Cicada 3301', 'Our recruiting project.');
insert into project (name, description) values ('CIA_Brute_Force', 'We are developing a brute forcing tool for the CIA.');

insert into section (name, description) values ('HR','HR stands for Human Resources.');
insert into section (name, description) values ('Billing','Billing sends the bills to our customers.');
insert into section (name, description) values ('Priority Management','They handle our most loyal customers.');
insert into section (name, description) values ('Post','The smallest section in our company. Good old granny Martha is the only employee of the section.');
insert into section (name, description) values ('Management','The bosses of the company.');

insert into entry (check_in, check_out) values ('2020-11-19 11:12:00','2020-11-19 11:12:00');
insert into entry (check_in, check_out) values ('2020-11-19 11:12:00','2020-01-25 11:12:00');
insert into entry (check_in, check_out) values ('2020-11-08 10:42:00','2020-11-19 11:12:00');
insert into entry (check_in, check_out) values ('2020-11-06 12:22:00','2020-11-19 11:12:00');
insert into entry (check_in, check_out) values ('2020-11-04 11:12:00','2020-11-19 11:12:00');

insert into application_user (username, password, section_section_id) values ('max.muster','test@test.ch',1);
insert into application_user (username, password, section_section_id) values ('peter.mueller','test@test.ch',2);
insert into application_user (username, password, section_section_id) values ('lili.koch','test@test.ch',3);
insert into application_user (username, password, section_section_id) values ('jamie.oliver','test@test.ch',5);
insert into application_user (username, password, section_section_id) values ('test.test','test@test.ch',3);
insert into application_user (username, password, section_section_id) values ('martha.sutter','test@test.ch',4);

insert into section_application_user (section_section_id, application_user_id) values ('1','1');
insert into section_application_user (section_section_id, application_user_id) values ('2','2');
insert into section_application_user (section_section_id, application_user_id) values ('3','3');
insert into section_application_user (section_section_id, application_user_id) values ('5','4');
insert into section_application_user (section_section_id, application_user_id) values ('3','5');
insert into section_application_user (section_section_id, application_user_id) values ('4','6');

insert into application_user_project (application_user_id, project_projectid) values ('4','1');
insert into application_user_project (application_user_id, project_projectid) values ('4','2');
insert into application_user_project (application_user_id, project_projectid) values ('4','3');
insert into application_user_project (application_user_id, project_projectid) values ('6','2');
insert into application_user_project (application_user_id, project_projectid) values ('5','1');
insert into application_user_project (application_user_id, project_projectid) values ('5','2');

