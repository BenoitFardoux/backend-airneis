package com.bav.airneisbackend.utilisateur.serverside.exception

class AdresseInvalideException(champsInvalides: MutableList<String>) : UtilisateurException("les champs suivants sont invalides : ${champsInvalides.joinToString(", ")}) ")