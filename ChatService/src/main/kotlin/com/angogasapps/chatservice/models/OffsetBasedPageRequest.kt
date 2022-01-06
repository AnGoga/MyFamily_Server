//package com.angogasapps.chatservice.models
//
//import org.apache.commons.lang.builder.EqualsBuilder
//import org.apache.commons.lang.builder.HashCodeBuilder
//import java.awt.print.Pageable
//import java.io.Serializable
//import org.springframework.data.domain.Sort;
//
//
//
//class OffsetBasedPageRequest(offset: Int, limit: Int, sort: Sort) : Pageable, Serializable {
//    var pageSize = 0
//    val offset = 0
//    private val sort: Sort
//
//    /**
//     * Creates a new [OffsetBasedPageRequest] with sort parameters applied.
//     *
//     * @param offset     zero-based offset.
//     * @param limit      the size of the elements to be returned.
//     * @param direction  the direction of the [Sort] to be specified, can be null.
//     * @param properties the properties to sort by, must not be null or empty.
//     */
//    constructor(offset: Int, limit: Int, direction: Sort.Direction, vararg properties: String) : this(
//        offset,
//        limit,
//        Sort.by(direction, properties)
//
//    ) {
//        require(offset >= 0) { "Offset index must not be less than zero!" }
//        require(limit >= 1) { "Limit must not be less than one!" }
//        pageSize = limit
//        this.offset = offset
//        this.sort = sort
//
//    }
//
//    /**
//     * Creates a new [OffsetBasedPageRequest] with sort parameters applied.
//     *
//     * @param offset zero-based offset.
//     * @param limit  the size of the elements to be returned.
//     */
//    constructor(offset: Int, limit: Int) : this(offset, limit, Sort.unsorted()) {}
//
//    val pageNumber: Int
//        get() = offset / pageSize
//
//    fun getSort(): Sort {
//        return sort
//    }
//
//    operator fun next(): Pageable {
//        return OffsetBasedPageRequest(offset + pageSize, pageSize, getSort())
//    }
//
//    fun previous(): OffsetBasedPageRequest {
//        return if (hasPrevious()) OffsetBasedPageRequest(offset - pageSize, pageSize, getSort()) else this
//    }
//
//    fun previousOrFirst(): Pageable {
//        return if (hasPrevious()) previous() else first()
//    }
//
//    fun first(): Pageable {
//        return OffsetBasedPageRequest(0, pageSize, getSort())
//    }
//
//    fun hasPrevious(): Boolean {
//        return offset > pageSize
//    }
//
//
//    companion object {
//        private const val serialVersionUID = -25822477129613575L
//    }
//
//}