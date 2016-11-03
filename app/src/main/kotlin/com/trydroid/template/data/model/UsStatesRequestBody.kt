package com.trydroid.template.data.model

import org.simpleframework.xml.Element
import org.simpleframework.xml.Root

@Root(name = "soap12:Body", strict = false)
class UsStatesRequestBody {

    @field:Element(name = "GetInfoByCity", required = false)
    var usStatesRequestData: UsStatesRequestData? = null
}