#History (zurück zur [Haupt-Readme](../../)?)
Die History wurde etwas zu lang, deshalb hab ich sie in eine eigene Datei verschoben...

__Derzeitiger Gesamtstatus:__ :x: Wieder 98.21 %. Sobald wir über 99 sind, gibts auch wieder einen Smiley :D (<- Der ist nicht gemeint...)

Gesamtpunkte (/7) = Funktionalität (/5) + Wartbarkeit (/2).

| Nr. | Punkte (/7) | Kommentar
|----:|:-----------:|---
| 8   | 5+2=7       | Im Konstruktor hättet ihr - theoretisch - jede Karte einzeln kopieren müssen, anstatt das ganze Array zu übernehmen (Stichwort "tiefe Kopie"). Das ist in dieser Aufgabe nicht schlimm, spätestens wenn ihr im vierten Semester Rechnernetze habt und ein Spiel wie Labyrinth oder so programmieren müsst, ist sowas extrem ärgerlich, da es nicht direkt auffällt. Ansonsten ist eure Lösung schön und kompakt.
| 7   | 5+2=7       | Funktioniert alles.
| 6   | 4+2=6 :sob: | Läuft alles fehlerfrei. Alternativ zu "Math.pow(2, x)" könnt ihr auch "1 << x", den (Bit)Shift-Operator verwenden. Der schiebt alle Bits der angegebenen Zahl (hier 1) um x Bitstellen nach links (was im Endeffekt analog zu 1*(2^x) ist). Habe ich damals selber nicht gemacht, sieht aber cooler aus und dürfte schneller sein ;) Für BigInteger.intValue() muss ich euch aber einen Punkt abziehen, da ihr den String selbstständig in einen Integer umwandeln solltet.
| 5   | 5+2=7       | Euer eigene Adressdatei hättet ihr mir ruhig dazulegen können. Hashmap toString() würde ich nicht verwenden, da die ganzen Adressen dann nebeneinander stehen, was unübersichtlich ist (da es so auch in der Beispielausgabe der Aufgabenstellung steht, kein Punktabzug). Nehmt die Kommentierung wieder ein bisschen ernster, sollten die Korrekteure wechseln, würde es mich nicht wundern, wenn man euch dafür Punkte abzieht.
| 4   | 5+2=7       | Schöne Lösung.
| 3   | 5+2=7       | Die Funktionen getMax() und getMaxIndex() machen praktisch das Gleiche, also hättet ihr zur Berechnung der größten Zahl auch einfach values[getMaxIndex()] nehmen können. Parser-Funktionen bei Benutzereingaben würde ich normalerweise immer in einem try-catch machen, auch wenn das in diesem Fall nicht gefordert.
| 2   | 5+2=7       | Die uns gegebene Musterlösung arbeitet mit einem int-Array (-1 für nicht vorhanden, 0 für verfügbar und 1 für belegt), die meisten anderen Gruppen haben ein char-Array verwendet, daher wurde da der Konstruktor benötigt, um die Arrays zu initialisieren. Das spart ihr euch natürlich mit einem boolean-Array und der entsprechenden Hilfsmethode "platzGueltig". Gefällt mir persönlich auch besser.
| 1   | 5+2=7       | Streng genommen solltet ihr gucken, was die "Stoppwatch" so tut, nicht die "Stoppuhr" ;) (kein Punktabzug).
