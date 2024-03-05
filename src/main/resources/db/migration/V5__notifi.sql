create table notifications
(
    id      bigint      NOT NULL AUTO_INCREMENT,
    user_id bigint(100) not null,
    text    text        not null,
    primary key (id),
    foreign key (user_id) references users (id)
);

