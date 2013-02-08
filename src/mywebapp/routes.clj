(ns mywebapp.routes
  (:use compojure.core
        mywebapp.views)
  (:require [compojure.handler :as handler]
            [compojure.route :as route]))


(defroutes app-routes
  (GET "/" [] (index-page))
  (POST "/result" [p1 p2] (result-page p1 p2))
  (route/resources "/")
  (route/not-found "No page"))


(def app
  (handler/site app-routes))
