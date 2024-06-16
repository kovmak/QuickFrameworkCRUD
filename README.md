# QuickFrameworkCRUD

## Table of Contents

- [Overview](#overview)
- [Features](#features)
- [Database Schema](#database-schema)
- [Setup](#setup)
- [Usage](#usage)
- [Testing](#testing)
- [Contributing](#contributing)
- [License](#license)

## Overview

QuickFrameworkCRUD is a simple CRUD (Create, Read, Update, Delete) application developed using Spring Boot framework. It provides basic functionalities to interact with an underlying database, allowing users to perform CRUD operations on entities such as animals, employees, enclosures, and visitors.

## Features

- Create, read, update, and delete operations for animal entities.
- Create, read, update, and delete operations for employee entities.
- Create, read, update, and delete operations for enclosure entities.
- Create, read, update, and delete operations for visitor entities.

## Database Schema

The database schema includes tables for animals, employees, enclosures, and visitors. Each table contains attributes relevant to its respective entity, such as ID, name, species for animals, name, position, salary for employees, and so on.

## Setup

1. Clone the repository: `git clone https://github.com/Sangariusss/QuickFrameworkCRUD.git`
2. Navigate to the project directory: `cd QuickFrameworkCRUD`
3. Configure the database connection properties in `application.properties`.
4. Build the project: `mvn clean install`

## Usage

1. Run the application: `java -jar target/QuickFrameworkCRUD.jar`
2. Access the endpoints using a REST client or browser.
3. Perform CRUD operations on the specified entities using the provided endpoints.

## Testing

Unit tests and integration tests are available to ensure the correctness and functionality of the application. Run the tests using Maven:

```
mvn test
```

## Contributing

Contributions to QuickFrameworkCRUD are welcome. If you'd like to contribute, please follow these steps:

1. Fork the repository.
2. Create a new branch for your feature or bug fix: `git checkout -b feature/new-feature`.
3. Make changes and commit them: `git commit -m "Add new feature"`.
4. Push changes to your fork: `git push origin feature/new-feature`.
5. Open a pull request.

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.
