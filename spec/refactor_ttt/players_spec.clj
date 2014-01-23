(ns refactor-ttt.players-spec
  (:require [speclj.core :refer :all]
            [refactor-ttt.players :refer :all]
            [refactor-ttt.constants :refer :all]))

(let [b (:blank mark)]
(describe "Player Spec"
  (describe "win-message"
    (around [it]
      (with-out-str (it)))
    (it "player-wins"
        (should= "The human wins!\n"
          (with-out-str
            (player-wins))))
    (it "computer-wins"
        (should= "All hail the machine!\n"
          (with-out-str
            (computer-wins)))))
  (describe "move"
    (around [it]
      (with-out-str (it)))

    (describe "player-move"
      (it "displays prompt for index"
        (should= "\n(0 1 2)\nPlease select an index\n"
          (with-out-str (with-in-str "0" (player-move [b b b])))))
      (it "converts string to index"
        (should= 0
          (with-in-str "0"
            (player-move [b b b])))))

    (describe "computer-move"
      (it "gets a random available index"
        (should-contain (computer-move [b b b]) [0,1,2]))))

    (describe "player-type"
      (it "contains 'player' and 'computer'"
        (should-contain :player player-type)
        (should-contain :computer player-type))
      (it "both contain a move function"
        (should= player-move
                 (:move (:player player-type)))
        (should= computer-move
                 (:move (:computer player-type))))
      (it "both contain a win function"
        (should= player-wins
                 (:win-message (:player player-type)))
        (should= computer-wins
                 (:win-message (:computer player-type)))))))

