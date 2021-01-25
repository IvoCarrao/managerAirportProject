
CREATE TABLE airplane(
  id INT NOT NULL ,
  brand VARCHAR(100) NOT NULL,
  yearMade INT NOT NULL,
  isInTheAir boolean NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE airport(
  id   INT NOT NULL,
  city VARCHAR(100) NOT NULL,
  name VARCHAR (100) NOT NULL,
  PRIMARY KEY (id)
);
