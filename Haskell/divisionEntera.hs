--Dado dos números enteros A y B, implemente una función que retorne la 
--división entera de ambos  por el método de las restas sucesivas.

division_entera :: Int -> Int -> Int
division_entera x y
  |(x < y) = 0
  |otherwise = 1 + division_entera(x - y) y

main = print (division_entera 5 6)