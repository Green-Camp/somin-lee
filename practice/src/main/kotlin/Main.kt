fun main(args: Array<String>) {
    println("반갑습니다! 사용자님의 이름을 입력해주세요 : ")

    val name = readLine()
    println("""
        안녕하세요 $name 님,
        원하시는 카테고리를 입력해주세요.
        =======================
    """.trimIndent())
}