# E-Books
Mobile App to Read Books

I developed a mobile application that simulates a book review platform. The app is built using Kotlin and Jetpack Compose and features email-based authentication powered by Firebase Auth.

Upon launching the application, users are presented with a login screen. New users have the option to register, which directs them to a sign-up page. Once authenticated, users are taken to the Home screen, which displays two horizontally scrollable lists (LazyRow): one featuring recommended books and another showcasing best-selling titles. Selecting a book opens a detailed view containing information such as the book’s literary genre, number of pages, rating, and a brief description.

The application also includes a dedicated search page, accessible via a bottom navigation bar, where users can search for books by name using a search bar or filter results based on a selected literary genre. Additionally, there is a Saved Books page for storing books that users wish to read later.

The Profile page displays the user's name and email address, along with a sign-out button that redirects to the login screen. Notably, the app maintains the user's session across restarts if they were logged in prior to closing the application.

A persistent bottom navigation bar, which remains visible on all four primary pages (Home, Books, Saved Books, and Profile), enables seamless navigation and updates dynamically as users switch between sections.

This project is implemented using the MVVM architecture, ensuring a clean separation of concerns and enhanced scalability.
