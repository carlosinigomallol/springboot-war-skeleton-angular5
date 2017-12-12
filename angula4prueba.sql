CREATE TABLE articles ( 
    article_id	int(11) AUTO_INCREMENT NOT NULL,
    title     	varchar(25) NOT NULL,
    category  	varchar(25) NOT NULL,
    entry_date  date NOT NULL,
    complete_entry_date datetime NOT NULL,
    PRIMARY KEY(article_id)
)
GO

