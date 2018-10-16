%Definir la relación mcd (+X,+Y,?Z) que se verifique si Z es el máximo común divisor entre X e Y.

mcd(X, X, X):-!.
mcd(_, 1, 1):-!.
%mcd(0,Y,Y):-!.
%mcd(X,0,X):-!.
mcd(A, B, Z):- A < B, mcd(B,A,Z),!.
mcd(A, B, Z):-dif(A,0), dif(B,0), A > B, A1 is A-B, mcd(A1,B,Z).
