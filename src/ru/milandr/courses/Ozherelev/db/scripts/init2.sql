create table if not exists players (
  id bigint primary key,
  nickname varchar(60),
  country  varchar(30)
);

/*DELETE FROM players;*/

/*script for true result (just a copy of init1.sql)*/
/*
INSERT INTO "players" (id, nickname, country) VALUES (1, 'Violent Joker', 'Russia Federation');
INSERT INTO "players" (id, nickname, country) VALUES (2, 'Gipermaxi4', 'Russia Federation');
INSERT INTO "players" (id, nickname, country) VALUES (3, 'Inspirarion', 'Russia Federation');
INSERT INTO "players" (id, nickname, country) VALUES (4, 'Korben Dalos', 'Russia Federation');
INSERT INTO "players" (id, nickname, country) VALUES (5, 'Pushkin', 'Russia Federation');
INSERT INTO "players" (id, nickname, country) VALUES (6, 'Emil Zolya', 'Russia Federation');
INSERT INTO "players" (id, nickname, country) VALUES (7, 'Snek', 'Russia Federation');
INSERT INTO "players" (id, nickname, country) VALUES (8, 'shiSava', 'Russia Federation');
INSERT INTO "players" (id, nickname, country) VALUES (9, 'Magicpie', 'Russia Federation');
INSERT INTO "players" (id, nickname, country) VALUES (10, 'King_Kong', 'Russia Federation');
INSERT INTO "players" (id, nickname, country) VALUES (11, 'The nineth wall', 'Russia Federation');
*/

/*script for false result */

INSERT INTO "players" (id, nickname, country) VALUES (1, 'Hitman', 'Russia Federation');
INSERT INTO "players" (id, nickname, country) VALUES (2, 'GiperIgri4', 'Russia Federation');
INSERT INTO "players" (id, nickname, country) VALUES (3, 'Inspirarion', 'Russia Federation');
INSERT INTO "players" (id, nickname, country) VALUES (4, 'Korben Dalos', 'Russia Federation');
INSERT INTO "players" (id, nickname, country) VALUES (5, 'Evgeniy Onegin', 'Russia Federation');
INSERT INTO "players" (id, nickname, country) VALUES (6, 'Emil Zolya', 'Russia Federation');
INSERT INTO "players" (id, nickname, country) VALUES (7, 'Shadow Witch', 'Russia Federation');
INSERT INTO "players" (id, nickname, country) VALUES (8, 'Konek', 'Russia Federation');
INSERT INTO "players" (id, nickname, country) VALUES (9, 'Small Rat', 'Russia Federation');
INSERT INTO "players" (id, nickname, country) VALUES (10, 'King_Kong', 'Russia Federation');
INSERT INTO "players" (id, nickname, country) VALUES (11, 'The ninth wall', 'Russia Federation');
