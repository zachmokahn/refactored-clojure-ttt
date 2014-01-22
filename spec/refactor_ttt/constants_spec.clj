(ns refactor-ttt.constants-spec
  (:require [speclj.core :refer :all]
            [refactor-ttt.constants :refer :all]))

(let [board ["-" "-" "-" "-" "-" "-" "-" "-" "-"]]
(describe "markers"
  (it "blank is '-'"
      (should= "-"
               (:blank mark)))
  (it "player is 'x'"
      (should= "x"
               (:player mark)))
  (it "computer is 'o'"
      (should= "o"
               (:computer mark)))))
