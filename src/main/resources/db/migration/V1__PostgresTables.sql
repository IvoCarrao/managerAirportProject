CREATE TABLE airplane(
  id   VARCHAR(24) NOT NULL,
  brand VARCHAR(100) NOT NULL,
  yearMade VARCHAR (4) NOT NULL,
  isInTheAir VARCHAR (5) NOT NULL
);

CREATE TABLE airport(
  id   VARCHAR(24) NOT NULL,
  city VARCHAR(100) NOT NULL,
  name VARCHAR (100) NOT NULL
);