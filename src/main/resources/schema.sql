create table t_coffee (
                          id bigint not null auto_increment,
                          name varchar(255),
                          price bigint not null,
                          create_time timestamp,
                          update_time timestamp,
                          primary key (id)
);
create table t_class (
    id int not null auto_increment,
    name varchar(255),
    teacher_id int not null,
    primary key (id)
);
create table t_student
(
    id         int not null auto_increment,
    name       varchar(255),
    class_id   int not null,
    primary key (id)
);
create table t_teacher(
    id int not null auto_increment,
    name varchar(255),
    primary key (id)
);

insert into t_teacher(name) values ("teacherW");
insert into t_teacher(name) values ("teacherLI");

insert into t_class(name,teacher_id) values("English",1);
insert into t_class(name,teacher_id) values("Math",1);
insert into t_class(name,teacher_id) values("Chines",2);
insert into t_class(name,teacher_id) values("Music",2);

insert into t_student(name,class_id) values("studentOne",1);
insert into t_student(name,class_id) values("studentTwo",1);
insert into t_student(name,class_id) values("studentThree",2);
insert into t_student(name,class_id) values("studentFour",2);










