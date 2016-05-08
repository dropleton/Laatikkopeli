## Testausdokumentaatio

Projektini TheBoxGame testaus kattaa kaikkien Entityjen ja pelilogiikan testauksen. Pyrin kirjoittamaan testit niin kattaviksi kuin mahdollista. En kuitenkaan voinut mutaatiotestata kirjoittamiani testejä, sillä aloitettuani projektin puhtaalta pöydältä en saanut enää generoitua pit-raportteja kovasta yrityksestä huolimatta. Myös Chekcstyle-raportit lopettivat toimimasta JavaDocin tarkistuksen lisäyksen yhteydessä. Lähetin tästä sähköpostia ohjaajille, mutten ehtinyt saada vastausta ennen loppupalautusta.

Mielestäni testaukseni kattaa oleellisimman ohjelmalogiikan. Testauksen ulkopuolelle jätin näppäimistön kuuntelusta huolehtivan KeyManager-luokan, abstraktin luokan State perivät luokat sekä pelin pyörittämisestä huolehtivan Game-luokan. 

KeyManagerin testaamattomuuden perustelen sillä, että käytännössä luokan toiminnalisuus koostuu KeyListener-olion metodin keyPressed(KeyEvent e) overridesta. Metodin sisällä ei tehdä muuta, kuin kutsutaan yksittäisiä MovingLogic-luokan metodeita pelaajan liikuttamiseen. Koska testaan pelaajan liikkumista testiluokan MovingLogicTest yhteydessä, en nähnyt testauksen kirjoittamista tälle luokalle erikseen tarpeelliseksi.

Abstraktia luokkaa State en testannut yksinomaan siitä syystä, ettei kyseinen luokka tee muuta kuin ohjeistaa sen perivien luokkien toteuttamaan metodin render(Graphics g). Koska metodia render(Graphics g) en onnistunut testaamaan muissakaan yhteyksissä ja kaikkien sen toteuttavien luokkien toiminnan pystyin varmistamaan ohjelman ajamisen yhteydessä, jätin sen testauksen väliin myös State-luokan yhteydessä.

Luokan Game testausta en toteuttanut yksinkertaisesti siksi, etten keksinyt mitään järkevää tapaa testata oleellisinta eli run()-metodia. Graafisen käyttöliittymän testaus muutenkin olisi ollut ongelmallista, sillä ikkunassa ei ollut nappeja tai tekstikenttiä, joiden toimintaa olisi voinut testata. Pelaajan ja laatikoiden oikea liikkuminen kuitenkin testataan MovingLogic-luokan yhteydessä. Lisäksi varmistin graafisen käyttöliittymän toiminnan kokeilemalla toteuttamiani ominaisuuksia ohjelman ajamisen yhteydessä. 

Peliin jäi pitkästä tutkinnasta huolimatta yksittäinen näkyvä bugi, jonka ansiosta pelaajan ja laatikoiden aloitusruudut jäävät punaiseksi pelaajaa tai laatikoita siirrettäessä. Tämä ei kuitenkaan vaikuta ohjelman toiminnallisuuteen millään tavalla, vaikka tämä voikin asiasta tietämätöntä pelaajaa hiukan hämmentää. Ylimääräiset punaiset ruudut eivät siis vaikuta itse peliin millään tavalla.
