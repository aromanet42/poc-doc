
# Principe

- les tests XXDocumentations génèrent uniquement les "snippets" (exemple de requete/réponse/curl)
- le plugin asciidoctor-maven-plugin converti les snippets AsciiDoc en html

- le plugin swagger récupère les méthodes avec l'annot Swagger @ApiOperation pour générer la doc
  - le plugin commence par générer le contrat de l'API en Json Swagger
  - il convertit ensuite le JSON en HTML en utilisant les templates Handlebar-Mustache (hbs) http://mustache.github.io/mustache.5.html
  - les templates sont customisables. Ils utilisent Markdown et Handlebar-Mustache pour le templating (Cela nécessite de faire une montée en compétence sur Handlebar-Mustache)
    - on peut inclure des libs Javascipts (exemple Bootstrap)
    - on peut donc inclure les snippets assez facilement (voir snippet.hbs et strapdown.html.hbs)

# Pros

- la doc est près du code
- il n'y a pas besoin de décrire les objets plusieurs fois (JSON/XML)
- exemples de requete/réponse généré par les tests (RestDoc)
- possibilité d'avoir des Filtres
- montée en compétence rapide sur le templating (On connait tous markdown)
- POM.xml plus simple que sur la branche swagger-restdoc

# Cons

- attention, il faut que l'attribut value du @RequestMapping ait une valeur (meme si c'est juste /)
- il n'y a qu'un seul fichier HTML généré - il est peut-etre possible de jouer avec le JS pour ne pas tout afficher en meme temps
