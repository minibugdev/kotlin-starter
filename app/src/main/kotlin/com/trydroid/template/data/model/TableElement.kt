package com.trydroid.template.data.model

import org.simpleframework.xml.Element
import org.simpleframework.xml.Root

@Root(name = "Table", strict = false)
class TableElement {

    @field:Element(name = "CITY", required = false)
    var city: String? = null

    @field:Element(name = "STATE", required = false)
    var state: String? = null

    @field:Element(name = "ZIP", required = false)
    var zip: String? = null

    @field:Element(name = "TIME_ZONE", required = false)
    var timeZone: String? = null

    @field:Element(name = "AREA_CODE", required = false)
    var areaCode: String? = null
}
