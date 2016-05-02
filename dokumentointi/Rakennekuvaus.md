## Rakennekuvaus

TheBoxGame koostuu erilaisista Entityistä sekä niitä hallitsevasta Worldistä.

Luokka Entity sisältää tiedon Entityn x- ja y-koordinaateista, Entityn Tilestä ja jokaisen erityyppisen Entityn yksilöivän id:n. Entityn perii luokka Movable, joka toteuttaa liikkumiseen tarvittavat metodit. Movablen perivät luokat Player ja Box, koska ne ovat pelissä liikkuvat Entityt. Suoraan luokan Entity perivät puolestaan luokat Wall ja Goal, koska niitä ei voida liikuttaa.

Luokka Tile sisältää myös x- ja y-koordinaatit ja siinä mahdollisesti olevan Entityn. Lisäksi jokaiselle Tilelle asetetaan World-luokassa sitä ympäröivät Tilet (up, down, left ja right). Näin on mahdollista löytää tiettyä Tileä seuraava Tile.

Luokka World sisältää kaikki pelissä olevat Entityt ja Tilet. Se huolehtii kaksiulotteisen Tilearrayn muodostamisesta ja lisää jokaiselle Tilelle sitä ympäröivät Tilet. Lisäksi se asettaa kuhunkin Tileen oikean Entityn ja kullekin Entitylle oikean Tilen.

Luokkaa MovingLogic ei ole merkitty luokkakaavioon, sillä sen tehtävänä on pelkästään huolehtia Entityjen liikuttamisesta. Sama pätee sen apuluokille sekä luokalle KeyManager.
