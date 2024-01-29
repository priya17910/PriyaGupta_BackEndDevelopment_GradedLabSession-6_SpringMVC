insert into roles values (1, "ADMIN");
insert into roles values (2, "USER");

-- Username: "testadmin" ; Password: "adminpassword" --
insert into users values (1, "$2a$12$ey/NrL1C2/Kd1y.h1cZ/eO617HDUJksdjVtrEaz2gWXEIVJm3iMhi", "testadmin");
-- Username: "testuser" ; Password: "userpassword" --
insert into users values (2, "$2a$12$ytSwAXH8Bi14BJxcc.6svuPGzeDQG/odYDMObtc6BaGlpgEAyNYHS", "testuser");

insert into users_roles values (1, 1);
insert into users_roles values (2, 2);