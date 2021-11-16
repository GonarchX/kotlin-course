import java.lang.RuntimeException

class LibraryServiceImpl : LibraryService {
    private val books: MutableSet<Book> = mutableSetOf()
    private val users: MutableSet<User> = mutableSetOf()
    private val booksStatus: MutableMap<Book, Status> = mutableMapOf()
    private val booksByUser: MutableMap<User, MutableSet<Book>> = mutableMapOf()
    private val countOfBooksByUser: Int = 3

    override fun findBooks(substring: String): List<Book> = books.filter { book -> book.name.contains(substring) }

    override fun findBooks(author: Author): List<Book> = books.filter { book -> book.author.contains(author) }

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
            { book -> author == null || book.author.contains(author) },
            { book -> year == null || book.year == year },
            { book -> genre == null || book.genre == genre },
            { book -> status == null || booksStatus[book] == status },
        )
        return books.filter { x -> conditions.all { condition -> condition(x) } }
    }

    override fun getAllBooks(): List<Book> = books.toList()

    override fun getAllAvailableBooks(): List<Book> = books.filter { book -> booksStatus[book] == Status.Available }

    override fun getBookStatus(book: Book): Status {
        books.find { it == book }
            ?: throw RuntimeException("Library doesn't contain this book!")

        if (booksStatus[book] == null)
            throw RuntimeException("Unknown book status!")

        return booksStatus[book]!!
    }

    override fun getAllBookStatuses(): Map<Book, Status> {
        return booksStatus
    }

    override fun setBookStatus(book: Book, status: Status) {
        books.find { it == book }
            ?: throw RuntimeException("Library doesn't contain this book!")

        booksStatus[book] = status
    }

    override fun addBook(book: Book, status: Status) {
        if (books.find { it == book } != null) {
            throw RuntimeException("This book is already in this library!")
        }

        booksStatus[book] = status
        books.add(book)
    }

    private fun isRegisteredUser(user: User): Boolean {
        return users.find { it == user } != null
    }

    override fun registerUser(user: User) {
        if (isRegisteredUser(user))
            throw RuntimeException("This user is already a user of the library!")

        booksByUser[user] = mutableSetOf()
        users.add(user)
    }

    override fun unregisterUser(user: User) {
        if (!isRegisteredUser(user))
            throw RuntimeException("This user is not a user of the library!")

        users.remove(user)
    }

    override fun takeBook(user: User, book: Book) {
        if (!isRegisteredUser(user))
            throw RuntimeException("This user is not a user of the library!")

        if (booksByUser[user]!!.count() < countOfBooksByUser) {
            booksByUser[user]!!.add(book)
        }
        else
            throw RuntimeException("Library maximum books by user is ${countOfBooksByUser}. This user now have ${booksByUser[user]!!.count()}")

        booksStatus[book] = Status.UsedBy(user)
    }

    override fun returnBook(book: Book) {
        books.find { it == book } ?: throw RuntimeException("Library doesn't contained this book ever!")

        booksByUser.filter { it.value.contains(book) }.map { it.value }.first().remove(book)
        booksStatus[book] = Status.Available
    }
}