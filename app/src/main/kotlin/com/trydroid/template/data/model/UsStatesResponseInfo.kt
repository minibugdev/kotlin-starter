package com.trydroid.template.data.model

import org.simpleframework.xml.ElementList
import org.simpleframework.xml.Root

@Root(name = "GetInfoByCityResult", strict = false)
class UsStatesResponseInfo {

    @field:ElementList(name = "NewDataSet", required = false)
    var elements: List<TableElement>? = null
}