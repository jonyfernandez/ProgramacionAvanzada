hombre(pedro) .
hombre(manuel) .
hombre(arturo) .
hombre(homero) .
hombre(jony) .

mujer(mar�a).
mujer(marta).

padre(pedro, manuel).
padre(pedro, arturo).
padre(pedro, mar�a) .
padre(jony,marta).
padre(jony,homero).

ni�o(X,Y):-padre(Y,X).
hijo(X,Y):-padre(Y,X),hombre(X).
hija(X,Y):-padre(Y,X),mujer(X).
hermano_o_hermana(X,Y):-padre(Z,X),padre(Z,Y),not(X==Y).
hermano(X,Y):-hermano_o_hermana(X,Y),hombre(X).
hermana(X,Y):-hermano_o_hermana(X,Y),mujer(X).
