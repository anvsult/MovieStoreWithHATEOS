insert into languages (languageid,name) Values (1,'English');
insert into languages (languageid,name) Values (2,'French');


insert into directors(directorid, name, dob, country, imageURL) values ('1001', 'Steven Spielberg', '1946-12-18', 'United States', 'https://upload.wikimedia.org/wikipedia/commons/6/67/Steven_Spielberg_by_Gage_Skidmore.jpg');
insert into directors(directorid, name, dob, country, imageURL) values ('2500', 'Tim Burton', '1958-08-23', 'United States', 'https://hips.hearstapps.com/hmg-prod/images/tim-burton-9542431-1-402.jpg');
insert into directors(directorid, name, dob, country, imageURL) values ('3000', 'Lewis Teague', '1938-03-08', 'United States', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTZ1oyF-Hrc-nPOQ4mH-q5baSZWaUCvLwY55wRgorAjaUlUsXmb');
insert into directors(directorid, name, dob, country, imageURL) values ('3500', 'The Wachowskis', '1965-06-21', 'United States', 'https://geekwithclipons.files.wordpress.com/2020/09/img_9020.jpg');
insert into directors(directorid, name, dob, country, imageURL) values ('4000', 'Garry Marshall', '1934-11-13', 'United States', 'https://media-cldnry.s-nbcnews.com/image/upload/newscms/2016_29/1629106/160719-garry-marshall-mbe-1118p.jpg');

insert into movies (movieid, title, releaseyear, posterurl, directorid, languageid) values ('101', 'E.T. The Extra-Terrestrial', 1982, 'https://m.media-amazon.com/images/M/MV5BMTQ2ODFlMDAtNzdhOC00ZDYzLWE3YTMtNDU4ZGFmZmJmYTczXkEyXkFqcGdeQXVyMTQxNzMzNDI@._V1_FMjpg_UX1000_.jpg', '1001', 1);
insert into movies (movieid, title, releaseyear, posterurl, directorid, languageid) values ('102', 'Cujo', 1983, 'https://upload.wikimedia.org/wikipedia/en/8/8a/CujoVHScover.jpg', '3000', 1);
insert into movies (movieid, title, releaseyear, posterurl, directorid, languageid) values ('105', 'Edward Scissorhands', 1990, 'https://upload.wikimedia.org/wikipedia/en/3/3b/Edwardscissorhandsposter.JPG', '2500', 1);
insert into movies (movieid, title, releaseyear, posterurl, directorid, languageid) values ('210','The Matrix', 1999, 'https://resizing.flixster.com/hTz9Ap43sCkvDiFvCkjmb1IWkUg=/ems.cHJkLWVtcy1hc3NldHMvbW92aWVzL2EwMGEwNmQxLTE1MGYtNGQwYS04ZDhlLWQ0MzYwOTQ5M2JlMC5qcGc=', '3500', 2);
insert into movies (movieid, title, releaseyear, posterurl, directorid, languageid) values ('225', 'Jaws', 1975, 'https://s3.amazonaws.com/static.rogerebert.com/uploads/movie/movie_poster/jaws-1975/large_l1yltvzILaZcx2jYvc5sEMkM7Eh.jpg', '1001', 1);
insert into movies (movieid, title, releaseyear, posterurl, directorid, languageid) values ('999', 'Pretty Woman', 1990, 'https://upload.wikimedia.org/wikipedia/en/b/b6/Pretty_woman_movie.jpg', '4000', 2);
insert into movies (movieid, title, releaseyear, posterurl, directorid, languageid) values ('423', 'Beetlejuice', 1988, 'https://upload.wikimedia.org/wikipedia/en/7/76/Beetlejuice_%281988_film_poster%29.png', '2500', 1);


