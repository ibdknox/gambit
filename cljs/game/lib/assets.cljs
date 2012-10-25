(ns game.lib.assets)

(comment
  (asset-set
    (image "cool.png")
    (tp "blah")
    )
  )

(defn image [src]
  (let [I (Image.)]
    (set! (.-src I) src)
    I))
