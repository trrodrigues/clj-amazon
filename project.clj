(defproject amazon "0.1.0-SNAPSHOT"
  :description "decision tree map reduce"
  :license {:name "MIT"
            :url "http://opensource.org/licenses/MIT"}
  :dependencies [[org.clojure/clojure "1.6.0"]]
  :main ^:skip-aot amazon.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}
             :dev {:dependencies [[clojure-csv/clojure-csv "2.0.1"]]
                   :resource-paths ["test/resources"]}})
