# Artemis-Financial
Artemis Financial Project 
Artemis Financial Secure Project Write-up 

The purpose of this project was to refactor an insecure Spring Boot Financial application into a secure version that followed the principals of secure software engineering. Some of the tasks completed were adding a secure SHA-256 cryptographic endpoint, enabling encrypted HTTPS traffic, scanning 3rd party dependencies for CVEs, and verification that no new bugs were introduced while implementing secure features. The application represents a backend web application that would likely undergo hardening such as this before going into production in enterprise/financial settings.

The application itself was written in Java and built using Maven. I also followed RESTful API standards when building the application. A secure cryptographic endpoint using SHA-256 was implemented using the MessageDigest Java API. Our /hash endpoint takes user input, and returns the 256-bit checksum as a hexadecimal string. The endpoint does not store the plaintext version of the user input and relies on backend deterministic processing. SHA-256 is commonly used and is industry standard.

HTTPS was setup by generating a PKCS12 keystore using keytool (built into Java) and configuring the Spring Boot application to serve on port 8443 with SSL/TLS. I confirmed successful encrypted browser-server connections were taking place.

OWASP Dependency-Check was used to identify CVEs in project dependencies. The Dependency-Check identified high and medium severity CVEs in an older version of Spring Boot used by the application and its transitive dependencies (Tomcat, Jackson, etc.). I analyzed the report and took notes on potential mitigation strategies. This application shows how insecure dependencies can be and how important it is to manage dependency lifecycles.

Once all of the features were implemented I rebuilt the application using Maven and verified that the application ran correctly, produced proper SHA-256 hashes, and required HTTPS traffic.
