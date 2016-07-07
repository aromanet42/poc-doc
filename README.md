
= Principe

- La webapp génère sa propre doc swagger (format json) à partir du Docket configuré dans MiraklNewDocApplication
- toutes les méthodes avec au moins une annot Swagger (@ApiOperation, @ApiParam, etc) sont documentées
- Le test ServiceDocumentation créé les fichiers AsciiDoctor à partir de la doc JSON
- un plugin Maven converti les fichiers AsciiDoctor en HTML

= Pros

- la doc est près du code
- il n'y a pas besoin de décrire les objets plusieurs fois (JSON/XML)

= Cons

- 3 fichiers générés : overview, paths (liste des resources), definitions (liste des Dtos)
- il n'y a pas d'exemple de requete/réponse