import java.lang.Exception

fun main() {
    val library = LibraryServiceImpl()

    val books: MutableMap<Book, Status> = mutableMapOf<Book, Status>(
        Book(
            "BookName1",
            mutableListOf(Author("Author Name1", "Author LastName1")),
            2010,
            Genre.Action
        ) to Status.Available,
        Book(
            "BookName2",
            mutableListOf(Author("Author Name2", "Author LastName2")),
            2012,
            Genre.Fantasy
        ) to Status.Restoration,
        Book(
            "BookName3",
            mutableListOf(Author("Author Name3", "Author LastName3")),
            2015,
            Genre.Detective
        ) to Status.Available,
        Book(
            "BookName4",
            mutableListOf(Author("Author Name3", "Author LastName3")),
            2007,
            Genre.Action
        ) to Status.Available,
        Book(
            "BookName5",
            mutableListOf(Author("Author Name3", "Author LastName3")),
            20022,
            Genre.Action
        ) to Status.ComingSoon,
    )

    books.forEach { bookInfo -> library.addBook(bookInfo.key, bookInfo.value) }

    val users: MutableList<User> = mutableListOf<User>(
        User("Name1", "LastName1"),
        User("Name2", "LastName2"),
        User("Name3", "LastName3"),
        User("Name4", "LastName4"),
    )
    users.forEach { user -> library.registerUser(user) }

//    <this line generate exception because books[2] is copy of books[0]>
//    library.addBook(Book("BookName1", Author("Author Name1", "Author LastName1"), 2010, Genre.Action, Status.Available))

    println("All books:")
    library.getAllBooks().forEach { println(it) }

    println("\nAfter taking books with '3' in name")
    library.takeBook(users[0], library.findBooks("3")[0])
    library.getAllBooks().forEach { println(it) }

    println("\nStatuses of each book")
    library.getAllBookStatuses().forEach { println("${it.key.name} - ${it.value}") }

    println("\nAll available books")
    library.getAllAvailableBooks().forEach { println(it) }

    library.returnBook(library.findBooks("3")[0])

    println("\nUnregister user №3")
    library.unregisterUser(users[2])

    try {
        library.takeBook(users[2], library.getAllBooks()[1])
    } catch (e: Exception) {
        println("\n${users[2]}")
        println("trying take book from library!")
    }

    println("\nAll books with multiple conditions:")
    library.findBooks("Book", null, null, Genre.Action, Status.Available).forEach { println(it) }

    library.setBookStatus(library.findBooks(null, null, null, null, Status.Restoration).first(), Status.Available)

    try {
        library.takeBook(users[0], library.getAllAvailableBooks()[0])
        library.takeBook(users[0], library.getAllAvailableBooks()[0])
        library.takeBook(users[0], library.getAllAvailableBooks()[0])
        library.takeBook(users[0], library.getAllAvailableBooks()[0])
    } catch (e: Exception) {
        println(e.message)
    }
}