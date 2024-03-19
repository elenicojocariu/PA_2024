**_Week 1:_**
<br>
Compulsory 1: done
</br>
<br>
Tema 1: am aplicat metoda cu suma patratelor, am adaugat argumente cu ajutorul "Modify run configuration" </br>
<br>
Bonus 1: am creat matricea de adiacenta pentru un wheel graph si am afisat o. Am facut o metode findCycles care gaseste ciclurile de cate 3 
noduri. Aceasta apeleaza metoda recursiva DFS care realizeaza o parcurgere DFS incepand cu nodurile nevizitate. 
</br>
<br>
**_Week 2:_**
</br>
<br>
Compulsory 2: done 
</br>
<br>
Tema 2: Am testat metoda equals, ea returneaza false. Am facut clasa Depot bidirectionala: obiectul depot are referinta catre obiectul vehicle si invers. Am facut extins clasa Vehicle cu Truck si Drone, ea a devenit abstracta, ea nu mai este apelata in main, ci instantele claselor extinse sunt. In Solution am ales sa fac greedy- sortare dupa minTime. Am generat comentarii cu javadoc  </br>
<br>
Bonus 2:
</br>
<br>
**_Week 3:_**
</br>
<br>
Compulsory 3: done
</br>
<br>
Tema 3: Am implementat clasele Statue, Concert,Church care mostenesc clasa Attraction. Clasa Concert implementeaza interfetele <<Visitable>> si <<Payable>>. Clasa Church implementeaza interfata <<Visitable>>. Atasez link catre diagrama UML cu reprezentarea claselor, interfetelor etc: https://app.diagrams.net/#G1M3Yzf1pSivOzdeEcB06gLa_oDu_eteia#%7B%22pageId%22%3A%22C5RBs43oDa-KdzZeNtuy%22%7D . Clasa Pair este generica. In <<Visitable>> am declarat getTimetable care returneaza un Map cu cheia DayOfWeek si valoarea TimeInterval. TimeInterval este o clasa ce extinde genericul Pair. Am implementat metoda default getOpeningHour care returneaza un LocalTime si foloseste din Pair .getFirst (ora deschiderii). In clasa TravelPlan am metoda generateTravelPlan() care ia perioada din startDate-ul si endDate-ul vacantei si in functie de timetable-ul fiecarei atractii <<Visitable>> o pune in plan. </br>
<br>
Bonus 3: 
</br>
