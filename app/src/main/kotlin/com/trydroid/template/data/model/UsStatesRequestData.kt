package com.trydroid.template.data.model

import org.simpleframework.xml.Element
import org.simpleframework.xml.Namespace
import org.simpleframework.xml.Root

@Root(name = "GetInfoByState", strict = false)
@Namespace(reference = "http://www.webserviceX.NET")
class UsStatesRequestData {

    @field:Element(name = "USCity", required = false)
    var city: String? = null
}