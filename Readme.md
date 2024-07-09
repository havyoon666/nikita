docker volume create departments_data

docker run --name departments-postgres \
-e POSTGRES_DB=departments \
-e POSTGRES_USER=manager \
-e POSTGRES_PASSWORD=password \
-v departments_data:/var/lib/postgresql/data \
-p 5432:5432 \
-d postgres

create table if not exists public.departments
(
id          integer not null
constraint departments_pk
primary key,
name        text,
description text
);

alter table public.departments
owner to manager;

