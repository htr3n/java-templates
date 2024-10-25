# Hexagonal Architecture

The project is a Java EE Web application (`WAR`). It is designed and structured based on
the [hexagonal architecture](https://en.wikipedia.org/wiki/Hexagonal_architecture_(software)). That is, the essential
domain and business logic form the very core while the interaction with the clients and other systems is defined via
ports and implemented as adapters. There are two types of ports

* `api`  (*Application Programming Interface*) loosely indicates the interfaces to SAGO's clients (e.g. SAGO Web UI)
* `spi` (*System Programming Interface*) loosely indicates the features or functionality that are provided by other
  systems or internally implemented (e.g. database persistence and query)

There are **adapters** that implement the corresponding **ports**.

* `aws` are adapters that interact with AWS services, for instance, invoking AWS Lambda
* `config` are adapters for manipulating application configurations
* `dpc` are adapters for DPC integration
* `pdf` are adapters for PDF rendering
* `persistence` are adapters for working with the persistence layer, e.g. databases, files.
* `rest` are REST endpoints, i.e. adapters providing access to SAGO functionality.
