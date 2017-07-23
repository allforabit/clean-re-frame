(ns clean-re-frame.interface-adapters.views
  (:require
   [clojure.string :as str]
   [re-frame.core :refer [dispatch]]
   [clean-re-frame.interface-adapters.events :as events]
   [clean-re-frame.interface-adapters.subs :as subs]
   [re-frame.core :as rf]
   [reagent.core :as reagent]))


(defn list-todos [todos]
  (into
   [:ul]
   (map #(vector :li (:title %)) todos)))

(defn list-todos-wrapper []
  (let [todos (rf/subscribe [::subs/todos])]
    [list-todos @todos]))


(defn todo-input [{:keys [title on-save on-stop]}]
  (let [val  (reagent/atom title)
        stop #(do (reset! val "")
                  (when on-stop (on-stop)))
        save #(let [v (-> @val str str/trim)]
                (when (seq v) (on-save v))
                (stop))]
    (fn [props]
      [:input (merge props
                     {:type        "text"
                      :value       @val
                      :auto-focus  true
                      :on-blur     save
                      :on-change   #(reset! val (-> % .-target .-value))
                      :on-key-down #(case (.-which %)
                                      13 (save)
                                      27 (stop)
                                      nil)})])))

(defn todo-entry
  []
  [:header#header
   [todo-input
    {:id "new-todo"
     :placeholder "What needs to be done?"
     :on-save #(dispatch [::events/add-todo %])}]])


(defn main []
  [:div
   [list-todos-wrapper]
   [todo-entry]])
