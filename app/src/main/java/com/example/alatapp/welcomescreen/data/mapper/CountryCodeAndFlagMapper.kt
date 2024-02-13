package com.example.alatapp.welcomescreen.data.mapper

import com.example.alatapp.welcomescreen.data.local.CountryCodeAndFlagEntity
import com.example.alatapp.welcomescreen.data.remote.CountryCodeAndFlagItem
import com.example.alatapp.welcomescreen.data.remote.response.Idd


fun CountryCodeAndFlagEntity.toCountryCodeAndFlagItem()
        : CountryCodeAndFlagItem {
    return CountryCodeAndFlagItem(
        flag = flag,
        name = name,
        idd = idd,
        flags = flags
    )

}


fun CountryCodeAndFlagItem.toCountryCodeWithFlagEntity(): CountryCodeAndFlagEntity {
    return CountryCodeAndFlagEntity(
        flags = flags,
        idd = idd,
        name = name,
        flag = flag
    )
}