insert into area (id, name, type) values
(1, '테스트 지역', 'OPEN_MAP');

insert into room (id, summary, description, floor_id) values
(1, '테스트 중앙', '흰 빛으로 가득한 공간입니다.', 1),
(2, '테스트 동쪽', '흰 빛으로 가득한 공간입니다.', 2),
(3, '테스트 서쪽', '흰 빛으로 가득한 공간입니다.', 3),
(4, '테스트 남쪽', '흰 빛으로 가득한 공간입니다.', 4),
(5, '테스트 북쪽', '흰 빛으로 가득한 공간입니다.', 5);

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

insert into floor (id) values
(1),
(2),
(3),
(4),
(5);

insert into bag (id) values
(1);

insert into player (id, name, room_id, bag_id) values
(1, '테스트 플레이어', 1, 1);

insert into item (id, name, description, is_gettable, grade, type) values
(1, '돌멩이', '주먹만하고 흙이 묻어 있는 돌멩이이다.', true, 'COMMON', 'ETC'),
(2, '손전등', '검은색 메탈 재질의 손잡이가 있는 LCD 손전등이다.', true, 'COMMON', 'ETC');

insert into item_broker (id, item_id, dtype) values
(1, 1, 'floor'),
(2, 2, 'bag');

insert into floor_item_broker (id, floor_id) values
(1, 1);

insert into bag_item_broker (id, bag_id) values
(2, 1);