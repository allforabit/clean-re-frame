(ns clean-re-frame.interface-adapters.subs
  (:require [re-frame.core :as rf]
            [clean-re-frame.use-cases.core :refer [list-todos]]))

(rf/reg-sub ::todos list-todos)
