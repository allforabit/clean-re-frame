(ns clean-re-frame.core
  (:require [reagent.core :as reagent]
            [re-frame.core :as re-frame]
            [re-frisk.core :refer [enable-re-frisk!]]
            [clean-re-frame.interface-adapters.core :as rf-driver]
            [re-frame.core :as rf]))


(defn dev-setup []
    (enable-console-print!)
    (enable-re-frisk!)
    (println "dev mode"))

(defn mount-root []
  (re-frame/clear-subscription-cache!)
  (reagent/render [rf-driver/view]
                  (.getElementById js/document "app")))

(defn ^:export init []
  (dev-setup)
  (rf/dispatch-sync [:initialize])
  (mount-root))
