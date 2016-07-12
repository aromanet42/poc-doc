
= Principe

- les tests XXDocumentations génèrent uniquement les "snippets" (exemple de requete/réponse/curl)
- le plugin swagger récupère les méthodes avec l'annot Swagger @ApiOperation pour générer la doc
- le plugin swagger2markup-maven-plugin converti le json généré par swagger en AsciiDoc et en profite pour intégrer les snippets
- le plugin asciidoctor-maven-plugin converti les fichiers AsciiDoc en html

= Pros

- la doc est près du code
- il n'y a pas besoin de décrire les objets plusieurs fois (JSON/XML)
- exemples de requete/réponse généré par les tests (RestDoc)
- possibilité d'avoir des Filtres

= Cons

- attention, il faut que l'attribut value du @RequestMapping ait une valeur (meme si c'est juste /)
- il faut que le nom du test corresponde au nom de la méthode testée pour que swagger2markup-maven-plugin soit capable d'insérer les snippets au bon endroit