(ns clean-re-frame.interface-adapters.events
  (:require [re-frame.core :as rf]
            [clean-re-frame.use-cases.add-todo :refer [add-todo]]
            [clean-re-frame.entities.todo :refer [default-todos]]))

(def todo-interceptors
  [(rf/path :todos) rf/trim-v])

(rf/reg-event-db ::add-todo
                 todo-interceptors
                 add-todo)

(rf/reg-event-db
 :initialize
 (fn [_ _]
   {:todos default-todos}))
