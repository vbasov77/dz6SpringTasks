create table tasks
(
    id          bigint       NOT NULL AUTO_INCREMENT,
    description varchar(500) not null,
    status      varchar(100) not null,
    urgency      integer(10),
    created_at  datetime     NOT NULL DEFAULT CURRENT_TIMESTAMP,
    primary key (id)
);

INSERT INTO tasks (id, description, status, urgency)
VALUES
    (1, 'Повесить картину', 'завершено', 1),
    (2, 'Забить гвоздь', 'в процессе', 0),
    (3, 'Почистить картофель', 'не начата', 1),
    (4, 'Сходить в магазин', 'не начата', 0);

