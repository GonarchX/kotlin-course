data class Book(val name: String, val author: Author, val year: Int, val genre: Genre)

data class Author(val firstName: String, val lastName: String)

data class User (val firstName: String, val lastName: String)

enum class Genre {
    Action,
    Adventure,
    Classics,
    Detective,
    Fantasy,
    Horror,
}

sealed class Status {
    object Available : Status()
    data class UsedBy(val user: User) : Status()
    object ComingSoon : Status()
    object Restoration : Status()
}