(ns rock-paper-scissors.core)

(defn foo
  "I don't do a whole lot."
  [x]
  x (println x "Hello, World!"))

(def dominates
  {:rock :paper :paper :scissors :scissors :rock})

(def choices
  (set (keys dominates)))

(defn winner [choice1 choice2]
  (cond
   (= choice1 choice2) nil
   (= (dominates choice1) choice2) choice2
   :else choice1))

(defn draw? [me you]
  (= me you))

(defn iwon? [me you]
  (= (winner me you) me))
