package com.example.etsy.model

data class ResponseBank (
    val code: String? = null,
    val desc: String? = null,
    val data: List<Datum>? = null
)

data class Datum (
    val id: Long? = null,
    val name: String? = null,
    val code: String? = null,
    val bin: String? = null,
    val shortName: String? = null,
    val logo: String? = null,
    val transferSupported: Long? = null,
    val lookupSupported: Long? = null,
    val datumShortName: String? = null,
    val support: Long? = null,
    val isTransfer: Long? = null,
    val swiftCode: String? = null
)
