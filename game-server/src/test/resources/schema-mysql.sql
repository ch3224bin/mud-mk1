create table account (id bigint not null auto_increment, username varchar(255) not null,
    email varchar(255) not null, provider varchar(255) not null, primary key (id));
alter table account add constraint UK_ACCOUNT_USERNAME unique(username);
alter table account add constraint UK_ACCOUNT_EMAIL unique(email);

create table role (id bigint not null auto_increment, role varchar(255), primary key (id));

create table account_role (account_id bigint not null, role_id bigint not null);
alter table account_role add constraint FK_ACCOUNT_ROLE_01 foreign key (role_id) references role(id);
alter table account_role add constraint FK_ACCOUNT_ROLE_02 foreign key (account_id) references account(id);

create table charactor (dtype varchar(31) not null, id bigint not null auto_increment,
	name varchar(255) not null, state varchar(255) not null, primary key (id));
alter table charactor add constraint UK_CHARACTOR_NAME unique (name);

create table player (id bigint not null auto_increment, account_id bigint, is_online boolean default false not null, primary key (id));
alter table player add constraint FK_PLAYER_01 foreign key (account_id) references account(id);

create table non_player (is_attackable boolean, id bigint not null, description varchar(1000), primary key (id));
alter table non_player add constraint FK_NON_PLAYER_01 foreign key (id) references charactor(id);

create table stat (id bigint not null auto_increment, type varchar(255) not null,
	value integer not null, charactor_id bigint not null, primary key (id));
alter table stat add constraint FK_STAT_01 foreign key (charactor_id) references charactor(id);

create table status (id bigint not null auto_increment, hp integer, mp integer, charactor_id bigint not null,
	move_rate int(3), luck int(3) default 15, primary key (id));
alter table status add constraint FK_STATUS_01 foreign key (charactor_id) references charactor(id);

create table skill (id bigint not null auto_increment, point int(3) not null, type varchar(255) not null, charactor_id bigint not null, primary key (id));
alter table skill add constraint FK_SKILL_01 foreign key (charactor_id) references charactor(id);

create table charactor_bag (id bigint not null auto_increment, charactor_id bigint not null, primary key (id));
alter table charactor_bag add constraint UK_CHARACTOR_BAG_CHARACTOR_ID unique (charactor_id);
alter table charactor_bag add constraint FK_CHARACTOR_BAG_01 foreign key (charactor_id) references charactor(id);

create table room (id bigint not null auto_increment, description varchar(255) not null, summary varchar(255) not null, primary key (id));

create table area (id bigint not null auto_increment, name varchar(255) not null, type varchar(255) not null, primary key (id));
create table area_room (area_id bigint not null, room_id bigint not null);
alter table area_room add constraint UK_AREA_ROOM_ROOM_ID unique (room_id);
alter table area_room add constraint FK_AREA_ROOM_01 foreign key (room_id) references room(id);
alter table area_room add constraint FK_AREA_ROOM_02 foreign key (area_id) references area(id);

create table charactor_room (room_id bigint, charactor_id bigint not null, primary key (charactor_id));
alter table charactor_room add constraint FK_CHARACTOR_ROOM_01 foreign key (room_id) references room(id);
alter table charactor_room add constraint FK_CHARACTOR_ROOM_02 foreign key (charactor_id) references charactor(id);

create table door (id bigint not null auto_increment, is_locked boolean not null, primary key (id));

create table wayout (id bigint not null auto_increment,
	direction varchar(255) not null, room_id bigint not null,
	next_room_id bigint not null, door_id bigint not null, is_show boolean default true not null, primary key (id));
alter table wayout add constraint FK_WAYOUT_01 foreign key (room_id) references room(id);
alter table wayout add constraint FK_WAYOUT_02 foreign key (next_room_id) references room(id);
alter table wayout add constraint FK_WAYOUT_03 foreign key (door_id) references door(id);

create table item (dtype varchar(31) not null,
	id bigint not null auto_increment,
	description varchar(255) not null,
	is_getable boolean default true not null,
	name varchar(255) not null,
	grade varchar(255) not null, primary key (id));

create table keey (id bigint not null, primary key (id));
alter table keey add constraint FK_KEEY_01 foreign key (id) references item(id);

create table container (id bigint not null, door_id bigint, primary key (id));
alter table container add constraint FK_CONTAINER_01 foreign key (id) references item(id);
alter table container add constraint FK_CONTAINER_02 foreign key (door_id) references door(id);

create table weapon (count int(3) not null, sided int(3) not null,
	bonus int(2) not null,
	weapon_type varchar(255) not null, critical boolean default false not null,
	id bigint not null, primary key (id));
alter table weapon add constraint FK_WEAPON_01 foreign key (id) references item(id);

create table equipment (id bigint not null auto_increment, charactor_id bigint not null, weapon_id bigint, primary key (id));
alter table equipment add constraint FK_EQUIPMENT_01 foreign key (charactor_id) references charactor(id);
alter table equipment add constraint FK_EQUIPMENT_02 foreign key (weapon_id) references weapon(id);

create table key_door (door_id bigint not null, key_id bigint not null);
alter table key_door add constraint FK_KEY_DOOR_01 foreign key (key_id) references keey(id);
alter table key_door add constraint FK_KEY_DOOR_02 foreign key (door_id) references door(id);

create table item_broker (dtype varchar(31) not null,
	id bigint not null auto_increment,
	item_id bigint not null, primary key (id));
alter table item_broker add constraint UK_ITEM_BROKER_ITEM_ID unique (item_id);
alter table item_broker add constraint FK_ITEM_BROKER_01 foreign key (item_id) references item(id);

create table item_broker_charactor_bag (id bigint not null, charactor_bag_id bigint not null, primary key (id));
alter table item_broker_charactor_bag add constraint FK_ITEM_BROKER_CHARACTOR_BAG_01 foreign key (charactor_bag_id) references charactor_bag(id);
alter table item_broker_charactor_bag add constraint FK_ITEM_BROKER_CHARACTOR_BAG_02 foreign key (id) references item_broker(id);

create table item_broker_room (id bigint not null, room_id bigint not null, primary key (id));
alter table item_broker_room add constraint FK_ITEM_BROKER_ROOM_01 foreign key (room_id) references room(id);
alter table item_broker_room add constraint FK_ITEM_BROKER_ROOM_02 foreign key (id) references item_broker(id);

create table item_broker_container (id bigint not null, container_id bigint not null, primary key (id));
alter table item_broker_container add constraint FK_ITEM_BROKER_CONTAINER_01 foreign key (container_id) references container(id);
alter table item_broker_container add constraint FK_ITEM_BROKER_CONTAINER_02 foreign key (id) references item_broker(id);
