insert into account (id, username, email) values
(1, 'user', 'user@jeff-life.com'),
(2, 'user1', 'user1@jeff-life.com');

insert into role (id, role) values
(1, 'USER'),
(2, 'ADMIN');

insert into account_role (account_id, role_id) values
(1, 1), (1, 2), (2, 1);

insert into charactor (dtype, id, name, state) values
('player', 1, '액션가면', 'NORMAL'),
('player', 2, 'test1234', 'CHARACTER_CREATE1'),
('non_player', 3, '안내원', 'NORMAL'),
('non_player', 4, '전자동 대련 기계', 'NORMAL');

insert into player (id, account_id) values
(1, 1),
(2, 2);

insert into non_player (id, is_attackable, description) values
(3, 0, '단정한 유니폼을 입고 있다.'),
(4, 1, '가벼운 금속 파이프와 각종 모터로 만들어진 전투 훈련용 기계이다.');

insert into stat (charactor_id, type, value) values
(1, 'STR',75), (1, 'CON', 75), (1, 'SIZ', 75), (1, 'INT', 75), (1, 'POW', 75), (1, 'DEX', 75), (1, 'APP', 75), (1, 'EDU', 75),
(2, 'STR', 75), (2, 'CON', 75), (2, 'SIZ', 75), (2, 'INT', 75), (2, 'POW', 75), (2, 'DEX', 75), (2, 'APP', 75), (2, 'EDU', 75),
(3, 'STR', 75), (3, 'CON', 75), (3, 'SIZ', 75), (3, 'INT', 75), (3, 'POW', 75), (3, 'DEX', 75), (3, 'APP', 75), (3, 'EDU', 75),
(4, 'STR', 50), (4, 'CON', 75), (4, 'SIZ', 50), (4, 'INT', 0), (4, 'POW', 0), (4, 'DEX', 25), (4, 'APP', 10), (4, 'EDU', 5);

insert into status (charactor_id, hp, mp, move_rate) values
(1, 15, 15, 30), (2, 15, 15, 30), (3, 15, 15, 30), (4, 10, 0, 30);

insert into skill (charactor_id, type, point) values
(1, '격투', 50),
(4, '격투', 50);

insert into charactor_bag (id, charactor_id) values
(1, 1), (2, 2), (3, 3), (4, 4);

insert into room (id, summary, description) values
(1, '테스트 중앙', '흰 빛으로 가득한 공간입니다.'),
(2, '테스트 동쪽', '흰 빛으로 가득한 공간입니다.'),
(3, '테스트 서쪽', '흰 빛으로 가득한 공간입니다.'),
(4, '테스트 남쪽', '흰 빛으로 가득한 공간입니다.'),
(5, '테스트 북쪽', '흰 빛으로 가득한 공간입니다.');

insert into charactor_room (charactor_id, room_id) values
(1, 1), (2, 1), (3, 1), (4, 1);

insert into door (id, is_locked) values
(1, 0), (2, 0), (3, 0), (4, 1), (5, 1);

insert into wayout (room_id, door_id, direction, next_room_id) values
(1, 1, 'EAST', 2),
(2, 1, 'WEST', 1),
(1, 2, 'WEST', 3),
(3, 2, 'EAST', 1),
(1, 3, 'SOUTH', 4),
(4, 3, 'NORTH', 1),
(1, 4, 'NORTH', 5),
(5, 4, 'SOUTH', 1);

insert into item (dtype, id, name, description, is_getable, grade) values
('key', 1, '북쪽 열쇠', '북쪽문을 열 수 있는 열쇠이다.', true, 'COMMON'),
('container', 2, '서랍', '하얀 플라스틱으로 만들어진 1단 서랍이다.', false, 'COMMON'),
('key', 3, '남쪽 열쇠', '남쪽문을 열 수 있는 열쇠이다.', true, 'COMMON'),
('container', 4, '낡은 금고', '페인트가 벗겨지고 녹이슨 철제 금고이다.', false, 'COMMON'),
('key', 5, '금고 열쇠', '낡은 금고 열쇠이다.', true, 'COMMON');

insert into keey (id) values
(1), (3), (5);

insert into container (id, door_id) values
(2, null), (4, 5);

insert into equipment (charactor_id) values
(1), (4);

insert into key_door (key_id, door_id) values
(1, 4),
(3, 3),
(5, 5);

insert into item_broker (dtype, id, item_id) values
('room', 1, 1),
('container', 2, 5),
('room', 3, 2),
('room', 4, 4),
('container', 5, 3);

insert into item_broker_room(id, room_id) values
(1, 1),
(3, 1),
(4, 1);

insert into item_broker_container(id, container_id) values
(2, 2),
(5, 4);
