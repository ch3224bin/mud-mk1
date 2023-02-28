insert into area (id, name, type) values
(1, '테스트 지역', 'OPEN_MAP');

insert into room (id, summary, description) values
(1, '테스트 중앙', '흰 빛으로 가득한 공간입니다.'),
(2, '테스트 동쪽', '흰 빛으로 가득한 공간입니다.'),
(3, '테스트 서쪽', '흰 빛으로 가득한 공간입니다.'),
(4, '테스트 남쪽', '흰 빛으로 가득한 공간입니다.'),
(5, '테스트 북쪽', '흰 빛으로 가득한 공간입니다.');

insert into area_room (area_id, room_id) values
(1, 1),
(1, 2),
(1, 3),
(1, 4),
(1, 5);

insert into door (id, is_locked) values
(1, 0), (2, 0), (3, 0), (4, 1), (5, 1);

insert into way_out (room_id, door_id, direction, next_room_id) values
(1, 1, 'EAST', 2),
(2, 1, 'WEST', 1),
(1, 2, 'WEST', 3),
(3, 2, 'EAST', 1),
(1, 3, 'SOUTH', 4),
(4, 3, 'NORTH', 1),
(1, 4, 'NORTH', 5),
(5, 4, 'SOUTH', 1);