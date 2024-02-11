create table performers
(
    id          bigint       NOT NULL AUTO_INCREMENT,
    name      varchar(100) not null,
    primary key (id)

);

INSERT INTO performers (id, name)
VALUES
    (1, 'Татьяна'),
    (2, 'Альберт'),
    (3, 'Ольга'),
    (4, 'Вадим');

