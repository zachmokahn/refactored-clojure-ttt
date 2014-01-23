(ns refactor-ttt.game
  (:require [refactor-ttt.board :refer :all]
            [refactor-ttt.constants :refer :all]
            [refactor-ttt.players :refer :all]
            [refactor-ttt.rules :refer :all]))

(defn display [board]
  (println "\n\n")
  (show board))

(defn get-winner [board]
  (if (win? board :player)
      ((:win-message (:player player-type)))
      ((:win-message (:computer player-type)))))

(defn get-results [board]
  (if (draw? board)
      (println "Draw! Nobody wins!")
      (get-winner board)))

(defn check? [board]
  (game-over? board))

(defn game [board turn]
  (display board)
  (if (check? board)
      (get-results board)
      (let [index ((:move (turn player-type)) board)]
        (if (valid-move? board index)
          (recur (move board index turn) (change-turn turn))
          (recur board turn)))))
