create table approved_order
(
  id         bigint auto_increment
    primary key,
  user_id    bigint       null,
  answer     varchar(255) null,
  numberRoom int          null,
  cost_room  bigint       null,
  constraint FKsoog5orp3cr4u265chi9o19a
    foreign key (user_id) references orders_users (id),
  constraint FKtndi681jqmaogaiwf1qj0ff8l
    foreign key (cost_room) references cost_rooms (id)
);
create table cost_room
(
  id   bigint auto_increment
    primary key,
  cost int null
);
create table denied_order
(
  id      bigint auto_increment
    primary key,
  user_id bigint       null,
  answer  varchar(255) null,
  constraint FK1fd2t0g62hsw5nluh4pcpns0k
    foreign key (user_id) references orders_users (id)
);
create table login_user
(
  id         bigint auto_increment
    primary key,
  user_login varchar(255) null,
  password   varchar(255) null,
  user_id    bigint       null,
  constraint UK_hbtcs91ah0gpgj5eq72pr9xi7
    unique (user_login),
  constraint FKj952evru5ofpxnbylfs4hpr09
    foreign key (user_id) references users (id)
);
create table new_order
(
  id             bigint auto_increment
    primary key,
  name_room      varchar(255) null,
  number_of_beds varchar(255) null,
  user_login     varchar(255) null
);
create table order_user
(
  id             bigint auto_increment
    primary key,
  name_room      varchar(255) null,
  number_of_beds varchar(255) null,
  user_login     varchar(255) null
);
create table room
(
  room_id     bigint auto_increment
    primary key,
  beds        varchar(255) null,
  name        varchar(255) null,
  number_room varchar(255) null
);
create table user_order_room
(
  user_login bigint not null,
  room_id    bigint not null,
  constraint FKhaan6jlxkh978h8g8s17ei4om
    foreign key (room_id) references rooms (room_id),
  constraint FKsldkw1ta3qqnwvqabefysqgq9
    foreign key (user_login) references login_users (id)
);
create table user
(
  id      bigint auto_increment
    primary key,
  name    varchar(255) null,
  phone   varchar(255) null,
  surname varchar(255) null
);

insert into schema_for_project_final.rooms (name, beds, number_room)
values ("standart",1,101),("family room",4,102),("standart",4,103),("family room",5,104),("standart",3,105),
       ("family room",3,106),("standart",1,107),("standart",2,108),("family room",4,109),("standart",2,110),
       ("standart",1,201),("family room",5,202),("family room",3,203),("standart",2,204),("standart",2,205),
       ("family room",4,206),("standart",1,207),("standart",3,208),("standart",4,209),("family room",4,210),
       ("standart",2,301),("family room",5,302),("honeymoon suite",2,303),("suite",1,304),("honeymoon suite",2,305),
       ("family room",6,306),("standart",4,307),("family room",6,308),("standart",2,309),("standart",1,310),
       ("suite",4,401),("senior suite",4,402),("standart",2,403),("family room",6,404),("senior suite",2,405),
       ("family room",4,406),("honeymoon suite",2,407),("family room",4,408),("senior suite",2,409),("suite",3,410),
       ("honeymoon suite",2,501),("suite",2,502),("senior suite",2,503),("suite",2,504),("honeymoon suite",2,505),
       ("senior suite",1,506),("standart",1,507),("honeymoon suite",2,508),("suite",1,509),("standart",1,510),
       ("honeymoon suite",2,601),("senior suite",3,602),("standart",4,603),("senior suite",2,604),("honeymoon suite",2,605),
       ("suite",4,606),("senior suite",2,607),("suite",2,608),("royal suite",6,609),("suite",4,610),
       ("honeymoon suite",2,701),("royal suite",5,702),("suite",4,703),("presidential suite",1,704),("senior suite",4,705),
       ("senior suite",4,706),("presidential suite",2,707),("royal suite",3,708),("honeymoon suite",2,709),("presidential suite",4,710);