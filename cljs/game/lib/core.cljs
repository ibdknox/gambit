(ns game.lib.core)

(set! *print-fn* #(.log js/console %))

(def frame
  (or (.-requestAnimationFrame js/window)
      (.-webkitRequestAnimationFrame js/window)
      (.-mozRequestAnimationFrame js/window)
      (.-oRequestAnimationFrame js/window)
      (.-msRequestAnimationFrame js/window)
      (fn [callback] (js/setTimeout callback 17))))

(defn entity [name & comps]
  (let [ent (js/Game.create name)]
    (doseq [c comps]
      (js/Game.addC ent c))))

(defn rem! [e]
  (js/Game.destroy e))

(def ! aset)
(def ? aget)

(def add-c js/Game.addC)
(def rem-c js/Game.remC)
(def all-e js/Game.allE)
(def as js/Game.as)
