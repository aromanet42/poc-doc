

= Principe

Pour générer la doc, il faut lancer le Test ServiceDocumentation

cela va générer des "snippets" dans target/generated-snippets
Les snippets contiennent :

- un exemple CURL
- un exemple de requete
- un exemple de réponse

On a ensuite un plugin maven asciidoctor-maven-plugin qui génère un fichier HTML à partir du fichier src/main/asciidoc/index.adoc qui va inclure les différents snippets


= Pros

- on a des exemples Json/Xml pertinents puisque générés à partir de tests

= Cons

- on doit créer à la main les fichiers api/XXX.adoc qui agrègent les exemples
- on doit maintenir à la main le fichier index.adoc et les différents api/XXX.adoc
- la description de la Resource et des Paramètres est loin du code
- toute la doc est dans une seule page HTML
- les erreurs AsciiDoc ne provoquent pas de build fail

    asciidoctor: ERROR: index.adoc: line 80: invalid part, must have at least one section (e.g., chapter, appendix, etc.)
    Rendered /home/aromanet/workspace/mirakl-new-doc/src/main/asciidoc/index.adoc
    Rendered /home/aromanet/workspace/mirakl-new-doc/src/main/asciidoc/apis/post_service.adoc
    Rendered /home/aromanet/workspace/mirakl-new-doc/src/main/asciidoc/apis/getorder.adoc

    --- maven-jar-plugin:2.5:jar (default-jar) @ mirakl-new-doc ---
    Building jar: /home/aromanet/workspace/mirakl-new-doc/target/mirakl-new-doc-0.0.1-SNAPSHOT.jar

    --- spring-boot-maven-plugin:1.3.5.RELEASE:repackage (default) @ mirakl-new-doc ---

    --- maven-install-plugin:2.5.2:install (default-install) @ mirakl-new-doc ---
    Installing /home/aromanet/workspace/mirakl-new-doc/target/mirakl-new-doc-0.0.1-SNAPSHOT.jar to /home/aromanet/.m2/repository/com/example/mirakl-new-doc/0.0.1-SNAPSHOT/mirakl-new-doc-0.0.1-SNAPSHOT.jar
    Installing /home/aromanet/workspace/mirakl-new-doc/pom.xml to /home/aromanet/.m2/repository/com/example/mirakl-new-doc/0.0.1-SNAPSHOT/mirakl-new-doc-0.0.1-SNAPSHOT.pom
    ------------------------------------------------------------------------
    BUILD SUCCESS
    ------------------------------------------------------------------------
