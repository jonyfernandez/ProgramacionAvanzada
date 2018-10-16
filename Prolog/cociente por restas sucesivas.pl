%Codifique en prolog las reglas necesarias para obtener la el cociente entre dos números a partir de restas sucesivas.

cociente(X,Y,0):-X<Y,!.
cociente(X,Y,C):-X>=Y, Y>0, X1 is X-Y, cociente(X1,Y,C1), C is C1+1.

%cociente y resto.

cocienteResto(X,Y,0,X):- X<Y,!.
cocienteResto(X,X,1,0):-!.
cocienteResto(X,Y,C,R):-X1 is X-Y, cocienteResto(X1,Y,C1,R), C is C1+1.
