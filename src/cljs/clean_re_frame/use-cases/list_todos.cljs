(ns clean-re-frame.use-cases.list-todos)

(defn list-todos [db]
  (->> db
      :todos
      (vals)
      (filter (complement nil?))))

