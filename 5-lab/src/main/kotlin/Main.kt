import java.lang.Exception
import java.time.Year

fun main() {
    val library = LibraryServiceImpl()

    val books: MutableList<Book> = mutableListOf<Book>(
        Book("BookName1", Author("Author Name1", "Author LastName1"), 2010, Genre.Action, Status.Available),
        Book("BookName2", Author("Author Name2", "Author LastName2"), 2012, Genre.Fantasy, Status.Restoration),
        Book("BookName3", Author("Author Name3", "Author LastName3"), 2015, Genre.Detective, Status.Available),
        Book("BookName4", Author("Author Name3", "Author LastName3"), 2007, Genre.Action, Status.Available),
        Book("BookName5", Author("Author Name3", "Author LastName3"), 20022, Genre.Action, Status.ComingSoon),
        )

    books.forEach{ book -> library.addBook(book, book.status)}

    val users: MutableList<User> = mutableListOf<User>(
        User("Name1", "LastName1"),
        User("Name2", "LastName2"),
        User("Name3", "LastName3"),
        User("Name4", "LastName4"),
    )
    users.forEach{ user -> library.registerUser(user)}

//    <this line generate exception because books[2] is copy of books[0]>
//    library.addBook(Book("BookName1", Author("Author Name1", "Author LastName1"), 2010, Genre.Action, Status.Available))

    println("All books:")
    library.getAllBooks().forEach { it -> println(it) }

    println("\nAfter taking books with '3' in name")
    library.takeBook(users[0], library.findBooks("3")[0])
    library.getAllBooks().forEach { it -> println(it) }

    println("\nStatuses of each book")
    library.getAllBookStatuses().forEach { it -> println("${it.key.name} - ${it.value}") }

    println("\nAll available books")
    library.getAllAvailableBooks().forEach { it -> println(it) }

    library.returnBook(library.findBooks("3")[0])

    println("\nUnregister user №3")
    library.unregisterUser(users[2])

    try {
        library.takeBook(users[2], books[1])
    }
    catch (e: Exception){
        println("\n${users[2]}")
        println("trying take book from library!")
    }

    println("\nAll books with multiple conditions:")
    library.findBooks("Book", null, null, Genre.Action, Status.Available).forEach { it -> println(it) }
}