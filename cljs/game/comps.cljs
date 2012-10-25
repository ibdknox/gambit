(ns game.comps
  (:require-macros [game.lib.macros :refer [component]]))

(component position [x y a]
           :x x
           :y y
           :a (or a 0))

(component dimensions [w h]
           :w w
           :h h
           :hw (/ w 2)
           :hh (/ h 2))

(component renderable [func]
           :fn func)

