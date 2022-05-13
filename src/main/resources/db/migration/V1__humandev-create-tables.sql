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
);

create table profile
(
    id   bigint auto_increment
        primary key,
    name varchar(255) null
);

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
        foreign key (category_id) references category (id)
);

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
        foreign key (subcategory_id) references subcategory (id)
);

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
        foreign key (question_id) references question (id)
);

create table user
(
    id       bigint auto_increment
        primary key,
    email    varchar(255) null,
    password varchar(255) null
);

create table profile_users
(
    profiles_id bigint not null,
    users_id    bigint not null,
        foreign key (users_id) references user (id),
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
        foreign key (section_id) references section (id)
);
