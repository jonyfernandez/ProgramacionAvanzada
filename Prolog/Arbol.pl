hombre(pedro) .
hombre(manuel) .
hombre(arturo) .
hombre(homero) .
hombre(jony) .

mujer(maría).
mujer(marta).

padre(pedro, manuel).
padre(pedro, arturo).
padre(pedro, maría) .
padre(jony,marta).
padre(jony,homero).

%NIÑO(X,Y): EXPRESA QUE X ES HIJO O HIJA DE Y.

niño(X,Y):-padre(Y,X).

%HIJO(X,Y): EXPRESA QUE X ES UN HIJO VARON DE Y.

hijo(X,Y):-padre(Y,X),hombre(X).

%HIJA(X,Y): EXPRESA QUE X ES UNA HIJA DE Y.

hija(X,Y):-padre(Y,X),mujer(X).

%HERMANO_O_HERMANA(X,Y): EXPRESA QUE X ES HERMANO O HERMANA DE Y.

hermano_o_hermana(X,Y):-padre(Z,X),padre(Z,Y),not(X==Y).

%HERMANO(X,Y): EXPRESA QUE X ES HERMANO DE Y.

hermano(X,Y):-hermano_o_hermana(X,Y),hombre(X).

%HERMANA(X,Y): EXPRESA QUE X ES HERMANA DE Y.

hermana(X,Y):-hermano_o_hermana(X,Y),mujer(X).
