# Player schema
# --- !Ups
CREATE TABLE Player (
  id serial,
  username varchar(256),
  password varchar(256),
  highscore int,
  preferred_address varchar(256),
  addresses varchar(256)[]
);
# --- !Downs
DROP TABLE Player;

# Word schema
# --- !Ups
CREATE TABLE Word (
  id serial,
  content varchar(32)
);
# --- !Downs