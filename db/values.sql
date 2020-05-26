insert into database_architecture (name,max_width_of_column_name,max_width_of_table_name,max_width_of_relationship_name)values('MySQl',64,64,64);
insert into database_architecture (name,max_width_of_column_name,max_width_of_table_name,max_width_of_relationship_name)values('Oracle',128,128,128);

//insert into database_architecture (name,max_width_of_column_name,max_width_of_table_name,max_width_of_relationship_name)values('Microsoft SQL Server',64,64,64);
//insert into database_architecture (name,max_width_of_column_name,max_width_of_table_name,max_width_of_relationship_name)values('SqLite',64,64,64);

insert into database_engine (database_architecture_code,name) values(1,"PERFORMANCE_SCHEMA");
insert into database_engine (database_architecture_code,name) values(1,"InnoDB");
insert into database_engine (database_architecture_code,name) values(1,"MRG_MYISAM");
insert into database_engine (database_architecture_code,name) values(1,"BLACKHOLE");
insert into database_engine (database_architecture_code,name) values(1,"MyISAM");

insert into database_engine (database_architecture_code,name) values(2,"InnoDB");


//---------------------------
insert into database_architecture_data_type (database_architecture_code,data_type,max_width,default_size,max_width_of_precision,allow_auto_increment) values (1,'CHAR',255,1,0,0);
insert into database_architecture_data_type (database_architecture_code,data_type,max_width,default_size,max_width_of_precision,allow_auto_increment) values (1,'VARCHAR',255,1,0,0);
insert into database_architecture_data_type (database_architecture_code,data_type,max_width,default_size,max_width_of_precision,allow_auto_increment) values (1,'INT',11,4,11,1);
insert into database_architecture_data_type (database_architecture_code,data_type,max_width,default_size,max_width_of_precision,allow_auto_increment) values (1,'FLOAT',24,4,11,1);
insert into database_architecture_data_type (database_architecture_code,data_type,max_width,default_size,max_width_of_precision,allow_auto_increment) values (1,'DOUBLE',16,8,11,0);

