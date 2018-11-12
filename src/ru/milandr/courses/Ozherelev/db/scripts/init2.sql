create table if not exists players (
  id bigint primary key,
  nickname varchar(60),
  country  varchar(30)
);

/*DELETE FROM players;*/

/*script for true result (just a copy of init1.sql)*/
/*
INSERT INTO "players" (id, nickname, country) VALUES (1, 'Violent Joker', 'Russian Federation');
INSERT INTO "players" (id, nickname, country) VALUES (2, 'Gipermaxi4', 'Russian Federation');
INSERT INTO "players" (id, nickname, country) VALUES (3, 'Inspirarion', 'Russian Federation');
INSERT INTO "players" (id, nickname, country) VALUES (4, 'Korben Dalos', 'Russian Federation');
INSERT INTO "players" (id, nickname, country) VALUES (5, 'Pushkin', 'Russian Federation');
INSERT INTO "players" (id, nickname, country) VALUES (6, 'Emil Zolya', 'Russian Federation');
INSERT INTO "players" (id, nickname, country) VALUES (7, 'Snek', 'Russian Federation');
INSERT INTO "players" (id, nickname, country) VALUES (8, 'shiSava', 'Russian Federation');
INSERT INTO "players" (id, nickname, country) VALUES (9, 'Magicpie', 'Russian Federation');
INSERT INTO "players" (id, nickname, country) VALUES (10, 'King_Kong', 'Russian Federation');
INSERT INTO "players" (id, nickname, country) VALUES (11, 'The nineth wall', 'Russian Federation');
*/

/*script for false result */

INSERT INTO "players" (id, nickname, country) VALUES (1, 'Hitman', 'Russian Federation');
INSERT INTO "players" (id, nickname, country) VALUES (2, 'GiperIgri4', 'Russian Federation');
INSERT INTO "players" (id, nickname, country) VALUES (3, 'Inspirarion', 'Russian Federation');
INSERT INTO "players" (id, nickname, country) VALUES (4, 'Korben Dalos', 'Russian Federation');
INSERT INTO "players" (id, nickname, country) VALUES (5, 'Evgeniy Onegin', 'Russian Federation');
INSERT INTO "players" (id, nickname, country) VALUES (6, 'Emil Zolya', 'Russian Federation');
INSERT INTO "players" (id, nickname, country) VALUES (7, 'Shadow Witch', 'Russian Federation');
INSERT INTO "players" (id, nickname, country) VALUES (8, 'Konek', 'Russian Federation');
INSERT INTO "players" (id, nickname, country) VALUES (9, 'Small Rat', 'Russian Federation');
INSERT INTO "players" (id, nickname, country) VALUES (10, 'King_Kong', 'Russian Federation');
INSERT INTO "players" (id, nickname, country) VALUES (11, 'The ninth wall', 'Russian Federation');
