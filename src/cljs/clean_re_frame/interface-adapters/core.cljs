(ns clean-re-frame.interface-adapters.core
  (:require [clean-re-frame.interface-adapters.views :as views]
            [clean-re-frame.interface-adapters.events]
            [clean-re-frame.interface-adapters.subs]))


;; Alias some stuff
;; The main re-frame view
(def view views/main)

