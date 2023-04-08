# hexagonal-arch
The application is a sample implementation of Hexagonal architecture.
We have built a movie ticket booking system.

The APIs are:
1. Create a movie.
2. Fetch all movies.
3. Create a booking.
4. Fetch details of a booking.
5. Fetch all bookings of a user.

Dependencies are:
1. JDK 11 or later.
2. MongoDB

Steps to run locally:
1. Run mongo locally, assuming docker desktop is installed.
**'docker run -d --name local-mongo -p 27017:27017 mongo'**
2. Clone the repo, import into Intellij and run the app

Steps to use:
Once the app is running, use the postman collection [Hexagonal-arch.postman_collectionpr.json](https://github.com/dib2007/hexagonal-arch/blob/main/Hexagonal-arch.postman_collectionpr.json) to play with it. Have fun!!
