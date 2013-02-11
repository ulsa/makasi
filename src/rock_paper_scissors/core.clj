(ns rock-paper-scissors.core)

(def dominates
  {:rock :paper
   :paper :scissors
   :scissors :rock})

(def choices
  (set (keys dominates)))

(defn winner [choice1 choice2]
  (cond
   (= choice1 choice2) nil
   (= (dominates choice1) choice2) choice2
   :else choice1))
