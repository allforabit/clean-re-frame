(ns clean-re-frame.entities.todo)

;; Some spec stuff

(def sample-todo {:id 0
                  :title "test todo"})

(def sample-todos (sorted-map 1 sample-todo))

;; Empty sorted map
(def default-todos sample-todos)

