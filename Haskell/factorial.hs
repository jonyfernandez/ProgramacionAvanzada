--Implemente una función recursiva para calcular el factorial de un número

--Usando Pattern Matching (Patrones)

factorial :: Int -> Int
factorial 0 = 1
factorial n = n * factorial (n - 1)

main = print (factorial 10)

--Otra forma: Usando condicionales (IF)

factorial :: Int -> Int
factorial n = if(n == 0) then 1
              else n * factorial (n - 1)

main = print (factorial 10)

--Otra forma: Usando funciones predefinidas de haskell

factorial :: Int -> Int
factorial n = product[1..n]

main = print (factorial 10)