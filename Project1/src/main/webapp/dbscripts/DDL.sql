create table world.employee (
	id int(20) not null,
	name varchar(20),
    salary double(5,2),
    CONSTRAINT PK_ID PRIMARY KEY (id)
    );
    
create table world.FILE_DATA (
	FILE_ID int(20), 
    FILE_CONTENT blob, 
    TEMP_FLAG varchar(1)
    ); 
