(ns cljs-redux.core)

(defn make-dispatcher [model reducer]
  (fn [action]
    (swap! model reducer action)))

(defn with-log [dispatch!]
  (fn [action]
    (println action)
    (dispatch! action)))

(defmacro defreducer [name [state action] & body]
  `(defn ~name [~state ~action]
      (case (:type ~action)
        ~@body
        ~state)))
