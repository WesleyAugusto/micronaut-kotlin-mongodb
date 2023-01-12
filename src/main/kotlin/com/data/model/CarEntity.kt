package com.data.model

import com.data.annotations.NoArg
import java.math.BigDecimal

@NoArg
data class CarEntity(
    var id : String?,
    var brand : String,
    var model : String,
    var price : BigDecimal
)