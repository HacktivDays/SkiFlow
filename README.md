#Fonctionnalités
Application permettant de piloter des afficheurs LED en haut de piste (vert/orange/rouge) pour orienter les skieurs sur les pistes les moins fréquentées.
Utilisation de divers capteurs (Video / boutons) pour analyser les files d'attente aux remontées mécaniques

##Récupération des données
* Flux video
* Boutons poussoir

##Envoi des données
* Mise à jour du statut des afficheurs (vert/orange/rouge)

##Stockage des données
Nb de personnes par remontée par heure

##Restitution des données
TODO

#REST API

##PUT (/data)
```
 {
    skiLiftId : 1,
    state : 1, // 0 ==> vert, 1 ==> orange, 2 ==> rouge
    priority: 1 // 0 ==> vidéo, 1 ==> manuel
 }
```

##GET (/data/{panelId})
