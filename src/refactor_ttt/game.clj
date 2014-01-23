(ns refactor-ttt.game
  (:require [refactor-ttt.board :refer :all]
            [refactor-ttt.constants :refer :all]
            [refactor-ttt.players :refer :all]
            [refactor-ttt.rules :refer :all]))

(defn display [board]
  (println "\n\n")
  (show board))

(defn message [turn]
  (:win-message (turn player-type)))

(defn get-winner [board]
  (if (win? board :player)
      (message :player)
      (message :computer)))

(defn get-results [board]
  (if (draw? board)
      (println "Draw! Nobody wins!")
      (get-winner board)))

(defn game [board turn]
  (display board)
  (if (game-over? board)
      (get-results board)
      (let [index ((:move (turn player-type)) board)]
        (if (valid-move? board index)
          (recur (move board index turn) (change-turn turn))
          (recur board turn)))))
