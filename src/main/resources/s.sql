CREATE TABLE `Habits` (
  `id_habit` integer PRIMARY KEY,
  `id_user` integer,
  `name` varchar(255),
  `id_cat_category` integer,
  `desciption` varchar(255),
  `created_at` date,
  `modified_at` date,
  `last_day` date,
  `total_days` integer,
  `id_cat_priority` integer
);


INSERT INTO HABITS (id_habit,id_user,name,id_cat_category,desciption,created_at,modified_at,last_day,total_days,id_cat_priority) 
VALUES (1,1,'Prueba',1,'Hola mundo', '2024-11-05','2024-11-05','2024-11-05',1,1); 