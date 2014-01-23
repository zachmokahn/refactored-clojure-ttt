(ns refactor-ttt.players
  (:require [refactor-ttt.board :refer :all]))

(defn player-wins []
  (println "The human wins!"))

(defn computer-wins []
  (println "All hail the machine!"))

(defn player-move [board]
  (println)
  (println (available-spaces board))
  (println "Please select an index")
  (read-string (read-line)))

(defn computer-move [board]
  (rand-nth (available-spaces board)))

(def player-type
  {:player
    {:win-message player-wins
     :move player-move}
   :computer
    {:win-message computer-wins
     :move computer-move}})

