package com.trydroid.template.data.model

import org.simpleframework.xml.Element
import org.simpleframework.xml.Namespace
import org.simpleframework.xml.Root

@Root(name = "GetInfoByCityResponse", strict = false)
@Namespace(reference = "http://www.webserviceX.NET")
class UsStatesResponseData {

    @field:Element(name = "GetInfoByCityResult", required = false)
    var data: UsStatesResponseInfo? = null
}
