(ns clean-re-frame.use-cases.core
  (:require [clean-re-frame.use-cases.add-todo :as add-todo]
            [clean-re-frame.use-cases.list-todos :as list-todos]))

(def add-todo add-todo/add-todo)
(def list-todos list-todos/list-todos)

