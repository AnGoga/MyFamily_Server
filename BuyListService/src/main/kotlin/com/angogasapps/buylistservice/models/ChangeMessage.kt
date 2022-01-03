package com.angogasapps.buylistservice.models

import com.angogasapps.buylistservice.enums.EBuyListEvents
import com.angogasapps.buylistservice.entities.BuyList

class ChangeMessage(val event: EBuyListEvents, val buyLists: MutableList<BuyList>)