package org.example;

public class Main {
    public static void main(String[] args) {
        Game game = new Game(4, 5000);
        game.addPlayer(new Player("Player 1"));
        game.addPlayer(new Player("Player 2"));
        game.addPlayer(new Player("Player 3"));
        game.play();
    }
}
//Sugestii lab:
//acces la resursa partajata=saculet
//coordonare jucatori ca sa folosim notify
//jetoane=arcele grafului
//gasim circuit cel mai lung
//daca gaseste un circuit hamiltonian-> a castiagat jocul / a expirat timpul
//in sac am graful complet
//un shuffle si apoi un queue din care extrag
//get available Processors from java run time
//un alg de cautare a unui circ hamiltonian dupa ce se alege piesa la fiecare la fir de executie
//deci 2 fire de executie pt jucator unu se gandeste ce sa faca cu piesele si celaalt asteapta randul, ies din starea wait, fac un semafor cu k culori si