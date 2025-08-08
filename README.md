# Doctor Appointment API

Plataforma para búsqueda y recomendación de doctores, con información detallada y base para integrar un sistema de citas médicas en el futuro.  
Incluye **API REST en Spring Boot** y aplicación **Android en Java**.

## 🚀 Tecnologías usadas
- Java 17
- Spring Boot
- SQL Server
- DTOs y AutoMapper
- REST API

## 📂 Estructura del repositorio
api/
├── pom.xml
├── src/
└── ...

## ⚙️ Configuración del entorno
1. Clonar el repositorio:
   ```bash
   git clone https://github.com/Soopph/Doctor-Appointment

2. Ir a la carpeta de la API:
   cd api

3. Configurar credenciales en src/main/resources/application.properties:
   spring.datasource.url=jdbc:sqlserver://localhost:1433;databaseName=DB_DoctorAppointment
   spring.datasource.username=TU_USUARIO
   spring.datasource.password=TU_PASSWORD


2. Ejecutar
   mvn spring-boot:run
