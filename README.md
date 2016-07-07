

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
