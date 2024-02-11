create table tasks
(
    id          bigint       NOT NULL AUTO_INCREMENT,
    description varchar(500) not null,
    status      varchar(100) not null,
    created_at  datetime     NOT NULL DEFAULT CURRENT_TIMESTAMP,
    primary key (id)
);

INSERT INTO tasks (id, description, status)
VALUES
    (1, 'Повесить картину', 'завершено'),
    (2, 'Забить гвоздь', 'в процессе'),
    (3, 'Покрасить', 'не начата'),
    (4, 'Сходить в магазин', 'не начата');

