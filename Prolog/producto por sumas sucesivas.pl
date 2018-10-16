%Codifique en prolog las reglas necesarias para obtener el producto de dos numeros  X e Y,  aplicando sumas sucesivas.


%producto(X,1,X):-!.
producto(0,_,0):-!.
producto(X,Y,P):-X>0 ,X1 is X-1, producto(X1,Y,P1), P is Y+P1.

%producto(_,0,0):-!.
%producto(X,Y,P):Y1 is Y-1, producto(X,Y1,P1), P is X+P1.
