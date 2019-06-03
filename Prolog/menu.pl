entrada(paella).
entrada(gazpacho).
entrada(consom�).

carne(filete_de_cerdo).
carne(pollo_asado).

pescado(trucha).
pescado(bacalao).

postre(flan).
postre(helado).
postre(pastel).

bebida(vino).
bebida(cerveza).
bebida(agua_mineral).

plato_principal(X):-carne(X);pescado(X).

%a) �CUALES SON LOS MENU QUE OFRECE EL RESTAURANTE?
menu(X,Y,Z):-entrada(X),plato_principal(Y),postre(Z).

%b) �CUALES SON LOS MENUS QUE TIENEN CONSOM� EN LAS ENTRADAS?
menu_consome(X,Y,Z):-menu(X,Y,Z),X==consom�.
menu_consomeV2(Y,Z):-menu(consom�,Y,Z).

%c) �CUALES SON LOS MENUS QUE NO TIENE FLAN COMO POSTRES?

menu_sin_flan(X,Y,Z):-menu(X,Y,Z),not(Z==flan).
menu_sin_flanV2(X,Y,Z):-menu(X,Y,Z),Z\==flan.
menu_sin_flanV3(X,Y,Z):-menu(X,Y,Z),dif(Z,flan).

% bis) MENU CON BEBIDAS

menu_con_bebidas(X,Y,Z,W):-menu(X,Y,Z),bebida(W).
