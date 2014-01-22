(ns refactor-ttt.board
  (:require [refactor-ttt.constants :refer :all]))

(def new-board
  (vec (repeat 9 (:blank mark))))

(defn move [board index turn]
  (assoc board index (turn mark)))

(defn available-spaces [board]
  (keep-indexed (fn[index space] (if (= space (:blank mark)) index)) board))

(defn render [board index]
  (str " " (if (= (get board index) "-") index (get board index)) " "))

(defn show [board]
  (println (str
(render board 0) "|" (render board 1) "|"  (render board 2)
"\n-----------\n"
(render board 3) "|" (render board 4) "|" (render board 5)
"\n-----------\n"
(render board 6) "|" (render board 7) "|" (render board 8))))
