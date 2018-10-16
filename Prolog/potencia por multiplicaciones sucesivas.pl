%Codifique en prolog las reglas necesarias para obtener la potencia N de un numero X aplicando multiplicaciones sucesivas.

%cls :- write('\e[2J').

potencia(_,0,1):-!.
potencia(X,Y,P):-Y1 is Y-1,potencia(X,Y1,P1),P is X*P1.
