(ns refactor-ttt.rules
  (:require [refactor-ttt.constants :refer :all]))

(def winning-combos
  [[0 1 2] [3 4 5] [6 7 8]
   [0 3 6] [1 4 7] [2 5 8]
   [0 4 8] [2 4 6]])

(defn valid-move? [board index]
  (= (get board index) (:blank mark)))

(defn change-turn [turn]
  (if (= turn :computer) :player :computer))

(defn map-winning-combos [board token]
  (filter (fn [combo] (every? (fn [marker] (= marker token))
    (map (fn [index] (get board index)) combo))) winning-combos))

(defn win? [board turn]
  (not (empty? (map-winning-combos board (turn mark)))))

(defn any-winner? [board]
  (or (win? board :player)
      (win? board :computer)))

(defn draw? [board]
  (and (not-any? (fn [value] (= value (:blank mark))) board)
       (not (any-winner? board))))

(defn game-over? [board]
  (or (draw? board) (any-winner? board)))
