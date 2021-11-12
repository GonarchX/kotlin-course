## Задание 5.
Реализовать модель сервиса “Библиотека”.

В библиотеки есть книги, у каждой книги есть название, список авторов, жанр и год издания.
У библиотеки есть пользователи, у каждого из них есть имя и фамилия.

У каждой книги в библиотеки возможен один из статусов: 
* доступна, 
* используется юзером %user_name%, 
* ожидается поступление, 
* на рестоврации 

Реализовать сервис с возможностями:
* Регистрировать новых пользователей и удалить существующих.
* Добавлять новые книги
* Просматривать список всех книг
* Просматривать список всех доступных книг
* Просматривать текущий статус всех книг
* Осуществлять поиск книг по автору, названию, жанру году издания
* Выдавать книгу пользователю
* Возвращать книгу в библиотеку
* Отправлять книгу на реставрацию
* Добавлять информацию о том, что какая-то книга скоро будет доступна в библиотеке.

Ограничения: 
* Для простоты считаем, что каждая книга существует в единственном экземпляре
* Нельзя выдавать одному пользователю больше трех книг на руки
* Все операции должны проверять возможность своего выполнения и проверять целостность данных  (например, нельзя выдавать книгу незарегистрированному пользователю или выдать книгу, которой нет в наличии)


Технические ограничения:
* Все классы с данными (Author, Book, User, Status) должны быть неизменяемые

Опционально, чтобы получить 5 баллов (+1), необходимо выполнить хотя одно из следующих дополнений:
* Реализовать все функции findBooks в виде одной функции с параметрами по умолчанию
* Добавить unit-тесты
* Добавить логирование операций сервиса

Подсказка:

```kotlin 
class Book /* implementation */
class Author /* implementation */
class User /* implementation */

enum class Genre {
   /*implementation*/
}

sealed class Status {
   object Available : Status()
   data class UsedBy(val user: User) : Status()
   object ComingSoon : Status()
   object Restoration : Status()
}

interface LibraryService {
   fun findBooks(substring: String): List<Book>
   fun findBooks(author: Author): List<Book>
   fun findBooks(year: Year): List<Book>
   fun findBooks(genre: Genre)

   fun getAllBooks(): List<Book>
   fun getAllAvailableBooks(): List<Book>

   fun getBookStatus(book: Book): Status
   fun getAllBookStatuses(): Map<Book, Status>

   fun setBookStatus(book: Book, status: Status)

   fun addBook(book: Book, status: Status = Status.Available)

   fun registerUser(/* parameters */)
   fun unregisterUser(user: User)

   fun takeBook(user: User, book: Book)
   fun returnBook(book: Book)
}
```
