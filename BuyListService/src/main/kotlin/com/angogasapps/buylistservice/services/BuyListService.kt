package com.angogasapps.buylistservice.services

import com.angogasapps.buylistservice.enums.EBuyListEvents
import com.angogasapps.buylistservice.entities.BuyList
import com.angogasapps.buylistservice.entities.BuyListIdsBinding
import com.angogasapps.buylistservice.entities.Product
import com.angogasapps.buylistservice.repositories.BuyListBindingRepository
import com.angogasapps.buylistservice.repositories.BuyListRepository
import com.angogasapps.buylistservice.repositories.ProductRepository
import org.hibernate.Hibernate
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Propagation
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class BuyListService {
    @Autowired
    private lateinit var buyListRepository: BuyListRepository
    @Autowired
    private lateinit var productRepository: ProductRepository
    @Autowired
    private lateinit var buyListBindingRepository: BuyListBindingRepository
    @Autowired
    private lateinit var notifier: BuyListChangesNotifier

    fun createBuyList(familyId: String, buyList: BuyList) {
        buyList.products.forEach { it.buyListId = buyList.id }
        buyListRepository.save(buyList)
        buyListBindingRepository.save(BuyListIdsBinding(buyListId = buyList.id, familyId = familyId))

        notifier.notifyChange(familyId, EBuyListEvents.buyListAdded, buyList)
    }

    fun deleteBuyList(familyId: String, buyListId: String) {
        buyListRepository.deleteById(buyListId)
        productRepository.deleteAllByBuyListId(buyListId)
        buyListBindingRepository.deleteById(buyListId)


        notifier.notifyChange(familyId, EBuyListEvents.buyListRemoved, BuyList(id = buyListId))
    }

    fun updateBuyListName(familyId: String, buyListId: String, newName: String) {
        buyListRepository.updateBuyListName(id = buyListId, name = newName)
        notifier.notifyChange(familyId, EBuyListEvents.buyListChanged, BuyList(id = buyListId, title = newName))
    }

    fun createProduct(familyId: String, buyListId: String, productId: String, product: Product) {
        product.buyListId = buyListId
        productRepository.save(product)

        notifier.notifyChange(
            familyId,
            EBuyListEvents.productAdded,
            BuyList(id = buyListId, products = mutableListOf(product))
        )
    }

    fun updateProduct(familyId: String, buyListId: String, productId: String, product: Product) {
        productRepository.save(product)

        notifier.notifyChange(
            familyId,
            EBuyListEvents.productChanged,
            BuyList(id = buyListId, products = mutableListOf(product))
        )
    }

    fun deleteProduct(familyId: String, buyListId: String, productId: String) {
        productRepository.deleteById(productId)

        notifier.notifyChange(
            familyId,
            EBuyListEvents.productRemoved,
            BuyList(id = buyListId, products = mutableListOf(Product(id = productId)))
        )
    }

    @Transactional(propagation = Propagation.REQUIRED, readOnly = true, noRollbackFor = [Exception::class])
    fun getAllBuyLists(familyId: String): MutableList<BuyList> {
        val idsList = buyListBindingRepository.findAllByFamilyId(familyId)
        val list = buyListRepository.findAllById(idsList).toMutableList()
        list.forEach {
            Hibernate.initialize(it.products)
            it.products.forEach { 
                Hibernate.initialize(it.imageUrls)
            }
        }

        return list
    }
}