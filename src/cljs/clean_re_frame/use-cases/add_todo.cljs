(ns clean-re-frame.use-cases.add-todo)


(defn allocate-next-id
  "Returns the next note id.
  Assumes todos are sorted.
  Returns one more than the current largest id."
  [todos]
  ((fnil inc 0) (last (keys todos))))

;; This will be called by an event handler
(defn add-todo [todos [title]]
  (let [id (allocate-next-id todos)]
    (assoc todos id {:id id
                     :title title})))
