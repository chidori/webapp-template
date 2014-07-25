(ns leiningen.new.webapp
  (:require [leiningen.new.templates :refer [renderer sanitize year ->files]]
            [leiningen.core.main :as main]))

(defn webapp
  "Create a new simple webapp project"
  [name]
  (let [data {:name name
              :sanitized (sanitize name)}
        render #((renderer "webapp") % data)]
    (main/info "Generating a lovely new webapp project named" (str name "..."))
    (->files data
             [".gitignore"  (render "gitignore")]
             ["project.clj" (render "project.clj")]
             ["README.md"   (render "README.md")]
             ["src/{{sanitized}}/core.clj" (render "core.clj")]
             ["src/{{sanitized}}/repl.clj" (render "repl.clj")]
             ["src/templates/index.html" (render "index.html")])))
