package data

/**프로젝트 전역에서 관리되는 장바구니 싱글턴 객체*/
object CartItems {
    private val mutableProducts = mutableMapOf<Product, Int>()
    val products : Map<Product,Int> = mutableProducts

    fun addProduct(product: Product){
        mutableProducts[product]?.let{
            mutableProducts[product] = it+1
        }?:kotlin.run{
            mutableProducts[product] = 1
        }
    }

}