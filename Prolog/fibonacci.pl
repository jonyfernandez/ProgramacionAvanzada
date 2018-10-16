%Codifique en prolog las reglas necesarias para obtener el término N en
%la serie de Fibonacci

fibonacci(0,0):-!.
fibonacci(1,1):-!.
fibonacci(X,F):- X1 is X-1, X2 is X-2,fibonacci(X1,F1),fibonacci(X2,F2), F is F1+F2.
