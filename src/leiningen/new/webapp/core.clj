(ns {{name}}.core
  (:require [compojure.core :refer [defroutes routes GET]]
            [compojure.route :as route]
            [ring.middleware.params :refer [wrap-params]]
            [ring.middleware.keyword-params :refer [wrap-keyword-params]])
  (:gen-class))

(defn index []
  (str "Index page"))

(defroutes app-routes
           (route/resources "/")
           (GET "/" [] index)
           (route/not-found "Not found"))

(def app
  (-> (routes app-routes)
      (wrap-keyword-params)
      (wrap-params)))

(defn main- [& args]
  (println "main"))
