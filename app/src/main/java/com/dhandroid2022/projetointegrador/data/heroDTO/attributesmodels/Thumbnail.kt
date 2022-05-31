package com.dhandroid2022.projetointegrador.data.heroDTO.attributesmodels

/*
ESSA CLASSE É UTILIZADA PARA RECUPERAR O LINK DA THUMBNAIL DOS HERÓIS,
NA API ESSE DADO VEM COMO UM OBJETO COM 2 PROPRIEDADES: 'path' E 'extension'
 */

data class Thumbnail(
    val path: String,
    val extension: String,
)
