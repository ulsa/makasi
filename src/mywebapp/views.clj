(ns mywebapp.views
  (:use [hiccup core page])
  (:require [hiccup.form :as f]
            [rock-paper-scissors.core :as rps]))

(defn header []
  [:div.navbar.navbar-inverse.navbar-fixed-top
   [:div.navbar-inner
    [:div.container
     [:a.brand {:href "/"} "Makasi"]
     [:div.nav-collapse.collapse
      [:ul.nav
       [:li.active [:a {:href "/"} "Home"]]]]]]])

(defn template [& body]
  (html5
   [:head
    [:title "Rock, paper, scissors"]
    [:meta {:name "viewport"
            :content "width=device-width, initial-scale=1.0"}]
    (include-css "/css/bootstrap.min.css")]
   [:body {:style "padding-top:60px;"}
    (header)
    [:div.container
     body]]))

(defn index-page []
  (template

   [:div {:class "hero-unit"}
    [:h1 "Rock, paper, scissors, the Clojure way"]
    (f/form-to
     [:post "/result"]
     (f/label "p1" "Player 1:")
     (f/drop-down "p1" rps/choices)
     [:br]
     (f/label "p2" "Player 2:")
     (f/drop-down "p2" rps/choices)
     [:br]
     (f/submit-button "Play"))]))

(defn result-page [p1 p2]
  (template
     [:div {:class "hero-unit"}
    [:h1 "Result"]
     [:div (name (rps/winner (keyword p1) (keyword p2)))]]))
