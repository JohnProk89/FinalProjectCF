INSERT INTO games (id, name, genre, created_at) VALUES
                                            (1,'Crash Bandicoot','platformer', now()),
                                            (2,'Nier Automata','jrpg',  now()),
                                            (3,'Counter Strike','fps', now()),
                                            (4,'Hades','roguelike', now()),
                                            (5,'Resident Evil','horror', now()),
                                            (6,'PUBG','fps', now()),
                                            (7,'TEKKEN','fighting', now()),
                                            (8,'Silent Hill 2','horror', now());
ALTER TABLE games AUTO_INCREMENT = 9;