(ns refactor-ttt.core
  (:require [refactor-ttt.board :refer :all]
            [refactor-ttt.constants :refer :all]
            [refactor-ttt.game :refer :all]
            [refactor-ttt.rules :refer :all]))

(defn -main []
    (game new-board :player))
