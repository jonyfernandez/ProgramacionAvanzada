numero(1).
numero(2).
numero(3).
ventas(febrero,25000).
ventas(marzo,15000).
ventas(abril,18000).
ventas(enero,25000).

%Producto Cartesiano.

productoCartesiano(X,Y) :-numero(X),numero(Y).

%Seleccion numero Menor.

seleccion(X,Y):-productoCartesiano(X,Y),numero(X), X<Y.

%proyeccion

proyeccion(X):-seleccion(X,_). %_VARIABLE ANONIMA.

maximo(X):-numero(X),not(proyeccion(X)).



%Mes donde mas ventas se hizo.

producto_Cartesiano(X,Y,Z,W):-ventas(X,Y),ventas(Z,W).
seleccion_Ventas(X,Y,Z,W):-producto_Cartesiano(X,Y,Z,W), Y<W.
proyeccion_Ventas(X,Y):-seleccion_Ventas(X,Y,_,_).
maximo_ventas(X,Y):-ventas(X,Y),not(proyeccion_Ventas(X,Y)).
mes_maximo(X):-ventas(X,Y),maximo_ventas(X,Y).

terna(X,Y,Z):-!,numero(X),numero(Y),numero(Z). %! operador de corte, se usa en recursividad.

funcion(X,F):-F is -X, X<4,!. %sin el corte quedaria esperando.
funcion(X,-4):-X>=4,X=<8,!.
funcion(X,F):-F is X-12, X>8.
