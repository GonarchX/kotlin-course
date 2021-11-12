import java.lang.Exception

class LibraryServiceImpl : LibraryService {
    private var books: MutableList<Book> = mutableListOf()
    private var users: MutableList<User> = mutableListOf()

    override fun findBooks(substring: String): List<Book> = books.filter { book -> book.name.contains(substring) }

    override fun findBooks(author: Author): List<Book> = books.filter { book -> book.author == author }

    override fun findBooks(year: Int): List<Book> = books.filter { book -> book.year == year }

    override fun findBooks(genre: Genre): List<Book> = books.filter { book -> book.genre == genre }

    override fun findBooks(
        substring: String?,
        author: Author?,
        year: Int?,
        genre: Genre?,
        status: Status?
    ): List<Book> {
        val conditions = listOf<(Book) -> Boolean>(
            { book -> substring == null || book.name.contains(substring) },
            { book -> author == null || book.author == author },
            { book -> year == null || book.year == year },
            { book -> genre == null || book.genre == genre },
            { book -> status == null || book.status == status },
        )
        return books.filter { x -> conditions.all { condition -> condition(x) } }
    }

    override fun getAllBooks(): List<Book> = books

    override fun getAllAvailableBooks(): List<Book> = books.filter { book -> book.status == Status.Available }

    override fun getBookStatus(book: Book): Status {
        books.find { it -> it == book }
            ?: throw Exception("Library doesn't contain this book!")

        return book.status
    }

    override fun getAllBookStatuses(): Map<Book, Status> {
        return books.associateBy({ it }, { it.status })
    }

    override fun setBookStatus(book: Book, status: Status) {
        books.find { it -> it == book }
            ?: throw Exception("Library doesn't contain this book!")

        book.status = status
    }

    override fun addBook(book: Book, status: Status) {
        if (books.find { it -> it == book } != null) {
            throw Exception("This book is already in this library!")
        }

        book.status = status
        books.add(book)
    }

    fun isRegisteredUser(user: User): Boolean {
        return users.find { it -> it == user } != null
    }

    override fun registerUser(user: User) {
        if (isRegisteredUser(user))
            throw Exception("This user is already a user of the library!")

        users.add(user)
    }

    override fun unregisterUser(user: User) {
        if (!isRegisteredUser(user))
            throw Exception("This user is not a user of the library!")

        users.remove(user)
    }

    override fun takeBook(user: User, book: Book) {
        if (!isRegisteredUser(user))
            throw Exception("This user is not a user of the library!")

        book.status = Status.UsedBy(user)
    }

    override fun returnBook(book: Book) {
        books.find { it -> it == book } ?: throw Exception("Library doesn't contained this book ever!")

        book.status = Status.Available
    }
}