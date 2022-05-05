create table category
(
    id                   bigint auto_increment
        primary key,
    active               bit          not null,
    category_description varchar(255) null,
    code                 varchar(255) null,
    hexa_color           varchar(255) null,
    icon                 varchar(255) null,
    name                 varchar(255) null,
    ordination           int          null,
    study_guide          varchar(255) null
)
    auto_increment = 6;

create table profile
(
    id   bigint auto_increment
        primary key,
    name varchar(255) null
)
    auto_increment = 3;

create table subcategory
(
    id                      bigint auto_increment
        primary key,
    active                  bit          not null,
    code                    varchar(255) null,
    name                    varchar(255) null,
    ordination              int          null,
    study_guide             varchar(255) null,
    subcategory_description varchar(255) null,
    category_id             bigint       null,
    constraint FKe4hdbsmrx9bs9gpj1fh4mg0ku
        foreign key (category_id) references category (id)
)
    auto_increment = 9;

create table course
(
    id                 bigint auto_increment
        primary key,
    active             bit          not null,
    code               varchar(255) null,
    course_description varchar(255) null,
    course_time_hours  int          null,
    developed_skills   varchar(255) null,
    instructor         varchar(255) null,
    name               varchar(255) null,
    target_audience    varchar(255) null,
    subcategory_id     bigint       null,
    constraint FK7nvhqkx7a103mlbo624cxm6t6
        foreign key (subcategory_id) references subcategory (id)
)
    auto_increment = 15;

create table section
(
    id          bigint auto_increment
        primary key,
    active      bit          not null,
    code        varchar(255) null,
    name        varchar(255) null,
    ordination  int          not null,
    test_status bit          not null,
    course_id   bigint       null,
    constraint FKoy8uc0ftpivwopwf5ptwdtar0
        foreign key (course_id) references course (id)
);

create table explanation
(
    id                   bigint       not null
        primary key,
    code                 varchar(255) null,
    ordination           int          not null,
    status               bit          not null,
    title                varchar(255) null,
    section_id           bigint       null,
    activity_explanation varchar(255) null,
    constraint FK_g4yaf57vif4vt4gct70mnfqoi
        foreign key (section_id) references section (id)
);

create table question
(
    id                   bigint       not null
        primary key,
    code                 varchar(255) null,
    ordination           int          not null,
    status               bit          not null,
    title                varchar(255) null,
    section_id           bigint       null,
    question_description varchar(255) null,
    question_type        varchar(255) null,
    constraint FK_dyisjpgv8bmnrhy8t72lloed3
        foreign key (section_id) references section (id)
);

create table alternative
(
    id                   bigint auto_increment
        primary key,
    answer               varchar(255) null,
    answer_check         bit          not null,
    answer_justification varchar(255) null,
    ordination           int          not null,
    question_explanation varchar(255) null,
    question_id          bigint       null,
    constraint FKoxl3ycb9i75i3ibkrqquy7h8s
        foreign key (question_id) references question (id)
);

create table user
(
    id       bigint auto_increment
        primary key,
    email    varchar(255) null,
    password varchar(255) null
)
    auto_increment = 3;

create table profile_users
(
    profiles_id bigint not null,
    users_id    bigint not null,
    constraint FKjxqbwita6kl7k5d28px39bijl
        foreign key (users_id) references user (id),
    constraint FKp1sa7m4q8sduu5cexeqyjry2b
        foreign key (profiles_id) references profile (id)
);

create table video
(
    id                bigint       not null
        primary key,
    code              varchar(255) null,
    ordination        int          not null,
    status            bit          not null,
    title             varchar(255) null,
    section_id        bigint       null,
    video_description varchar(255) null,
    video_time        int          not null,
    video_url         varchar(255) null,
    constraint FK_9plr1ju3p20cqby10jdvr0uh5
        foreign key (section_id) references section (id)
);
