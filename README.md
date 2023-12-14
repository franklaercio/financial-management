# SecureWallet - Your Digital Gateway to Seamless Transactions

## Description

SecureWallet, your all-in-one digital wallet application designed to revolutionize the way you manage your finances and
conduct transactions. Seamlessly blending cutting-edge technology with user-friendly features, SecureWallet ensures a
secure and convenient experience for all your digital financial needs.

## Technologies
* Java 21
* Maven 3.8.1
* Spring Boot 3.1.5
* MySQL 8.0.26
* Docker 20.10.8
* Docker Compose 1.29.2
* JUnit 5.7.2
* OpenApi 2.2.0
* MapStruct 1.4.2
* Flyway 10.0.1

## Installation
1. Clone the repository
2. Execute `docker compose up -d` in the terminal
3. Execute `mvn clean install` in the terminal
4. Create a schema named `wallet` in your MySQL database `wallet`
5. Open the project in your IDE
6. Run the program
7. Enjoy!

## Tasks

- [ ] Create entities
  - [X] User
  - [X] Person
  - [ ] Card
  - [ ] Transaction
- [X] Manager security authentication mode and access
  - [X] Generate JSON Web Token
  - [X] Control resources by role
- [X] Create endpoint to create person details 
- [ ] Create endpoint to create card
- [ ] Create endpoint to manager card
- [ ] Create endpoint to make transactions

## Usage - doing

## API Documentation
1. When the program starts, the user will be access the documentation.
2. The user can view the API documentation by entering the following URL in a browser:
3. http://localhost:8080/swagger-ui/index.html

## Endpoints - doing

## Contributing
Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

## License
This project is licensed under the GNU License - see the [LICENSE.md](LICENSE.md) file for details.
