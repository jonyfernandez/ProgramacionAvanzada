%Codifique en prolog las reglas necesarias para obtener el factorial de un número natural N.

factorial(X,F):- F is 1, X=0,!.
factorial(X,F):- F1 is X-1, factorial(F1,F2),F is X*F2.
