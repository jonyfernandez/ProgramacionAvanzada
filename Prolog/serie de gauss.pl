%Codifique en prolog las reglas necesarias para obtener el término N en la serie de Gauss

serieGauss(0,0):-!.
serieGauss(N,R):-A is N-1,serieGauss(A,Ra),R is N+Ra.

%gauss(1,1):-!.
%gauss(N,R):-N>1, A is N-1, gauss(A,Ra), R is N+Ra.
