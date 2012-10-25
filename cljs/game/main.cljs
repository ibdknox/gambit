(ns game.main
  (:require [game.lib.core :refer [frame entity all-e add-c rem! as] :as gc]
            [game.lib.physics :as phys]
            [game.lib.dev :as dev]
            [game.lib.util :refer [now every wait]]
            [game.comps :as comps]
            [jayq.core :refer [text $]])
  (:require-macros [game.lib.macros :refer [dofs letc dyn ? ! when-dev]]))

(def brush (js/window.brush "#canvas"))
(def key? js/input.key)

(defn clear []
  (dofs [e js/Game.entities]
        (rem! e)))

(defn renderer [ents]
  ;(.clearRect brush (js-obj :x 500 :y 500))
  (dofs [e ents]
        (letc e [rend :renderable
                 pos :position]
              ((? rend :fn) e pos))))

(defn game-loop []
  (dev/begin)
  (phys/add|rem)

  ;;systems here

  (phys/step)
  (renderer (all-e :renderable))
  (when-dev
    (when false
      (dev/phys-debug)))
  (dev/end)

  (frame (dyn game-loop)))

(defn run []
  (dev/add-stats)
  (phys/init "#canvas")

  ;;contact listners here

  (game-loop))

(run)
