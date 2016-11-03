package com.trydroid.template.data.model

import org.simpleframework.xml.Element
import org.simpleframework.xml.Root

@Root(name = "Body", strict = false)
class UsStatesResponseBody {

    @field:Element(name = "GetInfoByCityResponse", required = false)
    var data: UsStatesResponseData? = null
}
