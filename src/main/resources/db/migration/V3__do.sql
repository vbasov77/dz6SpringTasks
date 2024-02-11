create table do
(
    id            bigint NOT NULL AUTO_INCREMENT,
    task_id       bigint not null,
    performer_id bigint not null,
    primary key (id),
    foreign key (task_id) references tasks(id)
);

INSERT INTO do (id, task_id, performer_id)
VALUES (1, 1, 3),
       (2, 3, 2),
       (3, 1, 1),
       (4, 2, 4);

