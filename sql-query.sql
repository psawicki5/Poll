CREATE TABLE poll.Question (
	ID int NOT NULL AUTO_INCREMENT,
    questionText varchar(255) NOT NULL,
    pubDate varchar(32),
    primary key (ID)
);

CREATE TABLE poll.Choice (
	ID int not null AUTO_INCREMENT,
	question_id int not null,
    choice_text varchar(255),
    votes int default 0,
    primary key (ID),
    foreign key (question_id) references Question(ID)
);