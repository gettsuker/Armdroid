package com.example.armdroid.utils

object Constants {

    const val NAV_MENU_HOME = "Home"
    const val NAV_MENU_REDEEM_CODE = "Redeem Code"
    const val NAV_MENU_QUICK_LINKS = "Quick Links"
    const val NAV_MENU_EXIT_APP = "Exit App"
    const val QUICK_LINK_DETAIL = "Quick Link Detail"
    const val POPUP_FRAGMENT = "Popup Fragment"
    const val CONTENT_LIST_KEY = "contentList"
    const val VIRTUAL_TICKET_ENDPOINT_KEY = "virtualTicketValidationEndpoint"
    const val COMPANY_NAME = "YBVR"
    const val TIME_NEEDED_TO_CHECK_INTERNET_CONNECTION = 10000
    const val MAX_SCREEN_WIDTH_VALUE_TO_BE_DETECTED_AS_A_MOBILE_PHONE = 600
    const val MAX_SCREEN_WIDTH_VALUE_TO_BE_DETECTED_AS_A_MOBILE_PHONE_IN_LANDSCAPE = 940
    const val MAX_SCREEN_HEIGHT_VALUE_TO_BE_DETECTED_AS_A_MOBILE_PHONE_IN_LANDSCAPE = 600
    const val SLIDE_ANIMATION_DURATION = 300

    val navMenuHome: String
        get() = NAV_MENU_HOME

    val navMenuRedeemCode: String
        get() = NAV_MENU_REDEEM_CODE

    val navMenuQuickLinks: String
        get() = NAV_MENU_QUICK_LINKS

    val navMenuExitApp: String
        get() = NAV_MENU_EXIT_APP

    val quickLinkDetail: String
        get() = QUICK_LINK_DETAIL

    val popupFragment: String
        get() = POPUP_FRAGMENT

    val contentListKey: String
        get() = CONTENT_LIST_KEY

    val virtualTicketEndpointURL: String
        get() = VIRTUAL_TICKET_ENDPOINT_KEY

    val timeNeededToCheckInternetConnection: Int
        get() = TIME_NEEDED_TO_CHECK_INTERNET_CONNECTION
}