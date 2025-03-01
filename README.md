# Task-farmCollector

Farm Collector is a Java-based backend service that allows users to manage farm records, track planted crops, record harvested amounts, and generate seasonal reports.

## Tech Stack
- **Java 17**
- **Spring Boot** (Backend Framework)
- **Maven** (Build Tool)
- **MySQL** (Database)
- **JUnit & Mockito** (Unit Testing)
- **Spring Data JPA** (ORM for Database Interaction)
- **JSON** (Request/Response Format)

---

## Getting Started
### Prerequisites
- **Java 17** installed
- **Maven** installed
- **MySQL** database running

### Setup Instructions
1. **Clone the Repository:**
   ```sh
   git clone https://github.com/your-repo/farm_collector.git
   cd farm_collector
   ```
2. **Configure MySQL Database:**
   - Create a database named `farm_collector`.
   - Update `application.properties` or `application.yml` with your MySQL credentials:
   
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/farm_collector
   spring.datasource.username=root
   spring.datasource.password=your_password
   spring.jpa.hibernate.ddl-auto=update
   spring.jpa.show-sql=true
   ```
3. **Build and Run the Application:**
   ```sh
   mvn clean install
   mvn spring-boot:run
   ```

---

## API Endpoints

### 1️⃣ Create a Farm
- **Endpoint:** `POST /api/farms`
- **Request Body (JSON):**
  ```json
  {
    "name": "ThompsonFarm",
    "location": "Texas"
  }
  ```
- **Response:**
  ```json
  {
    "id": 1,
    "name": "ThompsonFarm",
    "location": "Texas"
  }
  ```

### 2️⃣ Save Planted Data
- **Endpoint:** `POST /api/planted`
- **Request Body:**
  ```json
  {
    "farmId": 1,
    "cropType": "Corn",
    "season": "Summer 2024",
    "plantingArea": 20,
    "expectedAmount": 200.0
  }
  ```

### 3️⃣ Save Harvested Data
- **Endpoint:** `POST /api/harvested`
- **Request Body:**
  ```json
  {
    "farmId": 1,
    "cropType": "Corn",
    "season": "Summer 2024",
    "actualAmount": 180.0
  }
  ```

### 4️⃣ Get Seasonal Reports
- **Endpoint:** `GET /api/reports/{season}`
- **Example Response:**
  ```plaintext
  Season Report for: Summer 2024
  =========================================================
  Farm Name: ThompsonFarm
  Crop Type: Corn
  Expected Amount: 200.0 tons
  Actual Harvested: 180.0 tons
  =========================================================
  Farm Name: RevTFarm
  Crop Type: Grain
  Expected Amount: 150.0 tons
  Actual Harvested: 120.0 tons
  =========================================================
  Farm Name: MercyCrop
  Crop Type: Tuber
  Expected Amount: 969.0 tons
  Actual Harvested: 890.0 tons
  ```

---

## Running Tests
- **Run unit tests:**
  ```sh
  mvn test
  ```
- **Testing Tools Used:**
  - JUnit 5
  - Mockito for mocking dependencies

---

## License
This project is licensed under the MIT License.

---

## Author
Developed by **Samuel Olawuyi**.

