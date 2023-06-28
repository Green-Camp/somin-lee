package screen

import data.CartItems
import data.Product

/**카테고리 및 상품 관리*/
class ShoppingProductList {
    private val products = arrayOf(
        Product("패션", "패딩"),
        Product("패션", "겨울 바지"),
        Product("전자기기", "핸드폰"),
        Product("전자기기", "패딩"),
        Product("전자기기", "패딩"),
        Product("반려동물용품", "건식사료"),
        Product("반려동물용품", "습식사료"),
        Product("반려동물용품", "간식"),
        Product("반려동물용품", "치약")
    )
    private val categories: Map<String, List<Product>> = products.groupBy { product ->
        product.categoryLabel
    }

    /**사용자가 요청한 카테고리의 상품 목록을 출력*/
    fun showProductLists(selectedCategory: String) {
        val categoryProducts = categories[selectedCategory]
        if (!categoryProducts.isNullOrEmpty()) {
            println(
                """
                ***==================================
                선택하신 [$selectedCategory] 카테고리 상품입니다.
            """.trimIndent()
            )
            val productSize = categoryProducts.size
            for (index in 0 until productSize) {
                println("${index}. ${categoryProducts[index].name}")
            }
            showCartOption(categoryProducts)
        } else {
            showEmptyProductMessage(selectedCategory)
        }
    }

    private fun showCartOption(categoryProducts: List<Product>) {
        println(
            """
            ***==================================
            장바구니에 담을 상품 번호를 입력해주세요.
        """.trimIndent()
        )
        val selectedIndex = readLine()?.toIntOrNull()!!
        categoryProducts.getOrNull(selectedIndex)?.let { product ->
            CartItems.addProduct(product)
            println("장바구니로 이동하려면 #을, 계속 쇼핑하려면 *을 입력하세요.")
        }
    }

    private fun showEmptyProductMessage(selectedCategory: String) {

    }

}