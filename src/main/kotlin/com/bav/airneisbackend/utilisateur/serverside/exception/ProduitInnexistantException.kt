package com.bav.airneisbackend.utilisateur.serverside.exception

class ProduitInnexistantException(val id : String) : UtilisateurException("L'article n'existe pas $id")

