(ns refactor-ttt.board-spec
  (:require [speclj.core :refer :all]
            [refactor-ttt.board :refer :all]))
(let [board ["-" "-" "-" "-" "-" "-" "-" "-" "-"]]
(describe "new-board"
  (it "an 'blank' vector"
    (should= board
             new-board)))

(describe "move"
  (it "returns a new vector with change made"
    (should= ["-" "-" "-" "-" "x" "-" "-" "-" "-"]
             (move board 4 :player))))

(describe "available-spaces"
  (it "returns all indexes on new board"
    (should= [0 1 2 3 4 5 6 7 8]
             (available-spaces board)))
  (it "returns only available indexes"
    (should= []
             (available-spaces ["o" "o" "o" "o" "o" "o" "o" "o" "o"]))
    (should= [0 4 8]
             (available-spaces ["-" "o" "o" "o" "-" "o" "o" "o" "-"]))))

(describe "render"
  (it "returns token if space is occupied"
    (should= " x "
             (render ["x" "o"] 0))
    (should= " o "
             (render ["x" "o"] 1)))
  (it "returns index value if blank"
    (should= " 0 "
             (render board 0))))

(describe "show"
  (around [it]
    (with-out-str (it)))
  (it "properly renders a board"
    (should= (str
            " 0 | 1 | 2 \n"
            "-----------\n"
            " 3 | 4 | 5 \n"
            "-----------\n"
            " 6 | 7 | 8 \n")
      (with-out-str(show board))))))
