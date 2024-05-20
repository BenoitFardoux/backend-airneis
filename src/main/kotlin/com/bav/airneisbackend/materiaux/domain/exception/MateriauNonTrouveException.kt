package com.bav.airneisbackend.materiaux.domain.exception

class MateriauNonTrouveException(val id: String) : MateriauException("Le materiau avec l'id $id n'a pas été trouvé");