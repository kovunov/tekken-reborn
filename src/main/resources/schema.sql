create table if not exists fighter (
  id identity,
  name varchar(50) not null,
  damage_per_hit int not null,
  health int not null,
  resistance double not null,
  anime_from varchar(50) not null,
  created_at timestamp not null
);