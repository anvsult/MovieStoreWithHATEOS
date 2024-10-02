DROP TABLE IF EXISTS movies;
DROP TABLE IF EXISTS directors;
DROP TABLE IF EXISTS languages;

create table languages
(
    id         INT                                             NOT NULL AUTO_INCREMENT,
    languageId INT NOT NULL UNIQUE,
    name       VARCHAR(20)                                     NOT NULL,
    PRIMARY KEY (id)
);

create table directors (
                           id INT NOT NULL AUTO_INCREMENT,
                           directorid VARCHAR(36) NOT NULL UNIQUE,
                           name VARCHAR(255) NOT NULL,
                           dob DATE NOT NULL,
                           country VARCHAR(255) NOT NULL,
                           imageurl VARCHAR(255),
                           PRIMARY KEY (id)

);

create table movies (
                        id INT NOT NULL AUTO_INCREMENT,
                        movieid VARCHAR(36) NOT NULL UNIQUE,
                        title VARCHAR(255) NOT NULL,
                        releaseyear INT NOT NULL,
                        posterurl VARCHAR(255),
                        directorid VARCHAR(36) NOT NULL,
                        languageid INT NOT NULL,
                        PRIMARY KEY (id),
                        FOREIGN KEY (directorid) references directors(directorid),
                        FOREIGN KEY (languageid) references languages(languageid)
);

