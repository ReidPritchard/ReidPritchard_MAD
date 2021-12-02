package com.example.lab_08

data class DataClass(val shouldFill: Boolean) {
    // data_list = "Coffee Place Name": ["Name", "ImageID", "Local/Not Local", "Address"], ...
    private val data_list: MutableMap<String, List<Any>> = mutableMapOf()

    init {
        if (shouldFill)
            setFillerData()
    }

    private fun setFillerData() {
        addItem("Amante", "amante", true, "2850 Baseline Rd")
        addItem("Starbucks", "starbucks_image", false, "3033 Arapahoe Ave")
        addItem("No Coffee????", "weirdFaceImage", false, "")
    }

    fun addItem(shopName: String, imgName: String, isLocal: Boolean, address: String) {
        data_list[shopName] = listOf(shopName, imgName, isLocal, address)
    }

    fun getShop(name: String): List<Any>? {
        return data_list[name]
    }
}