# Artemis-Financial
Artemis Financial Project 
Artemis Financial App Hardening Project 

In this project, I took an existing Spring Boot application and refactored it to align with best practices for secure software development. I created secure cryptographic endpoint functionality, added encrypted HTTPS support, checked application dependencies for vulnerabilities, and preserved the applications ability to run as originally intended. The refactor emulates real-world techniques and applications of backend hardening within enterprise applications and financial institutions.

The Spring Boot app was written in Java and uses Maven for dependency management. RESTful API conventions were used throughout. I created a SHA-256 cryptographic hash endpoint which utilizes MessageDigest API in Java. The /hash endpoint takes user input and returns a 256-bit hex checksum to the user. This ensures deterministic output from the backend without storing the plaintext user input. SHA-256 is one of the many cryptographic hash standards issued by NIST and is widely used across industries.

HTTPS support was enabled via generation of a PKCS12 keystore through Java’s keytool utility and configuration of the Spring Boot application to run on port 8443 using SSL/TLS encryption. I validated encrypted browser communication through the installed SSL certificate and confirmed that the application loaded and ran as intended.

OWASP Dependency-Check was integrated into the application to scan project dependencies for known CVEs. The Dependency-Check identified multiple vulnerabilities in an older version of Spring Boot as well as application frameworks that Spring Boot was dependent on, including Tomcat and Jackson. I analyzed the output and noted potential for future mitigation.

Finally, I used Maven to rebuild the application once the refactoring and configuration changes had been made. After launching the app, I validated that the application ran, calculated the correct SHA-256 hashes, and enforced HTTPS traffic.

The source code for this project demonstrates my capability to architect and refactor backend applications/services written in Java. The code can securely implement API endpoints, correctly configure HTTPS in a Spring Boot environment, responsibly maintain 3rd party dependencies, utilize automated security tools to identify weaknesses, and validate applications for correctness after changes have been made.
