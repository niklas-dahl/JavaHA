#History (zurück zur [Haupt-Readme](./)?)
Die History wurde etwas zu lang, deshalb hab ich sie in eine eigene Datei verschoben...

| Nr. | Punkte (/7) | Kommentar
|----:|:-----------:|---
| 5   | 5+2=7       | Euer eigene Adressdatei hättet ihr mir ruhig dazulegen können. Hashmap toString() würde ich nicht verwenden, da die ganzen Adressen dann nebeneinander stehen, was unübersichtlich ist (da es so auch in der Beispielausgabe der Aufgabenstellung steht, kein Punktabzug). Nehmt die Kommentierung wieder ein bisschen ernster, sollten die Korrekteure wechseln, würde es mich nicht wundern, wenn man euch dafür Punkte abzieht.
| 4   | 5+2=7       | Schöne Lösung.
| 3   | 5+2=7       | Die Funktionen getMax() und getMaxIndex() machen praktisch das Gleiche, also hättet ihr zur Berechnung der größten Zahl auch einfach values[getMaxIndex()] nehmen können. Parser-Funktionen bei Benutzereingaben würde ich normalerweise immer in einem try-catch machen, auch wenn das in diesem Fall nicht gefordert.
| 2   | 5+2=7       | Die uns gegebene Musterlösung arbeitet mit einem int-Array (-1 für nicht vorhanden, 0 für verfügbar und 1 für belegt), die meisten anderen Gruppen haben ein char-Array verwendet, daher wurde da der Konstruktor benötigt, um die Arrays zu initialisieren. Das spart ihr euch natürlich mit einem boolean-Array und der entsprechenden Hilfsmethode "platzGueltig". Gefällt mir persönlich auch besser.
| 1   | 5+2=7       | Streng genommen solltet ihr gucken, was die "Stoppwatch" so tut, nicht die "Stoppuhr" ;) (kein Punktabzug).
